package com.demo.javacore.scheduler;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer的使用
 *  一种工具，线程用其安排以后在后台线程中执行的任务，可安排任务执行一次，或者定期重复执行
 * @author ycn
 */
public class TimerTest extends TimerTask {

	private String jobName;
	
	public TimerTest() {}
	public TimerTest(String jobName) {
		this.jobName = jobName;
	}

	@Override
	public void run() {
		System.err.println(System.currentTimeMillis()+":");
		System.out.println("run the task => " + jobName);
	}

	public static void main(String[] args) {
		Timer timer = new Timer();
		//安排指定的任务从指定的延迟后开始进行重复的 固定延迟执行。以近似固定的时间间隔（由指定的周期分隔）进行后续执行
		timer.schedule(new TimerTest("Job 1"), 1000, 1000);
		timer.schedule(new TimerTest("Job 2"), 2000, 2000);
	}
}
