package com.demo.javacore.io.byteoper;

/**
 * 	Integer类的进制转换
 */
public class IntegerOperT {

	public static void main(String[] args) {
		System.out.println("17的十六进制： " + Integer.toHexString(17));
		System.out.println("17的八进制：     " 	+ Integer.toOctalString(17));
		System.out.println("17的二进制：     " 	+ Integer.toBinaryString(17));

		System.out.println(Integer.valueOf("11", 16));
		System.out.println(Integer.valueOf("21", 8));
		System.out.println(Integer.valueOf("00010001", 2));
	}

}
