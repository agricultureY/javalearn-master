package com.demo.subscribe;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 消息监听-订阅者一
 * @author ycn
 */
public class TopicListener implements MessageListener {

	public void onMessage(Message message) {
		try {
			System.out.println("订阅者一收到的消息 ："+((TextMessage)message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
