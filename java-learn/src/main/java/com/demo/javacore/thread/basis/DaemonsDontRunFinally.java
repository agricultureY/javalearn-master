package com.demo.javacore.thread.basis;

import java.util.concurrent.TimeUnit;

/**
 * 后台线程遇到Finally
 * @author ycn
 */
public class DaemonsDontRunFinally {

	public static void main(String[] args) {
		Thread t = new Thread(new ADaemon());
		t.setDaemon(true);//设为后台线程
		t.start();
	}
}

class ADaemon implements Runnable{

	@Override
	public void run() {
		try {
			System.out.println("启动ADaemon线程！");
			TimeUnit.SECONDS.sleep(1);//终止线程1秒
		} catch (Exception e) {
			System.out.println("InterruptedException");
			e.printStackTrace();
		} finally {
			// 因为main是非后台线程，main线程结束。ADaemon后台线程也就结束。因此可能没到finally就结束了。
            System.out.println("finally 运行吗？");
		}
	}
	
}
