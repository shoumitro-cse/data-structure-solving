// Find maximum level sum in Binary Tree

//javac -d classes MaximumLevelSumBinaryTree.java  && cd classes && java MaximumLevelSumBinaryTree && cd ..

import java.util.LinkedList; 
import java.util.Queue; 

class MaximumLevelSumBinaryTree { 

	// A binary tree node has data, pointer 
	// to left child and a pointer to right child 
	static class Node { 
		int data; 
		Node left, right; 
		public Node(int data) { 
			this.data = data; 
			this.left = this.right = null; 
		} 
	}; 


    // Time Complexity : O(N) where N is the total number of nodes in the tree.
    // Auxiliary Space : O(w) where w is the maximum width of the tree.
	static int maxLevelSum(Node root) { 
		// Base case 
		if (root == null) {
			return 0; 
		}

		int result = root.data; 
		Queue<Node> q = new LinkedList<>(); 
		q.add(root); 

		while (!q.isEmpty()) { 
			int count = q.size(); 
			int sum = 0; 
			while (count-- > 0) { 
				// Dequeue an node from queue 
				Node temp = q.poll(); 
				// Add this node's value to current sum. 
				sum = sum + temp.data; 
				// Enqueue left and right children of dequeued node 
				if (temp.left != null) {
					q.add(temp.left); 
				}

				if (temp.right != null) {
					q.add(temp.right); 
				}
			} 
			// Update the maximum node count value 
			result = Math.max(sum, result); 
		} 
		return result; 
	} 



	public static void main(String[] args) { 

		Node root = new Node(1); 
		
		root.left = new Node(2); 
		root.right = new Node(3); 
		
		root.left.left = new Node(4); 
		root.left.right = new Node(5); 
		
		// root.right.left = new Node(8); 
		root.right.right = new Node(9); 

		root.right.right.left = new Node(6); 
		root.right.right.right = new Node(7); 
		
    /*   Constructed Binary tree is: 
                 1 
               /   \ 
             2      3 
           /  \    /  \ 
          4    5      8 
                    /   \ 
                   6     7    */

		System.out.println("Maximum level sum is " + maxLevelSum(root)); 
	} 
} 



/*
Find maximum level sum in Binary Tree

Given a Binary Tree having positive and negative nodes, the task is to find the maximum sum 
level in it.

Examples: 

Input :               4
                    /   \
                   2    -5
                  / \    /\
                -1   3 -2  6
Output: 6
Explanation :
Sum of all nodes of 0'th level is 4
Sum of all nodes of 1'th level is -3
Sum of all nodes of 0'th level is 6
Hence maximum sum is 6

Input :          1
               /   \
             2      3
           /  \      \
          4    5      8
                    /   \
                   6     7  
Output :  17
*/