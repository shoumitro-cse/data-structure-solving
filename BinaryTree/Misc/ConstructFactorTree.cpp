// construct Factor Tree for a given number 

// g++ ConstructFactorTree.cpp && ./a.out

#include<bits/stdc++.h> 
using namespace std; 

// Tree node 
struct Node 
{ 
	struct Node *left, *right; 
	int key; 
}; 

// Utility function to create a new tree Node 
Node* newNode(int key) 
{ 
	Node* temp = new Node; 
	temp->key = key; 
	temp->left = temp->right = NULL; 
	return temp; 
} 

// Constructs factor tree for given value and stores root of tree at given reference. 
void createFactorTree(struct Node **node_ref, int val) { 
	*node_ref = newNode(val); 
	// the number is factorized 
	for (int i = 2 ; i < val/2 ; i++) { 
		if (val % i != 0) 
	      continue; 
		createFactorTree(&((*node_ref)->left), i); 
		createFactorTree(&((*node_ref)->right), val/i); 
	  return;// important 
	} 
} 

// Iterative method to find the height of Binary Tree 
void printLevelOrder(Node *root) 
{ 
	// Base Case 
	if (root == NULL) return; 

	queue<Node *> q; 
	q.push(root); 
	// q.push(NULL); 

	while (q.empty() == false) { 
		// Print front of queue and remove it from queue 
		Node *node = q.front(); 
		q.pop(); 
         
/*         if (!node && !q.empty()) {
	       cout<<endl; 
	       q.push(NULL); 
         } else {
		   cout << node->key << " "; 
         }*/
		   cout << node->key << " "; 

		if (node->left != NULL) 
			q.push(node->left); 
		if (node->right != NULL) 
			q.push(node->right); 
	}
} 

// driver program 
int main() 
{ 
	int val = 48;// sample value 
	struct Node *root = NULL; 

	createFactorTree(&root, val); 
	
	cout << "\n\nLevel order traversal of constructed factor tree: \n"; 
	printLevelOrder(root); 
	cout <<endl; 
	
	return 0; 
} 


/*
Factor Tree of a given Number

Factor Tree is an intuitive method to understand the factors of a number. 
It shows how all the factors are been derived from the number. 
It is a special diagram where you find the factors of a number, 
then the factors of those numbers, etc until you can’t factor anymore. 
The ends are all the prime factors of the original number.

Example:

Input : v = 48
Output : Root of below tree
   48
   /\
  2  24
     /\
    2  12
       /\
      2  6
         /\
        2  3

*/