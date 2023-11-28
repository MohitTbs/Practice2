package recursion;

public class factorial {

	static int f = 1;

	public static void main(String[] args) {
		System.out.println(getFactorial(5));

	}

	static int getFactorial(int a) {
		if (a == 0) {
			return f;
		}
		
		f = f * a;
		getFactorial(a - 1);
		return f;

	}
}
