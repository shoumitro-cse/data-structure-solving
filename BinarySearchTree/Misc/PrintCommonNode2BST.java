// Print Common Nodes in Two Binary Search Trees

import java.util.*; 

class PrintCommonNode2BST { 

	// A BST node 
	static class Node { 
		int key; 
		Node left, right; 
	} 

	// A utility function to create a new node 
	static Node newNode(int ele) { 
		Node temp = new Node(); 
		temp.key = ele; 
		temp.left = null; 
		temp.right = null; 
		return temp; 
	} 

	// Function two print common elements in given two trees 
	static void printCommon(Node root1, Node root2) 
	{ 
		
		Stack<Node> s1 = new Stack<Node> (); 
		Stack<Node> s2 = new Stack<Node> (); 

		while (true) { 
			// push the Nodes of first tree in stack s1 
			if (root1 != null) { 
				s1.push(root1); 
				root1 = root1.left; 
			} else if (root2 != null) { 
		 	   // push the Nodes of second tree in stack s2 
				s2.push(root2); 
				root2 = root2.left; 
			} else if (!s1.isEmpty() && !s2.isEmpty()) { 
			  // Both root1 and root2 are NULL here 
				root1 = s1.peek(); 
				root2 = s2.peek(); 
				// If current keys in two trees are same 
				if (root1.key == root2.key) { 
					System.out.print(root1.key + " "); 
					s1.pop(); 
					s2.pop(); 
					// move to the inorder successor 
					root1 = root1.right; 
					root2 = root2.right; 
				} else if (root1.key < root2.key) { 
					s1.pop(); 
					root1 = root1.right; 
					// root2 is set to NULL, because we need new Nodes of tree 1 
					root2 = null; 
				} else if (root1.key > root2.key) { 
					s2.pop(); 
					root2 = root2.right; 
					root1 = null; 
				} 
			} else {
			   // Both roots and both stacks are empty 
				break; 
			}
		} 
	} 

	// A utility function to do inorder traversal 
	static void inorder(Node root) { 
		if (root != null) { 
			inorder(root.left); 
			System.out.print(root.key + " "); 
			inorder(root.right); 
		} 
	} 

	/* A utility function to insert a new Node with given key in BST */
	static Node insert(Node node, int key) 
	{ 
		/* If the tree is empty, return a new Node */
		if (node == null) return newNode(key); 
		/* Otherwise, recur down the tree */
		if (key < node.key) 
			node.left = insert(node.left, key); 
		else if (key > node.key) 
			node.right = insert(node.right, key); 
		/* return the (unchanged) Node pointer */
		return node; 
	} 

	// Driver program 
	public static void main(String[] args) 
	{ 
		// Create first tree as shown in example 
		Node root1 = null; 
		root1 = insert(root1, 5); 
		root1 = insert(root1, 1); 
		root1 = insert(root1, 10); 
		root1 = insert(root1, 0); 
		root1 = insert(root1, 4); 
		root1 = insert(root1, 7); 
		root1 = insert(root1, 9); 

		// Create second tree as shown in example 
		Node root2 = null; 
		root2 = insert(root2, 10); 
		root2 = insert(root2, 7); 
		root2 = insert(root2, 20); 
		root2 = insert(root2, 4); 
		root2 = insert(root2, 9); 

		System.out.print("Tree 1 : " + "\n"); 
		inorder(root1); 
		System.out.println(); 
		System.out.print("Tree 2 : " + "\n"); 
		inorder(root2); 
		System.out.println(); 
		System.out.println("Common Nodes: "); 

		printCommon(root1, root2); 

	} 
} 
