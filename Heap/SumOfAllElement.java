// Sum of all elements between k1’th and k2’th smallest elements

import java.util.Arrays; 

class SumOfAllElement { 

	// Returns sum between two kth smallest 
	// element of array 

	static int sumBetweenTwoKth(int arr[], int k1, int k2) { 
		// Sort the given array 
		Arrays.sort(arr); 

		// Below code is equivalent to 
		int result = 0; 

		for (int i = k1; i < k2-1; i++) 
			result += arr[i]; 

		return result; 
	} 

	public static void main(String[] args) { 

		int arr[] = { 20, 8, 22, 4, 12, 10, 14 }; 
		int n = arr.length; 

		int k1 = 3, k2 = 6; 

		System.out.print(sumBetweenTwoKth(arr, k1, k2)); 
	} 
} 

/*Sum of all elements between k1’th and k2’th smallest elements


Given an array of integers and two numbers k1 and k2. Find the sum of all elements between given two k1’th and k2’th smallest elements of the array. It may be assumed that (1 <= k1 < k2 <= n) and all elements of array are distinct.
Examples :

Input : arr[] = {20, 8, 22, 4, 12, 10, 14},  k1 = 3,  k2 = 6  
Output : 26          
         3rd smallest element is 10. 6th smallest element 
         is 20. Sum of all element between k1 & k2 is
         12 + 14 = 26

Input : arr[] = {10, 2, 50, 12, 48, 13}, k1 = 2, k2 = 6 
Output : 73 */

