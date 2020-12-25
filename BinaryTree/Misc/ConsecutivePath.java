// Java Program to find Maximum Consecutive Path Length in a Binary Tree 

//javac -d classes ConsecutivePath.java  && cd classes && java ConsecutivePath && cd ..

import java.util.*; 
class ConsecutivePath { 

	// To represent a node of a Binary Tree 
	static class Node 
	{ 
		Node left, right; 
		int val; 
	} 

	// Create a new Node and return its address 
	static Node newNode(int val) 
	{ 
		Node temp = new Node(); 
		temp.val = val; 
		temp.left = null; 
		temp.right = null; 
		return temp; 
	} 

	// Returns the maximum consecutive Path Length 
	static int maxPathLenUtil(Node root, int prev_val, int prev_len) 
	{ 
		if (root == null) 
			return prev_len; 

		int cur_val = root.val; 

		if (cur_val == prev_val+1) { 
			return Math.max(maxPathLenUtil(root.left, cur_val, prev_len+1), 
					maxPathLenUtil(root.right, cur_val, prev_len+1)); 
		} 

		int newPathLen = Math.max(maxPathLenUtil(root.left, cur_val, 1), 
							maxPathLenUtil(root.right, cur_val, 1)); 

		return Math.max(prev_len, newPathLen); 
	} 

	// A wrapper over maxPathLenUtil(). 
	static int maxConsecutivePathLength(Node root) { 
		// Return 0 if root is NULL 
		if (root == null) 
			return 0; 
		// Else compute Maximum Consecutive Increasing Path Length using maxPathLenUtil. 
		return maxPathLenUtil(root, root.val-1, 0); 
	} 

	//Driver program to test above function 
	public static void main(String[] args) 
	{ 
		Node root = newNode(10); 
		root.left = newNode(11); 
		root.right = newNode(9); 
		root.left.left = newNode(13); 
		root.left.right = newNode(12); 
		root.right.left = newNode(13); 
		root.right.right = newNode(8); 

		System.out.println("\n\nMaximum Consecutive Increasing Path Length is "
			 +maxConsecutivePathLength(root)); 

	} 
} 

/*
Maximum Consecutive Increasing Path Length in Binary Tree

Given a Binary Tree find the length of the longest path which comprises of nodes with consecutive values in increasing order. Every node is considered as a path of length 1.
Examples:

       10
      /    \     
     /      \
    11        9    
   / \        /\
  /   \      /  \
13    12    13   8
Maximum Consecutive Path Length is 3 (10, 11, 12)
Note: 10, 9 ,8 is NOT considered since
the nodes should be in increasing order.

        5
          /  \
         /    \
        8      11
        /        \
       /          \
       9      10   
      /              /
     /             /
    6           15
Maximum Consecutive Path Length is 2 (8, 9).*/