// Java code to delete all leaves with given value. 

//javac -d classes DeleteLeft.java  && cd classes && java DeleteLeft && cd ..

class DeleteLeft { 

	// A binary tree node 
	static class Node { 
		int data; 
		Node left, right; 
	} 

	// A utility function to allocate a new node 
	static Node newNode(int data) 
	{ 
		Node newNode = new Node(); 
		newNode.data = data; 
		newNode.left = null; 
		newNode.right = null; 
		return (newNode); 
	} 

	static Node deleteLeaves(Node root, int x) 
	{ 
		if (root == null) 
			return null; 
		
		root.left = deleteLeaves(root.left, x); 
		root.right = deleteLeaves(root.right, x); 

		if (root.data == x && root.left == null && root.right == null) { 
			return null; 
		} 
		
		return root; 
	} 

	static void inorder(Node root) 
	{ 
		if (root == null) 
			return; 
		inorder(root.left); 
		System.out.print(root.data + " "); 
		inorder(root.right); 
	} 

	// Driver program 
	public static void main(String[] args) 
	{ 
		Node root = newNode(10); 
		root.left = newNode(3); 
		root.right = newNode(10); 
		root.left.left = newNode(3); 
		root.left.right = newNode(1); 
		root.right.right = newNode(3); 
		root.right.right.left = newNode(3); 
		root.right.right.right = newNode(3); 
		deleteLeaves(root, 3); 
		System.out.print("Inorder traversal after deletion : "); 
		inorder(root); 
		System.out.println(" "); 
	} 
} 


/*Source: Microsoft Interview

Delete leaf nodes with value as x

Given a binary tree and a target integer x, delete all the leaf nodes having value as x. 
Also, delete the newly formed leaves with the target value as x.

Example:

Input : x = 5  
            6
         /     \
        5       4
      /   \       \
     1     2       5 
Output : 
            6
         /     \
        5       4
      /   \  
     1     2 
Inorder Traversal is 1 5 2 6 4*/