// Java program to find deepest left leaf node of binary tree 
import java.util.*; 

class DeepestLeft 
{ 

	// tree node 
	static class Node 
	{ 
		int data; 
		Node left, right; 
	}; 

	// returns a new tree Node 
	static Node newNode(int data) 
	{ 
		Node temp = new Node(); 
		temp.data = data; 
		temp.left = temp.right = null; 
		return temp; 
	} 

	// return the deepest left leaf node 
	// of binary tree 
	static Node getDeepestLeftLeafNode(Node root) 
	{ 
		if (root == null) 
			return null; 

		// create a queue for level order traversal 
		Queue<Node> q = new LinkedList<>(); 
		q.add(root); 

		Node result = null; 

		// traverse until the queue is empty 
		while (!q.isEmpty()) 
		{ 
			Node temp = q.peek(); 
			q.remove(); 

			// Since we go level by level, the last 
			// stored left leaf node is deepest one, 
			if (temp.left != null) { 
				q.add(temp.left); 
				if (temp.left.left == null && temp.left.right == null) 
					result = temp.left; 
			} 
			
			if (temp.right != null) 
				q.add(temp.right); 
		} 
		return result; 
	} 

	// Driver Code 
	public static void main(String[] args) 
	{ 
		
		// construct a tree 
		Node root = newNode(1); 
		root.left = newNode(2); 
		root.right = newNode(3); 
		root.left.left = newNode(4); 
		root.right.left = newNode(5); 
		root.right.right = newNode(6); 
		root.right.left.right = newNode(7); 
		root.right.right.right = newNode(8); 
		root.right.left.right.left = newNode(9); 
		root.right.right.right.right = newNode(10); 

		Node result = getDeepestLeftLeafNode(root); 
		if (result != null) 
			System.out.println("Deepest Left Leaf Node :: " + 
												result.data); 
		else
			System.out.println("No result, " + 
					"left leaf not found"); 
	} 
} 

/*
Deepest left leaf node in a binary tree | iterative approach

Given a Binary Tree, find the deepest leaf node that is left child of its parent. 
For example, consider the following tree. The deepest left leaf node is the node with value 9.

Examples:

Input : 
       1
     /   \
    2     3
  /      /  \  
 4      5    6
        \     \
         7     8
        /       \
       9         10


Output : 9*/



/*
// A Java program to find 
// the deepest left leaf 
// in a binary tree 

// A Binary Tree node 
class Node 
{ 
	int data; 
	Node left, right; 

	// Constructor 
	public Node(int data) 
	{ 
		this.data = data; 
		left = right = null; 
	} 
} 

// Class to evaluate pass 
// by reference 
class Level 
{ 
	int maxlevel = 0; 
} 

class DeepestLeft 
{ 
	Node root; 
	
	Node result; 

	void deepestLeftLeafUtil(Node node, int lvl, Level level, boolean isLeft) { 
		// Base case 
		if (node == null) 
			return; 

		if (isLeft != false && node.left == null && node.right == null && lvl > level.maxlevel) { 
			result = node; 
			level.maxlevel = lvl; 
		} 
		// Recur for left and right subtrees 
		deepestLeftLeafUtil(node.left, lvl + 1, level, true); 
		deepestLeftLeafUtil(node.right, lvl + 1, level, false); 
	} 

	// A wrapper over deepestLeftLeafUtil(). 
	void deepestLeftLeaf(Node node) 
	{ 
		Level level = new Level(); 
		deepestLeftLeafUtil(node, 0, level, false); 
	} 
	
	// Driver program to test above functions 
	public static void main(String[] args) 
	{ 
		BinaryTree tree = new BinaryTree(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.right.left = new Node(5); 
		tree.root.right.right = new Node(6); 
		tree.root.right.left.right = new Node(7); 
		tree.root.right.right.right = new Node(8); 
		tree.root.right.left.right.left = new Node(9); 
		tree.root.right.right.right.right = new Node(10); 

		tree.deepestLeftLeaf(tree.root); 
		if (tree.result != null) 
			System.out.println("The deepest left child"+ 
							" is " + tree.result.data); 
		else
			System.out.println("There is no left leaf in"+ 
							" the given tree"); 
	} 
} 

*/