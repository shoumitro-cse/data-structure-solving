// Find if given vertical level of binary tree is sorted or not

//g++ verticalLevelSortedORnot.cpp && ./a.out

#include <bits/stdc++.h> 
using namespace std; 

// Structure of a tree node. 
struct Node { 
	int key; 
	Node *left, *right; 
}; 

// Function to create new tree node. 
Node* newNode(int key) 
{ 
	Node* temp = new Node; 
	temp->key = key; 
	temp->left = temp->right = NULL; 
	return temp; 
} 

// Helper function to determine if 
// vertical level l of given binary 
// tree is sorted or not. 
bool isSorted(Node* root, int level) 
{ 
	// If root is null, then the answer is an 
	// empty subset and an empty subset is 
	// always considered to be sorted. 
	if (root == NULL) 
		return true; 
	// Variable to store previous 
	// value in vertical level l. 
	int prevVal = INT_MIN; 
	// Variable to store current level 
	// while traversing tree vertically. 
	int currLevel; 
	// Variable to store current node 
	// while traversing tree vertically. 
	Node* currNode; 
	// Declare queue to do vertical order 
	// traversal. A pair is used as element 
	// of queue. The first element in pair 
	// represents the node and the second 
	// element represents vertical level 
	// of that node. 
	queue<pair<Node*, int>> q; 
	// Insert root in queue. Vertical level 
	// of root is 0. 
	q.push(make_pair(root, 0)); 

	// Do vertical order traversal until 
	// all the nodes are not visited. 
	while (!q.empty()) { 
		currNode = q.front().first; 
		currLevel = q.front().second; 
		q.pop(); 

		// Check if level of node extracted from 
		// queue is required level or not. If it 
		// is the required level then check if 
		// previous value in that level is less 
		// than or equal to value of node. 
		if (currLevel == level) { 
			if (prevVal <= currNode->key) 
				prevVal = currNode->key;			 
			else
				return false;			 
		} 

		// If left child is not NULL then push it 
		// in queue with level reduced by 1. 
		if (currNode->left) 
			q.push(make_pair(currNode->left, currLevel - 1)); 

		// If right child is not NULL then push it 
		// in queue with level increased by 1. 
		if (currNode->right) 
			q.push(make_pair(currNode->right, currLevel + 1)); 
	} 

	// If the level asked is not present in the 
	// given binary tree, that means that level 
	// will contain an empty subset. Therefore answer 
	// will be true. 
	return true; 
} 

// Driver program 
int main() 
{ 
    /* 
             1 
            / \ 
           2   5 
          / \ 
         7   4 
            / 
           6 
    */

	Node* root = newNode(1); 
	root->left = newNode(2); 
	root->right = newNode(5); 
	root->left->left = newNode(7); 
	root->left->right = newNode(4); 
	root->left->right->left = newNode(6); 

	int level = -1; 
	if (isSorted(root, level) == true) 
		cout << "Yes"; 
	else
		cout << "No"; 
	return 0; 
} 


/*
Find if given vertical level of binary tree is sorted or not


Given a binary tree. Find if a given vertical level of the binary tree is sorted or not.
(For the case when two nodes are overlapping, check if they form a sorted sequence in the level they lie.)

Prerequisite: Vertical Order Traversal

Examples:

Input : 1
       / \
      2   5
     / \
    7   4
       /
      6
   Level l = -1   
Output : Yes
Nodes in level -1 are 2 -> 6 which
forms a sorted sequence.

Input: 1
        / \
       2   6
        \ /
        3 4
   Level l = 0
Output : Yes
Note that nodes with value 3 and 4
are overlapping in the binary tree.
So we check if this form a sorted
sequence level wise. The sequence formed
at level 0 is 1 -> 3 -> 4 which is sorted.  */