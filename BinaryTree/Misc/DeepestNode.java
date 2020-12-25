// A Java program to find value of the deepest node in a given binary tree 

//javac -d classes DeepestNode.java  && cd classes && java DeepestNode && cd ..

class DeepestNode { 
	// A tree node with constructor 
	static class Node { 
		int data; 
		Node left, right; 
		// constructor 
		Node(int key) { 
			data = key; 
			left = null; 
			right = null; 
		} 
	};


/*  static int maxLevel = -1; 
    static int res = -1; 
    static void find(Node root, int level) { 
        if (root != null) { 
            find(root.left, ++level); 
            // Update level and resue  
            if (level > maxLevel) { 
                res = root.data; 
                maxLevel = level; 
            } 
            find(root.right, level); 
        } 
    } 
    // Returns value of deepest node  
    static int deepestNode(Node root) { 
        find(root, 0); 
        return res; 
    } */


	// Utility function to find height of a tree, rooted at 'root'. 
	static int height(Node root) { 
		if(root == null) return 0; 
		int leftHt = height(root.left); 
		int rightHt = height(root.right); 
		return Math.max(leftHt, rightHt) + 1; 
	} 

	// levels : current Level 
	// Utility function to print all 
	// nodes at a given level. 
	static void deepestNode(Node root, int levels) 
	{ 
		if(root == null) return; 
		
		if(levels == 1) 
		System.out.print(root.data + " "); 
		
		else if(levels > 1) 
		{ 
			deepestNode(root.left, levels - 1); 
			deepestNode(root.right, levels - 1); 
		} 
	} 

	// Driver Codede 
	public static void main(String args[]) 
	{ 
		Node root = new Node(1); 
		root.left = new Node(2); 
		root.right = new Node(3); 
		root.left.left = new Node(4); 
		root.right.left = new Node(5); 
		root.right.right = new Node(6); 
		root.right.left.right = new Node(7); 
		root.right.right.right = new Node(8); 
		root.right.left.right.left = new Node(9); 
		
		// Calculating height of tree 
		int levels = height(root); 
		
		// Printing the deepest node 
		deepestNode(root, levels); 
	} 
} 


/*
Find the Deepest Node in a Binary Tree

Given a binary tree, find the deep­est node in it.
Examples: 
 

Input : Root of below tree
            1
          /   \
         2      3
        / \    / \ 
       4   5  6   7
                   \
                    8
Output : 8

Input : Root of below tree
            1
          /   \
         2      3
               / 
              6  
Output : 6*/