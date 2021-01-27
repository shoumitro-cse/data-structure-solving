// find Non-overlapping sum 

import java.io.*; 
import java.util.*; 

class NonOverlappingSum { 

	// function for calculating Non-overlapping sum of two array 
	static int findSum(int[] A, int[] B, int n) { 
		
		// Insert elements of both arrays 
		HashMap<Integer, Integer> hash = new HashMap<>(); 
		for (int i = 0; i < n; i++) {

			if (hash.containsKey(A[i])) 
				hash.put(A[i], 1 + hash.get(A[i])); 
			else
				hash.put(A[i], 1); 

			if (hash.containsKey(B[i])) 
				hash.put(B[i], 1 + hash.get(B[i])); 
			else
				hash.put(B[i], 1); 
		} 

		// calculate non-overlapped sum 
		int sum = 0; 
		for (Map.Entry entry : hash.entrySet()) { 

			if (Integer.parseInt((entry.getValue()).toString()) == 1) {
				sum += Integer.parseInt((entry.getKey()).toString()); 
			}
		} 

		return sum; 

	} 

	public static void main(String args[]) {

		int[] A = { 5, 4, 9, 2, 3 }; 
		int[] B = { 2, 8, 7, 6, 3 }; 

		// size of array 
		int n = A.length; 

		// function call 
		System.out.println(findSum(A, B, n)); 
	} 
} 


/*
Non-overlapping sum of two sets


Given two arrays A[] and B[] of size n. It is given that both array individually 
contains distinct elements. We need to find the sum of all elements that are not common.

Examples:

Input : A[] = {1, 5, 3, 8}
        B[] = {5, 4, 6, 7}
Output : 29
1 + 3 + 4 + 6 + 7 + 8 = 29

Input : A[] = {1, 5, 3, 8}
        B[] = {5, 1, 8, 3}
Output : 0
All elements are common.
*/