// Java implementation to find length of longest strict bitonic subsequence 

//javac -d classes BitonicSubsequence.java  && cd classes && java BitonicSubsequence && cd ..

import java.util.*; 

class BitonicSubsequence { 
	
	// function to find length of longest strict bitonic subsequence 
	static int longLenStrictBitonicSub(int arr[], int n) { 

		HashMap<Integer, Integer> inc = new HashMap<Integer, Integer> (); 
		HashMap<Integer, Integer> dcr = new HashMap<Integer, Integer> (); 
		
		int len_inc[] = new int[n]; 
		int len_dcr[] = new int[n]; 
		
		// to store the length of longest strict bitonic subsequence 
		int longLen = 0; 
		
		// traverse the array elements from left to right 
		for (int i = 0; i < n; i++) { 
			// initialize current length for element arr[i] as 0 
			int len = 0; 
				
			// if 'arr[i]-1' is in 'inc' 
			if (inc.containsKey(arr[i] - 1)) 
				len = inc.get(arr[i] - 1); 
				
			// update arr[i] subsequence length in 'inc' and in len_inc[] 
			len_inc[i] = len + 1; 
			inc.put(arr[i], len_inc[i]); 
		} 
		
		// traverse the array elements from right to left 
		for (int i = n - 1; i >= 0; i--) { 
			// initialize current length 
			// for element arr[i] as 0 
			int len = 0; 
				
			// if 'arr[i]-1' is in 'dcr' 
			if (dcr.containsKey(arr[i] - 1)) 
				len = dcr.get(arr[i] - 1); 
				
			// update arr[i] subsequence length in 'dcr' and in len_dcr[] 
			len_dcr[i] = len + 1; 
			dcr.put(arr[i], len_dcr[i]); 
		} 
		
		// calculating the length of all the strict bitonic subsequence 
		for (int i = 0; i < n; i++) {
			if (longLen < (len_inc[i] + len_dcr[i] - 1)) {
				longLen = len_inc[i] + len_dcr[i] - 1; 
			}
		}
			
		// required longest length strict bitonic subsequence 
		return longLen;	 
	} 
		
	public static void main(String[] args) 
	{ 
		int arr[] = {1, 5, 2, 3, 4, 5, 3, 2}; 
		int n = arr.length; 
		System.out.println("Longest length strict bitonic subsequence = " + longLenStrictBitonicSub(arr, n)); 
	} 
} 

/*
Length of longest strict bitonic subsequence


Given an array arr[] containing n integers. The problem is to find the length of the 
longest strict bitonic subsequence. A subsequence is called strict bitonic if it is first 
increasing and then decreasing with the condition that in both the increasing and decreasing 
parts the absolute difference between adjacents is 1 only. A sequence, sorted in increasing order 
is considered Bitonic with the decreasing part as empty. Similarly, decreasing order sequence is 
considered Bitonic with the increasing part as empty.

Examples:

Input : arr[] = {1, 5, 2, 3, 4, 5, 3, 2}
Output : 6
The Longest Strict Bitonic Subsequence is:
{1, 2, 3, 4, 3, 2}.

Input : arr[] = {1, 2, 5, 3, 6, 7, 4, 6, 5}
Output : 5

*/