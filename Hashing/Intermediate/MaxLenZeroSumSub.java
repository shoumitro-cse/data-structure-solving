//Find the length of largest subarray with 0 sum

//javac -d classes MaxLenZeroSumSub.java  && cd classes && java MaxLenZeroSumSub && cd ..

import java.util.HashMap; 

class MaxLenZeroSumSub { 

	// Returns length of the maximum length subarray with 0 sum 
	static int maxLen(int arr[]) {

		/*Complexity Analysis: 
			Time Complexity: O(n), as use of good hashing function will allow 
			insertion and retrieval operations in O(1) time.
			Space Complexity: O(n), for the use of extra space to store the prefix array and hashmap.
		*/
		HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>(); 

		int sum = 0;    // Initialize sum of elements 
		int max_len = 0;// Initialize result 

		// Traverse through the given array 
		for (int i = 0; i < arr.length; i++) { 
			// Add current element to sum 
			sum += arr[i]; 

			if (arr[i] == 0 && max_len == 0) {
				max_len = 1; 
			}

			if (sum == 0) {
				max_len = i + 1; 
			}

			// Look this sum in hash table 
			Integer prev_i = hM.get(sum); 

			// If this sum is seen before, then update max_len if required 
			if (prev_i != null)
				max_len = Math.max(max_len, i-prev_i); 
			else // Else put this sum in hash table 
				hM.put(sum, i); 
		} 

		return max_len; 
	} 


/*   
    // Time Complexity: O(n^2) due to the use of nested loops.
    // Space complexity: O(1) as no extra space is used.
    static int maxLen(int arr[], int n) { 
        int max_len = 0; 
        // Pick a starting point 
        for (int i = 0; i < n; i++) { 
            // Initialize curr_sum for every starting point 
            int curr_sum = 0; 
            // try all subarrays starting with 'i' 
            for (int j = i; j < n; j++) { 
                curr_sum += arr[j]; 
                // If curr_sum becomes 0, then update max_len 
                if (curr_sum == 0) 
                    max_len = Math.max(max_len, j-i + 1); 
            } 
        } 
        return max_len; 
    } */


	public static void main(String arg[]) { 
		int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 }; 
		System.out.println("Length of the longest 0 sum subarray is "+ maxLen(arr)); 
	} 
} 


/*
Find the length of largest subarray with 0 sum


Given an array of integers, find the length of the longest sub-array with sum equals to 0.
Examples : 
 

Input: arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
Output: 5
Explanation: The longest sub-array with 
elements summing up-to 0 is {-2, 2, -8, 1, 7}

Input: arr[] = {1, 2, 3}
Output: 0
Explanation:There is no subarray with 0 sum

Input:  arr[] = {1, 0, 3}
Output:  1
Explanation: The longest sub-array with 
elements summing up-to 0 is {0}

*/