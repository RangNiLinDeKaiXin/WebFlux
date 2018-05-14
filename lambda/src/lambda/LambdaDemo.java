package lambda;

/**
 * @author: lcc
 * @Date: 2018-05-11
 **/
public class LambdaDemo {
	public static void main(String[] args) {
		Interface1 i1 = (i) -> i * 2;
		//最常见
		Interface1 i2 = i -> i * 2;

		Interface1 i3 = (int i) -> i * 2;
		//多行
		Interface1 i4 = (int i) -> {
			System.out.println("-----------");
			return i * 2;
		};

		System.out.println(i4.doubleNum(4));
		System.out.println(i4.add(1,5));
	}
}

interface Interface1 {
	int doubleNum(int i);
	default int add(int x,int y){
		return x+y;
	}
}

interface Interface2 {
	int doubleNum(int i);
	default int add(int x,int y){
		return x+y;
	}
}

interface Interface3 extends Interface1,Interface2 {

	@Override
	default int add(int x, int y) {
		return Interface1.super.add(x,y);
	}
}