package com.mooc.sell.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * 分布式锁可以简单概述为，多台机器上多个进程对一个数据进行操作的互斥。  redis可以用来做分布式锁的一个很重要的原因就是redis是单线程的。
 * （注意别怀疑，就是单线程，没有错。）
 */
@Component
@Slf4j
public class RedisLock {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * redis加锁
     * @param key   这里传的是productId
     * @param value 当前时间+超时时间长度=预期过期时间 （就是一个时间戳，一串数字而已）
     * @return
     */
    public boolean lock(String key, String value) {
        //这句话就是 setnx命令，只不过java API的写法和setnx稍微有点不同。在Redis 里,所谓 SETNX,是「SET if Not eXists」的缩写,也就是只有不存在的时候才设置,可以利用它来实现锁的效果
        /**
         * 如果客户端获得锁，SETNX返回1
         * 如果SETNX返回0，那么该键已经被其他的客户端锁定。
         */
        if (redisTemplate.opsForValue().setIfAbsent(key, value)) {
            return true;  }//这里是，可以获得锁就返回true，相当于setnx返回了1
            /**
             * 解释下以下代码（先说结论，这段代码既可以解决死锁，又可以让多个线程进来，只能有一个线程拿到锁，其他线程拿不到。因为 redisTemplate.opsForValue().getAndSet(key, value);
             * 上边的这行代码只有可能是一个线程去执行）
             * ，假如没有这一段代码 （以orderProductMockDiffUser方法为例）加锁成功之后如果后面的代码抛异常了，那解锁的操作就不会执行了
             * 没有解锁的情况下，如果下次又有请求进来 了，调用lock方法继续加锁（也就是setnx）肯定是set不进去的撒。
             * 那就直接返回false了。 那orderProductMockDiffUser就一直停在加锁的这一步，一直处于加锁失败的状态。这就称之为死锁。
             * 那怎么办呢？ 加上如下代码就有可能返回true，返回true，那上面的死锁就有可能解开了。
             * value传的是超时时间。
             */
            //假设商品id为100的锁被占用了，那么现在有两个线程都到了这一步，
            //现在redis里lockkey的value值为    currentValue=A     结果是其中一个线程拿到锁
            String currentValue = redisTemplate.opsForValue().get(key);
            //如果锁过期（何为锁过期，就是取出来当前key的value，也就是上一次锁的时间，小于当前时间，那就是过期了撒。如果大于，就是当前时间还没到，就没过期）
            if (!StringUtils.isEmpty(currentValue)
                    && Long.parseLong(currentValue) < System.currentTimeMillis()) {
                //锁过期了，线程开始竞争锁。每个线程调用getset命令。这个命令拆开来记，先get值，再set即可。
                //这个返回的oldValue就是get的值，getAndSet(key, value);这里的value值就是要set进去的值，假如两线程都调用getAndSet(lockkey, B)。
                String oldValue = redisTemplate.opsForValue().getAndSet(key, value);
                //如果第一个线程先执行完getAndSet，第二个线程拿到的oldValue就是B了，而currentValue=A。必然不相等，所以第二个线程是拿不到锁的。所以结果是只有其中一个线程拿到锁
                //这句判断就是，如果当前线程的oldValue=currentValue，说明该线程最先调用getAndSet方法，也就说明该线程拿到了锁
                if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {
                    return true;
                }
            }
            return false;
        }
        /**
         * 解锁
         * @param key
         * @param value
         */
        public void unlock (String key, String value){
            try {
                String currentValue = redisTemplate.opsForValue().get(key);
                if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                    redisTemplate.opsForValue().getOperations().delete(key);
                }
            } catch (Exception e) {
                log.error("【redis分布式锁】解锁异常 , {}", e);
            }
        }


    }
