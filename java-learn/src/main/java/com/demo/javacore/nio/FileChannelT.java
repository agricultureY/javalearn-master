package com.demo.javacore.nio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * FileChannel读写文件案例
 * @author ycn
 */
public class FileChannelT {

	//nio包路径
	private static final String nioDir = 
			"src" + File.separator +
			"main" + File.separator +
			"java" + File.separator +
			"com" + File.separator +
			"demo" + File.separator +
			"javacore" + File.separator +
			"nio";
	
	public static void main(String[] args) throws Exception {
		//读写方式获取FileChannelT.java文件
		RandomAccessFile in = new RandomAccessFile(nioDir+File.separator+"FileChannelT.java", "rw");
		//创建文件输出流
		FileOutputStream out = new FileOutputStream("F:/FileChannelT.java");
		//创建文件输入流通道
		FileChannel inCh = in.getChannel();
		//创建文件输出流通道
		FileChannel outCh = out.getChannel();
		//创建字节缓冲区
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
		long startTime = System.currentTimeMillis();
		
		while (true) {
			//将字节序列从此通道读入给定的缓冲区
			int eof = inCh.read(byteBuffer);
			if(eof == -1)
				break;
			byteBuffer.flip();//反转缓冲区
			//将字节序列化从给定的缓冲区写入到此通道
			outCh.write(byteBuffer);
			byteBuffer.clear();//清除缓冲区
		}
		
		//管理管道
		inCh.close();
		outCh.close();
		System.out.println("耗时："+(System.currentTimeMillis() - startTime));
	}
}
