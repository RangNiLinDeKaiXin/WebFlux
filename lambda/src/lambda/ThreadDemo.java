package lambda;

/**
 * @author: lcc
 * @Date: 2018-05-11
 **/
public class ThreadDemo {
	public static void main(String[] args) {
		Runnable ok = new Runnable() {
			@Override
			public void run() {
				System.out.println("ok");
			}
		};

		new Thread(ok).start();

		//jdk8 lambda
		Runnable ok1 = () -> System.out.println("ok");
	new Thread(ok1).start();

	}
}
