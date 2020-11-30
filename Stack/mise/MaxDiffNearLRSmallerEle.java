// Find maximum difference between nearest left and right smaller elements

//javac -d classes MaxDiffNearLRSmallerEle.java  && cd classes && java MaxDiffNearLRSmallerEle && cd ..

import java.util.*; 

class MaxDiffNearLRSmallerEle 
{ 

	// Function to fill left smaller element for every 
	// element of arr[0..n-1]. These values are filled in result[0..n-1] 
	static void leftSmaller(int arr[], int n, int result[]) { 
		// Create an empty stack 
		Stack<Integer> S = new Stack<>(); 
		// Traverse all array elements 
		// compute nearest smaller elements of every element 
		for (int i = 0; i < n; i++) { 
			// Keep removing top element from S while the top 
			// element is greater than or equal to arr[i] 
			while (!S.empty() && S.peek() >= arr[i]) { 
				S.pop(); 
			} 
			// Store the smaller element of current element 
			if (!S.empty()) { 
				result[i] = S.peek(); 
			} else { 
			    // If all elements in S were greater than arr[i] 
				result[i] = 0; 
			} 
			// Push this element 
			S.push(arr[i]); 
		} 
	} 
	// Function returns maximum difference b/w Left & right smaller element 
	static int findMaxDiff(int arr[], int n) {
		// To store left smaller elements 
		int[] left_arr = new int[n]; 
		// find left smaller element of every element 
		leftSmaller(arr, n, left_arr); 
		// find right smaller element of every element 
		// first reverse the array and do the same process 
		int[] right_arr = new int[n]; // To store right smaller elements in 
		// reverse array 
		reverse(arr); 
		leftSmaller(arr, n, right_arr); 

		reverse(right_arr);

		System.out.println("Left Smaller: "+Arrays.toString(left_arr));
		System.out.println("Right Smaller: "+Arrays.toString(right_arr));
		// find maximum absolute difference b/w left_arr & right_arr 
		// In the reversed array right smaller for arr[i] is 
		// stored at right_arr[n-i-1] 
		int result = -1; 
		for (int i = 0; i < n; i++) { 
			// result = Math.max(result, Math.abs(left_arr[i] - right_arr[n - 1 - i])); 
			result = Math.max(result, Math.abs(left_arr[i] - right_arr[i])); 
		} 

		// return maximum difference b/w left_arr & right_arr 
		return result; 
	} 

	static void reverse(int a[]) {

		int i, k, n = a.length; 
		int temp; 

		for (i = 0; i < n / 2; i++) { 
			temp = a[i]; 
			a[i] = a[n -i-1]; 
			a[n-i-1] = temp; 
		} 
	} 
	
	// Driver code 
	public static void main(String args[]) { 
		int arr[] = {2, 4, 8, 7, 7, 9, 3}; 
		int n = arr.length; 
		System.out.println("Maximum diff : " + findMaxDiff(arr, n)); 
	} 
} 


/*
Find maximum difference between nearest left and right smaller elements

Given an array of integers, the task is to find the maximum absolute difference between 
the nearest left and the right smaller element of every element in the array.

Note: If there is no smaller element on right side or left side of any element then we take 
zero as the smaller element. For example for the leftmost element, the nearest smaller 
element on the left side is considered as 0. Similarly, for rightmost elements, the smaller 
element on the right side is considered as 0.

Examples:

Input : arr[] = {2, 1, 8}
Output : 1
Left smaller  left_arr[] {0, 0, 1}
Right smaller RS[] {1, 0, 0}
Maximum Diff of abs(left_arr[i] - RS[i]) = 1 

Input  : arr[] = {2, 4, 8, 7, 7, 9, 3}
Output : 4
Left smaller   left_arr[] = {0, 2, 4, 4, 4, 7, 2}
Right smaller  RS[] = {0, 3, 7, 3, 3, 3, 0}
Maximum Diff of abs(left_arr[i] - RS[i]) = 7 - 3 = 4 

Input : arr[] = {5, 1, 9, 2, 5, 1, 7}
Output : 1

algo:
Let input array be 'arr[]' and size of array be 'n'

Find all smaller element on left side
     1. Create a new empty stack S and an array LS[]
     2. For every element 'arr[i]' in the input arr[],
          where 'i' goes from 0 to n-1.
        a) while S is nonempty and the top element of 
           S is greater than or equal to 'arr[i]':
           pop S
    
        b) if S is empty:
           'arr[i]' has no preceding smaller value 
            LS[i] = 0 
            
        c) else:
            the nearest smaller value to 'arr[i]' is top
            of stack
              LS[i] = s.top()

        d) push 'arr[i]' onto S   

Find all smaller element on right side
     3. First reverse array arr[]. After reversing the array, 
        right smaller become left smaller.
     4. Create an array RRS[] and repeat steps  1 and 2 to 
        fill RRS (in-place of LS).
         
5. Initialize result as -1 and do following for every element
   arr[i]. In the reversed array right smaller for arr[i] is
   stored at RRS[n-i-1]
      return result = max(result, LS[i]-RRS[n-i-1])

*/