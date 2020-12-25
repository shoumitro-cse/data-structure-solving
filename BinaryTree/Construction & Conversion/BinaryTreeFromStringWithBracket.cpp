 // Construct Binary Tree from String with bracket representation 

// g++ BinaryTreeFromStringWithBracket.cpp && ./a.out

#include <bits/stdc++.h>
using namespace std;

 // A binary tree node has data, pointer to left child and a pointer to right child 
struct Node {
	int data;
	Node *left, *right;
};
 // Helper function that allocates a new node 
Node* newNode(int data) {
	Node* node = (Node*)malloc(sizeof(Node));
	node->data = data;
	node->left = node->right = NULL;
	return (node);
}

 // This funtcion is here just to test 
void preOrder(Node* node) {
	if (node == NULL)
		return;
	printf("%d ", node->data);
	preOrder(node->left);
	preOrder(node->right);
}

// function to return the index of close parenthesis
int findIndex(string str, int si, int ei) {
	if (si > ei)
		return -1;
	// Inbuilt stack
	stack<char> s;
		// printf("%d\n", si);
	for (int i = si; i <= ei; i++) {
		// if open parenthesis, push it
		if (str[i] == '(') {
			s.push(str[i]);
		} else if (str[i] == ')') {
		    // if close parenthesis
			if (s.top() == '(') { // check top element
				s.pop(); // delete element
				// if stack is empty, this is the required index
				if (s.empty()) {
					return i;// first time return 9, 5, 14
				}
			}
		}
	}
	// if not found return -1
	return -1;
}

// function to construct tree from string
Node* treeFromString(string str, int si, int ei) {
	// Base case
	if (si > ei)
		return NULL;
	// new root
	Node* root = newNode(str[si]-'0');
	int index = -1;
	// if next char is '(' find the index of its complement ')'
	if (si+1 <= ei && str[si+1] == '(') {
		index = findIndex(str, si+1, ei);
		// printf("\n%d", index); //9, 5, 14
	}
	// if index found
	if (index != -1) {
		// printf("\n%d", si);
		// call for left subtree
		root->left = treeFromString(str, si+2, index-1);
		// call for right subtree
		root->right = treeFromString(str, index+2, ei-1);
	}
	return root;
}


int main() {

	// string str = "4 (2(3)(1)) (6(5))";
	string str = "4(2(3)(1))(6(5))";
	
	Node* root = treeFromString(str, 0, str.length()-1);
	
	printf("\n\n");
	preOrder(root);
	printf("\n");

	/*	       4
	         /   \
	        2     6
	       / \   / 
	      3   1 5      */

}


/*
Construct Binary Tree from String with bracket representation

Construct a binary tree from a string consisting of parenthesis and integers. 
The whole input represents a binary tree. It contains an integer followed by zero, 
one or two pairs of parenthesis. The integer represents the root’s value and a pair of 
parenthesis contains a child binary tree with the same structure. Always start to construct 
the left child node of the parent first if it exists.

Examples: 

Input : "1(2)(3)" 
Output : 1 2 3
Explanation :
           1
          / \
         2   3
Explanation: first pair of parenthesis contains 
left subtree and second one contains the right 
subtree. Preorder of above tree is "1 2 3".  

Input : "4(2(3)(1))(6(5))"
Output : 4 2 3 1 6 5
Explanation :
           4
         /   \
        2     6
       / \   / 
      3   1 5   
*/