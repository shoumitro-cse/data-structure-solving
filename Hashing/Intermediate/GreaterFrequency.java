// Maximum difference between frequency of two elements such that 
// element having greater frequency is also greater

import java.util.*;

class GreaterFrequency {

	static int maxdiff(int arr[], int n) {

		Map<Integer, Integer> freq = new HashMap<>();

		// Finding the frequency of each element.
		for (int i = 0; i < n; i++) {
			freq.put(arr[i], freq.get(arr[i]) == null ? 1 : freq.get(arr[i]) + 1);
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// finding difference such that element having greater frequency is also
				// greater in value.
				if (freq.get(arr[i]) > freq.get(arr[j]) && arr[i] > arr[j]) {
					ans = Math.max(ans, freq.get(arr[i]) - freq.get(arr[j]));
				} else if (freq.get(arr[i]) < freq.get(arr[j]) && arr[i] < arr[j] ){
					ans = Math.max(ans, freq.get(arr[j]) - freq.get(arr[i]));
				}
			}
		}
		return ans;
	}

	public static void main(String[] args)
	{
		int arr[] = { 3, 1, 3, 2, 3, 2 };
		int n = arr.length;

		System.out.println(maxdiff(arr, n));
	}
}


/*
Maximum difference between frequency of two elements such that element having greater 
frequency is also greater


Given an array of n positive integers with many repeating elements. The task is to 
find maximum difference between the frequency of any two different elements, such that 
the element with greater frequency is also greater in value than the second integer.

Examples:  

Input :  arr[] = { 3, 1, 3, 2, 3, 2 }.
Output : 2
Frequency of 3 = 3.
Frequency of 2 = 2.
Frequency of 1 = 1.
Here difference of frequency of element 3 and 1 is = 3 - 1 = 2.
Also 3 > 1.

*/