// Floor and Ceil from a BST

//javac -d classes FloorCeilBST.java  && cd classes && java FloorCeilBST && cd ..

class Node { 

	int data; 
	Node left, right; 

	Node(int d) 
	{ 
		data = d; 
		left = right = null; 
	} 
} 

class FloorCeilBST { 

	Node root; 

	int floor;
	int ceil;
	 
	// Helper function to find floor and ceil of a given key in BST 
	public void floorCeilBSTHelper(Node root, int key) {

	    while (root != null) {

	        if (root.data == key) {
	            ceil = root.data;
	            floor = root.data;
	            return;
	        }
	 
	        if (key > root.data) {
	            floor = root.data;
	            root = root.right;
	        } else {
	            ceil = root.data;
	            root = root.left;
	        }
	    }
	    return;
	}
	 
	public void floorCeilBST(Node root, int key) {
	    // Variables 'floor' and 'ceil' are passed by reference 
	    floor = -1;
	    ceil = -1;
	    floorCeilBSTHelper(root, key);
	    System.out.println(key + " " + floor + " " + ceil);
	}



/*	// Function to find ceil of a given input in BST. 
	// If input is more than the max key in BST, 
	// return -1 
	int Ceil(Node node, int input) { 
		// Base case 
		if (node == null) { 
			return -1; 
		} 
		// We found equal key 
		if (node.data == input) { 
			return node.data; 
		} 
		// If root's key is smaller, ceil must be in right subtree 
		if (node.data < input) { 
			return Ceil(node.right, input); 
		} 
		// Else, either left subtree or root has the ceil value 
		int ceil = Ceil(node.left, input); 

		return (ceil >= input) ? ceil : node.data; 
	} */

	// Driver Code 
	public static void main(String[] args) 
	{ 
		FloorCeilBST tree = new FloorCeilBST(); 
		tree.root = new Node(8); 
		tree.root.left = new Node(4); 
		tree.root.right = new Node(12); 
		tree.root.left.left = new Node(2); 
		tree.root.left.right = new Node(6); 
		tree.root.right.left = new Node(10); 
		tree.root.right.right = new Node(14); 

		for (int i = 0; i < 16; i++) { 
			// System.out.println(i + " " + tree.Ceil(tree.root, i)); 
			tree.floorCeilBST(tree.root, i); 
		} 
	} 
} 


/*
Floor and Ceil from a BST

Given a binary tree and a key(node) value, find the floor and ceil value for that particular key value.

Floor Value Node: Node with greatest data lesser than or equal to key value. 
Ceil Value Node: Node with smallest data larger than or equal to key value.

For example, Let’s consider the Binary Tree below – 

          8
        /   \    
      4      12
    /  \    /  \
   2    6  10   14

Key: 11  Floor: 10  Ceil: 12
Key: 1   Floor: -1  Ceil: 2
Key: 6   Floor: 6   Ceil: 6
Key: 15  Floor: 14  Ceil: -1
*/
