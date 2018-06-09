package com.demo.javacore.thread.threadlocal;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal是解决线程安全问题一个很好的思路
 * 	ThreadLocal类中有一个Map，用于存储每一个线程的变量副本，Map中元素的键为线程对象，而值对应线程的变量副本
 * 	由于Key值不可重复，每一个“线程对象”对应线程的“变量副本”，而到达了线程安全
 * @author ycn
 */
public class SafeTask implements Runnable {
	
	/**
	 * 线程的局部变量,不会被所有线程共享
	 */
	private static ThreadLocal<Date> startDate = new ThreadLocal<Date>() {

		/**
		 * 隐式实现初始化对象
		 */
		@Override
		protected Date initialValue() {
			return new Date();
		}
	};
	
	@Override
	public void run() {
		System.out.printf("Starting Thread:%s : %s\n",Thread.currentThread().getId(),startDate.get());
		try {
			TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Finish Thread:%s : %s\n",Thread.currentThread().getId(),startDate.get());
	}

}
