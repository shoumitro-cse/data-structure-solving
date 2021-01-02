//Insertion in Threaded Binary Search Tree. 

//javac -d classes InsertionThreadedBT.java  && cd classes && java InsertionThreadedBT && cd ..

import java.util.*; 

class InsertionThreadedBT { 

	static class Node { 
		Node left, right; 
		int info; 
		// True if left pointer points to predecessor in Inorder Traversal 
		boolean lthread; 
		// True if right pointer points to predecessor in Inorder Traversal 
		boolean rthread; 
	}; 
		
	// Insert a Node in Binary Threaded Tree 
	static Node insert( Node root, int ikey) { 

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
		
			if (ikey < ptr.info) { // Moving on left subtree. 
				if (ptr.lthread == false) 
					ptr = ptr.left; 
				else
					break; 
			} else { // Moving on right subtree. 
				if (ptr.rthread == false) 
					ptr = ptr.right; 
				else
					break; 
			} 
		} 
		
		// Create a new node 
		Node tmp = new Node(); 
		tmp.info = ikey; 
		tmp.lthread = true; 
		tmp.rthread = true; 
		
		if (par == null) { 
			root = tmp; 
			tmp.left = null; 
			tmp.right = null; 
		} else if (ikey < par.info) { 
			tmp.left = par.left; 
			tmp.right = par; 
			par.lthread = false; 
			par.left = tmp; 
		} else { 
			tmp.left = par; 
			tmp.right = par.right; 
			par.rthread = false; 
			par.right = tmp; 
		} 
		
		return root; 
	} 
		
	// Returns inorder successor using rthread 
	static Node inorderSuccessor( Node ptr) { 
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
	static void inorder( Node root) { 
		if (root == null) 
			System.out.printf("Tree is empty"); 

		// Reach leftmost node 
		Node ptr = root; 
		while (ptr.lthread == false) 
			ptr = ptr.left; 
		
		// One by one print successors 
		while (ptr != null) { 
			System.out.printf("%d ",ptr.info); 
			ptr = inorderSuccessor(ptr); 
		} 
	} 
		
	// Driver Program 
	public static void main(String[] args) {

		Node root = null; 
		
		root = insert(root, 20); 
		root = insert(root, 10); 
		root = insert(root, 30); 
/*		root = insert(root, 5); 
		root = insert(root, 16); 
		root = insert(root, 14); 
		root = insert(root, 17); 
		root = insert(root, 13); */
		
		System.out.println("\n");
		inorder(root); 
		System.out.println();
	} 
} 
