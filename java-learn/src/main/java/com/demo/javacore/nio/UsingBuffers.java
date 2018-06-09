package com.demo.javacore.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * 利用buffer实现交换相邻字符
 * @author ycn
 */
public class UsingBuffers {

	private static void symmetricScaramble(CharBuffer cb) {
		while(cb.hasRemaining()) {
			//将Mark设为position
			char c1 = cb.get();
			char c2 = cb.get();
			//重置为以前标记的位置
			cb.reset();
			cb.put(c2).put(c1);
		}
	}
	
	public static void main(String[] args) {
		char [] data = "Using Buffer".toCharArray();
        // 一个字符两个字节
        ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
        CharBuffer cb = bb.asCharBuffer();
        cb.put(data);
        // 重绕此缓冲区
        System.out.println(cb.rewind());
        symmetricScaramble(cb);
        // 重绕此缓冲区
        System.out.println(cb.rewind());
        symmetricScaramble(cb);
        System.out.println(cb.rewind());
	}
}
