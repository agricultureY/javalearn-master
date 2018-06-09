package com.demo.javacore.collection.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Collections.EMPTY_MAP 与 new HashMap 性能对比
 * 场景：webservice接口，根据某些条件直接返回空Map，则使用Collections.EMPTY_MAP。
 * @author ycn
 */
public class PerBtwnEmptyMapAndHashMapT {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		for (int i = 0; i < 100000000; i++) {
			Map<String,Object> map = Collections.emptyMap();
		}
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("Collections.EMPTY_MAP:  " + duration);
		
		startTime = System.nanoTime();
		for (int i = 0; i < 100000000; i++) {
			Map<String,Object> map = new HashMap<>();
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("new HashMap:  " + duration);
	}
}
