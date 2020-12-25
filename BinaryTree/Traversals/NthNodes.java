// Java program for nth nodes of inorder traversals 

//javac -d classes NthNodes.java  && cd classes && java NthNodes && cd ..

import java.util. *; 

class NthNodes {

	static class Node { 
		int data; 
		Node left; 
		Node right; 
	} 
		
	static Node newNode(int data) {

		Node node = new Node(); 
		node.data = data; 
		node.left = null; 
		node.right = null; 
		
		return (node); 
	} 
		

	 // Given a binary tree, print its nth nodes of inorder
	static int count =0; 
	// Time Complexity: O(n)
	static void NthInorder( Node node, int n) { 
		if (node == null) {
			return; 
		}
		if (count <= n) { 
			NthInorder(node.left, n); 
			count++; 
			if (count == n) {
				System.out.printf("%d ", node.data); 
			}
			NthInorder(node.right, n); 
		} 
	} 
		
	 // Driver program to test above functions
	public static void main(String args[]) {

		Node root = newNode(10); 
		root.left = newNode(20); 
		root.right = newNode(30); 
		root.left.left = newNode(40); 
		root.left.right = newNode(50); 
		
		int n = 4; 
		
		NthInorder(root, n); 
		System.out.printf("\n"); 

/*		Input : n = 4

              10
            /   \
           20     30
         /   \
        40     50

	Output : 10
	Inorder Traversal is : 40 20 50 10 30*/

	} 
} 



/*
Find n-th node of inorder traversal

Given the binary tree and you have to find out the n-th node of inorder traversal.

Examples: 

Input : n = 4
              10
            /   \
           20     30
         /   \
        40     50
Output : 10
Inorder Traversal is : 40 20 50 10 30

Input :  n = 3
            7
          /   \
         2     3
             /   \
            8     5
Output : 8
Inorder: 2 7 8 3 5
3th node is 8*/

