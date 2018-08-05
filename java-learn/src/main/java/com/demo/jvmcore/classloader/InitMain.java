package com.demo.jvmcore.classloader;
/**
 * 子类的初始化过程和主动引用：子类初始化先初始化父类
 * @author yy
 */
public class InitMain {

	public static void main(String[] args) {
		System.out.println(ChildClass.v);//子类被加载但没被初始化
//		System.out.println(new ChildClass().i);
	}
}
class PanterClass{
	static {
		System.out.println("parent init~~");
	}
	public static int v = 100;
	public int i = 10;
}
class ChildClass extends PanterClass{
	static {
		System.out.println("child init~~");
	}
}
