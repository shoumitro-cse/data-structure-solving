// K-th Largest Sum Contiguous Subarray

// javac -d classes KthLargestSumSubArray.java  && cd classes && java KthLargestSumSubArray && cd ..

import java.util.*; 

class KthLargestSumSubArray {

	// function to calculate kth largest element in contiguous subarray sum 
	static int kthLargestSum(int arr[], int n, int k) { 

		// array to store predix sums 
		int sum[] = new int[n+1]; 
		
		sum[0] = 0; 
		sum[1] = arr[0]; 

		for (int i = 2; i <= n; i++) {
			sum[i] = sum[i-1] + arr[i-1]; 
		}
		
		// priority_queue of min heap 
		PriorityQueue<Integer> Q = new PriorityQueue<Integer> (); 
		// loop to calculate the contigous subarray sum position-wise 
		for (int i = 1; i <= n; i++) { 
			// loop to traverse all positions that  form contiguous subarray 
			for (int j = i; j <= n; j++) { 
				// calculates the contiguous subarray sum from j to i index 
				int x = sum[j] - sum[i-1]; 
				// if queue has less then k elements, then simply push it 
				if (Q.size() < k) 
					Q.add(x); 
				else { 
					if (Q.peek() < x) { 
						Q.poll(); 
						Q.add(x); 
					} 
				} 
			} 
		} 
		// the top element will be then kth largest element 
		return Q.poll(); 
	} 
	
	// Driver Code 
	public static void main(String[] args) 
	{ 
		int a[] = new int[]{ 10, -10, 20, -40 }; 
		int n = a.length; 
		int k = 6; 

		// calls the function to find out the k-th largest sum 
		System.out.println(kthLargestSum(a, n, k)); 
	} 
} 

/*
K-th Largest Sum Contiguous Subarray

Given an array of integers. Write a program to find the K-th largest sum of contiguous subarray within the array of numbers which has negative and positive numbers.

Examples:


Input: a[] = {20, -5, -1} 
         k = 3
Output: 14
Explanation: All sum of contiguous 
subarrays are (20, 15, 14, -5, -6, -1) 
so the 3rd largest sum is 14.

Input: a[] = {10, -10, 20, -40} 
         k = 6
Output: -10 
Explanation: The 6th largest sum among 
sum of all contiguous subarrays is -10.

*/