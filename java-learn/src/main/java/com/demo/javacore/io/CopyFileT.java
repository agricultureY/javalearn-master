package com.demo.javacore.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件复制
 * @author ycn
 */
public class CopyFileT {
	public static void main(String[] args) throws IOException {
		String dir = "src" + File.separator +
				"main" + File.separator +
				"java" + File.separator +
				"com" + File.separator +
				"demo" + File.separator +
				"javacore" + File.separator +
				"io" + File.separator;
		
		copyFile(dir + "/CopyFileT.java", "D://Copy.java");
	}
	
	/**
	 * 文件复制
	 * @param srcFile--源文件路径
	 * @param destFile--目标文件生成路径
	 * @throws IOException
	 */
	public static void copyFile(String srcFile,String destFile) 
		throws IOException {
		copyFile(new File(srcFile), new File(destFile));
	}
	
	public static void copyFile(File srcFile,File destFile)
		throws IOException {
		// 文件不存在
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("文件：" + srcFile + "不存在");
		}
		// 文件不是文件类型
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "不是文件");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		byte[] bytes = new byte[2 * 1024];
		int b;
		while ((b=in.read(bytes, 0, bytes.length)) != -1) {
			out.write(bytes, 0, b);
			out.flush();
		}
		out.close();
		in.close();
	}
}
