package com.demo.javacore.thread.basis;
/**
 * Runnable接口实现类--测试基类
 * @author ycn
 */
public class LiftOff implements Runnable {
	
	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;

	public LiftOff() { }
	
	public LiftOff(int countDown) {
		this.countDown = countDown;
	}
	
	/****查看线程状态****/
	public String status(){
        return "#" + id + "(" +
                (countDown >0 ? countDown : "LiftOff!") + "), ";
    }
	
	@Override
	public void run() {
		while(countDown-- > 0) {
			System.out.println(status());
			//暂停当前执行的线程，并执行其他线程
			Thread.yield();
		}
	}

}
