package com.demo.jvmcore.memory;
/**
 * 输出浮点数在虚拟机的实际表示
 * @author yy
 */
public class FloatInJvm {

	public static void main(String[] args) {
		float a = 3.111f;
		System.out.println(Integer.toBinaryString(Float.floatToRawIntBits(a)));
	}
}
