package com.demo.point;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 消息消费者
 * @author ycn
 */
public class JMSConsumer {
	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER; // 默认的连接用户名
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD; // 默认的连接密码
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL; // 默认的连接地址
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory; // 连接工厂
		Connection connection = null; // 连接
		Session session; // 会话 接受或者发送消息的线程
		Destination destination; // 消息的目的地
		MessageConsumer messageConsumer; // 消息的消费者
		connectionFactory = new ActiveMQConnectionFactory(JMSConsumer.USERNAME, JMSConsumer.PASSWORD, JMSConsumer.BROKEURL);//实例化连接工厂
		try {
			connection = connectionFactory.createConnection();//创建连接
			connection.start();//启动连接
			session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);//创建session
			destination = session.createQueue("first queue");
			messageConsumer = session.createConsumer(destination);//创建消息消费者
			while(true) {
				TextMessage textMessage = (TextMessage) messageConsumer.receive(100000);
				if(null != textMessage) 
					System.out.println("收到消息："+textMessage.getText());
				else
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
}
