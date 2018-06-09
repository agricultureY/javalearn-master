package com.demo.javacore.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 通过Channel复制文件
 * @author ycn
 */
public class ChannelCopy {

	//读取文件
	private static final String sourceFile = 
			"src" + File.separator +
			"main" + File.separator +
			"java" + File.separator +
			"com" + File.separator +
			"demo" + File.separator +
			"javacore" + File.separator +
			"nio" + File.separator +
			"ChannelCopy.java";
	private static final String targetFile = "data.txt";
	private static final int BSIZE = 1024;
	
	public static void main(String[] args) throws Exception {
		//创建用于读写的Channel
		FileChannel in = new FileInputStream(sourceFile).getChannel(),
				out = new FileOutputStream(targetFile).getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
		// 将字节序列从此通道读入给定的缓冲区,分块读，直至读到文件末端
		while (in.read(byteBuffer) != -1) {// -1,表示读到文件末端
			// 反转缓冲区，为写入或读取做好准备
			byteBuffer.flip();
			// 将含有字节序列的缓冲区写入文件通道
			out.write(byteBuffer);
			// 清空缓冲区
			byteBuffer.clear();
		}
	}
}
