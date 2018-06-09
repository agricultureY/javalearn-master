package com.demo.javacore.thread.daemon;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * 写事件到一个队列
 * @author ycn
 */
public class WriterTask implements Runnable {
	
	private Deque<Event> deques;
	
	public WriterTask(Deque<Event> deques) {
		this.deques = deques;
	}

	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			Event e = new Event();
			e.setDate(new Date());
			e.setEvent(String.format("The thread  %s has generated an event", Thread.currentThread().getId()));
			deques.addFirst(e);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		System.out.println("-->"+deques.size());
	}

}
