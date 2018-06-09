package com.demo.javacore.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})//声明作用于方法
@Retention(RetentionPolicy.RUNTIME)//保留到运行时
public @interface TestMethod {

	String value();
}
