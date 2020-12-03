// Java program to find averages of all levels in a binary tree. 

//javac -d classes AveragesOfAllLevelsBT.java  && cd classes && java AveragesOfAllLevelsBT && cd ..

import java.util.*; 

class AveragesOfAllLevelsBT { 

	 // A binary tree node has data, pointer to left child and a pointer to right child 
	static class Node { 
		int val; 
		Node left, right; 
	} 

	static Node newNode(int data) 
	{ 
		Node temp = new Node(); 
		temp.val = data; 
		temp.left = null; 
		temp.right = null; 
		return temp; 
	} 

	 // Function to print the average value of the nodes on each level 
	static void averageOfLevels(Node root) { 
		Queue<Node> q = new LinkedList<Node> (); 
		q.add(root); 
		while (!q.isEmpty()) { 

		   int sum = 0, count = 0; 
			Queue<Node> temp = new LinkedList<Node> (); 

			while (!q.isEmpty()) { 
				Node n = q.remove(); 
				sum += n.val; 
				count++; 
				if (n.left != null) {
					temp.add(n.left); 
				}
				if (n.right != null) {
					temp.add(n.right); 
				}
			} 

			q = temp; 
			System.out.print((sum * 1.0 / count) + " "); 
		} 
	} 


	public static void main(String[] args) { 

		Node root = null; 

		root = newNode(4); 

		root.left = newNode(2); 
		root.right = newNode(9); 

		root.left.left = newNode(3); 
		root.left.right = newNode(5); 

		root.right.right = newNode(7); 

/*		Input : 
		    4
		   / \
		  2   9
		 / \   \
		3   5   7*/


		System.out.println("Averages of levels : "); 
		System.out.print("["); 
		averageOfLevels(root); 
		System.out.println("]"); 
	} 
} 


/*
Averages of Levels in Binary Tree

Given a non-empty binary tree, print the average value of the nodes on each level.

Examples:

Input : 
    4
   / \
  2   9
 / \   \
3   5   7

Output : [4 5.5 5]

The average value of nodes on 
level 0 is 4, 
level 1 is 5.5 
level 2 is 5
Hence, print [4 5.5 5].


Complexity Analysis:

Time complexity : O(n).
	The whole tree is traversed atmost once. Here, n refers to the number of
	 nodes in the given binary tree.
Auxiliary Space : O(n).
	The size of queues can grow upto atmost the maximum number of nodes at any level in
	the given binary tree. Here, n refers to the maximum number of nodes at any level in
	the input tree.



*/
