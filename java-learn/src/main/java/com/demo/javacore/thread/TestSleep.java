package com.demo.javacore.thread;

/**
 * 当Thread0进入休眠状态时，Thread1并没有继续执行，而是等待Thread0休眠结束释放了对象锁，Thread1才继续执行。
 * 当调用sleep()方法时，必须捕获异常或者向上层抛出异常。当线程休眠时间满时，并不一定会马上执行，
 * 因为此时有可能CPU正在执行其他的任务，所以调用了sleep()方法相当于线程进入了阻塞状态。
 * @author yy
 *
 */
public class TestSleep {

	private Integer i = 10;
	private Object obj = new Object();
	
	public static void main(String[] args) {
		TestSleep ts = new TestSleep();
		MyThread1 t1 = ts.new MyThread1();
		MyThread1 t2 = ts.new MyThread1();
		t1.start();
		t2.start();
	}
	
	class MyThread1 extends Thread{
		@SuppressWarnings("static-access")
		@Override
		public void run() {
			synchronized (obj) {
				i++;
				System.out.println("i的值："+i);
				System.out.println("线程  "+Thread.currentThread().getName()+"进入休眠状态");
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("线程  "+Thread.currentThread().getName()+"休眠结束");
				i++;
				System.out.println("i的值>："+i);
			}
		}
		
	}
}

