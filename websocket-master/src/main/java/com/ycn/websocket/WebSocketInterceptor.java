package com.ycn.websocket;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
/**
 * websocket拦截器
 * @author ycn
 *
 */
public class WebSocketInterceptor implements HandshakeInterceptor {
	   
		  /**
		   * @desp 将HttpSession中对象放入WebSocketSession中
		   * 在beforeHandshake()方法中，我们将HttpSession中我们登录后存储的对象放到WebSocketSession中，以此实现定向发送消息
		   */
		  @Override
		  public boolean beforeHandshake(ServerHttpRequest request,
		      ServerHttpResponse response, WebSocketHandler handler,
		      Map<String, Object> map) throws Exception {
		    if(request instanceof ServletServerHttpRequest){
		      ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
		      HttpSession session = servletRequest.getServletRequest().getSession();
		      if(session!=null){
		        //区分socket连接以定向发送消息
		        map.put("user", session.getAttribute("user"));
		      }
		    }
		    return true;
		  }
		/** 
		 * 将HttpSession中对象放入WebSocketSession中
	     * 简单描述该方法的实现功能（可选）. 
	     */  
	   /* @Override  
	    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,  
	            Map<String, Object> attributes) throws Exception {  
	        if(request instanceof ServletServerHttpRequest){  
	             ServletServerHttpRequest serverHttpRequest = (ServletServerHttpRequest)request;  
	             //获取参数  
	             String userId = serverHttpRequest .getServletRequest().getParameter("userId");  
	            attributes.put(MyMessageHandler.USER_KEY, userId);  
	        }  
	          
	        return true;  
	    }*/

		@Override
		public void afterHandshake(ServerHttpRequest arg0, ServerHttpResponse arg1, WebSocketHandler arg2, Exception arg3) {
			
		}

}
