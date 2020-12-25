//convert a given binary tree to a tree that holds logical AND property. 

//javac -d classes BinaryTreeToLogicalANDTree.java  && cd classes && java BinaryTreeToLogicalANDTree && cd ..

class BinaryTreeToLogicalANDTree { 

	// Structure of binary tree 
	static class Node 
	{ 
		int data; 
		Node left; 
		Node right; 
	} 

	// function to create a new node 
	static Node newNode(int key) 
	{ 
		Node node = new Node(); 
		node.data= key; 
		node.left = null; 
		node.right = null; 
		return node; 
	} 

	// Convert the given tree to a tree where 
	// each node is logical AND of its children 
	// The main idea is to do Postorder traversal 
	static void convertTree(Node root) 
	{ 
		if (root == null) 
			return; 
		 // first recur on left child 
		convertTree(root.left); 
		 // then recur on right child 
		convertTree(root.right); 

		if (root.left != null && root.right != null) {
			root.data = (root.left.data) & (root.right.data); 
		}
	} 

	static void printInorder(Node root) 
	{ 
		if (root == null) 
			return; 
		/* first recur on left child */
		printInorder(root.left); 
		/* then print the data of node */
		System.out.print(root.data + " "); 
		/* now recur on right child */
		printInorder(root.right); 
	} 

	// main function 
	public static void main(String[] args) 
	{ 

		Node root=newNode(0); 

		root.left=newNode(1); 
		root.right=newNode(0); 

		root.left.left=newNode(0); 
		root.left.right=newNode(1); 

		root.right.left=newNode(1); 
		root.right.right=newNode(1); 

		/*Input : The below tree doesn’t hold the logical AND property
		        convert it to a tree that holds the property.
		             0
		           /   \
		          1     0
		         / \   / \
		        0   1 1   1 
		Output :
		             0
		           /   \
		          0     1
		         / \   / \
		        0   1 1   1 */

		System.out.print("\n\nInorder traversal before conversion "); 
		printInorder(root); 

		convertTree(root); 

		System.out.print("\nInorder traversal after conversion "); 
		printInorder(root); 
		System.out.println(); 
	}
} 



/*Convert a given Binary tree to a tree that holds Logical AND property

Given a Binary Tree (Every node has at most 2 children) where each node has value either 0 or 1. 
Convert a given Binary tree to a tree that holds Logical AND property, 
i.e., each node value should be the logical AND between its children.

Examples:

Input : The below tree doesn’t hold the logical AND property
        convert it to a tree that holds the property.
             1
           /   \
          1     0
         / \   / \
        0   1 1   1 
Output :
             0
           /   \
          0     1
         / \   / \
        0   1 1   1 */