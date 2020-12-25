// Java program to insert element in binary tree

//javac -d classes InserElement.java  && cd classes && java InserElement && cd ..

import java.util.LinkedList;
import java.util.Queue;

public class InserElement {

	 // A binary tree node has key, pointer to left child and a pointer to right child 
	static class Node {
		int key;
		Node left, right;

		// constructor
		Node(int key)
		{
			this.key = key;
			left = null;
			right = null;
		}
	}
	static Node root;
	static Node temp = root;

	 // Inorder traversal of a binary tree
	static void inorder(Node temp)
	{
		if (temp == null)
			return;

		inorder(temp.left);
		System.out.print(temp.key + " ");
		inorder(temp.right);
	}

	// function to insert element in binary tree 
	static void insert(Node temp, int key) {

		if (temp == null) {
			root = new Node(key);
			return;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(temp);

		// Do level order traversal until we find an empty place.
		while (!q.isEmpty()) {
			temp = q.remove();

			if (temp.left == null) {
				temp.left = new Node(key);
				break;
			} else {
				q.add(temp.left);
			}

			if (temp.right == null) {
				temp.right = new Node(key);
				break;
			} else {
				q.add(temp.right);
			}
		}
	}


	public static void main(String args[]) {

		root = new Node(10);

		root.left = new Node(11);
		root.right = new Node(9);

		root.left.left = new Node(7);

		root.right.left = new Node(15);
		root.right.right = new Node(8);

		/*Input	  10
				/    \
		       11     9
		      /  \   / \
		     7      15  8 */

		System.out.print("\n\nInorder traversal before insertion:");
		inorder(root);

		int key = 12;
		insert(root, key);

		System.out.print("\nInorder traversal after insertion:");
		inorder(root);
		System.out.print("\n");

		/*Output    10
				 /     \
		        11      9
		      /  \     / \
		     7    12  15  8 */

	}
}
