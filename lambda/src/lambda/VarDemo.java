package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author: lcc
 * @Date: 2018-05-14
 **/
public class VarDemo {
	public static void main(String[] args) {
    //  final String str="我们的时间";
		String str="我们的时间";
		Consumer<String> stringConsumer = s -> System.out.println(s+str);
		stringConsumer.accept("1314");

		List<String> list = new ArrayList<>();
		Consumer<String> listConsumer = s -> System.out.println(s+list);
		listConsumer.accept("1314");

	}
}
