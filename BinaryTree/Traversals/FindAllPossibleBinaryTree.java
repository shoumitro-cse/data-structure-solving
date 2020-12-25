// Find all possible binary trees with given Inorder Traversal

//javac -d classes FindAllPossibleBinaryTree.java  && cd classes && java FindAllPossibleBinaryTree && cd ..


import java.util.Vector; 

 // Class containing left and right child of current node and key value
class Node { 
	int data; 
	Node left, right; 

	public Node(int item) { 
		data = item; 
		left = null; 
		right = null; 
	} 
} 

 // Class to print Level Order Traversal 
class FindAllPossibleBinaryTree { 

	Node root; 

	// A utility function to do preorder traversal of BST 
	void preOrder(Node node) { 
		if (node != null) { 
			System.out.print(node.data + " " ); 
			preOrder(node.left); 
			preOrder(node.right); 
		} 
	} 

	Vector<Node> getTrees(int arr[], int start, int end) { 
		// List to store all possible trees 
		Vector<Node> trees= new Vector<Node>(); 
		 // if start > end then subtree will be empty so returning NULL in the list 
		if (start > end) { 
			trees.add(null); 
			return trees; 
		} 
		 // Iterating through all values from start to end for constructing left and right subtree recursively 
		for (int i = start; i <= end; i++) { 
			 // Constructing left subtree 
			Vector<Node> left_trees = getTrees(arr, start, i-1); 
			 // Constructing right subtree 
			Vector<Node> right_trees = getTrees(arr, i+1, end); 
			 // Now looping through all left and right subtrees and connecting them to ith root below 
			for (int j = 0; j < left_trees.size(); j++) { 
				for (int k = 0; k < right_tr ees.size(); k++) { 
					// Making arr[i] as root 
					Node node = new Node(arr[i]); 
					// Connecting left subtree 
					node.left = left_trees.get(j); 
					// Connecting right subtree 
					node.right = right_trees.get(k); 
					// Adding this tree to list 
					trees.add(node); 
				} 
			} 
		} 
		return trees; 
	} 

	public static void main(String args[]) { 

		// int in[] = {4, 5, 7}; 
		int in[] = {3, 2}; 
		int n = in.length; 
		
		FindAllPossibleBinaryTree tree = new FindAllPossibleBinaryTree(); 
		
		Vector<Node> trees = tree.getTrees(in, 0, n-1); 

		System.out.println("Preorder traversal of different "+ " binary trees are:"); 
		
		for (int i = 0; i < trees.size(); i++) { 
			tree.preOrder(trees.get(i)); 
			System.out.println(""); 
		}

	} 
} 





/*Find all possible binary trees with given Inorder Traversal

Given an array that represents Inorder Traversal, find all possible Binary Trees with 
the given Inorder traversal and print their preorder traversals.

Examples:

Input:   in[] = {3, 2};
Output:  Preorder traversals of different possible Binary Trees are:
         3 2
         2 3
Below are different possible binary trees
    3        2
     \      /
      2    3

Input:   in[] = {4, 5, 7};
Output:  Preorder traversals of different possible Binary Trees are:
          4 5 7 
          4 7 5 
          5 4 7 
          7 4 5 
          7 5 4 
Below are different possible binary trees
  4         4           5         7       7
   \          \       /   \      /       /
    5          7     4     7    4       5
     \        /                  \     /
      7      5                    5   4 



Algorithm:

1) Initialize list of Binary Trees as empty.  
2) For every element in[i] where i varies from 0 to n-1,
    do following
......a)  Create a new node with key as 'arr[i]', let this node be 'node'
......b)  Recursively construct list of all left subtrees.
......c)  Recursively construct list of all right subtrees.
3) Iterate for all left subtrees
   a) For current leftsubtree, iterate for all right subtrees
      Add current left and right subtrees to 'node' and add
      'node' to list.

 */