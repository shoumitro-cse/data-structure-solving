// Root to leaf paths having equal lengths in a Binary Tree

//javac -d classes EqualLengthsPath.java  && cd classes && java EqualLengthsPath && cd ..

import java.util.HashMap; 
import java.util.Map; 

class EqualLengthsPath { 

	// A binary tree node 
	static class Node 
	{ 
		int data; 
		Node left, right; 
	}; 

	// Utility that allocates a new node 
	// with the given data and null left 
	// and right pointers. 
	static Node newnode(int data) 
	{ 
		Node node = new Node(); 
		node.data = data; 
		node.left = node.right = null; 
		return (node); 
	} 

	// Function to store counts of different root to leaf path lengths in hash map m. 
	static void pathCountUtil(Node node, HashMap<Integer, Integer> m, int path_len) { 
		// Base condition 
		if (node == null) 
			return; 
		// If leaf node reached, increment count of path length of this root to leaf path. 
		if (node.left == null && node.right == null) { 
			if (!m.containsKey(path_len)) 
				m.put(path_len, 0); 
			m.put(path_len, m.get(path_len) + 1); 
		  return; 
		} 
		// Recursively call for left and right subtrees with path lengths more than 1. 
		pathCountUtil(node.left, m, path_len + 1); 
		pathCountUtil(node.right, m, path_len + 1); 
	} 

	// A wrapper over pathCountUtil() 
	static void pathCounts(Node root) { 
		// Create an empty hash table 
		HashMap<Integer, Integer> m = new HashMap<>(); 
		// Recursively check in left and right subtrees. 
		pathCountUtil(root, m, 1); 
		// Print all path lenghts and their counts. 
		for(Map.Entry<Integer, Integer> entry : m.entrySet()) { 
			System.out.printf("%d paths have length %d\n", entry.getValue(), entry.getKey()); 
		} 
	} 

	public static void main(String[] args) 
	{ 
		Node root = newnode(8); 
		root.left = newnode(5); 
		root.right = newnode(4); 
		root.left.left = newnode(9); 
		root.left.right = newnode(7); 
		root.right.right = newnode(11); 
		root.right.right.left = newnode(3); 
		
		pathCounts(root); 
	} 
} 


/*Root to leaf paths having equal lengths in a Binary Tree

Given a binary tree, print the number of root to leaf paths having equal lengths.

Examples: 

Input : Root of below tree
                   10
                  /   \
                8      2
              /  \    /  \
            3     5  2    4
Output : 4 paths are of length 3.

Input : Root of below tree 
                  10
                 /   \
               8      2
             /  \    /  \
            3    5  2    4
           /               \
          9                 1
Output : 2 paths are of length 3
         2 paths are of length 4*/



