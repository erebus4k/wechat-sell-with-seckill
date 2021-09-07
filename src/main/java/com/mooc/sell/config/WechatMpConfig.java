package com.mooc.sell.config;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−09-02-9:39
 * @className: com.mooc.sell.config.WechatMpConfig
 * @description: TODO
 */
@Component
@Configuration
public class WechatMpConfig {

    @Autowired
    private WechatAccountConfig accountConfig;

    @Bean
    public WxMpService wxMpService() {
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
        return wxMpService;
    }

    @Bean
    public WxMpConfigStorage wxMpConfigStorage() {
        //WxMpInMemoryConfigStorage wxMpConfigStorage = new WxMpInMemoryConfigStorage();//这里官方更新用法了，注意
        WxMpDefaultConfigImpl wxMpConfigStorage = new WxMpDefaultConfigImpl();
        wxMpConfigStorage.setAppId(accountConfig.getMpAppId());           //这两个一开始是配置文件读的，后来用acountconfig
        wxMpConfigStorage.setSecret(accountConfig.getMpAppSecret());  //这两个一开始从配置文件里读
        return wxMpConfigStorage;
    }
}