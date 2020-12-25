// AVL with duplicate keys

//An AVL tree (named after inventors Adelson-Velsky and Landis) is a 
//self-balancing binary search tree.

//javac -d classes AVLBinaryTree.java  && cd classes && java AVLBinaryTree && cd ..

import java.util.*; 

class AVLBinaryTree { 

	// An AVL tree Node 
	static class Node { 
		int data; 
		Node left; 
		Node right; 
		int height; 
		int count; 
	} 

	// A utility function to get height of the tree 
	static int height(Node temp) { 
		if (temp == null) 
			return 0; 
		return temp.height; 
	} 

	// A utility function to get maximum of two integers 
	static int max(int a, int b) { 
		return (a > b) ? a : b; 
	} 

	 // Helper function that allocates a new Node with the given data and 
	// null left and right pointers. 
	static Node newNode(int data) { 
		Node Node = new Node(); 
		Node.data = data; 
		Node.left = null; 
		Node.right = null; 
		Node.height = 1; // new Node is initially added at leaf 
		Node.count = 1; 
		return Node; 
	} 

	// A utility function to right rotate subtree rooted with y 
	// See the diagram given above. 
	static Node rightRotate(Node y) {
		Node x = y.left; 
		Node T2 = x.right; 
		// Perform rotation 
		x.right = y; 
		y.left = T2; 
		// Update heights 
		y.height = max(height(y.left), height(y.right)) + 1; 
		x.height = max(height(x.left), height(x.right)) + 1; 
		// Return new root 
		return x; 
	} 

	// A utility function to left rotate subtree rooted with x 
	// See the diagram given above. 
	static Node leftRotate(Node x) { 
		Node y = x.right; 
		Node T2 = y.left; 
		// Perform rotation 
		y.left = x; 
		x.right = T2; 
		// Update heights 
		x.height = max(height(x.left), height(x.right)) + 1; 
		y.height = max(height(y.left), height(y.right)) + 1; 
		// Return new root 
		return y; 
	} 

	// Get Balance factor of Node N 
	static int getBalance(Node N) { 
		if (N == null) 
			return 0; 
		return height(N.left) - height(N.right); 
	} 

	static Node insert(Node Node, int data) { 
		// 1. Perform the normal BST rotation 
		if (Node == null) {
			return newNode(data); 
		}
		// If data already exists in BST, increment count and return 
		if (Node.data == data) { 
			  Node.count++; 
			return Node; 
		} 
		 // Otherwise, recur down the tree 
		if (data < Node.data) 
			Node.left = insert(Node.left, data); 
		else
			Node.right = insert(Node.right, data); 

		 // 2. Update height of this ancestor Node 
		Node.height = max(height(Node.left), height(Node.right)) + 1; 
		 // 3. Get the balance factor of this ancestor Node to check whether 
		//this Node became unbalanced 
		int balance = getBalance(Node); //1, 0

		// If this Node becomes unbalanced, then there are 4 cases 

		// Left=> Left Case 
		if (balance > 1 && data < Node.left.data) 
			return rightRotate(Node); 

		// Left=> Right Case 
		if (balance > 1 && data > Node.left.data) { 
			Node.left = leftRotate(Node.left); 
			return rightRotate(Node); 
		} 

		// Right=> Right Case 
		if (balance < -1 && data > Node.right.data) 
			return leftRotate(Node); 


		// Right=> Left Case 
		if (balance < -1 && data < Node.right.data) { 
			Node.right = rightRotate(Node.right); 
			return leftRotate(Node); 
		} 
		 // return the (unchanged) Node pointer 
		return Node; 
	} 

	static Node minValueNode(Node Node) { 
		Node current = Node; 
		 // loop down to find the leftmost leaf 
		while (current.left != null) { 
			current = current.left; 
		}
		return current; 
	} 

	static Node deleteNode(Node root, int data) { 
		// STEP 1: PERFORM STANDARD BST DELETE 
		if (root == null) 
			return root; 
		// If the data to be deleted is smaller than the root's data, 
		// then it lies in left subtree 
		if (data < root.data) {
			root.left = deleteNode(root.left, data); 
		}
		// If the data to be deleted is greater than the root's data, 
		// then it lies in right subtree 
		else if (data > root.data) {
			root.right = deleteNode(root.right, data); 
		}
		// if data is same as root's data, then This is the Node to be deleted 
		else { 
			// If data is present more than once, simply decrement 
			// count and return 
			if (root.count > 1) { 
				 root.count--; 
				return null; 
			} 
			// ElSE, delete the Node 

			// Node with only one child or no child 
			if (root.left == null || root.right == null) { 
				Node temp = root.left != null ? root.left : root.right; 
				// No child case 
				if (temp == null) { 
					// temp = root; 
					root = null; 
				} else { // One child case 
					root = temp; // Copy the contents of the non-empty child
				} 
			} else { 
				// Node with two children: Get the inorder successor (smallest 
				// in the right subtree) 
				Node temp = minValueNode(root.right); 
				// Copy the inorder successor's data to this Node and update the count 
				root.data = temp.data; 
				root.count = temp.count; 
				temp.count = 1; 
				// Delete the inorder successor 
				root.right = deleteNode(root.right, temp.data); 
			} 
		} 

		// If the tree had only one Node then return 
		if (root == null) {
			return root; 
		}
		// STEP 2: UPDATE HEIGHT OF THE CURRENT Node 
		root.height = max(height(root.left), height(root.right)) + 1; 
		// STEP 3: GET THE BALANCE FACTOR OF THIS Node (to check whether 
		// this Node became unbalanced) 
		int balance = getBalance(root); 
		// If this Node becomes unbalanced, then there are 4 cases 

		// Left--> Left Case 
		if (balance > 1 && getBalance(root.left) >= 0) 
			return rightRotate(root); 
		// Left--> Right Case 
		if (balance > 1 && getBalance(root.left) < 0) { 
			root.left = leftRotate(root.left); 
			return rightRotate(root); 
		} 
		// Right--> Right Case 
		if (balance < -1 && getBalance(root.right) <= 0) 
			return leftRotate(root); 
		// Right--> Left Case 
		if (balance < -1 && getBalance(root.right) > 0) { 
			root.right = rightRotate(root.right); 
			return leftRotate(root); 
		} 

		return root; 
	} 

	// A utility function to print preorder traversal of the tree. 
	// The function also prints height of every Node 
	static void preOrder(Node root) { 
		if (root != null) { 
			System.out.printf("%d(%d) ", root.data, root.count); 
			preOrder(root.left); 
			preOrder(root.right); 
		} 
	} 

	 // Driver program to test above function
	public static void main(String args[]) {

		Node root = null; 

		 // Coning tree given in the above figure 
		root = insert(root, 9); 
		root = insert(root, 5); 

		root = insert(root, 10); 
		
		root = insert(root, 5); 
		root = insert(root, 9); 
		
		root = insert(root, 7); 
		root = insert(root, 17); 

		/*	     9(2)
		       /      \
		      5(2)    10(1)
		    /    \     /  \
		   null  7(1) null 17(1)     */ 

		System.out.printf("\nPre order traversal of the constructed AVL tree is \n"); 
		preOrder(root); 
		System.out.printf("\n"); 

        Node del = deleteNode(root, 9);

/*        Node del = deleteNode(root, 7);
        if (del != null) {
		   System.out.println("\ndelete: "+del.data); 
        }*/

		System.out.printf("\nPre order traversal after deletion of 9 \n"); 
		preOrder(root); 
		System.out.printf("\n"); 
	} 
} 


/*
AVL with duplicate keys

Please refer below post before reading about AVL tree handling of duplicates.

How to handle duplicates in Binary Search Tree?
This is to augment AVL tree node to store count together with regular fields like key, 
left and right pointers.

Insertion of keys 12, 12, 12, 10, 10, 20, 9, 11 in an 
empty Binary Search Tree would create following.

          12(3)
       /        \
     10(2)      20(1)
    /    \       
 9(1)   11(1)

  */