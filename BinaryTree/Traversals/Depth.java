// Calculate depth of a full Binary tree from Preorder

//javac -d classes Depth.java  && cd classes && java Depth && cd ..

import java .io.*; 

class Depth { 

	static int findDepthRec(String tree, int n, int index) { 
		if (index >= n || tree.charAt(index) == 'l') {
			return 0; 
		}
		index++; 
		int left = findDepthRec(tree, n, index); 
		index++; 
		int right = findDepthRec(tree, n, index); 
		return Math.max(left, right) + 1; 
	} 

	// Wrapper over findDepthRec() 
	static int findDepth(String tree, int n) { 
		int index = 0; 
		return findDepthRec(tree, n, index); 
	} 

	// Driver Code 
	static public void main(String[] args) { 
		// String tree = "nlnnlll"; 
		String tree = "nlnll"; 
		int n = tree.length(); 
		System.out.println("\n\nndepth: "+findDepth(tree, n)); 

		/*		    n
				   / \
				  l   n 
				     / \ 
				    l   l*/

	} 
} 


/*Calculate depth of a full Binary tree from Preorder

Given preorder of a binary tree, calculate its depth(or height) [starting from depth 0]. 
The preorder is given as a string with two possible characters.

‘l’ denotes the leaf
‘n’ denotes internal node

The given tree can be seen as a full binary tree where every node has 0 or two children. 
The two children of a node can ‘n’ or ‘l’ or mix of both.

Examples :

Input  : nlnll
Output : 2

Explanation :

    n
   / \
  l   n 
     / \ 
    l   l*/