// Java program to find difference between max and min sum of array 

import java.util.Arrays; 

class DiffMinMaxSum { 
	// utility function 
	static int find_difference(int arr[], int n, int m) { 
		int max = 0, min = 0; 
		// sort array 
		Arrays.sort(arr); 
		for (int i = 0, j = n-1; i < m; i++, j--) { 
			min += arr[i]; 
			max += arr[j]; 
		} 
	  return (max - min); 
	} 

	public static void main(String arg[]) 
	{ 
		int arr[] = { 1, 2, 3, 4, 5 }; 
		int n = arr.length; 
		int m = 4; 
		System.out.print(find_difference(arr, n, m)); 
	} 
} 


/*Maximum difference between two subsets of m elements

Given an array of n integers and a number m, find the maximum possible difference between 
two sets of m elements chosen from given array.

Examples:

Input : arr[] = 1 2 3 4 5
            m = 4
Output : 4

The maximum four elements are 2, 3, 
4 and 5. The minimum four elements are 
1, 2, 3 and 4. The difference between
two sums is (2 + 3 + 4 + 5) - (1 + 2 + 3 + 4) = 4
  
Input : arr[] = 5 8 11 40 15
           m = 2
Output : 42
The difference is (40 + 15) - (5  + 8)  
*/


