package com.demo.javacore.thread.basis;
/**
 * 线程简单使用-启动多个LiftOff线程
 * @author ycn
 */
public class MoreBasicThreads {

	public static void main(String[] args) {
		for(int i=0;i<5;i++)
			new Thread(new LiftOff()).start();
		System.out.println("Waiting for LiftOff");
	}
}
