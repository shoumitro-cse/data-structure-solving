//find lowest common ancestor using parent pointer A tree node 

//javac -d classes LowestCommonAncestor.java  && cd classes && java LowestCommonAncestor && cd ..

import java.util.HashMap; 
import java.util.Map; 

class Node 
{ 
	int key; 
	Node left, right, parent; 

	Node(int key) 
	{ 
		this.key = key; 
		left = right = parent = null; 
	} 
} 

class LowestCommonAncestor 
{ 
	Node root, n1, n2, lca; 

	/* A utility function to insert a new node with 
	given key in Binary Search Tree */
	Node insert(Node node, int key) 
	{ 
		/* If the tree is empty, return a new node */
		if (node == null) 
			return new Node(key); 

		/* Otherwise, recur down the tree */
		if (key < node.key) { 
			node.left = insert(node.left, key); 
			node.left.parent = node; 
		} else if (key > node.key) { 
			node.right = insert(node.right, key); 
			node.right.parent = node; 
		} 
		/* return the (unchanged) node pointer */
		return node; 
	} 

	// To find LCA of nodes n1 and n2 in Binary Tree 
	Node LCA(Node n1, Node n2) 
	{ 
		// Creata a map to store ancestors of n1 
		Map<Node, Boolean> ancestors = new HashMap<Node, Boolean>(); 
		// Insert n1 and all its ancestors in map 
		while (n1 != null) { 
			ancestors.put(n1, Boolean.TRUE); 
			n1 = n1.parent; 
		} 
		// Check if n2 or any of its ancestors is in 
		// map. 
		while (n2 != null) { 
			if (ancestors.containsKey(n2) != ancestors.isEmpty()) 
				return n2; 
			n2 = n2.parent; 
		} 

		return null; 
	} 

	// Driver method to test above functions 
	public static void main(String[] args) 
	{ 
		LowestCommonAncestor tree = new LowestCommonAncestor(); 
		tree.root = tree.insert(tree.root, 20); 
		tree.root = tree.insert(tree.root, 8); 
		tree.root = tree.insert(tree.root, 22); 
		tree.root = tree.insert(tree.root, 4); 
		tree.root = tree.insert(tree.root, 12); 
		tree.root = tree.insert(tree.root, 10); 
		tree.root = tree.insert(tree.root, 14); 

	/*     		  20
	    		/    \
	    	   8      22
	    	  / \
	    	 4   12
	    	     / \
	    	    10  14*/
 
		tree.n1 = tree.root.left.right.left; //10
		tree.n2 = tree.root.left; //8

		tree.lca = tree.LCA(tree.n1, tree.n2); 

		System.out.println("LCA of " + tree.n1.key + " and " + tree.n2.key + " is " + tree.lca.key); 
	} 
} 


//Java implementation to find lowest common ancestor of
// n1 and n2 using one traversal of binary tree

/*
class Node
{
	int data;
	Node left, right;

	public Node(int item)
	{
		data = item;
		left = right = null;
	}
}

public class LowestCommonAncestor
{
	//Root of the Binary Tree
	Node root;

	Node findLCA(int n1, int n2)
	{
		return findLCA(root, n1, n2);
	}

	// This function returns pointer to LCA of two given
	// values n1 and n2. This function assumes that n1 and
	// n2 are present in Binary Tree
	Node findLCA(Node node, int n1, int n2)
	{
		// Base case
		if (node == null)
			return null;

		// If either n1 or n2 matches with root's key, report
		// the presence by returning root (Note that if a key is
		// ancestor of other, then the ancestor key becomes LCA
		if (node.data == n1 || node.data == n2)
			return node;

		// Look for keys in left and right subtrees
		Node left_lca = findLCA(node.left, n1, n2);
		Node right_lca = findLCA(node.right, n1, n2);

		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		// So this node is the LCA
		if (left_lca!=null && right_lca!=null)
			return node;

		// Otherwise check if left subtree or right subtree is LCA
		return (left_lca != null) ? left_lca : right_lca;
	}

	public static void main(String args[]) {

		LowestCommonAncestor tree = new LowestCommonAncestor();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

		System.out.println("LCA(4, 5) = " +
							tree.findLCA(4, 5).data);
		System.out.println("LCA(4, 6) = " +
							tree.findLCA(4, 6).data);
		System.out.println("LCA(3, 4) = " +
							tree.findLCA(3, 4).data);
		System.out.println("LCA(2, 4) = " +
							tree.findLCA(2, 4).data);
	}
}
*/