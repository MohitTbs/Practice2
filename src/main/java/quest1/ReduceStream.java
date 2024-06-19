package quest1;

import java.util.Arrays;
import java.util.List;

public class ReduceStream {

	static String getString(String s1, String s2) {
		if (s1.length() > s2.length())
			return s1;
		return s2;

	}

	public static void main(String[] args) {

		List<String> l1 = Arrays.asList("Mine", "Car", "Pillow", "Exaggeration", "Excruciating");

		String output = l1.stream().reduce((s1, s2) -> {
			if (s1.length() < s2.length())
				return s1;
			return s2;
		}).get();

		System.out.println(output);

	}

}
