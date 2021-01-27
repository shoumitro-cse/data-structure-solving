
/* Java program to Check if a given array contains duplicate 
elements within k distance from each other */

//javac -d classes ArrContainDupKDist.java  && cd classes && java ArrContainDupKDist && cd ..

import java.util.*; 

class ArrContainDupKDist {

	static boolean checkDuplicatesWithinK(int arr[], int k) { 
		
		// Creates an empty hashset 
		HashSet<Integer> set = new HashSet<>(); 
		
		// Traverse the input array 
		for (int i=0; i < arr.length; i++) { 
			
			// If already present n hash, then we found a duplicate within k distance 
			if (set.contains(arr[i])) {
			  return true; 
			}
			
			// Add this item to hashset 
			set.add(arr[i]); 

			// Remove the k+1 distant item 
			if (i >= k) {
			  set.remove(arr[i-k]); 
			}

		} 

		return false; 
	} 

	public static void main (String[] args) {

		int arr[] = {10, 5, 3, 4, 3, 5, 6}; 
		
		if (checkDuplicatesWithinK(arr, 3)) {
		  System.out.println("Yes"); 
		} else {
		  System.out.println("No");
		}

	} 
}


/*
Check if a given array contains duplicate elements within k distance from each other


Given an unsorted array that may contain duplicates. Also given a number k which is smaller 
than size of array. Write a function that returns true if array contains duplicates 
within k distance.

Examples:

Input: k = 3, arr[] = {1, 2, 3, 4, 1, 2, 3, 4}
Output: false
All duplicates are more than k distance away.

Input: k = 3, arr[] = {1, 2, 3, 1, 4, 5}
Output: true
1 is repeated at distance 3.

Input: k = 3, arr[] = {1, 2, 3, 4, 5}
Output: false

Input: k = 3, arr[] = {1, 2, 3, 4, 4}
Output: true
*/
