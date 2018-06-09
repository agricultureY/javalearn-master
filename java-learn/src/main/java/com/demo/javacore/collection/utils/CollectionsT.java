package com.demo.javacore.collection.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections的使用
 * @author ycn
 */
public class CollectionsT {
	public static void main(String[] args){
		// 测试集合工具类Sort方法
		testSort();
		testAddAll();
	}
	
	/**
	 * 测试集合工具类Sort方法
	 */
	private static void testSort(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(2);
		list.add(4);
		// 调用集合工具类Sort方法
		Collections.sort(list);
	
		System.out.println("list sorted:");
		System.out.print("\t" + list + "\n");
	}
	
	private static void testAddAll() {
		List<String> list = new ArrayList<>();
		list.add("s2");
		list.add("s4");
		list.add("s1");
		list.add("s3");
		System.out.println(list);
		Collections.addAll(list, "s5","s7",null,"s9");
		System.out.println(list);
	}
}
