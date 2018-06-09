package com.demo.javacore.thread.daemon;
/**
 * 管理队列,如果超过10秒则移除事件
 * @author ycn
 */

import java.util.Date;
import java.util.Deque;

public class CleanerTask extends Thread {

	private Deque<Event> deque;

	public CleanerTask(Deque<Event> deque) {
		this.deque = deque;
		this.setDaemon(true);
	}
	
	/**
	 * 删除该时间前10s内创建的事件对象
	 * @param date
	 */
	private void clean(Date date) {
		long difference = 0;
		boolean del;
		if(deque.size() == 0)
			return;
		del = false;
		System.out.println("before cleaner : "+deque.size());
		do {
			if(deque.size() > 0) {				
				Event e = deque.getLast();
				difference = date.getTime() - e.getDate().getTime();
				if(difference > 10000) {
					System.out.printf("Cleaner: %s \n",e.getEvent());
					deque.removeLast();
					del = true;
				}
			}
		} while (difference > 10000);
		if(del)
			System.out.printf("Cleaner: Size of the queue: %d\n",deque.size());
		System.out.println("after cleaner : "+deque.size());
	}

	@Override
	public void run() {
		while(true)
			clean(new Date());
	}
	
}
