// Java program to find deepest right leaf node of binary tree 

//javac -d classes DeepestRghtLeaf.java  && cd classes && java DeepestRghtLeaf && cd ..

import java.util.*; 

class DeepestRghtLeaf { 
	// tree node 
	static class Node { 
		int data; 
		Node left, right; 
	}; 

	// returns a new tree Node 
	static Node newNode(int data) { 
		Node temp = new Node(); 
		temp.data = data; 
		temp.left = temp.right = null; 
		return temp; 
	} 

	// return the deepest right leaf node of binary tree 
	static Node getDeepestRightLeafNode(Node root) 
	{ 
		if (root == null) 
			return null; 
		// create a queue for level order traversal 
		Queue<Node> q = new LinkedList<>(); 
		q.add(root); 

		Node result = null; 

		// traverse until the queue is empty 
		while (!q.isEmpty()) 
		{ 
			Node temp = q.poll(); 

			if (temp.left != null) { 
				q.add(temp.left); 
			} 
			// Since we go level by level, the last 
			// stored right leaf node is deepest one 
			if (temp.right != null) { 
				q.add(temp.right); 
				if (temp.right.left == null && temp.right.right == null) 
					result = temp.right; 
			} 
		} 
		return result; 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		
		// construct a tree 
		Node root = newNode(1); 
		root.left = newNode(2); 
		root.right = newNode(3); 
		root.left.right = newNode(4); 
		root.right.left = newNode(5); 
		root.right.right = newNode(6); 
		root.right.left.right = newNode(7); 
		root.right.right.right = newNode(8); 
		root.right.left.right.left = newNode(9); 
		root.right.right.right.right = newNode(10); 

		Node result = getDeepestRightLeafNode(root); 
		if (result != null) 
			System.out.println("Deepest Right Leaf Node :: "
				+ result.data); 
		else
			System.out.println("No result, right leaf not found\n"); 
	} 
} 

/*Deepest right leaf node in a binary tree | Iterative approach
Last Updated: 04-07-2019
Given a Binary Tree, find the deepest leaf node that is right child of its parent. 
For example, consider the following tree. The deepest right leaf node is the node with value 10.

Examples:

Input : 
       1
     /   \
    2     3
     \   /  \  
      4 5    6
         \    \
          7    8
         /      \
        9        10

Output : 10
*/