package com.demo.javacore.thread.basis;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SingleThreadExecutor的使用-启动LiftOff线程
 * @author ycn
 */
public class SingleThreadExecutor {

	public static void main(String[] args) {
		//创建使用单个worker线程的线程池Executor
		ExecutorService exe = Executors.newSingleThreadExecutor();
		for(int i=0;i<5;i++)
			exe.execute(new LiftOff());// 由Executor决定执行给定的线程
        // 顺序关闭，执行已提交的线程，不准添加新的线程
        exe.shutdown();
	}
}
