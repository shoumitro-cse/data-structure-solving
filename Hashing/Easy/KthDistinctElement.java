// Java program to print k-th distinct element in a given array 

import java.util.*; 

class KthDistinctElement { 

	// Returns k-th distinct element in arr. 
	static int printKDistinct(int arr[], int n, int k) {

		//int dist_count = 0; 
		Map <Integer, Integer> h = new HashMap<Integer, Integer> (); 
			
		for (int i = 0; i < n; i++) { 
			if(h.containsKey(arr[i])) 
				h.put(arr[i], h.get(arr[i]) + 1); 
			else
				h.put(arr[i], 1); 
		} 

		// If size of hash is less than k. 
		if (h.size() < k) 
			return -1; 

		// Traverse array again and find k-th element with count as 1. 
		int dist_count = 0; 
		for (int i = 0; i < n; i++) { 
			
			if (h.get(arr[i]) == 1) {
				dist_count++; 
			}

			if (dist_count == k) {
				return arr[i]; 
			}
		} 

		return -1; 
	} 


/*	    // Returns k-th distinct element in arr. 
    static int printKDistinct(int arr[], int n, int k) {

        int dist_count = 0; 
        for (int i = 0; i < n; i++) { 
            // Check if current element is present somewhere else. 
            int j; 
              
            for (j = 0; j < n; j++) {
                if (i != j && arr[j] == arr[i]) {
                    break; 
                }
            }
      
            // If element is unique 
            if (j == n) {
                dist_count++; 
            }
      
            if (dist_count == k) {
                return arr[i]; 
            }
        } 
      
        return -1; 
    } */



	public static void main (String[] args) { 
		int ar[] = {1, 2, 1, 3, 4, 2}; 
		int n = ar.length; 
		System.out.println(printKDistinct(ar, n, 2)); 
	} 
} 


/*
k-th distinct (or non-repeating) element in an array.

Given an integer array, print k-th distinct element in an array. 
The given array may contain duplicates and the output should print 
k-th element among all unique elements. If k is more than number of distinct elements, print -1.

Examples :

Input : arr[] = {1, 2, 1, 3, 4, 2}, 
        k = 2
Output : 4

First non-repeating element is 3
Second non-repeating element is 4

Input : arr[] = {1, 2, 50, 10, 20, 2}, 
        k = 3
Output : 10

Input : {2, 2, 2, 2}, 
        k = 2
Output : -1*/

