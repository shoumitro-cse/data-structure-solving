// Find distance from root to given node in a binary tree
 
import java.util.*; 

class DistRootToGivenNode { 

	static class Node { 
		int data; 
		Node left, right; 
	} 

	// A utility function to create a new Binary Tree Node 
	static Node newNode(int item) { 
		Node temp = new Node(); 
		temp.data = item; 
		temp.left = null; 
		temp.right = null; 
		return temp; 
	} 

	// Returns -1 if x doesn't exist in tree. Else returns distance of x from root 
	static int findDistance(Node root, int x) { 
		// Base case 
		if (root == null) 
		return -1; 
		// Initialize distance 
		int dist = -1; 
		// Check if x is present at root or in left subtree or right subtree. 
		if ((root.data == x) || 
			(dist = findDistance(root.left, x)) >= 0 || 
			(dist = findDistance(root.right, x)) >= 0) 
			return dist + 1; 
		return dist; 
	} 

	public static void main(String[] args) 
	{ 
		Node root = newNode(5); 
		root.left = newNode(10); 
		root.right = newNode(15); 
		root.left.left = newNode(20); 
		root.left.right = newNode(25); 
		root.left.right.right = newNode(45); 
		root.right.left = newNode(30); 
		root.right.right = newNode(35); 

		System.out.println(findDistance(root, 45)); 
	} 
} 


/*
Find distance from root to given node in a binary tree


Given root of a binary tree and a key x in it, find distance of the given key from root. 
Dis­tance means num­ber of edges between two nodes.

Examples:

Input : x = 45,
        Root of below tree
        5
      /    \
    10      15
    / \    /  \
  20  25  30   35
       \
       45
Output : Distance = 3             
There are three edges on path
from root to 45.

For more understanding of question,
in above tree distance of 35 is two
and distance of 10 is 1.

*/