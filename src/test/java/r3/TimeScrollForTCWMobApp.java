package r3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimeScrollForTCWMobApp {

	public static void main(String[] args) {

		List<Integer> hours = new ArrayList<Integer>(Arrays.asList(12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
		int input = 7;

		int dest = 12;

		if (dest == 12 && input == 12) {
			System.out.println("Already on 12");
		} else if (dest == 12) {
			int index = hours.indexOf(input);
			for (int i = index - 1; i >= 0; i--) {
				System.out.println(hours.get(i));
			}
		} else if (input < dest) {
			int index1 = hours.indexOf(input);
			int index2 = hours.indexOf(dest);
			for (int i = index1; i <= index2; i++) {
				System.out.println(hours.get(i));
			}
		} else if (dest < input) {
			int index1 = hours.indexOf(input);
			int index2 = hours.indexOf(dest);
			for (int i = index1; i >= index2; i--) {
				System.out.println(hours.get(i));
			}
		}

	}

}
