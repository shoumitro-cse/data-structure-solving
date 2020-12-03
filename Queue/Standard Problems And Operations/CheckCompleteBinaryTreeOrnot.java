//A Java program to check if a given binary tree is complete or not 

//javac -d classes CheckCompleteBinaryTreeOrnot.java  && cd classes && java CheckCompleteBinaryTreeOrnot && cd .

import java.util.LinkedList; 
import java.util.Queue; 

class Node  {

	int data; 
	Node left; 
	Node right;
	// Constructor 
	Node(int d) { 
		data = d; 
		left = null; 
		right = null; 
	} 
} 


public class CheckCompleteBinaryTreeOrnot 
{ 

	// Time Complexity: O(n) where n is the number of nodes in given Binary Tree
	// Auxiliary Space: O(n) for queue.
	static boolean isCompleteBT(Node root) { 
		// Base Case: An empty tree is complete Binary Tree 
		if(root == null) {
			return true; 
		}
		// Create an empty queue 
		Queue<Node> queue =new LinkedList<>(); 
		// Create a flag variable which will be set true when a non full node is seen 
		boolean flag = false; 
		// Do level order traversal using queue. 
		queue.add(root); 

		while(!queue.isEmpty()) { 
			
			Node temp_node = queue.poll(); 
			
			 // Check if left child is present
			if(temp_node.left != null) { 
				if(flag == true) { 
					return false; 
				}
				// Enqueue Left Child 
				queue.add(temp_node.left); 
			} else {
				flag = true; 
			}

			 // Check if right child is present
			if(temp_node.right != null) { 
				if(flag == true) {
					return false; 
				}
				// Enqueue Right Child 
				queue.add(temp_node.right); 
			} else {
				flag = true; 
			}

		} 
		// If we reach here, then the tree is complete Binary Tree 
		return true; 
	} 
	
	 // Driver program to test above functions
	public static void main(String[] args) { 
	
		Node root = new Node(1); 

		root.left = new Node(2); 
		root.right = new Node(3); 
		
		root.left.left = new Node(4); 
		root.left.right = new Node(5); 
		
		// root.right.left = new Node(6); 
		root.right.right = new Node(7); 

        /* 
                1 
              /   \ 
             2     3 
            / \     \ 
           4   5     6 
        */
		
		if(isCompleteBT(root) == true) 
			System.out.println("\nComplete Binary Tree"); 
		else
			System.out.println("\nNOT Complete Binary Tree"); 
	} 

} 



/*Check whether a given Binary Tree is Complete or not | Set 1 (Iterative Solution)

Given a Binary Tree, write a function to check whether the given Binary Tree is 
Complete Binary Tree or not.
A complete binary tree is a binary tree in which every level, except possibly the last, 
is completely filled, and all nodes are as far left as possible. See the following examples.

The following trees are examples of Complete Binary Trees
    1
  /   \
 2     3
  
    
 
       1
    /    \
   2       3
  /
 4

 
       1
    /    \
   2      3
  /  \    /
 4    5  6


The following trees are examples of Non-Complete Binary Trees
 
    1
      \
       3
  


       1
    /    \
   2       3
    \     /  \   
     4   5    6

  


       1
    /    \
   2      3
         /  \
        4    5*/