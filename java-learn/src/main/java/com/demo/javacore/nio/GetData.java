package com.demo.javacore.nio;

import java.nio.ByteBuffer;

/**
 * ByteBuffer操作类型数据
 * @author ycn
 */
public class GetData {

	private static final int BSIZE = 1024;//1字节 
	
	public static void main(String[] args) {
		//创建字节缓冲区
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		int i = 0;
		while(i++ < bb.limit())//缓冲区的限制
			if(bb.get() != 0)//如果字节不为0，读取当前位置字节
				System.out.println("该字节不为0!");
		System.out.println("i = "+i);
		//重绕此缓冲区
		bb.rewind();
		//写入数据
		bb.asCharBuffer().put("Hello Word");
		//从次缓冲区读取，并输出
		char c;
		while((c = bb.getChar()) != 0)
			System.out.print(c+" ");
		System.out.println();
		//写入short类型数据
		bb.asShortBuffer().put((short) 123);
		System.out.println(bb.getShort());
		//重绕此缓冲区
		bb.rewind();
		// 写入Long类型数据
        bb.asLongBuffer().put((long)99471142);
        System.out.println(bb.getLong());
        // 重绕此缓冲区
        bb.rewind();
	}
}
