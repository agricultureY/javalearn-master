package com.demo.designmode.garnish;
/**
 * 装饰模式测试类
 * @author yy
 *
 */
public class GarnishMain {

	public static void main(String[] args) {
		System.out.println(new RequestGrnish(RequestFactory.getRequest()).getParamter());
	}
}
