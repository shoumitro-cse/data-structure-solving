// Given an array A[] and a number x, check for pair in A[] with sum as x

//javac -d classes PairSum.java  && cd classes && java PairSum && cd ..

import java.io.*;
import java.util.HashSet;

// Complexity Analysis:  

// Time Complexity: O(n). 
// As the whole array is needed to be traversed only once.
// Auxiliary Space: O(n). 
// As a hash map has been used to store array elements.

class PairSum {

	static void printpairs(int arr[], int sum) {

		HashSet<Integer> s = new HashSet<Integer>();

		for (int i = 0; i < arr.length; ++i) {
			int temp = sum - arr[i];
			// checking for condition
			if (s.contains(temp)) {
				System.out.println("Pair with given sum "+ sum + " is (" + arr[i]+ ", " + temp + ")");
			}

			s.add(arr[i]);
		}
	}

	public static void main(String[] args) {
		int A[] = { 1, 4, 45, 6, 10, 8 };
		int n = 16;
		printpairs(A, n);
	}
}


/*Given an array A[] and a number x, check for pair in A[] with sum as x


Write a program that, given an array A[] of n numbers and another number x, determines 
whether or not there exist two elements in S whose sum is exactly x. 
Examples: 

Input: arr[] = {0, -1, 2, -3, 1}
        sum = -2
Output: -3, 1
If we calculate the sum of the output,
1 + (-3) = -2

Input: arr[] = {1, -2, 1, 0, 5}
       sum = 0
Output: -1
No valid pair exists.*/





/*// Java program to check if given array
// has 2 elements whose sum is equal
// to the given value
import java.util.*;

class PairSum {
	// Function to check if array has 2 elements
	// whose sum is equal to the given value
	static boolean hasArrayTwoCandidates(
		int A[],
		int arr_size, int sum)
	{
		int l, r;

		 Sort the elements 
		Arrays.sort(A);

		 // Now look for the two candidates in the sorted array
		l = 0;
		r = arr_size - 1;
		while (l < r) {
			if (A[l] + A[r] == sum)
				return true;
			else if (A[l] + A[r] < sum)
				l++;
			else // A[i] + A[j] > sum
				r--;
		}
		return false;
	}

	// Driver code
	public static void main(String args[])
	{
		int A[] = { 1, 4, 45, 6, 10, -8 };
		int n = 16;
		int arr_size = A.length;

		// Function calling
		if (hasArrayTwoCandidates(A, arr_size, n))
			System.out.println("Array has two "
							+ "elements with given sum");
		else
			System.out.println("Array doesn't have "
							+ "two elements with given sum");
	}
}


// Complexity Analysis:  

// Time Complexity: Depends on what sorting algorithm we use. 
// If Merge Sort or Heap Sort is used then (-)(nlogn) in worst case.
// If Quick Sort is used then O(n^2) in worst case.
// Auxiliary Space: This too depends on sorting algorithm. The auxiliary space is O(n) for merge sort and O(1) for Heap Sort.
*/