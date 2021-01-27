// java find maximum difference of subset sum
//Maximum possible difference of two subsets of an array


import java .io.*;

public class MaxDiffSubsetSum {
	
	// function for maximum subset diff
	static int maxDiff(int []arr, int n) {

		int SubsetSum_1 = 0, SubsetSum_2 = 0;

		for (int i = 0; i <= n - 1; i++) {
			boolean isSingleOccurance = true;
			for (int j = i + 1; j <= n - 1; j++) {
				// if frequency of any element is two make both equal to zero
				if (arr[i] == arr[j]) {
					isSingleOccurance = false;
					arr[i] = arr[j] = 0;
					break;
				}
			}

			if (isSingleOccurance) {
				if (arr[i] > 0)
					SubsetSum_1 += arr[i];
				else
					SubsetSum_2 += arr[i];
			}
		}
		
		return Math.abs(SubsetSum_1 - SubsetSum_2);
	}
	
	static public void main (String[] args) {
		int []arr = { 4, 2, -3, 3, -2, -2, 8 };
		int n = arr.length;
		System.out.println("Maximum Difference = " + maxDiff(arr, n));
	}
}


/*
Maximum possible difference of two subsets of an array


Given an array of n-integers. The array may contain repetitive elements but the highest frequency of any elements must not exceed two. You have to make two subsets such that the difference of the sum of their elements is maximum and both of them jointly contain all elements of the given array along with the most important condition, no subset should contain repetitive elements. 
Examples: 

Input : arr[] = {5, 8, -1, 4}
Output : Maximum Difference = 18
Explanation : 
Let Subset A = {5, 8, 4} & Subset B = {-1}
Sum of elements of subset A = 17, of subset B = -1
Difference of Sum of Both subsets = 17 - (-1) = 18

Input : arr[] = {5, 8, 5, 4}
Output : Maximum Difference = 12
Explanation : 
Let Subset A = {5, 8, 4} & Subset B = {5}
Sum of elements of subset A = 17, of subset B = 5
Difference of Sum of Both subsets = 17 - 5 = 12

*/