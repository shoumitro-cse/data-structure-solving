// CPP code to demonstrate insert operation in binary search tree

 // g++ InsertOperationAndReversePathBST.cpp && ./a.out

#include <bits/stdc++.h> 
using namespace std; 

struct node { 
	int key; 
	struct node *left, *right; 
}; 

// A utility function to 
// create a new BST node 
struct node* newNode(int item) 
{ 
	struct node* temp = new node; 
	temp->key = item; 
	temp->left = temp->right = NULL; 
	return temp; 
} 

// A utility function to 
// do inorder traversal of BST 
void inorder(struct node* root) 
{ 
	if (root != NULL) { 
		inorder(root->left); 
		cout << root->key << " "; 
		inorder(root->right); 
	} 
} 

// reverse tree path using queue 
void reversePath(struct node** node, int& key, queue<int>& q1) { 
	 // If the tree is empty, return a new node 
	if (node == NULL) 
		return; 
	// If the node key equal to key then 
	if ((*node)->key == key) { 
		// push current node key 
		q1.push((*node)->key); 
		// replace first node with last element 
		(*node)->key = q1.front(); 
		// remove first element 
		q1.pop(); 
		// return 
		return; 
	} 
	// if key smaller than node key then 
	else if (key < (*node)->key) { 
		// push node key into queue 
		q1.push((*node)->key); 
		// recusive call itself 
		reversePath(&(*node)->left, key, q1); 
		// replace queue front to node key 
		(*node)->key = q1.front(); 
		// performe pop in queue 
		q1.pop(); 
	} 
	
	// if key greater than node key then 
	else if (key > (*node)->key) { 
		// push node key into queue 
		q1.push((*node)->key); 
		// recusive call itself 
		reversePath(&(*node)->right, key, q1); 
		// replace queue front to node key 
		(*node)->key = q1.front(); 
		// performe pop in queue 
		q1.pop(); 
	} 
	// return 
	return; 
} 

 // A utility function to insert a new node with given key in BST 
struct node* insert(struct node* node, int key) { 
	 // If the tree is empty, return a new node 
	if (node == NULL) 
		return newNode(key); 

	 // Otherwise, recur down the tree 
	if (key < node->key) 
		node->left = insert(node->left, key); 
	else if (key > node->key) 
		node->right = insert(node->right, key); 

	 // return the (unchanged) node pointer 
	return node; 
} 

// Driver Program to test above functions 
int main() { 



	struct node* root = NULL; 
	queue<int> q1; 

	// reverse path till k 
	// int k = 40; 
	int k = 80; 
	root = insert(root, 50); 
	insert(root, 30); 
	insert(root, 20); 
	insert(root, 40); 
	insert(root, 70); 
	insert(root, 60); 
	insert(root, 80); 
      /*     50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */

	cout << "Before Reverse :" << endl; 
	// print inoder traversal of the BST 
	inorder(root); 

	cout << "\n"; 

	// reverse path till k 
	reversePath(&root, k, q1); 
	
	cout << "After Reverse :" << endl; 

	// print inorder of reverse path tree 
	inorder(root); 
	cout<< endl; 

	return 0; 
} 



/*Reverse a path in BST using queue

Given a binary search tree and a key, your task to reverse path of the binary tree.

Prerequisite : Reverse path of Binary tree

Examples :

Input :       50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 
k = 70
Output :
Inorder before reversal :
20 30 40 50 60 70 80 
Inorder after reversal :
20 30 40 70 60 50 80 

Input :       8
           /     \
          3       10
         /  \       \
       1    6         14
           /  \      /
          4    7    13
k = 13
Output :
Inorder before reversal :
1 3 4 6 7 8 10 13 14
Inorder after reversal :
1 3 4 6 7 13 14 8 10*/