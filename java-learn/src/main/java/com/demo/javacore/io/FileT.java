package com.demo.javacore.io;

import java.io.File;
import java.io.IOException;

/**
 * File类的使用
 * @author yy
 */
public class FileT {
	
	private static void fileData(File f) {
		System.out.println(
			" 绝对路径：" + f.getAbsolutePath() +
			"\n 可读：" + f.canRead() +
			"\n 可写：" + f.canWrite() +
			"\n 文件名：" + f.getName() +
			"\n 上级目录：" + f.getParent() +
			"\n 相对地址：" + f.getPath() +
			"\n 长度：" + f.length() +
			"\n 最近修改时间：" + f.lastModified()
			);
		if(f.isFile())
			System.out.println(" 是一个文件");
		else if(f.isDirectory())
			System.out.println(" 是一个目录");
	}
	
	public static void main(String[] args) {
		try {
			// 创建一个目录
			File dir = new File("E:" + File.separator + "dir");
			dir.mkdir();
			// 创建一个文件
			File file = new File(dir,"file.txt");
			file.createNewFile();
			
			// 是否是一个目录
			System.out.println(dir.isDirectory());
			// 是否是一个文件
			System.out.println(file.isFile());
			
			// 删除文件
			if (file.delete()) {
				System.out.println(file.getName() + "被删除了！");
			} else {
				System.out.println("文件删除失败！");
			}
		} catch (IOException e) { e.printStackTrace(); }
		
		// 获取src目录
		File file = new File("src");
		// file详细操作
		fileData(file);
	}
}
