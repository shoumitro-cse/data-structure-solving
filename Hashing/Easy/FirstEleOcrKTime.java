// Java implementation to find first element occurring k times 

//javac -d classes FirstEleOcrKTime.java  && cd classes && java FirstEleOcrKTime && cd ..

import java.util.HashMap; 


class FirstEleOcrKTime { 

	// function to find the first element occurring k number of times 
	//Time Complexity: O(n)
	static int firstElement(int arr[], int n, int k) { 
		
		// unordered_map to count occurrences of each element 
		HashMap<Integer, Integer> count_map = new HashMap<>(); 

		for (int i = 0; i < n; i++) { 
			int a = 0; 

			if(count_map.get(arr[i]) != null) { 
				a = count_map.get(arr[i]); // get occur value
			} 
			
			count_map.put(arr[i], a+1); 
		}

		//count_map[arr[i]]++; 

		// it is the required first element 
		for (int i = 0; i < n; i++) { 
		   // if count of element == k ,then 
			if (count_map.get(arr[i]) == k) { 
				return arr[i]; 
			} 
		} 

		// no element occurs k times 
		return -1; 
	} 

	public static void main(String[] args) { 
		int arr[] = {1, 7, 4, 3, 4, 8, 7}; 
		int n = arr.length; 
		int k = 2; 
		System.out.println(firstElement(arr, n, k)); 
	} 
} 

/*
First element occurring k times in an array


Given an array of n integers. The task is to find the first element that occurs k number of times. 
If no element occurs k times the print -1. The distribution of integer elements could be in any range.

Examples:

Input: {1, 7, 4, 3, 4, 8, 7},
k = 2
Output: 7
Both 7 and 4 occur 2 times.
But 7 is the first that occurs 2 times.

Input: {4, 1, 6, 1, 6, 4},
k = 1
Output: -1
*/