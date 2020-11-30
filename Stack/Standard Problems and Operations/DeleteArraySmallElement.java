//Delete array elements which are smaller than next or become smaller

//javac -d classes DeleteArraySmallElement.java  && cd classes && java DeleteArraySmallElement && cd ..

import java.util.*; 

//Java program to delete elements from array. 
class DeleteArraySmallElement { 

// Function for deleting k elements 
	static void deleteElements(int arr[], int n, int k) { 
		// Create a stack and push arr[0] 
		Stack<Integer> s = new Stack<>(); 
		s.push(arr[0]); 

		int count = 0; 

		// traversing a loop from i = 1 to n 
		for (int i = 1; i < n; i++) { 
			// condition for deleting an element 
			while (!s.empty() && s.peek() < arr[i] && count < k) { 
				s.pop(); 
				count++; 
			} 
			s.push(arr[i]); 
		} 

		// Putting elements of stack in a vector 
		// from end to begin. 
		int m = s.size(); 
		int[] v = new int[m]; // Size of vector is m 
		while (!s.empty()) { 
			v[--m] = s.pop(); 
		} 

		System.out.println(Arrays.toString(v)); 
	} 


	public static void main(String[] args) { 
		int k = 2; 
		int arr[] = {20, 10, 25, 30, 40}; 
		deleteElements(arr, arr.length, k); 
	} 
} 

/*Delete array elements which are smaller than next or become smaller

Given an array arr[] and a number k. The task is to delete k elements which are smaller 
than next element (i.e., we delete arr[i] if arr[i] < arr[i+1]) or become smaller than 
next because next element is deleted.

Examples:

Input       : arr[] = { 3, 100, 1 }
              k = 1
Output      : 100, 1
Explanation : arr[0] < arr[1] means 3 is less than
              100, so delete 3

Input       : arr[] = {20, 10, 25, 30, 40}
              k = 2
Output      : 25 30 40
Explanation : First we delete 10 because it follows
              arr[i] < arr[i+1]. Then we delete 20
              because 25 is moved next to it and it
              also starts following the condition.

Input       : arr[] = { 23, 45, 11, 77, 18}
              k = 3
Output      : 77, 18
Explanation : We delete 23, 45 and 11 as they follow  
              the condition arr[i] < arr[i+1]*/