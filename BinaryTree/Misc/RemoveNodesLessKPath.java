// Remove nodes on root to leaf paths of length < K


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

class RemoveNodesLessKPath 
{ 
	Node root; 

	// Utility method that actually removes the nodes which are not 
	// on the pathLen >= k. This method can change the root as well. 
	Node removeShortPathNodesUtil(Node node, int level, int k) 
	{ 
		//Base condition 
		if (node == null) 
			return null; 
			
		node.left = removeShortPathNodesUtil(node.left, level + 1, k); 
		node.right = removeShortPathNodesUtil(node.right, level + 1, k); 

		if (node.left == null && node.right == null && level < k) 
			return null; 

		// Return root; 
		return node; 
	} 

	// Method which calls the utitlity method to remove the short path 
	// nodes. 
	Node removeShortPathNodes(Node node, int k) 
	{ 
		int pathLen = 0; 
		return removeShortPathNodesUtil(node, 1, k); 
	} 

	//Method to print the tree in inorder fashion. 
	void printInorder(Node node) 
	{ 
		if (node != null) 
		{ 
			printInorder(node.left); 
			System.out.print(node.data + " "); 
			printInorder(node.right); 
		} 
	} 

	// Driver program to test for samples 
	public static void main(String args[]) { 
		
		RemoveNodesLessKPath tree = new RemoveNodesLessKPath(); 
		int k = 4; 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.root.left.left.left = new Node(7); 
		tree.root.right.right = new Node(6); 
		tree.root.right.right.left = new Node(8); 

		System.out.println("The inorder traversal of original tree is : "); 
		tree.printInorder(tree.root); 
		
		Node res = tree.removeShortPathNodes(tree.root, k); 
		System.out.println(""); 
		
		System.out.println("The inorder traversal of modified tree is : "); 
		tree.printInorder(res); 
	} 
} 



/*
Remove nodes on root to leaf paths of length < K



Given a Binary Tree and a number k, remove all nodes that lie only on root to leaf path(s)
of length smaller than k. If a node X lies on multiple root-to-leaf paths and if any of the paths has path length >= k, then X is not deleted from Binary Tree. In other words a node is deleted if all paths going through it have lengths smaller than k.

Consider the following example Binary Tree

               1
           /      \
         2          3
      /     \         \
    4         5        6
  /                   /
 7                   8 
Input: Root of above Binary Tree
       k = 4

Output: The tree should be changed to following  
           1
        /     \
      2          3
     /             \
   4                 6
 /                  /
7                  8

There are 3 paths 
i) 1->2->4->7      path length = 4
ii) 1->2->5        path length = 3
iii) 1->3->6->8    path length = 4 

There is only one path " 1->2->5 " of length smaller than 4.  
The node 5 is the only node that lies only on this path, so 
node 5 is removed.
Nodes 2 and 1 are not removed as they are parts of other paths
of length 4 as well.

If k is 5 or greater than 5, then whole tree is deleted. 

If k is 3 or less than 3, then nothing is deleted.

*/