// Java implementation to find the longest subarray with sum divisible by k 

//javac -d classes LongestSubArr.java  && cd classes && java LongestSubArr && cd ..

import java.io.*; 
import java.util.*; 

class LongestSubArr { 
		
	// function to find the longest subarray with sum divisible by k 
	static int longSubarrWthSumDivByK(int arr[], int n, int k) { 
		// unodered map 'um' implemented as hash table 
		HashMap<Integer, Integer> um= new HashMap<Integer, Integer>(); 
		// 'mod_arr[i]' stores (sum[0..i] % k) 
		int mod_arr[]= new int[n]; 
		int max = 0; 
		int curr_sum = 0; 
		
		// traverse arr[] and build up the array 'mod_arr[]' 
		for (int i = 0; i < n; i++) { 
			curr_sum += arr[i]; 
			// as the sum can be negative, taking modulo twice 
			mod_arr[i] = ((curr_sum % k) + k) % k;	 
		} 
		
		for (int i = 0; i < n; i++) { 
			// if true then sum(0..i) is divisible by k 
			if (mod_arr[i] == 0) {
				// update 'max' 
				max = i + 1; 
			} else if (um.containsKey(mod_arr[i]) == false) {
				um.put(mod_arr[i] , i); 
			} else {
			  // if true, then update 'max' 
			  if (max < (i-um.get(mod_arr[i]))) {
				max = i-um.get(mod_arr[i]);	
			  }
			}	 
		} 
		
		// required length of longest subarray with sum divisible by 'k' 
		return max; 
	}	 
	
	public static void main (String[] args) { 
		
		int arr[] = {2, 7, 6, 1, 4, 5}; 
		int n = arr.length; 
		int k = 3; 
		
		System.out.println("Length = "+ longSubarrWthSumDivByK(arr, n, k)); 
		
	} 
} 



/*
Longest subarray with sum divisible by k

Given an arr[] containing n integers and a positive integer k. The problem is to find the 
length of the longest subarray with sum of the elements divisible by the given value k.
Examples:

Input : arr[] = {2, 7, 6, 1, 4, 5}, k = 3
Output : 4
The subarray is {7, 6, 1, 4} with sum 18,
which is divisible by 3.

Input : arr[] = {-2, 2, -5, 12, -11, -1, 7}
Output : 5

*/