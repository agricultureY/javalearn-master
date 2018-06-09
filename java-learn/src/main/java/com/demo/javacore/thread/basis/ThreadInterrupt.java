package com.demo.javacore.thread.basis;
/**
 * 中断线程
 * @author ycn
 */
public class ThreadInterrupt {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new InterrupThread());
		t.start();
		Thread.sleep(1000);
		t.interrupt();
	}
}

class InterrupThread implements Runnable{
	private int num = 1;
	
	@Override
	public void run() {
		while(true)
			System.out.println("---------------->" + num++);
	}
	
}