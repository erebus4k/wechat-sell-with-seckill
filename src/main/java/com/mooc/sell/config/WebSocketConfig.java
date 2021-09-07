package com.mooc.sell.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;


/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−09-04-23:38
 * @className: com.mooc.sell.config.WebSocketConfig
 * @description: TODO
 */
@Component
public class WebSocketConfig {
    //@Bean          //这里不注释测试会出错
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
