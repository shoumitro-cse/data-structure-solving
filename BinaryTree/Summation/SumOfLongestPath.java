// Java implementation to find the sum of nodes on the longest path from root to leaf node 

//javac -d classes SumOfLongestPath.java  && cd classes && java SumOfLongestPath && cd ..

public class SumOfLongestPath {						 
	// Node of a binary tree 
	static class Node { 
		int data; 
		Node left, right; 
		
		Node(int data){ 
			this.data = data; 
			left = null; 
			right = null; 
		} 
	} 
	static int maxLen; 
	static int maxSum; 
	
	// function to find the sum of nodes on the 
	// longest path from root to leaf node 
	static void sumOfLongRootToLeafPath(Node root, int sum, int len) { 
		// if true, then we have traversed a root to leaf path 
		if (root == null) { 
			// update maximum length and maximum sum 
			// according to the given conditions 
			if (maxLen < len) { 
				maxLen = len; 
				maxSum = sum; 
			} else if (maxLen == len && maxSum < sum) {
				maxSum = sum; 
			}
			return; 
		} 
		// recur for left subtree 
		sumOfLongRootToLeafPath(root.left, sum + root.data, len + 1); 
		sumOfLongRootToLeafPath(root.right, sum + root.data, len + 1); 
		
	} 
	//Time Complexity: O(n)
	static int sumOfLongRootToLeafPathUtil(Node root) { 
		// if tree is NULL, then sum is 0 
		if (root == null) 
			return 0; 
		maxSum = Integer.MIN_VALUE; 
		maxLen = 0; 
		// finding the maximum sum 'maxSum' for the maximum length root to leaf path 
		sumOfLongRootToLeafPath(root, 0, 0); 
		// required maximum sum 
		return maxSum; 
	} 
	

	public static void main(String args[]) { 
        // binary tree formation 
        Node root = new Node(4);         /*        4        */
        root.left = new Node(2);         /*       / \       */
        root.right = new Node(5);        /*      2   5      */
        root.left.left = new Node(7);    /*     / \ / \     */
        root.left.right = new Node(1);   /*    7  1 2  3    */
        root.right.left = new Node(2);   /*      /          */
        root.right.right = new Node(3);  /*     6           */
        root.left.right.left = new Node(6); 
	
		System.out.println( "Sum = "+ sumOfLongRootToLeafPathUtil(root)); 
	} 
} 

/*
Sum of nodes on the longest path from root to leaf node

Given a binary tree containing n nodes. The problem is to find the sum of all nodes on the 
longest path from root to leaf node. If two or more paths compete for the longest path, 
then the path having maximum sum of nodes is being considered.

Examples:

Input : Binary tree:
        4        
       / \       
      2   5      
     / \ / \     
    7  1 2  3    
      /
     6
Output : 13

        4        
       / \       
      2   5      
     / \ / \     
    7  1 2  3 
      /
     6

The highlighted nodes (4, 2, 1, 6) above are 
part of the longest root to leaf path having
sum = (4 + 2 + 1 + 6) = 13


Algorithm:

sumOfLongRootToLeafPath(root, sum, len, maxLen, maxSum)
    if root == NULL
        if maxLen < len
        maxLen = len
        maxSum = sum
    else if maxLen == len && maxSum is less than sum
        maxSum = sum
        return

    sumOfLongRootToLeafPath(root-left, sum + root-data,
                           len + 1, maxLen, maxSum)
    sumOfLongRootToLeafPath(root-right, sum + root-data,
                           len + 1, maxLen, maxSum)

sumOfLongRootToLeafPathUtil(root)
    if (root == NULL)
        return 0
    
    Declare maxSum = Minimum Integer
    Declare maxLen = 0
    sumOfLongRootToLeafPath(root, 0, 0, maxLen, maxSum)
    return maxSum

    */