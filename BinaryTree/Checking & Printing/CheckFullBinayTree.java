//check if binay tree is full or not 

//javac -d classes CheckFullBinayTree.java  && cd classes && java CheckFullBinayTree && cd ..

import java.util.*; 

class Node 
{ 
	int data; 
	Node left, right; 

	Node(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

class CheckFullBinayTree {

	Node root; 


/*	// Check whether a binary tree is a full binary tree or not | Iterative Approach
    //Time Complexity: O(n).
    //Auxiliary Space: O(max), where max is the maximum number of nodes at a particular level.
	static boolean isFullTree(Node root)  
	{  
	    // if tree is empty  
	    if (root == null)  
	        return true; 
	    // queue used for level order traversal  
	    Queue<Node> q = new LinkedList<Node> ();  
	    // push 'root' to 'q'  
	    q.add(root);  
	    // traverse all the nodes of the binary tree  
	    // level by level until queue is empty  
	    while (!q.isEmpty()) {  
	        // get the pointer to 'node' at front  
	        // of queue  
	        Node node =  q.remove();  
	        // if it is a leaf node then continue  
	        if (node.left == null && node.right == null)  
	            continue;  
	        // if either of the child is not null and the  
	        // other one is null, then binary tree is not  
	        // a full binary tee  
	        if (node.left == null || node.right == null)  
	            return false;  
	        // push left and right childs of 'node'  
	        // on to the queue 'q'  
	        q.add(node.left);  
	        q.add(node.right);  
	    }  
	  
	    // binary tree is a full binary tee  
	    return true;  
	}*/

	
	 // this function checks if a binary tree is full or not 
	boolean isFullTree(Node node) { 
		// if empty tree 
		if(node == null) 
		return true; 
		// if leaf node 
		if(node.left == null && node.right == null ) 
			return true; 
		// if both left and right subtrees are not null the are full 
		if((node.left!=null) && (node.right!=null)) 
			return (isFullTree(node.left) && isFullTree(node.right)); 
		// if none work 
		return false; 
	} 

	
	// Driver program 
	public static void main(String args[]) 
	{ 
		CheckFullBinayTree tree = new CheckFullBinayTree(); 
		tree.root = new Node(10); 

		tree.root.left = new Node(20); 
		tree.root.right = new Node(30); 

		tree.root.left.left = new Node(50); 
		tree.root.left.right = new Node(40); 

		tree.root.right.left = new Node(60); 
		tree.root.right.right = new Node(70); 

		/*		  10
				/    \
		       20     30
		      / \     / \
			 50  40	  60 70*/

		if(tree.isFullTree(tree.root)) 
			System.out.println("\n\nThe binary tree is full"); 
		else
			System.out.println("\n\nThe binary tree is not full"); 
	} 
} 

/*Check whether a binary tree is a full binary tree or not

A full binary tree is defined as a binary tree in which all nodes have either zero or two child nodes.
Conversely, there is no node in a full binary tree, which has one child node. 

For Example :

				  10
				/    \
		       20     30
		      / \     / \
			 50  40	  60 70


Input : 
           1
         /   \
        2     3
       / \  
      4   5
Output : Yes

Input :
           1
         /   \
        2     3
       /  
      4   
Output :No

To check whether a binary tree is a full binary tree we need to test the following cases:-
1) If a binary tree node is NULL then it is a full binary tree.
2) If a binary tree node does have empty left and right sub-trees, then it is a full binary tree 
   by definition.
3) If a binary tree node has left and right sub-trees, then it is a part of a full binary tree 
   by definition. In this case recursively check if the left and right sub-trees are also 
   binary trees themselves.
4) In all other combinations of right and left sub-trees, the binary tree is not a full binary tree.

Following is the implementation for checking if a binary tree is a full binary tree.


 Perform iterative level order traversal of the tree using queue. For each node encountered, 
 follow the steps given below:

1. If (node->left == NULL && node->right == NULL), it is a leaf node. Discard it and start 
   processing the next node from the queue.
2. If (node->left == NULL || node->right == NULL), then it means that only child of 
   node is present. Return false as the binary tree is not a full binary tree.
3. Else, push the left and right child’s of the node on to the queue.
   If all the node’s from the queue gets processed without returning false, 
   then return true as the binary tree is a full binary tree.



*/