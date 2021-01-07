// Java code for k largest elements in an array

import java.util.Arrays;
import java.util.Collections;

class kLargestElements {

	public static void kLargest(Integer[] arr, int k)
	{

		Arrays.sort(arr, Collections.reverseOrder());

		// Print the first kth largest elements
		for (int i = 0; i < k; i++)
			System.out.print(arr[i] + " ");
	}

	public static void main(String[] args)
	{
		Integer arr[] = new Integer[] { 1, 23, 12, 9, 30, 2, 50 };
		int k = 3;
		kLargest(arr, k);
	}
}


/*import java.io.*;
import java.util.*;

class kLargestElements {

	public static void FirstKelements(int arr[], int size, int k) {
		// Creating Min Heap for given
		// array with only k elements
		// Create min heap with priority queue
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for(int i = 0; i < k; i++) {
			minHeap.add(arr[i]);
		}
		
		// Loop For each element in array
		// after the kth element
		for(int i = k; i < size; i++) {
			
			if (minHeap.peek() > arr[i]) {
				continue;
			} else {
				minHeap.poll();
				minHeap.add(arr[i]);
			}
		}
		
		// Now min heap contains k maximum
		// elements, Iterate and print
		Iterator iterator = minHeap.iterator(); 
		
		while (iterator.hasNext()) { 
			System.out.print(iterator.next() + " "); 
		} 
	}

	// Driver code
	public static void main (String[] args)
	{
		int arr[] = { 11, 3, 2, 1, 15, 5, 4,45, 88, 96, 50, 45 };
		
		int size = arr.length;
		// Size of Min Heap
		int k = 3;
		
		FirstKelements(arr, size, k);
	}
}

*/
