package lambda;

/**
 * @author: lcc
 * @Date: 2018-05-14
 **/
public class TypeDemo {
	public static void main(String[] args) {
		//变量类型定义
		IMath lambda = (x, y) -> x + y;

		//数组里
		IMath[] lambdas = {(x, y) -> x + y};

		//强转
		Object lambda2 = (IMath) (x, y) -> x + y;
		//通过返回类型
		IMath createLambdas=createLambda();

		TypeDemo demo=new TypeDemo();
		demo.test((x,y)->x+y);
	}

	public void test(IMath iMath) {

	}

	public static IMath createLambda() {
		return (x ,y)->x + y;
	}
}

interface IMath {
	int add(int x, int y);
}
