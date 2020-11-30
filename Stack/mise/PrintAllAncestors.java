// Java program to print all ancestors of a given key 
// javac -d classes PrintAllAncestors.java  && cd classes && java PrintAllAncestors && cd ..

import java.util.Stack; 

public class PrintAllAncestors {

	// Class for a tree node 
	static class Node { 
		int data; 
		Node left, right; 
		// constructor to create Node left and right are by default null 
		Node(int data) { 
			this.data = data; 
			left = right = null;
		} 
	} 
	
	// Iterative Function to print all ancestors of a given key 
	static void printAncestors(Node root, int key) {

		if(root == null) 
			return; 
		// Create a stack to hold ancestors 
		Stack<Node> st = new Stack<>(); 
		// Traverse the complete tree in postorder way till we find the key 
		while(true) { 
			// Traverse the left side. While traversing, push the nodes into 
			// the stack so that their right subtrees can be traversed later 
			while(root != null && root.data != key) { 
				st.push(root); // push current node 
				root = root.left; // move to next node 
			} 
			// If the node whose ancestors are to be printed is found, 
			// then break the while loop. 
			if(root != null && root.data == key) 
				break; 
			// Check if right sub-tree exists for the node at top 
			// If not then pop that node because we don't need this 
			// node any more. 
			if(st.peek().right == null) {

				root = st.pop(); 
				// If the popped node is right child of top, then remove the top 
				// as well. Left child of the top must have processed before. 
				while( st.empty() == false && st.peek().right == root) { 
					root = st.pop(); 
				} 
			} 
			// if stack is not empty then simply set the root as right child 
			// of top and start traversing right sub-tree. 
			root = st.empty() ? null : st.peek().right; 
		} 
		// If stack is not empty, print contents of stack 
		// Here assumption is that the key is there in tree 
		while( !st.empty() ) { 
		  System.out.print(st.pop().data+" ");  
		} 
	} 
	
	// Driver program to test above functions 
	public static void main(String[] args) {

		// Let us construct a binary tree 
		Node root = new Node(1);

		root.left = new Node(2); 
		root.right = new Node(3);

		root.left.left = new Node(4); 
		root.left.right = new Node(5); 

		root.right.left = new Node(6); 
		root.right.right = new Node(7); 

		root.left.left.left = new Node(8); 

		root.left.right.right = new Node(9); 

		root.right.right.left = new Node(10); 


		/*		    1
		        /       \
		       2         3
		     /   \     /   \
		    4     5   6     7 
		   /  \  / \        / \
		  8         9     10    */
		
		System.out.println("Following are all keys and their ancestors"); 

		for(int key = 1; key <= 10; key++) { 
			System.out.print(key+": "); 
			printAncestors(root, key); 
			System.out.println(); 
		} 
	} 

} 


/*Print ancestors of a given binary tree node without recursion


Given a Binary Tree and a key, write a function that prints all the ancestors of the key 
in the given binary tree.
For example, consider the following Binary Tree

            1
        /       \
       2         3
     /   \     /   \
    4     5    6    7 
   /       \       /
  8         9     10  
Following are different input keys and their ancestors in the above tree

Input Key    List of Ancestors 
-------------------------
 1            
 2            1
 3            1
 4            2 1
 5            2 1
 6            3 1
 7            3 1
 8            4 2 1
 9            5 2 1
10            7 3 1*/