//Find top k (or most frequent) numbers in a stream

//javac -d classes TopKNum.java  && cd classes && java TopKNum && cd ..

import java.io.*; 
import java.util.*; 

class TopKNum { 

	// function to search in top vector for element 
	static int find(int[] arr, int ele) { 
		for (int i = 0; i < arr.length; i++) 
			if (arr[i] == ele) 
				return i; 
		return -1; 
	} 

	// Function to print top k numbers 
	static void kTop(int[] a, int n, int k) { 
		
		// vector of size k+1 to store elements 
		int[] top = new int[k+1]; 

		// array to keep track of frequency 
		HashMap<Integer, Integer> freq = new HashMap<>();

		for (int i = 0; i <= k; i++) { 
		  freq.put(i, 0); 
		}

		// iterate till the end of stream 
		for (int m = 0; m < n; m++) { 
			// increase the frequency 
			if (freq.containsKey(a[m])) 
				freq.put(a[m], freq.get(a[m])+1); 
			else
				freq.put(a[m], 1); 
			// store that element in top vector 
			top[k] = a[m]; 
			// search in top vector for same element 
			int i = find(top, a[m]); 
			--i; 
			// iterate from the position of element to zero 
			while (i >= 0) { 
				// compare the frequency and swap if higher frequency element is stored next to it 
				if (freq.get(top[i]) < freq.get(top[i=+1])) { 
					int temp = top[i]; 
					top[i] = top[i+1]; 
					top[i+1] = temp; 
				} else if ((freq.get(top[i]) == freq.get(top[i+1])) && (top[i] > top[i+1])) { 
				    // if frequency is same compare the elements and swap if next element is high 
					int temp = top[i]; 
					top[i] = top[i+1]; 
					top[i+1] = temp; 
				} else {
					break; 
				}

				--i; 
			} 

			// print top k elements 
			for (int j = 0; j < k && top[j] != 0; ++j) {
				System.out.print(top[j] + " "); 
			}

		} 

		System.out.println(); 
	} 

	public static void main(String args[]) { 
		int k = 4; 
		int[] arr = { 5, 2, 1, 3, 2 }; 
		int n = arr.length; 
		kTop(arr, n, k); 
	} 
} 



/*
Find top k (or most frequent) numbers in a stream

Given an array of n numbers. Your task is to read numbers from the array and 
keep at-most K numbers at the top (According to their decreasing frequency) 
every time a new number is read. We basically need to print top k numbers 
sorted by frequency when input stream has included k distinct elements, 
else need to print all distinct elements sorted by frequency.

Examples:

Input : arr[] = {5, 2, 1, 3, 2}
k = 4
Output : 5 2 5 1 2 5 1 2 3 5 2 1 3 5

Explanation:

After reading 5, there is only one element 5 whose frequency is max till now.
so print 5.
After reading 2, we will have two elements 2 and 5 with the same frequency.
As 2, is smaller than 5 but their frequency is the same so we will print 2 5.
After reading 1, we will have 3 elements 1, 2 and 5 with the same frequency,
so print 1 2 5.
Similarly after reading 3, print 1 2 3 5
After reading last element 2 since 2 has already occurred so we have now a
frequency of 2 as 2. So we keep 2 at the top and then rest of the element
with the same frequency in sorted order. So print, 2 1 3 5.
Input : arr[] = {5, 2, 1, 3, 4}
k = 4
Output : 5 2 5 1 2 5 1 2 3 5 1 2 3 4
Explanation:

After reading 5, there is only one element 5 whose frequency is max till now.
so print 5.
After reading 2, we will have two elements 2 and 5 with the same frequency.
As 2, is smaller than 5 but their frequency is the same so we will print 2 5.
After reading 1, we will have 3 elements 1, 2 and 5 with the same frequency,
so print 1 2 5.
Similarly after reading 3, print 1 2 3 5
After reading last element 4, All the elements have same frequency
So print, 1 2 3 4.
*/
