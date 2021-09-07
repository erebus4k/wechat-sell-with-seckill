package com.mooc.sell.utils;

import java.util.Random;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−09-01-14:31
 * @className: com.mooc.sell.utils.KeyUtil
 * @description: TODO
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
