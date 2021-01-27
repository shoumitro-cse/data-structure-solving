//Recaman’s sequence

//javac -d classes RecamanSequence.java  && cd classes && java RecamanSequence && cd ..

import java.io.*; 
import java.util.*; 


class RecamanSequence { 
	

	// Prints first n terms of Recaman sequence 
	static void recaman(int n) 
	{ 
	    if (n <= 0) 
	    return; 
	  
	    // Print first term and store it in a hash  
	    System.out.printf("%d, ", 0); 
	    HashSet<Integer> s = new HashSet<Integer>(); 
	    s.add(0); 
	  
	    // Print remaining terms using  
	    // recursive formula. 
	    int prev = 0; 
	    for (int i = 1; i< n; i++) 
	    { 
	        int curr = prev - i; 
	        // If arr[i-1] - i is negative or 
	        // already exists. 
	        if (curr < 0 || s.contains(curr)) {
	            curr = prev + i; 
	        }
	  
	        s.add(curr); 
	  
	        System.out.printf("%d, ", curr); 
	        prev = curr; 
	    } 
	} 


	// Prints first n terms of Recaman sequence 
	static void recaman2(int n) { 
		// Create an array to store terms 
		int arr[] = new int[n]; 
		// First term of the sequence is always 0 
		arr[0] = 0; 
		System.out.print(arr[0]+" ,"); 
	
		// Fill remaining terms using recursive formula. 
		for (int i = 1; i < n; i++) { 
			
			int curr = arr[i - 1] - i; 
			int j; 
			
			for (j = 0; j < i; j++) { 
				// If arr[i-1] - i is negative or already exists. 
				if ((arr[j] == curr) || curr < 0) { 
					curr = arr[i - 1] + i; 
					break; 
				} 
			} 
			arr[i] = curr; 
			System.out.print(arr[i]+", "); 
		} 
	} 
	
	public static void main (String[] args) { 
		int n = 17; 
		recaman(n); 
        System.out.println();
	} 
} 


/*
Recaman’s sequence


Given an integer n. Print first n elements of Recaman’s sequence.

Examples:

Input : n = 6
Output : 0, 1, 3, 6, 2, 7

Input  : n = 17
Output : 0, 1, 3, 6, 2, 7, 13, 20, 12, 21, 11, 22, 10, 23, 9, 24, 8


It is basically a function with domain and co-domain as natural numbers and 0. It is recursively defined as below:
Specifically, let a(n) denote the (n+1)-th term. (0 being already there).
The rule says:

a(0) = 0,
if n > 0 and the number is not 
   already included in the sequence,
     a(n) = a(n - 1) - n 
else 
     a(n) = a(n-1) + n. 
*/
