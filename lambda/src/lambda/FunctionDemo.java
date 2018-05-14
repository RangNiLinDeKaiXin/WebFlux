package lambda;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author: lcc
 * @Date: 2018-05-11
 **/
public class FunctionDemo {

	public static void main(String[] args) {
		//断言
		//IntPredicate jdk带有类型的断言
		Predicate<Integer> predicate = i->i>0;
		System.out.println(predicate.test(-9) );

		//消费函数

		Consumer<String> consumer =s-> System.out.println(s);
		consumer.accept("输入的数据");
	}
}
