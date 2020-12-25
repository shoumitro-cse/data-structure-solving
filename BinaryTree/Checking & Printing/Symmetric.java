// Iterative Java program to check if given binary tree symmetric 

//javac -d classes Symmetric.java  && cd classes && java Symmetric && cd ..

import java.util.* ; 

public class Symmetric 
{ 
	Node root; 
	static class Node 
	{ 
		int val; 
		Node left, right; 
		Node(int v) 
		{ 
			val = v; 
			left = null; 
			right = null; 
		} 
	} 

	/* constructor to initialise the root */
	Symmetric(Node r) { root = r; } 

	/* empty constructor */
	Symmetric() { } 



/*    // returns true if trees with roots as root1 and root2 are mirror 
    boolean isMirror(Node node1, Node node2)  
    { 
        // if both trees are empty, then they are mirror image 
        if (node1 == null && node2 == null) 
            return true; 
   
        // For two trees to be mirror images, the following three 
        // conditions must be true 
        // 1 - Their root node's key must be same 
        // 2 - left subtree of left tree and right subtree 
        //      of right tree have to be mirror images 
        // 3 - right subtree of left tree and left subtree 
        //      of right tree have to be mirror images 
        if (node1 != null && node2 != null && node1.key == node2.key) 
            return (isMirror(node1.left, node2.right) 
                    && isMirror(node1.right, node2.left)); 
   
        // if neither of the above conditions is true then 
        // root1 and root2 are mirror images 
        return false; 
    } */
    
	/* function to check if the tree is Symmetric */
	public boolean isSymmetric(Node root) 
	{ 
		/* This allows adding null elements to the queue */
		Queue<Node> q = new LinkedList<Node>(); 

		/* Initially, add left and right nodes of root */
		q.add(root.left); 
		q.add(root.right); 

		while (!q.isEmpty()) 
		{ 
			/* remove the front 2 nodes to 
			check for equality */
			Node tempLeft = q.remove(); 
			Node tempRight = q.remove(); 

			/* if both are null, continue and chcek 
			for further elements */
			if (tempLeft==null && tempRight==null) 
				continue; 

			/* if only one is null---inequality, retun false */
			if ((tempLeft==null && tempRight!=null) || (tempLeft!=null && tempRight==null)) 
				return false; 

			/* if both left and right nodes exist, but 
			have different values-- inequality, 
			return false*/
			if (tempLeft.val != tempRight.val) 
				return 0; 

			/* Note the order of insertion of elements 
			to the queue : 
			1) left child of left subtree 
			2) right child of right subtree 
			3) right child of left subtree 
			4) left child of right subtree */
			q.add(tempLeft.left); 
			q.add(tempRight.right); 
			q.add(tempLeft.right); 
			q.add(tempRight.left); 
		} 

		/* if the flow reaches here, return true*/
		return true; 
	} 

	/* driver function to test other functions */
	public static void main(String[] args) 
	{ 
		Node n = new Node(1); 
		Symmetric bt = new Symmetric(n); 
		bt.root.left = new Node(2); 
		bt.root.right = new Node(2); 
		bt.root.left.left = new Node(3); 
		bt.root.left.right = new Node(4); 
		bt.root.right.left = new Node(4); 
		bt.root.right.right = new Node(3); 

		if (bt.isSymmetric(bt.root)) 
			System.out.println("The given tree is Symmetric"); 
		else
			System.out.println("The given tree is not Symmetric"); 
	} 
} 
