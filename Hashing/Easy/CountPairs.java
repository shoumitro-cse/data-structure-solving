// Count pairs from two sorted arrays whose sum is equal to a given value x

//javac -d classes CountPairs.java  && cd classes && java CountPairs && cd ..

import java.io.*; 

class CountPairs { 
		
	// function to count all pairs from both the sorted arrays whose sum is equal to a given value 
	static int countPairs(int []arr1, int []arr2, int m, int n, int x) {
		int count = 0; 	
		// generating pairs from both the arrays 
		for (int i = 0; i < m; i++) {
		  for (int j = 0; j < n; j++) {
			// if sum of pair is equal to 'x' increment count 
			if ((arr1[i] + arr2[j]) == x) {
				count++; 
			}
		  }
		}
		// required count of pairs 
		return count; 
	} 
	
	public static void main (String[] args) { 
		int arr1[] = {1, 3, 5, 7}; 
		int arr2[] = {2, 3, 5, 8}; 
		int m = arr1.length; 
		int n = arr2.length; 
		int x = 10; 
		
		System.out.println( "Count = "+ countPairs(arr1, arr2, m, n, x)); 
	} 
} 

/*Count pairs from two sorted arrays whose sum is equal to a given value x

Given two sorted arrays of size m and n of distinct elements. Given a value x. The problem is to count all pairs from both arrays whose sum is equal to x.
Note: The pair has an element from each array.

Examples :

Input : arr1[] = {1, 3, 5, 7}
        arr2[] = {2, 3, 5, 8}
        x = 10

Output : 2
The pairs are:
(5, 5) and (7, 3)

Input : arr1[] = {1, 2, 3, 4, 5, 7, 11} 
        arr2[] = {2, 3, 4, 5, 6, 8, 12} 
        x = 9

Output : 5
*/


