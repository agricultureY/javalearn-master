package com.demo.subscribe;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 消息生产者-消息发布者
 * @author ycn
 */
public class JMSPeoducer {

	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;//默认的用户名
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;//默认的密码
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;//默认的链接地址
	private static final Integer SENDNUM = 5;//发送的消息数量
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory;//连接工厂
		Connection connection = null;//连接
		Session session;//回话接受或者发送消息的线程
		Destination destination;//消息的目的地
		MessageProducer messageProducer;//消息生产者
		connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL);//实例化工厂 
		try {
			connection = connectionFactory.createConnection();//获取连接
			connection.start();//启动连接
			session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);//创建session
			destination = session.createQueue("first topic");//创建消息队列
			messageProducer = session.createProducer(destination);//创建消息生产者
			sendMessage(session, messageProducer);//发送消息
			session.commit();//提交session
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();//关闭连接
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 发送消息
	 * @param session
	 * @param messageProducer
	 * @throws Exception
	 */
	public static void sendMessage(Session session,MessageProducer messageProducer) throws Exception{
		for(int i=0;i<SENDNUM;i++) {
			TextMessage textMessage = session.createTextMessage("ActiveMQ发布的消息："+i);
			System.out.println("ActiveMQ发布的消息："+i);
			messageProducer.send(textMessage);
		}
	}
}
