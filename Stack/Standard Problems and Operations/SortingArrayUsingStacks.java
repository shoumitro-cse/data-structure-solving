// Java program to sort an array using stack 

//javac -d classes SortingArrayUsingStacks.java  && cd classes && java SortingArrayUsingStacks && cd ..

import java.io.*; 
import java.util.*; 

class SortingArrayUsingStacks 
{ 
	// This function return 
	// the sorted stack 
	static Stack<Integer> sortStack(Stack<Integer> input) {

		Stack<Integer> tmpStack = new Stack<Integer>(); 
	
		while (!input.empty()) {
			// pop out the first element 
			int tmp = input.pop(); 
			while (!tmpStack.empty() && tmpStack.peek() < tmp) { 
				input.push(tmpStack.pop()); 
			} 
			tmpStack.push(tmp); 
		} 
	
		return tmpStack; 
	} 
	
	//Time Complexity : O(n*n)
	static void sortArrayUsingStacks(int []arr, int n) { 
		// push array elements to stack 
		Stack<Integer> input = new Stack<Integer>(); 

		for (int i = 0; i < n; i++) 
			input.push(arr[i]); 
	
		// Sort the temporary stack 
		Stack<Integer> tmpStack = sortStack(input); 
	
		// Put stack elements in arrp[] 
		for (int i = 0; i < n; i++) { 
			arr[i] = tmpStack.pop(); 
		} 
	} 
	
	// Driver Code 
	public static void main(String args[]) 
	{ 
		int []arr = {10, 5, 15, 45}; 
		int n = arr.length; 

		System.out.println(Arrays.toString(arr)); 
	
		sortArrayUsingStacks(arr, n); 
	
		System.out.println(Arrays.toString(arr)); 
		System.out.println(" "); 
	} 
} 


/*Sorting array using Stacks

Given an array of elements, task is to sort these elements using stack.

Prerequisites : Stacks

Examples :

Input :  8 5 7 1 9 12 10
Output : 1 5 7 8 9 10 12 
Explanation :
Output is sorted element set

Input :  7 4 10 20 2 5 9 1
Output : 1 2 4 5 7 9 10 20 */