//Print All Distinct Elements of a given integer array

//javac -d classes PrintAllDistinctEle.java  && cd classes && java PrintAllDistinctEle && cd ..

import java.util.HashMap; 


// Java program to print all distinct 
// elements in a given array 
import java.io.*; 

class PrintAllDistinctEle { 

	static void printDistinct(int arr[], int n) { 
		// Pick all elements one by one 
		for (int i = 0; i < n; i++) { 
			// Check if the picked element is already printed 
			int j; 
			for (j = 0; j < i; j++) { 
			  if (arr[i] == arr[j]) {
				break; 
			  }
		    }
	
			// If not printed earlier, then print it 
			if (i == j) {
			  System.out.print( arr[i] + " "); 
			}
			
		} 
	} 
	
	// Driver program 
	public static void main (String[] args) 
	{ 
		int arr[] = {6, 10, 5, 4, 9, 120, 4, 6, 10}; 
		int n = arr.length; 
		printDistinct(arr, n); 

	} 
} 



/*
public class PrintAllDistinctEle { 

	public static void main(String args[]) {

		int ar[] = { 10, 5, 3, 4, 3, 5, 6 }; 
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>(); 
		for (int i = 0; i < ar.length; i++) { 
			hm.put(ar[i], i); 
		} 
		// Using hm.keySet() to print output reduces time complexity. - Lokesh 
		System.out.println(hm.keySet()); 

	} 

} */


/*
Print All Distinct Elements of a given integer array


Given an integer array, print all distinct elements in array. The given array may contain duplicates and the output should print every element only once. The given array is not sorted.
Examples:

Input: arr[] = {12, 10, 9, 45, 2, 10, 10, 45}
Output: 12, 10, 9, 45, 2

Input: arr[] = {1, 2, 3, 4, 5}
Output: 1, 2, 3, 4, 5

Input: arr[] = {1, 1, 1, 1, 1}
Output: 1

*/