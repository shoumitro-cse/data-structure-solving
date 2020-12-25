// Java program to convert binary tree into its mirror 

//javac -d classes BinaryTreeIntoItsMirrorIntoItsMirror.java  && cd classes && java BinaryTreeIntoItsMirrorIntoItsMirror && cd ..

import java.util.*; 

class Node 
{ 
	int data; 
	Node left, right; 

	public Node(int item) { 
		data = item; 
		left = right = null; 
	} 
} 

class BinaryTreeIntoItsMirror {

	Node root; 

/*	static void mirror(Node root) { 
	    if (root == null) 
	        return; 
	    Queue<Node> q = new LinkedList<>(); 
	    q.add(root); 
	    // Do BFS. While doing BFS, keep swapping 
	    // left and right children 
	    while (q.size() > 0) 
	    { 
	        // pop top node from queue 
	        Node curr = q.remove(); 
	        // swap left child with right child 
	        Node temp = curr.left; 
	        curr.left = curr.right; 
	        curr.right = temp;; 
	        // push left and right children 
	        if (curr.left != null) 
	            q.add(curr.left); 
	        if (curr.right != null) 
	            q.add(curr.right); 
	    } 
	} 
*/

	void mirror() { 
		 mirror(root); 
	} 

	Node mirror(Node node) { 
		if (node == null) 
			return node; 
		 // do the subtrees 
		Node left = mirror(node.left); 
		Node right = mirror(node.right); 
		 // swap the left and right pointers 
		node.left = right; 
		node.right = left; 
	  return node; 
	} 

	void inOrder() { 
		inOrder(root); 
	} 

	void inOrder(Node node) { 
		if (node == null) 
			return; 
		inOrder(node.left); 
		System.out.print(node.data + " "); 
		inOrder(node.right); 
	} 

	 // testing for example nodes 
	public static void main(String args[]) {
		 // creating a binary tree and entering the nodes 
		BinaryTreeIntoItsMirror tree = new BinaryTreeIntoItsMirror(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 

		 // print inorder traversal of the input tree 
		System.out.println("\n\nInorder traversal of input tree is :"); 
		tree.inOrder(); 
		System.out.println(""); 

		 // convert tree to its mirror 
		tree.mirror(); 

		 // print inorder traversal of the minor tree 
		System.out.println("Inorder traversal of binary tree is : "); 
		tree.inOrder(); 
		System.out.println(); 

	} 
} 
