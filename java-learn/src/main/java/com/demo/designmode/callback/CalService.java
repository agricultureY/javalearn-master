package com.demo.designmode.callback;

/**
 * 模拟回掉模式服务端
 * @author yy
 *
 */
public class CalService {

	public void getClientMsg(CalbackApi cal,String msg) throws InterruptedException {
		System.out.println("服务器接收到客户端消息:"+msg);
		Thread.sleep(5000);//模拟服务器数据处理
		System.out.println("服务器处理完毕!!");
		cal.process("200--成功");
	}
}
