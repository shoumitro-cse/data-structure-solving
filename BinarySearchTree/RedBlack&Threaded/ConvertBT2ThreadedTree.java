//Convert a Binary Tree to Threaded binary tree | Set 2 (Efficient)

//javac -d classes ConvertBT2ThreadedTree.java  && cd classes && java ConvertBT2ThreadedTree && cd ..

import java.util.*; 

class ConvertBT2ThreadedTree { 
	 // structure of a node in threaded binary tree 
	static class Node { 
		int key; 
		Node left, right; 
		// Used to indicate whether the right pointer is a normal right pointer or a pointer 
		// to inorder successor. 
		boolean isThreaded; 
	}; 
		
	// Converts tree with given root to threaded 
	// binary tree. 
	// This function returns rightmost child of 
	// root. 
	static Node createThreaded(Node root) 
	{ 
		// Base cases : Tree is empty or has single 
		//			 node 
		if (root == null) 
			return null; 

		if (root.left == null && root.right == null) 
			return root; 
		// Find predecessor if it exists 
		if (root.left != null) { 
			// Find predecessor of root (Rightmost child in left subtree) 
			Node l = createThreaded(root.left); 
			// Link a thread from predecessor to root. 
			l.right = root; 
			l.isThreaded = true; 
		} 
		// If current node is rightmost child 
		if (root.right == null) 
			return root; 
		// Recur for right subtree. 
		return createThreaded(root.right); 
	} 
		
	// A utility function to find leftmost node 
	// in a binary tree rooted with 'root'. 
	// This function is used in inOrder() 
	static Node leftMost(Node root) { 
		while (root != null && root.left != null) 
			root = root.left; 
		return root; 
	} 
		
	// Function to do inorder traversal of a threadded binary tree 
	static void inOrder(Node root) 
	{ 
		if (root == null) return; 
		// Find the leftmost node in Binary Tree 
		Node cur = leftMost(root); 
		while (cur != null) { 
			System.out.print(cur.key + " "); 
			// If this Node is a thread Node, then go to inorder successor 
			if (cur.isThreaded) 
				cur = cur.right; 
			else // Else go to the leftmost child in right subtree 
				cur = leftMost(cur.right); 
		} 
	} 
		
	// A utility function to create a new node 
	static Node newNode(int key) { 
		Node temp = new Node(); 
		temp.left = temp.right = null; 
		temp.key = key; 
		return temp; 
	} 
		
	// Driver program to test above functions 
	public static void main(String args[]) 
	{ 
	   /*       1  
	            / \  
	           2   3  
	          / \ / \  
	         4  5 6  7   */
		Node root = newNode(1); 
		root.left = newNode(2); 
		root.right = newNode(3); 
		root.left.left = newNode(4); 
		root.left.right = newNode(5); 
		root.right.left = newNode(6); 
		root.right.right = newNode(7); 
		
		createThreaded(root); 
		
		System.out.println("Inorder traversal of created "+"threaded tree is\n"); 
		inOrder(root); 
	} 
} 

/*
Convert a Binary Tree to Threaded binary tree | Set 2 (Efficient)

Idea of Threaded Binary Tree is to make inorder traversal faster and do it without stack and without recursion. In a simple threaded binary tree, the NULL right pointers are used to store inorder successor. Where-ever a right pointer is NULL, it is used to store inorder successor.

Following diagram shows an example Single Threaded Binary Tree. The dotted lines represent threads.


Following is structure of a single-threaded binary tree.

struct Node 
{ 
    int key; 
    Node *left, *right; 
  
    // Used to indicate whether the right pointer is a normal right  
    // pointer or a pointer to inorder successor. 
    bool isThreaded;  
};

*/