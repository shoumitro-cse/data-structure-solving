// Find height of a special binary tree whose leaf nodes are connected


import java.io.*; 
import java.util.*; 

// User defined node class 
class Node { 
	int data; 
	Node left, right; 
	// Constructor to create a new tree node 
	Node(int key) 
	{ 
		data = key; 
		left = right = null; 
	} 
} 

class FindHeightSpecialBT { 

	// function to check if given node is a leaf node or 
	// node 
	static boolean isLeaf(Node node) { 
	 return (node.left != null && node.left.right == node && 
	 	node.right != null && node.right.left == node); 
	} 

	static int maxDepth(Node node) { 
		// if node is NULL, return 0 
		if (node == null) 
			return 0; 
		// if node is a leaf node, return 1 
		if (isLeaf(node)) 
			return 1; 
		// compute the depth of each subtree and take maximum 
		return 1+ Math.max(maxDepth(node.left), maxDepth(node.right)); 
	} 

	// Driver code 
	public static void main(String args[]) {

		Node root = new Node(1); 

		root.left = new Node(2); 
		root.right = new Node(3); 
		root.left.left = new Node(4); 
		root.left.right = new Node(5); 
		root.left.left.left = new Node(6); 

		/*		 1 
		       /   \ 
		      2      3 
		    /  \ 
		   4    5
		  /   
		 6 */

		// Given tree contains 3 leaf nodes 
		Node L1 = root.left.left.left; 
		Node L2 = root.left.right; 
		Node L3 = root.right; 

		// create circular doubly linked list out of leaf nodes of the tree 

		// set next pointer of linked list 
		L1.right = L2; 
		L2.right = L3; 
		L3.right = L1; 

		// set prev pointer of linked list 
		L3.left = L2; 
		L2.left = L1; 
		L1.left = L3; 

		// calculate height of the tree 
		System.out.println("Height of tree is: "+ maxDepth(root)); 
	} 

	
} 


/*
Find height of a special binary tree whose leaf nodes are connected


Given a special binary tree whose leaf nodes are connected to form a circular doubly linked list, 
find its height.
For example, 

         1 
       /   \ 
      2      3 
    /  \ 
   4    5
  /   
 6 
In the above binary tree, 6, 5 and 3 are leaf nodes and they form a circular doubly linked list. 
Here, the left pointer of leaf node will act as a previous pointer of circular doubly linked 
list and its right pointer will act as next pointer of circular doubly linked list. 
*/