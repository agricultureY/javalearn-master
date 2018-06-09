package com.demo.javacore.thread.join;

import java.util.concurrent.TimeUnit;

/**
 * DSLoder
 * @author ycn
 */
public class DSLoader implements Runnable {

	@Override
	public void run() {
		System.out.println("begining the DSLoader");
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("DSLoader has finished");
	}

}
