package com.demo.javacore.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * DataOutputStream和DataInputStream的使用
 * @author yy
 */
public class StoringAndRecoveringData {
	public static void main(String[] args) throws IOException {
		// 写入数据
		DataOutputStream outputStream = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream("data.txt")));
		outputStream.writeDouble(3.1415926);
		outputStream.writeUTF("你好");
		outputStream.writeInt(1);
		outputStream.close();
		
		// 写出数据
		DataInputStream inputStream = new DataInputStream(
				new BufferedInputStream(new FileInputStream("data.txt")));
		System.out.println(inputStream.readDouble());
		System.out.println(inputStream.readUTF());
		System.out.println(inputStream.readInt());
	}
}
