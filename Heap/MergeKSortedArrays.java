// Merge k sorted arrays | Set 1


import java.io.*;
import java.util.*;

class MergeKSortedArrays {

	public static void mergeKArrays(int[][] arr, int a, int[] output) {
		int c = 0;
		// traverse the matrix
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < 4; j++)
				output[c++] = arr[i][j];
		}
		// sort the array
		Arrays.sort(output);
	}

	// A utility function to print array elements
	public static void printArray(int[] arr, int size) {
		for (int i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
	}

	public static void main(String[] args) {

		int[][] arr = { 
		               	{ 2, 6, 12, 34 },
						{ 1, 9, 20, 1000 },
						{ 23, 34, 90, 2000 } 
					  };
		int k = 4;
		int n = 3;

		int[] output = new int[n*k];

		mergeKArrays(arr, n, output);

		System.out.println("Merged array is ");
		printArray(output, n*k);
	}
}


/*
Merge k sorted arrays | Set 1


Given k sorted arrays of size n each, merge them and print the sorted output.
Example: 
 

Input: 
k = 3, n = 4 
arr[][] = { {1, 3, 5, 7}, 
{2, 4, 6, 8}, 
{0, 9, 10, 11}} ;
Output: 0 1 2 3 4 5 6 7 8 9 10 11 
Explanation: The output array is a sorted array that contains all the elements of the input matrix. 

Input: 
k = 3, n = 4 
arr[][] = { 
	        {1, 5, 6, 8}, 
			{2, 4, 10, 12}, 
			{3, 7, 9, 11}, 
			{13, 14, 15, 16}
		  } ;

Output: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
Explanation: The output array is a sorted array that contains all the elements of the input matrix. 
 

*/