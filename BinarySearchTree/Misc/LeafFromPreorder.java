// Java program to print leaf node from preorder of binary search tree. 

//javac -d classes LeafFromPreorder.java  && cd classes && java LeafFromPreorder && cd ..

import java.util.*; 

class LeafFromPreorder 
{ 

	// Binary Search 
	static int binarySearch(int inorder[], int l, int r, int d) { 

		int mid = (l+r) >> 1; 

		if (inorder[mid] == d) 
			return mid; 
		else if (inorder[mid] > d) 
			return binarySearch(inorder, l, mid-1, d); 
		else
			return binarySearch(inorder, mid+1, r, d); 
	} 

	// Point to the index in preorder. 
	static int ind; 

	// Function to print Leaf Nodes by 
	// doing preorder traversal of tree 
	// using preorder and inorder arrays. 
	static void leafNodesRec(int preorder[], int inorder[], int l, int r, int n) { 
		// If l == r, therefore no right or left subtree. 
		// So, it must be leaf Node, print it. 
		if(l == r) { 
			System.out.printf("%d ", inorder[l]); 
			ind = ind + 1; 
			return; 
		} 
		// If array is out of bound, return. 
		if (l < 0 || l > r || r >= n) 
			return; 
		// Finding the index of preorder element 
		// in inorder array using binary search. 
		int loc = binarySearch(inorder, l, r, preorder[ind]); 
		// Incrementing the index. 
		ind = ind+1; 
		// Finding on the left subtree. 
		leafNodesRec(preorder, inorder, l, loc-1, n);
		// Finding on the right subtree. 
		leafNodesRec(preorder, inorder, loc+1, r, n); 
	} 

	// Finds leaf nodes from given preorder traversal. 
	static void leafNodes(int preorder[], int n) { 
		// To store inorder traversal 
		int inorder[] = new int[n]; 
		// Copy the preorder into another array. 
		for (int i = 0; i < n; i++) 
			inorder[i] = preorder[i]; 
		// Finding the inorder by sorting the array. 
		Arrays.sort(inorder); 
		// Print the Leaf Nodes. 
		leafNodesRec(preorder, inorder, 0, n-1, n); 
	} 

	// Driver Code 
	public static void main(String args[]) { 
		int preorder[] = { 890, 325, 290, 530, 965 }; 
		int n = preorder.length; 
		leafNodes(preorder, n); 
		System.out.println();
	} 
} 


/*Leaf nodes from Preorder of a Binary Search Tree

Given a Preorder traversal of a Binary Search Tree. The task is to print leaf nodes of the Binary Search Tree from the given preorder.

Examples:

Input : preorder[] = {890, 325, 290, 530, 965};
Output : 290 530 965
Explanation : Tree represented is,
      890
     /   \
  325    965
  /  \
290   530

Input : preorder[] = { 3, 2, 4 };
Output : 2 4
*/
