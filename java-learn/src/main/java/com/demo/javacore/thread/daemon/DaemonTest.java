package com.demo.javacore.thread.daemon;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1.直到3个WriteTask线程休眠后,CleanerTask才执行
 * 2.从结果中,可以看出队列维持在一定数量当中
 * @author ycn
 */
public class DaemonTest {

	public static void main(String[] args) {
		Deque<Event> eves = new ArrayDeque<>();
		WriterTask writerTask = new WriterTask(eves);
		for(int i=0;i<3;i++){
			Thread t = new Thread(writerTask);
			t.start();
		}
		
		CleanerTask cleanerTask = new CleanerTask(eves);
		cleanerTask.start();
	}
}
