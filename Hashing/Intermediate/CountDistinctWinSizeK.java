// Count distinct elements in every window of size k
 

import java.util.Arrays; 

class CountDistinctWinSizeK { 

	// Counts distinct elements in window of size k 
	static int countWindowDistinct(int win[], int k) {
		int dist_count = 0; 
		// Traverse the window 
		for (int i = 0; i < k; i++) { 
			
			// Check if element arr[i] exists in arr[0..i-1] 
			int j; 
			for (j = 0; j < i; j++) {
			  if (win[i] == win[j]) {
				break; 
			  }
			}

			if (j == i) {
				dist_count++; 
			}
		} 
		return dist_count; 
	} 

	// Counts distinct elements in all windows of size k 
	static void countDistinct(int arr[], int n, int k) { 
		// Traverse through every window 
		for (int i = 0; i <= n-k; i++) {
			System.out.println(countWindowDistinct(Arrays.copyOfRange(arr, i, arr.length), k)); 
		}
	} 

	public static void main(String args[]) { 
		int arr[] = { 1, 2, 1, 3, 4, 2, 3 }, k = 4; 
		countDistinct(arr, arr.length, k); 
	} 

} 

/*
Count distinct elements in every window of size k


Given an array of size n and an integer k, return the count of distinct numbers in all 
windows of size k.
Example:

Input: arr[] = {1, 2, 1, 3, 4, 2, 3};
       k = 4
Output: 3 4 4 3

Explanation:
First window is {1, 2, 1, 3}, count of distinct numbers is 3
Second window is {2, 1, 3, 4} count of distinct numbers is 4
Third window is {1, 3, 4, 2} count of distinct numbers is 4
Fourth window is {3, 4, 2, 3} count of distinct numbers is 3

Input: arr[] = {1, 2, 4, 4};
       k = 2
Output: 2 2 1

Explanation:
First window is {1, 2}, count of distinct numbers is 2
First window is {2, 4}, count of distinct numbers is 2
First window is {4, 4}, count of distinct numbers is 1
*/