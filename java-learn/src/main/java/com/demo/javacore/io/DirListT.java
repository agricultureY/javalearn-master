package com.demo.javacore.io;

import java.io.File;
import java.util.Arrays;

/**
 * 列出目录并排序
 * @author yy
 *
 */
public class DirListT {
	public static void main(String[] args) {
		// 获取当前目录
		File path = new File(".");// .表示当前目录
		// 文件路径名数组
		String list[] = path.list();
		
		// 对String文件名进行排序
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		
		// 打印
		for(String dirItem : list)
			System.out.println(dirItem);
	}
}
