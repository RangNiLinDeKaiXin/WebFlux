package com.lcc.jdk9;

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

/**
 * processor 需要继承SubmissionPublisher 并实现 Processor接口
 * 输入数据源int 过滤小于0 然后转程string 发布出去
 */
/**
 * @author: lcc
 * @Date: 2018-05-14
 **/
class MyProcessor extends SubmissionPublisher<String>
		implements Processor<Integer, String> {

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

}

public class FlowDemo2 {

	public static void main(String[] args) throws Exception {
		SubmissionPublisher<Integer> publiser = new SubmissionPublisher<Integer>();

		MyProcessor processor = new MyProcessor();

		publiser.subscribe(processor);

		Subscriber<String> subscriber = new Subscriber<String>() {

			private Subscription subscription;

			@Override
			public void onSubscribe(Subscription subscription) {
				this.subscription = subscription;

				this.subscription.request(1);
			}

			@Override
			public void onNext(String item) {

				this.subscription.request(1);

				// this.subscription.cancel();
			}

			@Override
			public void onError(Throwable throwable) {
				throwable.printStackTrace();

				this.subscription.cancel();
			}

			@Override
			public void onComplete() {
				System.out.println("!");
			}

		};
        //处理器 与最终订阅者建立关系
		processor.subscribe(subscriber);

		publiser.submit(-111);
		publiser.submit(111);

		publiser.close();

		Thread.currentThread().join(1000);
	}

}
