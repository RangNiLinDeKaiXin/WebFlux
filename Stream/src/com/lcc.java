package com;

import java.util.stream.IntStream;

/**
 * @author: lcc
 * @Date: 2018-05-14
 **/
public class lcc {
	public static void main(String[] args) {
		int [] nums ={1,2,3};
		//外部迭代
		int sum =0;
		for(int i: nums) {
			sum +=i;
		}
		System.out.println(sum);

		//stream 内部迭代
		int sum2 = IntStream.of(nums).sum();
		System.out.println(sum2);
	}
}
