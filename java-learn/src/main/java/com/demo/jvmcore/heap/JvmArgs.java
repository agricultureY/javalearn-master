package com.demo.jvmcore.heap;
/**
 * 打印堆内存
 *   jvm参数配置：
 *   	-XX:+UseSerialGC    	串行回收	CPU利用率最高，停顿时间即用户等待时间比较长
 *   	-XX:+UseParNewGC		采用ParNew收集器	Serial收集器的多线程版本；新生代并行，老年代串行；新生代复制算法、老年代标记-压缩
 *   	-XX:ParallelGCThreads	限制线程数量
 *   	XX:+USeParNewGC			打开并发标记扫描垃圾回收器	停顿时间短，回收效率高，对吞吐量要求高
 *   	-XX:+UseConcMarkSweepGC	cms收集器 采用“标记-清除”算法实现，使用多线程的算法去扫描堆，对发现未使用的对象进行回收；响应时间优先，减少垃圾收集停顿时间；产生大量空间碎片、并发阶段会降低吞吐量
 *   	-XX:+UseG1GC			使用g1垃圾回收器	支持很大的堆，高吞吐量，主线程暂停时使用并行收集，主线程运行时并发收集
 *   
 *   	-XX:+PrintGC			每次触发GC的时候打印相关日志
 *   	-XX:+PrintGCDetails 	更详细的GC日志
 *   
 *   	-Xms               		堆初始值
 *   	-Xmx               		堆最大可用值
 *   	-Xmn               		新生代堆最大可用值
 *   	-XX:SurvivorRatio  		用来设置新生代中eden空间和from/to空间的比例    (默认：8:1:1).
 *   	-XX:NewRatio       		配置新生代与老年代占比 1:2    (默认：1:2)
 *   
 *   	-Xss					栈内存设置	太大将导致JVM可建的线程数量减少
 *   	-XX:PermSize			永久代内存大小	太大会导致fullGC时间过长，太小将增加fullGC频率
 *   
 *   	-XX:+DisableExplicitGC	禁止手动fullGC，如果配置，则System.gc()将无效
 *   
 *   	-XX:MaxTenuringThreshold设置晋升老年代阈值
 *   例：
 *   	-Xms20m					堆初始值20m
 *   	-Xmx20m					最大值20m
 *   	-Xmn1m					新生代堆最大可用值1m
 *   	-XX:SurvivorRatio=2		eden空间和from/to空间的比例为：2:1:1
 *   	-XX:NewRatio=2    		配置新生代与老年代占比 1:2
 *   	-XX:+PrintGCDetails 
 *   	-XX:+UseSerialGC
 *   	 
 *   com.demo.jvmcore.heap.JvmXmxArgs a b
 *   打印始终小于 33M , 因为GC在不同区域采用不同回收算法，可用内存的减少为了其使用空间换时间的策略。
 *   
 *   总结：
 *   	1、初始堆值和最大堆内存内存越大，吞吐量就越高。
 *   	2、最好使用并行收集器,因为并行收集器速度比串行吞吐量高，速度快。
 *   	3、设置堆内存新生代的比例和老年代的比例最好为1:2或者1:3。
 *   	4、减少GC对老年代的回收。
 * 
 * @Package: com.demo.jvmcore.heap
 * @author: ycn
 * @date: 2018年7月27日 上午10:08:56
 */
public class JvmArgs {

	public static void main(String[] args) {
		/*for (String arg : args) {
			System.out.println("参数为："+arg);
		}
		byte[] b = null;
		for(int i = 0; i < 10; i++)
			b = new byte[1 * 1024 * 1024];*/
		System.out.println("堆最大内存："+Runtime.getRuntime().maxMemory()/1024/1024+"M");
		System.out.println("堆可用内存："+Runtime.getRuntime().freeMemory()/1024/1024+"M");
		System.out.println("堆已用内存："+Runtime.getRuntime().totalMemory()/1024/1024+"M");
	}
}
