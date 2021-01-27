// Java program to count cumlative frequencies of elements in an unsorted array. 

import java.util.*; 

class CountCumlativeFreq {

	static void countFreq(int[] a, int n) {

		// Insert elements and their frequencies in hash map. 
		SortedMap<Integer, Integer> hm = new TreeMap<>(); 
		for (int i = 0; i < n; i++) {
			hm.put(a[i], hm.get(a[i]) == null ? 1 : hm.get(a[i]) + 1); 
		}

		int cumul = 0; 

		// iterate the set and print the cumulative frequency 
		for (SortedMap.Entry<Integer, Integer> x : hm.entrySet()) { 
			cumul += x.getValue(); 
			System.out.println(x.getKey() + " " + cumul); 
		} 
	} 

	public static void main(String[] args) { 
		int[] a = { 1, 3, 2, 4, 2, 1 }; 
		int n = a.length; 
		countFreq(a, n); 
	} 
} 

/*
Cumulative frequency of count of each element in an unsorted array

Given an unsorted array. The task is to calculate the cumulative frequency of 
each element of the array using count array.

Examples:

Input : arr[] = [1, 2, 2, 1, 3, 4]
Output :1->2
        2->4
        3->5
        4->6

Input : arr[] = [1, 1, 1, 2, 2, 2]
Output :1->3
        2->6
*/