package com.demo.javacore.collection.map;

import java.util.Map;
import java.util.TreeMap;

/**
 * TreeMap的使用
 * @author ycn
 */
public class TreeMapT {

	public static void main(String[] args) {
		Map<String, Object> map = new TreeMap<>();
		map.put("1", "1");
		map.put("4", "4");
		map.put("2", "2");
		map.put("2", "3");
		// 注意排序
		System.out.println(map);
	}
}
