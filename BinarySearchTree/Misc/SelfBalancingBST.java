//Count inversions in an array | Set 2 (Using Self-Balancing BST)

//javac -d classes SelfBalancingBST.java  && cd classes && java SelfBalancingBST && cd ..

import java.util.*; 

class SelfBalancingBST { 

	// Initialize result 
	static int result = 0; 

	// An AVL tree node 
	static class Node 
	{ 
		int key, height; 
		Node left, right; 
		// Size of the tree rooted 
		// with this Node 
		int size; 
	} 

	// A utility function to get the height of 
	// the tree rooted with N 
	static int height(Node N) { 
		if (N == null) 
			return 0; 
		return N.height; 
	} 

	// A utility function to size of the 
	// tree of rooted with N 
	static int size(Node N) 
	{ 
		if (N == null) 
			return 0; 
		return N.size; 
	} 

	// A utility function to create a new node 
	static Node newNode(int ele) 
	{ 
		Node temp = new Node(); 
		temp.key = ele; 
		temp.left = null; 
		temp.right = null; 
		temp.height = 1; 
		temp.size = 1; 
		return temp; 
	} 

	// A utility function to right rotate subtree rooted with y 
	static Node rightRotate(Node y) { 
		Node x = y.left; 
		Node T2 = x.right; 
		// Perform rotation 
		x.right = y; 
		y.left = T2; 
		// Update heights 
		y.height = Math.max(height(y.left), height(y.right)) + 1; 
		x.height = Math.max(height(x.left), height(x.right)) + 1; 
		// Update sizes 
		y.size = size(y.left) + size(y.right) + 1; 
		x.size = size(x.left) + size(x.right) + 1; 

		// Return new root 
		return x; 
	} 

	// A utility function to left rotate  subtree rooted with x 
	static Node leftRotate(Node x) { 
		Node y = x.right; 
		Node T2 = y.left; 
		// Perform rotation 
		y.left = x; 
		x.right = T2; 
		// Update heights 
		x.height = Math.max(height(x.left), height(x.right)) + 1; 
		y.height = Math.max(height(y.left), height(y.right)) + 1; 
		// Update sizes 
		x.size = size(x.left) + size(x.right) + 1; 
		y.size = size(y.left) + size(y.right) + 1; 

		// Return new root 
		return y; 
	} 

	// Get Balance factor of Node N 
	static int getBalance(Node N) { 
		if (N == null) 
			return 0; 
		return height(N.left) - height(N.right); 
	} 

	// Inserts a new key to the tree rotted 
	// with Node. Also, updates *result 
	// (inversion count) 
	static Node insert(Node node, int key) 
	{ 
		
		// 1. Perform the normal BST rotation 
		if (node == null) 
			return (newNode(key)); 

		if (key < node.key) { 
			node.left = insert(node.left, key); 
			// UPDATE COUNT OF GREATE ELEMENTS FOR KEY 
			result = result + size(node.right) + 1; 
		} else
			node.right = insert(node.right, key); 
		// 2. Update height and size of  this ancestor node 
		node.height = Math.max(height(node.left), height(node.right)) + 1; 
		node.size = size(node.left) + size(node.right) + 1; 
		// 3. Get the balance factor of this 
		// ancestor node to check whether this 
		// node became unbalanced 
		int balance = getBalance(node); 
		// If this node becomes unbalanced, 
		// then there are 4 cases 
		// Left Left Case 
		if (balance > 1 && key < node.left.key) 
			return rightRotate(node); 
		// Right Right Case 
		if (balance < -1 && key > node.right.key) 
			return leftRotate(node); 
		// Left Right Case 
		if (balance > 1 && key > node.left.key) { 
			node.left = leftRotate(node.left); 
			return rightRotate(node); 
		} 
		// Right Left Case 
		if (balance < -1 && key < node.right.key) { 
			node.right = rightRotate(node.right); 
			return leftRotate(node); 
		} 
		// Return the (unchanged) node pointer 
		return node; 
	} 

	// The following function returns inversion 
	// count in arr[] 
	static void getInvCount(int arr[], int n) { 
		// Create empty AVL Tree 
		Node root = null; 
		for(int i = 0; i < n; i++) 
			root = insert(root, arr[i]); 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		int[] arr = new int[] { 8, 4, 2, 1 }; 
		int n = arr.length; 
		getInvCount(arr, n); 
		
		System.out.print("Number of inversions " + "count are : " + result); 
	} 
} 

/*

Count inversions in an array | Set 2 (Using Self-Balancing BST)

Inversion Count for an array indicates – how far (or close) the array is from being sorted. If an array is already sorted then the inversion count is 0. If an array is sorted in the reverse order that inversion count is the maximum. 
Two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j. For simplicity, we may assume that all elements are unique.
Example: 

Input: arr[] = {8, 4, 2, 1}
Output: 6

Explanation: Given array has six inversions:
(8,4), (4,2),(8,2), (8,1), (4,1), (2,1).


Input: arr[] = {3, 1, 2}
Output: 2

Explanation:Given array has two inversions:
(3, 1), (3, 2)  
*/