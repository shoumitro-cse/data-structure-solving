// Java code to calculate maximum unique element of every segment of array 

import java.io.*; 
import java.util.*; 

class UniqueElement { 

	static void find_max(int[] A, int N, int K) 
	{ 
		// Storing counts of first K-1 elements 
		// Also storing distinct elements. 
		HashMap<Integer, Integer> Count = new HashMap<>(); 
		for (int i = 0; i < K-1; i++) 
			if (Count.containsKey(A[i])) 
				Count.put(A[i], 1+Count.get(A[i])); 
			else
				Count.put(A[i], 1); 

		TreeSet<Integer> Myset = new TreeSet<Integer>(); 
		for (Map.Entry x : Count.entrySet()) { 
			if (Integer.parseInt(String.valueOf(x.getValue())) == 1) 
				Myset.add(Integer.parseInt(String.valueOf(x.getKey()))); 
		} 

		for (int i = K-1; i < N; i++) { 

			// Process K-th element of current window 
			if (Count.containsKey(A[i])) 
				Count.put(A[i], 1 + Count.get(A[i])); 
			else
				Count.put(A[i], 1); 

			if (Integer.parseInt(String.valueOf(Count.get(A[i]))) == 1) 
				Myset.add(A[i]); 
			else
				Myset.remove(A[i]); 

			if (Myset.size() == 0) 
				System.out.println("Nothing"); 
			else
				System.out.println(Myset.last()); 

			// Remove first element of current window before next iteration. 
			int x = A[i-K+1]; 
			Count.put(x, Count.get(x)-1); 

			if (Integer.parseInt(String.valueOf(Count.get(x))) == 1) 
				Myset.add(x); 

			if (Integer.parseInt(String.valueOf(Count.get(x))) == 0) 
				Myset.remove(x); 
		} 
	} 

	// Driver code 
	public static void main(String args[]) 
	{ 
		int[] a = { 1, 2, 2, 3, 3 }; 
		int n = a.length; 
		int k = 3; 
		find_max(a, n, k); 
	} 
} 

/*
Maximum Unique Element in every subarray of size K

Given an array and an integer K. We need to find the maximum of every segment of length K which has no duplicates in that segment.

Examples:

Input : a[] = {1, 2, 2, 3, 3}, 
          K = 3.
Output : 1 3 2
For segment (1, 2, 2), Maximum = 1.
For segment (2, 2, 3), Maximum = 3.
For segment (2, 3, 3), Maximum = 2. 

Input : a[] = {3, 3, 3, 4, 4, 2},
          K = 4.
Output : 4 Nothing 3

*/