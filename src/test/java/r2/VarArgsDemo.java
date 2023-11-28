package r2;

public class VarArgsDemo {

	static void printString(String... a) {
		for (String s : a) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {

		// printString("Hello", "784548", "jshdsh4878xu", "KeepItUp");

		String[] as = { "Hello", "784548", "jshdsh4878xu", "KeepItUp" };

		printString(as);
	}

}
