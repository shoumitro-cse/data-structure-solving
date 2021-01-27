// Java program to count pairs whose product exist in array 

//javac -d classes CountPairsProduct.java  && cd classes && java CountPairsProduct && cd ..

import java.io.*; 

class CountPairsProduct 
{ 
	
	// Returns count of pairs 
	// whose product exists in arr[] 
	static int countPairs(int arr[], int n) 
	{ 
		int result = 0; 
		for (int i = 0; i < n ; i++) { 
			for (int j = i + 1 ; j < n ; j++) { 
				int product = arr[i] * arr[j] ; 
				// find product in an array 
				for (int k = 0; k < n; k++) { 
					// if product found increment counter 
					if (arr[k] == product) { 
						result++; 
						break; 
					} 
				} 
			} 
		} 

		// return Count of all pair whose product exist in array 
		return result; 
	} 

	public static void main (String[] args) { 
		int arr[] = {6, 2, 4, 12, 5, 3} ; 
		int n = arr.length; 
		System.out.println(countPairs(arr, n)); 
	} 
} 




/*
Count pairs whose products exist in array

Given an array, count those pair whose product value is present in array.

Examples:

Input : arr[] = {6, 2, 4, 12, 5, 3}
Output : 3
       All pairs whose product exist in array 
       (6 , 2) (2, 3) (4, 3)   

Input :  arr[] = {3, 5, 2, 4, 15, 8}
Output : 2 
*/

