package quest1;

public class Fibo {

	static int n1 = 0, n2 = 1, n3;

	static void printFibo(int count) {
		// To print the series up to given count

		for (int i = 2; i < count; i++) {
			n3 = n1 + n2;
			System.out.print(" " + n3);
			n1 = n2;
			n2 = n3;
		}
	}

	static void printFiboRecursion(int count) {

		if (count > 0) {
			n3 = n2 + n1;
			n1 = n2;
			n2 = n3;

			System.out.print(" " + n3);
			printFibo(count - 1);
		}
	}

	static int FiboRecu(int n) {

		if (n <= 1) {
			return n;
		}

		return FiboRecu(n - 1) + FiboRecu(n - 2);
	}

	public static void main(String[] args) {

		System.out.print(n1 + " " + n2);
//		printFibo(10);
//		printFiboRecursion(10);

		for (int i = 0; i < 4; i++) {
			System.out.print(FiboRecu(i) + " ");
		}
	}

}
