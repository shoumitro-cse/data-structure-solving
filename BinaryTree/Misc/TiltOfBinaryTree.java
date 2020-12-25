// Tilt of Binary Tree

import java.util.*; 

class TiltOfBinaryTree { 

	static class Node { 
		int val; 
		Node left, right; 
	} 

	 // Recursive function to calculate Tilt of whole tree 
	static class T{ 
		int tilt = 0; 
	} 

	static int traverse(Node root, T t ) 
	{ 
		if (root == null) 
			return 0; 
		// Compute tilts of left and right subtrees 
		// and find sums of left and right subtrees 
		int left = traverse(root.left, t); 
		int right = traverse(root.right, t); 
		// Add current tilt to overall 
		t.tilt += Math.abs(left - right); 
		// Returns sum of nodes under current tree 
		return left + right + root.val; 
	} 

	 // Driver function to print Tilt of whole tree 
	static int Tilt(Node root) { 
		T t = new T(); 
		traverse(root, t); 
		return t.tilt; 
	} 

	static Node newNode(int data) { 
		Node temp = new Node(); 
		temp.val = data; 
		temp.left = null; 
		temp.right = null; 
		return temp; 
	} 

	public static void main(String[] args) 
	{ 

		Node root = null; 
		root = newNode(4); 
		root.left = newNode(2); 
		root.right = newNode(9); 
		root.left.left = newNode(3); 
		root.left.right = newNode(8); 
		root.right.right = newNode(7); 
		System.out.println("The Tilt of whole tree is " + Tilt(root)); 
	} 
} 


/*Tilt of Binary Tree

Given a binary tree, return the tilt of the whole tree. The tilt of a tree node is defined 
as the absolute difference between the sum of all left subtree node values and the sum of 
all right subtree node values. Null nodes are assigned tilt to be zero. Therefore, tilt of 
the whole tree is defined as the sum of all nodes’ tilt.

Examples:

Input :
    1
   / \
  2   3
Output : 1
Explanation: 
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1

Input :
    4
   / \
  2   9
 / \   \
3   5   7
Output : 15
Explanation: 
Tilt of node 3 : 0
Tilt of node 5 : 0
Tilt of node 7 : 0
Tilt of node 2 : |3-5| = 2
Tilt of node 9 : |0-7| = 7
Tilt of node 4 : |(3+5+2)-(9+7)| = 6
Tilt of binary tree : 0 + 0 + 0 + 2 + 7 + 6 = 15
*/