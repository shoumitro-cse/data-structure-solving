// Evaluation of Expression Tree

// g++ evaluate__expression_tree.cpp && ./a.out

#include <bits/stdc++.h> 
using namespace std; 

// Class to represent the Nodes of syntax tree 
class Node { 
	public: 
		string data; 
		Node *left = NULL, *right = NULL; 
		Node(string x) { 
			data = x; 
		} 
}; 

// Utility function to return the integer value of a given string 
int toInt(string s) { 
	int num = 0;
	if(s[0]!='-') { 
		for (int i=0; i<s.length(); i++) { 
			num = num*10 + (int(s[i])-48);
		} 
	} else {
		for (int i=1; i<s.length(); i++) { 
			num = num*10 + (int(s[i])-48); 
			num = num * -1; 
		} 
	}
	return num; 
} 

// This function receives a Node of the syntax tree and recursively evaluates it 
int eval(Node* root) { 
	// empty tree 
	if (root == NULL) 
		return 0; 
	// leaf Node i.e, an integer 
	if (root->left == NULL && root->right == NULL) 
		return toInt(root->data);
	// Evaluate left subtree 
	int l_val = eval(root->left); 
	// Evaluate right subtree 
	int r_val = eval(root->right); 
	// Check which operator to apply 
	if (root->data=="+") 
		return l_val+r_val; 

	if (root->data=="-") 
		return l_val-r_val; 

	if (root->data=="*") 
		return l_val*r_val; 

	return l_val/r_val; 
} 

//driver function to check the above program 
int main() { 
	// create a syntax tree 
	Node *root = new Node("+"); 
	root->left = new Node("*"); 
	root->left->left = new Node("5"); 
	root->left->right = new Node("-4"); 
	root->right = new Node("-"); 
	root->right->left = new Node("100"); 
	root->right->right = new Node("20"); 

	cout << eval(root) << endl; 

	delete(root); 

	root = new Node("+"); 
	root->left = new Node("*"); 
	root->left->left = new Node("5"); 
	root->left->right = new Node("4"); 
	root->right = new Node("-"); 
	root->right->left = new Node("100"); 
	root->right->right = new Node("/"); 
	root->right->right->left = new Node("20"); 
	root->right->right->right = new Node("2"); 

	cout << eval(root)<<endl; 
	return 0; 
} 
