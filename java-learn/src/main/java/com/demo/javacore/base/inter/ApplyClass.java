package com.demo.javacore.base.inter;

import java.util.Arrays;

/**
 * 不调用接口的接口案例
 * @author yy
 */
public class ApplyClass {

	public static String str = "test string is you are a person";
	
	public static void process(Processor p,Object input) {
		System.out.println("调用对象的名称 ："+p.name());
		System.out.println(p.process(input));
	}
	
	public static void main(String[] args) {
		process(new Upcase(),str);
        process(new Splitcase(),str);
	}
}

class Processor {
    public String name(){
        return getClass().getSimpleName();
    }

    Object process(Object input){return input;}
}

class Upcase extends Processor {
    @Override
    Object process(Object input) {
        return ((String)input).toUpperCase();
    }
}

class Splitcase extends Processor {
    @Override
    Object process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}
