// Check if a given Binary Tree is height balanced like a Red-Black Tree

//javac -d classes CheckHeightBalanced.java  && cd classes && java CheckHeightBalanced && cd ..

class CheckHeightBalanced { 

	static class Node { 
		int key; 
		Node left, right; 
		Node(int key) { 
			left = null; 
			right = null; 
			this.key = key; 
		} 
	} 


	// Returns returns tree if the Binary 
	// tree is balanced like a Red-Black 
	// tree. This function also sets value 
	// in maxh and minh (passed by reference). 
	// maxh and minh are set as maximum and 
	// minimum heights of root. 
	// time complexity is O(n)
	static boolean isBalancedUtil(Node root, int maxh, int minh) { 
		// Base case 
		if (root == null) { 
			maxh = minh= 0; 
			return true; 
		} 
		// To store max and min heights of left subtree 
		int leftMaxheight=0;
		int leftMinheight=0; 
		// To store max and min heights of right subtree 
		int rightMaxheight=0;
		int rightMinheight=0; 
		// Check if left subtree is balanced, also set leftMaxheight and leftMinheight 
		if (isBalancedUtil(root.left, leftMaxheight, leftMinheight) == false) 
			return false; 
		// Check if right subtree is balanced, also set rightMaxheight and rightMinheight 
		if (isBalancedUtil(root.right, rightMaxheight, rightMinheight) == false) 
			return false; 
		// Set the max and min heights of this node for the parent call 
		// System.out.println(leftMaxheight.d+" "+leftMinheight.d+" : "+rightMaxheight.d+" "+rightMinheight.d);
		// System.out.println("Ans: "+maxh.d+" "+minh.d);
		maxh = Math.max(leftMaxheight, rightMaxheight) + 1 ; 
		minh = Math.min(leftMinheight, rightMinheight) + 1; 
		// System.out.println("Ans: "+maxh.d+" "+minh.d+"\n");
		// See if this node is balanced 
		if (maxh <= 2*minh)  
			return true; 
		return false; 
	} 

	// A wrapper over isBalancedUtil() 
	static boolean isBalanced(Node root) { 
		int maxh=0, minh=0; 
		return isBalancedUtil(root, maxh, minh); 
	} 


	public static void main(String args[]) { 
	
		Node root = new Node(10); 
	
		root.left = new Node(5); 
		root.right = new Node(100); 
	
		root.right.left = new Node(50); 
		root.right.right = new Node(150); 
	
		root.right.left.left = new Node(40); 

/*		Node root = new Node(10); 
		root.right = new Node(100); 
		root.right.left = new Node(50); 
		root.right.left.left = new Node(40); 
		root.right.left.left.left = new Node(40); 
		root.right.left.left.left.left = new Node(40); 
		root.right.left.left.left.left.left = new Node(40); 
		root.right.left.left.left.left.left.left = new Node(40); 
		root.right.left.left.left.left.left.left.left = new Node(40); 
		root.right.left.left.left.left.left.left.left.left = new Node(40); 
		root.right.left.left.left.left.left.left.left.left.left = new Node(40); 
		root.right.left.left.left.left.left.left.left.left.left.left = new Node(40); 
		root.right.left.left.left.left.left.left.left.left.left.left.left = new Node(40); */

		/*		  10
		        /   \
		      5     100
		           /   \
		          50   150
		         /
		        40 */

		System.out.println(isBalanced(root) ? "Balanced" : "Not Balanced"); 
	
	} 
} 

/*Check if a given Binary Tree is height balanced like a Red-Black Tree

In a Red-Black Tree, the maximum height of a node is at most twice the minimum height 
(The four Red-Black tree properties make sure this is always followed). 
Given a Binary Search Tree, we need to check for following property.
For every node, length of the longest leaf to node path has not more than twice the nodes
on shortest path from node to leaf.

    12                                        40
      \                                     /    \ 
       14                                 10      100    
         \                                        /  \
          16                                     60   150    
 Cannot be a Red-Black Tree              It can be Red-Black Tree
 with any color assignment
 Max height of 12 is 1
 Min height of 12 is 3



          10
        /   \
      5     100
           /   \
          50   150
         /
        40 
 It can also be Red-Black Tree

Expected time complexity is O(n). The tree should be traversed at-most once in the solution.
*/

/*
//Program to check if a given Binary Tree is balanced like a Red-Black Tree 
#include <bits/stdc++.h> 
using namespace std; 

struct Node 
{ 
	int key; 
	Node *left, *right; 
}; 

// utility that allocates a new Node with the given key 
Node* newNode(int key) 
{ 
	Node* node = new Node; 
	node->key = key; 
	node->]left = node->right = NULL; 
	return (node); 
} 

// Returns returns tree if the Binary tree is balanced like a Red-Black 
// tree. This function also sets value in maxh and minh (passed by 
// reference). maxh and minh are set as maximum and minimum heights of root. 
bool isBalancedUtil(Node *root, int &maxh, int &minh) 
{ 
	// Base case 
	if (root == NULL) 
	{ 
		maxh = minh = 0; 
		return true; 
	} 

	int lmxh, lmnh; // To store max and min heights of left subtree 
	int rmxh, rmnh; // To store max and min heights of right subtree 

	// Check if left subtree is balanced, also set lmxh and lmnh 
	if (isBalancedUtil(root->left, lmxh, lmnh) == false) 
		return false; 

	// Check if right subtree is balanced, also set rmxh and rmnh 
	if (isBalancedUtil(root->right, rmxh, rmnh) == false) 
		return false; 

	// Set the max and min heights of this node for the parent call 
	maxh = max(lmxh, rmxh) + 1; 
	minh = min(lmnh, rmnh) + 1; 

	// See if this node is balanced 
	if (maxh <= 2*minh) 
		return true; 

	return false; 
} 

// A wrapper over isBalancedUtil() 
bool isBalanced(Node *root) 
{ 
	int maxh, minh; 
	return isBalancedUtil(root, maxh, minh); 
} 


int main() 
{ 
	Node * root = newNode(10); 
	root->left = newNode(5); 
	root->right = newNode(100); 
	root->right->left = newNode(50); 
	root->right->right = newNode(150); 
	root->right->left->left = newNode(40); 
	isBalanced(root)? cout << "Balanced" : cout << "Not Balanced"; 

	return 0; 
}
*/