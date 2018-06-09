package com.demo.javacore.thread.forkjoin;

import java.util.concurrent.RecursiveTask;
/**
 * 自定义fork/join任务
 * @author ycn
 */
public class MyForkJoinTask extends RecursiveTask<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final int spilSize = 2;
	
	private int start,end;
	
	public MyForkJoinTask() { }
	
	public MyForkJoinTask(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		if((end - start) < spilSize) {
			for(int i=start;i<end;i++)
				sum += i;
		}else {
			int middle = (start + end)/spilSize;
			MyForkJoinTask firstTask = new MyForkJoinTask(start, middle);
			MyForkJoinTask secondTask = new MyForkJoinTask(middle + 1, end);
			//提交任务
			firstTask.fork();
			secondTask.fork();
			//线程阻塞等待任务结果
			Integer firstResult = firstTask.join();
			Integer secondResult = secondTask.join();
			sum = firstResult.intValue() + secondResult.intValue();
		}
		return sum;
	}

}
