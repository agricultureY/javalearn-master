package com.demo.javacore.thread.basis;

import java.util.concurrent.TimeUnit;

/**
 * 后台线程简单使用
 * @author ycn
 */
public class SimpleDaemons implements Runnable {

	@Override
	public void run() {
		try {
			TimeUnit.MICROSECONDS.sleep(1000);
			System.out.println(Thread.currentThread()+" ---- "+this);
		} catch (Exception e) {
			System.out.println("sleep() interrupted");
		}
	}

	//main主线程不是后台线程
	public static void main(String[] args) throws InterruptedException {
		for(int i=0;i<10;i++) {
			//创建新的线程
			Thread daemon = new Thread(new SimpleDaemons());
            // 设置为后台线程
            daemon.setDaemon(true);
            daemon.start();
		}
		System.out.println("所有任务已启动");
		//如果main线程结束,那么同时杀死所有线程，多次运行,打印的后台线程数不定
		TimeUnit.MICROSECONDS.sleep(175);
	}
}
