// Longest subsequence such that difference between adjacents is one | Set 2

// javac -d classes LongestSubsequAdj1.java  && cd classes && java LongestSubsequAdj1 && cd ..

import java.util.*; 

class LongestSubsequAdj1 { 
		
	// function to find longest subsequence such that difference between adjacents is one 
	static int longLenSub(int []arr, int n) { 

		HashMap<Integer, Integer> um = new HashMap<Integer, Integer>(); 		
		// to store the longest length subsequence 
		int longLen = 0;
		// traverse the array elements 
		for (int i = 0; i < n; i++) { 
			// initialize current length for element arr[i] as 0 
			int len = 0; 
			// if 'arr[i]-1' is in 'um' and its length of subsequence is greater than 'len' 
			if (um.containsKey(arr[i]-1) && len < um.get(arr[i]-1)) 
				len = um.get(arr[i]-1); 
			
			// if 'arr[i]+1' is in 'um' and its length of subsequence is greater than 'len'	 
			if (um.containsKey(arr[i] + 1) && len < um.get(arr[i] + 1)) 
				len = um.get(arr[i] + 1); 
			
			// update arr[i] subsequence length in 'um' 
			um. put(arr[i], len + 1); 
			
			// update longest length 
			if (longLen < um.get(arr[i])) 
			  longLen = um.get(arr[i]); 
		} 
			
		// required longest length subsequence 
		return longLen;	 
	} 
		
	public static void main(String[] args) { 
		int[] arr = {1, 2, 3, 4, 5, 3, 2}; 
		int n = arr.length; 
		System.out.println("Longest length subsequence = " + longLenSub(arr, n)); 
	} 
} 

