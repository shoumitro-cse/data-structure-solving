// Java program to convert binary tree to threaded tree 

//javac -d classes ConvertBT2ThreadedTree2.java  && cd classes && java ConvertBT2ThreadedTree2 && cd ..

import java.util.LinkedList; 
import java.util.Queue; 


class Node { 
	int data; 
	Node left, right; 

	// Used to indicate whether the right pointer is a normal 
	// right pointer or a pointer to inorder successor. 
	boolean isThreaded; 

	public Node(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

class ConvertBT2ThreadedTree2 { 
	Node root; 

	// Helper function to put the Nodes in inorder into queue 
	void populateQueue(Node node, Queue<Node> q) 
	{ 
		if (node == null) 
			return; 
		if (node.left != null) 
			populateQueue(node.left, q); 
		q.add(node); 
		if (node.right != null) 
			populateQueue(node.right, q); 
	} 

	// Function to traverse queue, and make tree threaded 
	void createThreadedUtil(Node node, Queue<Node> q) 
	{ 
		if (node == null) 
			return; 

		if (node.left != null) {
			createThreadedUtil(node.left, q); 
		}

		q.remove(); 

		if (node.right != null) {
			createThreadedUtil(node.right, q); 
		} else { 
		    // If right pointer is NULL, link it to the 
		    // inorder successor and set 'isThreaded' bit. 
			node.right = q.peek(); 
			node.isThreaded = true; 
		} 
	} 

	// This function uses populateQueue() and 
	// createThreadedUtil() to convert a given binary tree 
	// to threaded tree. 
	void createThreaded(Node node) 
	{ 
		// Create a queue to store inorder traversal 
		Queue<Node> q = new LinkedList<Node>(); 
		// Store inorder traversal in queue 
		populateQueue(node, q); 
		// Link NULL right pointers to inorder successor 
		createThreadedUtil(node, q); 
	} 

	// A utility function to find leftmost node in a binary 
	// tree rooted with 'root'. This function is used in inOrder() 
	Node leftMost(Node node) 
	{ 
		while (node != null && node.left != null) 
			node = node.left; 
		return node; 
	} 

	// Function to do inorder traversal of a threaded binary tree 
	void inOrder(Node node) 
	{ 
		if (node == null) 
			return; 
		// Find the leftmost node in Binary Tree 
		Node cur = leftMost(node); 
		while (cur != null) { 
			System.out.print(" " + cur.data + " "); 
			// If this Node is a thread Node, then go to inorder successor 
			if (cur.isThreaded == true) 
				cur = cur.right; 
			else // Else go to the leftmost child in right subtree 
				cur = leftMost(cur.right); 
		} 
	} 

	// Driver program to test for above functions 
	public static void main(String args[]) 
	{ 
		ConvertBT2ThreadedTree2 tree = new ConvertBT2ThreadedTree2(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 

		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.root.right.left = new Node(6); 
		tree.root.right.right = new Node(7); 

		tree.createThreaded(tree.root); 
		System.out.println("Inorder traversal of created threaded tree"); 
		tree.inOrder(tree.root); 
	} 
} 

