// Java code to find maximum shortest distance from endpoints 

// javac -d classes ShortestDistance.java  && cd classes && java ShortestDistance && cd ..

import java.util.*; 

class ShortestDistance { 

	static void makePermutation(int []a, int n) {
		// Store counts of all elements. 
		HashMap<Integer, Integer> count = new HashMap<Integer, Integer>(); 
		for (int i = 0; i < n; i++) { 
			if(count.containsKey(a[i])) { 
				count.put(a[i], count.get(a[i]) + 1); 
			} else { 
				count.put(a[i], 1); 
			} 
		} 
	} 

	// function to find maximum shortest distance 
	static int find_maximum(int a[], int n, int k) {
		// stores the shortest distance of every element in original array. 
		HashMap<Integer, Integer> b = new HashMap<Integer, Integer>(); 
		
		for (int i = 0; i < n; i++) { 
			int x = a[i]; 
			// shortest distance from ends 
			int d = Math.min(1+i, n-i); 
			if (!b.containsKey(x)) {
				b.put(x, d); 
			} else { 
				b.put(x, Math.min(d, b.get(x))); 
			} 
		} 
		
		int ans = Integer.MAX_VALUE; 
		for (int i = 0; i < n; i++) { 
			int x = a[i]; 
			// similar elements ignore them cause we need distinct elements 
			if (x != k-x && b.containsKey(k-x))	{	 
			  ans = Math.min(Math.max(b.get(x), b.get(k-x)), ans);	
			} 
		} 

		return ans; 
	} 

	public static void main(String[] args) {
		
		int a[] = { 3, 5, 8, 6, 7 }; 
		int K = 11; 
		int n = a.length; 
		
		System.out.println(find_maximum(a, n, K)); 

	} 
} 

/*
Pair with given sum and maximum shortest distance from end


Given an array of N integers and an integer K, pick two distinct elements 
whose sum is K and find the maximum shortest distance of the picked elements from the endpoints.

Examples:

Input : a[] = {2, 4, 3, 2, 1}, k = 5.
Output :  2
Explanation:
Select the pair(4, 1). 
Shortest distance of 4 from ends = 2
Shortest distance of 1 from ends = 1
Hence, answer is max(2, 1) = 2      

Input : a[] = {2, 4, 1, 9, 5}, k = 3
Output : 3
Explanation:
Select the pair (2, 1)
Shortest distance of 2 from ends = 1
Shortest distance of 1 from ends = 3
Hence, answer is max(1, 3) = 3. */