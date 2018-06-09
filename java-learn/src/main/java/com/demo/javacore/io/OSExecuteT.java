package com.demo.javacore.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 操作系统进程流的案例
 * @author yy
 *
 */
public class OSExecuteT {

	/**
	 * 获取操作系统进程信息
	 * @param command--进程的名称(即:cmd操作命令行)
	 */
	public static void commond(String command) {
		boolean err = false;
		try {
			//创建操作系统进程 
			Process process = new ProcessBuilder(command.split(" ")).start();
			//读取进程的输入流
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String s;
			while((s = bufferedReader.readLine()) != null) {
				System.out.println(s);
			}
			//读取进程中的错误流
			BufferedReader errs = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			while((s = errs.readLine()) != null) {
				System.err.println(s);
				if(! err)
					err = true;
			}
		} catch (Exception e) {
			if (!command.startsWith("CMD /C"))
				commond("CMD /C " + command);
			else 
				throw new RuntimeException(e);
		}
		if (err)
			throw new OSExecuteException("Errors Executing " + command);
	}
	
	public static void main(String[] args) {
		commond("mvn -version");
	}
}

class OSExecuteException extends RuntimeException {
	private static final long serialVersionUID = -3254218368058055219L;

	public OSExecuteException(String msg) {
		super(msg);
	}
}