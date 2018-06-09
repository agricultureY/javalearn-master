package com.demo.javacore.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;

/**
 * 格式化内存输入
 * @author yy
 */
public class FormatteMemoryInput {
	public static void main(String[] args) throws IOException {
		String filePath = "src" + File.separator +
				"main" + File.separator +
				"java" + File.separator +
				"com" + File.separator +
				"demo" + File.separator +
				"javacore" + File.separator +
				"io" + File.separator +
				"FormatteMemoryInput.java";
		try {
			DataInputStream in = new DataInputStream(
					// 缓冲区字节输入
					new ByteArrayInputStream(
							BufferedInputFileT.read(filePath).getBytes()));
			while(true)
				System.out.println((char)in.readByte());
		} catch (EOFException e) {
			System.out.println("End of Stream");
		}
	}
}
