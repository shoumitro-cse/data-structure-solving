//print levels of all nodes 

//javac -d classes PrintLevelBtree.java  && cd classes && java PrintLevelBtree && cd ..  

import java.util.LinkedList; 
import java.util.Queue; 

public class PrintLevelBtree { 
	
	static class Node { 
		int data; 
		Node left; 
		Node right; 
		Node(int data){ 
			this.data = data; 
			left = null; 
			right = null; 
		} 
	} 
	
	// User defined class Pair to hold the node and its level 
	static class Pair { 
		Node n; 
		int i; 
		Pair(Node n, int i){ 
			this.n = n; 
			this.i = i; 
		} 
	} 
	
	// function to print the nodes and its corresponding level 
	// Time Complexity: O(n) where n is the number of nodes in the given Binary Tree.
	static void printLevel(Node root) { 
		if (root == null) 
			return; 
		// queue to hold tree node with level 
		Queue<Pair> q = new LinkedList<Pair>(); 
		// let root node be at level 1 
		q.add(new Pair(root, 1)); 
		Pair p; 
		// Do level Order Traversal of tree 
		while (!q.isEmpty()) { 
			p = q.remove(); 
			System.out.println("Level of " + p.n.data + " is " + p.i); 
			if (p.n.left != null) 
				q.add(new Pair(p.n.left, p.i+1)); 
			if (p.n.right != null) 
				q.add(new Pair(p.n.right, p.i+1)); 
		} 
	} 
	

	public static void main(String args[]) { 

		Node root = null; 
	
		root = new Node(3); 
		root.left = new Node(2); 
		root.right = new Node(5); 
		root.left.left = new Node(1); 
		root.left.right = new Node(4); 

		/*	   3 <---- level 1
		      / \
		     2   5 <---- level 2
		    / \
		   1   4 <---- level 3    */
	
		printLevel(root); 
	} 
} 



/*Print Levels of all nodes in a Binary Tree

Given a Binary Tree and a key, write a function that prints levels of all keys in given binary tree.

For example, consider the following tree. If the input key is 3, then your function should
 return 1. If the input key is 4, then your function should return 3. And for key which is 
 not present in key, then your function should return 0.



Input:
	   3 <---- level 1
      / \
     2   5 <---- level 2
    / \
   1   4 <---- level 3    

output:
 Level of 1 is 3
 Level of 2 is 2
 Level of 3 is 1
 Level of 4 is 3
 Level of 5 is 2*/