package com.demo.designmode.responsibility;
/**
 * 实际处理者--error日志输出
 * @author ycn
 */
public class ErrorLogger extends AbstractLogger {

	public ErrorLogger(int level) {
		this.level = level;
	}
	
	@Override
	protected void write(String message) {
		System.out.println("error console::logger : "+message);
	}

}
