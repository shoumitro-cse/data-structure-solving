// Foldable Binary Trees

// javac -d classes FoldableBinaryTrees.java  && cd classes && java FoldableBinaryTrees && cd ..

class Node { 
	int data; 
	Node left, right; 

	Node(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

class FoldableBinaryTrees { 

	Node root; 

/*	 // Returns true if the given tree is foldable 
	boolean isFoldable(Node node) { 
		boolean res; 
		 // base case 
		if (node == null) 
			return true; 
		 // convert left subtree to its mirror 
		mirror(node.left); 
		 // Compare the structures of the right subtree and mirrored left subtree 
		res = isStructSame(node.left, node.right); 
		 // Get the originial tree back 
		mirror(node.left); 

		return res; 
	} 

	boolean isStructSame(Node a, Node b) { 
		if (a == null && b == null) 
			return true; 
		if (a != null && b != null && isStructSame(a.left, b.left) && isStructSame(a.right, b.right)) 
			return true; 

		return false; 
	} 

	 // UTILITY FUNCTIONS 
	void mirror(Node node) { 
		if (node == null) 
			return; 
		else { 
			Node temp; 
			 // do the subtrees 
			mirror(node.left); 
			mirror(node.right); 
			 // swap the pointers in this node 
			temp = node.left; 
			node.left = node.right; 
			node.right = temp; 
		} 
	} */


	    // Returns true if the given tree can be folded 
    boolean isFoldable(Node node) { 
        if (node == null) 
            return true; 
        return IsFoldableUtil(node.left, node.right); 
    } 
  
     // A utility function that checks if trees with roots as n1 and n2 are mirror of each other 
    boolean IsFoldableUtil(Node n1, Node n2) { 
         // If both left and right subtrees are NULL, then return true 
        if (n1 == null && n2 == null) 
            return true; 
         // If one of the trees is NULL and other is not, then return false 
        if (n1 == null || n2 == null) 
            return false; 
         // Otherwise check if left and right subtrees are mirrors of their counterparts 
        return IsFoldableUtil(n1.left, n2.right) && IsFoldableUtil(n1.right, n2.left); 
    } 


	 // Driver program to test above functions 
	public static void main(String args[]) {

		FoldableBinaryTrees tree = new FoldableBinaryTrees(); 

		tree.root = new Node(1); 

		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		
		tree.root.left.right = new Node(4); 
		tree.root.right.left = new Node(5); 

        /* The constructed binary tree is 
             1 
           /   \ 
          2     3 
           \    / 
            4  5 
        */

		if (tree.isFoldable(tree.root)) 
			System.out.println("tree is foldable"); 
		else
			System.out.println("Tree is not foldable"); 
	} 
} 




/*Foldable Binary Trees

Question: Given a binary tree, find out if the tree can be folded or not.

A tree can be folded if left and right subtrees of the tree are structure 
wise mirror image of each other. An empty tree is considered as foldable.

Consider the below trees:
(a) and (b) can be folded.
(c) and (d) cannot be folded.

(a)
       10
     /    \
    7      15
     \    /
      9  11


(b)
        10
       /  \
      7    15
     /      \
    9       11

(c)
        10
       /  \
      7   15
     /    /
    5   11

(d)

         10
       /   \
      7     15
    /  \    /
   9   10  12


Algo:
1) If tree is empty, then return true.
2) Convert the left subtree to its mirror image
    mirror(root->left); 
3) Check if the structure of left subtree and right subtree is same
   and store the result.
    res = isStructSame(root->left, root->right); 
4) Revert the changes made in step (2) to get the original tree.
    mirror(root->left);
5) Return result res stored in step 2.



Method 2 (Check if Left and Right subtrees are Mirror)
There are mainly two functions:

// Checks if tree can be folded or not

IsFoldable(root)
1) If tree is empty then return true
2) Else check if left and right subtrees are structure wise mirrors of
    each other. Use utility function IsFoldableUtil(root->left,
    root->right) for this.
// Checks if n1 and n2 are mirror of each other.

IsFoldableUtil(n1, n2)
1) If both trees are empty then return true.
2) If one of them is empty and other is not then return false.
3) Return true if following conditions are met
   a) n1->left is mirror of n2->right
   b) n1->right is mirror of n2->left

   

   */