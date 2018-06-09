package com.demo.javacore.initAndCleanup;
/**
 * 构造器
 * @author yy
 */
public class SimpleConstructor {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Child();
		}
		for (int i = 0; i < 10; i++) {
			new Child2(i);
		}
	}
}

// Child类
class Child {
	Child() { // Child类的构造器
		System.out.println("Child init... ");
	}
}
class Child2 {
	Child2(int i) { // Child类的构造器
		System.out.println("Child init " + i + " ");
	}
}