// Construct a complete binary tree from given array in level order fashion

// javac -d classes ComBinaryFromArr.java  && cd classes && java ComBinaryFromArr && cd ..

public class ComBinaryFromArr { 
	Node root; 

	// Tree Node 
	static class Node { 
		int data; 
		Node left, right; 
		Node(int data) { 
			this.data = data; 
			this.left = this.right = null; 
		} 
	} 

	// Function to insert nodes in level order 
	// Time Complexity: O(n), where n is the total number of nodes in the tree.
	public Node insertLevelOrder(int[] arr, Node root, int i) { 
		// Base case for recursion 
		if (i < arr.length) { 
			Node temp = new Node(arr[i]); 
			root = temp; 
			// insert left child 
			root.left = insertLevelOrder(arr, root.left, 2 * i + 1); 
			// insert right child 
			root.right = insertLevelOrder(arr, root.right, 2 * i + 2); 
		} 
		return root; 
	} 

	// Function to print tree nodes in InOrder fashion 
	public void inOrder(Node root) { 
		if (root != null) { 
			inOrder(root.left); 
			System.out.print(root.data + " "); 
			inOrder(root.right); 
		} 
	} 

	// Driver program to test above function 
	public static void main(String args[]) { 
		ComBinaryFromArr t2 = new ComBinaryFromArr(); 
		int arr[] = { 1, 2, 3, 4, 5, 6, 6, 6, 6 }; 
		t2.root = t2.insertLevelOrder(arr, t2.root, 0); 
		t2.inOrder(t2.root); 
		System.out.println(""); 
	} 
} 


/*
Construct a complete binary tree from given array in level order fashion

Given an array of elements, our task is to construct a complete binary tree from 
this array in level order fashion. That is, elements from left in the array will be 
filled in the tree level wise starting from level 0.

Examples:

Input  :  arr[] = {1, 2, 3, 4, 5, 6}

Output : Root of the following tree
                  1
                 / \
                2   3
               / \ /
              4  5 6


Input: arr[] = {1, 2, 3, 4, 5, 6, 6, 6, 6, 6}

Output: Root of the following tree
                   1
                  / \
                 2   3
                / \ / \
               4  5 6  6
              / \ /
             6  6 6                             */