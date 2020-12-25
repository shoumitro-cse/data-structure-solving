//find sum of all odd nodes in the path connecting two given nodes 

//javac -d classes SumOfOddPathConnecting2Nodes.java  && cd classes && java SumOfOddPathConnecting2Nodes && cd ..

import java.util.*; 
class SumOfOddPathConnecting2Nodes 
{ 

	// Binary Tree node 
	static class Node 
	{ 
		int data; 
		Node left; 
		Node right; 
	} 

	// Utitlity function to create a 
	// new Binary Tree node 
	static Node newNode(int data) 
	{ 
		Node node = new Node(); 
		node.data = data; 
		node.left = null; 
		node.right = null; 
		
		return node; 
	} 

	// Function to check if there is a path from root 
	// to the given node. It also populates 
	// 'arr' with the given path 
	static boolean getPath(Node root, Vector<Integer> arr, int x) 
	{ 
		// if root is null 
		// there is no path 
		if (root==null) 
			return false; 
		// push the node's value in 'arr' 
		arr.add(root.data); 
		// if it is the required node 
		// return true 
		if (root.data == x) 
			return true; 
		// else check whether the required node lies 
		// in the left subtree or right subtree of 
		// the current node 
		if (getPath(root.left, arr, x) || getPath(root.right, arr, x)) 
			return true; 

		// required node does not lie either in the 
		// left or right subtree of the current node 
		// Thus, remove current node's value from 
		// 'arr'and then return false 
		arr.remove(arr.size()-1); 
		return false; 
	} 

	// Function to get the sum of odd nodes in the 
	// path between any two nodes in a binary tree 
	static int sumOddNodes(Node root, int n1, int n2) 
	{ 
		// vector to store the path of 
		// first node n1 from root 
		Vector<Integer> path1= new Vector<Integer>(); 
		// vector to store the path of 
		// second node n2 from root 
		Vector<Integer> path2= new Vector<Integer>(); 

		getPath(root, path1, n1); 
		getPath(root, path2, n2);

		System.out.println(path1);
		System.out.println(path2);

		int intersection = -1; 

		// Get intersection point 
		int i = 0, j = 0; 
		while (i != path1.size() || j != path2.size()) { 
			// Keep moving forward until no intersection  is found 
			if (i == j && path1.get(i) == path2.get(j)) { 
				i++; 
				j++; 
			} else { 
				intersection = j - 1; 
				break; 
			} 
		} 
		
		int sum = 0; 
		
		// calculate sum of ODD nodes from the path 
		for (i = path1.size()-1; i > intersection; i--) 
			if(path1.get(i)%2!=0) 
				sum += path1.get(i); 

		for (i = intersection; i < path2.size(); i++) 
			if(path2.get(i)%2!=0) 
				sum += path2.get(i); 
		return sum;		 
	} 

	// Driver Code 
	public static void main(String args[]) 
	{ 
		Node root = newNode(1); 
		
		root.left = newNode(2); 
		root.right = newNode(3); 
		root.left.left = newNode(4); 
		root.left.right = newNode(5); 
		root.right.right = newNode(6); 
		
		int node1 = 5; 
		int node2 = 6; 
		
		System.out.println(sumOddNodes(root, node1, node2)); 
		
	} 
} 
