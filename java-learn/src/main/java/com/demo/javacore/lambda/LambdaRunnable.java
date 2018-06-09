package com.demo.javacore.lambda;
/**
 * Lambda启动线程
 * @author yy
 */
public class LambdaRunnable {
	static int b = 10;
	public static void main(String[] args) {
		/*Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				b++;
				System.out.println(b);
			}
		});*/
		
		Thread thread = new Thread(() -> {
			b++;
			System.out.println(b);
		}) ;
		
		thread.start();
		System.out.println("Done!");
	}
}
