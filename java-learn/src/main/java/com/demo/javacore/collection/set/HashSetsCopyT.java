package com.demo.javacore.collection.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * HashSet及其子类的转换使用
 * @author ycn
 */
public class HashSetsCopyT {
	public static void main(String[] args){
		Set<Object> s1 = new HashSet<Object>();
		s1.add("List");
		s1.add("Queue");
		s1.add("Set");
		s1.add("Map");
		
		System.out.println("HashSet Elements:");
		System.out.print("\t" + s1 + "\n");
		
		Set<Object> s2 = copy(s1);
		System.out.println("HashSet Elements After Copy:");
		System.out.print("\t" + s2 + "\n");
	}
	
	public static Set<Object> copy(Set<Object> set)	{
		Set<Object> setCopy = new LinkedHashSet<Object>(set);
		return setCopy;
	}
}
