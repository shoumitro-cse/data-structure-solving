// Density of Binary Tree in One Traversal

//javac -d classes DensityOfBinaryTree.java  && cd classes && java DensityOfBinaryTree && cd ..

class Node { 
	int data; 
	Node left, right; 
	public Node(int data) { 
		this.data = data; 
		left = right = null; 
	} 
} 

// Class to implement pass by reference of size 
class Size { 
	// variable to calculate size of tree 
	int size = 0; 
} 

class DensityOfBinaryTree { 
	Node root; 
	// Function to compute height and size of a binary tree 
	int heighAndSize(Node node, Size s) { 
		if (node == null) 
			return 0; 
		// compute height of each subtree 
		int left = heighAndSize(node.left, s); 
		int right = heighAndSize(node.right, s); 
		//increase size by 1 
		s.size++; 
		//return larger of the two 
		return (left > right) ? left + 1 : right + 1; 
	} 

	//function to calculate density of a binary tree 
	float density(Node root) { 
		Size s = new Size(); 
		if (root == null) 
			return 0; 
		// Finds height and size 
		int _height = heighAndSize(root, s); 
		return (float) s.size / _height; 
	} 

	// Driver code to test above methods 
	public static void main(String[] args) { 
		DensityOfBinaryTree tree = new DensityOfBinaryTree(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 

		System.out.println("\n\nDensity of given Binary Tree is : "+ tree.density(tree.root)); 
	} 

} 



/*Density of Binary Tree in One Traversal

Given a Binary Tree, find density of it by doing one traversal of it.

Density of Binary Tree = Size / Height 
Examples:

Input: Root of following tree
   10
  /   \
 20   30

Output: 1.5
Height of given tree = 2
Size of given tree = 3

Input: Root of following tree
     10
    /   
   20   
 /
30
Output: 1
Height of given tree = 3
Size of given tree = 3 */