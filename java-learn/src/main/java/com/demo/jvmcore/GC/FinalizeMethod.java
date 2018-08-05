package com.demo.jvmcore.GC;
/**
 * finalize方法调用
 * 		GC回收之前执行--查看对象是否被回收
 * 
 * @Package: com.demo.jvmcore.GC
 * @author: ycn
 * @date: 2018年7月26日 下午3:08:27
 */
public class FinalizeMethod {

	@Override
	protected void finalize() throws Throwable {
		System.out.println("GC 回收............");
	}
	
	public static void main(String[] args) {
		Object obj = new FinalizeMethod();
		System.gc();//通知GC进行回收
		FinalizeMethod fz = (FinalizeMethod) obj;
		System.gc();
		fz = new FinalizeMethod();
		System.gc();
		fz = null;
		FinalizeMethod fza = new FinalizeMethod();
		fza = null;
		FinalizeMethod fzb = new FinalizeMethod();
		System.gc();
	}

}
