//Print nodes between two given level numbers of a binary tree

//javac -d classes PrintNodesTwoLevel.java  && cd classes && java PrintNodesTwoLevel && cd ..

import java.util.LinkedList; 
import java.util.Queue; 


class Node 
{ 
	int data; 
	Node left, right; 

	public Node(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

class PrintNodesTwoLevel 
{ 
	Node root; 


/*	static void breakStatement() {
        int i=0;
        while (true) {
        	if (true) {
        		if (true) {
        			if (true) {
        			  if (true) {
        				if (true) {
        				 if (true) {
        				  if (true) {
        			    	 if (true) {
        			    	   System.out.println("\n\n\nbreak0"); 
        				       break;
        			        }
        			    	System.out.println("\n\n\nbreak1"); 
        			      }
        				  System.out.println("\n\n\nbreak2"); 
        			     }
        				 System.out.println("\n\n\nbreak3"); 
        			    }
        				System.out.println("\n\n\nbreak4"); 
        			  }
        			 System.out.println("\n\n\nbreak5"); 
        			}
        		  System.out.println("break6"); 
        		}
        	 System.out.println("break7"); 
        	}
          System.out.println("while break8"); 
          // i++;
        }
       System.out.println("Break9 Outer Location.");
   } */

	 // Given a binary tree, print nodes from level number 'low' to level number 'high'
   // Time complexity is O(n).
	void printLevels(Node node, int low, int high) { 

		Queue<Node> Q = new LinkedList<>(); 
		Node marker = new Node(-1); // Marker node to indicate end of level 
		int level = 1; // Initialize level number 
		// Enqueue the only first level node and marker node for end of level 
		Q.add(node); 
		Q.add(marker); 
		// Simple level order traversal loop 
		while (Q.isEmpty() == false) { 
			// Remove the front item from queue 
			Node n = Q.remove(); 
			// Check if end of level is reached 
			if (n == marker) { 
				// print a new line and increment level number 
				System.out.println(""); 
				level++; 
				// Check if marker node was last node in queue or 
				// level number is beyond the given upper limit 
				if (Q.isEmpty() == true || level > high) {
		            // System.out.println("break1"); 
					break; 
				}
				// Enqueue the marker for end of next level 
				Q.add(marker); 
				// If this is marker, then we don't need print it and enqueue its children 
				continue; 
			} 
		    // System.out.println("break2"); 
			// If level is equal to or greater than given lower level, print it 
			if (level >= low) 
				System.out.print( n.data + " "); 
			// Enqueue children of non-marker node 
			if (n.left != null) 
				Q.add(n.left); 
			if (n.right != null) 
				Q.add(n.right); 
		} 
		// System.out.println("break3"); 
	} 

	public static void main(String args[]) {

		PrintNodesTwoLevel tree = new PrintNodesTwoLevel(); 

		tree.root = new Node(20); 
		
		tree.root.left = new Node(8); 
		tree.root.right = new Node(22); 

		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(12); 
		
		tree.root.left.right.left = new Node(10); 
		tree.root.left.right.right = new Node(14); 


		/*		 20
				/  \
			   8    22
			  / \
			 4   12
			     / \
			    10  14	*/

		System.out.print("\n"); 
		System.out.print("Level Order traversal between given two levels is "); 
		tree.printLevels(tree.root, 2, 3); 

		// breakStatement();

	} 
} 

/*
Print nodes between two given level numbers of a binary tree

Given a binary tree and two level numbers ‘low’ and ‘high’, print nodes from level low to level high.
For example consider the binary tree given in below diagram. 

Input: Root of below tree, low = 2, high = 4
		 20
		/  \
	   8    22
	  / \
	 4   12
	     / \
	    10  14	
Output:
8 22
4 12
10 14*/