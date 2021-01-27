// Subarrays with distinct elements


import java.util.*; 

class DistinctElements { 

	// Returns sum of lengths of all subarrays with distinct elements. 
	public static int sumoflength(int[] arr, int n) { 
		// For maintaining distinct elements. 
		Set<Integer> s = new HashSet<>(); 
		// Initialize ending point and result 
		int j = 0, ans = 0; 
		// Fix starting point 
		for (int i = 0; i < n; i++) { 
			while (j < n && !s.contains(arr[j])) { 
				s.add(arr[i]); 
				j++; 
			} 
			// Calculating and adding all possible length subarrays in arr[i..j] 
			ans += ((j - i) * (j - i + 1)) / 2; 
			// Remove arr[i] as we pick new stating point from next 
			s.remove(arr[i]); 
		} 
		return ans; 
	} 

	public static void main(String[] args) { 
		int[] arr = { 1, 2, 3, 4 }; 
		int n = arr.length; 
		System.out.println(sumoflength(arr, n)); 
	} 
	
} 


/*
Subarrays with distinct elements


Given an array, the task is to calculate the sum of lengths of contiguous subarrays 
having all elements distinct.

Examples:

Input :  arr[] = {1, 2, 3}
Output : 10
{1, 2, 3} is a subarray of length 3 with 
distinct elements. Total length of length
three = 3.
{1, 2}, {2, 3} are 2 subarray of length 2 
with distinct elements. Total length of 
lengths two = 2 + 2 = 4
{1}, {2}, {3} are 3 subarrays of length 1
with distinct element. Total lengths of 
length one = 1 + 1 + 1 = 3
Sum of lengths = 3 + 4 + 3 = 10

Input :  arr[] = {1, 2, 1}
Output : 7

Input :  arr[] = {1, 2, 3, 4}
Output : 20
*/
