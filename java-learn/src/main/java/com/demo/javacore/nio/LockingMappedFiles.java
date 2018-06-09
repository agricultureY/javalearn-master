package com.demo.javacore.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * 映射文件的使用
 * @author ycn
 */
public class LockingMappedFiles {
	static final int LENGTH = 0x8FFFFFF; // 128 MB
    static FileChannel fc;
    
    public static void main(String[] args) throws IOException {
		fc = new RandomAccessFile("data.txt", "rw").getChannel();
		MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
		for (int i = 0;i < LENGTH; i++)
            out.put((byte)'x');
        new LockAndModify(out,0,0 + LENGTH/3);
        new LockAndModify(out,LENGTH/2,LENGTH/2 + LENGTH/4);
	}
    
    private static class LockAndModify extends Thread{
    	private ByteBuffer buffer;
    	private int start,end;
    	
    	LockAndModify(ByteBuffer bb,int start,int end) {
    		this.start = start;
    		this.end = end;
    		bb.limit(end);
    		bb.position(start);
    		buffer = bb.slice();
    		start();
		}
    	
		@Override
		public void run() {
			try {
				//从FileChannel获取文件加锁对象，并加锁
				FileLock fl = fc.lock(start, end, false);
				System.out.println("Locked:"+start+" to "+end);
				//写入数据
				while(buffer.position() < buffer.limit() - 1) {
					buffer.put((byte) (buffer.get() + 1));
				}
				fl.release();
				System.out.println("Released:"+start+" to "+end);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	
    }
}
