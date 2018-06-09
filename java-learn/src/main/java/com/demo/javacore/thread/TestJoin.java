package com.demo.javacore.thread;
/**
 * join()方法的作用是等待线程对象销毁，如果子线程执行了这个方法，那么主线程就要等待子线程执行完毕之后才会销毁。
 * @author yy
 */
public class TestJoin {

	public static void main(String[] args) throws InterruptedException {
		new MyJoinThread("t1").start();
		for (int i = 0; i < 10; i++) {
			if(i == 5) {
				MyJoinThread t2 = new MyJoinThread("t2");
				t2.start();
				t2.join();
			}
			System.out.println("main当前线程："+Thread.currentThread().getName()+"---"+i);
		}
	}
}

class MyJoinThread extends Thread {
	public MyJoinThread(String name) {
		super(name);
	}
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("当前线程："+Thread.currentThread().getName()+"---"+i);
		}
	}
}
