// Remove edges connected to a node such that the three given nodes are in different trees

//javac -d classes RemoveEdge.java  && cd classes && java RemoveEdge && cd ..

public class RemoveEdge { 

	// LCA function taken from the above link mentioned 
	// This function returns a pointer to LCA of two given 
	// values n1 and n2. This function assumes that n1 and n2 
	// are present in Binary Tree 
	static Node findLCA(Node root, int n1, int n2) 
	{ 
		// Base case 
		if (root == null) 
			return null; 
	
		// If either n1 or n2 matches with root's key, report 
		// the presence by returning root (Note that if a key is 
		// ancestor of other, then the ancestor key becomes LCA 
		if (root.key == n1 || root.key == n2) 
			return root; 
	
		// Look for keys in left and right subtrees 
		Node left_lca = findLCA(root.left, n1, n2); 
		Node right_lca = findLCA(root.right, n1, n2); 
	
		// If both of the above calls return Non-NULL, then one key 
		// is present in once subtree and other is present in other, 
		// So this node is the LCA 
		if (left_lca!=null && right_lca!=null) 
			return root; 
	
		// Otherwise check if left subtree or right subtree is LCA 
		return (left_lca != null) ? left_lca : right_lca; 
	} 
	
	// the function assumes a, b, c are present in the tree 
	// and returns a node disconnecting which 
	// results in all three nodes in different trees 
	static Node findNode(Node root, int a, int b, int c) 
	{ 
		// lca of a, b 
		Node x = findLCA(root, a, b); //1
		// lca of b, c 
		Node y = findLCA(root, b, c); //3
		// lca of c, a 
		Node z = findLCA(root, c, a); //1
	
		if (x.key == y.key) 
			return z; 
		else if (x.key == z.key) 
			return y; 
		else
			return x; 
	} 

	public static void main(String args[]) { 
		Node root = new Node(1); 

		root.left = new Node(2); 
		root.right = new Node(3); 

		root.left.left = new Node(4); 
		root.left.right = new Node(5);

		root.left.left.left = new Node(8); 
		root.left.left.right = new Node(9); 

		root.left.right.left = new Node(10); 
		root.left.right.right = new Node(11); 

		root.right.left = new Node(6); 
		root.right.right = new Node(7); 

		root.right.left.left = new Node(12); 
		root.right.left.right = new Node(13); 

		root.right.right.left = new Node(14); 
		root.right.right.right = new Node(15); 




		System.out.print("Disconnect node "+findNode(root, 5, 6, 15).key+" from the tree"); 
	} 
} 

// Node class 
class Node { 
	int key; 
	Node left, right; 
	Node (int data) 
	{ 
		this.key=data; 
	} 
}; 
