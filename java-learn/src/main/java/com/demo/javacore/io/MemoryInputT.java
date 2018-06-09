package com.demo.javacore.io;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

/**
 * 内存中输入
 * @author yy
 */
public class MemoryInputT {
	public static void main(String[] args) throws IOException {
		String fileName = "src" + File.separator +
				"main" + File.separator +
				"java" + File.separator +
				"com" + File.separator +
				"demo" + File.separator +
				"javacore" + File.separator +
				"io" + File.separator +
				"FileIOStreamT.java";
		StringReader sr = new StringReader(BufferedInputFileT.read(fileName));
		int c;
		while((c = sr.read()) != -1) {
			System.out.println((char)c);
		}
	}
}
