package com.demo.designmode.responsibility;
/**
 * 抽象处理者
 * @author ycn
 */
public abstract class AbstractLogger {

	public static int INFO = 1;
	public static int DEBUG = 2;
	public static int ERROR = 3;
	
	protected int level;
	
	//责任链中的下一个元素
	protected AbstractLogger nextLogger;
	
	public void setNextLogger(AbstractLogger logger) {
		this.nextLogger = logger;
	}
	
	abstract protected void write(String message);
	
	public void logMessage(int level,String message) {
		if(this.level <= level)
			write(message);
		if(nextLogger != null)
			nextLogger.logMessage(level, message);
	}
}
