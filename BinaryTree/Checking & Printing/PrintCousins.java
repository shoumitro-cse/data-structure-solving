// Print cousins of a given node in Binary Tree

//javac -d classes PrintCousins.java  && cd classes && java PrintCousins && cd ..

class PrintCousins { 

	// A Binary Tree Node 
	static class Node 
	{ 
		int data; 
		Node left, right; 
	} 

	// A utility function to create a new Binary Tree Node 
	static Node newNode(int item) 
	{ 
		Node temp = new Node(); 
		temp.data = item; 
		temp.left = null; 
		temp.right = null; 
		return temp; 
	} 

	 // It returns level of the node if it is present in tree, otherwise returns 0.
	static int getLevel(Node root, Node node, int level) { 
		// base cases 
		if (root == null) 
			return 0; 
		if (root == node) 
			return level; 
		// If node is present in left subtree 
		int downlevel = getLevel(root.left, node, level+1); 
		if (downlevel != 0) 
			return downlevel; 
		// If node is not present in left subtree 
		return getLevel(root.right, node, level+1); 
	} 

	 // Print nodes at a given level such that sibling of node is not printed if it exists 
	static void printGivenLevel(Node root, Node node, int level) { 
		// Base cases 
		if (root == null || level < 2) 
			return; 
		// If current node is parent of a node with given level 
		if (level == 2) { 
			if (root.left == node || root.right == node) 
				return; 
			if (root.left != null) 
			   System.out.print(root.left.data + " "); 
			if (root.right != null) 
			  System.out.print(root.right.data + " "); 
		} else if (level > 2) { 
		   // Recur for left and right subtrees 
			printGivenLevel(root.left, node, level-1); 
			printGivenLevel(root.right, node, level-1); 
		} 
	} 

	// This function prints cousins of a given node 
	// Time Complexity : O(n)
	static void printCousins(Node root, Node node) { 
		// Get level of given node 
		int level = getLevel(root, node, 1); //3
		// Print nodes of given level. 
		printGivenLevel(root, node, level); 
	} 

	// Driver Program to test above functions 
	public static void main(String[] args) { 
		Node root = newNode(1); 

		root.left = newNode(2); 
		root.right = newNode(3); 

		root.left.left = newNode(4); 
		root.left.right = newNode(5); 

		root.right.left = newNode(6); 
		root.right.right = newNode(7); 

/*		root.right.left.right = newNode(8); 
		root.left.right.right = newNode(15); */

/*		     1
           /   \
          2     3
        /   \  /  \
       4    5  6   7*/

		System.out.print("\n\n\n"); 
		printCousins(root, root.left.right); //root.left.right=5
		System.out.print("\n"); 
	} 
} 


/*
Print cousins of a given node in Binary Tree

Given a binary tree and a node, print all cousins of given node. Note that siblings should not be printed.

Example:

Input : root of below tree 
             1
           /   \
          2     3
        /   \  /  \
       4    5  6   7
       and pointer to a node say 5.

Output : 6, 7*/