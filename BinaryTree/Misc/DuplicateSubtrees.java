// find all duplicate subtrees in a binary tree. 

//javac -d classes DuplicateSubtrees.java  && cd classes && java DuplicateSubtrees && cd ..

import java.util.HashMap; 

public class DuplicateSubtrees { 


	static HashMap<String, Integer> m; 

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

	static String inorder(Node node) 
	{ 
		if (node == null) 
			return ""; 
	
		String str = "("; 
		str += inorder(node.left); 
		str += Integer.toString(node.data); 
		str += inorder(node.right); 
		str += ")"; 

		// System.out.println(str);
	
		if (m.get(str) != null && m.get(str)==1 ) 
			System.out.print( node.data + " "); 
	
		if (m.containsKey(str)) 
			m.put(str, m.get(str) + 1); 
		else
			m.put(str, 1); 
		
		return str; 
	} 
	
	// Wrapper over inorder() 
	static void printAllDups(Node root) 
	{ 
		m = new HashMap<>(); 
		inorder(root); 
	} 
	// Driver code 
	public static void main(String args[]) 
	{ 
		Node root = null; 
		root = new Node(1); 
		root.left = new Node(2); 
		root.right = new Node(3); 
		root.left.left = new Node(4); 
		root.right.left = new Node(2); 
		root.right.left.left = new Node(4); 
		root.right.right = new Node(4); 
		
		printAllDups(root); 
		System.out.println();
	} 
} 

/*
Find All Duplicate Subtrees

Given a binary tree, find all duplicate subtrees. For each duplicate subtrees, 
we only need to return the root node of any one of them. Two trees are duplicate 
if they have the same structure with same node values.

Examples:

Input :
       1
      / \
     2   3
    /   / \
   4   2   4
      /
     4

Output : 
   2           
  /    and    4
 4
Explanation: Above Trees are two duplicate subtrees. 
Therefore, you need to return above trees root in the 
form of a list.
*/