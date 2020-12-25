// Java program to determine whether binary tree is level sorted or not. 

import java.util.*; 

class LevelSorted { 

	// Structure of a tree node. 
	static class Node { 
		int key; 
		Node left, right; 
	} 

	// Function to create new tree node. 
	static Node newNode(int key) 
	{ 
		Node temp = new Node(); 
		temp.key = key; 
		temp.left = null; 
		temp.right = null; 
		return temp; 
	} 

	// Function to determine if 
	// given binary tree is level sorted 
	// or not. 
	static int isSorted(Node root) { 
		// to store maximum value of previous level. 
		int prevMax = Integer.MIN_VALUE; 
		// to store minimum value of current level. 
		int minval; 
		// to store maximum value of current level. 
		int maxval; 
		// to store number of nodes in current level. 
		int levelSize; 
		// queue to perform level order traversal. 
		Queue<Node> q = new LinkedList<Node> (); 
		q.add(root); 
		while (!q.isEmpty()) { 
			// find number of nodes in current level. 
			levelSize = q.size(); 

			minval = Integer.MAX_VALUE; 
			maxval = Integer.MIN_VALUE; 
			// traverse current level and find 
			// minimum and maximum value of this level. 
			while (levelSize > 0) { 
				root = q.peek(); 
				q.remove(); 

				levelSize--; 

				minval = Math.min(minval, root.key); 
				maxval = Math.max(maxval, root.key); 

				if (root.left != null) 
					q.add(root.left); 

				if (root.right != null) 
					q.add(root.right); 
			} 
			// if minimum value of this level is not greater than maximum 
			// value of previous level then given tree is not level sorted. 
			if (minval <= prevMax) 
				return 0; 
			// maximum value of this level is previous maximum value for next level. 
			prevMax = maxval; 
		} 

		return 1; 
	} 

	// Driver program 
	public static void main(String[] args) 
	{ 

		Node root = newNode(1); 
		root.left = newNode(4); 
		root.left.right = newNode(6); 
		root.left.right.left = newNode(8); 
		root.left.right.right = newNode(9); 
		root.left.right.left.left = newNode(12); 
		root.left.right.right.right = newNode(10); 

		if (isSorted(root) == 1) 
			System.out.println("Sorted"); 
		else
			System.out.println("Not sorted"); 
	} 
} 

/*Time Complexity: O(n)
Auxiliary Space: O(n)*/

/*Check if a binary tree is sorted level-wise or not

Given a binary tree. The task is to check if the binary tree is sorted level-wise or not. A binary tree is level sorted if max( i-1th level) is less than min( ith level ).

Examples:

Input :        1 
              / \
             /   \
            2     3
           / \   / \
          /   \ /   \
         4    5 6    7
Output : Sorted

Input:         1 
              / 
             4 
            / \
           6   5
                \
                 2
Output: Not sorted*/