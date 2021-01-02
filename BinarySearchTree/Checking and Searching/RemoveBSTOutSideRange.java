//Remove BST keys outside the given range

import java.math.BigDecimal; 
import java.util.ArrayList; 
import java.util.Arrays; 
import java.util.List; 
import java.util.Scanner; 

class Node 
{ 
	int key; 
	Node left; 
	Node right; 
} 

class RemoveBSTOutSideRange 
{ 
	// Removes all nodes having value 
	// outside the given range and 
	// returns the root of modified tree 
	private static Node removeOutsideRange(Node root, int min, int max) 
	{ 
		// BASE CASE 
		if(root == null)  
			return null; 
		} 
		// FIRST FIX THE LEFT AND 
		// RIGHT SUBTREE OF ROOT 
		root.left = removeOutsideRange(root.left, min, max); 
		root.right = removeOutsideRange(root.right, min, max); 

		if(root.key < min) 
		{ 
			Node rchild = root.right; 
			root = null; 
			return rchild; 
		} 
		// 1. b) Root's key is greater than 
		// max value (Root is not in range) 
		if(root.key > max) { 
			Node lchild = root.left; 
			root = null; 
			return lchild; 
		} 
		// 2. Root in range 
		return root; 
	} 

	public static Node newNode(int num) 
	{ 
		Node temp = new Node(); 
		temp.key = num; 
		temp.left = null; 
		temp.right = null; 
		return temp; 
	} 

	public static Node insert(Node root, int key) 
	{ 
		if(root == null) 
		{ 
			return newNode(key); 
		} 
		if(root.key > key) 
		{ 
			root.left = insert(root.left, key); 
		} 
		else
		{ 
			root.right = insert(root.right, key); 
		} 
		return root; 
	} 
	
	private static void inorderTraversal(Node root) 
	{ 
		if(root != null) 
		{ 
			inorderTraversal(root.left); 
			System.out.print(root.key + " "); 
			inorderTraversal(root.right); 
		} 
	} 
	
	// Driver code 
	public static void main(String[] args) 
	{ 
		Node root = null; 
		root = insert(root, 6); 
		root = insert(root, -13); 
		root = insert(root, 14); 
		root = insert(root, -8); 
		root = insert(root, 15); 
		root = insert(root, 13); 
		root = insert(root, 7); 
		
		System.out.print("Inorder Traversal of " + 
						"the given tree is: "); 
		inorderTraversal(root); 
		
		root = removeOutsideRange(root, -10, 13); 
		
		System.out.print("\nInorder traversal of " + "the modified tree: "); 
		inorderTraversal(root); 
	} 
}


/*// Java code to count BST nodes that 
// lie in a given range 
class BinarySearchTree { 

	/* Class containing left and right child 
	of current node and key value*/
	static class Node { 
		int data; 
		Node left, right; 

		public Node(int item) { 
			data = item; 
			left = right = null; 
		} 
	} 

	// Root of BST 
	Node root; 

	// Constructor 
	BinarySearchTree() { 
		root = null; 
	} 
	
	// Returns count of nodes in BST in 
	// range [low, high] 
	int getCount(Node node, int low, int high) 
	{ 
		// Base Case 
		if(node == null) 
			return 0; 
		// If current node is in range, then 
		// include it in count and recur for 
		// left and right children of it 
		if(node.data >= low && node.data <= high) 
			return 1 + getCount(node.left, low, high)+ getCount(node.right, low, high); 
				
		// If current node is smaller than low, 
		// then recur for right child 
		else if(node.data < low) 
			return this.getCount(node.right, low, high); 
		
		// Else recur for left child 
		else
			return this.getCount(node.left, low, high);	 
	} 

	// Driver function 
	public static void main(String[] args) { 
		BinarySearchTree tree = new BinarySearchTree(); 
		
		tree.root = new Node(10); 
		tree.root.left	 = new Node(5); 
		tree.root.right	 = new Node(50); 
		tree.root.left.left = new Node(1); 
		tree.root.right.left = new Node(40); 
		tree.root.right.right = new Node(100); 
	// 	 Let us constructed BST shown in above example 
	// 	10 
	// 	/ \ 
	// 5	 50 
	// /	 / \ 
	// 1	 40 100 
	int l=5; 
	int h=45; 
	System.out.println("Count of nodes between [" + l + ", "
					+ h+ "] is " + tree.getCount(tree.root, 
												l, h)); 
	} 
} 
*/



/*
// Java program to print BST in given range 

// A binary tree node 
class Node { 

	int data; 
	Node left, right; 

	Node(int d) { 
		data = d; 
		left = right = null; 
	} 
} 

class BinaryTree { 
	
	static Node root; 
	
	void Print(Node node, int k1, int k2) { 
		
		if (node == null) { 
			return; 
		} 


		if (k1 < node.data) { 
			Print(node.left, k1, k2); 
		} 

		if (k1 <= node.data && k2 >= node.data) { 
			System.out.print(node.data + " "); 
		} 

		if (k2 > node.data) { 
			Print(node.right, k1, k2); 
		} 
	} 
	
	public static void main(String[] args) { 
		BinaryTree tree = new BinaryTree(); 
		int k1 = 10, k2 = 25; 
		tree.root = new Node(20); 
		tree.root.left = new Node(8); 
		tree.root.right = new Node(22); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(12); 

		tree.Print(root, k1, k2); 
	} 
} 

// This code has been contributed by Mayank Jaiswal 

*/

/*
Print BST keys in the given range


Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. Print all the keys of the tree in range k1 to k2. i.e. print all x such that k1<=x<=k2 and x is a key of given BST. Print all the keys in increasing order.
Example:

Graph:


Input: k1 = 10 and k2 = 22
Output: 12, 20 and 22.
Explanation: The keys are 4, 8, 12, 20, and 22.
So keys in range 10 to 22 is 12, 20 and 22.

Input: k1 = 1 and k2 = 10
Output: 4 and 8
Explanation: The keys are 4, 8, 12, 20, and 22.
So keys in range 1 to 10 is 4 and 8.*/




/*// Java code to print BST keys in given Range in 
// constant space using Morris traversal. 
class Morris { 

static class node { 

	int data; 
	node left, right; 
} 

// Function to print the keys in range 
static void RangeTraversal(node root, int n1, int n2) 
{ 
	if (root == null) 
		return; 

	node curr = root; 

	while (curr != null) { 

		if (curr.left == null) 
		{ 
			// check if current node 
			// lies between n1 and n2 
			if (curr.data <= n2 && curr.data >= n1) 
			{ 
				System.out.print(curr.data + " "); 
			} 

			curr = curr.right; 
		} 

		else { 
			node pre = curr.left; 
			// finding the inorder predecessor- 
			// inorder predecessor is the right 
			// most in left subtree or the left 
			// child, i.e in BST it is the 
			// maximum(right most) in left subtree. 
			while (pre.right != null && pre.right != curr) 
				pre = pre.right; 

			if (pre.right == null) 
			{ 
				pre.right = curr; 
				curr = curr.left; 
			} 

			else { 
				pre.right = null; 

				// check if current node lies 
				// between n1 and n2 
				if (curr.data <= n2 && curr.data >= n1) 
				{ 
					System.out.print(curr.data + " "); 
				} 

				curr = curr.right; 
			} 
		} 
	} 
} 

// Helper function to create a new node 
static node newNode(int data) 
{ 
	node temp = new node(); 
	temp.data = data; 
	temp.right = null; 
	temp.left = null; 

	return temp; 
} 

// Driver Code 
public static void main(String[] args) 
{ 

	//  Constructed binary tree is 
	// 	4 
	// 	/ \ 
	// 2	 7 
	// / \ / \ 
	// 1 3 6 10 


	node root = newNode(4); 
	root.left = newNode(2); 
	root.right = newNode(7); 
	root.left.left = newNode(1); 
	root.left.right = newNode(3); 
	root.right.left = newNode(6); 
	root.right.right = newNode(10); 

	RangeTraversal(root, 4, 12); 
	
} 
} 
*/