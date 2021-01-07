// Sort a nearly sorted (or K sorted) array

//javac -d classes KSortArray.java  && cd classes && java KSortArray && cd ..

import java.util.Iterator; 
import java.util.PriorityQueue; 

class KSortArray { 

	private static void kSort(int[] arr, int n, int k) { 
		// min heap 
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); 

		// add first k + 1 items to the min heap 
		for(int i = 0; i < k + 1; i++) { 
			priorityQueue.add(arr[i]); 
		} 

		int index = 0; 
		for(int i = k + 1; i < n; i++) { 
			arr[index++] = priorityQueue.poll(); 
			priorityQueue.add(arr[i]); 
		} 

		Iterator<Integer> itr = priorityQueue.iterator(); 

		while(itr.hasNext()) { 
			arr[index++] = priorityQueue.poll(); 
		} 

	} 

	// A utility function to print the array 
	private static void printArray(int[] arr, int n) {

		for(int i = 0; i < n; i++) 
			System.out.print(arr[i] + " "); 
	} 


	public static void main(String[] args) { 
		int k = 3; 
		int arr[] = { 2, 6, 3, 12, 56, 8 }; 
		int n = arr.length; 
		
		kSort(arr, n, k); 

		System.out.println("\n\nFollowing is sorted array"); 
		printArray(arr, n); 
		System.out.println(); 
	} 
} 


