package com.demo.javacore.thread.join;
/**
 * 测试join入口
 * 	把指定的线程加入到当前线程，可以将两个交替执行的线程合并为顺序执行的线程
 * 	比如在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B
 * 	主要作用就是同步，它可以使得线程之间的并行执行变为串行执行
 * @author ycn
 */
public class JoinTest {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new DSLoader());
        Thread t2 = new Thread(new NetLoader());

        t1.start();
        t2.start();

        //可以注释其中一个加深理解
        //t1.join();
        t2.join();

        System.out.println("ending all");
	}
}
