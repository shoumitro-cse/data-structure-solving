// Java code for max sum with adjacent levels not allowed 

//javac -d classes MaxSumAdjacentLevelsNotAllowed.java  && cd classes && java MaxSumAdjacentLevelsNotAllowed && cd ..

import java.util.*; 

public class MaxSumAdjacentLevelsNotAllowed { 

	// Tree node class for Binary Tree 
	// representation 
	static class Node { 
		int data; 
		Node left, right; 
		Node(int item) 
		{ 
			data = item; 
			left = right = null; 
		} 
	} 

	// Recursive function to find the maximum 
	// sum returned for a root node and its 
	// grandchildren 
	public static int getSumAlternate(Node root) { 

		if (root == null) 
			return 0; 

		int sum = root.data; 
		if (root.left != null) { 
			sum += getSum(root.left.left); 
			sum += getSum(root.left.right); 
		} 
		if (root.right != null) { 
			sum += getSum(root.right.left); 
			sum += getSum(root.right.right); 
		} 
		return sum; 
	} 

	// Returns maximum sum with adjacent 
	// levels not allowed. This function mainly uses getSumAlternate() 
	public static int getSum(Node root) { 
		if (root == null) 
			return 0; 
		// We compute sum of alternate levels 
		// starting first level and from second level. And return maximum of two values. 
		return Math.max(getSumAlternate(root), getSumAlternate(root.left)+getSumAlternate(root.right)); 
	} 

	// Driver function 
	public static void main(String[] args) { 
		
/*		Node root = new Node(1); 
		root.left = new Node(2); 
		root.right = new Node(3); 
		root.right.left = new Node(4); 
		root.right.left.right = new Node(5); 
		root.right.left.right.left = new Node(6); */

	    Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.right.left = new Node(4); 
        root.right.right = new Node(5); 
        root.left.left = new Node(1);  
        /*    1
            /   \
           2     3
          /     / \
         1     4   5
          output: 1+1+4+5
         */

		System.out.println(getSum(root)); 
	} 
} 
 