// check if two trees are identical

// javac -d classes IdenticalTree.java  && cd classes && java IdenticalTree && cd ..

import java.util.*; 

class Node 
{ 
	int data; 
	Node left, right; 

	Node(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

class IdenticalTree 
{ 
	Node root1, root2; 

/*	// Iterative method to find height of Binary Tree  
// Time complexity of above solution is O(n + m) where m and n are number of nodes in two trees.
	static boolean identicalTrees(Node root1, Node root2)  {  
	    // Return true if both trees are empty  
	    if (root1 == null && root2 == null)  return true;  
	    // Return false if one is empty and other is not  
	    if (root1 == null || root2 == null) return false;  
	    // Create an empty queues for simultaneous traversals  
	    Queue<Node > q1 = new LinkedList<Node> (); 
	    Queue<Node>  q2 = new LinkedList<Node> ();  
	    // Enqueue Roots of trees in respective queues  
	    q1.add(root1);  
	    q2.add(root2);  
	  
	    while (!q1.isEmpty() && !q2.isEmpty())  {  
	        // Get front nodes and compare them  
	        Node n1 = q1.peek();  
	        Node n2 = q2.peek();  
	        if (n1.data != n2.data)  
	        return false;  
	        // Remove front nodes from queues  
	        q1.remove(); 
	        q2.remove();  
	         // Enqueue left children of both nodes 
	        if (n1.left != null && n2.left != null)  {  
	            q1.add(n1.left);  
	            q2.add(n2.left);  
	        }  else if (n1.left != null || n2.left != null)  {
	         // If one left child is empty and other is not  
	            return false;  
	        }
	 
	        // Right child code (Similar to left child code)  
	        if (n1.right != null && n2.right != null)   {  
	            q1.add(n1.right);  
	            q2.add(n2.right);  
	        }  else if (n1.right != null || n2.right != null)  {
	            return false;  
	        }
	    }  
	  
	    return true;  
	}  */


	 // Given two trees, return true if they are structurally identical 
	boolean identicalTrees(Node a, Node b) { 
		// 1. both empty 
	  if (a == null && b == null) 
			return true; 
		 // 2. both non-empty -> compare them 
	  if (a != null && b != null) 
		return (a.data == b.data && identicalTrees(a.left, b.left) && identicalTrees(a.right, b.right)); 
		 // 3. one empty, one not -> false 
		return false; 
	} 

	 // Driver program to test identicalTrees() function 
	public static void main(String[] args) { 
		IdenticalTree tree = new IdenticalTree(); 

		tree.root1 = new Node(1); 
		tree.root1.left = new Node(2); 
		tree.root1.right = new Node(3); 
		tree.root1.left.left = new Node(4); 
		tree.root1.left.right = new Node(5); 

		tree.root2 = new Node(1); 
		tree.root2.left = new Node(2); 
		tree.root2.right = new Node(3); 
		tree.root2.left.left = new Node(4); 
		tree.root2.left.right = new Node(5); 

		if (tree.identicalTrees(tree.root1, tree.root2)) 
			System.out.println("\n\nBoth trees are identical"); 
		else
			System.out.println("\n\nTrees are not identical"); 

	} 
} 

/*
check if two trees are identical

Examples:

Input : Roots of below trees
    10           10
  /   \         /
 5     6       5 
Output : false

Input : Roots of below trees
    10            10
  /   \         /   \
 5     6       5     6
Output : true



Algorithm:

sameTree(tree1, tree2)
1. If both trees are empty then return 1.
2. Else If both trees are non -empty
     (a) Check data of the root nodes (tree1->data ==  tree2->data)
     (b) Check left subtrees recursively  i.e., call sameTree( 
          tree1->left_subtree, tree2->left_subtree)
     (c) Check right subtrees recursively  i.e., call sameTree( 
          tree1->right_subtree, tree2->right_subtree)
     (d) If a,b and c are true then return 1.
3  Else return 0 (one is empty and other is not)*/