// Maximum length subsequence with difference between adjacent elements as either 0 or 1 | Set 2 

import java.util.HashMap; 

class SubSeqDiff01 
{ 
	
	// function to find maximum length subsequence 
	// with difference between adjacent elements as 
	// either 0 or 1 
	public static int maxLengthSub(int[] arr) { 
		
		// to store the maximum length subsequence 
		int max_val = 0; 
		int start = 0; 
		
		// hash table to map the array element with the 
		// length of the longest subsequence of which 
		// it is a part of and is the last element of 
		// that subsequence 
		HashMap<Integer, Integer> map = new HashMap<>(); 

		// traverse the array elements 
		for (int i = 0; i < arr.length; i++) 
		{ 
			
			// initialize current length 
			// for element arr[i] as 0 
			int temp = 0; 
			if (map.containsKey(arr[i] - 1)) 
			{ 
				temp = map.get(arr[i] - 1); 
			} 

			if (map.containsKey(arr[i])) 
			{ 
				temp = Math.max(temp, map.get(arr[i])); 
			} 
			
			if (map.containsKey(arr[i] + 1)) 
			{ 
				temp = Math.max(temp, map.get(arr[i] + 1)); 
			} 
			temp++; 
			
			// update maximum length 
			if (temp > max_val) 
			{ 
				max_val = temp; 
			} 
			
			map.put(arr[i], temp); 
		} 
		
		// required maximum length subsequence 
		return max_val; 
	} 
	
	// Driver Code 
	public static void main(String[] args) 
	{ 
		int arr[] = {2, 5, 6, 3, 7, 6, 5, 8}; 
		System.out.println(maxLengthSub(arr)); 
	} 
} 

/*
Maximum length subsequence with difference between adjacent elements as either 0 or 1 | Set 2

Given an array of n integers. The problem is to find maximum length of the subsequence with difference between adjacent elements in the subsequence as either 0 or 1. Time Complexity of O(n) is required.

Examples:

Input : arr[] = {2, 5, 6, 3, 7, 6, 5, 8}
Output : 5
The subsequence is {5, 6, 7, 6, 5}.

Input : arr[] = {-2, -1, 5, -1, 4, 0, 3}
Output : 4
The subsequence is {-2, -1, -1, 0}.

*/