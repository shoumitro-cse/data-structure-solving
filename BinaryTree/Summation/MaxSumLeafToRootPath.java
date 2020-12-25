// Find the maximum sum leaf to root path in a Binary Tree

//javac -d classes MaxSumLeafToRootPath.java  && cd classes && java MaxSumLeafToRootPath && cd ..

class Node { 
	int data; 
	Node left, right; 
	Node(int item) { 
		data = item; 
		left = right = null; 
	} 
} 

// A wrapper class is used so that max_no can be updated among function calls.
class Maximum { 
	int max_no = Integer.MIN_VALUE; 
} 

class MaxSumLeafToRootPath { 

	Node root; 
	Maximum max = new Maximum(); 
	Node target_leaf = null; 

	// A utility function that prints all nodes on the path from root to target_leaf 
	boolean printPath(Node node, Node target_leaf) { 
		// base case 
		if (node == null) 
			return false; 
		// return true if this node is the target_leaf or 
		// target leaf is present in one of its descendants 
		if (node == target_leaf || printPath(node.left, target_leaf) || printPath(node.right, target_leaf)) { 
			System.out.print(node.data + " "); 
			return true; 
		} 
		return false; 
	} 


	void getTargetLeaf(Node node, Maximum max_sum_ref, int curr_sum) { 

		if (node == null) 
			return; 
		// Update current sum to hold sum of nodes on path from root to this node 
		curr_sum = curr_sum + node.data; 
		// If this is a leaf node and path to this node 
		// has maximum sum so far, the n make this node target_leaf 
		if (node.left == null && node.right == null) { 
			if (curr_sum > max_sum_ref.max_no) { 
				max_sum_ref.max_no = curr_sum; 
				target_leaf = node;  
			} 
		} 
		// If this is not a leaf node, then recur down to find the target_leaf 
		getTargetLeaf(node.left, max_sum_ref, curr_sum); 
		getTargetLeaf(node.right, max_sum_ref, curr_sum); 
	} 

	// Returns the maximum sum and prints the nodes on max sum path 
	int maxSumPath() { 
		// base case 
		if (root == null) 
			return 0; 
		// find the target leaf and maximum sum 
		getTargetLeaf(root, max, 0); 
		// print the path from root to the target leaf 
		printPath(root, target_leaf); 
		return max.max_no; // return maximum sum 
	} 

	// driver function to test the above functions 
	public static void main(String args[]) { 
		
		MaxSumLeafToRootPath tree = new MaxSumLeafToRootPath(); 
		
		tree.root = new Node(10); 
		tree.root.left = new Node(-2); 
		tree.root.right = new Node(7); 
		tree.root.left.left = new Node(8); 
		tree.root.left.right = new Node(-4); 

		System.out.println("Following are the nodes on maximum sum path"); 
		int sum = tree.maxSumPath(); 
		System.out.println(""); 
		System.out.println("Sum of nodes is : " + sum); 

	} 

} 

/*
Find the maximum sum leaf to root path in a Binary Tree

Given a Binary Tree, find the maximum sum path from a leaf to root. 
For example, in the following tree, there are three leaf to root 
paths 8->-2->10, -4->-2->10 and 7->10. The sums of these three 
paths are 16, 4 and 17 respectively. The maximum of them is 17 and 
the path for maximum is 7->10.

                  10
               /      \
             -2        7
           /   \     
          8     -4  */