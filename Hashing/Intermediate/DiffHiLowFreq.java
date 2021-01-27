// Difference between highest and least frequencies in an array

import java.util.*; 

class DiffHiLowFreq { 

	static int findDiff(int arr[], int n) { 
		// sort the array 
		Arrays.sort(arr); 
		int count = 0, max_count = 0, min_count = n; 

		for (int i = 0; i < (n - 1); i++) { 
			// checking consecutive elements 
			if (arr[i] == arr[i + 1]) { 
				count += 1; 
				continue; 
			} else { 
				max_count = Math.max(max_count, count); 
				min_count = Math.min(min_count, count); 
				count = 0; 
			} 
		} 

		return (max_count - min_count); 
	} 

	// Driver program to test above function 
	public static void main(String[] args) 
	{ 

		int arr[] = { 7, 8, 4, 5, 4, 1, 
					1, 7, 7, 2, 5 }; 
		int n = arr.length; 

		System.out.println(findDiff(arr, n)); 
	} 
} 

/*
Difference between highest and least frequencies in an array


Given an array, find the difference between highest occurrence and least occurrence of 
any number in an array

Examples:

Input  : arr[] = [7, 8, 4, 5, 4, 1, 1, 7, 7, 2, 5]
Output : 2
Lowest occurring element (5) occurs once.
Highest occurring element (1 or 7) occurs 3 times

Input  : arr[] = [1, 1, 1, 3, 3, 3]
Output : 0*/