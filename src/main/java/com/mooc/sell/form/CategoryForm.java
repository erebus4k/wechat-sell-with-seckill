package com.mooc.sell.form;

import lombok.Data;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−09-04-8:07
 * @className: com.mooc.sell.form.CategoryForm
 * @description: TODO
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;
}
