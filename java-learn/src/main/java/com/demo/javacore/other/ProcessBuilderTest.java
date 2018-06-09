package com.demo.javacore.other;

import java.io.IOException;
import java.util.Scanner;

/**
 * Java进程调用CMD窗口
 * @author ycn
 */
public class ProcessBuilderTest {

	public static void main(String[] args) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("\"cmd\",\"/c\",\"ipconfig/all\"");
		Process p = pb.start();
		
		Scanner sc = new Scanner(p.getInputStream());
		while(sc.hasNext())
			System.out.println(sc.next());
		sc.close();
	}
}
