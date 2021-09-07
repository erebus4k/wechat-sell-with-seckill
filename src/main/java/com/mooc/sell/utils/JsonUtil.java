package com.mooc.sell.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−09-02-16:10
 * @className: com.mooc.sell.utils.JsonUtil
 * @description: TODO
 */
public class JsonUtil {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
