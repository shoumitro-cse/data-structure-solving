// Change a Binary Tree so that every node stores sum of all nodes in left subtree

 //javac -d classes EveryNodeStoresSumofAllNodes.java  && cd classes && java EveryNodeStoresSumofAllNodes && cd ..

class EveryNodeStoresSumofAllNodes { 

	// A tree node 
	static class node 
	{ 
		int data; 
		node left, right; 
	} 

   // Time Complexity: O(n)
	static int updatetree(node root) { 
		// Base cases 
		if (root == null) 
			return 0; 

		if (root.left == null && root.right == null) 
			return root.data; 
		// Update left and right subtrees 
		int leftsum = updatetree(root.left); 
		int rightsum = updatetree(root.right); 
		// Add leftsum to current node 
		root.data += leftsum; 
		// Return sum of values under root 
		return root.data + rightsum; 
	} 

	// Utility function to do inorder traversal 
	static void inorder(node node) 
	{ 
		if (node == null) 
			return; 
		inorder(node.left); 
		System.out.print(node.data + " "); 
		inorder(node.right); 
	} 

	// Utility function to create a new node 
	static node newNode(int data) 
	{ 
		node node = new node(); 
		node.data = data; 
		node.left = null; 
		node.right = null; 
		return(node); 
	} 

	// Driver program 
	public static void main(String[] args) { 

		node root = newNode(1); 
		root.left = newNode(2); 
		root.right = newNode(3); 
		root.left.left = newNode(4); 
		root.left.right = newNode(5); 
		root.right.right = newNode(6); 

		 /*Input:
			       1
			      / \
			     2   3
			    / \   \
			   4   5   6

		  Output:
			      12
			     / \
			    6   3
			   / \   \
			  4   5   6*/


		updatetree(root); // return 21
		
		System.out.println("\n\nInorder traversal of the modified tree is"); 
		inorder(root); 
		System.out.println(); 
	} 
} 


/*
Change a Binary Tree so that every node stores sum of all nodes in left subtree

Given a Binary Tree, change the value in each node to sum of all the values in the nodes 
in the left subtree including its own.

Examples:

Input : 
     1
   /   \
 2      3

Output :
    3
  /   \
 2     3


Input
       1
      / \
     2   3
    / \   \
   4   5   6
Output:
      12
     / \
    6   3
   / \   \
  4   5   6*/