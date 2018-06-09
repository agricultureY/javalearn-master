package com.demo.javacore.thread.basis;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池CachedThreadPool的简单使用-启动LiftOff线程
 * @author ycn
 */
public class CachedThreadPool {

	public static void main(String[] args) {
		//创建新的线程池
		ExecutorService exe = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++)
			exe.execute(new LiftOff());//由线程池决定执行给定的线程
		//顺序关闭，执行以前提交的线程，不接受新的线程
		exe.shutdown();
	}
}
