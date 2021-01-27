// Longest subarray having count of 1s one more than count of 0s

import java.util.*; 

class LongSubArrMore1 { 

	// function to find the length of longest subarray having count of 1's one more than count of 0's 
	static int lenOfLongSubarr(int arr[], int n) {
		
		// unordered_map 'um' implemented as hash table 
		HashMap<Integer, Integer> um = new HashMap<Integer, Integer>(); 
		int sum = 0, maxLen = 0; 
		
		// traverse the given array 
		for (int i = 0; i < n; i++) { 
			
			// consider '0' as '-1' 
			sum += arr[i] == 0 ? -1 : 1; 
			
			// when subarray starts form index '0' 
			if (sum == 1) {
				maxLen = i + 1; 
			} else if (!um.containsKey(sum)) {
			    // make an entry for 'sum' if it is not present in 'um' 
			    um. put(sum, i); 
			}
			
			// check if 'sum-1' is present in 'um' or not 
			if (um.containsKey(sum - 1)) { 
				// update maxLength 
				if (maxLen < (i - um.get(sum - 1))) {
					maxLen = i - um.get(sum - 1); 
				}
			} 
		} 

		// required maximum length 
		return maxLen; 
	} 

	public static void main(String[] args) { 
		int arr[] = { 0, 1, 1, 0, 0, 1 }; 
		int n = arr.length; 
		System.out.println("Length = " + lenOfLongSubarr(arr, n)); 
	} 
} 

/*
Longest subarray having count of 1s one more than count of 0s


Given an array of size n containing 0’s and 1’s only. The problem is to find the length of the longest subarray having count of 1’s one more than count of 0’s.

Examples:

Input : arr = {0, 1, 1, 0, 0, 1}
Output : 5
From index 1 to 5.

Input : arr[] = {1, 0, 0, 1, 0}
Output : 1
*/