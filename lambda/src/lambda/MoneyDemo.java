package lambda;

import java.text.DecimalFormat;
import java.util.function.Function;

/**
 * @author: lcc
 * @Date: 2018-05-11
 **/
interface IMoneyFormat{
	String format(int i);
}
class MyMoney{
	private final int money;

	MyMoney(int money) {
		this.money = money;
	}
//	public void printMoney(IMoneyFormat moneyFormat) {
//		System.out.println("我的存款"+moneyFormat.format(this.money));
//	}
	public void printMoney(Function<Integer,String> moneyFormat) {
		System.out.println("我的存款"+moneyFormat.apply(this.money));
	}
}
public class MoneyDemo {
	public static void main(String[] args) {
		MyMoney me = new MyMoney(99999999);
		Function<Integer, String> integerStringFunction = i -> new DecimalFormat("#,###").format(i);

		me.printMoney(integerStringFunction);
		//函数式接口链式操作
		me.printMoney(integerStringFunction.andThen(s->"人民币"+s));

	}
}
