package com.demo.javacore.io;

import java.io.PrintWriter;
/**
 * 改变System.out输出
 * @author yy
 *
 */
public class ChangeSystemOut {
	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out,true);
		out.println("Hello PrintWriter");
		out.close();
	}
}
