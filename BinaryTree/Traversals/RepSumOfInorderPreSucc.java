//Replace each node in binary tree with the sum of its inorder predecessor and successor

//javac -d classes RepSumOfInorderPreSucc.java  && cd classes && java RepSumOfInorderPreSucc && cd ..

import java.util.*; 

class RepSumOfInorderPreSucc { 
		
	// node of a binary tree 
	static class Node { 
		int data; 
		Node left, right; 
	} 
	//INT class 
	static class INT { 
		int data; 
	} 
	// function to get a new node of a binary tree 
	static Node getNode(int data) { 
		// allocate node 
		Node new_node =new Node(); 
		// put in the data; 
		new_node.data = data; 
		new_node.left = new_node.right = null; 

		return new_node; 
	} 

	// function to store the inorder traversal of the binary tree in 'arr' 
	static void storeInorderTraversal( Node root, Vector<Integer> arr) { 
		// if root is null 
		if (root==null) 
			return; 
		// first recur on left child 
		storeInorderTraversal(root.left, arr); 
		// then store the root's data in 'arr' 
		arr.add(root.data); 
		// now recur on right child 
		storeInorderTraversal(root.right, arr); 
	} 

	// function to replace each node with the sum of its inorder predecessor and successor 
	static void replaceNodeWithSum( Node root, Vector<Integer> arr, INT i) { 
		// if root is null 
		if (root==null) 
			return; 
		// first recur on left child 
		replaceNodeWithSum(root.left, arr, i); 
		// replace node's data with the sum of its 
		// inorder predecessor and successor 
		root.data = arr.get(i.data - 1) + arr.get(i.data + 1); 
		// move 'i' to point to the next 'arr' element 
		i.data++; 
		// now recur on right child 
		replaceNodeWithSum(root.right, arr, i); 
	} 

// Time Complexity: O(n)
// Auxiliary Space: O(n)
	static void replaceNodeWithSumUtil( Node root) { 
		// if tree is empty 
		if (root==null) 
			return; 
		Vector<Integer> arr= new Vector<Integer>(); 
		// store the value of inorder predecessor for the leftmost leaf 
		arr.add(0); 
		// store the inoder traversal of the tree in 'arr' 
		storeInorderTraversal(root, arr); 
		// store the value of inorder successor for the rightmost leaf 
		arr.add(0); 
		// arr = [0, 4, 2, 5, 1, 6, 3, 7 ,0]
		INT i = new INT(); 
		i.data=1; 
		replaceNodeWithSum(root, arr, i); 
	} 

	// function to print the preorder traversal 
	// of a binary tree 
	static void preorderTraversal( Node root) { 
		// if root is null 
		if (root==null) 
			return; 
		// first print the data of node 
		System.out.print( root.data + " "); 
		// then recur on left subtree 
		preorderTraversal(root.left); 
		// now recur on right subtree 
		preorderTraversal(root.right); 
	} 

	// Driver program to test above 
	public static void main(String args[]) { 

	    // binary tree formation 
	    Node root = getNode(1);     

	    root.left = getNode(2);             
	    root.right = getNode(3);          
	    
	    root.left.left = getNode(4);    
	    root.left.right = getNode(5); 
	    
	    root.right.left = getNode(6); 
	    root.right.right = getNode(7); 

		/*	     1
		       /   \
		      2     3
		    /  \  /  \
		   4   5  6   7 */

		System.out.println( "Preorder Traversal before tree modification:"); 
		preorderTraversal(root); 

		replaceNodeWithSumUtil(root); 

		System.out.println("\nPreorder Traversal after tree modification:"); 
		preorderTraversal(root); 
		System.out.println(); 

	} 
} 


/*
Replace each node in binary tree with the sum of its inorder predecessor and successor
Last Updated: 23-10-2019
Given a binary tree containing n nodes. The problem is to replace each node in the binary tree with the sum of its inorder predecessor and inorder successor.

Examples:

Input :          1
               /   \
              2     3
            /  \  /  \
           4   5  6   7

Inorder : 4, 2, 5, 1, 6, 3, 7 

Output :        11
              /    \
             9      13
            / \    /  \
           2   3   4   3

                  
Inorder : 4, 2, 5, 1, 6, 3, 7 

For 1: (if x=1 then predecessor=pre node of and successor=after node of x)
Inorder predecessor = 5
Inorder successor  = 6
Sum = 11

For 4:
Inorder predecessor = 0
(as inorder predecessor is not present)
Inorder successor  = 2
Sum = 2

For 7:
Inorder predecessor = 3
Inorder successor  = 0
(as inorder successor is not present)
Sum = 3
*/