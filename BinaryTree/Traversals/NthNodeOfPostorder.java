// Java program to find n-th node of Postorder Traversal of Binary Tree 

// javac -d classes NthNodeOfPostorder.java  && cd classes && java NthNodeOfPostorder && cd ..

class Node 
{ 
	int data; 
	Node left, right; 
	Node(int data) 
	{ 
		this.data=data; 
	} 
};


public class NthNodeOfPostorder { 

	static int count = 0; 

	// function to find the N-th node in the postorder traversal of a given binary tree 
	public static void getNode(Node root, int N) { 
		if (root == null) 
			return; 
		if (count <= N) { 
			// left recursion 
			getNode(root.left, N); 
			// right recursion 
			getNode(root.right, N); 
			count++; 
			// prints the n-th node of preorder traversal 
			if (count == N) { 
				System.out.println(root.data);
			} 
		} 
	} 


	public static void main(String args[]) { 

		Node root = new Node(25); 
		root.left = new Node(20); 
		root.right = new Node(30); 
		root.left.left = new Node(18); 
		root.left.right = new Node(22); 
		root.right.left = new Node(24); 
		root.right.right = new Node(32); 


/*	             25
	           /    \
	          20    30
	        /    \ /   \
	      18    22 24   32*/
	
		int N = 6; 
	
		// prints n-th node found 
		getNode(root, N); 
	} 
} 

