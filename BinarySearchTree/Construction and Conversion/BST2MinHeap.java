// Java Program to convert a BST into a Min-Heap in O(n) time and in-place 

//javac -d classes BST2MinHeap.java  && cd classes && java BST2MinHeap && cd ..

import java.util.*; 

class BST2MinHeap 
{ 
	
	// Node for BST/Min-Heap 
	static class Node 
	{ 
		int data; 
		Node left, right; 
	}; 

	// Utility function for allocating node for BST 
	static Node newNode(int data) 
	{ 
		Node node = new Node(); 
		node.data = data; 
		node.left = node.right = null; 
		return node; 
	} 

	// Utility function to print Min-heap level by level 
	static void printLevelOrder(Node root) 
	{ 
		// Base Case 
		if (root == null) return; 

		// Create an empty queue for level order traversal 
		Queue<Node> q = new LinkedList<>(); 
		q.add(root); 

		while (q.size() > 0) 
		{ 
			int nodeCount = q.size(); 
			while (nodeCount > 0) 
			{ 
				Node node = q.peek(); 
				System.out.print( node.data + " "); 
				q.remove(); 
				if (node.left != null) 
					q.add(node.left); 
				if (node.right != null) 
					q.add(node.right); 
				nodeCount--; 
			} 
			System.out.println(); 
		} 
	} 

	// A simple recursive function to convert a given 
	// Binary Search tree to Sorted Linked List 
	// root	 -. Root of Binary Search Tree 
	// head_ref -. Pointer to head node of created 
	//			 linked list 
	static Node BSTToSortedLL(Node root, Node head_ref) 
	{ 
		// Base cases 
		if(root == null) 
			return head_ref; 
		// Recursively convert right subtree 
		head_ref = BSTToSortedLL(root.right, head_ref); 
		// insert root into linked list 
		root.right = head_ref; 
		// Change left pointer of previous head 
		// to point to null 
		if (head_ref != null) 
			(head_ref).left = null; 
		// Change head of linked list 
		head_ref = root; 
		// Recursively convert left subtree 
		head_ref = BSTToSortedLL(root.left, head_ref); 
		return head_ref; 
	} 

	// Function to convert a sorted Linked 
	// List to Min-Heap. 
	// root -. Root of Min-Heap 
	// head -. Pointer to head node of sorted 
	//			 linked list 
	static Node SortedLLToMinHeap(Node root, Node head) 
	{ 
		// Base Case 
		if (head == null) 
			return null; 
		// queue to store the parent nodes 
		Queue<Node > q = new LinkedList<>(); 
		// The first node is always the root node 
		root = head; 
		// advance the pointer to the next node 
		head = head.right; 
		// set right child to null 
		root.right = null; 
		// add first node to the queue 
		q.add(root); 
		// run until the end of linked list is reached 
		while (head != null) 
		{ 
			// Take the parent node from the q and remove it from q 
			Node parent = q.remove(); 

			Node leftChild = head; 
			head = head.right;	 // advance linked list to next node 
			leftChild.right = null; // set its right child to null 
			q.add(leftChild); 

			// Assign the left child of parent 
			parent.left = leftChild; 

			if (head != null) 
			{ 
				Node rightChild = head; 
				head = head.right; // advance linked list to next node 
				rightChild.right = null; // set its right child to null 
				q.add(rightChild); 

				// Assign the right child of parent 
				parent.right = rightChild; 
			} 
		} 
		return root; 
	} 

	// Function to convert BST into a Min-Heap 
	// without using any extra space 
	static Node BSTToMinHeap(Node root) 
	{ 
		// head of Linked List 
		Node head = null; 
		// Convert a given BST to Sorted Linked List 
		head = BSTToSortedLL(root, head); 
		// set root as null 
		root = null; 
		// Convert Sorted Linked List to Min-Heap 
		root = SortedLLToMinHeap(root, head); 
		return root; 
	} 

	// Driver code 
	public static void main(String args[]) 
	{ 
		/* Constructing below tree 
	        8
	     /    \
	    4      12
	  /  \     /  \
	 2    6   10  14
			*/

		Node root = newNode(8); 
		root.left = newNode(4); 
		root.right = newNode(12); 
		root.right.left = newNode(10); 
		root.right.right = newNode(14); 
		root.left.left = newNode(2); 
		root.left.right = newNode(6); 

		root = BSTToMinHeap(root); 

		/* Output - Min Heap 
		       2
		     /    \
		   4        6
		 /  \     /   \
		8    10  12   14
				*/

		printLevelOrder(root); 
	} 
} 


/*

Convert BST into a Min-Heap without using array

Given a Binary Search Tree, convert it into a Min-Heap containing the same elements in O(n) time. 
Do this in-place.

Input: Binary Search Tree
        8
     /    \
    4      12
  /  \     /  \
 2    6   10  14


Output - Min Heap
       2
     /    \
   4        6
 /  \     /   \
8    10  12   14
[Or any other tree that follows Min Heap
 properties and has same keys]
*/




/*// C++ implementation to convert the given 
// BST to Min Heap (using array)
#include <bits/stdc++.h> 
using namespace std; 

// structure of a node of BST 
struct Node 
{ 
	int data; 
	Node *left, *right; 
}; 


struct Node* getNode(int data) 
{ 
	struct Node *newNode = new Node; 
	newNode->data = data; 
	newNode->left = newNode->right = NULL; 
	return newNode; 
} 

// function prototype for preorder traversal 
// of the given tree 
void preorderTraversal(Node*); 

// function for the inorder traversal of the tree 
// so as to store the node values in 'arr' in 
// sorted order 
void inorderTraversal(Node *root, vector<int>& arr) 
{ 
	if (root == NULL) 
		return; 

	// first recur on left subtree 
	inorderTraversal(root->left, arr); 

	// then copy the data of the node 
	arr.push_back(root->data); 

	// now recur for right subtree 
	inorderTraversal(root->right, arr); 
} 

// function to convert the given BST to MIN HEAP 
// performs preorder traversal of the tree 
void BSTToMinHeap(Node *root, vector<int> arr, int *i) 
{ 
	if (root == NULL) 
		return; 

	// first copy data at index 'i' of 'arr' to 
	// the node 
	root->data = arr[++*i]; 

	// then recur on left subtree 
	BSTToMinHeap(root->left, arr, i); 

	// now recur on right subtree 
	BSTToMinHeap(root->right, arr, i); 
} 

// utility function to convert the given BST to 
// MIN HEAP 
void convertToMinHeapUtil(Node *root) 
{ 
	// vector to store the data of all the 
	// nodes of the BST 
	vector<int> arr; 
	int i = -1; 

	// inorder traversal to populate 'arr' 
	inorderTraversal(root, arr); 

	// BST to MIN HEAP conversion 
	BSTToMinHeap(root, arr, &i); 
} 

// function for the preorder traversal of the tree 
void preorderTraversal(Node *root) 
{ 
	if (!root) 
		return; 

	// first print the root's data 
	cout << root->data << " "; 

	// then recur on left subtree 
	preorderTraversal(root->left); 

	// now recur on right subtree 
	preorderTraversal(root->right); 
} 

// Driver program to test above 
int main() 
{ 
	// BST formation 
	struct Node *root = getNode(4); 
	root->left = getNode(2); 
	root->right = getNode(6); 
	root->left->left = getNode(1); 
	root->left->right = getNode(3); 
	root->right->left = getNode(5); 
	root->right->right = getNode(7); 

	convertToMinHeapUtil(root); 
	cout << "Preorder Traversal:" << endl; 
	preorderTraversal(root); 

	return 0; 
} 
*/