package com.demo.javacore.base.inter;

import java.util.Arrays;

/**
 * 使用接口的接口案例
 * @author yy
 */
public class ApplyInter {

	public static String str = "test string is you are a person";
	
	public static void process(ProcessorInter p,Object input) {
		System.out.println("调用对象的名称 ："+p.name());
		System.out.println(p.process(input));
	}
	
	public static void main(String[] args) {
		process(new UpcaseImpl(), str);
		process(new SplitcaseImpl(),str);
	}
}

interface ProcessorInter{
	String name();
	Object process(Object input);
}

class UpcaseImpl implements ProcessorInter {
	@Override
	public String name() {
		return this.getClass().getSimpleName();
	}

	@Override
	public Object process(Object input) {
		return ((String)input).toUpperCase();
	}
}

class SplitcaseImpl implements ProcessorInter {
	@Override
	public String name() {
		return this.getClass().getSimpleName();
	}

	@Override
	public Object process(Object input) {
		return Arrays.toString(((String)input).split(" "));
	}
}
