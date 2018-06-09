package com.demo.javacore.thread.threadlocal;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 私有变量会被所有线程共享
 * 不安全
 * @author ycn
 */
public class UnsafeTask implements Runnable {

	private Date startDate;
	
	@Override
	public void run() {
		startDate = new Date();
		System.out.printf("Starting Thread:%s : %s\n",Thread.currentThread().getId(),startDate);
		try {
			TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Finish Thread:%s : %s\n",Thread.currentThread().getId(),startDate);
	}

}
