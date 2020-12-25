//print all nodes at a distance k from given node 

//javac -d classes PrintAllnodeDistKGivenNode.java  && cd classes && java PrintAllnodeDistKGivenNode && cd ..  

class Node { 
	int data; 
	Node left, right; 
	Node(int item) { 
		data = item; 
		left = right = null; 
	} 
} 

class PrintAllnodeDistKGivenNode { 
	Node root; 

	void printkdistanceNodeDown(Node node, int k) { 
		// Base Case 
		if (node == null || k < 0) 
			return;
		// If we reach a k distant node, print it 
		if (k == 0) { 
			System.out.print(node.data); 
			System.out.println(""); 
			return; 
		} 
		// Recur for left and right subtrees 
		printkdistanceNodeDown(node.left, k-1); 
		printkdistanceNodeDown(node.right, k-1); 
	} 

	int printkdistanceNode(Node node, Node target, int k) { //k=2
		// Base Case 1: If tree is empty, return -1 
		if (node == null) 
			return -1; 

		if (node == target) { 
			printkdistanceNodeDown(node, k); 
			return 0; 
		} 
		// Recur for left subtree 
		int dl = printkdistanceNode(node.left, target, k); 
		// Check if target node was found in left subtree 
		if (dl != -1) { 
			if (dl+1 == k) { 
				System.out.print(node.data); 
				System.out.println(""); 
			} else {
				printkdistanceNodeDown(node.right, k-dl-2); 
			}
			// Add 1 to the distance and return value for parent calls 
			return 1+dl; 
		} 
		// Recur for right subtree 
		int dr = printkdistanceNode(node.right, target, k); 
		if (dr != -1) { 
			if (dr+1 == k) { 
				System.out.print(node.data); 
				System.out.println(""); 
			} else {
				printkdistanceNodeDown(node.left, k-dr-2); 
			}
			return 1+dr; 
		} 

		// If target was neither present in left nor in right subtree 
		return -1; 
	} 

	// Driver program to test the above functions 
	public static void main(String args[]) { 

		PrintAllnodeDistKGivenNode tree = new PrintAllnodeDistKGivenNode(); 

		 // Let us construct the tree shown in above diagram 
		tree.root = new Node(20); 
		tree.root.left = new Node(8); 
		tree.root.right = new Node(22); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(12); 
		tree.root.left.right.left = new Node(10); 
		tree.root.left.right.right = new Node(14); 

		/*	   20
		      /  \
		     8    22
		    / \
		   4   12
		       / \
		      10  14*/

		Node target = tree.root.left.right; //12
		tree.printkdistanceNode(tree.root, target, 2); // return 2
	} 
} 

/*
Print all nodes at distance k from a given node

Given a binary tree, a target node in the binary tree, and an integer value k, print all the nodes that are at distance k from the given target node. No parent pointers are available.
BinaryTree

       20
      /  \
     8    22
    / \
   4   12
       / \
      10  14

Consider the tree shown in diagram

Input: target = pointer to node with data 8.
root = pointer to node with data 20.
k = 2.
Output : 10 14 22

If target is 14 and k is 3, then output
should be “4 20”*/



/*Time Complexity: At first look the time complexity looks more than O(n),
but if we take a closer look, we can observe that no node is traversed more than twice.
Therefore the time complexity is O(n).*/