package com.demo.javacore.scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledExecutorService的使用
 *  基于线程池设计的定时任务类,每个调度任务都会分配到线程池中的一个线程去执行,也就是说,任务是并发执行,互不影响
 *  只有当调度任务来的时候,ScheduledExecutorService才会真正启动一个线程,
 *   其余时间ScheduledExecutorService都是出于轮询任务的状态
 * @author ycn
 */
public class SchedulerExecutorTest implements Runnable {

	private String jobName;
	public SchedulerExecutorTest() {}
	public SchedulerExecutorTest(String jobName) {
		super();
		this.jobName = jobName;
	}

	@Override
	public void run() {
		System.out.println("running => " + jobName);
	}

	public static void main(String[] args) {
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		executor.scheduleAtFixedRate(new SchedulerExecutorTest("Job 1"), 1, 1, TimeUnit.MINUTES);//1S
		executor.scheduleAtFixedRate(new SchedulerExecutorTest("Job 2"), 1, 2, TimeUnit.MINUTES);//1S
	}
}
