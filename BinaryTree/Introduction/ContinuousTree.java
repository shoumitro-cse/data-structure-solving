// Java program to check if a tree is continuous or not

//javac -d classes ContinuousTree.java  && cd classes && java ContinuousTree && cd ..

import java.util.*;

class ContinuousTree {

	 // A binary tree node has data, pointer to left child and a pointer to right child 
	static class Node {
		int data;
		Node left, right;
	};

	static Node newNode(int data) {
		Node node = new Node();
		node.data = data;
		node.left = node.right = null;
		return node;
	}

	// Function to check tree is continuous or not
	static boolean treeContinuous( Node ptr) {

		// if next node is empty then return true
		if (ptr == null)
			return true;

		// if current node is leaf node then return true
		// because it is end of root to leaf path
		if (ptr.left == null && ptr.right == null)
			return true;

		// If left subtree is empty, then only check right
		if (ptr.left == null)
		return (Math.abs(ptr.data - ptr.right.data) == 1) && treeContinuous(ptr.right);

		// If right subtree is empty, then only check left
		if (ptr.right == null)
		return (Math.abs(ptr.data - ptr.left.data) == 1) && treeContinuous(ptr.left);

		// If both left and right subtrees are not empty, check everything
		return Math.abs(ptr.data - ptr.left.data)==1 &&
				Math.abs(ptr.data - ptr.right.data)==1 &&
				treeContinuous(ptr.left) && treeContinuous(ptr.right);
	}


	public static void main(String args[]) {

		Node root = newNode(3);
		
		root.left	 = newNode(2);
		root.right	 = newNode(4);
		
		root.left.left = newNode(1);
		root.left.right = newNode(3);
		
		root.right.right = newNode(5);

          /*Input :  3
                    / \
                   2   4
                  / \   \
                 1   3   5  */
		
		if(treeContinuous(root))
		   System.out.println( "Yes") ;
		else
		   System.out.println( "No");
	}
}


/*Continuous Tree

A tree is a Continuous tree if in each root to leaf path, the absolute difference 
between keys of two adjacent is 1. We are given a binary tree, we need to check if 
the tree is continuous or not.
Examples: 
 

Input :              3
                    / \
                   2   4
                  / \   \
                 1   3   5
Output: "Yes"

// 3->2->1 every two adjacent node's absolute difference is 1
// 3->2->3 every two adjacent node's absolute difference is 1
// 3->4->5 every two adjacent node's absolute difference is 1

Input :              7
                    / \
                   5   8
                  / \   \
                 6   4   10
Output: "No"

// 7->5->6 here absolute difference of 7 and 5 is not 1.
// 7->5->4 here absolute difference of 7 and 5 is not 1.
// 7->8->10 here absolute difference of 8 and 10 is not 1.*/