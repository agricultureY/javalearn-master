package com.demo.designmode.garnish;

/**
 * 装饰模式的请求实现
 * @author yy
 *
 */
public class RequestImpl implements Request {
	
	private String msg;
	
	public RequestImpl(String msg) {
		this.msg = msg;
	}

	@Override
	public String getParamter() {
		return msg;
	}

}
