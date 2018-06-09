package com.demo.javacore.collection.queue;

import java.util.PriorityQueue;

/**
 * PriorityQueue的使用
 *  PriorityQueue也叫优先队列，所谓优先队列指的就是每次从优先队列中取出来的元素要么是最大值（最大堆），要么是最小值（最小堆）
 *  队列是一种先进先出的数据结构，每次从队头出队（移走一个元素），从队尾插入一个元素（入队）
 * @author ycn
 */
public class PriorityQueueT {
	public static void main(String[] args) {
		int[] ia = { 1, 10, 5, 3, 4, 7, 6, 9, 8 };
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
 
		for (int x : ia) 
			pq1.offer(x);
		// 注意排序
		System.out.println("pq1: " + pq1);
	}
}
