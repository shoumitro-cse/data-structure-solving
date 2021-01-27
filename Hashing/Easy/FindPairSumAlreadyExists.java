// A simple Java program to find pair whose sum already exists in array 

//javac -d classes FindPairSumAlreadyExists.java  && cd classes && java FindPairSumAlreadyExists && cd ..

import java.io.*; 
import java.util.*; 
import java.lang.*; 
import java.io.*; 

public class FindPairSumAlreadyExists { 


	    // Function to find pair whose sum 
    // exists in arr[] 
    // /Time Complexity : O(n2)
    public static void findPair(int[] arr, int n) { 

        /* store all the array elements as a Hash value*/
        HashSet<Integer> s = new HashSet<Integer>(); 
  
        for (Integer i : arr) { 
            s.add(i); 
        } 
 
        boolean found = false; 
  
        for (int i = 0; i < n - 1; i++) { 
            for (int j = i + 1; j < n; j++) { 
                int sum = arr[i] + arr[j]; 
                if (s.contains(sum)) { 
                    found = true; 
                    System.out.println(arr[i] + " "+ arr[j]); 
                } 
            } 
        } 
  
        if (found == false) 
            System.out.println("Not Exist "); 
    } 


/*	// Function to find pair whose 
	// sum exists in arr[] 
	static void findPair(int[] arr, int n) { 
		boolean found = false; 
		for (int i = 0; i < n; i++) { 
			for (int j = i + 1; j < n; j++) { 
				for (int k = 0; k < n; k++) { 
					if (arr[i] + arr[j] == arr[k]) { 
						System.out.println(arr[i] + " " + arr[j]); 
						found = true; 
					} 
				} 
			} 
		} 

		if (found == false) 
			System.out.println("Not exist"); 
	} */

	// Driver code 
	static public void main(String[] args) { 
		int[] arr = {10, 4, 8, 13, 5}; 
		int n = arr.length; 
		findPair(arr, n); 
	} 
} 



/*
Find pairs in array whose sums already exist in array

Given an array of n distinct and positive elements, the task is to find pair 
whose sum already exists in given array.

Examples :

Input : arr[] = {2, 8, 7, 1, 5};
Output : 2 5
         7 1    
     
Input : arr[] = {7, 8, 5, 9, 11};
Output : Not Exist
*/
