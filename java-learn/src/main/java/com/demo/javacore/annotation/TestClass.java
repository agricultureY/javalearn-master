package com.demo.javacore.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})//声明作用于类
@Retention(RetentionPolicy.RUNTIME)//保留到运行时
public @interface TestClass {

	String value() default "default";//设置默认值
}
