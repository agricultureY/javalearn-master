package com.demo.javacore.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 比较ArrayList与LinkedList
 * @author ycn
 */
public class PerBtwnArlAndLklT {
	public static void main(String[] args) {
		testPerBtwnArlAndLkl();
	}
	
	/**
	 * 	ArrayList与LinkedList各方法性能的对比
	 */
	public static void testPerBtwnArlAndLkl(){
		ArrayList<Integer> 	arrayList  = new ArrayList<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
				
		// ArrayList add方法
		long startTime = System.nanoTime();
		long endTime;
		long duration; 
		for (int i = 0; i < 100000; i++)
			arrayList.add(i);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("ArrayList add:  " + duration);
		 
		// LinkedList add方法
		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++)
			linkedList.add(i);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedList add: " + duration);
		 
		// ArrayList get方法
		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++)
			arrayList.get(i);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("ArrayList get:  " + duration);
		 
		// LinkedList get方法
		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++)
			linkedList.get(i);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedList get: " + duration);
		 
		// ArrayList remove方法
		startTime = System.nanoTime();
		for (int i = 9999; i >=0; i--)
			arrayList.remove(i);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("ArrayList remove:  " + duration);
		 
		// LinkedList remove方法
		startTime = System.nanoTime();
		for (int i = 9999; i >=0; i--)
			linkedList.remove(i);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedList remove: " + duration);
	}
}
