// Minimum and maximum node that lies in the path connecting two nodes in a Binary Tree

//javac -d classes PathConnectingTwoNodes.java  && cd classes && java PathConnectingTwoNodes && cd ..

import java.util.*;

class PathConnectingTwoNodes
{
	
	// Structure of binary tree
	static class Node 
	{
		Node left;
		Node right;
		int data;
	};

	// Function to create a new node
	static Node newNode(int key)
	{
		Node node = new Node();
		node.left = node.right = null;
		node.data = key;
		return node;
	}

	static Vector<Integer> path;

	// Function to store the path from root node
	// to given node of the tree in path vector and
	// then returns true if the path exists
	// otherwise false
	static boolean FindPath(Node root, int key)
	{
		if (root == null)
			return false;

		path.add(root.data);

		if (root.data == key)
			return true;

		if (FindPath(root.left, key) || FindPath(root.right, key))
			return true;

		path.remove(path.size()-1);
		return false;
	}

	// Function to print the minimum and the maximum
	// value present in the path connecting the
	// given two nodes of the given binary tree
	static int minMaxNodeInPath(Node root, int a, int b)
	{

		// To store the path from the root node to a
		path = new Vector<Integer> ();
		boolean flag = true;
		
		// To store the path from the root node to b
		Vector<Integer> Path2 = new Vector<Integer>(), Path1 = new Vector<Integer>();

		// To store the minimum and the maximum value
		// in the path from LCA to a
		int min1 = Integer.MAX_VALUE;
		int max1 = Integer.MIN_VALUE;

		// To store the minimum and the maximum value
		// in the path from LCA to b
		int min2 = Integer.MAX_VALUE;
		int max2 = Integer.MIN_VALUE;

		int i = 0;
		int j = 0;
		
		flag = FindPath(root, a);
		Path1 = path;
		
		path = new Vector<Integer>();
		
		flag &= FindPath(root, b);
		Path2 = path;
			
		System.out.println(Path1);
		System.out.println(Path2);
		
		// If both a and b are present in the tree
		if ( flag) {
			// Compare the paths to get the first different value
			for (i = 0; i < Path1.size() && i < Path2.size(); i++){
				if (Path1.get(i) != Path2.get(i))
					break;
			}

			i--;
			j = i;

			// Find minimum and maximum value in the path from LCA to a
			for (; i < Path1.size(); i++) {
				if (min1 > Path1.get(i))
					min1 = Path1.get(i);
				if (max1 < Path1.get(i))
					max1 = Path1.get(i);
			}
			// Find minimum and maximum value in the path from LCA to b
			for (; j < Path2.size(); j++) {
				if (min2 > Path2.get(j))
					min2 = Path2.get(j);
				if (max2 < Path2.get(j))
					max2 = Path2.get(j);
			}
			// Minimum of min values in first path and second path
			System.out.println( "Min = " + Math.min(min1, min2) );
			// Maximum of max values in first path and second path
			System.out.println( "Max = " + Math.max(max1, max2));
		} else // If no path exists
			System.out.println("Min = -1\nMax = -1");
		return 0;
	}

	// Driver Code
	public static void main(String args[]) {

		Node root = newNode(20);
		root.left = newNode(8);
		root.right = newNode(22);
		root.left.left = newNode(5);
		root.left.right = newNode(3);
		root.right.left = newNode(4);
		root.right.right = newNode(25);
		root.left.right.left = newNode(10);
		root.left.right.right = newNode(14);

		int a = 5;
		int b = 14;

		minMaxNodeInPath(root, a, b);
	}
}

/*
Minimum and maximum node that lies in the path connecting two nodes in a Binary Tree


Given a binary tree and two nodes a and b, the task is to print the minimum and 
the maximum node value that lies in the path connecting the given nodes a and b. 
If either of the two nodes is not present in the tree then print -1 for both minimum 
and maximum value.

Examples: 

Input:
          1
         /  \
        2    3
       / \    \
      4   5    6
         /    / \
        7    8   9
a = 5, b = 6

Output:
Min = 1
Max = 6

Input:
           20
         /   \
        8     22
      /   \  /   \
     5     3 4    25
          / \
         10  14
a = 5, b = 14

Output:
Min = 3
Max = 14*/