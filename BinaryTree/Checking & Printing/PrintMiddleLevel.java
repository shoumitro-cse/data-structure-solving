//Print middle level of perfect binary tree without finding height

// /javac -d classes PrintMiddleLevel.java  && cd classes && java PrintMiddleLevel && cd ..

class Node {

	public int key;
	public Node left;
	public Node right;

	public Node(int val) {
		this.left = null;
		this.right = null;
		this.key = val;
	}
}

public class PrintMiddleLevel {

	// Takes two parameters - same initially and calls recursively
	private static void printMiddleLevelUtil(Node a, Node b) {
		// Base case e
		if (a == null || b == null)
			return;
		// Fast pointer has reached the leaf so print value at slow pointer
		if ((b.left == null) && (b.right == null)) {
			System.out.print(a.key + " ");
			return;
		}

		if (b.left.left != null) { // work like fast pointer
			printMiddleLevelUtil(a.left, b.left.left);
			printMiddleLevelUtil(a.right, b.left.left);
		} else { // work like slow pointer
			printMiddleLevelUtil(a.left, b.left);
			printMiddleLevelUtil(a.right, b.left);
		}
	}

	// Main printing method that take a Tree as input
	public static void printMiddleLevel(Node node) {
		printMiddleLevelUtil(node, node);
	}

	// Driver code
	public static void main(String[] args)
	{
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);

		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n1.left = n2;
		n1.right = n3;

	/*		    1
			  /   \
	         2     3 <--- print level
	        / \   / \
	       6   7 8   9*/


		System.out.print("\n\n\n");
		printMiddleLevel(n1);
		System.out.print("\n");
	}
}


/*
The idea is similar to method 2 of finding middle of singly linked list.
Use fast and slow (or tortoise) pointers in each route of the tree. 

1. Advance fast pointer towards leaf by 2.
2.  Advance slow pointer towards lead by 1.
3. If fast pointer reaches the leaf print value at the slow pointer
4. Check if the fast->left->left exists, then recursively move slow pointer by one step and fast pointer by two steps.
5. If the fast->left->left doesn’t exist (in case of even number of levels), the move both the pointers by one step.
  filter_none
*/