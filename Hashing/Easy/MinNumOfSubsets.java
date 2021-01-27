// Minimum number of subsets with distinct elements

//javac -d classes MinNumOfSubsets.java  && cd classes && java MinNumOfSubsets && cd ..

import java.util.HashMap; 
import java.util.Map; 


class MinNumOfSubsets { 
	
	// Function to count subsets such that all subsets have distinct elements. 
	static int subset(int arr[], int n) { 
		
		// Traverse the input array and store frequencies of elements 
		HashMap<Integer, Integer> mp = new HashMap<>(); 
		for (int i = 0; i < n; i++) {
			mp.put(arr[i], mp.get(arr[i]) == null?1:mp.get(arr[i])+1); 
		}

		// Find the maximum value in map. 
		int res = 0; 
		for (Map.Entry<Integer,Integer> entry : mp.entrySet()) {
		   res = Math.max(res, entry.getValue()); 
	    }

		return res; 
	} 

	public static void main(String[] args) { 
		int arr[] = { 5, 6, 9, 3, 4, 3, 4, 3,4 }; 
		int n = arr.length; 
		System.out.println(subset(arr, n)); 

	} 
} 


/*Minimum number of subsets with distinct elements

You are given an array of n-element. You have to make subsets from the array such that no 
subset contain duplicate elements. Find out minimum number of subset possible.

Examples :

Input : arr[] = {1, 2, 3, 4}
Output :1
Explanation : A single subset can contains all 
values and all values are distinct

Input : arr[] = {1, 2, 3, 3}
Output : 2
Explanation : We need to create two subsets
{1, 2, 3} and {3} [or {1, 3} and {2, 3}] such
that both subsets have distinct elements.
*/
