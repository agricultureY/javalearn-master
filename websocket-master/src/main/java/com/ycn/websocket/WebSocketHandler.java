package com.ycn.websocket;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * websockethandler处理类
 * @author ycn
 *
 */
@Service
public class WebSocketHandler extends TextWebSocketHandler {
	//定义日志
	private static final Logger logger;
	//线程安全
	private static final Map<String,WebSocketSession> sessions;
    private static final Map<String,Thread> threads;
    //用户标识
    private static final String CLIENT_ID = "sessionId";
    //处理线程
    //private  Thread thread = null;
    
    static{
    	sessions = new ConcurrentHashMap<String, WebSocketSession>();
    	threads = new ConcurrentHashMap<String, Thread>();
		logger = LoggerFactory.getLogger(SocketHandler.class);
	}
    
    /*@Autowired
    private IVisualizationService visualizationService;*/

    /**
     * 建立websocket连接
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    	logger.info(session.getId()+"--成功建立socket连接");
        Object sessionType = session.getAttributes().get("user");
        if(sessionType != null && "user".equals(sessionType)){
            sessions.put(CLIENT_ID,session);
            sessions.put(session.getId(),session);
        }
        super.afterConnectionEstablished(session);
    }

    /**
     * 关闭websocket连接
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        Thread thread = threads.get(session.getId());
        if(thread != null){
            thread.interrupt();
            try {
                thread.join();
                threads.remove(session.getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sessions.remove(session.getId());
        sessions.remove(CLIENT_ID);
        thread = null;
        try {
            super.afterConnectionClosed(session, status);
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
    
	//这里是处理前端发送的消息以及返回给前端的数据
	//可以从session里面获取attributes，
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        Thread thread = threads.get(session.getId());
        if(thread == null){
        	logger.info("handleTextMessage: \n"+session.getId());
        	WebSocketSession sessi =  sessions.get(session.getId());
        	if(sessi == null){
        		sessions.put(session.getId(),session);
        	} else {
        		session = sessi;
        	}
        	final WebSocketSession localSession = session;
        	final TextMessage localMessage = message;
            String payload = message.getPayload();
            if(StringUtils.isNotBlank(payload)){
            	Thread t = new Thread(new Runnable() {
                    public void run() {
                        while(!Thread.currentThread().isInterrupted()){
                            try {
                            	localSession.sendMessage(localMessage);
                                /*try {
                                    Thread.sleep(180000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }*/
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                t.start();
                threads.put(sessi.getId(),t);
            }
        }
    }

    
	/**
	 * 给所有在线用户发送消息
	 * @param message
	 */
	public void sendMessageToUsers(TextMessage message) {
		Collection<WebSocketSession> users = sessions.values();
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
		WebSocketSession session = sessions.get(userName);
		if(null != null && session.isOpen()) {
			try {
				session.sendMessage(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
