//Sorted Array to Balanced BST

// javac -d classes SortedArrayToBST.java  && cd classes && java SortedArrayToBST && cd ..

class Node { 
	
	int data; 
	Node left, right; 
	
	Node(int d) { 
		data = d; 
		left = right = null; 
	} 
} 

class SortedArrayToBST { 
	
	static Node root; 

	 // A function that constructs Balanced Binary Search Tree from a sorted array 
	Node sortedArrayToBST(int arr[], int start, int end) { 
		 // Base Case 
		if (start > end) { 
			return null; 
		} 
		 // Get the middle element and make it root 
		int mid = (start + end) / 2; 
		Node node = new Node(arr[mid]); 
		 // Recursively construct the left subtree and make it left child of root 
		node.left = sortedArrayToBST(arr, start, mid-1); 
		 // Recursively construct the right subtree and make it right child of root 
		node.right = sortedArrayToBST(arr, mid+1, end); 
		
		return node; 
	} 

	/* A utility function to print preorder traversal of BST */
	void preOrder(Node node) { 
		if (node == null) { 
			return; 
		} 
		System.out.print(node.data + " "); 
		preOrder(node.left); 
		preOrder(node.right); 
	} 
	
	public static void main(String[] args) { 
		
		SortedArrayToBST tree = new SortedArrayToBST(); 
		
		int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7}; 
		int n = arr.length; 

		root = tree.sortedArrayToBST(arr, 0, n - 1); 
		
		System.out.println("Preorder traversal of constructed BST"); 
		tree.preOrder(root); 
	} 
} 

/*
Time Complexity: O(n)
Following is the recurrance relation for sortedArrayToBST().

  T(n) = 2T(n/2) + C
  T(n) -->  Time taken for an array of size n
   C   -->  Constant (Finding middle of array and linking root to left 
                      and right subtrees take constant time) */


/*
Sorted Array to Balanced BST

Given a sorted array. Write a function that creates a Balanced Binary Search Tree 
using array elements.
Examples:

Input:  Array {1, 2, 3}
Output: A Balanced BST
     2
   /  \
  1    3 

Input: Array {1, 2, 3, 4}
Output: A Balanced BST
      3
    /  \
   2    4
 /
1
*/
