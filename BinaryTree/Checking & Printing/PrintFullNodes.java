// Java program to find the all full nodes in a given binary tree 

//javac -d classes PrintFullNodes.java  && cd classes && java PrintFullNodes && cd .. 

class Node 
{ 
	int data; 
	Node left, right; 
	Node(int data) 
	{ 
		left=right=null; 
		this.data=data; 
	} 
}; 

public class PrintFullNodes { 

   // Time Complexity : O(n)
	public static void findFullNode(Node root) { 
		if (root != null) { 
			findFullNode(root.left); 
			if (root.left != null && root.right != null) 
				System.out.print(root.data+" "); 
			findFullNode(root.right); 
		} 
	} 

	public static void main(String args[]) { 

		Node root = new Node(1); 
		root.left = new Node(2); 
		root.right = new Node(3); 
		root.left.left = new Node(4); 
		root.right.left = new Node(5); 
		root.right.right = new Node(6); 
		root.right.left.right = new Node(7); 
		root.right.right.right = new Node(8); 
		root.right.left.right.left = new Node(9); 

	    System.out.println(""); 
		findFullNode(root); 
	    System.out.println(""); 
	} 
} 



/*
Print all full nodes in a Binary Tree

Given a binary tree, print all nodes will are full nodes. 
Full Nodes are nodes which has both left and right children as non-empty.

Examples:

Input :    10
          /  \
         8    2
        / \   /
       3   5 7

Output : 10 8

Input :   1
         / \
        2   3
           / \
          4   6     

Output : 1 3

*/