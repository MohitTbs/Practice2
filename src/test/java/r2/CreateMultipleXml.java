package r2;

public class CreateMultipleXml {

	public static void main(String[] args) {

		int k;

		String st1 = "";
		for (k = 1; k <= 10; k++) {
			String st = "<test name=\"Test" + k + "\" >\r\n" + "		<classes > \r\n"
					+ "			<class name=\"r2.LoadTheSite\" />\r\n" + "		</classes>\r\n" + "	</test> ";
			st1 = st1 + "\n\n" + st;
		}

		System.out.println(st1);
	}

}
