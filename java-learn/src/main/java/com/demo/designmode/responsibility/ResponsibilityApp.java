package com.demo.designmode.responsibility;
/**
 * 责任链模式测试
 * @author ycn
 */
public class ResponsibilityApp {

	/**
	 * 设置责任链传递
	 * @return
	 */
	private static AbstractLogger getLogger() {
		AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
		AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
		AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
		errorLogger.setNextLogger(fileLogger);
		fileLogger.setNextLogger(consoleLogger);
		return errorLogger;
	}
	
	public static void main(String[] args) {
		AbstractLogger logger = getLogger();
		logger.logMessage(AbstractLogger.INFO, "info log...");
		System.out.println("=================================");
		logger.logMessage(AbstractLogger.DEBUG, "debug log...");
		System.out.println("=================================");
		logger.logMessage(AbstractLogger.ERROR, "error log...");
	}
	
}
