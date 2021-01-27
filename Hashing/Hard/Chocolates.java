// Maximum number of chocolates to be distributed equally among k students


import java.io.*; 
import java.util.*; 

class Chocolates { 

	// Function to find the maximum number of chocolates to be distributed equally among k students 
	static int maxNumOfChocolates(int arr[], int n, int k) { 

		// Hash table 
		HashMap <Integer,Integer> um = new HashMap<Integer,Integer>(); 
		// 'sum[]' to store cumulative sum, where sum[i] = sum(arr[0]+..arr[i]) 
		int[] sum = new int[n]; 
		int curr_rem; 
		// To store sum of sub-array having maximum sum 
		int maxSum = 0; 

		// Building up 'sum[]' 
		sum[0] = arr[0]; 
		for (int i = 1; i < n; i++) {
		  sum[i] = sum[i - 1] + arr[i]; // increase up sum
		}

		// Traversing 'sum[]' 
		for (int i = 0; i < n; i++) { 
			
			// Finding current remainder 
			curr_rem = sum[i] % k; 
			
			// If true then sum(0..i) is divisible by k 
			if (curr_rem == 0) { 
				// update 'maxSum' 
				if (maxSum < sum[i]) {
				   maxSum = sum[i]; 
				}
			} else if (!um.containsKey(curr_rem) ) {
				um.put(curr_rem , i); 
			} else {
				// If true, then update 'max' 
				if (maxSum < (sum[i] - sum[um.get(curr_rem)])) {
				   maxSum = sum[i] - sum[um.get(curr_rem)]; 
				}
		    }
		} 

		// Required maximum number of chocolates to be distributed equally among 'k' students 
		return (maxSum / k); 
	} 

	public static void main(String[] args) { 
		int arr[] = { 2, 7, 6, 1, 4, 5 }; 
		int n = arr.length; 
		int k = 3; // students
		System.out.println("Maximum number of chocolates: "+ maxNumOfChocolates(arr, n, k)); 
	} 
} 


/*
Source: Asked in Amazon.

Maximum number of chocolates to be distributed equally among k students


Given n boxes containing some chocolates arranged in a row. There are k number of students. The problem is to distribute maximum number of chocolates equally among k students by selecting a consecutive sequence of boxes from the given lot. Consider the boxes are arranged in a row with numbers from 1 to n from left to right. We have to select a group of boxes which are in consecutive order that could provide maximum number of chocolates equally to all the k students. An array arr[] is given representing the row arrangement of the boxes and arr[i] represents number of chocolates in that box at position ‘i’.

Examples:

Input : arr[] = {2, 7, 6, 1, 4, 5}, k = 3
Output : 6
The subarray is {7, 6, 1, 4} with sum 18.
Equal distribution of 18 chocolates among
3 students is 6.
Note that the selected boxes are in consecutive order
with indexes {1, 2, 3, 4}.*/

