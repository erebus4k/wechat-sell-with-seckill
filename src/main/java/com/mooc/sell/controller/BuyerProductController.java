package com.mooc.sell.controller;

import com.mooc.sell.VO.ProductInfoVO;
import com.mooc.sell.VO.ProductVO;
import com.mooc.sell.VO.ResultVO;
import com.mooc.sell.dataobject.ProductCategory;
import com.mooc.sell.dataobject.ProductInfo;
import com.mooc.sell.service.CategoryService;
import com.mooc.sell.service.ProductService;
import com.mooc.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 买家商品
 * @version 1.0
 */
@RestController   //因为返回json格式，所以这里用@RestController注解
@RequestMapping("/buyer/product")
//这里api文档是：包名（也就是sell）/buyer/prodcut,我们希望自动加sell包名，所以去配置文件application.yml加servlet.context-path: /sell
public class BuyerProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")  //这是个get请求
    @Cacheable(cacheNames = "product", key = "123")
    public ResultVO<Object> list() {     //按api字段分层分析去写这里，比如点餐，有食品分类，1类有多个食品，所以是列表
        //1.查询所有上架商品    【数据库查询】
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2.查询类目（一次性查询）   【数据库查询】
        //传统方法
            //List<Integer> categoryTypeList = new ArrayList<>();
            /*for (ProductInfo productInfo : productInfoList){
                categoryTypeList.add(productInfo.getCategoryType());
            }    */
           //精简方法（java8, lambda）
         List<Integer> categoryTypeList = productInfoList.stream()              //注意，java8的新特性stream()可以给list去重！！
                 .map(ProductInfo::getCategoryType)
                 .collect(Collectors.toList());              //所有上架的商品的类别编号的列表
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
                                                              //所有上架商品的类别对象组成的列表

        //3.数据拼装（api文档里那种json格式）
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory: productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());


            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo: productInfoList){  //productInfoList是所有上架商品列表，这里遍历所有上架的商品
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){   //如果当前商品跟第一层类别循环的类同类，
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);                              //完成第三层商品详情的列表，送给第二层的foods
                }                                                               //productInfoVOList一定不为空，因为上架商品肯定存在于上架商品的类
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);                      //完成第二层类目的列表，送给第一层的data
        }



        /*ResultVO<Object> resultVO = new ResultVO<>();  //第一层
        resultVO.setData(productVOList);
        resultVO.setCode(0);
        resultVO.setMsg("成功");             //对于每个ResultVO都要重新写四行是比较麻烦的，所以要想办法封装一下，见utils包和下边代码
        return resultVO;  */
        return ResultVOUtil.success(productVOList);

    }
}
