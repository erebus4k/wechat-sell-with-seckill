package com.mooc.sell.dataobject.mapper;

import com.mooc.sell.dataobject.ProductCategory;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−09-05-10:26
 * @className: com.mooc.sell.dataobject.mapper.ProductCategoryMapper
 * @description: TODO
 */

public interface ProductCategoryMapper {
    //插入

    @Insert("insert into product_category(category_name,category_type) values (#{categoryName, jdbcType=VARCHAR}, #{categoryType, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Insert("insert into product_category(category_name,category_type) values (#{categoryName, jdbcType=VARCHAR}, #{categoryType, jdbcType=INTEGER})")
    int insertByObject(ProductCategory productCategory);

    //查找

    @Select("select * from product_category where category_name = #{categoryName}")
    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_type", property = "categoryType"),
    })
    List<ProductCategory> findByCategoryName(String categoryName);

    //用字段更新
    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByCategoryType(@Param("categoryName")String categoryName, @Param("categoryType") Integer categoryType);

    //用对象更新
    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByObject(ProductCategory productCategory);

    @Delete("delete from product_category where category_type = #{categoryType}")
    int deleteByCategoryType(Integer categoryType);
}
