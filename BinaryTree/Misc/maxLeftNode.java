// Get maximum left node in binary tree

import java.util.*; 

class maxLeftNode { 

	// A Binary Tree Node 
	static class Node { 
		int data; 
		Node left, right; 
	} 

	// Get max of left element using 
	// Inorder traversal 
	static int maxOfLeftElement(Node root) 
	{ 
		int res = Integer.MIN_VALUE; 
		if (root == null) 
			return res; 

		if (root.left != null) 
			res = root.left.data; 
		
		return Math.max(maxOfLeftElement(root.left), Math.max(res, maxOfLeftElement(root.right))); 
	} 

	// Utility function to create a new tree node 
	static Node newNode(int data) 
	{ 
		Node temp = new Node(); 
		temp.data = data; 
		temp.left = null; 
		temp.right = null; 
		return temp; 
	} 

	// Driver program to test above functions 
	public static void main(String[] args) 
	{ 
		// Let us create binary tree shown in above diagram 
		Node root = newNode(7); 
		root.left = newNode(6); 
		root.right = newNode(5); 
		root.left.left = newNode(4); 
		root.left.right = newNode(3); 
		root.right.left = newNode(2); 
		root.right.right = newNode(1); 

		/* 7 
			/ \ 
			6 5 
		/ \ / \ 
		4 3 2 1		 */
		System.out.println(maxOfLeftElement(root)); 
	} 
} 
