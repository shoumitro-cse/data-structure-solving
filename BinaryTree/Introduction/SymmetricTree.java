//Symmetric Tree (Mirror Image of itself)

// Java program to check is binary tree is symmetric or not 

//javac -d classes SymmetricTree.java  && cd classes && java SymmetricTree && cd ..

class Node { 
	int data; 
	Node left, right; 
	Node(int item) { 
		data = item; 
		left = right = null; 
	} 
} 

class SymmetricTree {

	Node root; 

	// returns true if trees with roots as root1 and root2 are mirror 
	boolean isMirror(Node node1, Node node2) { 
		// if both trees are empty, then they are mirror image 
		if (node1 == null && node2 == null) 
			return true; 

		if (node1 != null && node2 != null && node1.data == node2.data) 
			return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left); 

		return false; 
	} 

	// returns true if the tree is symmetric i.e mirror image of itself 
	boolean isSymmetric(Node node) { 
		// check if tree is mirror of itself 
		return isMirror(root, root); 
	} 

	// Driver program 
	public static void main(String args[]) { 

		SymmetricTree tree = new SymmetricTree(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(2); 
		tree.root.left.left = new Node(3); 
		tree.root.left.right = new Node(4); 
		tree.root.right.left = new Node(4); 
		tree.root.right.right = new Node(3); 

		/*   1
		   /   \
		  2     2
		 / \   / \
		3   4 4   3*/

		boolean output = tree.isSymmetric(tree.root); 

		if (output == true) 
			System.out.println("\n\ntrue"); 
		else
			System.out.println("\n\nfalse"); 
	} 
} 



/*
Symmetric Tree (Mirror Image of itself)

Given a binary tree, check whether it is a mirror of itself.

For example, this binary tree is symmetric:

     1
   /   \
  2     2
 / \   / \
3   4 4   3


But the following is not:

    1
   / \
  2   2
   \   \
   3    3*/