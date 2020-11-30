// Java Program to find Right smaller element of next greater element 

//javac -d classes FindNextSmallerOfNextGreater.java  && cd classes && java FindNextSmallerOfNextGreater && cd ..

import java.util.*; 

public class FindNextSmallerOfNextGreater { 


	// function find Next greater element 
	// Time complexity : O(n)
	public static void nextGreater(int arr[], int next[], char order) { 
		// create empty stack 
		Stack<Integer> stack=new Stack<>(); 

		for (int i=arr.length-1; i>=0; i--) { 

/*			while (!stack.isEmpty() && ((order=='G')? arr[stack.peek()] <= arr[i]:arr[stack.peek()] >= arr[i])) {
				stack.pop(); 
			}	*/		
			while (!stack.isEmpty() && (order=='G') && arr[stack.peek()] <= arr[i]) {
				stack.pop(); 
			}

			while (!stack.isEmpty() && (order=='S') && arr[stack.peek()] >= arr[i]) {
				stack.pop(); 
			}			
			// store the next greater element of current element 
			if (!stack.isEmpty()) {
				next[i] = stack.peek(); 
			} else {
			   // If all elements in S were smaller than arr[i] 
				next[i] = -1; 
			}
			// Push this element 
			stack.push(i); 
		} 
	} 

	// Function to find Right smaller element of next greater 
	// element 
	public static void nextSmallerOfNextGreater(int arr[]) {

		int nextGreaterIndex[]=new int[arr.length]; // stores indexes of next greater elements 
		int nextSmallerIndex[]=new int[arr.length]; // stores indexes of right smaller elements 
	
		nextGreater(arr, nextGreaterIndex, 'G'); 
		nextGreater(arr, nextSmallerIndex, 'S'); 

		System.out.println("nextGreaterIndex: "+Arrays.toString(nextGreaterIndex));
		System.out.println("nextSmallerIndex: "+Arrays.toString(nextSmallerIndex));
	
		for (int i=0; i< arr.length; i++) { 
			// Find next Smaller index of next Greater index in an arr
			if (nextGreaterIndex[i] != -1 && nextSmallerIndex[nextGreaterIndex[i]] != -1) 
				System.out.print(arr[nextSmallerIndex[nextGreaterIndex[i]]]+" "); 
			else
				System.out.print("-1 "); 
		} 
		System.out.print("\n"); 
	} 

	public static void main(String args[]) { 
		int arr[] = {5, 1, 9, 2, 5, 1, 7}; 
		System.out.println("Array:: "+Arrays.toString(arr));
		nextSmallerOfNextGreater(arr); 
	} 
} 


/*Find next Smaller of next Greater in an array

Given array of integer, find the next smaller of next greater element of every element in array.

Note : Elements for which no greater element exists or no smaller of greater element exist, 
print -1.

Examples:

Input : arr[] = {5, 1, 9, 2, 5, 1, 7}
Output:          2  2 -1  1 -1 -1 -1
Explanation :  
Next Greater ->      Right Smaller 
   5 ->  9             9 ->  2 
   1 ->  9             9 ->  2
   9 -> -1            -1 -> -1
   2 ->  5             5 ->  1
   5 ->  7             7 -> -1
   1 ->  7             7 -> -1
   7 -> -1            -1 -> -1 

Input  : arr[] = {4, 8, 2, 1, 9, 5, 6, 3}
Output :          2  5  5  5 -1  3 -1 -1 */