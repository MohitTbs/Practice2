package recursion;

public class RecursionCall {

	public static void main(String[] args) {

		getSum(1);
		
	}
	
	static void getSum(int a) {
		if(a == 10) {
			System.out.println(10);
			return;
		}
		System.out.println(a);
		 getSum(a+1);
	}

}
