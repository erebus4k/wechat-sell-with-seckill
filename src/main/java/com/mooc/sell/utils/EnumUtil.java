package com.mooc.sell.utils;

import com.mooc.sell.enums.CodeEnum;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−09-03-15:39
 * @className: com.mooc.sell.utils.EnumUtil
 * @description: TODO
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
