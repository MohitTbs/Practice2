package quest1;

public class ReturnIf {

	static int k = 4;

	static void m1() {

		if (k == 5) {
			System.out.println("k");
			return;
		}

		System.out.println("After if");
	}

	static int m2() {

		try {
			System.out.println("Inside try");
			return 20;
		} catch (Exception e) {
			System.out.println("Inside catch");
			return 30;
		} finally {
			System.out.println("Inside finally");
		}
	}

	public static void main(String[] args) {

		//m1();
		System.out.println(m2());
		
	}

}
