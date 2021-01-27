// Java program to find longest subarray with k or less distinct elements. 

import java.util.*; 

class LongestSubarray {

	// function to print the longest sub-array 
	static void longest(int a[], int n, int k) { 

		int[] freq = new int[7]; 
		int start = 0, end = 0, now = 0, l = 0; 
		
		for (int i = 0; i < n; i++) { 
			
			// mark the element visited 
			freq[a[i]]++; 

			// if its visited first time, then increase the counter of distinct elements by 1 
			if (freq[a[i]] == 1) {
			   now++; 
			}

			// When the counter of distinct elements increases from k, then reduce it to k 
			while (now > k) { 
				// from the left, reduce the number of time of visit 
				freq[a[l]]--; 
				// if the reduced visited time element is not present in further segment 
				// then decrease the count of distinct elements 
				if (freq[a[l]] == 0) 
					now--; 
				// increase the subsegment mark 
				l++; 
			} 

			// check length of longest sub-segment when greater then previous best then change it 
			if (i - l + 1 >= end - start + 1) { 
				end = i; 
				start = l; 
			} 
		} 

		// print the longest sub-segment 
		for (int i = start; i <= end; i++) {
			System.out.print(a[i]+" "); 
		}

	} 

	public static void main(String args[]) { 
		int a[] = { 6, 5, 1, 2, 3, 2, 1, 4, 5 }; 
		int n = a.length; 
		int k = 3; 
		longest(a, n, k); 
	} 
} 


/*
Longest subarray not having more than K distinct elements


Given N elements and a number K, find the longest subarray which has not more 
than K distinct elements.(It can have less than K)

Examples:

Input : arr[] = {1, 2, 3, 4, 5}
            k = 6 
Output : 1 2 3 4 5 
Explanation: The whole array has only 5 
distinct elements which is less than k, 
so we print the array itself.

Input: arr[] = {6, 5, 1, 2, 3, 2, 1, 4, 5}
           k = 3
Output: 1 2 3 2 1, 
The output is the longest subarray with 3
distinct elements.

*/