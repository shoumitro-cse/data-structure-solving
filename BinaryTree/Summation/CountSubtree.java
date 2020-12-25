// Java program to find if 
// there is a subtree with given sum 

// javac -d classes CountSubtree.java  && cd classes && java CountSubtree && cd ..

import java.io.*;

// Node class to create new node
class Node
{
	int data;
	Node left;
	Node right;
	Node(int data)
	{
		this.data = data;
	}
}

class CountSubtree
{
	static int count = 0;
	static Node ptr;
	
	// Utility function to count subtress that 
	// sum up to a given value x
	int countSubtreesWithSumXUtil(Node root, int x)
	{
		int l = 0, r = 0;
		if(root == null) return 0;
		l += countSubtreesWithSumXUtil(root.left, x);
		r += countSubtreesWithSumXUtil(root.right, x);
		if(l + r + root.data == x) count++;
		if(ptr != root) return l + root.data + r;
		return count;
	}

	// Driver Code
	public static void main(String[] args)
	{

		Node root = new Node(5);
		root.left = new Node(-10);
		root.right = new Node(3);
		root.left.left = new Node(9);
		root.left.right = new Node(8);
		root.right.left = new Node(-4);
		root.right.right = new Node(7);
		int x = 7;
		ptr = root; // assigning global value of ptr
		System.out.println("Count = " +new CountSubtree().countSubtreesWithSumXUtil(root, x));
	}
}



/*Count subtrees that sum up to a given value x only using single recursive function

Given a binary tree containing n nodes. The problem is to count subtrees having total 
node’s data sum equal to a given value using only single recursive functions.

Examples: 

Input : 
             5
           /   \  
        -10     3
        /  \   /  \
       9    8 -4   7
       
       x = 7

Output : 2
There are 2 subtrees with sum 7.

1st one is leaf node:
7.

2nd one is:

      -10
     /   \
    9     8*/