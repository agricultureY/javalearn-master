package com.demo.javacore.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * FileChannel的transferTo/transferFrom
 * @author ycn
 */
public class FileChannelTransferTo {
	// 读取的文件
	private static final String sourceFile = 
			"src" + File.separator +
			"main" + File.separator +
			"java" + File.separator +
			"com" + File.separator +
			"demo" + File.separator +
			"javacore" + File.separator +
			"nio" + File.separator +
			"FileChannelTransferTo.java";
	// 输出的文件
	private static final String targetFile = "data.txt";
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// 创建用于读写的Channel
		FileChannel
			in  = new FileInputStream(sourceFile).getChannel(),
			out = new FileOutputStream(targetFile).getChannel();
		// 将in通道的字节传输给out可写入字节通道
		in.transferTo(0, in.size(),out);
		// or
		// 将字节从给定的可读取字节通道传输到此通道的文件中。
		// out.transferFrom(in, 0, in.size());
	}
}
