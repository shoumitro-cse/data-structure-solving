//Most frequent element in an array

//javac -d classes MostFrequentEle.java  && cd classes && java MostFrequentEle && cd ..

import java.util.*; 

class MostFrequentEle { 
	
	static int mostFrequent(int arr[], int n) { 		
		
		// Sort the array 
		Arrays.sort(arr); 

        // System.out.println(Arrays.toString(arr)); 
        // arr = [1, 1, 2, 2, 2, 3, 5]

		// find the max frequency using linear traversal 
		int max_count = 1, res = arr[0]; 
		int curr_count = 1; 
		
		for (int i = 1; i < n; i++) { 
			
			if (arr[i] == arr[i-1]) {
				curr_count++; 
			} else { 
				if (curr_count > max_count) { 
					max_count = curr_count; 
					res = arr[i-1]; 
				} 
				curr_count = 1; 
			} 
		} 

		// If last element is most frequent 
		if (curr_count > max_count) { 
			max_count = curr_count; 
			res = arr[n-1]; 
		} 
	
		return res; 
	} 
	
	public static void main (String[] args) { 
		
		int arr[] = {1, 5, 2, 1, 2, 3, 2}; 
		int n = arr.length; 
		
		System.out.println(mostFrequent(arr, n)); 
		
	} 
} 

/*
Most frequent element in an array


Given an array, find the most frequent element in it. If there are multiple elements 
that appear maximum number of times, print any one of them.

Examples:

Input : arr[] = {1, 3, 2, 1, 4, 1}
Output : 1
1 appears three times in array which
is maximum frequency.

Input : arr[] = {10, 20, 10, 20, 30, 20, 20}
Output : 20
*/
