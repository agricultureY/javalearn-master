package com.demo.javacore.thread.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * 每个线程有不同的启动时间,但结束时间可能相同
 * @author ycn
 */
public class UnsafeTest {

	public static void main(String[] args) throws InterruptedException {
		UnsafeTask task = new UnsafeTask();
		for(int i=0;i<10;i++) {
			Thread t = new Thread(task);
			t.start();
			TimeUnit.SECONDS.sleep(2);
		}
	}
}
