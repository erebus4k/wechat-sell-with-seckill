package com.mooc.sell.dataobject.DAO;

import com.mooc.sell.dataobject.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−09-05-12:52
 * @className: com.mooc.sell.dataobject.DAO.ProductCategoryDao
 * @description: TODO
 */

public class ProductCategoryDao {
    //@Autowired
    ProductCategoryMapper mapper;
    public int insertByMap(Map<String, Object> map){
        return mapper.insertByMap(map);

    }

}
