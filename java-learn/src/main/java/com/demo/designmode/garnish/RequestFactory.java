package com.demo.designmode.garnish;

/**
 * 请求工厂类
 * @author yy
 *
 */
public class RequestFactory {

	public static Request getRequest() {
		return new RequestImpl("测试装饰模式123qwe");
	}
}
