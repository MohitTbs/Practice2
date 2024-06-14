package quest1;

import java.util.HashSet;
import java.util.Set;

public class ArraySubsetArray {

	public static void main(String[] args) {

		
		int[] ar1 = new int[] { 2, 4, 96, 74, 36};

		int[] ar2 = new int[] { 96, 74, 4};
		
		int m = ar1.length;
		int n = ar2.length;

		// Approach 1
		
//		Set<Integer> s = new HashSet<Integer>();
//		for(int i = 0; i < m; i++) {
//			s.add(ar1[i]);
//		}
//		int p = s.size();
//		
//		for(int i = 0; i < n; i++) {
//			s.add(ar2[i]);
//		}
//		
//		if(s.size() == p) {
//			System.out.println("ar2 is subset of ar1");
//		}
//		else {
//			System.out.println("ar2 is not subset of ar1");
//		}
		
		// Approach 2
		
//		HashSet<Integer> hset =  new HashSet<>();
//		boolean b1 = true;
//		for(int i = 0; i < ar1.length; i++) {
//			hset.add(ar1[i]);
//		}
//		
//		for(int i = 0; i < ar2.length; i++) {
//			if(!hset.contains(ar2[i])) {
//				b1 = false;
//			}
//		}
//		
//		if(b1) {
//			System.out.println("is a subset");
//		}else {
//			System.out.println("is not a subset");
//		}
	}

}
