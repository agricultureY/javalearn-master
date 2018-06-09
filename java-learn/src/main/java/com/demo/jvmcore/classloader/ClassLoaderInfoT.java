package com.demo.jvmcore.classloader;
/**
 * 打印类加载器信息
 * @author yy
 */
public class ClassLoaderInfoT {

	public static void main(String[] args) {
		ClassLoader load = Thread.currentThread().getContextClassLoader();
		System.out.println("当前类加载器："+load);
		System.out.println("当前类的父加载器："+load.getParent());
		System.out.println("当前类的爷加载器："+load.getParent().getParent());
	}
}
