package com.lcc.stream;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author: lcc
 * @Date: 2018-05-14
 **/
public class ParallelStreamDemo {
	public static void main(String[] args) {
		//parallel 产生并行流
		//	IntStream.range(1,5).parallel().peek(ParallelStreamDemo::debug).count();

		//先并行在串行
		//多次调用parallel，sequential 以最后一次运行
//		IntStream.range(1, 5)
//				.parallel()
//				.peek(ParallelStreamDemo::debug)
//				.sequential().peek(ParallelStreamDemo::debug2)
//				.count();

		//并行流线程Thread[ForkJoinPool.commonPool
		//默认线程数为当前电脑cpu个数
		//System.setProperty("java.util.concurrent.ForkJoinPool",20);
		IntStream.range(1, 10).parallel().peek(ParallelStreamDemo::debug).count();

	}

	public static void debug(int i) {
		System.out.println(Thread.currentThread()+"debug" + i);
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void debug2(int i) {
		System.out.println("info" + i);
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
