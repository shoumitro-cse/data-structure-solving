// Print all triplets in sorted array that form AP (or Arithmetic Progression)

//javac -d classes TripletsAP.java  && cd classes && java TripletsAP && cd ..

import java.io.*; 
import java.util.*; 

class TripletsAP {

	// Function to print all triplets in given sorted array that forms AP 
	static void printAllAPTriplets(int [] arr, int n) {
		ArrayList<Integer> s = new ArrayList<Integer>(); 
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) { 
				// Use hash to find if there is a previous element with difference 
				// equal to arr[j] - arr[i] 
				int diff = arr[j] - arr[i]; 
				boolean exists = s.contains(arr[i]-diff); 
				if (exists) {
				   System.out.println(arr[i]-diff + " " + arr[i] + " " + arr[j]); 
				}
			}
		    s.add(arr[i]); 
		} 
	} 
	
	public static void main(String args[]) { 
		int []arr = {2, 6, 9, 12, 17, 22, 31, 32, 35, 42}; 
		int n = arr.length; 
		printAllAPTriplets(arr, n); 
	} 
} 


/*
Print all triplets in sorted array that form AP

Given a sorted array of distinct positive integers, print all triplets that form AP (or Arithmetic Progression)

Examples :

Input : arr[] = { 2, 6, 9, 12, 17, 22, 31, 32, 35, 42 };
Output :
6 9 12
2 12 22
12 17 22
2 17 32
12 22 32
9 22 35
2 22 42
22 32 42

Input : arr[] = { 3, 5, 6, 7, 8, 10, 12};
Output :
3 5 7
5 6 7
6 7 8
6 8 10
8 10 12

*/