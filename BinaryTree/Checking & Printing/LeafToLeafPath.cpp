// Print the longest leaf to leaf path in a Binary tree

// g++ LeafToLeafPath.cpp && ./a.out

#include <bits/stdc++.h> 
using namespace std; 

// Tree node structure used in the program 
struct Node { 
	int data; 
	Node *left, *right; 
}; 

struct Node* newNode(int data) 
{ 
	struct Node* node = new Node; 
	node->data = data; 
	node->left = node->right = NULL; 

	return (node); 
} 

// Function to find height of a tree 
int height(Node* root, int& ans, Node*(&k), int& lh, int& rh, int& f) { 
	if (root == NULL) 
		return 0; 
	int left_height = height(root->left, ans, k, lh, rh, f); 
	int right_height = height(root->right, ans, k, lh, rh, f); 
	// update the answer, because diameter of a 
	// tree is nothing but maximum value of 
	// (left_height + right_height + 1) for each node 
	if (ans < 1 + left_height + right_height) { 
			ans = 1 + left_height + right_height; 
			// save the root, this will help us finding the 
			// left and the right part of the diameter 
			k = root; 
			// save the height of left & right subtree as well. 
			lh = left_height; 
			rh = right_height; 
	} 

	return 1 + max(left_height, right_height); 
} 

// prints the root to leaf path 
void printArray(int ints[], int len, int f) { 
	int i; 
	// print left part of the path in reverse order 
	if (f == 0) { 
		for (i = len - 1; i >= 0; i--) { 
			printf("%d ", ints[i]); 
		} 
	} else if (f == 1) { 
	   // print right part of the path 
		for (i = 0; i < len; i++) { 
			printf("%d ", ints[i]); 
		} 
	} 
} 

// this function finds out all the root to leaf paths 
void printPathsRecur(Node* node, int path[], int pathLen, int max, int& f) { 
	if (node == NULL) 
		return; 
	// append this node to the path array 
	path[pathLen] = node->data; 
	pathLen++; 
	// If it's a leaf, so print the path that led to here 
	if (node->left == NULL && node->right == NULL) { 
		// print only one path which is equal to the height of the tree. 
		if (pathLen == max && (f == 0 || f == 1)) { 
			printArray(path, pathLen, f); 
			f = 2; 
		} 
	} else { 
		// otherwise try both subtrees 
		printPathsRecur(node->left, path, pathLen, max, f); 
		printPathsRecur(node->right, path, pathLen, max, f); 
	} 
} 

// Computes the diameter of a binary tree with given root. 
void diameter(Node* root) { 
	if (root == NULL) 
		return; 
	// lh will store height of left subtree 
	// rh will store height of right subtree 
	int ans = -999, lh = 0, rh = 0; //int ans = INT_MIN;
	// f is a flag whose value helps in printing 
	// left & right part of the diameter only once 
	int f = 0; 
	Node* k; 
	int height_of_tree = height(root, ans, k, lh, rh, f); 
/*	cout<<height_of_tree<<endl;//5
	cout<<ans<<endl; //6
	cout<<lh<<endl;//3
	cout<<rh<<endl;//2
	cout<<k->data<<endl;//2*/
	int lPath[100], pathlen = 0; 
	// print the left part of the diameter 
	printPathsRecur(k->left, lPath, pathlen, lh, f); 
	printf("%d ", k->data); 
	int rPath[100]; 
	f = 1; 
	// print the right part of the diameter 
	printPathsRecur(k->right, rPath, pathlen, rh, f); 
} 

// Driver code 
int main() {

	struct Node* root = newNode(1); 
	root->left = newNode(2); 
	root->right = newNode(3); 
	root->left->left = newNode(4); 
	root->left->right = newNode(5); 
	root->left->right->left = newNode(6); 
	root->left->right->right = newNode(7); 
	root->left->left->right = newNode(8); 
	root->left->left->right->left = newNode(9); 

		/*    
		      1 
		    /   \      
		   2     3 
		 /   \    
		4     5 
		 \   / \  
		  8 6   7 
		 / 
		9       */

	diameter(root); 
	cout<<endl;

	return 0; 
} 


/*Print the longest leaf to leaf path in a Binary tree

The diameter of a tree (sometimes called the width) is the number of nodes on the longest 
path between two end nodes. In this post, we will see how to print the nodes involved in 
the diameter of the tree. The diagram below shows two trees each with diameter nine, the leaves 
that form the ends of the longest path are shaded (note that there is more than one path in 
each tree of length nine, but no path longer than nine nodes).


Examples:

Input:      1
          /   \
        2      3
      /  \
    4     5

Output : 4 2 1 3 
       or 5 2 1 3  

Input:      1
          /   \
        2      3
      /  \      \
    4     5      6

Output : 4 2 1 3 6
       or 5 2 1 3 6      */