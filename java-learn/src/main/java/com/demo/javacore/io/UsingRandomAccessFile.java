package com.demo.javacore.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile的使用案例
 * @author yy
 */
public class UsingRandomAccessFile {
	// 文件名
		static String file = "rtest.bat";
		
		static void display() throws IOException {
			// 创建随机访问类，只读模式
			RandomAccessFile rf = new RandomAccessFile(file, "r");
			for (int i = 0; i < 7; i++)
				System.out.println("Value "  + i + ": " + rf.readDouble());// 读取一个Double
			System.out.println(rf.readUTF());// 读取一个字符串
			rf.close();
		}
		
		public static void main(String[] args) throws IOException {
			// 创建随机访问类，读写模式
			RandomAccessFile rf = new RandomAccessFile(file, "rw");
			for (int i = 0; i < 7; i++)
				rf.writeDouble( i * 1.123);// 写入一个Double
			rf.writeUTF("文件结束");// 写入一个字符串
			rf.close();
			
			display();
			
			rf = new RandomAccessFile(file, "rw");
			rf.seek(5 * 8);// 设置文件指针偏移量，设置到第5个双精度字节
			rf.writeDouble(47.003);
			rf.close();
			
			display();
		}
}
