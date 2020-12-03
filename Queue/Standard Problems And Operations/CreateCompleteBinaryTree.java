// Java program to create complete Binary Tree from its Linked List representation 
 // javac -d classes CreateCompleteBinaryTree.java  && cd classes && java CreateCompleteBinaryTree && cd ..

import java.util.*; 

// A linked list node 
class Node 
{ 
	int data; 
	Node next; 
	Node(int d) 
	{ 
		data = d; 
		next = null; 
	} 
} 

// A binary tree node 
class BinaryTreeNode { 
	int data; 
	BinaryTreeNode left, right = null; 
	BinaryTreeNode(int data) { 
		this.data = data; 
		left = right = null; 
	} 
} 

class BinaryTree 
{ 
	Node head; 
	BinaryTreeNode root; 

	// Function to insert a node at the beginning of 
	// the Linked List 
	void push(int new_data) { 
		// allocate node and assign data 
		Node new_node = new Node(new_data); 
		// link the old list off the new node 
		new_node.next = head; 
		// move the head to point to the new node 
		head = new_node; 
	} 

	// converts a given linked list representing a 
	// complete binary tree into the linked 
	// representation of binary tree. 

	//Time Complexity: Time complexity is O(n) where n is the number of nodes.
	BinaryTreeNode convertList2Binary(BinaryTreeNode root_node) { 
		
		// queue to store the parent nodes 
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>(); 
		
		// Base Case 
		if (head == null) { 
			  root_node = null; 
			return null; 
		} 

		// 1.) The first node is always the root node, and add it to the queue 
		root_node = new BinaryTreeNode(head.data); 
		q.add(root_node); 
		head = head.next; 

		// until the end of linked list is reached, do the following steps 
		while (head != null) { 
			// 2.a) take the parent node from the q and remove it from q 
			BinaryTreeNode parent = q.poll(); 

			BinaryTreeNode leftChild = null, rightChild = null; 

			if (head != null) { 
				leftChild = new BinaryTreeNode(head.data); 
				q.add(leftChild); 
				head = head.next; 
			} 			

			if (head != null) { 
				rightChild = new BinaryTreeNode(head.data); 
				q.add(rightChild); 
				head = head.next; 
			} 
			
			// 2.b) assign the left and right children of parent 
			parent.left = leftChild; 
			parent.right = rightChild; 
		} 
		
		return root_node; 
	} 

	// Utility function to traverse the binary tree 
	// after conversion 
	void inorderTraversal(BinaryTreeNode node) 
	{ 
		if (node != null) 
		{ 
			inorderTraversal(node.left); 
			System.out.print(node.data + " "); 
			inorderTraversal(node.right); 
		} 
	} 

} 


class CreateCompleteBinaryTree {
	// Driver program to test above functions 
	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree(); 
		tree.push(36); // Last node of Linked List 
		tree.push(30); 
		tree.push(25); 
		tree.push(15); 
		tree.push(12); 
		tree.push(10); // First node of Linked List 

		BinaryTreeNode root_node = tree.convertList2Binary(tree.root); 

		System.out.println("Inorder Traversal of the"+ " constructed Binary Tree is:"); 
	
		tree.inorderTraversal(root_node); 
		System.out.println(""); 
	} 

}


/*
Construct Complete Binary Tree from its Linked List Representation


Given Linked List Representation of Complete Binary Tree, construct the Binary tree. 
A complete binary tree can be represented in an array in the following approach.
If root node is stored at index i, its left, and right children are stored at 
indices 2*i+1, 2*i+2 respectively.

Suppose tree is represented by a linked list in same way, how do we convert this into normal 
linked representation of binary tree where every node has data, left and right pointers?
In the linked list representation, we cannot directly access the children of the current 
node unless we traverse the list.





1. Create an empty queue.
2. Make the first node of the list as root, and enqueue it to the queue.
3. Until we reach the end of the list, do the following.
………a. Dequeue one node from the queue. This is the current parent.
………b. Traverse two nodes in the list, add them as children of the current parent.
………c. Enqueue the two nodes into the queue.*/