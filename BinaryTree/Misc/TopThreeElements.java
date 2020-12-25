//Top three elements in binary tree

import java.util.*; 

class TopThreeElements 
{ 
	static class Node 
	{ 
		int data; 
		Node left; 
		Node right; 
	}; 

	static int first, second, third; 

	/* Helper function that allocates 
	a new Node with the given data and 
	null left and right pointers. */
	static Node newNode(int data) 
	{ 
		Node node = new Node(); 
		node.data = data; 
		node.left = null; 
		node.right = null; 
		return (node); 
	} 

	// function to find three largest element 
	static void threelargest(Node root) { 

		if (root == null) 
			return; 

		if (root.data > first) { 
			third = second; 
			second = first; 
			first = root.data; 
		} else if (root.data > second && root.data != first) { 
			third = second; 
			second = root.data; 
		} else if (root.data > third && root.data != first && root.data != second) 
			third = root.data; 

		threelargest(root.left); 
		threelargest(root.right); 
	} 

	// driver function 
	public static void main(String[] args) 
	{ 
		Node root = newNode(1); 
		root.left = newNode(2); 
		root.right = newNode(3); 
		root.left.left = newNode(4); 
		root.left.right = newNode(5); 
		root.right.left = newNode(4); 
		root.right.right = newNode(5); 
		
		first = 0; second = 0; third = 0; 
		threelargest(root); 
		System.out.print("three largest elements are " + 
						first + " " + second + " " + third); 
	} 
} 

/*
Top three elements in binary tree

We have a simple binary tree and we have to print the top 3 largest 
elements present in the binary tree.

Examples:

Input : 
          1
         /  \
        2    3
       / \   / \
      4  5   4  5
Output :Three largest elements are 5 4 3
*/