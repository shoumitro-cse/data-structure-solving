// Check if two arrays are equal or not

//javac -d classes FindEleThatNotExist2Arr.java  && cd classes && java FindEleThatNotExist2Arr && cd ..

import java.io.*;
import java.util.*;

class CheckTwoArraysEqualOrNot {
	
	// Returns true if arr1[0..n-1] and arr2[0..m-1] contain same elements.
	public static boolean areEqual(int arr1[], int arr2[]) {
		
		// Length of the two array
		int n = arr1.length;
		int m = arr2.length;
		
		// If lengths of arrays are not equal
		if (n != m) {
			return false;
		}
			
		// To store xor of both arrays
		int b1 = arr1[0];
		int b2 = arr2[0];
		
		// Find xor of each elements in array
		for(int i = 1; i < n; i++) {
			b1 ^= arr1[i];
		}

		for(int i = 1; i < m; i++) {
			b2 ^= arr2[i];
		}

		int all_xor = b1 ^ b2;
		
		// If xor is zero means they are equal (5^5=0)
		if (all_xor == 0) {
			return true;
		}
			
		// If all elements were not same, then xor will not be zero
		return false;
	}

	// Driver code
	public static void main(String[] args)
	{
		int arr1[] = { 3, 5, 2, 5, 2 };
		int arr2[] = { 2, 3, 5, 5, 2 };
		
		// Function call
		if (areEqual(arr1, arr2))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}

/*

Check if two arrays are equal or not


Given two given arrays of equal length, the task is to find if given arrays are equal or not. Two arrays are said to be equal if both of them contain the same set of elements, arrangements (or permutation) of elements may be different though.

Note: If there are repetitions, then counts of repeated elements must also be the same for two arrays to be equal. 

Examples : 

Input  : arr1[] = {1, 2, 5, 4, 0};
         arr2[] = {2, 4, 5, 0, 1}; 
Output : Yes

Input  : arr1[] = {1, 2, 5, 4, 0, 2, 1};
         arr2[] = {2, 4, 5, 0, 1, 1, 2}; 
Output : Yes
 
Input : arr1[] = {1, 7, 1};
        arr2[] = {7, 7, 1};
Output : No

*/