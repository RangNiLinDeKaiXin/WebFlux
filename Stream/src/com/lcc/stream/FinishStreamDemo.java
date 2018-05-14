package com.lcc.stream;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: lcc
 * @Date: 2018-05-14
 **/
public class FinishStreamDemo {
	public static void main(String[] args) {
		String str = "lcc shuai qi";
		str.chars().parallel().forEach(i -> System.out.print((char) i));
		//保证顺序
		str.chars().parallel().forEachOrdered(i -> System.out.print((char) i));

		//收集到容器
		List<String> list = Stream.of(str.split(" ")).collect(Collectors.toList());
		System.out.println(list);

		//reduce
		Optional<String> letters = Stream.of(str.split(" ")).reduce((s1, s2) -> s1 + "-" + s2);
		System.out.println(letters.orElse(""));

		Integer lengths = Stream.of(str.split(" ")).map(s -> s.length()).reduce(0, (s1, s2) -> s1 + s2);
		System.out.println(lengths);
         //max
		Optional<String> max = Stream.of(str.split(" ")).max((s1, s2) -> s1.length() - s2.length());
		System.out.println(max.get());

		OptionalInt first = new Random().ints().findFirst();
		System.out.println(first.getAsInt());

	}
}
