package com.demo.jvmcore.memory;
/**
 * 负整数在JVM中的表示
 * @author yy
 */
public class IntegerInJvm {
	public static void main(String[] args) {
        int a = -10;
        for (int i = 0; i < 32; i++){
            // 0x80000000?
            // 0100,0000,0000,0000,0000,0000,0000,0000
            // ?????????0
            int t = (a & 0x80000000 >>> i) >>> (31 - i);
            System.out.print(t);
        }
        System.out.println();
        System.out.println("--------------------------------");
        // ???
        System.out.println(Integer.toBinaryString(a));
    }
}
