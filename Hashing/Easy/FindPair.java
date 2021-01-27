// JAVA Code for Given two unsorted arrays, find all pairs whose sum is x 

//javac -d classes FindPair.java  && cd classes && java FindPair && cd ..

import java.util.*; 

class FindPair { 

	// Function to find all pairs in both arrays 
	// whose sum is equal to given value x 
	public static void findPairs(int arr1[], int arr2[], int n, int m, int x) {
		// Insert all elements of first array in a hash 
		HashMap<Integer, Integer> s = new HashMap<Integer, Integer>(); 

		for (int i = 0; i < n; i++) {
			s.put(arr1[i], 0); 
		}

		for (int j = 0; j < m; j++) {
			if (s.containsKey(x-arr2[j])) {
				System.out.println(x - arr2[j] + " " + arr2[j]); 
			}
		}
	} 


/*   static void findPairs(int arr1[], int arr2[], int n, int m, int x) { 
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < m; j++) 
                if (arr1[i] + arr2[j] == x) 
                    System.out.println(arr1[i] + " "
                                       + arr2[j]); 
    }*/


	/* Driver program to test above function */
	public static void main(String[] args) { 
		int arr1[] = { 1, 0, -4, 7, 6, 4 }; 
		int arr2[] = { 0, 2, 4, -3, 2, 1 }; 
		int x = 8; 

		findPairs(arr1, arr2, arr1.length, arr2.length, x); 
	} 
} 


/*
Asked in: Amazon

Given two unsorted arrays, find all pairs whose sum is x

Given two unsorted arrays of distinct elements, the task is to find all pairs from both arrays whose sum is equal to X.

Examples:

Input :  arr1[] = {-1, -2, 4, -6, 5, 7}
         arr2[] = {6, 3, 4, 0}  
         x = 8
Output : 4 4
         5 3

Input : arr1[] = {1, 2, 4, 5, 7} 
        arr2[] = {5, 6, 3, 4, 8}  
        x = 9
Output : 1 8
         4 5
         5 4*/
