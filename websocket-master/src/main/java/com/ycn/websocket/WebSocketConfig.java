package com.ycn.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
/**
 * websocket配置
 * @author ycn
 *
 */
@Configuration
@EnableWebMvc
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {

	@Autowired
	private SocketHandler socketHandler;

	/**
	 * 注册handle
	 */
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		//注册处理拦截器,拦截url为socketServer的请求
	    registry.addHandler(socketHandler, "/socketServer").addInterceptors(new WebSocketInterceptor());
	    //注册SockJs的处理拦截器,拦截url为/sockjs/socketServer的请求
	    registry.addHandler(socketHandler, "/sockjs/socketServer").addInterceptors(new WebSocketInterceptor()).withSockJS();
	}
	
    /** 
     * 注册handle 
     */  
    /*@Override  
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {  
          registry.addHandler(myHandler(), "/testHandler").addInterceptors(new WebSocketInterceptor());  
          registry.addHandler(myHandler(), "/socketJs/testHandler").addInterceptors(new WebSocketInterceptor()).withSockJS();  
  
    }  
      
    @Bean  
    public WebSocketHandler myHandler(){  
        return new MyMessageHandler();  
    } */ 

}
