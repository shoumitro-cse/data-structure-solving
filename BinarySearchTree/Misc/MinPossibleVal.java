// Minimum Possible value of |ai + aj – k| for given array and k.

import java.util.*; 

class MinPossibleVal { 
	
	// function for finding pairs and min value 
	static void pairs(int arr[], int n, int k) { 
		// initialize smallest and count 
		int smallest = Integer.MAX_VALUE; 
		int count=0; 
		// iterate over all pairs 
		for (int i=0; i<n; i++) 
			for(int j=i+1; j<n; j++) { 
				// is abs value is smaller than smallest update smallest and reset count to 1 
				if ( Math.abs(arr[i] + arr[j] - k) < smallest ) { 
					smallest = Math.abs(arr[i] + arr[j] - k); 
					count = 1; 
				} else if (Math.abs(arr[i] + arr[j] - k) == smallest) {
				   // if abs value is equal to smallest increment count value 
					count++; 
				}
			} 
		// print result 
		System.out.println("Minimal Value = " + smallest); 
		System.out.println("Total Pairs = " + count);	 
	} 
	
	public static void main(String[] args) 
	{ 
		int arr[] = {3, 5, 7, 5, 1, 9, 9}; 
		int k = 12; 
		int n = arr.length; 
		pairs(arr, n, k); 
	} 
} 

/*
Output:
	Minimal Value = 0
	Total Pairs = 4*/

/*
Minimum Possible value of |ai + aj – k| for given array and k.

You are given an array of n integer and an integer K. Find the number of total 
unordered pairs {i, j} such that absolute value of (ai + aj – K), i.e., |ai + aj – k| is minimal possible where i != j.

Examples:

Input : arr[] = {0, 4, 6, 2, 4}, 
            K = 7
Output : Minimal Value = 1
         Total  Pairs = 5 
Explanation : Pairs resulting minimal value are :
              {a1, a3}, {a2, a4}, {a2, a5}, {a3, a4}, {a4, a5} 

Input : arr[] = {4, 6, 2, 4}  , K = 9
Output : Minimal Value = 1
         Total Pairs = 4 
Explanation : Pairs resulting minimal value are :
              {a1, a2}, {a1, a4}, {a2, a3}, {a2, a4} 


*/