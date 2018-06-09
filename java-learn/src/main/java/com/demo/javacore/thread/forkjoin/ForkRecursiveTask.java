package com.demo.javacore.thread.forkjoin;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
/**
 * 每个文件使用一个线程处理,最终汇总到一起
 * @author ycn
 */
public class ForkRecursiveTask extends RecursiveTask<Map<String, Integer>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final File[] files;
	
	public ForkRecursiveTask(String path) {
		files = new File(path).listFiles();
	}
	
	/**
	 * 汇总处理,相当于reduce
	 */
	@Override
	protected Map<String, Integer> compute() {
		List<ForkJoinTask<Map<String, Integer>>> tasks = new ArrayList<>();
		for (File file : files) {
			FileRecursiveTask task = new FileRecursiveTask(file);
			tasks.add(task);
		}
		Map<String, Integer> result = new HashMap<>();
		for (ForkJoinTask<Map<String, Integer>> task : tasks) {
			Map<String, Integer> map = task.join();
			for(String key : map.keySet()) {
				if(result.containsKey(key))
					result.put(key, map.get(key) + result.get(key));
				else
					result.put(key, map.get(key));
			}
		}
		return null;
	}

}
