// print all values smaller than a given value in Binary Heap 

//javac -d classes PrintSmaller.java  && cd classes && java PrintSmaller && cd ..

class MinHeap { 
	// array of elements in heap 
	int[] harr; 

	// maximum possible size of min heap 
	int capacity; 
	int heap_size; // Current no. of elements. 

	int parent(int i) { return (i - 1) / 2; } 
	int left(int i) { return (2 * i + 1); } 
	int right(int i) { return (2 * i + 2); } 

	// Function to print all elements smaller than k 
	void printSmallerThan(int x, int pos) //x=100, pos=0
	{ 
		/* Make sure item exists */
		if (pos >= heap_size) 
			return; 

		if (harr[pos] >= x) { 
			/* Skip this node and its descendants, 
			as they are all >= x . */
			return; 
		} 

		System.out.print(harr[pos] + " "); 

		printSmallerThan(x, left(pos)); 
		printSmallerThan(x, right(pos)); 
	} 

	// Constructor: Builds a heap of given size 
	public MinHeap(int cap) 
	{ 
		heap_size = 0; 
		capacity = cap; 
		harr = new int[cap]; 
	} 

	// Inserts a new key 'k' 
	void insertKey(int k) 
	{ 
		if (heap_size == capacity) { 
			System.out.println("Overflow: Could not insertKey"); 
			return; 
		} 

		// First insert the new key at the end 
		heap_size++; 
		int i = heap_size - 1; 
		harr[i] = k; 

		// Fix the min heap property if it is violated 
		while (i != 0 && harr[parent(i)] > harr[i]) { 
			swap(i, parent(i)); 
			i = parent(i); 
		} 
	} 

	// A utility function to swap two elements 
	void swap(int x, int y) 
	{ 
		int temp = harr[x]; 
		harr[x] = harr[y]; 
		harr[y] = temp; 
	} 

}; 


class PrintSmaller {

	// Driver code 
	public static void main(String[] args) 
	{ 
		MinHeap h = new MinHeap(15); 
		h.insertKey(3); 
		h.insertKey(2); 
		h.insertKey(15); 
		h.insertKey(5); 
		h.insertKey(4); 
		h.insertKey(45); 
		h.insertKey(80); 
		h.insertKey(6); 
		h.insertKey(150); 
		h.insertKey(77); 
		h.insertKey(120); 

		// Print all nodes smaller than 100. 
		int x = 100; 
		h.printSmallerThan(x, 0); 
		System.out.println();
	} 
}

/*
Print all nodes less than a value x in a Min Heap.


Given a binary min heap and a value x, print all the binary heap nodes having 
value less than the given value x.

Examples : Consider the below min heap as common input two both below examples.

                   2
                /     \
               3        15
            /    \     / \
           5       4  45  80
          / \     / \
         6   150 77 120

Input  : x = 15        
Output : 2 3 5 6 4

Input  : x = 80
Output : 2 3 5 6 4 77 15 45
*/


