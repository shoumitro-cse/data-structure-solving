// Path length having maximum number of bends


// g++ MaxBend.cpp && ./a.out
#include <bits/stdc++.h> 
using namespace std; 

// structure node 
struct Node { 
	int key; 
	struct Node* left; 
	struct Node* right; 
}; 

// Utility function to create a new node 
struct Node* newNode(int key) 
{ 
	struct Node* node = new Node(); 
	node->left = NULL; 
	node->right = NULL; 
	node->key = key; 

	return node; 
} 

void findMaxBendsUtil(struct Node* node, 
					char dir, int bends, 
					int* maxBends, int soFar, 
					int* len) 
{ 
	// Base Case 
	if (node == NULL) 
		return; 

	// Leaf node 
	if (node->left == NULL && node->right == NULL) { 
		if (bends > *maxBends) { 
			*maxBends = bends; 
			*len = soFar; 
		} 
	} 
	// Recurring for both left and right child 
	else { 
		if (dir == 'l') { 
			findMaxBendsUtil(node->left, dir, 
							bends, maxBends, 
							soFar + 1, len); 
			findMaxBendsUtil(node->right, 'r', 
							bends + 1, maxBends, 
							soFar + 1, len); 
		} 
		else { 
			findMaxBendsUtil(node->right, dir, 
							bends, maxBends, 
							soFar + 1, len); 
			findMaxBendsUtil(node->left, 'l', 
							bends + 1, maxBends, 
							soFar + 1, len); 
		} 
	} 
} 

// Helper function to call findMaxBendsUtil() 
int findMaxBends(struct Node* node) { 
	if (node == NULL) 
		return 0; 
	int len = 0, bends = 0, maxBends = -1; 
	// Call for left subtree of the root 
	if (node->left) 
		findMaxBendsUtil(node->left, 'l', bends, &maxBends, 1, &len); 
	// Call for right subtree of the root 
	if (node->right) 
		findMaxBendsUtil(node->right, 'r', bends, &maxBends, 1, &len); 
	// Include the root node as well in the path length 
	len++; 

	return len; 
} 

// Driver code 
int main() 
{ 
    /*
      10 
      / \ 
     8    2 
    / \  / 
    3  5 2 
          \ 
           1 
          / 
         9 
    */

	struct Node* root = newNode(10); 
	root->left = newNode(8); 
	root->right = newNode(2); 
	root->left->left = newNode(3); 
	root->left->right = newNode(5); 
	root->right->left = newNode(2); 
	root->right->left->right = newNode(1); 
	root->right->left->right->left = newNode(9); 

	cout << findMaxBends(root) - 1; 

	return 0; 
} 


/*
Path length having maximum number of bends


Given a binary tree, find the path length having maximum number of bends.
Note : Here, bend indicates switching from left to right or vice versa while traversing in the tree.
For example, consider below paths (L means moving leftwards, R means moving rightwards):
LLRRRR – 1 Bend
RLLLRR – 2 Bends
LRLRLR – 5 Bends

Prerequisite : Finding Max path length in a Binary Tree

Examples:

Input : 
            4
          /   \
        2      6
      /  \    / \
    1     3  5   7
                /
               9
              / \
             12 10
                  \
                  11
                  / \
                45  13
                      \
                      14

Output : 6

In the above example, the path 4-> 6-> 7-> 9-> 10-> 11-> 45
is having the maximum number of bends, i.e., 3. 

The length of this path is 6. 

*/