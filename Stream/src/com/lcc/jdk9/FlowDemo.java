package com.lcc.jdk9;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;
/**
 * @author: lcc
 * @Date: 2018-05-14
 **/
public class FlowDemo {

	public static void main(String[] args) throws Exception {
		// 1定义发布者 发布的数据类型是integer
		//直接使用jdk自带SubmissionPublisher 他实现Publisher 接口
		SubmissionPublisher<Integer> publiser = new SubmissionPublisher<Integer>();
		//2 定义订阅者
		Subscriber<Integer> subscriber = new Subscriber<Integer>() {

			private Subscription subscription;

			@Override
			public void onSubscribe(Subscription subscription) {
				//保存订阅关系 用它来响应发布者
				this.subscription = subscription;
				//请求一个数据
				this.subscription.request(1);
			}

			@Override
			public void onNext(Integer item) {

				System.out.println("接收到数据: " + item);

				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				//处理完 再请求数据
				this.subscription.request(1);

				//已经达到目标 调用cancel告诉发布者不再接受数据了
				// this.subscription.cancel();
			}

			@Override
			public void onError(Throwable throwable) {
				//出现异常
				throwable.printStackTrace();

				//告诉发布者 不接受后面的数据
				this.subscription.cancel();
			}

			@Override
			public void onComplete() {

				System.out.println("处理完成!");
			}

		};
		//3建立订阅关系
		publiser.subscribe(subscriber);

		for (int i = 0; i < 1000; i++) {
			System.out.println("生产者生成数据:" + i);
			//submit 是个block方法 缓冲池默认256
			publiser.submit(i);
		}
		//关闭发布者
		publiser.close();
		//主线程延迟 否则数据没有消费就退出
		Thread.currentThread().join(1000);
		System.out.println();
	}

}
