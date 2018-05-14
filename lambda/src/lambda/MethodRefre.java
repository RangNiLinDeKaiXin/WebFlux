package lambda;

import java.util.function.*;

/**
 * @author: lcc
 * @Date: 2018-05-14
 **/
public class MethodRefre {
	public static void main(String[] args) {
		//方法引用
		//Consumer<String> consumer=s -> System.out.println(s);
		Consumer<String> consumer = System.out::println;
		consumer.accept("接收一个字符串");

		//静态方法引用
		Consumer<Dog> dogConsumer = Dog::bark;
		Dog dog = new Dog();
		dogConsumer.accept(dog);

		//非静态
		Function<Integer, Integer> function = dog::eat;
		UnaryOperator<Integer> function2 = dog::eat;
		IntUnaryOperator function3 = dog::eat;

		System.out.println("剩下" + function.apply(2) + "斤");
		System.out.println("剩下" + function2.apply(2) + "斤");
		System.out.println("剩下" + function3.applyAsInt(2) + "斤");

		//使用类名来引用方法
		BiFunction<Dog, Integer, Integer> biFunction = Dog::eat;
		System.out.println("剩下" + biFunction.apply(dog, 2) + "斤");

		//构造函数 无参
		Supplier<Dog> dogSupplier = Dog::new;
		System.out.println("创建新对象" + dogSupplier.get());
		// 构造函数 有参
		Function<String, Dog> dogFunction = Dog::new;

		System.out.println("创建新对象" + dogFunction.apply("旺财"));

	}
}

class Dog {
	private String name = "啸天";

	private int food = 10;


	public Dog() {

	}

	public Dog(String name) {
		this.name = name;
	}

	/**
	 * 狗叫 静态
	 *
	 * @param dog
	 */
	public static void bark(Dog dog) {
		System.out.println(dog + "叫了");
	}

	/**
	 * 吃狗粮
	 * jdk 默认会把当前实例传入非静态方法 参数名this，位置第一个
	 *
	 * @param num
	 * @return 剩下的
	 */
//	public int eat(int num) {
//		System.out.println(name + "吃了" + num + "斤狗粮");
//		food = food - num;
//		return food;
//	}
	public int eat(Dog this, int num) {
		System.out.println(name + "吃了" + num + "斤狗粮");
		food = food - num;
		return food;
	}

	@Override
	public String toString() {
		return this.name;
	}
}