package com.lcc.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author: lcc
 * @Date: 2018-05-14
 **/
public class StartStreamDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		//从集合创建
		list.stream();
		list.parallelStream();

		//从数组
		Arrays.stream(new int[] {2,3,5});

		//数字
		IntStream.of(1,3,5);
		IntStream.rangeClosed(1,10);
		new Random().ints().limit(5);

		//自己创建
		Random random= new Random();
		Stream.generate(()->random.nextInt());
	}
}
