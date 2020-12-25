// Java implementation to print the path common to the 
// two paths from the root to the two given nodes 

//javac -d classes CommonPath.java  && cd classes && java CommonPath && cd ..

import java.util.ArrayList; 
public class CommonPath { 

	// Initialize n1 and n2 as not visited 
	static boolean v1 = false, v2 = false; 

	// This function returns pointer to LCA of two given 
	// values n1 and n2. This function assumes that n1 and 
	// n2 are present in Binary Tree 
	static Node findLCAUtil(Node node, int n1, int n2) 
	{ 
		// Base case 
		if (node == null) 
			return null; 
			
		//Store result in temp, in case of key match so that we can search for other key also. 
		Node temp=null; 
	
		// If either n1 or n2 matches with root's key, report the presence 
		// by setting v1 or v2 as true and return root (Note that if a key 
		// is ancestor of other, then the ancestor key becomes LCA) 
		if (node.data == n1) { 
			v1 = true; 
			temp = node; 
		} 
		if (node.data == n2) { 
			v2 = true; 
			temp = node; 
		} 
		// Look for keys in left and right subtrees 
		Node left_lca = findLCAUtil(node.left, n1, n2); 
		Node right_lca = findLCAUtil(node.right, n1, n2); 
	
		if (temp != null) 
			return temp; 
		// If both of the above calls return Non-NULL, then one key 
		// is present in once subtree and other is present in other, 
		// So this node is the LCA 
		if (left_lca != null && right_lca != null) 
			return node; 
		// Otherwise check if left subtree or right subtree is LCA 
		return (left_lca != null) ? left_lca : right_lca; 
	} 

	// Returns true if key k is present in tree rooted with root 
	static boolean find(Node root, int k) { 
		// Base Case 
		if (root == null) 
			return false; 
		// If key k is present at root, or in left subtree 
		// or right subtree, return true 
		if (root.data == k || find(root.left, k) || find(root.right, k)) 
			return true; 
		// Else return false 
		return false; 
	} 

	// This function returns LCA of n1 and n2 only if both n1 and n2 
	// are present in tree, otherwise returns null 
	static Node findLCA(Node root, int n1, int n2) { 
		// Find lca of n1 and n2 
		Node lca = findLCAUtil(root, n1, n2); 
	
		// Return LCA only if both n1 and n2 are present in tree 
		if (v1 && v2 || v1 && find(lca, n2) || v2 && find(lca, n1)) 
			return lca; 
		// Else return null 
		return null; 
	} 

	// function returns true if 
	// there is a path from root to 
	// the given node. It also populates 
	// 'arr' with the given path 
	static boolean hasPath(Node root, ArrayList<Integer> arr, int x) { 
		// if root is null 
		// there is no path 
		if (root==null) 
			return false; 
		// push the node's value in 'arr' 
		arr.add(root.data);	 
		// if it is the required node 
		// return true 
		if (root.data == x)	 
			return true; 
		// else check whether there the required node lies in the 
		// left subtree or right subtree of the current node 
		if (hasPath(root.left, arr, x) || hasPath(root.right, arr, x)) 
			return true; 
		// required node does not lie either in the 
		// left or right subtree of the current node 
		// Thus, remove current node's value from 'arr' 
		// and then return false;	 
		arr.remove(arr.size()-1); 
		return false;			 
	} 

	// function to print the path common 
	// to the two paths from the root 
	// to the two given nodes if the nodes 
	// lie in the binary tree 
	static void CommonPath(Node root, int n1, int n2) { 
		// ArrayList to store the common path 
		ArrayList<Integer> arr=new ArrayList<>(); 
		// LCA of node n1 and n2 
		Node lca = findLCA(root, n1, n2); 
		// if LCA of both n1 and n2 exists 
		if (lca!=null) { 
			// then print the path from root to LCA node 
			if (hasPath(root, arr, lca.data)) { 
				for (int i=0; i<arr.size()-1; i++)	 
					System.out.print(arr.get(i)+"->"); 
					System.out.print(arr.get(arr.size() - 1));	 
			}	 
		} 
		// LCA is not present in the binary tree 
		// either n1 or n2 or both are not present 
		else
			System.out.print("No Common Path"); 
	} 

	public static void main(String args[]) 
	{ 
		Node root = new Node(1); 
		root.left = new Node(2); 
		root.right = new Node(3); 
		root.left.left = new Node(4); 
		root.left.right = new Node(5); 
		root.right.left = new Node(6); 
		root.right.right = new Node(7); 
		root.left.right.left = new Node(8); 
		root.right.left.right = new Node(9); 
			
		int n1 = 4, n2 = 8; 
		CommonPath(root, n1, n2); 
   } 
} 

/* Class containing left and right child of current 
node and key value*/
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


/*
Print the path common to the two paths from the root to the two given nodes

Given a binary tree with distinct nodes(no two nodes have the same have data values). 
The problem is to print the path common to the two paths from the root to the two given 
nodes n1 and n2. If either of the nodes are not present then print “No Common Path”.

Examples:

Input :          1
               /   \
              2     3
             / \   /  \
            4   5  6   7
               /    \   
              8      9

          n1 = 4, n2 = 8

Output : 1->2
Path form root to n1:
1->2->4

Path form root to n2:
1->2->5->8

Common Path:
1->2*/