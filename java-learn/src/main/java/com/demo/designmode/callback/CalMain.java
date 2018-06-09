package com.demo.designmode.callback;
/**
 * 回掉模式测试
 * @author yy
 *
 */
public class CalMain {

	public static void main(String[] args) {
		CalService service = new CalService();
		Client client = new Client(service);
		client.sendMsg("客户端发送的请求~~~~~~~~~~~~~");
	}
}
