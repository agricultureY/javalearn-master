package com.demo.javacore.thread.basis;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程优先级的使用
 * @author ycn
 */
public class SimplePriorities implements Runnable {

	private int countDown = 5;
	private volatile double d;
	private int priority;
	
	public SimplePriorities(int priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		//获取当前执行线程的引用
		return Thread.currentThread()+" : "+countDown;
	}

	@Override
	public void run() {
		//获取当前执行的线程对象的引用,并设置其优先级
		Thread.currentThread().setPriority(priority);
		while(true) {
			for (int i = 1; i < 100000; i++){
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0)
                    Thread.yield();
            }
            System.out.println(this);
            if (--countDown == 0) return;
		}
	}

	public static void main(String[] args) {
		//创建新的线程池
		ExecutorService exe = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++)
			exe.execute(new SimplePriorities(Thread.MIN_PRIORITY));//由线程池决定执行线程,并设置优先级最低
		exe.execute(new SimplePriorities(Thread.MAX_PRIORITY));//由线程池决定执行线程,并设置优先级最高
		//顺序关闭，执行以前提交的线程，不接受新的线程
		exe.shutdown();
	}
}
