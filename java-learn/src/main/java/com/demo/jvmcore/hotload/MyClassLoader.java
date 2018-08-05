package com.demo.jvmcore.hotload;

import java.io.InputStream;

/**
 * 自定义类加载器
 * 
 * @Package: com.demo.jvmcore.hotload
 * @author: ycn
 * @date: 2018年7月27日 下午5:11:46
 */
public class MyClassLoader extends ClassLoader {
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		try {
			//文件名
			String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
			//获取文件输入流
			InputStream is = this.getClass().getResourceAsStream(fileName);
			//读取字节
			byte[] b = new byte[is.available()];
			is.read(b);
			//将byte字节流解析为jvm能够识别的class对象
			return defineClass(name, b, 0, b.length);
		} catch (Exception e) {
			throw new ClassNotFoundException();
		}
		
	}

}
