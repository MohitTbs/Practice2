package quest1;

import java.util.Arrays;
import java.util.Collections;

public class ReverseSortArrray {

	public static void main(String[] args) {

		Integer[] arr = new Integer[] { 29, 4, 35, 15, 7, 42 };

		// Approach 1
//		
//		Arrays.sort(arr, Collections.reverseOrder());
//		
//		System.out.println(Arrays.toString(arr));

		// Approach 2

		int temp;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
		

	}

}
