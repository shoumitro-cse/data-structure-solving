// Sorted order printing of a given array that represents a BST

//javac -d classes SortedOrder.java  && cd classes && java SortedOrder && cd ..

class SortedOrder { 
	
    private static void printSorted(int[] arr, int start, int end) { 

		if(start > end) 
			return; 
		// print left subtree 
		printSorted(arr, start*2 + 1, end); 
		// print root 
		System.out.print(arr[start] + " "); 
		// print right subtree 
		printSorted(arr, start*2 + 2, end); 
	} 
		
	// driver program to test above function 
	public static void main(String[] args) { 
		int arr[] = {4, 2, 5, 1, 3}; 
			
		printSorted(arr, 0, arr.length-1); 
	} 
} 
	

/*
Sorted order printing of a given array that represents a BST

Given an array that stores a complete Binary Search Tree, write a function that efficiently prints the given array in ascending order.
For example, given an array [4, 2, 5, 1, 3], the function should print 1, 2, 3, 4, 5*/