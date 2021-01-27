// Java program to find the only repeating element in an array where elements are 

//javac -d classes RepeatingEle.java  && cd classes && java RepeatingEle && cd ..

import java.io.*; 
import java.util.*; 

class RepeatingEle { 

	static int findRepeating(int[] arr, int n) { 
		int sum = 0; 
		for (int i = 0; i < n; i++) {
			sum += arr[i]; 
		}
		return sum - (((n - 1) * n) / 2); 
	} 

	public static void main(String args[]) { 
		int[] arr = {1, 5, 1, 2, 3, 4}; 
		int n = arr.length; 
		System.out.println(findRepeating(arr, n)); 
	} 
} 


/*
Find the only repetitive element between 1 to n-1

We are given an array arr[] of size n. Numbers are from 1 to (n-1) in random order. 
The array has only one repetitive element. We need to find the repetitive element.

Examples :

Input  : a[] = {1, 3, 2, 3, 4}
Output : 3

Input  : a[] = {1, 5, 1, 2, 3, 4}
Output : 1
*/

