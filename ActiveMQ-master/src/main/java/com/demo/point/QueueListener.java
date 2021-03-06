package com.demo.point;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 消息监听
 * @author ycn
 */
public class QueueListener implements MessageListener {

	public void onMessage(Message message) {
		try {
			System.out.println("收到的消息 ："+((TextMessage)message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
