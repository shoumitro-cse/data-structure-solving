// Find smallest range containing elements from k lists

// javac -d classes FindSmallestRange.java  && cd classes && java FindSmallestRange && cd ..

class FindSmallestRange { 

	static final int N = 5; 
	// array for storing the current index of list i 
	static int ptr[] = new int[501]; 
	// This function takes an k sorted lists in the form of 
	// 2D array as an argument. It finds out smallest range 
	// that includes elements from each of the k lists. 
	static void findSmallestRange(int arr[][], int n, int k) { 
		
		int i, minval, maxval, minrange, minel = 0, maxel = 0, flag, minind; 
		
		// initializing to 0 index; 
		for (i = 0; i <= k; i++) { 
			ptr[i] = 0; 
		} 

		minrange = Integer.MAX_VALUE; 
		
		while (true) { 
			// for mainting the index of list containing the minimum element 
			minind = -1; 
			minval = Integer.MAX_VALUE; 
			maxval = Integer.MIN_VALUE; 
			flag = 0; 

			// iterating over all the list 
			for (i = 0; i < k; i++) { 
				// if every element of list[i] is traversed then break the loop 
				if (ptr[i] == n) { 
					flag = 1; 
					break; 
				} 
				// find minimum value among all the list elements pointing by the ptr[] array 
				if (ptr[i] < n && arr[i][ptr[i]] < minval) { 
					minind = i; // update the index of the list 
					minval = arr[i][ptr[i]]; 
				} 
				// find maximum value among all the list elements pointing by the ptr[] array 
				if (ptr[i] < n && arr[i][ptr[i]] > maxval) { 
					maxval = arr[i][ptr[i]]; 
				} 
			} 

			// if any list exhaust we will not get any better answer, so break the while loop 
			if (flag == 1) { 
				break; 
			} 

			ptr[minind]++; 

			// updating the minrange 
			if ((maxval - minval) < minrange) { 
				minel = minval; 
				maxel = maxval; 
				minrange = maxel - minel; 
			} 
		} 
		System.out.printf("The smallest range is [%d, %d]\n", minel, maxel); 
	} 

	public static void main(String[] args) { 

		int arr[][] = { 
			{ 4, 7, 9, 12, 15 }, 
			{ 0, 8, 10, 14, 20 }, 
			{ 6, 12, 16, 30, 50 } 
		}; 

		int k = arr.length; 

		findSmallestRange(arr, N, k); 
	} 
} 


/*
Find smallest range containing elements from k lists

Given k sorted lists of integers of size n each, find the smallest range that includes at least element from each of the k lists. If more than one smallest ranges are found, print any one of them.

Example:

Input: K = 3
arr1[] : [4, 7, 9, 12, 15]
arr2[] : [0, 8, 10, 14, 20]
arr3[] : [6, 12, 16, 30, 50]
Output:
The smallest range is [6 8]

Explanation: Smallest range is formed by 
number 7 from the first list, 8 from second
list and 6 from the third list.

Input: k = 3
arr1[] : [4, 7]
arr2[] : [1, 2]
arr3[] : [20, 40]
Output:
The smallest range is [2 20]

Explanation:The range [2, 20] contains 2, 4, 7, 20
which contains element from all the three arrays.
*/