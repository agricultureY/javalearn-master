package com.demo.javacore.thread.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * 每个线程启动时间不同、结束时间也不同
 * @author ycn
 */
public class SafeTest {

	public static void main(String[] args) {
		SafeTask task = new SafeTask();
		for(int i=0;i<10;i++) {
			Thread t = new Thread(task);
			t.start();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
