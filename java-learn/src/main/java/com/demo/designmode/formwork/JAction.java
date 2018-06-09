package com.demo.designmode.formwork;

public class JAction extends Iterator<Integer>{

	@Override
	void process(Integer n) {
		iterate(n, new IAction(n));//迭代
		System.out.println();//换行
	}
	
}
