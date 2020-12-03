//Sum of minimum and maximum elements of all subarrays of size k.

// Java program to find sum of all minimum and maximum elements Of Sub-array Size k. 
// javac -d classes SumOfMinMaxEleSubarrays.java  && cd classes && java SumOfMinMaxEleSubarrays && cd ..

import java.util.Deque; 
import java.util.LinkedList; 

public class SumOfMinMaxEleSubarrays { 

	// Returns sum of min and max element of all subarrays of size k 
	// Time Complexity: O(n)
	public static int SumOfKsubArray(int arr[] , int k) { 

		int sum = 0; // Initialize result 

		// The queue will store indexes of useful elements in every window  
        // In deque 'G' we maintain decreasing order of values from front to rear  
        // In deque 'S' we  maintain increasing order of values from front to rear 
		Deque<Integer> S = new LinkedList<>(); // increasing
		Deque<Integer> G = new LinkedList<>(); // decreasing
		int i = 0; 
		
		for (i = 0; i < k; i++) { //k=4, so, 0, 1, 2, 3

			while ( !S.isEmpty() && arr[S.peekLast()] >= arr[i]) {
				S.removeLast(); // Remove from rear 
			}
			// Remove all previous smaller that are elements are useless. 
			while ( !G.isEmpty() && arr[G.peekLast()] <= arr[i]) {
				G.removeLast(); // Remove from rear 
			}
			// Add current element at rear of both deque 
			G.addLast(i); 
			S.addLast(i); 
		} 
		
		// System.out.println(S); // 2, 3
		// System.out.println(G); // 3
		// System.out.println();

		// System.out.println(i);//4
	
		// Process rest of the Array elements 
		for ( ; i < arr.length; i++ ) { 

			sum += arr[S.peekFirst()] + arr[G.peekFirst()]; 

/*			// Remove all elements which are out of this window 
			while ( !S.isEmpty() && (i-k) >= S.peekFirst()) {
				S.removeFirst(); 
			}

			while ( !G.isEmpty() && (i-k) >= G.peekFirst()) {
				G.removeFirst(); 
			}*/

			// remove all previous greater element that are useless 
			while ( !S.isEmpty() && arr[S.peekLast()] >= arr[i]) { 
				S.removeLast(); // Remove from rear 
			}

			// remove all previous smaller that are elements are useless 
			while ( !G.isEmpty() && arr[G.peekLast()] <= arr[i]) {
				G.removeLast(); // Remove from rear 
			}
			// Add current element at rear of both deque 
			G.addLast(i); 
			S.addLast(i); 

/*		    System.out.println(S); 
		    System.out.println(G);
		    System.out.println();*/
		} 
		// Sum of minimum and maximum element of last window 
		sum += arr[S.peekFirst()] + arr[G.peekFirst()]; 
		return sum; 
	} 

	public static void main(String args[]) { 
		int arr[] = {2, 5, -1, 7, -3, -1, -2} ; 
		int k = 4; 
		System.out.println(SumOfKsubArray(arr, k)); 
	} 

} 


/*
Sum of minimum and maximum elements of all subarrays of size k.

Given an array of both positive and negative integers, the task is to compute sum of 
minimum and maximum elements of all sub-array of size k.

Examples:

Input : arr[] = {2, 5, -1, 7, -3, -1, -2}  
        K = 4
Output : 18

Explanation : Subarrays of size 4 are : 
     {2, 5, -1, 7},   min + max = -1 + 7 = 6
     {5, -1, 7, -3},  min + max = -3 + 7 = 4      
     {-1, 7, -3, -1}, min + max = -3 + 7 = 4
     {7, -3, -1, -2}, min + max = -3 + 7 = 4

     Sum of all min & max = 6 + 4 + 4 + 4 = 18  */