package com.demo.javacore.reflection;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 反射扩容对象数组
 * @author yy
 */
public class ArrayCopy {

	/**
	 * 数组扩容
	 * @param a
	 * @param newLen
	 * @return
	 */
	public static Object goodCopyOf(Object a,int newLen) {
		Class cl = a.getClass();
		if(!cl.isArray())return null;
		Class componentType = cl.getComponentType();//获取数组组件对象
		int len = Array.getLength(a);
		Object newArray = Array.newInstance(componentType, newLen);
		System.arraycopy(a, 0, newArray, 0, Math.min(len, newLen));
		return newArray;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3};
        a = (int[]) goodCopyOf(a,10);
        System.out.println(Arrays.toString(a));

        String[] str = {"a","b","c"};
        str = (String[]) goodCopyOf(str,10);
        System.out.println(Arrays.toString(str));
	}
}
