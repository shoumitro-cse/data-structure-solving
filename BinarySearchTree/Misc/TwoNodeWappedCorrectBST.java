// Two nodes of a BST are swapped, correct the BST

//javac -d classes TwoNodeWappedCorrectBST.java  && cd classes && java TwoNodeWappedCorrectBST && cd ..

import java.util.*; 
import java.lang.*; 
import java.io.*; 

class Node { 

	int data; 
	Node left, right; 

	Node(int d) { 
		data = d; 
		left = right = null; 
	} 
} 

class TwoNodeWappedCorrectBST 
{ 
	Node first, middle, last, prev; 
	
	void correctBSTUtil( Node root) { 
		if( root != null ) { 
			// Recur for the left subtree 
			correctBSTUtil(root.left); 
			if (prev != null && root.data < prev.data) { 
				if (first == null) { 
					first = prev; 
					middle = root; 
				} else {
					last = root; 
				}
			} 
			// Mark this node as previous 
			prev = root; 
			// Recur for the right subtree 
			correctBSTUtil(root.right); 
		} 
	} 

	void correctBST( Node root ) { 
		// Initialize pointers needed for correctBSTUtil() 
		first = middle = last = prev = null; 
		// Set the poiters to find out  two nodes 
		correctBSTUtil( root ); 
		// Fix (or correct) the tree 
		if( first != null && last != null ) { 
			int temp = first.data; 
			first.data = last.data; 
			last.data = temp; 
		} else if( first != null && middle != null ) { 
		   // Adjacent nodes swapped 
			int temp = first.data; 
			first.data = middle.data; 
			middle.data = temp; 
		} 
	} 

	/* A utility function to print Inoder traversal */
	void printInorder(Node node) 
	{ 
		if (node == null) 
			return; 
		printInorder(node.left); 
		System.out.print(" " + node.data); 
		printInorder(node.right); 
	} 


	// Driver program to test above functions 
	public static void main (String[] args) 
	{ 
        /*   6 
            / \ 
           10  2 
          / \ / \ 
         1  3 7 12 
          
        10 and 2 are swapped 
        */

		Node root = new Node(6); 
		root.left = new Node(10); 
		root.right = new Node(2); 
		root.left.left = new Node(1); 
		root.left.right = new Node(3); 
		root.right.right = new Node(12); 
		root.right.left = new Node(7); 

		System.out.println("Inorder Traversal"+" of the original tree"); 
		TwoNodeWappedCorrectBST tree = new TwoNodeWappedCorrectBST(); 
		tree.printInorder(root); 

		tree.correctBST(root); 

		System.out.println("\nInorder Traversal"+ " of the fixed tree"); 
		tree.printInorder(root); 
		System.out.println(""); 
	} 
} 


/*Two nodes of a BST are swapped, correct the BST

Two of the nodes of a Binary Search Tree (BST) are swapped. Fix (or correct) the BST. 

Input Tree:
         10
        /  \
       5    8
      / \
     2   20

In the above tree, nodes 20 and 8 must be swapped to fix the tree.  
Following is the output tree
         10
        /  \
       5    20
      / \
     2   8

*/