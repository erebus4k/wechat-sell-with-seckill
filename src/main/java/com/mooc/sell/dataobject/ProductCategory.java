package com.mooc.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;


/**类目
 *
 * 如果就是想用其他表名，则用   @Table(name = "想用的表名")*/

@Entity   //把数据库映射成对象需要  注解
@DynamicUpdate         //可以让数据库里的时间动态更新，但必须要有改动才可以，如果没有变化就算有注解调用.save也不会更新时间
@Data             /*这是lombok插件的Data注解，包含了get、set和toString等方法。
               可大大简化代码，有这个就不需要getter&setter工具了，toString（）也不需要自己写了。性能是没变化的，只是@Data自动生成了*/

public class ProductCategory {
    /** 类目id.*/
    @Id                                                    /*标注用于声明一个实体类的属性映射为数据库的主键列  注解*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)    /*标注主键的生成策略,这里是自增的，即生成时自动为上一主键+1  注解*/
    //这里只用@GeneratedValue()会报错，可能是版本不匹配
    /*JPA提供的四种标准用法为TABLE，SEQUENCE，IDENTITY，AUTO。
     a，TABLE：使用一个特定的数据库表格来保存主键。
     b，SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。
     c，IDENTITY：主键由数据库自动生成（主要是自动增长型）
     d，AUTO：主键由程序控制。 */
    private Integer categoryId;
    /**
     * 类目名字.
     */
    private String categoryName;
    /**
     * 类目编号.
     */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;            //搞个构造方法，方便
        this.categoryType = categoryType;
    }

    public ProductCategory() {
    }


    /* 原本这里需要需要alt+insert 调用 getter and setter方法，但是有了lombok的@Data就不用了
     getter&setter的意义：
     1.当属性被私有之后,外界无法直接访问,所以需要提供公共的访问方式,让外界可以间接地访问,并不是所有的属性都需要定义,被外界需要的才需要,
     * 对当前类可以控制外别访问属性的方式(我让你怎么访问就怎么访问)
     2.一般提供给get方式获得私有属性的值,通过set定义私有属性的值*/

    //最后原本需要@Override覆写toString()方法，有了@Data也不需要了



}