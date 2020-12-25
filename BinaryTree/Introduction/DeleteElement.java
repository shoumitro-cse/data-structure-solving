// Java program to delete element in binary tree

//javac -d classes DeleteElement.java  && cd classes && java DeleteElement && cd ..

import java.util.LinkedList; 
import java.util.Queue; 

class DeleteElement { 
	
	// A binary tree node has key, pointer to 
	// left child and a pointer to right child 
	static class Node { 
		int key; 
		Node left, right; 
		// Constructor 
		Node(int key) { 
			this.key = key; 
			left = null; 
			right = null; 
		} 
	} 

	static Node root; 
	static Node temp = root; 

	// Inorder traversal of a binary tree 
	static void inorder(Node temp) { 
		if (temp == null) 
			return; 
		inorder(temp.left); 
		System.out.print(temp.key + " "); 
		inorder(temp.right); 
	} 

	// Function to delete deepest 
	// element in binary tree 
	static void deleteDeepest(Node root, Node delNode) { 
		Queue<Node> q = new LinkedList<Node>(); 
		q.add(root); 
		Node temp = null; 
		// Do level order traversal until last node 
		while (!q.isEmpty()) { 
			
			temp = q.remove(); 
			
			if (temp == delNode) { 
				temp = null; 
				return; 
			} 
			
			if (temp.right!=null) { 
				if (temp.right == delNode) { 
					temp.right = null; 
					return; 
		    	} else { 
				  q.add(temp.right);
				} 
		    } 

			if (temp.left != null) { 
				if (temp.left == delNode) { 
					temp.left = null; 
					return; 
				} else {
					q.add(temp.left); 
				}
			} 
	    } 
	} 

	// Function to delete given element in binary tree 
	static void delete(Node root, int key) { 
		
		if (root == null) 
			return; 
			
		if (root.left == null && root.right == null) { 
			if (root.key == key) 
				return; 
			else
				return; 
		} 
		
		Queue<Node> q = new LinkedList<Node>(); 
		q.add(root); 
		Node temp = null, keyNode = null; 
		
		// Do level order traversal until we find key and last node. 
		while (!q.isEmpty()) {

			temp = q.remove(); 
			
			if (temp.key == key) 
				keyNode = temp; 

			if (temp.left != null) 
				q.add(temp.left); 

			if (temp.right != null) 
				q.add(temp.right); 
		} 

		if (keyNode != null) { 
			int x = temp.key; //temp.key=8
			System.out.println("\nx: "+x);
			deleteDeepest(root, temp); // delete right or left last node
			keyNode.key = x; // replace 11 to 8.
		} 
	} 

	// Driver code 
	public static void main(String args[]) {

		root = new Node(10); 

		root.left = new Node(11); 
		root.left.left = new Node(7); 
		root.left.right = new Node(12); 
		
		root.right = new Node(9); 
		root.right.left = new Node(15); 
		root.right.right = new Node(8); 

		System.out.print("\n\nInorder traversal before deletion:"); 
		inorder(root); 

		int key = 11; 
		delete(root, key); 

/*	    key = 10; 
		delete(root, key); */

/*	    key = 8; 
		delete(root, key); */

		System.out.print("\nInorder traversal after deletion:"); 
		inorder(root); 
		System.out.print("\n"); 
	} 
} 


/*
Deletion in a Binary Tree

Given a binary tree, delete a node from it by making sure that tree shrinks 
from the bottom (i.e. the deleted node is replaced by bottom most and rightmost node). 
This different from BST deletion. Here we do not have any order among elements, 
so we replace with last element.

Examples :

Delete 10 in below tree
       10
     /    \         
    20     30

Output :    
       30
     /             
    20     


Delete 20 in below tree
       10
     /    \         
    20     30
            \
            40
Output :    
       10
     /   \             
    40    30   


Algorithm 
1. Starting at root, find the deepest and rightmost node in binary tree and 
   node which we want to delete. 
2. Replace the deepest rightmost node’s data with node to be deleted. 
3. Then delete the deepest rightmost node.*/