package com.demo.javacore.thread.join;

import java.util.concurrent.TimeUnit;

/**
 * NetLoader
 * @author ycn
 */
public class NetLoader implements Runnable {

	@Override
	public void run() {
		System.out.println("begining the NetLoader");
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("NetLoader has finished");
	}

}
