// Check if two nodes are cousins in a Binary Tree

//javac -d classes CheckTwoNodesAreCousins.java  && cd classes && java CheckTwoNodesAreCousins && cd ..

class Node 
{ 
	int data; 
	Node left, right; 

	Node(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

class CheckTwoNodesAreCousins {

	Node root; 
	// Recursive function to check if two Nodes are siblings 
	boolean isSibling(Node node, Node a, Node b) { 
		// Base case 
		if (node == null) 
			return false; 

		return ((node.left == a && node.right == b) || 
				(node.left == b && node.right == a) || 
				isSibling(node.left, a, b) || isSibling(node.right, a, b)); 
	} 

	// Recursive function to find level of Node 'ptr' in a binary tree 
	int level(Node node, Node ptr, int lev) { 
		// base cases 
		if (node == null) 
			return 0; 

		if (node == ptr) 
			return lev; 
		// Return level if Node is present in left subtree 
		int l = level(node.left, ptr, lev + 1); 
		if (l != 0) 
			return l; 
		// Else search in right subtree 
		return level(node.right, ptr, lev + 1); 
	} 

	// Returns 1 if a and b are cousins, otherwise 0 
	boolean isCousin(Node root, Node a, Node b) { 
		// 1. The two Nodes should be on the same level in the binary tree. 
		// 2. The two Nodes should not be siblings 
		//    (means that they should not have the same parent Node). 
		return ((level(root, a, 1) == level(root, b, 1)) && (!isSibling(root, a, b))); 
	} 

	//Driver program to test above functions 
	public static void main(String args[]) {

		CheckTwoNodesAreCousins tree = new CheckTwoNodesAreCousins(); 
		tree.root = new Node(1); 

		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 

		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 

		tree.root.left.right.right = new Node(15); 

		tree.root.right.left = new Node(6); 
		tree.root.right.right = new Node(7); 

		tree.root.right.left.right = new Node(8); 

		Node Node1, Node2; 

		Node1 = tree.root.left.left; 
		Node2 = tree.root.right.right; 

		if (tree.isCousin(tree.root, Node1, Node2)) 
			System.out.println("Yes"); 
		else
			System.out.println("No"); 
	} 
} 


/*
Check if two nodes are cousins in a Binary Tree

Given the binary Tree and the two nodes say ‘a’ and ‘b’, determine whether the two 
nodes are cousins of each other or not.
Two nodes are cousins of each other if they are at same level and have different parents.

Example:

     6
   /   \
  3     5
 / \   / \
7   8 1   3
Say two node be 7 and 1, result is TRUE.
Say two nodes are 3 and 5, result is FALSE.
Say two nodes are 7 and 5, result is FALSE.*/