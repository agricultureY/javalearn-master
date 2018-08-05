package com.demo.jvmcore.hotload;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 更新测试
 * 
 * @Package: com.demo.jvmcore.hotload
 * @author: ycn
 * @date: 2018年7月27日 下午5:19:16
 */
public class Hotswap {

	public static void main(String[] args) throws 
		ClassNotFoundException, 
		InstantiationException, 
		IllegalAccessException, 
		NoSuchMethodException, 
		SecurityException, 
		IllegalArgumentException, 
		InvocationTargetException, 
		InterruptedException {
		
		
		loadUser();
		System.gc();
		Thread.sleep(1000);//阻塞线程等待资源回收
		//需要被热部署的class文件    第一次user.class
		File stayClass = new File("F:\\self\\demos\\javalearn-master\\java-learn\\User.class");
		//之前编译好的class文件    需要被替换的class文件
		File theClass = new File("F:\\self\\demos\\javalearn-master\\java-learn\\target\\classes\\com\\demo\\jvmcore\\hotload\\User.class");
		boolean boo = theClass.delete();
		if(!boo) {
			System.out.println("热部署失败");
			return;
		}
		//替换
		stayClass.renameTo(theClass);
		System.out.println("热部署成功");
		loadUser();
	}
	
	public static void loadUser() throws 
		ClassNotFoundException, 
		InstantiationException, 
		IllegalAccessException, 
		NoSuchMethodException, 
		SecurityException, 
		IllegalArgumentException, 
		InvocationTargetException {
		
		
		MyClassLoader loader = new MyClassLoader();
		Class<?> clazz = loader.findClass("com.demo.jvmcore.hotload.User");
		Object obj = clazz.newInstance();
		Method method = clazz.getDeclaredMethod("add");
		method.invoke(obj);
		
		System.out.println(obj.getClass());
		System.out.println(obj.getClass().getClassLoader());
	}
}
