package com.demo.javacore.concurrent;
/**
 * 同步辅助类：完成一组线程执行前，使得一个或多个线程一直等待
 * @author yy
 */

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/**
 * CountDownLatch线程计数器应用    
 *  用途：使一个线程等待其他线程完成各自的工作后再执行
 *  原理：CountDownLatch是通过一个计数器来实现的，计数器的初始值为线程的数量。
 *  		每当一个线程完成了自己的任务后，计数器的值就会减1。
 *  		当计数器值到达0时，它表示所有的线程已经完成了任务，然后在闭锁上等待的线程就可以恢复执行任务。
 * @author ycn
 */
public class CountDownLatchT {

	//线程中止的计数器
	private final static int COUNT = 10;
	private final static CountDownLatch count = new CountDownLatch(COUNT);
	
	//线程池
	private final static ExecutorService service = Executors.newFixedThreadPool(5);
	
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < COUNT; i++) {
			service.execute(() -> {
				try {
					int time = new Random().nextInt(5);
					TimeUnit.SECONDS.sleep(time);//模拟线程耗时
					System.out.printf("Thread %s ## 耗时:%d \n",Thread.currentThread().getId(),time);
					//线程结束后计数器减1
					count.countDown();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}); 
		}
		count.await();
		service.shutdown();
		System.out.println("同步线程执行组结束!");
	}
}
