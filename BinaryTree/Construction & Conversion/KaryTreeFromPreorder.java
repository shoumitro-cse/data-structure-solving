//build full k-ary tree from its preorder traversal and to print the postorder traversal of the tree. 

//javac -d classes KaryTreeFromPreorder.java  && cd classes && java KaryTreeFromPreorder && cd ..

import java.util.*; 

class KaryTreeFromPreorder { 
	
	// Structure of a node of an n-ary tree 
	static class Node { 
		int key; 
		Vector<Node> child; 
	}; 

	// Utility function to create a new tree node with k children 
	static Node newNode(int value) { 
		Node temp = new Node(); 
		temp.key = value; 
		temp.child= new Vector<Node>(); 
		return temp; 
	} 

	static int index=0; 
	// Function to build full k-ary tree 
	static Node BuildKaryTree(int preorder[], int n, int k, int h) { 
		
		// For null tree 
		if (n <= 0) 
			return null; 

		Node temp = newNode(preorder[index]); 
		
		if (temp == null) { 
			System.out.println("Memory error" ); 
			return null; 
		} 
		
		// For adding k children to a node 
		for (int i = 0; i < k; i++) { 
			// Check if index is in range of array Check if height of the tree is greater than 1 
			if (index < n-1 && h > 1) { 
				index++; 
				// Recursively add each child 
				temp.child.add(BuildKaryTree(preorder, n, k, h-1)); 
			} else { 
				temp.child.add(null); 
			} 
		} 

		return temp; 
	} 

	// Function to findex the height of the tree 
	static Node BuildKaryTree_1(int[] A, int n, int k) { 
		int height = (int)Math.ceil(Math.log((double)n*(k-1)+1) / Math.log((double)k)); //3
		// System.out.println(height);//3
		index = 0; 
		return BuildKaryTree(A, n, k, height); 
	} 

	// Function to print postorder traversal of the tree 
	static void postord(Node root, int k) 
	{ 
		if (root == null) 
			return; 
		for (int i = 0; i < k; i++) 
			postord(root.child.get(i), k); 
		System.out.print(root.key + " "); 
	} 

	// Driver Code 
	public static void main(String args[]) {

		int preorder[] = { 1, 2, 5, 6, 7, 3, 8, 9, 10, 4 }; 
		
		int k = 3, n = preorder.length; 
	
		Node root = BuildKaryTree_1(preorder, n, k); 
	
		System.out.println("\n\nPostorder traversal of constructed full k-ary tree is: "); 
		postord(root, k); 
		System.out.println(); 
	} 
} 


/*
Construct the full k-ary tree from its preorder traversal

Given an array which contains the preorder traversal of full k-ary tree, 
construct the full k-ary tree and print its postorder traversal. A full k-ary tree is a tree 
where each node has either 0 or k children.

Examples:

Input : preorder[] = {1, 2, 5, 6, 7, 
                     3, 8, 9, 10, 4}
        k = 3
Output : Postorder traversal of constructed 
         full k-ary tree is: 5 6 7 2 8 9 10 
         3 4 1 
         Tree formed is:         1
                             /   |   \
                           2     3    4
                          /|\   /|\
                         5 6 7 8 9 10

Input : preorder[] = {1, 2, 5, 6, 7, 3, 4}
        k = 3 
Output : Postorder traversal of constructed 
         full k-ary tree is: 5 6 7 2 3 4 1
         Tree formed is:        1
                             /  |  \
                           2    3   4
                          /|\   
                         5 6 7 */