// Print leftmost and rightmost nodes of a Binary Tree

//javac -d classes PrintLeftmostRightmostNodes.java  && cd classes && java PrintLeftmostRightmostNodes && cd ..  

import java.util.*; 

/* A binary tree node has key, pointer to left 
child and a pointer to right child */
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

class PrintLeftmostRightmostNodes 
{ 
	Node root; 

	//Time Complexity : O(n) where n is number of nodes in Binary Tree.
	void printCorner(Node root) 
	{ 
		// star node is for keeping track of levels 
		Queue<Node> q = new LinkedList<Node>(); 

		// pushing root node and star node 
		q.add(root); 
		// Do level order traversal of Binary Tree 
		while (!q.isEmpty()) { 
			// n is the no of nodes in current Level 
			int n = q.size(); 
			for(int i = 0 ; i < n ; i++) { 
				// dequeue the front node from the queue 
				Node temp = q.poll(); 
				//If it is leftmost corner value or rightmost corner value then print it 
				if(i==0 || i==n-1) 
					System.out.print(temp.key + " "); 
				//push the left and right children of the temp node 
				if (temp.left != null) 
					q.add(temp.left); 
				if (temp.right != null) 
					q.add(temp.right); 
			} 
		} 

	} 

	public static void main(String[] args) {

		PrintLeftmostRightmostNodes tree = new PrintLeftmostRightmostNodes(); 
	
		tree.root = new Node(15); 
		tree.root.left = new Node(10); 
		tree.root.right = new Node(20); 
		tree.root.left.left = new Node(8); 
		tree.root.left.right = new Node(12); 
		tree.root.right.left = new Node(16); 
		tree.root.right.right = new Node(25); 

		/*		 15
				/  \
		       10   20
		      / \   / \
		     8  12 16  25*/


		System.out.println("\n"); 
		tree.printCorner(tree.root); 
		System.out.println(); 
	} 
} 

/*Print leftmost and rightmost nodes of a Binary Tree

Given a Binary Tree, Print the corner nodes at each level. 
The node at the leftmost and the node at the rightmost.
				 15
				/  \
		       10   20
		      / \   / \
		     8  12 16  25
For example, output for following is 15, 10, 20, 8, 25.*/