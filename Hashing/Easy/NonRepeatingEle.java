// Find the first non-repeating element in a given array of integers.

//javac -d classes NonRepeatingEle.java  && cd classes && java NonRepeatingEle && cd ..

import java.util.*; 

class NonRepeatingEle { 

	static int firstNonRepeating(int arr[], int n) {

		// Insert all array elements in hash table 
		Map<Integer, Integer> m = new HashMap<>(); 
		for (int i = 0; i < n; i++) { 
			if (m.containsKey(arr[i])) { 
				m.put(arr[i], m.get(arr[i]) + 1); 
			} else { 
				m.put(arr[i], 1); 
			} 
		} 

		// Traverse array again and return first element with count 1. 
		for (int i = 0; i < n; i++) {
		  if (m.get(arr[i]) == 1) {
			return arr[i]; 
		  }
		}
		return -1; 
	} 

	public static void main(String[] args) 
	{ 
		int arr[] = { 9, 4, 9, 6, 7, 4 }; 
		int n = arr.length; 
		System.out.println(firstNonRepeating(arr, n)); 
	} 
} 



/*
Non-Repeating Element


Find the first non-repeating element in a given array of integers.

Examples:

Input : -1 2 -1 3 2
Output : 3
Explanation : The first number that does not 
repeat is : 3

Input : 9 4 9 6 7 4
Output : 6
*/