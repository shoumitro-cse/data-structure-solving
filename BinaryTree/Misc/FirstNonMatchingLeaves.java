// Find first non matching leaves in two binary trees

//javac -d classes FirstNonMatchingLeaves.java  && cd classes && java FirstNonMatchingLeaves && cd ..

import java.util.*; 

class FirstNonMatchingLeaves { 

	// Tree node 
	static class Node 
	{ 
		int data; 
		Node left, right; 
	} 

	// Utility method to create a new node 
	static Node newNode(int x) 
	{ 
		Node temp = new Node(); 
		temp.data = x; 
		temp.left = null; 
		temp.right = null; 
		return temp; 
	} 

	static boolean isLeaf(Node t) 
	{ 
		return ((t.left == null) && (t.right == null)); 
	} 

	// Prints the first non-matching leaf node in 
	// two trees if it exists, else prints nothing. 
	static void findFirstUnmatch(Node root1, Node root2) 
	{ 
		// If any of the tree is empty 
		if (root1 == null || root2 == null) 
		return; 

		// Create two stacks for preorder traversals 
		Stack<Node> s1 = new Stack<Node> (); 
		Stack<Node> s2 = new Stack<Node> (); 
		s1.push(root1); 
		s2.push(root2); 

		while (!s1.isEmpty() || !s2.isEmpty()) 
		{ 
			// If traversal of one tree is over 
			// and other tree still has nodes. 
			if (s1.isEmpty() || s2.isEmpty() ) 
			return; 

			// Do iterative traversal of first tree 
			// and find first lead node in it as "temp1" 
			Node temp1 = s1.pop(); 
			while (temp1 != null && isLeaf(temp1) != true) 
			{ 
				// pushing right childfirst so that 
				// left child comes first while popping. 
				s1.push(temp1.right); 
				s1.push(temp1.left); 
				temp1 = s1.pop(); 
			} 

			// Do iterative traversal of second tree 
			// and find first lead node in it as "temp2" 
			Node temp2 = s2.pop(); 
			while (temp2 != null && isLeaf(temp2) != true) 
			{ 
				s2.push(temp2.right); 
				s2.push(temp2.left); 
				temp2 = s2.pop(); 
			} 

			// If we found leaves in both trees 
			if (temp1 != null && temp2 != null ) { 
				if (temp1.data != temp2.data ) { 
					System.out.println(temp1.data+" "+temp2.data); 
					return; 
				} 
			} 
		} 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		Node root1 = newNode(5); 
		root1.left = newNode(2); 
		root1.right = newNode(7); 
		root1.left.left = newNode(10); 
		root1.left.right = newNode(11); 
		/*        5
		        /   \
		       2     7
		     /   \
		   10     11*/
		Node root2 = newNode(6);
		root2.left = newNode(10); 
		root2.right = newNode(15); 
		/*          6
		       /    \
		     10     15*/
		findFirstUnmatch(root1, root2); 

	} 
} 


/*
Find first non matching leaves in two binary trees

Given two binary trees, find first leaves of two trees that do not match. 
If there are no non-matching leaves, print nothing.

Examples:

Input : First Tree
          5
        /   \
       2     7
     /   \
   10     11

      Second Tree   
          6
       /    \
     10     15

Output : 11 15
If we consider leaves of two trees in order,
we can see that 11 and 15 are the first leaves 
that do not match.
*/