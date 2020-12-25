 // Java program to determine if binary tree is height balanced or not 

//javac -d classes HeightBalanced.java  && cd classes && java HeightBalanced && cd ..

class Node { 

	int data; 
	Node left, right; 

	Node(int d) 
	{ 
		data = d; 
		left = right = null; 
	} 
} 

// A wrapper class used to modify height across 
// recursive calls. 
class Height { 
	int height = 0; 
} 

class HeightBalanced { 

	Node root; 

/*	int height(Node node) { 
        if (node == null) 
        return 1 + Math.max(height(node.left), height(node.right)); 
    } 

    // Time Complexity: O(n^2) Worst case occurs in case of skewed tree.
    boolean isBalanced(Node node)  { 
        int lh; 
        int rh; 
        if (node == null) 
            return true; 
        lh = height(node.left); 
        rh = height(node.right); 
  
        if (Math.abs(lh-rh) <= 1 && isBalanced(node.left) && isBalanced(node.right)) 
            return true; 
        return false; 
    } */

// Time Complexity: O(n)
	boolean isBalanced(Node root, Height height) 
	{ 
		if (root == null) { 
			height.height = 0; 
			return true; 
		} 

		Height lheight = new Height(), 
		       rheight = new Height(); 

		boolean l = isBalanced(root.left, lheight); 
		boolean r = isBalanced(root.right, rheight); 

		int lh = lheight.height, 
		    rh = rheight.height; 

		height.height = (lh > rh ? lh : rh) + 1; 

		if (Math.abs(lh - rh) >= 2) 
			return false; 
		else
			return l && r; 
	} 

	public static void main(String args[]) 
	{ 
		Height height = new Height(); 

		/* Constructed binary tree is 
				1 
				/ \ 
				2	 3 
			/ \ / 
			4	 5 6 
			/ 
		7		 */
		HeightBalanced tree = new HeightBalanced(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.root.right.right = new Node(6); 
		tree.root.left.left.left = new Node(7); 

		if (tree.isBalanced(tree.root, height)) 
		// if (tree.isBalanced(tree.root)) 
			System.out.println("Tree is balanced"); 
		else
			System.out.println("Tree is not balanced"); 
	} 
} 

// This code has been contributed by Mayank Jaiswal(mayank_24) 
