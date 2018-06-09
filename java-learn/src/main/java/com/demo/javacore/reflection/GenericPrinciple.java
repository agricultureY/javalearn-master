package com.demo.javacore.reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型原理
 * @author yy
 */
public class GenericPrinciple {

	public static void main(String[] args) {
		//声明两个list，一个有泛型，一个没有泛型
		List list1 = new ArrayList() ;
        List<String> list2 = new ArrayList<String>() ;
        list2.add("你好") ;
//        list2.add(11) ;加上泛型之后在编译期间只能添加String，不然会报错。
        System.out.println("list2的长度是："+list2.size());
        Class c1 = list1.getClass();
        Class c2 = list2.getClass() ;
        System.out.println("c1,c2是否相等:"+(c1==c2));
        try {
            //通过反射绕过编译器动态调用add方法，可能否加入非String类型的元素
            Method method = c2.getDeclaredMethod("add", Object.class) ;
            method.invoke(list2, 123) ;//在这里加入int类型，在上面如果加入int会出现编译报错。

            //list2的长度增加了，说明添加成功了
            System.out.println("现在list2的长度是:"+list2.size());
            /**
             * 所以可以看出，泛型只是在编译期间起作用，在经过编译进入运行期间是不起作用的。
             * 就算是不是泛型要求的类型也是可以插入的。
             */
        } catch (Exception e) {
            e.printStackTrace() ;
        }
	}
}
