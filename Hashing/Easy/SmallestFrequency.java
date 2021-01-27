// Java implementation to find smallest subarray with all occurrences of a most frequent element 

// javac -d classes SmallestFrequency.java  && cd classes && java SmallestFrequency && cd ..

import java.io.*; 
import java.util.*; 

class SmallestFrequency { 
	
	static void smallestSubsegment(int a[], int n) { 
		// To store left most occurrence of elements 
		HashMap<Integer, Integer> left = new HashMap<Integer, Integer>(); 
		// To store counts of elements 
		HashMap<Integer, Integer> count = new HashMap<Integer, Integer>(); 
		// To store maximum frequency 
		int mx = 0; 
		// To store length and starting index of smallest result window 
		int mn = -1;
		int strindex = -1; 
	
		for (int i = 0; i < n; i++) { 
			int x = a[i]; 

			// First occurrence of an element, store the index 
			if (count.get(x) == null) { 
				left.put(x, i) ; 
				count.put(x, 1); 
			} else {
			    // increase the frequency of elements 
				count.put(x, count.get(x) + 1); 
			}

			// Find maximum repeated element and store its last occurrence and first occurrence 
			if (count.get(x) > mx) { 
				mx = count.get(x); 
				// length of subsegment 
				mn = i-left.get(x) + 1; 
				strindex = left.get(x); 
			} else if ((count.get(x) == mx) && (i-left.get(x) + 1 < mn)) { 
			    // select subsegment of smallest size 
				mn = i-left.get(x) + 1; 
				strindex = left.get(x); 
			} 

		} 
	
		// Print the subsegment with all occurrences of a most frequent element 
		for (int i = strindex; i < strindex + mn; i++) {
			System.out.print(a[i] + " "); 
		}
	} 
	

	public static void main (String[] args) { 
		int A[] = { 1, 2, 2, 2, 1 }; 
		int n = A.length; 
		
		smallestSubsegment(A, n); 

		System.out.println();
	} 
} 



/*
Smallest subarray with all occurrences of a most frequent element


Given an array, A. Let x be an element in the array.x has the maximum frequency in the array.
Find the smallest subsegment of the array which also has x as the maximum frequency element.

Examples:

Input :  arr[] = {4, 1, 1, 2, 2, 1, 3, 3} 
Output :   1, 1, 2, 2, 1
The most frequent element is 1. The smallest
subarray that has all occurrences of it is
1 1 2 2 1

Input :  A[] = {1, 2, 2, 3, 1}
Output : 2, 2
Note that there are two elements that appear
two times, 1 and 2. The smallest window for
1 is whole array and smallest window for 2 is
{2, 2}. Since window for 2 is smaller, this is
our output.
*/
