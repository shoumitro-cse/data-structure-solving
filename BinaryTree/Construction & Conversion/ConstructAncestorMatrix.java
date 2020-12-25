// Java Program to construct ancestor matrix for a given tree

//javac -d classes ConstructAncestorMatrix.java  && cd classes && java ConstructAncestorMatrix && cd ..

import java.util.*;

class ConstructAncestorMatrix {

	// ancestorMatrix function to populate the matrix of
	//Time complexity of above solution is O(n2).
	public static void ancestorMatrix(Node root , int matrix[][],int size) {	
		// base case:
		if (root==null)
		  return ;
		// call recursively for a preorder {left}
		ancestorMatrix(root.left, matrix, size);
		// call recursively for preorder {right}
		ancestorMatrix(root.right, matrix, size);
		// here we will reach the root node automatically try solving on pen and paper
		if (root.left != null) {
			// make the current node as parent of its children node
			matrix[root.data][root.left.data] = 1;
			
			for (int i = 0; i < size; i++) {
				if (matrix[root.left.data][i] == 1){
				  matrix[root.data][i] = 1;
				}
			}
		}

		// same procedure followed for right node as well 
		if (root.right != null) {

			matrix[root.data][root.right.data] = 1;
			
			for (int i = 0; i < size; i++) {

				if (matrix[root.right.data][i]==1) {
				  matrix[root.data][i] = 1;
				}
			}
		}
			
		
	}
	

	public static void main(String[] args) {
		// construct the binary tree as follows
		Node tree_root = new Node(5);
		tree_root.left = new Node (1);
		tree_root.right = new Node(2);
		tree_root.left.left = new Node(0);
		tree_root.left.right = new Node(4);
		tree_root.right.left = new Node(3);

		/*		  5
				/   \
			   1     2
			  / \   /
			 0   4 3	*/
		
		// size of matrix 
		int size = 6;
		int matrix [][] = new int[size][size];
		
		ancestorMatrix(tree_root, matrix, size);
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	// node class for tree node
	static class Node {
		
		public int data ;
		public Node left ,right;

		public Node (int data){
			this.data = data;
			this.left = this.right = null;
		}
	}


}



/*
Construct Ancestor Matrix from a Given Binary Tree

Given a Binary Tree where all values are from 0 to n-1. 
Construct an ancestor matrix mat[n][n]. 
Ancestor matrix is defined as below.

mat[i][j] = 1 if i is ancestor of j
mat[i][j] = 0, otherwise

Examples: 

Input: Root of below Binary Tree.
          0
        /   \
       1     2
       
Output: 0 1 1
        0 0 0 
        0 0 0 

Input: Root of below Binary Tree.
           5
        /    \
       1      2
      /  \    /
     0    4  3

Output: 0 0 0 0 0 0 
        1 0 0 0 1 0 
        0 0 0 1 0 0 
        0 0 0 0 0 0 
        0 0 0 0 0 0 
        1 1 1 1 1 0*/