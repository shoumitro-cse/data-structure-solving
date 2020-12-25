//find if there is a subtree with given sum 

//javac -d classes SubtreeGivenSum.java  && cd classes && java SubtreeGivenSum && cd ..

import java.util.*; 

class SubtreeGivenSum { 

	static class Node { 
		int data; 
		Node left, right; 
	} 

	static class INT { 
		int v; 
		INT(int a) { 
			v = a; 
		} 
	} 

	static Node newnode(int data) { 
		Node node = new Node(); 
		node.data = data; 
		node.left = node.right = null; 
		return (node); 
	} 

	static int count = 0;
    static Node ptr;
  
    // Utility function to count subtress that 
    // sum up to a given value x
    static int countSubtreesWithSumXUtil(Node root, int x)
    {
        int l = 0, r = 0;
        if(root == null) 
        	return 0;
        l += countSubtreesWithSumXUtil(root.left, x);
        r += countSubtreesWithSumXUtil(root.right, x);
        if(l + r + root.data == x) 
        	count++;
        if(ptr != root) 
        	return l + root.data + r;
        return count;
    }
 



	static boolean sumSubtreeUtil(Node root, INT cur_sum, int sum) { 
		// base condition 
		if (root == null) { 
			cur_sum = new INT(0); 
			return false; 
		} 
		INT sum_left = new INT(0), sum_right = new INT(0); 
		return (sumSubtreeUtil(root.left, sum_left, sum) || 
				sumSubtreeUtil(root.right, sum_right, sum) || 
			((cur_sum.v = sum_left.v + sum_right.v + root.data) == sum)); 
	} 

	// Wrapper over sumSubtreeUtil() 
	static boolean sumSubtree(Node root, int sum) { 
		// Initialize sum of subtree with root 
		INT cur_sum = new INT( 0); 
		return sumSubtreeUtil(root, cur_sum, sum); 
	} 

	// Driver Code 
	public static void main(String args[]) 
	{ 
		Node root = newnode(8); 
		root.left = newnode(5); 
		root.right = newnode(4); 
		root.left.left = newnode(9); 
		root.left.right = newnode(7); 
		root.left.right.left = newnode(1); 
		root.left.right.right = newnode(12); 
		root.left.right.right.right = newnode(2); 
		root.right.right = newnode(11); 
		root.right.right.left = newnode(3); 
		int sum = 22; 

		if (sumSubtree(root, sum)) 
			System.out.println( "Yes"); 
		else
			System.out.println( "No"); 
		// System.out.println(countSubtreesWithSumXUtil(root, sum)); 
	} 
} 

/*Subtree with given sum in a Binary Tree

You are given a binary tree and a given sum. 
The task is to check if there exist a subtree whose sum of all nodes is equal to the given sum

	    1
	  /   \
	 3     6
	/ \   /
   5   9  8
// For above tree
Input : sum = 17
Output: "Yes"
// sum of all nodes of subtree {3, 5, 9} = 17

Input : sum = 11
Output: "No"
// no subtree with given sum exist*/