// Java implementation to find maximum spiral sum 

//javac -d classes MaxSpiralSum.java  && cd classes && java MaxSpiralSum && cd ..

import java.util.ArrayList; 
import java.util.Stack; 

public class MaxSpiralSum { 

	// function to find the maximum sum contiguous subarray. implements kadane's algorithm 
	static int maxSum(ArrayList<Integer> arr) { 
		System.out.println(arr); 
		// to store the maximum value that is ending up to the current index 
		int max_ending_here = Integer.MIN_VALUE; 
		// to store the maximum value encountered so far 
		int max_so_far = Integer.MIN_VALUE; 
		// traverse the array elements 
		for (int i = 0; i < arr.size(); i++) {		 
			// if max_ending_here < 0, then it could 
			// not possibly contribute to the maximum sum further 
			if (max_ending_here < 0) 
				max_ending_here = arr.get(i); 
			// else add the value arr[i] to max_ending_here 
			else
				max_ending_here +=arr.get(i); 
		   // System.out.println(max_ending_here); 
			// update max_so_far 
			max_so_far = Math.max(max_so_far, max_ending_here); 
		} 
		// required maxium sum contiguous subarray value 
		return max_so_far; 
	} 
	// Time Complexity: O(n).
	// Auxiliary Space: O(n).
	// Function to find maximum spiral sum 
	public static int maxSpiralSum(Node root) { 
		// if tree is empty 
		if (root == null) 
			return 0; 
		// Create two stacks to store alternate levels 
		Stack<Node> s1=new Stack<>();// For levels from right to left 
		Stack<Node> s2=new Stack<>(); // For levels from left to right 
		// ArrayList to store spiral order traversal of the binary tree 
		ArrayList<Integer> arr=new ArrayList<>(); 
		// Push first level to first stack 's1' 
		s1.push(root); 
		// traversing tree in spiral form until 
		// there are elements in any one of the stacks 
		while (!s1.isEmpty() || !s2.isEmpty()) { 
			// traverse current level from s1 and push nodes of next level to s2 
			while (!s1.isEmpty()) { 
				Node temp = s1.pop(); 
				// push temp-data to 'arr' 
				arr.add(temp.data); 
				// Note that right is pushed before left 
				if (temp.right!=null) 
					s2.push(temp.right); 
				if (temp.left!=null) 
					s2.push(temp.left); 
			} 
			// traverse current level from s2 and push nodes of next level to s1 
			while (!s2.isEmpty()) { 
				Node temp = s2.pop(); 
				// push temp-data to 'arr' 
				arr.add(temp.data); 
				// Note that left is pushed before right 
				if (temp.left!=null) 
					s1.push(temp.left); 
				if (temp.right!=null) 
					s1.push(temp.right); 
			} 
		} 
	
		// required maximum spiral sum 
		return maxSum(arr); 
	} 


	public static void main(String args[]) { 
		Node root = new Node(-2); 
		root.left = new Node(-3); 
		root.right = new Node(4); 
		root.left.left = new Node(5); 
		root.left.right = new Node(1); 
		root.right.left = new Node(-2); 
		root.right.right = new Node(-1); 
		root.left.left.left = new Node(-3); 
		root.right.right.right = new Node(2); 
		System.out.println("Maximum Spiral Sum = "+maxSpiralSum(root)); 
	} 
} 


class Node 
{ 
	int data ; 
	Node left, right ; 
	Node(int data) 
	{ 
		this.data=data; 
		left=right=null; 
	} 

}; 



/*
Maximum spiral sum in Binary Tree

Given a binary tree containing n nodes. The problem is to find the maximum sum obtained 
when the tree is spirally traversed. In spiral traversal one by one all levels are being 
traversed with the root level traversed from right to left, then next level from left to right, 
then further next level from right to left and so on.

Example:


Maximum spiral sum = 4 + (-1) + (-2) + 1 + 5 = 7*/