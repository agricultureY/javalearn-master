package com.demo.javacore.thread.basis;
/**
 * 线程简单使用--启动LiftOff线程
 * @author ycn
 */
public class BasicThreads {

	public static void main(String[] args) {
		//创建新的线程
		Thread t = new Thread(new LiftOff(5));
		//启动线程
		t.start();
        System.out.println("Waiting for LiftOff");
	}
}
