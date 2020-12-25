// Construct a special tree from given preorder traversal

//javac -d classes BinaryTreeFromPreorder.java  && cd classes && java BinaryTreeFromPreorder && cd ..


class Node { 
	int data; 
	Node left, right; 
	Node(int item) { 
		data = item; 
		left = right = null; 
	} 
} 


class Index { 
	int index = 0; 
} 

class BinaryTreeFromPreorder {

	Node root; 
	Index myindex = new Index(); 

	Node constructTreeUtil(int pre[], char preLN[], Index index_ptr, int n, Node temp) { 
		// store the current value of index in pre[] 
		int i = index_ptr.index; 
		// Base Case: All nodes are constructed 
		if (i == n) 
			return null; 
		// Allocate memory for this node and increment index for 
		// subsequent recursive calls 
		temp = new Node(pre[i]); 
		index_ptr.index++; 
		// If this is an internal node, construct left and right subtrees 
		// and link the subtrees 
		if (preLN[i] == 'N') { 
			temp.left = constructTreeUtil(pre, preLN, index_ptr, n, temp.left); 
			temp.right = constructTreeUtil(pre, preLN, index_ptr, n, temp.right); 
		} 

		return temp; 
	} 

	// A wrapper over constructTreeUtil() 
	Node constructTree(int pre[], char preLN[], int n, Node node) { 
		int index = 0; 
		return constructTreeUtil(pre, preLN, myindex, n, node); 
	} 

	 // This function is used only for testing 
	void printInorder(Node node) { 
		if (node == null) 
			return; 
		 // first recur on left child 
		printInorder(node.left); 
		 // then print the data of node 
		System.out.print(node.data + " "); 
		 // now recur on right child 
		printInorder(node.right); 
	} 

	public static void main(String args[]) {

		BinaryTreeFromPreorder tree = new BinaryTreeFromPreorder(); 
	
		int pre[] = new int[]{10, 30, 20, 5, 15}; 
		char preLN[] = new char[]{'N', 'N', 'L', 'L', 'L'}; 
		int n = pre.length; 
		// construct the above tree 
		Node mynode = tree.constructTree(pre, preLN, n, tree.root); 
		// Test the constructed tree 
		System.out.println("\n\nInorder Traversal of the Constructed Binary Tree: "); 
		tree.printInorder(mynode); 
		System.out.println(); 
	} 
} 

/*
Construct a special tree from given preorder traversal

Given an array ‘pre[]’ that represents Preorder traversal of a spacial binary tree where
every node has either 0 or 2 children. One more array ‘preLN[]’ is given which has only two 
possible values ‘L’ and ‘N’. The value ‘L’ in ‘preLN[]’ indicates that the corresponding node 
in Binary Tree is a leaf node and value ‘N’ indicates that the corresponding node is non-leaf node. 
Write a function to construct the tree from the given two arrays.

Example:

Input:  pre[] = {10, 30, 20, 5, 15},  preLN[] = {'N', 'N', 'L', 'L', 'L'}

Output: Root of following tree

          10
         /  \
        30   15
       /  \
      20   5               */