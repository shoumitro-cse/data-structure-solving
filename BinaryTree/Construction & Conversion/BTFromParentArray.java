// Java program to construct a binary tree from parent array 

// javac -d classes BTFromParentArray.java  && cd classes && java BTFromParentArray && cd ..

class Node { 
	int key; 
	Node left, right; 

	public Node(int key) { 
		this.key = key; 
		left = right = null; 
	} 
} 

class BTFromParentArray {

	Node root; 

	void createNode(int parent[], int i, Node created[]) { 
		// If this node is already created 
		if (created[i] != null) 
			return; 
		// Create a new node and set created[i] 
		created[i] = new Node(i); 
		// If 'i' is root, change root pointer and return 
		if (parent[i] == -1) { 
			root = created[i]; 
			return; 
		} 
		// If parent is not created, then create parent first 
		if (created[parent[i]] == null) { 
			createNode(parent, parent[i], created);
		} 
		// Find parent pointer 
		Node p = created[parent[i]]; 
		// If this is first child of parent 
		if (p.left == null) 
			p.left = created[i]; 
		else // If second child 
			p.right = created[i]; 
	} 

	/* Creates tree from parent[0..n-1] and returns root of the created tree */
	Node createTree(int parent[], int n) {	

		Node[] created = new Node[n]; 
	
		for (int i = 0; i < n; i++) { 
			created[i] = null; 
		}
	
		for (int i = 0; i < n; i++) { 
			createNode(parent, i, created);
		} 
	
		return root; 
	} 

	//For adding new line in a program 
	void newLine() { 
		System.out.println(""); 
	} 

	// Utility function to do inorder traversal 
	void inorder(Node node) { 
		if (node != null) { 
			inorder(node.left); 
			System.out.print(node.key + " "); 
			inorder(node.right); 
		} 
	} 

	// Driver method 
	public static void main(String[] args) { 

		BTFromParentArray tree = new BTFromParentArray(); 
		
		int parent[] = new int[]{-1, 0, 0, 1, 1, 3, 5}; 
		int n = parent.length; 
		
		Node node = tree.createTree(parent, n); 
		
		System.out.println("\n\nInorder traversal of constructed tree "); 
		tree.inorder(node); 
		tree.newLine(); 

		/*		 0
		       /   \
		      1     2
		     / \
		    3   4
		   /
		  5 
		 /
		6*/


	} 
} 


/*
Construct Binary Tree from given Parent Array representation

Given an array that represents a tree in such a way that array indexes are values in tree nodes 
and array values give the parent node of that particular index (or node). The value of the root 
node index would always be -1 as there is no parent for root. Construct the standard linked 
representation of given Binary Tree from this given representation.

Examples:

Input: parent[] = {1, 5, 5, 2, 2, -1, 3}
Output: root of below tree
          5
        /  \
       1    2
      /    / \
     0    3   4
         /
        6 

Explanation: 

Index of -1 is 5.  So 5 is root.  
5 is present at indexes 1 and 2.  So 1 and 2 are
children of 5.  
1 is present at index 0, so 0 is child of 1.
2 is present at indexes 3 and 4.  So 3 and 4 are
children of 2.  
3 is present at index 6, so 6 is child of 3.


Input: parent[] = {-1, 0, 0, 1, 1, 3, 5};

Output: root of below tree
         0
       /   \
      1     2
     / \
    3   4
   /
  5 
 /
6
Expected time complexity is O(n) where n is number of elements in given array.*/