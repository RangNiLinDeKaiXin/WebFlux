package com.lcc.stream;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * 1所有操作链式调用 一个元素只迭代一次
 *
 * 2每一个中间操作返回一个新的流
 * 流里面有个sourceStage 指向同一个地方就是head
 * Head->nextStage->nextStage->...null
 *
 *3有状态操作会把无状态操作截断，单独处理
 *
 * 4并行环境下，有状态的中间操作不一定能并行
 *
 * 5parallel sequential 不创建流 只是修改了Head的并行标志
 * @author: lcc
 * @Date: 2018-05-14
 **/
public class RunStreamDemo {

	public static void main(String[] args) {
		Random random = new Random();

		Stream<Integer> stream = Stream.generate(() -> random.nextInt())

				.limit(500)
				.peek(s -> print("peek: " + s))
				.filter(s -> {
					print("filter: " + s);
					return s > 1000000;
				})
				//有状态
				.sorted((i1, i2) -> {
					print("sorted: " + i1 + ", " + i2);
					return i1.compareTo(i2);
				})
				.peek(s -> {
					print("peek2: " + s);
				}).parallel();
		//sequential()

		stream.count();
	}


	public static void print(String s) {
		// System.out.println(s);
		System.out.println(Thread.currentThread().getName() + " > " + s);
		try {
			TimeUnit.MILLISECONDS.sleep(5);
		} catch (InterruptedException e) {
		}
	}


}
