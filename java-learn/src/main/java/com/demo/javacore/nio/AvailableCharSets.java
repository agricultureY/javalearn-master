package com.demo.javacore.nio;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

/**
 * 可用的charset打印
 * @author ycn
 */
public class AvailableCharSets {

	public static void main(String[] args) {
		//charset对象的有序映射
		SortedMap<String, Charset> charsets = Charset.availableCharsets();
		// 获取key的迭代器
        Iterator<String> iterator = charsets.keySet().iterator();
        while (iterator.hasNext()) {
            String csName = iterator.next();
            System.out.print(csName);
            // 获取别名的Charset集合的迭代器
            Iterator<String> aliases = charsets.get(csName).aliases().iterator();
            if (aliases.hasNext())
                System.out.print("： ");
            while (aliases.hasNext()) {
                System.out.print(aliases.next());
                if (aliases.hasNext())
                    System.out.print(",");
            }
            System.out.println();
        }
	}
}
