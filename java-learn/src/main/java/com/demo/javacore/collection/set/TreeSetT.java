package com.demo.javacore.collection.set;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * TreeSet操作已实现Comparable接口的对象
 * @author ycn
 */
public class TreeSetT {
	public static void main(String[] args){
		TreeSet<Bird> bSet = new TreeSet<Bird>();
		bSet.add(new Bird(1));
		bSet.add(new Bird(3));
		bSet.add(new Bird(2));
		
		// 注意排序
		Iterator<Bird> iter = bSet.iterator();
		while (iter.hasNext()){
			Bird bird = (Bird) iter.next();
			System.out.println(bird);
		}
	}
}
/**
 * Bird对象 实现了Comparable接口
 */
class Bird implements Comparable<Bird>{
	int size;
	public Bird(int s){
		size = s;
	}
	
	public String toString(){
		return size + "号鸟";
	}

	@Override
	public int compareTo(Bird o){
		return size - o.size;
	}
}
