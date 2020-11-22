// Java program to construct a linked list from given 2D matrix 
//javac -d classes LinkedListFrom2DMatrix.java  && cd classes && java LinkedListFrom2DMatrix && cd ..

public class LinkedListFrom2DMatrix { 

	// node of linked list 
	static class Node { 
		int data; 
		Node right; 
		Node down; 
	}; 

	// returns head pointer of linked list constructed from 2D matrix 
	// time complexity O(m*n) and space O(m*n)
	static Node construct(int arr[][], int i, int j, int m, int n) { 
		// return if i or j is out of bounds 
		if (i > n - 1 || j > m - 1) { // m=3, n=3
			return null; 
		}
		// create a new node for current i and j 
		// and recursively allocate its down and right pointers 
		Node temp = new Node(); 
		temp.data = arr[i][j]; 
		temp.right = construct(arr, i, j + 1, m, n); 
		temp.down = construct(arr, i + 1, j, m, n); 
		return temp; 
	} 

/*	1 -> 2 -> 3 -> NULL
	|    |    |
	v    v    v
	4 -> 5 -> 6 -> NULL
	|    |    |
	v    v    v
	7 -> 8 -> 9 -> NULL
	|    |    |
	v    v    v
	NULL NULL NULL*/

	static void display(Node head) { 
		// pointer to move right 
		Node __right; 
		// pointer to move down 
		Node __down = head; 
		// loop till node->down is not NULL 
		while (__down != null) { 
			__right = __down; 
			// loop till node->right is not NULL 
			while (__right != null) { 
				System.out.print(__right.data + " "); 
				__right = __right.right; 
			} 
			System.out.println(); 
			__down = __down.down; 
		} 
	} 

	// driver program 
	public static void main(String args[]) { 
		// 2D matrix 
		int m = 3, n = 3; 
		int arr[][] = { 
			            { 1, 2, 3 }, 
						{ 4, 5, 6 }, 
					    { 7, 8, 9 } 
					  }; 

		Node head = construct(arr, 0, 0, m, n); 
		display(head); 
	} 

} 


/*
Construct a linked list from 2D matrix

Given a matrix. Convert it into a linked list matrix such that each node is 
connected to its next right and down node.

Example:

Input : 2D matrix 
1 2 3
4 5 6
7 8 9

Output :
1 -> 2 -> 3 -> NULL
|    |    |
v    v    v
4 -> 5 -> 6 -> NULL
|    |    |
v    v    v
7 -> 8 -> 9 -> NULL
|    |    |
v    v    v
NULL NULL NULL


*/