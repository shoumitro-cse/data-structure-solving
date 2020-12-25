/* Java program to find maximum difference between node and its ancestor */

//javac -d classes MaxDiffBetNodeAncestor.java  && cd classes && java MaxDiffBetNodeAncestor && cd ..


class Node 
{ 
	int key; 
	Node left, right; 

	public Node(int key) 
	{ 
		this.key = key; 
		left = right = null; 
	} 
} 


class Res { 
	int r = Integer.MIN_VALUE; 
} 

public class MaxDiffBetNodeAncestor 
{ 
	Node root; 

	int maxDiffUtil(Node t, Res res) { 
		/* Returning Maximum int value if node is not there (one child case) */
		if (t == null) 
			return Integer.MAX_VALUE; 
		/* If leaf node then just return node's value */
		if (t.left == null && t.right == null) 
			return t.key; 
		/* Recursively calling left and right subtree for minimum value */
		int val = Math.min(maxDiffUtil(t.left, res), maxDiffUtil(t.right, res)); 
		/* Updating res if (node value - minimum value from subtree) is bigger than res */
		res.r = Math.max(res.r, t.key-val); 
		System.out.println(t.key+" : "+val+" : "+res.r);
		/* Returning minimum value got so far */
		return Math.min(val, t.key); 
	} 

	/* This function mainly calls maxDiffUtil() */
	int maxDiff(Node root) { 
		// Initialising result with minimum int value 
		Res res = new Res(); 
		maxDiffUtil(root, res); 
		return res.r; 
	} 

	/* Helper function to print inorder traversal of 
	binary tree */
	void inorder(Node root) 
	{ 
		if (root != null) 
		{ 
			inorder(root.left); 
			System.out.print(root.key + ""); 
			inorder(root.right); 
		} 
	} 

	// Driver program to test the above functions 
	public static void main(String[] args) 
	{ 
		MaxDiffBetNodeAncestor tree = new MaxDiffBetNodeAncestor(); 

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

		System.out.println("Maximum difference between a node and"
				+ " its ancestor is : " + tree.maxDiff(tree.root)); 
	} 
} 

/*

Maximum difference between node and its ancestor in Binary Tree

Given a binary tree, we need to find maximum value we can get by subtracting value of node 
B from value of node A, where A and B are two nodes of the binary tree and A is an ancestor of B. 
Expected time complexity is O(n).

For example, consider below binary tree

tree

We can have various ancestor-node difference, some of which are given below :
8 – 3 = 5
3 – 7 = -4
8 – 1 = 7
10 – 13 = -3
. . . .

But among all those differences maximum value is 7 obtained by subtracting 1 from 8,
 which we need to return as result.
*/