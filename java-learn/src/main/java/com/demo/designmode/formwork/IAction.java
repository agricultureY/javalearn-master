package com.demo.designmode.formwork;

public class IAction extends Iterator<Integer> {

	private final Integer x;//变量
	
	public IAction(Integer x) {
		this.x = x;
	}
	
	@Override
	void process(Integer n) {
		System.out.print("  "+n+"*"+x+"="+x*n);//i*j的乘积
	}

}

