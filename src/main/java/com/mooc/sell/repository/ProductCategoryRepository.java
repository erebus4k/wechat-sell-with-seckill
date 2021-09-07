package com.mooc.sell.repository;

import com.mooc.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
这是DAO层，dao层叫数据访问层，全称为data access object。基于MVC架构来说的。
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
