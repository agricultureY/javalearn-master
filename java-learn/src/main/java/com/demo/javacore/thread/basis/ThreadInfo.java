package com.demo.javacore.thread.basis;

/**
 * 线程优先级
 * @author ycn
 */
public class ThreadInfo {

	public static void main(String[] args) {
		Thread [] threads = new Thread[10];
		Thread.State [] states = new Thread.State[10];
		for(int i=0;i<10;i++) {
			threads[i] = new Thread(new Calculator(i));
			if((i%2)==0) {
				threads[i].setPriority(Thread.MAX_PRIORITY);
			}else {
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
		}
		//将线程信息写入log.txt文件
		//FileWriter fw = new FileWriter(".\\log.txt");
		//PrintWriter pw = new PrintWriter(fw);
		for(int i=0;i<10;i++) {
			//pw.println("Main: status of Thread "+ i +" : "+threads[i].getState());
			System.out.println("-->Main: status of Thread "+ i +" : "+threads[i].getState());
			states[i] = threads[i].getState();
		}
		//启动线程
		for(int i=0;i<10;i++)
			threads[i].start();
		boolean finish = false;
		System.out.println("==========================================");
		while(!finish) {
			for(int i=0;i<10;i++) {
				if(threads[i].getState() != states[i]) {
					writeThreadInfo(threads[i], states[i]);//pw
					states[i] = threads[i].getState();
				}
			}
			finish = true;
			for(int i=0;i<10;i++) {
				finish = finish && (threads[i].getState() == Thread.State.TERMINATED);//中断线程
			}
		}
	}
	
	private static void writeThreadInfo(Thread thread,Thread.State state) {//PrintWriter pw,
		/*pw.printf("Main: Id %d - $s\n",thread.getId(),thread.getName());
        pw.printf("Main: Priority: %d\n",thread.getPriority());
        pw.printf("Main: OldState: %s\n",state);
        pw.printf("Main: New State: %s\n",thread.getState());
        pw.printf("*****************************************\n");*/
        
        System.out.printf("Main: Id %d - $s\n",thread.getId(),thread.getName());
        System.out.printf("Main: Priority: %d\n",thread.getPriority());
        System.out.printf("Main: OldState: %s\n",state);
        System.out.printf("Main: New State: %s\n",thread.getState());
        System.out.printf("*****************************************\n");
	}
}

class Calculator implements Runnable{

	private int num;
	
	public Calculator(int num) {
		super();
		this.num = num;
	}

	@Override
	public void run() {
		for (int i = 0;i <=10; i++) {
            System.out.printf("%s: %d * %d = %d\n",
                    Thread.currentThread().getName(),
                    num, i, i * num);
        }
	}
	
}
