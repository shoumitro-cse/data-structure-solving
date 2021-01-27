//Count subsets having distinct even numbers

//javac -d classes DistinctEvenNum.java  && cd classes && java DistinctEvenNum && cd ..

import java.util.*; 

class DistinctEvenNum {

	// function to count the required subsets 
	static int countSubsets(int arr[], int n) { 
		HashSet<Integer> us = new HashSet<>(); 
		int even_count = 0; 			
		// inserting even numbers in the set 'us' single copy of each number is retained 
		for (int i = 0; i < n; i++) {
			if (arr[i] % 2 == 0) {
				us.add(arr[i]); 
			}
		}
		// counting distinct even numbers 
		even_count = us.size(); 
		// total count of required subsets 
		return (int) (Math.pow(2, even_count)-1); 
	} 

	public static void main(String[] args) { 
		int arr[] = {4, 2, 1, 9, 2, 6, 5, 3}; 
		int n = arr.length; 
		System.out.println("Number of subsets = "+ countSubsets(arr, n)); 
	} 
} 


/*
Count subsets having distinct even numbers

Given a sequence of n numbers. The task is to count all the subsets of the given set which only have even numbers and all are distinct.
Note: By the property of sets, if two subsets have the same set of elements then they are considered as one. For example: [2, 4, 8] and [4, 2, 8] are considered to be the same.

Examples:

Input : {4, 2, 1, 9, 2, 6, 5, 3} 
Output : 7
The subsets are:
[4], [2], [6], [4, 2], 
[2, 6], [4, 6], [4, 2, 6]

Input : {10, 3, 4, 2, 4, 20, 10, 6, 8, 14, 2, 6, 9}
Output : 127
*/