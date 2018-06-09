package com.ycn.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.socket.TextMessage;

import com.ycn.websocket.SocketHandler;
import com.ycn.websocket.WebSocketHandler;

/**
 * socket控制器
 * @author ycn
 *
 */
@Controller
public class SocketController{
	  
	  private static final Logger logger = LoggerFactory.getLogger(SocketController.class);
	  
	  @Autowired
	  private SocketHandler socketHandler;
	  @Autowired
	  private WebSocketHandler sc;
	  
	  @RequestMapping(value="/login")
	  public String login(HttpSession session){
	    logger.info("用户登录了建立连接啦");
	    session.setAttribute("user", "order");
	    return "home";
	  }

	  @RequestMapping(value = "/message", method = {RequestMethod.GET,RequestMethod.POST})
	  public String sendMessage(){
	    socketHandler.sendMessageToUser("order", new TextMessage("你有一条未处理订单"));
//	    sc.sendMessageToUser("liulichao", new TextMessage("这是一条测试的消息"));
	    return "message";
	  } 
	  
	  /*@RequestMapping(value="/placeOrder")
	  public String placeOrder(HttpSession session) {
		  logger.info("用户登录了建立连接啦");
		  session.setAttribute("user", "order");
		  return "home";
	  }
	  
	  @RequestMapping(value = "/sendMsg", method = {RequestMethod.GET,RequestMethod.POST})
	  public String sendMsg() {
		  sc.sendMessageToUser("order", new TextMessage("你有一条待处理订单"));
		  return "message";
	  }*/
}
