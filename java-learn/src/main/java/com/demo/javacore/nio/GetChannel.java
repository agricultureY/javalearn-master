package com.demo.javacore.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 从流中获取FileChannel
 * @author ycn
 */
public class GetChannel {

	private static final int BSIZE = 1024; // 1K字节
	
	public static void main(String[] args) throws IOException {
		//从文件输出流中获取FileChannel
		FileChannel fc = new FileOutputStream("data.txt").getChannel();
		//将含有字节序列的缓冲区写入文件通道
		fc.write(ByteBuffer.wrap("some text".getBytes()));//将已存在的字节数组包装到ByteBuffer中
		//关闭通道
		fc.close();
		fc = new RandomAccessFile("data.txt", "rw").getChannel();
		//文件指针指向文件尾部
		fc.position(fc.size());
		//将含有字节序列的缓冲区写入文件通道
		fc.write(ByteBuffer.wrap("some more".getBytes()));
		fc.close();
		//从文件输入流获取FileChannel文件
		fc = new FileInputStream("data.txt").getChannel();
		//分配ByteBuffer的大小 1K
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		//将字节序列从此通道读入给定的缓冲区。
		fc.read(buffer);
		//反转缓冲区，为写入或读取做好准备
		buffer.flip();
		//打印
		while (buffer.hasRemaining())
			System.out.print((char)buffer.get());
	}
}
