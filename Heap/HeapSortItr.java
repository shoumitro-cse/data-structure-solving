// Java implementation of Iterative Heap Sort 

//javac -d classes HeapSortItr.java  && cd classes && java HeapSortItr && cd ..

public class HeapSortItr { 

	// function build Max Heap where value 
	// of each child is always smaller than value of their parent 
	static void buildMaxHeap(int arr[], int n) { 
		for (int i = 1; i < n; i++) { 
			// if child is bigger than parent 
			if (arr[i] > arr[(i-1)/2]) { 
				int j = i; 
				// swap child and parent until  parent is smaller 
				while (arr[j] > arr[(j-1)/2]) { 
				   swap(arr, j, (j-1)/2); 
				   j = (j-1)/2; 
				} 
			} 
		} 
	} 

	static void HeapSortItrApply(int arr[], int n) { 

		buildMaxHeap(arr, n); 
		// printArray(arr); 

		for (int i = n-1; i > 0; i--) { 
			// swap value of first indexed with last indexed 
			swap(arr, 0, i); 
			// maintaining heap property after each swapping 
			int j = 0, index; 

			do { 

				index = (2*j + 1); 
				//if left child is smaller than right child point index variable to right child 
				if (index < (i-1) && arr[index] < arr[index+1]) 
				  index++; 

				//if parent is smaller than child then swapping parent with child having higher value 
				if (index < i && arr[j] < arr[index]) 
				  swap(arr, j, index); 

				j = index; 

			} while (index < i); 
		} 
	} 

	public static void swap(int[] a, int i, int j) { 
		int temp = a[i]; 
		a[i]=a[j]; 
		a[j] = temp; 
	} 

	 // A utility function to print array of size n 
	static void printArray(int arr[]) { 
		int n = arr.length; 
		for (int i = 0; i < n; i++) {
		  System.out.print(arr[i] + " "); 
		}
		System.out.println(); 
	} 

	public static void main(String args[]) { 

		int arr[] = {10, 20, 15, 17, 9, 21}; 
		int n = arr.length; 

		System.out.print("Given array: "); 
		printArray(arr); 

		HeapSortItrApply(arr, n); 

		System.out.print("Sorted array: "); 
		printArray(arr); 
	} 
} 

/*
Iterative HeapSort

HeapSort is a comparison based sorting technique where we first build Max Heap and then swaps the root element with last element (size times) and maintains the heap property each time to finally make it sorted.

Examples:

Input :  10 20 15 17 9 21
Output : 9 10 15 17 20 21 

Input:  12 11 13 5 6 7 15 5 19
Output: 5 5 6 7 11 12 13 15 19 

In first Example, first we have to build Max Heap.
So, we will start from 20 as child and check for its parent. Here 10 is smaller, so we will swap these two.
Now, 20 10 15 17 9 21
Now, child 17 is greater than its parent 10. So, both will be swapped and order will be
20 17 15 10 9 21
Now, child 21 is greater than parent 15. So, both will be swapped.
20 17 21 10 9 15
Now, again 21 is bigger than parent 20. So,
21 17 20 10 9 15
This is Max Heap.

Now, we have to apply sorting. Here, we have to swap first element with last one and we have to maintain Max Heap property.
So, after first swapping : 15 17 20 10 9 21
It clearly violates Max Heap property. So, we have to maintain it. So, order will be
20 17 15 10 9 21
17 10 15 9 20 21
15 10 9 17 20 21
10 9 15 17 20 21
9 10 15 17 20 21
Here, underlined part is sorted part.
*/
