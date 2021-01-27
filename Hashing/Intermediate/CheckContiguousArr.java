// Check if array contains contiguous integers with duplicates allowed

//javac -d classes CheckContiguousArr.java  && cd classes && java CheckContiguousArr && cd ..

import java.util.*; 

class CheckContiguousArr { 
	
	static boolean areElementsContiguous(int arr[], int n) { 
		// Sort the array 
		Arrays.sort(arr); // important
		for (int i = 1; i < n; i++) 
			if (arr[i] - arr[i-1] > 1) 
				return false; 
		return true;	 
	} 
	
	public static void main(String[] args) {

		int arr[] = { 5, 2, 3, 6, 4, 4, 6, 6 }; 
		int n = arr.length; 
		
		if (areElementsContiguous(arr, n)) 
			System.out.println("Yes"); 
		else
			System.out.println("No"); 
		
	} 
	
} 


/*
Source: Amazon interview Experience | Set 416.

Check if array contains contiguous integers with duplicates allowed

Given an array of n integers(duplicates allowed). Print “Yes” if it is a set of contiguous 
integers else print “No”.

Examples:

Input : arr[] = {5, 2, 3, 6, 4, 4, 6, 6}
Output : Yes
The elements form a contiguous set of integers
which is {2, 3, 4, 5, 6}.

Input : arr[] = {10, 14, 10, 12, 12, 13, 15}
Output : No
*/

