package quest1;

import java.util.Arrays;

public class BinarySearchArray {

	static int binarySearch(int[] arr, int key) {
		// Java implementation of iterative Binary Search
		int l = 0;
		int r = arr.length - 1;
		int m;

		while (l <= r) {
			m = (l + r) / 2;

			if (arr[m] == key) {
				return m;
			} else if (arr[m] > key) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}

		return -1;
	}
	
	

	public static void main(String[] args) {

		int[] array = { 54, 78, 96, 2, 74, 36, 25 };

		Arrays.sort(array);

		for (int k : array) {
			System.out.print(k + " ");
		}
		System.out.println();

		//System.out.println(binarySearch(array, 25));
		
		
		// Using inbuild
		
		System.out.println(Arrays.binarySearch(array, 74));
	}

}
