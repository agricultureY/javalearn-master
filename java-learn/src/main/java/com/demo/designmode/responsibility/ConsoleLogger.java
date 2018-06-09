package com.demo.designmode.responsibility;
/**
 * 实际处理者--控制台日志输出
 * @author ycn
 */
public class ConsoleLogger extends AbstractLogger {

	public ConsoleLogger(int level) {
		this.level = level;
	}
	
	@Override
	protected void write(String message) {
		System.out.println("standard console::logger : "+message);
	}

}
