//Maximum area rectangle by picking four sides from array

// finding maximum area possible of a rectangle 


//javac -d classes FindMaxAreaPossRect.java  && cd classes && java FindMaxAreaPossRect && cd ..

import java.util.Arrays; 
import java.util.Collections; 

public class FindMaxAreaPossRect {

	// function for finding max area 
	static int findArea(Integer arr[], int n) {
		
		// sort array in non-increasing order 
		Arrays.sort(arr, Collections.reverseOrder());
		
		// Initialize two sides of rectangle 
		int[] dimension = { 0, 0 }; 
		
		// traverse through array 
		for (int i = 0, j = 0; i < n - 1 && j < 2; i++) {
			// if any element occurs twice store that as dimension 
			if (arr[i] == arr[i + 1]) {
			   dimension[j++] = arr[i++]; 
			   // System.out.println(Arrays.toString(dimension));
			}
	    }

		// return the product of dimensions 
		return (dimension[0] * dimension[1]); 
	} 
	
	public static void main(String args[]) { 
		Integer arr[] = { 4, 2, 1, 4, 6, 6, 2, 5 }; 
		int n = arr.length; 
		System.out.println(findArea(arr, n)); 
	} 
} 


/*
Maximum area rectangle by picking four sides from array


Given an array of n positive integers that represent lengths. Find out the maximum possible 
area whose four sides are picked from given array. Note that a rectangle can only be formed 
if there are two pairs of equal values in given array.

Examples:

Input : arr[] = {2, 1, 2, 5, 4, 4}
Output : 8
Explanation : Dimension will be 4 * 2

Input : arr[] = {2, 1, 3, 5, 4, 4}
Output : 0
Explanation : No rectangle possible
*/