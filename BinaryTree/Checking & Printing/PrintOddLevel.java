// Recursive Java program to print odd level nodes 

//javac -d classes PrintOddLevel.java  && cd classes && java PrintOddLevel && cd .. 
import java.util.*; 

class PrintOddLevel { 

	static class Node { 
		int data; 
		Node left, right; 
	} 

/*	// Iterative method to do level order traversal line by line  
// Time complexity : O(n)
	static void printOddNodes(Node root, boolean notUse)  {  
	    // Base Case  
	    if (root == null) return;  
	    // Create an empty queue for level order tarversal  
	    Queue<Node> q = new LinkedList<Node> ();  
	    // Enqueue root and initialize level as odd  
	    q.add(root);  
	    boolean isOdd = true;  
	    while (true)  {  
	        // nodeCount (queue size) indicatesnumber of nodes at current level.  
	        int nodeCount = q.size();  
	        if (nodeCount == 0)  
	            break;  
	        // Dequeue all nodes of current level and Enqueue all nodes of next level  
	        while (nodeCount > 0)  {  
	            Node node = q.remove();  

	            if (isOdd == true)  
	              System.out.print(node.data + " "); 

	            if (node.left != null)  
	                q.add(node.left);  
	            if (node.right != null)  
	                q.add(node.right);  
	            nodeCount--;  
	        }  
	        isOdd = !isOdd;  
	    }  
	}  */

   // Time complexity : O(n)
	static void printOddNodes(Node root, boolean isOdd) { 
		// If empty tree 
		if (root == null) 
		  return; 
		// If current node is of odd level 
		if (isOdd == true) 
		  System.out.print(root.data + " "); 
		// Recur for children with isOdd switched. 
		printOddNodes(root.left, !isOdd); 
		printOddNodes(root.right, !isOdd); 
	} 

	// Utility method to create a node 
	static Node newNode(int data) 
	{ 
		Node node = new Node(); 
		node.data = data; 
		node.left = null; 
		node.right = null; 
		return (node); 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		Node root = newNode(1); 
		root.left = newNode(2); 
		root.right = newNode(3); 
		root.left.left = newNode(4); 
		root.left.right = newNode(5);

		System.out.println(); 
		printOddNodes(root, true); 
		System.out.println(); 

	} 
} 


/*
Print the nodes at odd levels of a tree

Given a binary tree, print nodes of odd level in any order. Root is considered at level 1.

For example consider the following tree
          1
       /     \
      2       3
    /   \       \
   4     5       6
        /  \     /
       7    8   9

Output  1 4 5 6*/