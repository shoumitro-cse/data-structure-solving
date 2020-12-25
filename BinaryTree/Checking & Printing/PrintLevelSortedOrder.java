// Print Binary Tree levels in sorted order 

// /javac -d classes PrintLevelSortedOrder.java  && cd classes && java PrintLevelSortedOrder && cd ..  

import java.util.*; 
import java.util.HashSet; 

class PrintLevelSortedOrder 
{ 
	static class Node 
	{ 
		int data; 
		Node left, right; 
	}; 
	static Node newNode(int data) 
	{ 
		Node node = new Node(); 
		node.data = data; 
		node.left = node.right = null; 
		return (node); 
	} 

	// Function to print sorted level order traversal 
	static void sorted_level_order(Node root) { 

		Queue<Node> q = new LinkedList<>(); 
		Set<Integer> s = new HashSet<Integer>(); 

		q.add(root); 
		q.add(null); 

		while (!q.isEmpty()) { 

			Node tmp = q.remove(); 

			if (tmp == null) { 
				if (s.isEmpty()) 
					break; 
				Iterator value = s.iterator(); 
				while (value.hasNext()) { 
					System.out.print(value.next() + " "); 
				} 
		        System.out.println(""); 
				q.add(null); 
				s.clear(); 
			} else { 
				s.add(tmp.data); 
				if (tmp.left != null) 
					q.add(tmp.left); 
				if (tmp.right != null) 
					q.add(tmp.right); 
			} 
		} 
	} 

	public static void main(String[] args) {

		Node root = newNode(7); 
		root.left = newNode(6); 
		root.right = newNode(5); 
		root.left.left = newNode(4); 
		root.left.right = newNode(3); 
		root.right.left = newNode(2); 
		root.right.right = newNode(1); 

		/*		    7
		          /    \
		        6       5
		       / \     / \
		      4  3    2   1*/

		System.out.println("\n\n"); 
		sorted_level_order(root); 
	} 
} 


/*
Print Binary Tree levels in sorted order | Set 2 (Using set)

Given a tree, print the level order traversal in sorted order.

Examples :

Input :     7
          /    \
        6       5
       / \     / \
      4  3    2   1
Output : 
7
5 6
1 2 3 4 

Input :     7
          /    \
        16       1
       / \      
      4   13    
Output :
7 
1 16
4 13*/
