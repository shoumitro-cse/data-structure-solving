// Java Program to find diagonal sum in a Binary Tree

// javac -d classes DiagonalSum.java  && cd classes && java DiagonalSum && cd ..

import java.util.*;
import java.util.Map.Entry;

//Tree node
class TreeNode {
	int data; //node data
	int vd; //vertical distance diagonally
	TreeNode left, right; //left and right child's reference
	// Tree node constructor
	public TreeNode(int data) {
		this.data = data;
		vd = Integer.MAX_VALUE;
		left = right = null;
	}
}

// Tree class
class Tree {

	TreeNode root;//Tree root

	// Tree constructor
	public Tree(TreeNode root) { 
		this.root = root; 
	}

	// Diagonal sum method
	public void diagonalSum() {
		// Queue which stores tree nodes
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		// Map to store sum of node's data lying diagonally
		Map<Integer, Integer> map = new TreeMap<>();
		// Assign the root's vertical distance as 0.
		root.vd = 0;//vertical distance diagonally
		// Add root node to the queue
		queue.add(root);
		// Loop while the queue is not empty
		while (!queue.isEmpty()) {
			// Remove the front tree node from queue.
			TreeNode curr = queue.remove();
			// Get the vertical distance of the dequeued node.
			int vd = curr.vd;
			// Sum over this node's right-child, right-of-right-child and so on
			while (curr != null) {
				int prevSum = (map.get(vd) == null)? 0: map.get(vd);
				map.put(vd, prevSum+curr.data);
				// If for any node the left child is not null add
				// it to the queue for future processing.
				if (curr.left != null) {
					curr.left.vd = vd+1;
					queue.add(curr.left);
				}
				// Move to the current node's right child.
				curr = curr.right;
			}
		}
		// Make an entry set from map.
		Set<Entry<Integer, Integer>> set = map.entrySet();
		// Make an iterator
		Iterator<Entry<Integer, Integer>> iterator = set.iterator();
		// Traverse the map elements using the iterator.
		System.out.print("\n\nDiagonal sum in a binary tree is - ");
		while (iterator.hasNext()) {
			Map.Entry<Integer, Integer> me = iterator.next();
			System.out.print(me.getValue()+" ");
		}
		System.out.println(" ");
	}
}

//Driver class
public class DiagonalSum {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		root.right.left.left = new TreeNode(12);
		root.right.left.right = new TreeNode(7);
		root.left.right.left = new TreeNode(11);
		root.left.left.right = new TreeNode(10);

		/*               1 
		             /     \
		           2         3
		         /   \      / \
		       9     6     4   5
		        \   /     / \
		        10 11     12 7  */

		Tree tree = new Tree(root);
		tree.diagonalSum();

	}
}


/*Diagonal Sum of a Binary Tree

Consider lines of slope -1 passing between nodes (dotted lines in below diagram). 
The diagonal sum in a binary tree is the sum of all node’s data lying between these lines. 
Given a Binary Tree, print all diagonal sums.
For the following input tree, the output should be 9, 19, 42. 
9 is sum of 1, 3 and 5. 
19 is sum of 2, 6, 4 and 7. 
42 is sum of 9, 10, 11 and 12.
 

               1 
             /     \
           2         3
         /   \      / \
       9     6     4   5
        \   /     / \
        10 11     12 7*/