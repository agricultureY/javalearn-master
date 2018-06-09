package com.demo.jvmcore.classloader;
/**
 * Final字段不会被引起初始化
 * @author yy
 */
public class UseFinalField {

	public static void main(String[] args) {
		System.out.println(FinalField.TEST_FINAL_STR);
		System.out.println(FinalField.TEST_STR);
	}
}
class FinalField{
	public static final String TEST_FINAL_STR = "TEST_FINAL_STR";
	public static String TEST_STR = "TEST_STR";
	static {
		System.out.println("FinalField init~~");
	}
}
