// Java implementation to find k elements with max occurence.

//javac -d classes KFrequentNumbers.java  && cd classes && java KFrequentNumbers && cd ..

import java.util.*;

public class KFrequentNumbers {

	static void print_N_mostFrequentNumber(int[] arr, int n, int k) {

		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
		
		// Put count of all the distinct elements in Map with element as the key & count as the value.
		for (int i = 0; i < n; i++) {
			mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
		}

		// Create a list from elements of HashMap
		List<Map.Entry<Integer, Integer> > list = 
		new ArrayList<Map.Entry<Integer, Integer>> (mp.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)
			{
				if (o1.getValue() == o2.getValue())
					return o2.getKey() - o1.getKey();
				else
					return o2.getValue() - o1.getValue();
			}
		});

		for (int i=0; i<k; i++)
		  System.out.println(list.get(i).getKey());
	}

	// Driver Code to test the code.
	public static void main(String[] args)
	{
		int arr[] = { 3, 1, 4, 4, 5, 2, 6, 1 };
		int n = arr.length;
		int k = 2;
		print_N_mostFrequentNumber(arr, n, k);
	}
}

/*
Find k numbers with most occurrences in the given array


Given an array of n numbers and a positive integer k. 
The problem is to find k numbers with most occurrences, i.e., 
the top k numbers having the maximum frequency. If two numbers have the same 
frequency then the larger number should be given preference. 
The numbers should be displayed in decreasing order of their frequencies. 
It is assumed that the array consists of k numbers with most occurrences.

Examples: 

Input: 
arr[] = {3, 1, 4, 4, 5, 2, 6, 1}, 
k = 2
Output: 4 1
Explanation:
Frequency of 4 = 2
Frequency of 1 = 2
These two have the maximum frequency and 4 is larger than 1.

Input : 
arr[] = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9},
k = 4
Output: 5 11 7 10
Explanation: 
Frequency of 5 = 3
Frequency of 11 = 2
Frequency of 7 = 2
Frequency of 10 = 1
These four have the maximum frequency and 5 is largest among rest.

*/