package com.lcc.stream;

import java.util.Random;
import java.util.stream.Stream;

/**
 * @author: lcc
 * @Date: 2018-05-14
 **/
public class MidStreamDemo {
	public static void main(String[] args) {

		String str = "lcc shuai qi";
		//每个单词长度
		Stream.of(str.split(" ")).map(s -> s.length()).forEach(System.out::println);
		System.out.println("----------------------");
		Stream.of(str.split(" ")).filter(s -> s.length() > 2).map(s -> s.length()).forEach(System.out::println);
		System.out.println("----------------------");
		//flatMap a-b(集合) 得到a里面b的所有集合
		Stream.of(str.split(" ")).flatMap(s -> s.chars().boxed()).forEach(
				i -> System.out.println((char) i.intValue())
		);
		System.out.println("----------------------");
		//peek 用与debug
		Stream.of(str.split(" ")).peek(System.out::println).forEach(System.out::println);
		//limit 主要用于无线流
		System.out.println("----------------------");
		new Random().ints().filter(i -> i > 100&&i<1000).limit(10).forEach(System.out::println);
	}

}
