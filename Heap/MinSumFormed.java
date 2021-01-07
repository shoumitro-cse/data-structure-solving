// Minimum sum of two numbers formed from digits of an array

// javac -d classes MinSumFormed.java  && cd classes && java MinSumFormed && cd ..

import java.util.PriorityQueue;

class MinSumFormed {
	
	// Returns sum of two numbers formed from all digits in a[]
	public static long solve(int[] a) {
		
		// min Heap
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		// to store the 2 numbers formed by array elements to minimize the required sum
		StringBuilder num1 = new StringBuilder();
		StringBuilder num2 = new StringBuilder();
		
		// Adding elements in Priority Queue
		for (int x : a)
			pq.add(x);
		
		// checking if the priority queue is non empty
		while (!pq.isEmpty()) {
			num1.append(pq.poll()+ "");
			if (!pq.isEmpty()) {
				num2.append(pq.poll()+ "");
			}
		}

		// the required sum calculated
		long sum = Long.parseLong(num1.toString()) + Long.parseLong(num2.toString());

		return sum;
	}

	public static void main (String[] args) {
		int arr[] = {6, 8, 4, 5, 2, 3};
		System.out.println("The required sum is "+ solve(arr));
	}
}


/*
Minimum sum of two numbers formed from digits of an array


Given an array of digits (values are from 0 to 9), find the minimum possible sum 
of two numbers formed from digits of the array. All digits of given array must be 
used to form the two numbers.

Examples: 

Input: [6, 8, 4, 5, 2, 3]
Output: 604
The minimum sum is formed by numbers 
358 and 246

Input: [5, 3, 0, 7, 4]
Output: 82
The minimum sum is formed by numbers 
35 and 047 
*/
