package com.demo.javacore.thread.forkjoin;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

/**
 * 通过fork/join统计一个目录下所有文本文件里面字符串的个数
 * @author ycn
 */
public class WordCountForkJoin {

	public static void main(String[] args) {
		String path = "src" + File.separator +
				"main" + File.separator +
				"java" + File.separator +
				"com" + File.separator +
				"demo" + File.separator +
				"javacore" + File.separator +
				"thread" + File.separator +
				"forkjoin" + File.separator +
				"data";
		ForkJoinPool pool = new ForkJoinPool();
		Map<String, Integer> map = pool.invoke(new ForkRecursiveTask(path));
		for(String key : map.keySet())
			System.out.println(key+" : "+map.get(key));
	}
}
