package com.demo.javacore.thread.uncaught;
/**
 * 多线程异常处理
 * 实现异常测试类
 * @author ycn
 */
public class UncaughtTest {

	public static void main(String[] args) {
		UncaughtTask task = new UncaughtTask();
		Thread t = new Thread(task);
		t.setUncaughtExceptionHandler(new ExceptionHadler());
		t.start();
	}
}
