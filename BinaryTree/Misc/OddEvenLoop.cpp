// C++ implementation to create odd and even loops
// in a binary tree

// g++ OddEvenLoop.cpp && ./a.out

#include <bits/stdc++.h>

using namespace std;

// structure of a node
struct Node
{
	int data;
	Node *left, *right, *abtr;
};

// Utility function to create a new node
struct Node* newNode(int data)
{
	struct Node* node = new Node;
	node->data = data;
	node->left = node->right = node->abtr = NULL;
	return node;
}

// preorder traversal to place the node pointer
// in the respective even_ptrs or odd_ptrs list
void preorderTraversal(Node *root, vector<Node*> *even_ptrs, vector<Node*> *odd_ptrs)
{
	if (!root)
		return;
	
	// place node ptr in even_ptrs list if
	// node contains even number 
	if (root->data % 2 == 0) 
		(*even_ptrs).push_back(root);
	// else place node ptr in odd_ptrs list
	else
		(*odd_ptrs).push_back(root);
		
	preorderTraversal(root->left, even_ptrs, odd_ptrs);
	preorderTraversal(root->right, even_ptrs, odd_ptrs);
}

// function to create the even and odd loops
void createLoops(Node *root) {
	
	vector<Node*> even_ptrs, odd_ptrs;

	preorderTraversal(root, &even_ptrs, &odd_ptrs);
	
	int i;
	
	// forming even loop
	for (i=1; i<even_ptrs.size(); i++)
		even_ptrs[i-1]->abtr = even_ptrs[i];
		
	// for the last element
	even_ptrs[i-1]->abtr = even_ptrs[0]; 
	
	// Similarly forming odd loop
	for (i=1; i<odd_ptrs.size(); i++)
		odd_ptrs[i-1]->abtr = odd_ptrs[i];
	odd_ptrs[i-1]->abtr = odd_ptrs[0];
}

// traversing the loop from any random
// node in the loop
void traverseLoop(Node *start)
{
	Node *curr = start;
	do {
		cout << curr->data << " ";
		curr = curr->abtr;
	} while (curr != start);
}

// Driver program to test above
int main()
{
	// Binary tree formation
	struct Node* root = NULL;
	root = newNode(1);				 /*		 1		 */
	root->left = newNode(2);			 /*	 / \	 */
	root->right = newNode(3);		 /*	 2	 3	 */
	root->left->left = newNode(4);	 /* / \ / \ */
	root->left->right = newNode(5);	 /* 4 5 6	 7 */
	root->right->left = newNode(6);
	root->right->right = newNode(7);
	
	createLoops(root);
	
	// traversing odd loop from any
	// random odd node
	cout << "Odd nodes: ";
	traverseLoop(root->right);
	
	cout << endl << "Even nodes: ";
	// traversing even loop from any
	// random even node
	traverseLoop(root->left); 
	
	return 0;
}


/*
Create loops of even and odd values in a binary tree

Given a binary tree with the node structure containing a data part, left and right pointers and an arbitrary pointer(abtr). The node’s value can be any positive integer. The problem is to create odd and even loops in a binary tree. An odd loop is a loop which connects all the nodes having odd numbers and similarly even loop is for nodes having even numbers. To create such loops, the abtr pointer of each node is used. An abtr pointer of an odd node(node having odd number) points to some other odd node in the tree. A loop must be created in such way that from any node we could traverse all the nodes in the loop to which the node belongs.
Examples: 
 

Consider the binary tree given below 

       1             
    /     \          
   2        3            
 /   \     /  \       
4     5   6    7   
     
Now with the help of abtr pointers of node, 
we connect odd and even nodes as:

Odd loop
1 -> 5 -> 3 -> 7 -> 1(again pointing to first node
                      in the loop)               
    
Even loop
2 -> 4 -> 6 -> 2(again pointing to first node
                 in the loop)

Nodes in the respective loop can be arranged in
any order. But from any node in the loop we should 
be able to traverse all the nodes in the loop.*/