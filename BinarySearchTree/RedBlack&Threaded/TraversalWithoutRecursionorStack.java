//Inorder Non-threaded Binary Tree Traversal without Recursion or Stack


class Node 
{ 
	int key; 
	Node left, right, parent; 

	public Node(int key) 
	{ 
		this.key = key; 
		left = right = parent = null; 
	} 
} 

class TraversalWithoutRecursionorStack 
{ 
	Node root; 

	/* A utility function to insert a new node with 
	given key in BST */
	Node insert(Node node, int key) 
	{ 
		/* If the tree is empty, return a new node */
		if (node == null) 
			return new Node(key); 

		/* Otherwise, recur down the tree */
		if (key < node.key) 
		{ 
			node.left = insert(node.left, key); 
			node.left.parent = node; 
		} 
		else if (key > node.key) 
		{ 
			node.right = insert(node.right, key); 
			node.right.parent = node; 
		} 
		
		/* return the (unchanged) node pointer */
		return node; 
	} 

	// Function to print inorder traversal using parent 
	// pointer 
	void inorder(Node root) { 
		boolean leftdone = false; 
		// Start traversal from root 
		while (root != null) { 
			// If left child is not traversed, find the leftmost child 
			if (!leftdone) { 
				while (root.left != null) { 
					root = root.left; 
				} 
			} 
			// Print root's data 
			System.out.print(root.key + " "); 
			// Mark left as done 
			leftdone = true; 
			// If right child exists 
			if (root.right != null) { 
				leftdone = false; 
				root = root.right; 
			} else if (root.parent != null) { // If right child doesn't exist, move to parent 
				// If this node is right child of its parent, visit parent's parent first 
				while (root.parent != null && root == root.parent.right) 
					root = root.parent; 
				
				if (root.parent == null) 
					break; 
				root = root.parent; 
			} else {
				break; 
			}
		} 
	} 

	public static void main(String[] args) 
	{ 
		TraversalWithoutRecursionorStack tree = new TraversalWithoutRecursionorStack(); 
		tree.root = tree.insert(tree.root, 24); 
		tree.root = tree.insert(tree.root, 27); 
		tree.root = tree.insert(tree.root, 29); 
		tree.root = tree.insert(tree.root, 34); 
		tree.root = tree.insert(tree.root, 14); 
		tree.root = tree.insert(tree.root, 4); 
		tree.root = tree.insert(tree.root, 10); 
		tree.root = tree.insert(tree.root, 22); 
		tree.root = tree.insert(tree.root, 13); 
		tree.root = tree.insert(tree.root, 3); 
		tree.root = tree.insert(tree.root, 2); 
		tree.root = tree.insert(tree.root, 6); 

		System.out.println("Inorder traversal is "); 
		tree.inorder(tree.root); 
	} 
} 


/*
Inorder Non-threaded Binary Tree Traversal without Recursion or Stack

We have discussed Thread based Morris Traversal. Can we do inorder traversal 
without threads if we have parent pointers available to us?

Input: Root of Below Tree [Every node of 
       tree has parent pointer also]
        10
      /    \
     5     100
           /  \
          80  120 
Output: 5 10 80 100 120
The code should not extra space (No Recursion
and stack)
*/