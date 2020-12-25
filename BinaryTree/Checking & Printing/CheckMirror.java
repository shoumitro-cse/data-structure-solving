// Check if two trees are Mirror

// javac -d classes CheckMirror.java  && cd classes && java CheckMirror && cd ..

import java.util.*; 

class Node { 
	int data; 
	Node left, right; 
	public Node(int data) { 
		this.data = data; 
		left = right = null; 
	} 
} 

class CheckMirror { 

/*	// Iterative method to check if two trees are mirror of each other
    // Time Complexity: O(n)
	static boolean areMirror(Node root1, Node root2)  {  

	    Stack<Node> st1 = new Stack<Node> (); 
	    Stack<Node> st2  = new Stack<Node> ();  

	    while (true)  {  

	        while (root1 != null && root2 != null)  {  

	            if (root1.data != root2.data) {
	                return false;  
	            }
	            st1.push(root1);  
	            st2.push(root2);  

	            root1 = root1.left;  
	            root2 = root2.right;      
	        }  
	          
	        if (!(root1 == null && root2 == null))  
	            return false;  
	              
	        if (!st1.isEmpty() && !st2.isEmpty()) {  

	            root1 = st1.pop();  
	            root2 = st2.pop();  
	              
	            root1 = root1.right;  
	            root2 = root2.left;      
	        } else {
	           // both the trees have been completely traversed  
	            break;  
	        }
	    }  
	      
	    // tress are mirrors of each other  
	    return true;  
	}  */


	// Time Complexity : O(n)
	 // Given two trees, return true if they are mirror of each other 
	boolean areMirror(Node a, Node b) { 
		 // Base case : Both empty 
		if (a == null && b == null) 
			return true; 
		// If only one is empty 
		if (a == null || b == null) 
			return false; 
		return a.data == b.data && areMirror(a.left, b.right) && areMirror(a.right, b.left); 
	} 

	// Driver code to test above methods 
	public static void main(String[] args) 
	{ 
	    // Node a, b; 
		CheckMirror tree = new CheckMirror(); 
		Node a = new Node(1); 
		Node b = new Node(1); 
		a.left = new Node(2); 
		a.right = new Node(3); 
		a.left.left = new Node(4); 
		a.left.right = new Node(5); 

		b.left = new Node(3); 
		b.right = new Node(2); 
		b.right.left = new Node(5); 
		b.right.right = new Node(4); 

		if (tree.areMirror(a, b) == true) 
			System.out.println("\nYes"); 
		else
			System.out.println("\nNo"); 

	} 
} 

/*
This problem is different from the problem discussed here.

For two trees ‘a’ and ‘b’ to be mirror images, the following three conditions must be true:

	1. Their root node’s key must be same
	2. Left subtree of root of ‘a’ and right subtree root of ‘b’ are mirror.
	3. Right subtree of ‘a’ and left subtree of ‘b’ are mirror.*/