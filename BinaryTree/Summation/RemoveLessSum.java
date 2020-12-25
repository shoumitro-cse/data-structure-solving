// Remove all nodes which don’t lie in any path with sum>= k

//javac -d classes RemoveLessSum.java  && cd classes && java RemoveLessSum && cd ..

import java.util.*; 

class RemoveLessSum { 

	// A Binary Tree Node 
	static class Node { 
		int data; 
		Node left, right; 
	}; 

	static class INT { 
		int v; 
		INT(int a) { 
			v = a; 
		} 
	} 

	static Node newNode(int data) 
	{ 
		Node node = new Node(); 
		node.data = data; 
		node.left = node.right = null; 
		return node; 
	} 

	// print the tree in LVR (Inorder traversal) way. 
	static void print(Node root) { 
		if (root != null) { 
			print(root.left); 
			System.out.print(root.data + " "); 
			print(root.right); 
		} 
	} 

	// A utility function to get maximum of two integers 
	static int max(int l, int r) { 
		return (l > r ? l : r); 
	} 
	
	// Main function which truncates the binary tree. 
	static Node pruneUtil(Node root, int k, INT sum) { 
		// Base Case 
		if (root == null) 
			return null; 
		// Initialize left and right sums as sum from root to this node (including this node) 
		INT lsum = new INT(sum.v + root.data); 
		INT rsum = new INT(lsum.v); 
		// Recursively prune left and right subtrees 
		root.left = pruneUtil(root.left, k, lsum); 
		root.right = pruneUtil(root.right, k, rsum); 
		// Get the maximum of left and right sums 
		sum.v = max(lsum.v, rsum.v); 
		// System.out.println("\n"+lsum.v+" "+rsum.v);
		// If maximum is smaller than k, then this node must be deleted 
		if (sum.v < k) { 
			root = null; 
		} 
		return root; 
	} 

	// A wrapper over pruneUtil() 
	static Node prune(Node root, int k) { 
		INT sum = new INT(0); 
		return pruneUtil(root, k, sum); 
	} 

	// Driver Code 
	public static void main(String args[]) {

		int k = 8; 
		Node root = newNode(1); 
		root.left = newNode(2); 
		root.right = newNode(3); 
		root.left.left = newNode(4); 
		root.left.right = newNode(5); 
		root.right.left = newNode(6); 
		root.right.right = newNode(7);

		/*		  1 
		      /      \
		     2        3
		   /   \     /  \
		  4     5   6    7*/

/*		root.left.left.left = newNode(8); 
		root.left.left.right = newNode(9); 
		root.left.right.left = newNode(12); 
		root.right.right.left = newNode(10); 
		root.right.right.left.right = newNode(11); 
		root.left.left.right.left = newNode(13); 
		root.left.left.right.right = newNode(14); 
		root.left.left.right.right.left = newNode(15); */

/*		          1 
		      /      \
		     2        3
		   /   \     /  \
		  4     5   6    7
		 / \    /       /
		8   9  12      10
		   / \           \
		  13  14         11
		      / 
		     15 */


		System.out.println("Tree before truncation\n"); 
		print(root); 

		root = prune(root, k); // k is 45 

		System.out.println("\n\nTree after truncation\n"); 
		print(root); 
		System.out.println(""); 
	} 
} 

/*
Remove all nodes which don’t lie in any path with sum>= k

Given a binary tree, a complete path is defined as a path from root to a leaf. The sum of all nodes on that path is defined as the sum of that path. Given a number K, you have to remove (prune the tree) all nodes which don’t lie in any path with sum>=k.

Note: A node can be part of multiple paths. So we have to delete it only in case when all paths from it have sum less than K.

Consider the following Binary Tree
          1 
      /      \
     2        3
   /   \     /  \
  4     5   6    7
 / \    /       /
8   9  12      10
   / \           \
  13  14         11
      / 
     15 

For input k = 20, the tree should be changed to following
(Nodes with values 6 and 8 are deleted)
          1 
      /      \
     2        3
   /   \        \
  4     5        7
   \    /       /
    9  12      10
   / \           \
  13  14         11
      / 
     15 

For input k = 45, the tree should be changed to following.
      1 
    / 
   2   
  / 
 4  
  \   
   9    
    \   
     14 
     /
    15 
*/