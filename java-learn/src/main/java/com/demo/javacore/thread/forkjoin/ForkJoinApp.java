package com.demo.javacore.thread.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * fork/join模式案例
 * @author ycn
 */
public class ForkJoinApp {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ForkJoinPool pool = new ForkJoinPool();
		MyForkJoinTask task = new MyForkJoinTask(1, 10);
		Future<Integer> result = pool.submit(task);
		System.out.println("result : " + result.get());
	}
}
