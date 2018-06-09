package com.demo.javacore.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 通过实现Callable接口创建带有返回值的线程
 * 
 * Executors.newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 * Executors.newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。 
 * Executors.newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
 * Executors.newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 * @author yy
 */
public class TestCallable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService pool = Executors.newFixedThreadPool(3);//创建线程池
		MyCallable c1 = new MyCallable("线程1");
		MyCallable c2 = new MyCallable("线程2");
		MyCallable c3 = new MyCallable("线程3");
		Future<Object> f1 = pool.submit(c1);
		Future<Object> f2 = pool.submit(c2);
		Future<Object> f3 = pool.submit(c3);
		System.out.println(f1.get().toString());
		System.out.println(f2.get().toString());
		System.out.println(f3.get().toString());
		
		ExecutorService singlePool = Executors.newSingleThreadExecutor();
		Future<Object> fs = singlePool.submit(new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				return new Random().nextInt(100);
			}
		});
		System.out.println(fs.get().toString());
		
		
	}
}

class MyCallable implements Callable<Object> {

	private String name;
	
	public MyCallable(String name) {
		this.name = name;
	}
	
	@Override
	public Object call() throws Exception {
		return name+"返回结果！";
	}
	
}
