//Convert left-right representation of a binary tree to down-right

//javac -d classes LeftRightTreeToDownRight.java  && cd classes && java LeftRightTreeToDownRight && cd ..

class LeftRightTreeToDownRight { 
	// A Binary Tree Node 
	static class node { 
		int key; 
		node left, right; 
		node(int key) { 
			this.key = key; 
			this.left = this.right = null; 
		} 
	} 


	// Time complexity is O(n).
	static void convert(node root) { 

		// Base Case 
		if (root == null) 
			return; 
		
		// Recursively convert left an right subtrees 
		convert(root.left); 
		convert(root.right); 
		
		// If left child is NULL, make right child as left as it is the first child. 
		if (root.left == null) 
		  root.left = root.right; 
		// If left child is NOT NULL, then make right child as right of left child 
		else
		  root.left.right = root.right; 

		// Set root's right as NULL 
		root.right = null; 
	} 

	// A utility function to traverse a tree stored in down-right form. 
	static void downRightTraversal(node root) { 
		if (root != null) { 
			System.out.print(root.key + " "); 
			downRightTraversal(root.right); 
			downRightTraversal(root.left); 
		} 
	} 

	// Utility function to create a new tree node 
	static node newNode(int key) { 
		node temp = new node(0); 
		temp.key = key; 
		temp.left = null; 
		temp.right = null; 
		return temp; 
	} 


	public static void main(String[] args) {

		node root = new node(1); 

		root.left = newNode(2); 
		root.right = newNode(3); 

		root.right.left = newNode(4); 
		root.right.right = newNode(5); 

		root.right.left.left = newNode(6); 
		root.right.right.left = newNode(7); 
		root.right.right.right = newNode(8); 

		/*		
		         1
		      /    \
		     2      3
		           / \
		          4   5
		         /    /\
		        6    7  8
	            */

		convert(root); 

		System.out.println("Traversal of the tree converted to down-right form"); 
		downRightTraversal(root); 
		System.out.println(); 
	} 
} 

/*
Convert left-right representation of a binary tree to down-right

Left-Right representation of a binary tree is standard representation where every node has 
a pointer to left child and another pointer to right child.
Down-Right representation is an alternate representation where every node has a pointer to 
left (or first) child and another pointer to next sibling. So siblings at every 
level are connected from left to right.

Given a binary tree in left-right representation as below

		         1
		      /    \
		     2      3
		           / \
		          4   5
		         /    /\
		        6    7  8

Convert the structure of the tree to down-right representation like the below tree.

            1
            | <-- down
            2 – 3  <--- right sibling pointer
                |
                4 — 5
                |   |
                6   7 – 8 
The conversion should happen in-place, i.e., left child pointer should be used as down pointer 
and right child pointer should be used as right sibling pointer.*/