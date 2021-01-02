//Find if there is a triplet in a Balanced BST that adds to zero

//g++ triplet.cpp && ./a.out

#include <bits/stdc++.h> 
using namespace std; 


// A BST node has key, and left and right pointers 
class node 
{ 
	public: 
	int key; 
	node *left; 
	node *right; 
}; 

// inorder traversal
void convertBSTtoDLL(node* root, node** head, node** tail) { 
	// Base case 
	if (root == NULL) 
		return; 
	// First convert the left subtree 
	if (root->left) 
		convertBSTtoDLL(root->left, head, tail); 
	// Then change left of current root as last node of left subtree 
	root->left = *tail; 
	// If tail is not NULL, then set right of tail as root, else current node is head 
	if (*tail) 
		(*tail)->right = root; 
	else
		*head = root; 
	// Update tail 
	*tail = root; 
	// Finally, convert right subtree 
	if (root->right) 
		convertBSTtoDLL(root->right, head, tail); 
} 


bool isPresentInDLL(node* head, node* tail, int sum) {

	while (head != tail) {

		int curr = head->key + tail->key; 
		if (curr == sum) 
			return true; 
		else if (curr > sum) 
			tail = tail->left; 
		else
			head = head->right; 
	} 
	return false; 
} 

// The main function that returns 
// true if there is a 0 sum triplet in BST otherwise returns false 
bool isTripletPresent(node *root) { 
	// Check if the given BST is empty 
	if (root == NULL) 
	  return false; 

	node* head = NULL; 
	node* tail = NULL; 
	convertBSTtoDLL(root, &head, &tail); 

	while ((head->right != tail) && (head->key < 0)) { 

		if (isPresentInDLL(head->right, tail, -1*head->key)) 
			return true; 
		else
			head = head->right; 
	} 

	return false; 
} 

// A utility function to create a new BST node with key as given num 
node* newNode(int num) { 
	node* temp = new node(); 
	temp->key = num; 
	temp->left = temp->right = NULL; 
	return temp; 
} 

// A utility function to insert a given key to BST 
node* insert(node* root, int key) 
{ 
	if (root == NULL) 
	  return newNode(key); 
	if (root->key > key) 
		root->left = insert(root->left, key); 
	else
		root->right = insert(root->right, key); 
	return root; 
} 

// Driver code 
int main() 
{ 
	node* root = NULL; 
	root = insert(root, 6); 
	root = insert(root, -13); 
	root = insert(root, 14); 
	root = insert(root, -8); 
	root = insert(root, 15); 
	root = insert(root, 13); 
	root = insert(root, 7); 

	if (isTripletPresent(root)) 
		cout << "Present"<<endl; 
	else
		cout << "Not Present"<<endl; 
	return 0; 
} 


/*
Find if there is a triplet in a Balanced BST that adds to zero


Given a Balanced Binary Search Tree (BST), write a function isTripletPresent() 
that returns true if there is a triplet in given BST with sum equals to 0, 
otherwise returns false. Expected time complexity is O(n^2) and only O(Logn) 
extra space can be used. You can modify given Binary Search Tree. Note that height of a
 Balanced BST is always O(Logn)
For example, isTripletPresent() should return true for following BST because there is a
triplet with sum 0, the triplet is {-13, 6, 7}

*/