// construct a tree from level order and inorder traversal 

// javac -d classes ConstructTreeLevelInorder.java  && cd classes && java ConstructTreeLevelInorder && cd ..

class Node { 
	int data; 
	Node left, right; 
	Node(int item) { 
		data = item; 
		left = right = null; 
	} 
	public void setLeft(Node left) { 
		this.left = left; 
	} 
	public void setRight(Node right) { 
		this.right = right; 
	} 
} 

class ConstructTreeLevelInorder 
{ 
	Node root; 

	Node buildTree(int in[], int level[]) { 
		Node startnode = null; 
		return constructTree(startnode, level, in, 0, in.length - 1); 
	} 


	// An upper bound on time complexity of method is O(n3). 
	// In the main recursive function, extractNodes() is called which takes O(n2) time.
	Node constructTree(Node startNode, int[] levelOrder, int[] inOrder, int inStart, int inEnd) { 
		// if start index is more than end index 
		if (inStart > inEnd) 
			return null; 

		if (inStart == inEnd) 
			return new Node(inOrder[inStart]); 
			
		boolean found = false; 
		int index = 0; 

		for (int i = 0; i < levelOrder.length-1; i++) { 

			int data = levelOrder[i]; 

			for (int j = inStart; j < inEnd; j++) { 
				if (data == inOrder[j]) { 
					startNode = new Node(data); 
					index = j; 
					found = true; 
					break; 
				} 
			} 

			if (found == true) { 
				break; 
			}
		} 

		startNode.setLeft(constructTree(startNode, levelOrder, inOrder, inStart, index-1)); 
		startNode.setRight(constructTree(startNode, levelOrder, inOrder, index + 1, inEnd)); 

		return startNode; 
	} 

	 // Utility function to print inorder traversal of binary tree 
	void printInorder(Node node) { 
		if (node == null) 
			return; 
		printInorder(node.left); 
		System.out.print(node.data + " "); 
		printInorder(node.right); 
	} 

	// Driver program to test the above functions 
	public static void main(String args[]) {

		ConstructTreeLevelInorder tree = new ConstructTreeLevelInorder(); 
	
		int in[] = new int[]{4, 8, 12, 20, 22}; 
		int level[] = new int[]{20, 8, 22, 4, 12}; 
		int n = in.length; 
		Node node = tree.buildTree(in, level); 

/*		 20
		/ \
       8   22
      / \
     4   12*/

		/* Let us test the built tree by printing Inorder traversal */
		System.out.println("\n\nInorder traversal of the constructed tree is "); 
		tree.printInorder(node); 
		System.out.println(""); 
	} 
} 


/*An upper bound on time complexity of above method is O(n3). 
In the main recursive function, extractNodes() is called which takes O(n2) time.*/



/*
Construct a tree from Inorder and Level order traversals | Set 1

Given inorder and level-order traversals of a Binary Tree, construct the Binary Tree. Following is an example to illustrate the problem.
BinaryTree

Input: Two arrays that represent Inorder
       and level order traversals of a 
       Binary Tree
in[] = {4, 8, 12, 20, 22};
level[] = {20, 8, 22, 4, 12};

Output: Construct the tree represented 
        by the two arrays.
        For the above two arrays, the 
        constructed tree is shown in 
        the diagram on right side*/



/*++++++++++++++++++++++++++++++++++++++=

Time Complexity: O(N^2)

  // program to construct tree using inorder and levelorder traversals 
#include <iostream> 
#include<set> 
using namespace std; 

struct Node 
{ 
	int key; 
	struct Node* left, *right; 
}; 

Node* makeNode(int data){ 
	Node* newNode = new Node(); 
	newNode->key = data; 
	newNode->right = newNode->right = NULL; 
	return newNode; 
} 

// Function to build tree from given  levelorder and inorder 
// Time Complexity: O(N^2)
Node* buildTree(int inorder[], int levelOrder[], int iStart, int iEnd, int n) {
 
	if (n <= 0) 
		return NULL; 

	// First node of level order is root 
	Node* root = makeNode(levelOrder[0]); 

	// Search root in inorder 
	int index = -1; 
	for (int i=iStart; i<=iEnd; i++){ 
		if (levelOrder[0] == inorder[i]){ 
			index = i; 
			break; 
		} 
	} 

	// Insert all left nodes in hash table 
	unordered_set<int> s;

	for (int i=iStart; i<index; i++) {
		s.insert(inorder[i]); 
	}
	
	// Separate level order traversals 
	// of left and right subtrees. 
	int lLevel[s.size()]; // Left 
	
	int rLevel[iEnd - iStart - s.size()]; // Right 
	
	int li = 0, ri = 0; 

	for (int i=1; i<n; i++) { 
		if (s.find(levelOrder[i]) != s.end()) 
			lLevel[li++] = levelOrder[i]; 
		else
			rLevel[ri++] = levelOrder[i];		 
	} 

	// Recursively build left and right subtrees and return root. 
	root->left = buildTree(inorder, lLevel, iStart, index-1, index-iStart); 
	root->right = buildTree(inorder, rLevel, index+1, iEnd, iEnd-index); 

	return root; 

} 


void printInorder(Node* node) 
{ 
	if (node == NULL) 
	return; 
	printInorder(node->left); 
	cout << node->key << " "; 
	printInorder(node->right); 
} 

// Driver Code 
int main() 
{ 
	int in[] = {4, 8, 10, 12, 14, 20, 22}; 
	int level[] = {20, 8, 22, 4, 12, 10, 14}; 
	int n = sizeof(in)/sizeof(in[0]); 
	Node *root = buildTree(in, level, 0, 
						n - 1, n); 


	cout << "Inorder traversal of the "
			"constructed tree is \n"; 
	printInorder(root); 

	return 0; 
} 
*/