// Java program to find a pair with product in given array. 

//javac -d classes FindPairProduct.java  && cd classes && java FindPairProduct && cd ..

import java.io.*; 

class FindPairProduct { 

	static int findGreatest( int []arr , int n) {

		int result = -1; 
		for (int i = 0; i < n ; i++) {
			for (int j = 0; j < n-1; j++) {
				for (int k = j+1 ; k < n; k++) {
					if (arr[j] * arr[k] == arr[i]) {
						result = Math.max(result, arr[i]); 
					}
				}
			}
		}
		return result; 
	} 

	static public void main (String[] args) { 
		int []arr = {30, 10, 9, 3, 35}; 
		int n = arr.length; 

		System.out.println(findGreatest(arr, n)); 
	} 
} 


/*Find pair with greatest product in array


Given an array of n elements, the task is to find the greatest number such that 
it is product of two elements of given array. If no such element exists, print -1. 
Elements are within the range of 1 to 10^5.

Examples :

Input :  arr[] = {10, 3, 5, 30, 35}
Output:  30
Explanation: 30 is the product of 10 and 3.

Input :  arr[] = {2, 5, 7, 8}
Output:  -1
Explanation: Since, no such element exists.

Input :  arr[] = {10, 2, 4, 30, 35}
Output:  -1

Input :  arr[] = {10, 2, 2, 4, 30, 35}
Output:  4

Input  : arr[] = {17, 2, 1, 35, 30}
Output : 35

*/