// Number of subtrees having odd count of even numbers

//javac -d classes NumberOfSubtrees.java  && cd classes && java NumberOfSubtrees && cd ..

import java.util.*; 

class NumberOfSubtrees { 

	static class Node { 
		int data; 
		Node left, right; 
	} 


	static Node newNode(int data) 
	{ 
		Node node = new Node(); 
		node.data = data; 
		node.left = null; 
		node.right = null; 
		return(node); 
	} 

	// Returns count of subtrees having odd count of even numbers 
	static class P { 
		int pcount = 0; 
	} 

	static int countRec(Node root, P p) { 
		// base condition 
		if (root == null) 
			return 0; 
		// count even nodes in left subtree 
		int c = countRec(root.left, p); 
		// Add even nodes in right subtree 
		c += countRec(root.right, p); 
		// Check if root data is an even number 
		if (root.data % 2 == 0) 
			c += 1; 
		// if total count of even numbers for the subtree is odd 
		if (c % 2 != 0) 
			(p.pcount)++; 
		// Total count of even nodes of the subtree 
		return c; 
	} 

	// A wrapper over countRec() 
	static int countSubtrees(Node root) { 
		P p = new P(); 
		countRec(root, p); 
		return p.pcount; 
	} 

	public static void main(String[] args) { 
		// binary tree formation 
		Node root = newNode(2); /*		 2		 */
		root.left	 = newNode(1); /*	 /	 \	 */
		root.right	 = newNode(3); /*	 1	 3	 */
		root.left.left = newNode(4); /* / \	 / \ */
		root.left.right = newNode(10); /* 4 10 8	 5 */
		root.right.left = newNode(8); /*	 /			 */
		root.right.right = newNode(5); /*	 6			 */
		root.left.right.left = newNode(6); 

	  System.out.println("Count = " + countSubtrees(root)); 
	} 
} 


/*
Number of subtrees having odd count of even numbers

Given a binary tree, find the number of subtrees having odd count of even numbers.

Examples:

Input :         2             
             /     \          
           1        3            
         /   \     /  \       
        4    10   8     5     
             /                
            6      
Output : 6
The subtrees are 4, 6,    1,      8,    3,
                        /   \          /  \
                        4    10       8    5
                            /
                           6

       2             
     /     \          
   1        3            
 /   \     /  \       
4    10   8     5     
     /                
    6   
*/