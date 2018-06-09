package com.demo.designmode.formwork;
/**
 * 动作模板抽象类
 * @author yy
 *
 * @param <T>
 */
public abstract class Iterator<T> {

	/**
	 * 动作抽象方法
	 * @param n
	 */
	abstract void process(T n);
	
	/**
	 * 迭代执行模板
	 * @param n  次数
	 * @param action  实现类
	 */
	static void iterate(int n,Iterator action) {
		for(int i = 1; i <= n; i++) {
			action.process(i);
		}
	}
}
