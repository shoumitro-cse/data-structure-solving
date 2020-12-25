// Java program to convert a ternary expreesion to a tree. 

//javac -d classes TernaryExpreesionToBinaryTree.java  && cd classes && java TernaryExpreesionToBinaryTree && cd ..

import java.util.Queue; 
import java.util.LinkedList; 

// Class to represent Tree node 
class Node { 
	char data; 
	Node left, right; 

	public Node(char item) { 
		data = item; 
		left = null; 
		right = null; 
	} 
} 

// Class to convert a ternary expression to a Tree 
class TernaryExpreesionToBinaryTree { 

   // Time Complexity : O(n) [ here n is length of String ]
	Node convertExpression(char[] expression, int i) { 
		
		// Base case 
		if (i >= expression.length) 
			return null; 
		
		Node root = new Node(expression[i]); 
		i = i+1; 

		if (i < expression.length && expression[i]=='?') {
			// System.out.println(root.data); // a b
			root.left = convertExpression(expression, i+1); 
		} else if (i < expression.length) {
			root.right = convertExpression(expression, i+1); 
		    // System.out.println(root.data+" "+root.right.data); //c d
		}

		return root; 
	} 
	
	// function print tree 
	public void printTree( Node root) 
	{ 
		if (root == null) 
			return; 
		System.out.print(root.data +" "); 
		printTree(root.left); 
		printTree(root.right); 
	} 
	
// Driver program to test above function 
	public static void main(String args[]) 
	{ 
		TernaryExpreesionToBinaryTree tree = new TernaryExpreesionToBinaryTree(); 
		
		String exp = "a?b?c:d:e"; 
		char[] expression=exp.toCharArray(); 
		
		Node root = tree.convertExpression(expression, 0); 
		
		System.out.println(); 
		tree.printTree(root) ; 
		System.out.println(); 


/*		Input : expression =  a?b?c:d:e

		Output :     a
		           /  \
		          b    null
		        /  \ 
		       c    null
              / \
           null  d
                / \
             null  e   */

	} 
} 


/*
Convert Ternary Expression to a Binary Tree

Given a string that contains ternary expressions. The expressions may be nested, 
task is convert the given ternary expression to a binary Tree.


Examples:

Input :  string expression =   a?b:c 
Output :        a
              /  
             b    
              \
               c
Input : expression =  a?b?c:d:e

Output :     a
           /  \
          b    null
        /  \ 
       c    null
      / \
   null  d
        / \
     null  e



Examples(make this own):

Input :  string expression =   a?b:c 
Output :        a
              /  \
             b    c

Input : expression =  a?b?c:d:e

Output :     a
           /  \
          b    e
        /  \
       c    d


Idea is that we traverse a string make first character as root and do following step recursively .
1. If we see Symbol ‘?’
…….. then we add next character as the left child of root.
2. If we see Symbol ‘:’
…….. then we add it as the right child of current root.
do this process until we traverse all element of “String”.

       */