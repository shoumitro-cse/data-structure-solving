// Find if there is a pair in root to a leaf path with sum equals to root’s data

//javac -d classes SumEqualToRoot.java  && cd classes && java SumEqualToRoot && cd ..

import java.util.*; 

class SumEqualToRoot { 

	 // A binary tree node has data, pointer to left child and a pointer to right child 
	static class Node { 
		int data; 
		Node left, right; 
	}; 

	 // utility that allocates a new node with the given data and null left and right pointers. 
	static Node newnode(int data) { 
		Node node = new Node(); 
		node.data = data; 
		node.left = node.right = null; 
		return (node); 
	} 

	// Function to print root to leaf path which satisfies the condition 
	static boolean printPathUtil(Node node, HashSet<Integer> s, int root_data) { 
		// Base condition 
		if (node == null) 
			return false; 
		// Check if current node makes a pair with any of the existing elements in set. 
		int rem = root_data - node.data; 
		if (s.contains(rem)) {
			System.out.println(node.data+" "+rem+" ");
			return true; 
		}
		// Insert current node in set 
		s.add(node.data); 
		// If result returned by either left or right child is  true, return true. 
		boolean res = printPathUtil(node.left, s, root_data) || printPathUtil(node.right, s, root_data); 
		// Remove current node from hash table 
		// s.remove(node.data); 

		return res; 
	} 

	// A wrapper over printPathUtil() 
	//Time Complexity: O(n) under the assumption that hash search, insert and erase take O(1) time.
	static boolean isPathSum(Node root) { 
		// create an empty hash table 
		HashSet<Integer> s = new HashSet<Integer>(); 
		// Recursively check in left and right subtrees. 
		return printPathUtil(root, s, root.data); 
	} 

	// Driver code 
	public static void main(String[] args) {

		Node root = newnode(5); 

		root.left = newnode(2); 
		root.right = newnode(3); 

		root.left.left = newnode(1); 
		root.left.right = newnode(4); 

		root.left.right.left = newnode(6); 
		root.left.right.right = newnode(8); 

		/*		  5
				 /  \
			    2    3
			  /  \
			 1    4
			     / \
			    6   8  */

		System.out.print(isPathSum(root)==true ?"\n\nYes\n" : "\n\nNo\n"); 
	
	} 
} 



/*
Find if there is a pair in root to a leaf path with sum equals to root’s data

Given a binary tree, find if there is a pair in root to a leaf path such that sum of values 
in pair is equal to root’s data. 
For example, in below tree (2, 3) and (4, 1) are pairs with sum equals to root’s data.

               5
			 /  \
		    2    3
		  /  \
		 1    4
		     / \
		    6   8 */