package com.demo.javacore.thread;
/**
 * 创建线程的方法：
 * 1、通过继承Thread类创建线程  重写run()方法
 * 		直接调用run()方法不会创建新的线程，而是在主线程中直接调用的run()方法,和普通的方法调用没有区别。
 *  	新的线程不影响主线程的执行
 * 2、通过实现Runnable接口创建线程  重写run()方法
 *  	实现Runnable的方式需要将实现Runnable接口的类作为参数传递给Thread，然后通过Thread类调用Start()方法来创建线程。
 *  
 * 销毁线程的方法：
 * 1、使用退出标识，使线程正常的退出，也就是当run()方法完成后线程终止。
 * 2、使用stop()方法强行关闭线程。
 * 3、使用interrupt()方法终止线程。
 * 
 * @author yy
 */
public class CreateThread {

	public static void main(String[] args) {
		System.out.println("主线程ID："+Thread.currentThread().getId());

		MyThread t1 = new MyThread("线程t1");
		t1.start();//启动线程一
		MyThread t2 = new MyThread("线程t2");
		t2.run();//直接调用run()方法

		SelfThread s1 = new SelfThread("线程s1");
		Thread ts1 = new Thread(s1);
		ts1.start();
		SelfThread s2 = new SelfThread("线程s2");
		Thread ts2 = new Thread(s2);
		ts2.run();
	}
}

class MyThread extends Thread{
	
	private String name;
	
	public MyThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("名字：" + name + "的线程ID是="
                + Thread.currentThread().getId()
                +"---- create by extends thread");
	}
	
}

class SelfThread implements Runnable{

	private String name;
	
	public SelfThread(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println("名字：" + name + "的线程ID是="
                + Thread.currentThread().getId()
                +" ---- create by implements runnable");
	}
	
}
