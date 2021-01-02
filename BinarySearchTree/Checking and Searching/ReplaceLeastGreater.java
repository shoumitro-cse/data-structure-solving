//replace every element with the least greater element on its right

// javac -d classes ReplaceLeastGreater.java  && cd classes && java ReplaceLeastGreater && cd ..

import java.io.*;

class ReplaceLeastGreater {
	
	// A binary Tree node
	class Node
	{
		int data;
		Node left, right;

		Node(int d)
		{
			data = d;
			left = right = null;
		}
	}

	// Root of BST
	static Node root;
	static Node succ;

	// Constructor
	ReplaceLeastGreater()
	{
		root = null;
		succ = null;
	}

	// A utility function to insert a new node with
	// given data in BST and find its successor 
	Node insert(Node node, int data)
	{
		
		// If the tree is empty, return a new node 
		if (node == null) {
			node = new Node(data);
		}
		// If key is smaller than root's key,
		// go to left subtree and set successor
		// as current node
		if (data < node.data) {
			succ = node;
			node.left = insert(node.left, data);
		}
		// Go to right subtree
		else if (data > node.data)
			node.right = insert(node.right, data);
			
		return node;
	}

	// Function to replace every element with the
	// least greater element on its right
	static void replace(int arr[], int n)
	{
		ReplaceLeastGreater tree = new ReplaceLeastGreater();
		// start from right to left
		for(int i = n-1; i >= 0; i--) {
			succ = null;
			// Insert current element into BST and find its inorder successor
			root = tree.insert(root, arr[i]);
			// Replace element by its inorder successor in BST
			if (succ != null)
				arr[i] = succ.data;
			// No inorder successor
			else
				arr[i] = -1;
		}
	}

	public static void main(String[] args)
	{
		int arr[] = new int[] { 8, 58, 71, 18, 31, 
								32, 63, 92, 43, 3,
								91, 93, 25, 80, 28 };
		int n = arr.length;

		replace(arr, n);

		for(int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}


/*
Replace every element with the least greater element on its right


Given an array of integers, replace every element with the least greater element on 
its right side in the array. If there are no greater element on the right side, replace it with -1.

Examples: 

Input: [8, 58, 71, 18, 31, 32, 63, 92, 
         43, 3, 91, 93, 25, 80, 28]
         
Output: [18, 63, 80, 25, 32, 43, 80, 93, 
         80, 25, 93, -1, 28, -1, -1]


*/