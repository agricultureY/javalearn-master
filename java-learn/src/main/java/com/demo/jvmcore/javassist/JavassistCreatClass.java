package com.demo.jvmcore.javassist;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过Javassist创建类
 * 
 * @Package: com.demo.jvmcore.javassist
 * @author: ycn
 * @date: 2018年7月27日 下午4:30:17
 */
public class JavassistCreatClass {
	
	public static void main(String[] args) throws ClassNotFoundException, 
		InstantiationException, 
		IllegalAccessException, 
		NoSuchMethodException, 
		SecurityException, 
		IllegalArgumentException, 
		InvocationTargetException {
		
		Class<?> clazz = Class.forName("com.demo.jvmcore.javassist.JavassistCreatClass");
		Object obj = clazz.newInstance();
		Method method = clazz.getDeclaredMethod("sum", int.class, int.class);
		method.invoke(obj, 1, 1);
	}
	
	public void sum(int i, int j) {
		System.out.println("sum-->"+(i + j));
	}

}
