// Find Sum of all unique sub-array sum for a given array.

import java.util.*;

class SumOfAllUniqueSubarr {

	// function for finding grandSum
	static int findSubarraySum(int []arr, int n) {

		int res = 0;

		// Go through all subarrays, compute sums and count occurrences of sums.
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += arr[j];
				if (m.containsKey(sum)) {
					m.put(sum, m.get(sum) + 1);
				} else {
					m.put(sum, 1);
				}
			}
		}

		// Print all those sums that appear once.
		for (Map.Entry<Integer, Integer> x : m.entrySet()) {
		   if (x.getValue() == 1) {
			 res += x.getKey();
		   }
		}

		return res;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 2, 3, 1, 4 };
		int n = arr.length;
		System.out.println(findSubarraySum(arr, n));
	}
}


/*
Find Sum of all unique sub-array sum for a given array.


Given an array of n-positive elements. The sub-array sum is defined as the sum of all elements of a particular sub-array, the task is to find the sum of all unique sub-array sum. 
Note: Unique Sub-array sum means no other sub-array will have the same sum value. 
Examples:

Input : arr[] = {3, 4, 5} 
Output : 40 
Explanation: All possible unique sub-array with their sum are as: 
(3), (4), (5), (3+4), (4+5), (3+4+5). Here all are unique so required sum = 40
Input : arr[] = {2, 4, 2} 
Output : 12 
Explanation: All possible unique sub-array with their sum are as: 
(2), (4)
*/

