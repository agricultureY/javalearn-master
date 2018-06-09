package com.demo.javacore.thread;

/**
 * 调用yield()方法是为了让当前线程交出CPU权限，让CPU去执行其他线程。它和sleep()方法类似同样是不会释放锁。
 * 	但是yield()不能控制具体的交出CUP的时间。并且它只能让相同优先级的线程获得CPU执行时间的机会。
 * 调用yield()方法不会让线程进入阻塞状态，而是进入就绪状态，它只需要等待重新获取CPU的时间，这一点和sleep()方法是不一样的。
 * @author yy
 */
public class TestYield {

	public static void main(String[] args) {
		MyYieldThread t = new MyYieldThread();
		t.start();
	}
}

class MyYieldThread extends Thread {
	
	@Override
	public void run() {
		long open = System.currentTimeMillis();
		int count = 0;
		for (int i = 0; i < 1000000; i++) {
			count = count+(i+1);
			//Thread.yield();
		}
		long end = System.currentTimeMillis();
		System.out.println("用时"+(end-open)+"毫秒");
	}
}
