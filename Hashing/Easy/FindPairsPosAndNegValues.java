// Pairs of Positive Negative values in an array

//javac -d classes FindPairsPosAndNegValues.java  && cd classes && java FindPairsPosAndNegValues && cd ..

import java.util.*;

class FindPairsPosAndNegValues {

	// Print pair with negative and positive value 
	static void printPairs(int arr[], int n) { 

		ArrayList<Integer> v = new ArrayList<Integer> (); 
		HashMap<Integer, Integer> cnt = new HashMap<Integer, Integer>(); 

		// For each element of array. 
		for (int i = 0; i < n; i++) { 
			// If element has not encounter early, mark it on cnt array. 
			if (!cnt.containsKey(Math.abs(arr[i]))) {
			    // If seen before, push it in vector (given that elements are distinct) 
				v.add(Math.abs(arr[i])); 
				cnt.put(Math.abs(arr[i]), 0); 
			} 
		} 

		if (v.size() == 0) {
		 return; 
		}

		Collections.sort(v); 
		for (int i = 0; i < v.size(); i++) {
			System.out.print("-" + v.get(i) + " " + v.get(i) + " "); 
		}

	} 

	public static void main(String[] args) { 
		int arr[] = { 4, 8, 9, -4, 1, -1, -8, -9 }; 
		int n = arr.length; 
		printPairs(arr, n); 
		System.out.println();
	}
} 


/*
Pairs of Positive Negative values in an array


Given an array of distinct integers, print all the pairs having positive value and negative value 
of a number that exists in the array. We need to print pairs in order of their occurrences. 
A pair whose any element appears first should be printed first.

Examples:  

Input  :  arr[] = { 1, -3, 2, 3, 6, -1 }
Output : -1 1 -3 3

Input  :  arr[] = { 4, 8, 9, -4, 1, -1, -8, -9 }
Output : -1 1 -4 4 -8 8 -9 9
*/