package com.demo.javacore.io.byteoper;

/**
 * 	String转换成byte数组
 */
public class StringConvertT {

	public static void main(String[] args){
		String str = "HOME";
		byte[] bytes = str.getBytes();
		// 打印字节数组
		System.out.println("UTF-8编码'HOME'的字节数组为：");
		for (int i = 0; i < bytes.length; i++) {
            System.out.println("\t" + bytes[i] + "|" + Integer.toBinaryString(bytes[i]));
        }
	}
}
