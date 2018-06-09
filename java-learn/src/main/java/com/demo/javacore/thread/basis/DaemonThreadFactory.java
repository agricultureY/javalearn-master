package com.demo.javacore.thread.basis;

import java.util.concurrent.ThreadFactory;
/**
 * 线程工厂类--将线程设置为后台线程
 * @author ycn
 */
public class DaemonThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setDaemon(true);//设为后台线程
		return t;
	}

}
