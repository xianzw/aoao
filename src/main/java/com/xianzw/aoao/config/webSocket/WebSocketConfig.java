package com.xianzw.aoao.config.webSocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * WebSocket
 * @author xianzw
 * @date 2020年5月27日下午8:10:34
 */
@Configuration
public class WebSocketConfig{
	
	@Bean  
    public ServerEndpointExporter serverEndpointExporter() {  
        return new ServerEndpointExporter();  
    } 
	
}
