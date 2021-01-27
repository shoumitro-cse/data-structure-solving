// Find subarray with given sum | Set 2 (Handles Negative Numbers)

//javac -d classes FindSubarrGivenSum.java  && cd classes && java FindSubarrGivenSum && cd ..

import java.util.*; 

class FindSubarrGivenSum { 

	public static void subArraySum(int[] arr, int n, int sum) { 
		//cur_sum to keep track of cummulative sum till that point 
		int cur_sum = 0; 
		int start = 0; 
		int end = -1; 
		HashMap<Integer, Integer> hashMap = new HashMap<>(); 

		for (int i = 0; i < n; i++) { 
			cur_sum = cur_sum + arr[i]; 
			//check whether cur_sum - sum = 0, if 0 it means 
			//the sub array is starting from index 0- so stop 
			if (cur_sum - sum == 0) { 
				start = 0; 
				end = i; 
				break; 
			} 
			//if hashMap already has the value, means we already 
			// have subarray with the sum - so stop 
			if (hashMap.containsKey(cur_sum - sum)) { 
				start = hashMap.get(cur_sum - sum) + 1; 
				end = i; 
				break; 
			} 
			//if value is not present then add to hashmap 
			hashMap.put(cur_sum, i); 

		} 

		// if end is -1 : means we have reached end without the sum 
		if (end == -1) { 
			System.out.println("No subarray with given sum exists"); 
		} else { 
			System.out.println("Sum found between indexes "+ start + " to " + end); 
		} 

	} 

	public static void main(String[] args) { 
		int[] arr = {10, 2, -2, -20, 10}; 
		int n = arr.length; 
		int sum = -10; 
		subArraySum(arr, n, sum); 
	} 
} 



/*
Find subarray with given sum | Set 2 (Handles Negative Numbers)


Given an unsorted array of integers, find a subarray which adds to a given number. 
If there are more than one subarrays with the sum as the given number, print any of them.

Examples:

Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Output: Sum found between indexes 2 and 4
Explantion: Sum of elements between indices
2 and 4 is 20 + 3 + 10 = 33

Input: arr[] = {10, 2, -2, -20, 10}, sum = -10
Output: Sum found between indexes 0 to 3
Explantion: Sum of elements between indices
0 and 3 is 10 + 2 - 2 - 20 = -10

Input: arr[] = {-10, 0, 2, -2, -20, 10}, sum = 20
Output: No subarray with given sum exists
Explantion: There is no subarray with the given sum
*/