package com.lcc.stream;

import java.util.stream.IntStream;

/**
 * @author: StreamDemo
 * @Date: 2018-05-14
 **/
public class StreamDemo {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		//外部迭代
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		System.out.println(sum);

		//stream 内部迭代
		int sum2 = IntStream.of(nums).sum();
		System.out.println(sum2);
		//map 中间操作（返回stream操作） 没有终止操作则中间操作不执行
		//sum 终止操作
		int sum3 = IntStream.of(nums).map(i -> i * 3).sum();
		System.out.println(sum3);

		int sum4 = IntStream.of(nums).map(StreamDemo::doubleNum).sum();
		System.out.println(sum4);


	}

	public static int doubleNum(int i) {
		return i * 2;
	}
}
