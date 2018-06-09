package com.demo.designmode.callback;
/**
 * 回掉模式  模拟客户端
 * @author yy
 *
 */

public class Client implements CalbackApi {

	private CalService service;
	public Client(CalService service) {
		this.service = service;
	}
	
	public void sendMsg(final String msg) {
		System.out.println("客户端发送消息为："+msg);
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					service.getClientMsg(Client.this, msg);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		System.out.println("客户端异步发送成功!");
	}
	
	@Override
	public void process(String status) {
		System.out.println("服务器返回消息："+status);
	}
}
