//Pairwise Swap leaf nodes in a binary tree

// g++ PairwiseSwapLeaf.cpp && ./a.out

#include <bits/stdc++.h> 
using namespace std; 

// A Binary Tree Node 
struct Node 
{ 
	int data; 
	struct Node *left, *right; 
}; 

// function to swap two Node 
void Swap(Node **a, Node **b) 
{ 
	Node * temp = *a; 
	*a = *b; 
	*b = temp; 
} 

// two pointers to keep track of 
// first and second nodes in a pair 
Node **firstPtr; 
Node **secondPtr; 

// function to pairwise swap leaf 
// nodes from left to right 
void pairwiseSwap(Node **root, int &count) 
{ 
	// if node is null, return 
	if (!(*root)) 
		return; 
	// if node is leaf node, increment count 
	if(!(*root)->left && !(*root)->right) { 
		// initialize second pointer by current node 
		secondPtr = root; 
		// increment count 
		count++; 
		// if count is even, swap first and second pointers 
		if (count % 2 == 0) 
			Swap(firstPtr, secondPtr); 
		else
			// if count is odd, initialize first pointer by second pointer 
			firstPtr = secondPtr; 
	} 

	// if left child exists, check for leaf recursively 
	if ((*root)->left) 
		pairwiseSwap(&(*root)->left, count); 
	// if right child exists, check for leaf recursively 
	if ((*root)->right) 
		pairwiseSwap(&(*root)->right, count); 

} 

// Utility function to create a new tree node 
Node* newNode(int data) 
{ 
	Node *temp = new Node; 
	temp->data = data; 
	temp->left = temp->right = NULL; 
	return temp; 
} 

// function to print inorder traversal 
// of binary tree 
void printInorder(Node* node) 
{ 
	if (node == NULL) 
		return; 
	/* first recur on left child */
	printInorder(node->left);
	/* then print the data of node */
	printf("%d ", node->data); 
	/* now recur on right child */
	printInorder(node->right); 
} 

// Driver program to test above functions 
int main() 
{ 
	// Let us create binary tree shown in 
	// above diagram 
	Node *root = newNode(1); 
	root->left = newNode(2); 
	root->right = newNode(3); 
	root->left->left = newNode(4); 
	root->right->left = newNode(5); 
	root->right->right = newNode(8); 
	root->right->left->left = newNode(6); 
	root->right->left->right = newNode(7); 
	root->right->right->left = newNode(9); 
	root->right->right->right = newNode(10); 

	// print inorder traversal before swapping 
	cout << "Inorder traversal before swap:\n"; 
	printInorder(root); 
	cout << "\n"; 

	// variable to keep track 
	// of leafs traversed 
	int c = 0; 

	// Pairwise swap of leaf nodes 
	pairwiseSwap(&root, c); 

	// print inorder traversal after swapping 
	cout << "Inorder traversal after swap:\n"; 
	printInorder(root); 
	cout << "\n"; 

	return 0; 
} 

/*
Pairwise Swap leaf nodes in a binary tree

Given a binary tree, we need to write a program to swap leaf nodes in the given
 binary tree pairwise starting from left to right as shown below.

Tree before swapping:



Tree after swapping:


The sequence of leaf nodes in original binary tree from left to right is (4, 6, 7, 9, 10).
 Now if we try to form pairs from this sequence, we will have two pairs as (4, 6), (7, 9). 
 The last node (10) is unable to form pair with any node and thus left unswapped.

*/