package com.demo.designmode.single;

/**
 * 懒汉式单例模式
 * @author yy
 */
public class LazySingleton {

	private LazySingleton() { }
	
	private static LazySingleton single = null;
	
	public static LazySingleton getInstance() {
		if(single == null)
			single = new LazySingleton();
		return single;
	}
	
	public static synchronized LazySingleton getSynInstance() {
		if(single == null)
			single = new LazySingleton();
		return single;
	}
	
	public static LazySingleton getInstanceDoubleCheck() {
		if(single == null) {
			synchronized (LazySingleton.class) {
				if(single == null)
					single = new LazySingleton();
			}
		}
		return single;
	}
}
