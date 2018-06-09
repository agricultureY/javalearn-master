package com.demo.jvmcore.classloader;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * String 类加载机制
 * @author yy
 */
public class StringCL {

	public static void main(String[] args) throws ClassNotFoundException {
		Class clzStr = Class.forName("java.lang.String");
		//获取对象的方法数组
		Method[] methods = clzStr.getMethods();
		for (Method m : methods) {
            // 获取修饰符标志的字符串
            String mod = Modifier.toString(m.getModifiers());
            System.out.print(mod + " " + m.getName() + "(");
            Class<?>[] ps = m.getParameterTypes();
            if (ps.length == 0)
                System.out.print(')');
            for (int i = 0; i < ps.length;i++) {
                char end = i == ps.length -1 ? ')':',';
                System.out.print(ps[i].getSimpleName() + end);
            }
            System.out.println();
        }
	}
}
