// Replace node with depth in a binary tree

class ReplaceNodeWithDepth { 

	/* A tree node structure */
	static class Node 
	{ 
		int data; 
		Node left, right; 
	} 

	/* Utility function to create a 
	new Binary Tree node */
	static Node newNode(int data) 
	{ 
		Node temp = new Node(); 
		temp.data = data; 
		temp.left = null; 
		temp.right = null;	 
		return temp; 
	} 

	// Helper function replaces the data with depth 
	// Note : Default value of level is 0 for root. 
	static void replaceNode(Node node, int level) 
	{ 
		// Base Case 
		if (node == null) 
			return;
		// Replace data with current depth 
		node.data = level; 

		replaceNode(node.left, level+1); 
		replaceNode(node.right, level+1); 
	} 

	// A utility function to print inorder 
	// traversal of a Binary Tree 
	static void printInorder(Node node) 
	{ 
		if (node == null) 
			return; 
		printInorder(node.left); 
		System.out.print(node.data + " "); 
		printInorder(node.right); 
	} 

	/* Driver function to test above functions */
	public static void main(String[] args) 
	{ 
		Node root = new Node(); 

		/* Constructing tree given in 
		the above figure */
		root = newNode(3); 
		root.left = newNode(2); 
		root.right = newNode(5); 
		root.left.left = newNode(1); 
		root.left.right = newNode(4); 
		
		System.out.println("Before Replacing Nodes");	 
		printInorder(root); 
		System.out.println(); 

		replaceNode(root, 0); 
		
		System.out.println("After Replacing Nodes"); 
		printInorder(root); 
		System.out.println(); 
		
	} 
} 

/*
Replace node with depth in a binary tree

Given a binary tree, replace each node with its depth value. For example, 
consider the following tree. Root is at depth 0, change its value to 0 and next 
level nodes are at depth 1 and so on.


       3                       0
      /  \                    /   \
     2    5      == >;         1     1
   /   \                   /   \
  1     4                 2     2*/