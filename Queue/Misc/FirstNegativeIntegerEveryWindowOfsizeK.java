//First negative integer in every window of size k

// Java implementation to find the first negative integer in every window of size k

// javac -d classes FirstNegativeIntegerEveryWindowOfsizeK.java  && cd classes && java FirstNegativeIntegerEveryWindowOfsizeK && cd ..

import java.util.*;

class FirstNegativeIntegerEveryWindowOfsizeK {

	// function to find the first negative integer in every window of size k
	static void printFirstNegativeInteger(int arr[], int n, int k) {
		// flag to check whether window contains a negative integer or not
		boolean flag;
		// Loop for each subarray(window) of size k
		for (int i = 0; i<(n-k+1); i++) {
			flag = false;
			// traverse through the current window
			for (int j = 0; j<k; j++){
				if (arr[i+j] < 0) {
					System.out.print((arr[i+j])+" ");
					flag = true;
					break;
				}
			}
			// if the current window does not contain a negative integer
			if (!flag) {
				System.out.print("0"+" ");
			}
		} 
	}

	// Driver program to test above functions
	public static void main(String args[]) {
		int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
		int n = arr.length;
		int k = 3;
		printFirstNegativeInteger(arr, n, k);
		
	}
}

/*
Time Complexity : The outer loop runs n-k+1 times and the inner loop runs k times 
for every iteration of outer loop. So time complexity is O((n-k+1)*k) which 
can also be written as O(nk) when k is comparitively much smaller than n, otherwise
when k tends to reach n, complexity becomes O(k). 


Problem name:
First negative integer in every window of size k

Given an array and a positive integer k, find the first negative integer for 
each window(contiguous subarray) of size k. If a window does not contain a negative integer, 
then print 0 for that window.

Examples: 
 
Input : arr[] = {-8, 2, 3, -6, 10}, k = 2
Output : -8 0 -6 -6

First negative integer for each window of size k
{-8, 2} = -8
{2, 3} = 0 (does not contain a negative integer)
{3, -6} = -6
{-6, 10} = -6

Input : arr[] = {12, -1, -7, 8, -15, 30, 16, 28} , k = 3
Output : -1 -1 -7 -15 -15 0*/