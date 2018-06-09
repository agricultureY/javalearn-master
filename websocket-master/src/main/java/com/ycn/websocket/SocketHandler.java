package com.ycn.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
/**
 * socket处理类
 * @author ycn
 *
 */
@Service
public class SocketHandler implements WebSocketHandler {
	private static final Logger logger;
	private static final List<WebSocketSession> users;
	  
	static{
		//线程安全list
		//users = (ArrayList<WebSocketSession>) Collections.synchronizedList(new ArrayList<WebSocketSession>());
		users = new ArrayList<WebSocketSession>();
		logger = LoggerFactory.getLogger(SocketHandler.class);
	}
	
	/**
	 * 建立websocket连接
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	    logger.info("成功建立socket连接");
	    users.add(session);
	    String username = session.getAttributes().get("user").toString();
	    if(username!=null){
	    	session.sendMessage(new TextMessage("我们已经成功建立soket通信了"));
	    }
	}

	/**
	 * 客户端调用websocket.send时候，会调用该方法,进行数据通信
	 */
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		String msg = message.toString();  
        String userId = this.getUserId(session);  
        System.err.println("该"+userId+"用户发送的消息是："+msg);  
        message = new TextMessage("服务端已经接收到消息，msg="+msg);  
        session.sendMessage(message);
	}

	/**
	 * 连接异常
	 */
	@Override
	public void handleTransportError(WebSocketSession session, Throwable error) throws Exception {
	    if(session.isOpen()){
	    	session.close();
	    }
	    logger.error("连接出现错误:"+error.toString());
	    users.remove(session);
	}
	
	/**
	 * 关闭websocket连接
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus arg1) throws Exception {
	    logger.debug("连接已关闭");
	    users.remove(session);
	}

	@Override
	public boolean supportsPartialMessages() {
	    return false;
	}

	/** 
     * getUserId:获取用户id 
     */
    private String  getUserId(WebSocketSession session){  
        try {  
            String userId = (String)session.getAttributes().get("user");  
            return userId;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }
    
	/**
	 * 给所有在线用户发送消息
	 * @param message
	 */
	public void sendMessageToUsers(TextMessage message) {
		for (WebSocketSession user : users) {
			try {
				if (user.isOpen()) {
					user.sendMessage(message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	 
	/**
	 * 给某个用户发送消息
	 * @param userName
	 * @param message
	 */
	public void sendMessageToUser(String userName, TextMessage message) {
		for (WebSocketSession user : users) {
			if (user.getAttributes().get("user").equals(userName)) {
				try {
					if (user.isOpen()) {
						user.sendMessage(message);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}
	
}
