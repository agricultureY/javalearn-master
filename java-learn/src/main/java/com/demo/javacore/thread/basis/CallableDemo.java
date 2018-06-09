package com.demo.javacore.thread.basis;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Callable接口的使用 --- 实现带返回值的任务
 * @author ycn
 */
public class CallableDemo {

	public static void main(String[] args) {
		//创建一个新的线程池
		ExecutorService exe = Executors.newCachedThreadPool();
		//callable实现类task返回结果集--Future获取callable产生的结果
		List<Future<String>> results = new ArrayList<>();
		for(int i=0;i<5;i++)
			results.add(exe.submit(new TaskWithResult(i)));//submit()启动Task
		
		//异步计算结果
		for (Future<String> future : results) {
			try {
				//get阻塞直至获取结果
				System.out.println(future.get());
			} catch (InterruptedException e) {
				System.out.println(e);
				e.printStackTrace();
			} catch (ExecutionException e) {
				System.out.println(e);
				e.printStackTrace();
			} finally {
				exe.shutdown();
			}
		}
	}
}

/**
 * Callable实现类task，指定其类型参数
 * @author ycn
 */
class TaskWithResult implements Callable<String>{

	private int id;
	public TaskWithResult(int id) {
		this.id = id;
	}

	@Override
	public String call() throws Exception {
		return "result of TaskWithResult " + id;
	}
	
}
