package lambda;

import java.util.function.Function;

/**
 * 级联表达式 和柯里化
 * 柯里化把多个参数转换只有一个参数的函数
 * 目的：函数标准化
 * 高阶函数：返回函数的函数
 *
 * @author: lcc
 * @Date: 2018-05-14
 **/
public class CurryDemo {
	public static void main(String[] args) {
		// x+y 级联
		Function<Integer, Function<Integer, Integer>> fun = x -> y -> x + y;
		System.out.println(fun.apply(2).apply(3));
		System.out.println(fun.apply(2));
		//
		Function<Integer, Function<Integer, Function<Integer, Integer>>> fun1 = x -> y -> z -> x + y + z;
		System.out.println(fun1.apply(1).apply(3).apply(5));

		int[] nums = {2, 3, 4};
		Function f = fun1;
		for (int i = 0; i < nums.length; i++) {
			if (f instanceof Function) {
				Object obj = f.apply(nums[i]);
				if (obj instanceof Function) {
					f = (Function) obj;
				}
			} else {
				System.out.println("结束-------");
			}
		}
	}
}
