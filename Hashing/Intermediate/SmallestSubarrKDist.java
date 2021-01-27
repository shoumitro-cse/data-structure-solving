// Smallest subarray with k distinct numbers


import java.util.*;

class SmallestSubarrKDist {
		
	static void minRange(int arr[], int n, int k) {
		int l = 0, r = n;
		// Consider every element as starting point.
		for (int i = 0; i < n; i++) {
			Set<Integer> s = new HashSet<Integer>();
			int j;
			for (j = i; j < n; j++) {
				s.add(arr[j]);
				if (s.size() == k) {
					if ((j - i) < (r - l)) {
						r = j;
						l = i;
					}
					break;
				}
			}

			if (j == n) {
				break;
			}

		}

		if (l == 0 && r == n)
			System.out.println("Invalid k");
		else
			System.out.println(l + " " + r);
	}

	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int n = arr.length;
		int k = 3;
		minRange(arr, n, k);
	}
}



/*Smallest subarray with k distinct numbers


We are given an array consisting of n integers and an integer k. We need to find the 
minimum range in array [l, r] (both l and r are inclusive) such that there are exactly 
k different numbers. 
Examples: 

Input : arr[] = { 1, 1, 2, 2, 3, 3, 4, 5} 
            k = 3
Output : 5 7

Input : arr[] = { 1, 2, 2, 3} 
            k = 2
Output : 0 1

*/