package com.demo.javacore.thread;
/**
 * 在操作系统中线程是分优先级的，优先级高的线程CPU将会提供更多的资源，
 * 在java中我们可以通过setPriority(int newPriority)方法来更改线程的优先级。
 * 在java中分为1~10这个十个优先级，设置不在这个范围内的优先级将会抛出IllegalArgumentException异常。
 * @author yy
 */
public class TestPriorityLevel {

	public static void main(String[] args) {
		MyPriorityThread t1 = new MyPriorityThread("t1");
		MyPriorityThread t2 = new MyPriorityThread("t2");
		MyPriorityThread t3 = new MyPriorityThread("t3");
		MyPriorityThread t4 = new MyPriorityThread("t4");
		MyPriorityThread t5 = new MyPriorityThread("t5");
		t1.setPriority(8);
		t2.setPriority(3);
		t3.setPriority(10);
		t4.setPriority(6);
		t5.setPriority(5);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}

class MyPriorityThread extends Thread {
	
	public MyPriorityThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		System.out.println("当前线程："+Thread.currentThread().getName());
	}
}
