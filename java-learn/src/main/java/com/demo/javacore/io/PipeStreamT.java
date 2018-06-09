package com.demo.javacore.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 管道输入输出流的使用
 * 		同一个JVM中，两个线程之间的字节流通信
 * @author yy
 *
 */
public class PipeStreamT {
	public static void main(String[] args) throws IOException {
		//创建管道输出流
		final PipedOutputStream pipedOutputStream = new PipedOutputStream();
		//创建管道输入流并连接到管道输出流
		final PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);
		/*等价  final PipedInputStream inputStream = new PipedInputStream();
		inputStream.connect(pipedOutputStream);*/
		//创建输出流管道线程
		Thread outputThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					//将指定的字节数组写入管道输出流
					pipedOutputStream.write("test content".getBytes());
				} catch (IOException e) {}
			}
		});
		//创建管道输入流线程
		Thread inputThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					int data = pipedInputStream.read();
					while(data != -1) {
						System.out.println((char)data);
						data = pipedInputStream.read();
					}
				} catch (IOException e) {}
			}
		});
		outputThread.start();
		inputThread.start();
	}
}
