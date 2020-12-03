// An iterative java program to find height of binary tree 

// javac -d classes HeightBinaryTree.java  && cd classes && java HeightBinaryTree && cd ..

import java.util.LinkedList; 
import java.util.Queue; 

// A binary tree node 
class Node 
{ 
	int data; 
	Node left, right; 

	Node(int item) 
	{ 
		data = item; 
		left = right; 
	} 
} 

class HeightBinaryTree 
{ 
	Node root; 



    int height(Node node) { 
		if (node == null) { 
			return 0; 
		} else { 
			 // compute the height of each subtree 
			int lheight = height(node.left); 
			int rheight = height(node.right); 
			 // use the larger one 
			if (lheight > rheight) 
				return (lheight + 1); 
			else
				return (rheight + 1); 
		} 
	}


	// Iterative method to find height of Binary Tree 
	//Time Complexity: O(n) where n is number of nodes in given binary tree.
	int treeHeight(Node node) { 
		// Base Case 
		if (node == null) {
			return 0; 
		}
		// Create an empty queue for level order tarversal 
		Queue<Node> q = new LinkedList(); 
		// Enqueue Root and initialize height 
		q.add(node); 
		int height = 0; 
		while (true) { 

			int nodeCount = q.size(); 
			
			if (nodeCount == 0) {
				return height; 
			}

			height++; 
			
			while (nodeCount > 0) { 

				Node newnode = q.remove(); 

				if (newnode.left != null) {
					q.add(newnode.left); 
				}

				if (newnode.right != null) {
					q.add(newnode.right); 
				}

				nodeCount--; 
			}

		} 
	} 

	// Driver program to test above functions 
	public static void main(String args[]) {

		HeightBinaryTree tree = new HeightBinaryTree(); 
		
		// Let us create a binary tree shown in above diagram 
		tree.root = new Node(1); 
	
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
	
		tree.root.left.left = new Node(4);  
		tree.root.left.right = new Node(5); 
	
		System.out.println("Height of tree is " + tree.treeHeight(tree.root)); 
		System.out.println("Height of tree is " + tree.height(tree.root)); 
	} 
} 


/*
Iterative Method to find Height of Binary Tree


There are two conventions to define the height of a Binary Tree
1) Number of nodes on the longest path from the root to the deepest node.
2) Number of edges on the longest path from the root to the deepest node.
In this post, the first convention is followed. For example, height of the below tree is 3.

Example Tree
Example Tree

Recursive method to find height of Binary Tree is discussed here. How to find height without
 recursion? We can use level order traversal to find height without recursion.
 The idea is to traverse level by level. Whenever move down to a level, increment height by 1 
 (height is initialized as 0). Count number of nodes at each level, stop traversing when the count 
 of nodes at the next level is 0.


Following is a detailed algorithm to find level order traversal using a queue.
Create a queue.
Push root into the queue.
height = 0
Loop
    nodeCount = size of queue
        
        // If the number of nodes at this level is 0, return height
    if nodeCount is 0
        return Height;
    else
        increase Height

        // Remove nodes of this level and add nodes of 
        // next level
    while (nodeCount > 0)
        pop node from front
        push its children to queue
        decrease nodeCount
       // At this point, queue has nodes of next level*/