package com.demo.javacore.thread.basis;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 后台线程工厂类的使用
 * @author ycn
 */
public class DaemonFromFactory implements Runnable{

	@Override
	public void run() {
		try {
			while(true) {
				TimeUnit.MICROSECONDS.sleep(100);
				System.out.println(Thread.currentThread()+"  "+this);
			}
		} catch (Exception e) {
			System.out.println("sleep() interrupted");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		//使用提供的线程工厂类，创建线程池
		ExecutorService exe = Executors.newCachedThreadPool(new DaemonThreadFactory());
		for(int i=0;i<10;i++)
			exe.execute(new DaemonFromFactory());//此runnable实现类经过线程工厂创建
		//关闭线程池
		exe.shutdown();
		System.out.println("任务已全部启动");
		TimeUnit.MICROSECONDS.sleep(500);
	}
}
