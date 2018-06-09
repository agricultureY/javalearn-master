package com.demo.javacore.reflection;

import java.util.Random;

/**
 * Class初始化案例
 * @author ycn
 */
public class ClassInitialization {
	public static Random random = new Random(47);
	
	public static void main(String[] args) throws ClassNotFoundException {
		// 类中有编译期常量 static Final,则暂时不需要初始化
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        System.out.println(Initable.staticFinal);
        // 调用非编译期常量，强制进行类Initable初始化
        System.out.println(Initable.staticFinal2);

        // 先进行初始化
        System.out.println(Initable2.staticNonFinal);

        // 无编译期常量，直接初始化
        Class initable3 = Class.forName("com.demo.javacore.reflection.Initable3");
        System.out.println("After creating Initable ref");
        System.out.println(Initable3.staticNonFinal);
	}
}

class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 =
            ClassInitialization.random.nextInt(1000);
    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}