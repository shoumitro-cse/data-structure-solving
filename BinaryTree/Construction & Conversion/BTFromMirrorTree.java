// Construct Full Binary Tree using its Preorder traversal and Preorder traversal of its mirror tree

//javac -d classes BTFromMirrorTree.java  && cd classes && java BTFromMirrorTree && cd ..

class BTFromMirrorTree { 

	// A Binary Tree Node 
	static class Node { 
		int data; 
		Node left, right; 
	}; 
	static class INT { 
		int a; 
		INT(int a){this.a=a;} 
	} 

	// Utility function to create a new tree node 
	static Node newNode(int data) { 
		Node temp = new Node(); 
		temp.data = data; 
		temp.left = temp.right = null; 
		return temp; 
	} 

	// A utility function to print inorder traversal 
	// of a Binary Tree 
	static void printInorder(Node node) { 
		if (node == null) 
			return; 

		printInorder(node.left); 
		System.out.printf("%d ", node.data); 
		printInorder(node.right); 
	} 

	// A recursive function to con Full binary tree 
	// from pre[] and preM[]. preIndex is used to keep 
	// track of index in pre[]. l is low index and h is high 
	//index for the current subarray in preM[] 
	static Node conBinaryTreeUtil(int pre[], int preM[], INT preIndex, int l, int h, int size) { 
		// Base case 
		if (preIndex.a >= size || l > h) 
			return null; 
		// The first node in preorder traversal is root. 
		// So take the node at preIndex from preorder and 
		// make it root, and increment preIndex 
		Node root = newNode(pre[preIndex.a]); 
			++(preIndex.a); 
		// If the current subarry has only one element, 
		// no need to recur 
		if (l == h) 
			return root; 
		// Search the next element of pre[] in preM[] 
		int i; 
		for (i = l; i <= h; ++i) {
			if (pre[preIndex.a] == preM[i]) { 
				break; 
			}
		}
		// con left and right subtrees recursively 
		if (i <= h) { 
			root.left = conBinaryTreeUtil (pre, preM, preIndex, i, h, size); 
			root.right = conBinaryTreeUtil (pre, preM, preIndex, l+1, i-1 , size); // diff from postorder
		} 
		// return root 
		return root;	 
	} 

	// function to con full binary tree 
	// using its preorder traversal and preorder 
	// traversal of its mirror tree 
	static void conBinaryTree(Node root, int pre[], int preMirror[], int size) { 
		INT preIndex = new INT(0); 
		int preMIndex = 0; 
		root = conBinaryTreeUtil(pre, preMirror, preIndex, 0, size-1, size); 
		printInorder(root); 
	} 

	// Driver code 
	public static void main(String args[]) { 

		int preOrder[] = {1,2,4,5,3,6,7}; 
		int preOrderMirror[] = {1,3,7,6,2,5,4}; 

		int size = preOrder.length; 

		Node root = new Node(); 

		conBinaryTree(root, preOrder, preOrderMirror, size); 
	} 
} 


/*
Construct Full Binary Tree using its Preorder traversal and Preorder traversal of its mirror tree

Given two arrays that represent Preorder traversals of a full binary tree and its mirror tree, 
we need to write a program to construct the binary tree using these two Preorder traversals.

A Full Binary Tree is a binary tree where every node has either 0 or 2 children.

Note: It is not possible to construct a general binary tree using these two traversal. 
But we can create a full binary tree using the above traversals without any ambiguity. 
For more details refer to this article.


Examples:

Input :  preOrder[] = {1,2,4,5,3,6,7}
         preOrderMirror[] = {1,3,7,6,2,5,4}

Output :          1
               /    \
              2      3
            /   \   /  \
           4     5 6    7*/