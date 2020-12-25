// Diameter of a Binary Tree in O(n) [A new method]

//javac -d classes diameterBT.java  && cd classes && java diameterBT && cd ..


class diameterBT { 

	 // Tree node structure used in the program 
	static class Node { 
		int data; 
		Node left, right; 
	} 

	static class A { 
		int ans = Integer.MIN_VALUE; 
	} 

	 // Function to find height of a tree 
	static int height(Node root, A a) { 
		if (root == null) 
			return 0; 
		int left_height = height(root.left, a); 
		int right_height = height(root.right, a); 
		// update the answer, because diameter of a 
		// tree is nothing but maximum value of 
		// (left_height + right_height + 1) for each node 
		a.ans = Math.max(a.ans, 1 + left_height + right_height); 

	  return 1 + Math.max(left_height, right_height); 
	} 


	static int diameter(Node root) { 
		if (root == null) 
			return 0; 
		// This will store the final answer 
		A a = new A(); 
		int height_of_tree = height(root, a); 
		return a.ans; 
	} 

	static Node newNode(int data) { 
		Node node = new Node(); 
		node.data = data; 
		node.left = null; 
		node.right = null; 
		return (node); 
	} 


	public static void main(String[] args) {

		Node root = newNode(1); 
		root.left = newNode(2); 
		root.right = newNode(3); 
		root.left.left = newNode(4); 
		root.left.right = newNode(5); 

		/*          1
		          /   \
		        2      3
		      /  \
		    4     5*/


		System.out.println("Diameter is " + diameter(root)); 
	} 
} 


/*
Diameter of a Binary Tree in O(n) [A new method]

The diameter of a tree is the number of nodes on the longest path between two leaves in the tree. 
The diagram below shows two trees each with diameter nine, the leaves that form the ends of the 
longest path are colored (note that there may be more than one path in the tree of the same diameter).



Examples:

Input :     1
          /   \
        2      3
      /  \
    4     5

Output : 4

Input :     1
          /   \
        2      3
      /  \ .    \
    4     5 .    6

Output : 5
*/




/*class Node {
	int data;
	Node left, right;
	public Node(int item) {
		data = item;
		left = right = null;
	}
}

// Class to print the Diameter
class diameterBT {
	Node root;

	// Method to calculate the diameter and return it to main
	int diameter(Node root) {
		// base case if tree is empty
		if (root == null)
			return 0;
		// get the height of left and right sub-trees
		int lheight = height(root.left);
		int rheight = height(root.right);
		// get the diameter of left and right sub-trees
		int ldiameter = diameter(root.left);
		int rdiameter = diameter(root.right);
		 // Return max of following three
			// 1) Diameter of left subtree
			// 2) Diameter of right subtree
			// 3) Height of left subtree + height of right subtree + 1
		
		return Math.max(lheight+rheight+1, Math.max(ldiameter, rdiameter));
	}

	// A wrapper over diameter(Node root)
	int diameter() { 
		return diameter(root); 
	}

	static int height(Node node){
		// base case tree is empty
		if (node == null)
			return 0;
		return (1 + Math.max(height(node.left), height(node.right)));
	}

	// Driver Code
	public static void main(String args[])
	{
		// creating a binary tree and entering the nodes
		diameterBT tree = new diameterBT();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		// Function Call
		System.out.println(
			"The diameter of given binary tree is : "
			+ tree.diameter());
	}
}
*/