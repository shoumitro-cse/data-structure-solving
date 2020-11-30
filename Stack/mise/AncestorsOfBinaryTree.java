// Java program to print all ancestors of a given key 
//Iterative method to find ancestors of a given binary tree

//javac -d classes AncestorsOfBinaryTree.java  && cd classes && java AncestorsOfBinaryTree && cd .

import java.util.*; 

class AncestorsOfBinaryTree { 

	// Structure for a tree node 
	static class Node { 
		int data; 
		Node left, right; 
	} 

	// A utility function to 
	// create a new tree node 
	static Node newNode(int data) { 
		Node node = new Node(); 
		node.data = data; 
		node.left = null; 
		node.right = null; 
		return node; 
	} 

	// Iterative Function to print 
	// all ancestors of a given key 
	static void printAncestors(Node root, int key) { 

		if (root == null) 
			return; 
		// Create a stack to hold ancestors 
		Stack<Node> st = new Stack<Node> (); 

		while (true) { 

			while (root != null && root.data != key) { 
				st.push(root); // push current node 
				root = root.left; // move to next node 
			} 
 
			if (root != null && root.data == key) 
				break; 

			if (st.peek().right == null) 
			{ 
				root = st.peek(); 
				st.pop(); 

				while (!st.isEmpty() && st.peek().right == root) { 
					root = st.peek(); 
					st.pop(); 
				} 
			} 
			root = st.isEmpty() ? null : st.peek().right; 
		} 

		// If stack is not empty, print contents of stack 
		// Here assumption is that the key is there in tree 
		while (!st.isEmpty()) 
		{ 
			System.out.print(st.peek().data + " "); 
			st.pop(); 
		} 
		System.out.println(""); 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		// Let us construct a binary tree 
		Node root = newNode(1); 
		root.left = newNode(2); 
		root.right = newNode(7); 
		root.left.left = newNode(3); 
		root.left.right = newNode(5); 
		root.right.left = newNode(8); 
		root.right.right = newNode(9); 
		root.left.left.left = newNode(4); 
		root.left.right.right = newNode(6); 
		root.right.right.left = newNode(10); 

/*		            1
		        /       \
		       2         7
		     /   \     /   \
		    3     5    8    9 
		   /       \       /
		  4         6     10 
		  
		Key = 6 
		Output : 5 2 1
		Ancestors of 6 are 5, 2 and 1.*/

		int key = 6; 
		printAncestors(root, key); 
	} 
} 

