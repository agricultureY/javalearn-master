package com.demo.javacore.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Lambda操作符
 *   :: 操作符格式 => 三种情况
 *     1、对象::实例方法
 *     2、类::静态方法
 *     3、类::实例方法
 *    对于前两种情况，方法引用就是对参数执行该方法
 * @author yy
 */
public class LambdaOperators {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("cccc");
        list.add("b");
        list.add("eeeee");
        
        //按字符串大小排序忽略大小写
        list.sort(String::compareToIgnoreCase);
        //打印list元素
        list.forEach(System.out::println);
        
        System.out.println("======按字符大小排序======");
        list.sort(Comparator.comparing(String::length));
        list.forEach(System.out::println);
	}
}
