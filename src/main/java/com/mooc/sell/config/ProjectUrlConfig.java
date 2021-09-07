package com.mooc.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−09-04-12:01
 * @className: com.mooc.sell.config.ProjectUrl
 * @description: TODO
 */
@Data
@ConfigurationProperties(prefix = "projecturl")   //源文件会报错，prefix必须全小写，不能驼峰
@Component
public class ProjectUrlConfig {

    /**
     * 微信公众平台授权url
     */
    public String wechatMpAuthorize;

    /**
     * 微信开放平台授权url
     */
    public String wechatOpenAuthorize;

    /**
     * 点餐系统
     */
    public String sell;
}
