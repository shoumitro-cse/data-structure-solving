// Elements to be added so that all elements of a range are present in array


import java.io.*; 
import java.util.*; 

public class RangeAdded { 
	
	// Function to count numbers to be added 
	static int countNum(int []arr, int n) { 
		int count = 0;
		// Sort the array 
		Arrays.sort(arr); 
		// Check if elements are consecutive or not. If not, update count 
		for (int i = 0; i < n - 1; i++) {
		   if (arr[i] != arr[i+1] && arr[i] != arr[i + 1] - 1) {
			 count += arr[i + 1] - arr[i] - 1; 
		   }
		}
	  return count; 
	} 
	
	static public void main (String[] args) { 
		int []arr = { 3, 5, 8, 6 }; 
		int n = arr.length; 
		System.out.println(countNum(arr, n)); 
	} 
} 


/*
Elements to be added so that all elements of a range are present in array


Given an array of size N. Let A and B be the minimum and maximum in the array respectively. 
Task is to find how many number should be added to the given array such that all the element 
in the range [A, B] occur at-least once in the array.

Examples:

Input : arr[] = {4, 5, 3, 8, 6}
Output : 1
Only 7 to be added in the list.

Input : arr[] = {2, 1, 3}
Output : 0

*/