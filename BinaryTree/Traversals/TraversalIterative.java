//Tree Traversal without Recursion

//javac -d classes TraversalIterative.java  && cd classes && java TraversalIterative && cd ..

import java.util.Stack; 

 // Class containing left and right child of current node and key value
class Node { 
	int data; 
	Node left, right; 
	public Node(int item) { 
		data = item; 
		left = right = null; 
	} 
} 

/* Class to print the inorder traversal */
class TraversalIterative {
	Node root; 

	// Time Complexity: O(n)
	// Inorder Tree Traversal without Recursion
	void inorder() { 
		if (root == null) {
			return; 
		}
		Stack<Node> s = new Stack<Node>(); 
		Node curr = root; 
		// traverse the tree 
		while (curr != null || s.size() > 0) { 
			while (curr != null) { 
				s.push(curr); 
				curr = curr.left; 
			} 
			curr = s.pop(); 
			System.out.print(curr.data + " "); 
			curr = curr.right; 
		} 
	} 


// Inorder Tree Traversal without recursion and without stack!
	// Time Complexity : O(n) 
    void MorrisTraversal() {

        Node current, pre;
        if (root == null){
            return;
        }

        current = root;
        while (current != null) {

            if (current.left == null) {

                System.out.print(current.data + " ");
                current = current.right;

            } else {

                pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                } 
            }

        }


    }

	public static void main(String args[]) { 

		TraversalIterative tree = new TraversalIterative(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 

	/*          1 
	          /   \ s
	         2     3 
	       /  \ 
	      4    5   */

		// tree.inorder(); 
		tree.MorrisTraversal(); 
		System.out.println(""); 

	} 
} 



/*
Inorder Tree Traversal without recursion and without stack! 
Using Morris Traversal, we can traverse the tree without using stack and recursion.
The idea of Morris Traversal is based on Threaded Binary Tree. In this traversal, 
we first create links to Inorder successor and print the data using these links, 
and finally revert the changes to restore original tree. 

1. Initialize current as root 
2. While current is not NULL
   If the current does not have left child
      a) Print current’s data
      b) Go to the right, i.e., current = current->right
   Else
      a) Find rightmost node in current left subtree OR
              node whose right child == current.
         If we found right child == current
             Go to the right, i.e. current = curent->right
         Else
             a) Make current as the right child of that rightmost 
                node we found; and 
             b) Go to this left child, i.e., current = current->left*/