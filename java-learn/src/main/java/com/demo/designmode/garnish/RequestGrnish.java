package com.demo.designmode.garnish;
/**
 * 装饰模式 请求装饰
 * @author yy
 *
 */
public class RequestGrnish implements Request {

	private Request request;
	
	public RequestGrnish(Request request) {
		if(request == null) {
			throw new IllegalArgumentException("request can be null");
		}
		this.request = request;
	}
	
	@Override
	public String getParamter() {
		return request.getParamter().toUpperCase();
	}

}
