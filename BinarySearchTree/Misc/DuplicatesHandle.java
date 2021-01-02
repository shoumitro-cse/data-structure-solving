// Java program to implement basic operations 
// (search, insert and delete) on a BST that 
// handles duplicates by storing count with 
// every node 

class DuplicatesHandle
{ 
	static class node 
	{ 
		int key; 
		int count; 
		node left, right; 
	}; 

	// A utility function to create a new BST node 
	static node newNode(int item) 
	{ 
		node temp = new node(); 
		temp.key = item; 
		temp.left = temp.right = null; 
		temp.count = 1; 
		return temp; 
	} 

	// A utility function to do inorder traversal of BST 
	static void inorder(node root) 
	{ 
		if (root != null) 
		{ 
			inorder(root.left); 
			System.out.print(root.key + "(" + 
							root.count + ") "); 
			inorder(root.right); 
		} 
	} 

	/* A utility function to insert a new 
	node with given key in BST */
	static node insert(node node, int key) 
	{ 
		/* If the tree is empty, return a new node */
		if (node == null) return newNode(key); 

		// If key already exists in BST, 
		// increment count and return 
		if (key == node.key) 
		{ 
		(node.count)++; 
			return node; 
		} 

		/* Otherwise, recur down the tree */
		if (key < node.key) 
			node.left = insert(node.left, key); 
		else
			node.right = insert(node.right, key); 

		/* return the (unchanged) node pointer */
		return node; 
	} 

	/* Given a non-empty binary search tree, return 
	the node with minimum key value found in that 
	tree. Note that the entire tree does not need 
	to be searched. */
	static node minValueNode(node node) 
	{ 
		node current = node; 

		/* loop down to find the leftmost leaf */
		while (current.left != null) 
			current = current.left; 

		return current; 
	} 

	/* Given a binary search tree and a key, 
	this function deletes a given key and 
	returns root of modified tree */
	static node deleteNode(node root, int key) 
	{ 
		// base case 
		if (root == null) return root; 
		// If the key to be deleted is smaller than the 
		// root's key, then it lies in left subtree 
		if (key < root.key) 
			root.left = deleteNode(root.left, key); 
		// If the key to be deleted is greater than 
		// the root's key, then it lies in right subtree 
		else if (key > root.key) 
			root.right = deleteNode(root.right, key); 

		// if key is same as root's key 
		else{ 
			// If key is present more than once, 
			// simply decrement count and return 
			if (root.count > 1) { 
				(root.count)--; 
				return root; 
			} 
			// ElSE, delete the node 
			// node with only one child or no child 
			if (root.left == null) { 
				node temp = root.right; 
				root=null; 
				return temp; 
			} else if (root.right == null) { 
				node temp = root.left; 
				root = null; 
				return temp; 
			} 
			// node with two children: Get the inorder 
			// successor (smallest in the right subtree) 
			node temp = minValueNode(root.right); 
			// Copy the inorder successor's 
			// content to this node 
			root.key = temp.key; 
			// Delete the inorder successor 
			root.right = deleteNode(root.right, temp.key); 
		} 
		return root; 
	} 

	// Driver Code 
	public static void main(String[] args) 
	{ 
		/* Let us create following BST 
				12(3) 
			/	 \ 
		10(2)	 20(1) 
		/ \ 
		9(1) 11(1) */
		node root = null; 
		root = insert(root, 12); 
		root = insert(root, 10); 
		root = insert(root, 20); 
		root = insert(root, 9); 
		root = insert(root, 11); 
		root = insert(root, 10); 
		root = insert(root, 12); 
		root = insert(root, 12); 

		System.out.print("Inorder traversal of " + 
						"the given tree " + "\n"); 
		inorder(root); 

		System.out.print("\nDelete 20\n"); 
		root = deleteNode(root, 20); 
		System.out.print("Inorder traversal of " + 
						"the modified tree \n"); 
		inorder(root); 

		System.out.print("\nDelete 12\n"); 
		root = deleteNode(root, 12); 
		System.out.print("Inorder traversal of " + 
						"the modified tree \n"); 
		inorder(root); 

		System.out.print("\nDelete 9\n"); 
		root = deleteNode(root, 9); 
		System.out.print("Inorder traversal of " + 
						"the modified tree \n"); 
		inorder(root); 
	} 
} 


/*

How to handle duplicates in Binary Search Tree?

In a Binary Search Tree (BST), all keys in left subtree of a key must be smaller and all keys in right subtree must be greater. So a Binary Search Tree by definition has distinct keys.
How to allow duplicates where every insertion inserts one more key with a value and every deletion deletes one occurrence?

A Simple Solution is to allow same keys on right side (we could also choose left side). For example consider insertion of keys 12, 10, 20, 9, 11, 10, 12, 12 in an empty Binary Search Tree

          12
       /     \
     10      20
    /  \     /
   9   11   12 
      /      \
    10       12
A Better Solution is to augment every tree node to store count together with regular fields like key, left and right pointers.
Insertion of keys 12, 10, 20, 9, 11, 10, 12, 12 in an empty Binary Search Tree would create following.

          12(3)
       /        \
     10(2)      20(1)
    /    \       
 9(1)   11(1)   

Count of a key is shown in bracket


*/