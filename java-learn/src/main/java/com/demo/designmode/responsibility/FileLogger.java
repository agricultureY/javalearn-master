package com.demo.designmode.responsibility;
/**
 * 实际处理者--file日志输出
 * @author ycn
 */
public class FileLogger extends AbstractLogger {

	public FileLogger(int level) {
		this.level = level;
	}
	
	@Override
	protected void write(String message) {
		System.out.println("File::logger : "+message);
	}

}
