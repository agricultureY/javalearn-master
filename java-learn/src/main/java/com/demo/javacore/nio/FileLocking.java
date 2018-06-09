package com.demo.javacore.nio;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * 文件加锁
 * @author ycn
 */
public class FileLocking {

	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("data.txt");
		//从输出流中获取文件加锁对象并锁定file
		FileLock fileLock = fos.getChannel().lock();
		if (fileLock != null) {
            System.out.println("Locked File");
            TimeUnit.MICROSECONDS.sleep(100);
            // 释放文件锁定
            fileLock.release();
            System.out.println("Release Lock");
        }
	}
}
