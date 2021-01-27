// Java Program to convert an Array to reduced form 

//javac -d classes ArraytoReducedForm.java  && cd classes && java ArraytoReducedForm && cd ..

import java.util.*; 

class ArraytoReducedForm { 

	public static void convert(int arr[], int n) { 
		
		// Create a temp array and copy contents of arr[] to temp 
		int temp[] = arr.clone(); 
		
		// Sort temp array 
		Arrays.sort(temp); 

		// Create a hash table. 
		HashMap<Integer, Integer> umap = new HashMap<>(); 
		
		// One by one insert elements of sorted temp[] and assign them values from 0 to n-1 
		int val = 0; 
		for (int i = 0; i < n; i++) {
			umap.put(temp[i], val++); 
		}

		// Convert array by taking positions from umap 
		for (int i = 0; i < n; i++) {
			arr[i] = umap.get(arr[i]); 
		}
	} 

	public static void printArr(int arr[], int n) { 
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " "); 
		}
	} 

	public static void main(String[] args) { 

		int arr[] = {10, 20, 15, 12, 11, 50}; 
		int n = arr.length; 

		System.out.println("Given Array is "); 
		printArr(arr, n); 

		convert(arr , n); 

		System.out.println("\n\nConverted Array is "); 
		printArr(arr, n); 
		System.out.println(); 

	} 
} 

/*
Convert an array to reduced form | Set 1 (Simple and Hashing)

Given an array with n distinct elements, convert the given array to a form where all 
elements are in range from 0 to n-1. The order of elements is same, i.e., 0 is placed 
in place of smallest element, 1 is placed for second smallest element, … n-1 is placed 
for largest element.

Input:  arr[] = {10, 40, 20}
Output: arr[] = {0, 2, 1}

Input:  arr[] = {5, 10, 40, 30, 20}
Output: arr[] = {0, 1, 4, 3, 2}

Expected time complexity is O(n Log n).
*/
