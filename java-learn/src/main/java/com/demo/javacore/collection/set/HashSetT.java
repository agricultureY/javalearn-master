package com.demo.javacore.collection.set;

import java.util.HashSet;
import java.util.Set;

/**
 * HashSet的Add方法
 * @author ycn
 */
public class HashSetT {
	public static void main(String[] args){
		Set<Object> h1 = new HashSet<>();
		h1.add("List");
		h1.add(new String("List"));
		h1.add("List");
		h1.add("Set");
		h1.add("Queue");
		h1.add("Map");
		// 注意排序
		System.out.println("HashSet Elements:");
		System.out.print("\t" + h1 + "\n");
	}
}
