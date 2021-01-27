//Find top three repeated in array

//javac -d classes Top3RepeatedNum.java  && cd classes && java Top3RepeatedNum && cd ..

import java.io.*; 
import java.util.*; 

// User defined Pair class 
class Pair { 
	int first, second; 
} 

class Top3RepeatedNum { 

	// Function to print top three repeated numbers 
	static void top3Repeated(int[] arr, int n) {

		// There should be atleast two elements 
		if (n < 3) { 
			System.out.print("Invalid Input"); 
			return; 
		} 

		// Count Frequency of each element 
		TreeMap<Integer, Integer> freq = new TreeMap<>(); 
		for (int i = 0; i < n; i++) {
			if (freq.containsKey(arr[i])) {
				freq.put(arr[i], 1 + freq.get(arr[i])); 
			} else {
				freq.put(arr[i], 1); 
			}
		}

		// Initialize first value of each variable of Pair type is INT_MIN 
		Pair x = new Pair(); 
		Pair y = new Pair(); 
		Pair z = new Pair(); 
		x.first = y.first = z.first = Integer.MIN_VALUE; 

		for (Map.Entry curr : freq.entrySet()) { 
			// If frequency of current element 
			// is not zero and greater than frequency of first largest element 
			if (Integer.parseInt(String.valueOf(curr.getValue())) > x.first) { 

				// Update second and third largest 
				z.first = y.first; 
				z.second = y.second; 

				y.first = x.first; 
				y.second = x.second; 

				// Modify values of x Number 
				x.first = Integer.parseInt(String.valueOf(curr.getValue())); 
				x.second = Integer.parseInt(String.valueOf(curr.getKey())); 
			} else if (Integer.parseInt(String.valueOf(curr.getValue())) > y.first) { 
				// Modify values of third largest 
				z.first = y.first; 
				z.second = y.second; 

				// Modify values of second largest 
				y.first = Integer.parseInt(String.valueOf(curr.getValue())); 
				y.second = Integer.parseInt(String.valueOf(curr.getKey())); 
			} else if (Integer.parseInt(String.valueOf(curr.getValue())) > z.first) { 
				// Modify values of z Number 
				z.first = Integer.parseInt(String.valueOf(curr.getValue())); 
				z.second = Integer.parseInt(String.valueOf(curr.getKey())); 
			} 
		} 

		// System.out.println("Three largest elements are " + x.first + " "+ y.first + " " + z.first); 
		System.out.println("Three largest elements are " + x.second + " "+ y.second + " " + z.second); 
	} 

	// Driver's Code 
	public static void main(String args[]) { 
		int[] arr = { 3, 4, 2, 3, 16, 3, 15, 16, 15, 15, 16, 2, 3 }; 
		int n = arr.length; 
		top3Repeated(arr, n); 
	} 
} 


/*
Asked in : Zoho

Find top three repeated in array


Given an array of size N with repeated numbers, You Have to Find the top three repeated numbers.
Note : If Number comes same number of times then our output is one who comes first in array
Examples:

Input : arr[] = {3, 4, 2, 3, 16, 3, 15, 16, 15, 15, 16, 2, 3}
Output : Three largest elements are 3 16 15
Explanation :Here, 3 comes 4 times, 16 comes 3 times, 15 comes 3 times.

Input : arr[] = {2, 4, 3, 2, 3, 4, 5, 5, 3, 2, 2, 5}
Output : Three largest elements are 2 3 5

*/
