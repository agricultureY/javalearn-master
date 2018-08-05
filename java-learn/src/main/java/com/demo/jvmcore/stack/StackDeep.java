package com.demo.jvmcore.stack;
/**
 * 堆栈溢出理解
 * 	-Xss
 * 
 * @Package: com.demo.jvmcore.stack
 * @author: ycn
 * @date: 2018年7月27日 下午2:21:54
 */
public class StackDeep {
	private static int count = 0;
    public static void recursion(){
        count++;
        recursion();
    }
    public static void count(){
		try {
			 count++;
			 count(); 
		} catch (Throwable e) {
			System.out.println("最大深度:"+count);
			e.printStackTrace();
		}
	 }

    public static void recursion(long a,long b,long c){
        long e=1,f=2,g=3,h=4,j=5,k=6,l=7,q=8,w=10,r=9;
        count++;
        recursion(a,b,c);
    }

    public static void main(String[] args) {
        try {
//             recursion(0L,0L,0L);
//            recursion();
        	count();
        } catch (Throwable e){
            System.out.println("counts = " + count);
            e.printStackTrace();
        }
    }
}
