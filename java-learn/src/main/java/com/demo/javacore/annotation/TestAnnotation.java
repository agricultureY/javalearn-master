package com.demo.javacore.annotation;
/**
 * 自定义注解测试入口
 * @author yy
 */
//@TestClass//拿到默认值default
@TestClass("作用于类上的注解")
public class TestAnnotation {

	@TestMethod("作用于方法上的注解")
	public void testAnno() {}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		TestClass tc = TestAnnotation.class.getAnnotation(TestClass.class);
		TestMethod tm = TestAnnotation.class.getDeclaredMethod("testAnno", null).getAnnotation(TestMethod.class);
		System.out.println("TestClass的值:"+tc.value());
		System.out.println("TestMethod的值:"+tm.value());
	}
}
