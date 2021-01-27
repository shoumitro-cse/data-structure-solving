// Number of subarrays having sum exactly equal to k

//javac -d classes NumberOfSubarrSumEqualToK.java  && cd classes && java NumberOfSubarrSumEqualToK && cd ..

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubarrSumEqualToK {

	// Function to find number of subarrays with sum exactly equal to k.
	// Time Complexity: O(nlogn) 
// Auxiliary Space: O(n)
	static int findSubarraySum(int arr[], int n, int sum) {
		// HashMap to store number of subarrays starting from index zero having
		// particular value of sum.
		HashMap<Integer, Integer> prevSum = new HashMap<>();
		int res = 0;
		// Sum of elements so far.
		int currsum = 0;

		for (int i = 0; i < n; i++) {
			// Add current element to sum so far.
			currsum += arr[i];
			// If currsum is equal to desired sum, then a new subarray is found. So
			// increase count of subarrays.
			if (currsum == sum)
				res++;

			if (prevSum.containsKey(currsum-sum))
				res += prevSum.get(currsum-sum);

			// Add currsum value to count of different values of sum.
			Integer count = prevSum.get(currsum);
			if (count == null)
				prevSum.put(currsum, 1);
			else
				prevSum.put(currsum, count + 1);
		}

		return res;
	}

	public static void main(String[] args) {

		int arr[] = { 10, 2, -2, -20, 10 };
		int sum = -10;
		int n = arr.length;
		System.out.println(findSubarraySum(arr, n, sum));
	}
}

/*Number of subarrays having sum exactly equal to k


Given an unsorted array of integers, find the number of subarrays having sum exactly 
equal to a given number k.

Examples: 

Input : arr[] = {10, 2, -2, -20, 10}, 
        k = -10
Output : 3
Subarrays: arr[0...3], arr[1...4], arr[3..4]
have sum exactly equal to -10.

Input : arr[] = {9, 4, 20, 3, 10, 5},
            k = 33
Output : 2
Subarrays : arr[0...2], arr[2...4] have sum
exactly equal to 33.

*/


/*// Java program for
// the above approach
import java.util.*;
class Solution {
	
	public static void main(String[] args)
	{
		int arr[] = { 10, 2, -2, -20, 10 };
		int k = -10;
		int n = arr.length;
		int res = 0;
		
		// calculate all subarrays
		for (int i = 0; i < n; i++) {
			
			int sum = 0;
			for (int j = i; j < n; j++) {
				
				// calculate required sum
				sum += arr[j];
				
				// check if sum is equal to
				// required sum
				if (sum == k)
					res++;
			}
		}
		System.out.println(res);
	}
}
*/