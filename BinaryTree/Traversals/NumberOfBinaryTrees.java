// Number of Binary Trees for given Preorder Sequence length

//javac -d classes NumberOfBinaryTrees.java  && cd classes && java NumberOfBinaryTrees && cd ..

import java.io.*; 

class NumberOfBinaryTrees { 

	static int countTrees(int n) { 
		// Array to store number of Binary tree for  every count of nodes 
		int binaryTree[] = new int[n+1]; 
		for(int i = 0; i <= n; i++) {
			binaryTree[i] = 0; 
		}

		binaryTree[0] = binaryTree[1] = 1; 
		// Start finding from 2 nodes, since already know for 1 node. 
		for (int i = 2; i <= n; ++i) {
			for (int j = 0; j < i; j++) { 
				binaryTree[i] = binaryTree[i] + binaryTree[j] * binaryTree[i-j-1];
			} 
		}
		return binaryTree[n]; 
	} 

	// Driver code 
	public static void main (String[] args) { 
	  int n = 4; 
	  System.out.println("\n\nTotal Possible " + "Binary Trees are : " + countTrees(n)); 

	} 
} 


/*
Number of Binary Trees for given Preorder Sequence length


Count the number of Binary Tree possible for a given Preorder Sequence length n.

Examples:

Input : n = 1
Output : 1

Input : n = 2
Output : 2

Input : n = 3
Output : 5


For example preorder traversal of below tree is 1 2 4 5 3 6 7
     1
   /   \
  2     3
 / \   / \
4   5 6   7 

*/