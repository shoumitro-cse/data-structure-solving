//check whether a given Binary Tree is Perfect or not 

//javac -d classes CheckPerfectBinaryTree.java  && cd classes && java CheckPerfectBinaryTree && cd ..

class CheckPerfectBinaryTree { 

	 // Tree node structure 
	static class Node 
	{ 
		int key; 
		Node left, right; 
	} 

	// Returns depth of leftmost leaf. 
	static int findADepth(Node node) { 
		int d = 0; 
		while (node != null) { 
			d++; 
			node = node.left; 
		} 
		return d; 
	} 

	/* This function tests if a binary tree is perfect 
	or not. It basically checks for two things : 
	1) All leaves are at same level 
	2) All internal nodes have two children */
	//Time complexity : O(n)
	static boolean isPerfectRec(Node root, int d, int level) { 
		// An empty tree is perfect 
		if (root == null) 
			return true; 
		// If leaf node, then its depth must be same as depth of all other leaves. 
		if (root.left == null && root.right == null) 
			return (d == level+1); 
		// If internal node and one child is empty 
		if (root.left == null || root.right == null) 
			return false; 
		// Left and right subtrees must be perfect. 
		return isPerfectRec(root.left, d, level+1) && isPerfectRec(root.right, d, level+1); 
	} 

	// Wrapper over isPerfectRec() 
	static boolean isPerfect(Node root) { 
	   int d = findADepth(root); //3
	  // System.out.println(d); 
	   return isPerfectRec(root, d, 0); 
	} 

	/* Helper function that allocates a new node with the 
	given key and NULL left and right pointer. */
	static Node newNode(int k) 
	{ 
		Node node = new Node(); 
		node.key = k; 
		node.right = null; 
		node.left = null; 
		return node; 
	} 

	// Driver Program 
	public static void main(String args[]) 
	{ 
		Node root = null; 
		root = newNode(10); 
		root.left = newNode(20); 
		root.right = newNode(30); 

		root.left.left = newNode(40); 
		root.left.right = newNode(50); 
		root.right.left = newNode(60); 
		root.right.right = newNode(70); 

		/*		       10
		           /       \  
		         20         30  
		        /  \        /  \
		      40    50    60   70*/

		if (isPerfect(root) == true) 
			System.out.println("Yes"); 
		else
			System.out.println("No"); 
	} 
} 


/*
Check whether a given binary tree is perfect or not


Given a Binary Tree, write a function to check whether the given Binary Tree is a prefect Binary Tree or not.

A Binary tree is Perfect Binary Tree in which all internal nodes have two children and all leaves are at same level.

Examples:
The following tree is a perfect binary tree

               10
           /       \  
         20         30  
        /  \        /  \
      40    50    60   70


               18
           /       \  
         15         30  

The following tree is not a perfect binary tree

      1
    /    \
   2       3
    \     /  \   
     4   5    6


A Perfect Binary Tree of height h 
(where height is number of nodes on path from root to leaf) has 2h – 1 nodes.




Below is an idea to check whether a given Binary Tree is perfect or not.

1. Find depth of any node (in below tree we find depth of leftmost node). Let this depth be d.
2. Now recursively traverse the tree and check for following two conditions.
  (i). Every internal node should have both children non-empty
   (ii). All leaves are at depth ‘d’*/