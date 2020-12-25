// Java program to implement iterative preorder traversal 

//javac -d classes IterativePreorderTraversal.java  && cd classes && java IterativePreorderTraversal && cd ..

import java.util.Stack; 

// A binary tree node 
class Node { 

	int data; 
	Node left, right; 

	Node(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

class IterativePreorderTraversal { 

	Node root; 

/*	// Iterative function to do Preorder traversal of the tree  
   //Time Complexity: O(N)
   //Auxiliary Space: O(H), where H is the height of the tree.
	void iterativePreorder(Node node) { 
	    if (node == null) { 
	        return; 
	    } 
	    Stack<Node> st = new Stack<Node>(); 
	    Node curr = node; 
	      
	    while (curr != null || !st.isEmpty()) { 
	         
	        while (curr != null)  { 
	            System.out.print(curr.data + " "); 
	            if (curr.right != null) 
	                st.push(curr.right);  
	            curr = curr.left; 
	        } 
	        // We reach when curr is NULL, so We  
	        // take out a right child from stack  
	        if (!st.isEmpty()) { 
	            curr = st.pop(); 
	        } 
	    } 
	} */

	void iterativePreorder() { 
		iterativePreorder(root); 
	} 

	// An iterative process to print preorder traversal of Binary tree 
	// Time Complexity: O(N)
// Auxiliary Space: O(N), where N is the total number of nodes in the tree.
	void iterativePreorder(Node node) { 
		// Base Case 
		if (node == null) { 
			return; 
		} 
		// Create an empty stack and push root to it 
		Stack<Node> nodeStack = new Stack<Node>(); 
		nodeStack.push(root); 

		while (nodeStack.empty() == false) { 
			// Pop the top item from stack and print it 
			Node mynode = nodeStack.pop(); 
			System.out.print(mynode.data + " "); 
			// Push right and left children of the popped node to stack 
			if (mynode.right != null) { 
				nodeStack.push(mynode.right); 
			} 
			if (mynode.left != null) { 
				nodeStack.push(mynode.left); 
			} 
		} 
	} 

	// driver program to test above functions 
	public static void main(String args[]) { 
		IterativePreorderTraversal tree = new IterativePreorderTraversal(); 
		tree.root = new Node(10); 
		tree.root.left = new Node(8); 
		tree.root.right = new Node(2); 
		tree.root.left.left = new Node(3); 
		tree.root.left.right = new Node(5); 
		tree.root.right.left = new Node(2); 

		tree.iterativePreorder(); 
		System.out.println(" "); 
	} 
} 

