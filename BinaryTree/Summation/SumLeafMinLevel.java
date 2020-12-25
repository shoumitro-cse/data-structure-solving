// Java implementation to find the sum of leaf nodes at minimum level 

//javac -d classes SumLeafMinLevel.java  && cd classes && java SumLeafMinLevel && cd ..

import java.util.*; 

class SumLeafMinLevel { 

	// structure of a node of binary tree 
	static class Node { 
		int data; 
		Node left, right; 
	}; 
	// function to get a new node 
	static Node getNode(int data) { 
		// allocate space 
		Node newNode = new Node(); 
		// put in the data 
		newNode.data = data; 
		newNode.left = newNode.right = null; 
		return newNode; 
	} 

	// function to find the sum of leaf nodes at minimum level 
	// Time Complexity: O(n).
// Auxiliary Space: O(n).
	static int sumOfLeafNodesAtMinLevel(Node root) { 
		// if tree is empty 
		if (root == null) 
			return 0; 
		// if there is only one node 
		if (root.left == null && root.right == null) 
			return root.data; 
		// queue used for level order traversal 
		Queue<Node> q = new LinkedList<>(); 
		int sum = 0; 
		boolean f = false; 
		// push root node in the queue 'q' 
		q.add(root); 
		while (f == false) { 
			// count number of nodes in the current level 
			int nc = q.size(); 
			// traverse the current level nodes 
			while (nc-- > 0) { 
				// get front element from 'q' 
				Node top = q.remove(); 
				// if it is a leaf node 
				if (top.left == null && top.right == null) { 
					// accumulate data to 'sum' 
					sum += top.data; 
					// set flag 'f' to 1, to signify minimum level for leaf nodes has been encountered 
					f = true; 
				} else { 
					// if top's left and right child exists, then push them to 'q' 
					if (top.left != null) 
						q.add(top.left); 
					if (top.right != null) 
						q.add(top.right); 
				} 
			} 
		} 
		// required sum 
		return sum; 
	} 

	// Driver Code 
	public static void main(String[] args) { 
		
		// binary tree creation 
		Node root = getNode(1); 
		root.left = getNode(2); 
		root.right = getNode(3); 
		root.left.left = getNode(4); 
		root.left.right = getNode(5); 
		root.right.left = getNode(6); 
		root.right.right = getNode(7); 
		root.left.right.left = getNode(8); 
		root.right.left.right = getNode(9); 
		/*            1
		            /   \
		           2     3
		         /  \   /  \
		        4   5   6   7
		           /     \
		          8       9*/

		System.out.println("Sum = " + sumOfLeafNodesAtMinLevel(root)); 

	} 
} 

/*Source: Microsoft IDC Interview Experience | Set 150.

Sum of leaf nodes at minimum level

Given a binary tree containing n nodes. The problem is to get the sum of all the leaf nodes which are at minimum level in the binary tree.

Examples:

Input : 
              1
            /   \
           2     3
         /  \   /  \
        4   5   6   7
           /     \
          8       9

Output : 11
Leaf nodes 4 and 7 are at minimum level.
Their sum = (4 + 7) = 11. */