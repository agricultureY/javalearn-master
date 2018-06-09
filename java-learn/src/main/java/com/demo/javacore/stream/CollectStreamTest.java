package com.demo.javacore.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectStreamTest {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Double result = list.stream().collect(Collectors.averagingDouble(d -> d*2));
		System.out.println(result);
	}
	
}
