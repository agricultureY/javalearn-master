package com.demo.javacore.collection.set;

import java.util.HashSet;

/**
 * HashSet 操作对象的决定因子：hashCode与equals
 * @author ycn
 */
public class HashSetObjT {
	public static void main(String[] args){
		HashSet<Object> objs = new HashSet<>();
		objs.add(new A());
		objs.add(new B());
		objs.add(new C());
		objs.add(new A());
		objs.add(new B());
		objs.add(new C());
		System.out.println("HashSet size:"+objs.size());
		System.out.println("HashSet Elements:");
		for (Object obj : objs) {
			System.out.println(obj);
		}
	}
}
class A {
	public boolean equals(Object obj){
		return true;
	}
}

class B {
	public int hashCode(){
		return 1;
	}
}

class C {
	public int hashCode(){
		return 2;
	}

	public boolean equals(Object obj){
		return true;
	}
}
