package com.demo.designmode.single;
/**
 * 饿汉式单例模式
 * @author yy
 *
 */
public class HungerSingleton {

	private HungerSingleton() { }
	
	private static HungerSingleton single = new HungerSingleton();
	
	public static HungerSingleton getInstance() {
		return single;
	}
}
