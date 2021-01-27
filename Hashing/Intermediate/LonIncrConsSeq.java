// Printing longest Increasing consecutive subsequence

//javac -d classes LonIncrConsSeq.java  && cd classes && java LonIncrConsSeq && cd ..

import java.util.HashMap; 

class LonIncrConsSeq { 

	public static void longestSubsequence(int[] a, int n) { 
		// stores the index of elements 
		HashMap<Integer, Integer> mp = new HashMap<>(); 
		// stores the length of the longest subsequence that ends with a[i] 
		int[] dp = new int[n]; 
		int maximum = Integer.MIN_VALUE; 
		// iterate for all element 
		int index = -1; 
		for(int i = 0; i < n; i++) { 
			// if a[i]-1 is present before i-th index 
			if (mp.get(a[i]-1) != null) { 
				// last index of a[i]-1 
				int lastIndex = mp.get(a[i]-1)-1; 
				// relation 
				dp[i] = 1 + dp[lastIndex]; 
			} else {
				dp[i] = 1; 
			}

			mp.put(a[i], i+1); 

			// stores the longest length 
			if (maximum < dp[i]) { 
				maximum = dp[i]; 
				index = i; 
			} 
		} 

		for (int curr = a[index] - maximum + 1; curr <= a[index]; curr++) {
			System.out.print(curr + " "); 
		}
	} 

	public static void main(String[] args) { 
		int[] a = { 3, 10, 3, 11, 4, 5, 6, 7, 8, 12 }; 
		int n = a.length; 
		longestSubsequence(a, n); 
		System.out.println();
	} 
} 

/*
Printing longest Increasing consecutive subsequence


Given n elements, write a program that prints the longest increasing subsequence whose 
adjacent element difference is one.

Examples:

Input : a[] = {3, 10, 3, 11, 4, 5, 6, 7, 8, 12}
Output : 3 4 5 6 7 8
Explanation: 3, 4, 5, 6, 7, 8 is the longest increasing subsequence whose adjacent 
element differs by one.

Input : a[] = {6, 7, 8, 3, 4, 5, 9, 10}
Output : 6 7 8 9 10
Explanation: 6, 7, 8, 9, 10 is the longest increasing subsequence*/