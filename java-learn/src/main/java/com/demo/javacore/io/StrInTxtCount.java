package com.demo.javacore.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 统计字符串在文本中出现的次数
 * @author ycn
 */
public class StrInTxtCount {

	/**
	 * 
	 * @param fileName--文件名
	 * @param str--指定字符串
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static int count(String fileName,String str) throws IOException,FileNotFoundException{
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		StringBuilder sb = new StringBuilder();
		while(true) {
			String line = br.readLine();
			if(null == line)
				break;
			sb.append(line);
		}
		int count = 0,index = 0;
		String result = sb.toString();
		while(true) {
			index = result.indexOf(str, index + 1);
			if(index > 0)
				count++;
			else
				break;
		}
		br.close();
		return count;
	}
}
