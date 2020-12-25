//Find right sibling of a binary tree with parent pointers

//javac -d classes RightSibling.java  && cd classes && java RightSibling && cd ..

public class RightSibling { 

	static class Node { 
		int data; 
		Node left, right, parent; 
		// Constructor 
		public Node(int data, Node parent) { 
			this.data = data; 
			left = null; 
			right = null; 
			this.parent = parent; 
		} 
	}; 

	// Method to find right sibling 
	static Node findRightSibling(Node node, int level) 
	{ 
		if (node == null || node.parent == null) 
			return null; 

		while (node.parent.right == node || (node.parent.right == null && node.parent.left == node)) { 
			if (node.parent == null) 
				return null; 
			node = node.parent; 
			level--; 
		} 
		// Move to the required child, where right sibling can be present 
		node = node.parent.right; 
		// find right sibling in the given subtree(from current node), when level will be 0 
		while (level < 0) { 
			// Iterate through subtree 
			if (node.left != null) 
				node = node.left; 
			else if (node.right != null) 
				node = node.right; 
			else
				// if no child are there, we cannot have right sibling in this path 
				break; 

			level++; 
		} 
		// System.out.println(level);
		if (level == 0) 
			return node; 
		else
		  return findRightSibling(node, level); 
	} 

	public static void main(String args[]) 
	{ 
		Node root = new Node(1, null); 
		root.left = new Node(2, root); 
		root.right = new Node(3, root); 
		root.left.left = new Node(4, root.left); 
		root.left.right = new Node(6, root.left); 
		root.left.left.left = new Node(7, root.left.left); 
		root.left.left.left.left = new Node(10, root.left.left.left); //10
		root.left.right.right = new Node(9, root.left.right); 
		root.right.right = new Node(5, root.right); 
		root.right.right.right = new Node(8, root.right.right); 
		root.right.right.right.right = new Node(12, root.right.right.right); 

		// passing 10 
		System.out.println(findRightSibling(root.left.left.left.left, 0).data); 
	} 
} 

/*
Find right sibling of a binary tree with parent pointers

Given a binary tree with parent pointers, find the right sibling of a given node(pointer to the node will be given), if it doesn’t exist return null. Do it in O(1) space and O(n) time?

Examples:

             1
            / \
           2   3
          /  \  \
         4    6  5
        /      \  \
       7        9  8
       /         \
      10         12
Input : Given above tree with parent pointer and node 10
Output : 12*/