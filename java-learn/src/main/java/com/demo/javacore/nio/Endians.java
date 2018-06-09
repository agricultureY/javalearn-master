package com.demo.javacore.nio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * ByteBuffer中字节存储顺序
 * @author ycn
 */
public class Endians {
	public static void main(String[] args) {
		//创建12个字节的字节缓冲区
		ByteBuffer bb = ByteBuffer.wrap(new byte [12]);
		bb.asCharBuffer().put("123qwe");
		System.out.println(Arrays.toString(bb.array()));
		//反转缓冲区
		bb.rewind();
		//设置字节存储顺序
		bb.order(ByteOrder.BIG_ENDIAN);
		bb.asCharBuffer().put("123qwe");
		System.out.println(Arrays.toString(bb.array()));
		//反转缓冲区
		bb.rewind();
		//设置字节存储顺序
		bb.order(ByteOrder.LITTLE_ENDIAN);
		bb.asCharBuffer().put("123qwe");
		System.out.println(Arrays.toString(bb.array()));
	}
}
