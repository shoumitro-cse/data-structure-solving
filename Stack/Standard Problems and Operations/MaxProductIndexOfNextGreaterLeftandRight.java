// Maximum product of indexes of next greater on left and right

// javac -d classes MaxProductIndexOfNextGreaterLeftandRight.java  && cd classes && java MaxProductIndexOfNextGreaterLeftandRight && cd ..

import java.io.*; 
import java.util.*; 

class MaxProductIndexOfNextGreaterLeftandRight {

	// function to find just next greater element in left side 
	static int[] nextGreaterInLeft(int []a, int n) {

		int []left_index = new int[n+1]; 
		Stack<Integer> s = new Stack<Integer>(); 
	
		for (int i = n - 1; i >= 0; i--) { 

			while (s.size() != 0 && a[i] > a[s.peek()]) { 
				int r = s.peek(); 
				s.pop(); 
				left_index[r] = i + 1; 

			} 
			// else push the current element in stack 
			s.push(i); 
		} 
		return left_index; 
	} 
	
	// function to find just next greater element in right side 
	static int[] nextGreaterInRight(int []a, int n) {

		int [] right_index = new int[n+1]; 
		Stack<Integer> s = new Stack<Integer>(); 

		for (int i = 0; i < n; ++i) { 

			while (s.size() != 0 && a[i] > a[s.peek()]) { 
				int r = s.peek(); 
				s.pop(); 
				right_index[r] = i + 1; 
			} 
			// else push the current element in stack 
			s.push(i); 
		} 
		 // System.out.println("\n\n"+Arrays.toString(right_index)); 
		return right_index; 
	} 
	
	// Function to find  maximum LR product 
	static int LRProduct(int []arr, int n) { 
		
		int []left = nextGreaterInLeft(arr, n); 

		int []right = nextGreaterInRight(arr, n);

		System.out.println("left: "+Arrays.toString(left)); 
		System.out.println("right: "+Arrays.toString(right)); 

		int ans = -1; 
		for (int i = 1; i <= n; i++) { 
			// finding the max index product 
			ans = Math.max(ans, left[i] * right[i]); 
		}
		return ans; 
	} 
	
	// Driver code 
	public static void main(String args[]) 
	{ 
		int []arr = new int[]{ 5, 4, 3, 4, 5 }; 
		// int []arr = new int[]{1, 1, 1, 1, 0, 1, 1, 1, 1, 1} ; 
		int n = arr.length; 
		System.out.println("original: "+Arrays.toString(arr)); 
	
		System.out.println("Max left*light product: "+LRProduct(arr, n)); 
	} 
} 


/*
Maximum product of indexes of next greater on left and right

Given an array a[1..N]. For each element at position i (1 <= i <= N). Where

1. L(i) is defined as closest index j such that j < i and a[j] > a[i]. 
   If no such j exists then L(i) = 0.

2. R(i) is defined as closest index k such that k > i and a[k] > a[i]. 
   If no such k exists then R(i) = 0.
   LRProduct(i) = L(i)*R(i) .

We need to find an index with maximum LRProduct

Examples:

Input : 1 1 1 1 0 1 1 1 1 1
Output : 24
For {1, 1, 1, 1, 0, 1, 1, 1, 1, 1} all element are same except 0. So only 
for zero their exist greater element and for others it will be zero. 
for zero, on left 4th element is closest and greater than zero and on right 6th 
element is closest and greater. so maximum product will be 4*6 = 24.

Input : 5 4 3 4 5
Output : 8
For {5, 4, 3, 4, 5}, L[] = {0, 1, 2, 1, 0} and R[]= {0, 5, 4, 5, 0},
LRProduct = {0, 5, 8, 5, 0} and max in this is 8.

*/