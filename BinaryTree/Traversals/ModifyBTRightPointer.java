// Modify a binary tree to get preorder traversal using right pointers only

//javac -d classes ModifyBTRightPointer.java  && cd classes && java ModifyBTRightPointer && cd ..

import java.util.*; 

class ModifyBTRightPointer { 
	// A binary tree node has data, left child and right child 
	static class Node { 
		int data; 
		Node left; 
		Node right; 
	}; 
 
	static Node newNode(int data) { 
		Node node = new Node(); 
		node.data = data; 
		node.left = null; 
		node.right = null; 
		return (node); 
	} 


/*	static void modifytree(Node root)  {  
	    // Base Case  
	    if (root == null)  
	        return;  

	  	Stack<Node> nodeStack = new Stack<Node> ();  
	    nodeStack.push(root);  
	    Node pre = null;  

	    while (nodeStack.isEmpty() == false) {  
	  	    Node node = nodeStack.pop();  

	        if (node.right != null)  
	            nodeStack.push(node.right);  

	        if (node.left != null)  
	            nodeStack.push(node.left);  
	  
	        // check if some previous node exists  
	        if (pre != null) {  
	            pre.right = node;  
	        }  
	        // set previous node as current node  
	        pre = node;  
	    }  
	} */

	// Function to modify tree 
	static Node modifytree( Node root) { 

		Node right = root.right; 
		Node rightMost = root; 

		if (root.left != null) { 
			rightMost = modifytree(root.left); 
			root.right = root.left; 
			root.left = null; 
		} 

		if (right == null) {
			return rightMost; 
		}

		rightMost.right = right; 
		rightMost = modifytree(right); 

		return rightMost; 
	} 

	static void printpre( Node root) { 
		System.out.println(" "); 
		while (root != null) { 
			System.out.print( root.data + " "); 
			root = root.right; 
		} 
		System.out.println(" "); 
	} 

	// Driver cde 
	public static void main(String args[]) { 

		Node root = newNode(10); 
		root.left = newNode(8); 
		root.right = newNode(2); 
		root.left.left = newNode(3); 
		root.left.right = newNode(5); 

		/*          10
		          /   \
		        8      2
		      /  \    
		    3     5 */
		modifytree(root); 
		printpre(root); 
	} 
} 

/*
Modify a binary tree to get preorder traversal using right pointers only

Given a binary tree. Modify it in such a way that after modification you can 
have a preorder traversal of it using only the right pointers. During modification, 
you can use right as well as left pointers.

Examples:

Input :    10
          /   \
        8      2
      /  \    
    3     5  

    
Output :    10
              \
               8
                \ 
                 3
                  \
                   5
                    \
                     2

Explanation : The preorder traversal of given binary tree is 10 8 3 5 2.*/