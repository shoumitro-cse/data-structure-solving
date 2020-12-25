// Check sum of Covered and Uncovered nodes of Binary Tree

//javac -d classes CheckSumOfCoveredandUncovered.java  && cd classes && java CheckSumOfCoveredandUncovered && cd ..

class Node 
{ 
	int data; 
	Node left, right; 

	public Node(int data) 
	{ 
		this.data = data; 
		left = right = null; 
	} 
} 

class CheckSumOfCoveredandUncovered {

	Node root; 

	 // Utility function to calculate sum of all node of tree 
	int sum(Node t) { 
		if (t == null) 
			return 0; 
		return t.data + sum(t.left) + sum(t.right); 
	} 

	 // Recursive function to calculate sum of left boundary elements 
	int uncoveredSumLeft(Node t) { 
		 // If left node, then just return its data value 
		if (t.left == null && t.right == null) 
			return t.data; 
		 // If left is available then go left otherwise go right 
		if (t.left != null) 
			return t.data + uncoveredSumLeft(t.left); 
		else
			return t.data + uncoveredSumLeft(t.right); 
	} 

	 // Recursive function to calculate sum of right boundary elements 
	int uncoveredSumRight(Node t) 
	{ 
		 // If left node, then just return its data value 
		if (t.left == null && t.right == null) 
			return t.data; 
		 // If right is available then go right otherwise go left 
		if (t.right != null) 
			return t.data + uncoveredSumRight(t.right); 
		else
			return t.data + uncoveredSumRight(t.left); 
	} 

	// Returns sum of uncovered elements 
	int uncoverSum(Node t) { 
		 // Initializing with 0 in case we don't have left or right boundary 
		int lb = 0, rb = 0; 

		if (t.left != null) 
			lb = uncoveredSumLeft(t.left); 
		if (t.right != null) 
			rb = uncoveredSumRight(t.right); 
		 // returning sum of root node, left boundary and right boundary
		return t.data + lb + rb; 
	} 

	// Returns true if sum of covered and uncovered elements is same. 
	boolean isSumSame(Node root) { 
		// Sum of uncovered elements 
		int sumUC = uncoverSum(root); 
		// Sum of all elements 
		int sumT = sum(root); 
		// Check if sum of covered and uncovered is same 
		return (sumUC == (sumT-sumUC)); 
	} 

	 // Helper function to print inorder traversal of binary tree 
	void inorder(Node root) 
	{ 
		if (root != null) 
		{ 
			inorder(root.left); 
			System.out.print(root.data + " "); 
			inorder(root.right); 
		} 
	} 

	// Driver program to test above functions 
	public static void main(String[] args) { 

		CheckSumOfCoveredandUncovered tree = new CheckSumOfCoveredandUncovered(); 

		// Making above given diagram's binary tree 
		tree.root = new Node(8);

		tree.root.left = new Node(3); 
		tree.root.left.left = new Node(1); 
		tree.root.left.right = new Node(6); 
		tree.root.left.right.left = new Node(4); 
		tree.root.left.right.right = new Node(7); 

		tree.root.right = new Node(10); 
		tree.root.right.right = new Node(14); 
		tree.root.right.right.left = new Node(13); 

		/*
		        9
		      /   \
		     4     17
		    / \     \
		   3   6     22
		      / \    /
		     5   7  20*/


		if (tree.isSumSame(tree.root)) 
			System.out.println("\n\nSum of covered and uncovered is same"); 
		else
			System.out.println("\n\nSum of covered and uncovered is not same"); 
	} 
} 

/*
                9
		      /   \
		     4     17
		    / \     \
		   3   6     22
		      / \    /
		     5   7  20

In above binary tree,
Covered node:     6, 5, 7
Uncovered node:   9, 4, 3, 17, 22, 20

The output for this tree should be false as 
sum of covered and uncovered node is not same*/