//Find sum of non-repeating (distinct) elements in an array

//javac -d classes SumDistinctEle.java  && cd classes && java SumDistinctEle && cd ..

import java.util.Arrays; 

// Java Find the sum of all non-repeated elements in an array 
public class SumDistinctEle { 

   // Find the sum of all non-repeated elements in an array 
	static int findSum(int arr[], int n) { 
		// sort all elements of array 
		Arrays.sort(arr); 
		
		int sum = arr[0]; 
		for (int i = 0; i < n-1; i++) { 
			if (arr[i] != arr[i+1]) { 
				sum = sum + arr[i+1]; 
			} 
		} 
		return sum; 
	} 

	public static void main(String[] args) { 
		int arr[] = {1, 2, 3, 1, 1, 4, 5, 6}; 
		int n = arr.length; 
		System.out.println(findSum(arr, n)); 

	} 
} 



/*
Find sum of non-repeating (distinct) elements in an array


Given an integer array with repeated elements, the task is to find sum of all distinct elements in array.

Examples:

Input  : arr[] = {12, 10, 9, 45, 2, 10, 10, 45,10};
Output : 78
Here we take 12, 10, 9, 45, 2 for sum
because it's distinct elements 

Input : arr[] = {1, 10, 9, 4, 2, 10, 10, 45 , 4};
Output : 71

*/