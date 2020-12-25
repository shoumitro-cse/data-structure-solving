 // Java program to find next right of a given key using preorder traversal 

import java.util.*; 

class NextRightGivenKey { 
	
	static class V { 
		int value_level = 0; 
	} 

	// A Binary Tree Node 
	static class Node { 
		Node left, right; 
		int key; 
	} 

	// Utility function to create a new tree node 
	static Node newNode(int key) 
	{ 
		Node temp = new Node(); 
		temp.key = key; 
		temp.left = null; 
		temp.right = null; 
		return temp; 
	} 

	static Node nextRightNode(Node root, int k, int level, V value) 
	{ 
		// return null if tree is empty 
		if (root == null) 
			return null; 
		// if desired node is found, set value_level to current level 
		if (root.key == k) { 
			value.value_level = level; 
			return null; 
		} else if (value.value_level != 0) { 
		   // if value_level is already set, then current node is the next right node 
			if (level == value.value_level) 
				return root; 
		} 
		// recurse for left subtree by increasing level by 1 
		Node leftNode = nextRightNode(root.left, k, level + 1, value); 
		// if node is found in left subtree, return it 
		if (leftNode != null) 
			return leftNode; 
		// recurse for right subtree by increasing level by 1 
		return nextRightNode(root.right, k, level + 1, value); 
	} 

	// Function to find next node of given node in the same level in given binary tree 
	static Node nextRightNodeUtil(Node root, int k) { 
		V v = new V(); 
		return nextRightNode(root, k, 1, v); 
	} 

	// A utility function to test above functions 
	static void test(Node root, int k) { 
		Node nr = nextRightNodeUtil(root, k); 
		if (nr != null) 
			System.out.println("Next Right of " + k + " is "+ nr.key); 
		else
			System.out.println("No next right node found for " + k); 
	} 

	// Driver program to test above functions 
	public static void main(String[] args) 
	{ 
		// Let us create binary tree given in the 
		// above example 
		Node root = newNode(10); 
		root.left = newNode(2); 
		root.right = newNode(6); 
		root.right.right = newNode(5); 
		root.left.left = newNode(8); 
		root.left.right = newNode(4); 

		test(root, 10); 
		test(root, 2); 
		test(root, 6); 
		test(root, 5); 
		test(root, 8); 
		test(root, 4); 
	} 
} 

/*Find next right node of a given key | Set 2

Given a Binary tree and a key in the binary tree, find the node right to the given key. If there is no node on right side, then return NULL. Expected time complexity is O(n) where n is the number of nodes in the given binary tree.

For example, consider the following Binary Tree. Output for 2 is 6, output for 4 is 5. Output for 10, 6 and 5 is NULL.

                  10
               /      \
             2         6
           /   \         \ 
         8      4          5
Input : 2
Output : 6

Input : 4
Output : 5

*/