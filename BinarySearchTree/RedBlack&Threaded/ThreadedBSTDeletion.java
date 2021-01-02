// Threaded Binary Search Tree | Deletion

///javac -d classes ThreadedBSTDeletion.java  && cd classes && java ThreadedBSTDeletion && cd ..

import java.util.*;

class ThreadedBSTDeletion {

	static class Node {
		Node left, right;
		int info;
		// True if left pointer points to predecessor
		// in Inorder Traversal
		boolean lthread;
		// True if right pointer points to predecessor
		// in Inorder Traversal
		boolean rthread;
	};

	// Insert a Node in Binary Threaded Tree
	static Node insert(Node root, int ikey)
	{
		// Searching for a Node with given value
		Node ptr = root;
		Node par = null; // Parent of key to be inserted
		while (ptr != null) {
			// If key already exists, return
			if (ikey == (ptr.info)) {
				System.out.printf("Duplicate Key !\n");
				return root;
			}

			par = ptr; // Update parent pointer

			// Moving on left subtree.
			if (ikey < ptr.info) {
				if (ptr.lthread == false)
					ptr = ptr.left;
				else
					break;
			}

			// Moving on right subtree.
			else {
				if (ptr.rthread == false)
					ptr = ptr.right;
				else
					break;
			}
		}

		// Create a new Node
		Node tmp = new Node();
		tmp.info = ikey;
		tmp.lthread = true;
		tmp.rthread = true;

		if (par == null) {
			root = tmp;
			tmp.left = null;
			tmp.right = null;
		}
		else if (ikey < (par.info)) {
			tmp.left = par.left;
			tmp.right = par;
			par.lthread = false;
			par.left = tmp;
		}
		else {
			tmp.left = par;
			tmp.right = par.right;
			par.rthread = false;
			par.right = tmp;
		}

		return root;
	}


	// Returns inorder successor using rthread
	// (Used in inorder)
	static Node inorderSuccessor(Node ptr)
	{
		// If rthread is set, we can quickly find
		if (ptr.rthread == true)
			return ptr.right;

		// Else return leftmost child of right subtree
		ptr = ptr.right;
		while (ptr.lthread == false)
			ptr = ptr.left;
		return ptr;
	}

	// Printing the threaded tree
	static void inorder(Node root)
	{
		if (root == null)
			System.out.printf("Tree is empty");

		// Reach leftmost Node
		Node ptr = root;
		while (ptr.lthread == false)
			ptr = ptr.left;

		// One by one print successors
		while (ptr != null) {
			System.out.printf("%d ", ptr.info);
			ptr = inorderSuccessor(ptr);
		}
	}

	static Node inPredecessor(Node ptr) {

		if (ptr.lthread == true)
			return ptr.left;

		ptr = ptr.left;
		while (ptr.rthread == false)
			ptr = ptr.right;
		return ptr;
	
	}

	// Here 'par' is pointer to parent Node and 'ptr' is
	// pointer to current Node.
	static Node caseA(Node root, Node par, Node ptr) {// delete leaf node

		// If Node to be deleted is root
		if (par == null) {
			root = null;
		} else if (ptr == par.left) {
		    // If Node to be deleted is left of its parent
			par.lthread = true;
			par.left = ptr.left;
		} else {
			par.rthread = true;
			par.right = ptr.right;
		}

		return root;
	}

	// Here 'par' is pointer to parent Node and 'ptr' is pointer to current Node.
	  
	// delete middle node with lthread=true or rthread=true
	static Node caseB(Node root, Node par, Node ptr) {

		Node child;

		// Initialize child Node to be deleted has left child.
		if (ptr.lthread == false)
			child = ptr.left;
		// Node to be deleted has right child.
		else
			child = ptr.right;

		// Node to be deleted is root Node.
		if (par == null)
			root = child;
		// Node is left child of its parent.
		else if (ptr == par.left)
			par.left = child;
		else
			par.right = child;

		// Find successor and predecessor
		Node s = inorderSuccessor(ptr);
		Node p = inPredecessor(ptr);

		// If ptr has left subtree.
		if (ptr.lthread == false) {
			p.right = s;
		} else { // If ptr has right subtree.
		  if (ptr.rthread == false)
			s.left = p;
		}

		return root;
	}

	// Here 'par' is pointer to parent Node and 'ptr' is pointer to current Node.
	
	// delete middle node with lthread=rthread=true
	static Node caseC(Node root, Node par, Node ptr) { 
		// Find inorder successor and its parent.
		Node parsucc = ptr;
		Node succ = ptr.right;

		// Find leftmost child of successor
		while (succ.lthread == false) {
			parsucc = succ;
			succ = succ.left;
		}

		ptr.info = succ.info;

		if (succ.lthread == true && succ.rthread == true)
			root = caseA(root, parsucc, succ);
		else
			root = caseB(root, parsucc, succ);

		return root;
	}

	// Deletes a key from threaded BST with given root and returns new root of BST.
	static Node delThreadedBST(Node root, int dkey) {
		// Initialize parent as null and ptrent
		// Node as root.
		Node par = null, ptr = root;
		// Set true if key is found
		int found = 0;
		// Search key in BST : find Node and its parent.
		while (ptr != null) {

			if (dkey == ptr.info) {
				found = 1;
				break;
			}

			par = ptr;
			if (dkey < ptr.info) {
				if (ptr.lthread == false)
					ptr = ptr.left;
				else
					break;
			} else {
				if (ptr.rthread == false)
					ptr = ptr.right;
				else
					break;
			}
		}

		if (found == 0)
			System.out.printf("dkey not present in tree\n");
		// Two Children
		else if (ptr.lthread == false && ptr.rthread == false)
			root = caseC(root, par, ptr);
		// Only Left Child
		else if (ptr.lthread == false)
			root = caseB(root, par, ptr);
		// Only Right Child
		else if (ptr.rthread == false)
			root = caseB(root, par, ptr);
		// No child
		else
			root = caseA(root, par, ptr);

		return root;
	}


	public static void main(String args[]) {
		
		Node root = null;

		root = insert(root, 20);
		root = insert(root, 10);
		root = insert(root, 30);
		root = insert(root, 5);
		root = insert(root, 16);
		root = insert(root, 14);
		root = insert(root, 17);
		root = insert(root, 13);

		// root = delThreadedBST(root, 20);
		root = delThreadedBST(root, 16);

		System.out.println("\n");
		inorder(root);
		System.out.println();
	}
}
