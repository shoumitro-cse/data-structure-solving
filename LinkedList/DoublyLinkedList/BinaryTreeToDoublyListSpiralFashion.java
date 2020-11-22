//Java program to convert Binary Tree into Doubly Linked List where the nodes are represented spirally 
//Convert a Binary Tree into Doubly Linked List in spiral fashion

//javac -d classes BinaryTreeToDoublyListSpiralFashion.java  && cd classes && java BinaryTreeToDoublyListSpiralFashion && cd ..

import java.util.*; 

class Node {
	int data; 
	Node left, right; 
	public Node(int data) { 
		this.data = data; 
		left = right = null; 
	} 
} 

class BinaryTreeToDoublyListSpiralFashion {

	Node root; 
	Node head; 

	 // Given a reference to a node, inserts the node on the front of the list. 
	void push_list(Node node) { 
		// Make right of given node as head and left as NULL 
		node.right = head; 
		node.left = null; 
		// change left of head node to given node 
		if (head != null) 
			head.left = node; 
		// move the head to point to the given node 
		head = node; 
	} 

	// Function to prints contents of DLL 
	void printList(Node node) { 
		while (node != null) { 
			System.out.print(node.data + " "); 
			node = node.right; 
		} 
	} 

	/* Function to print corner node at each level */
	void spiralLevelOrder(Node root) { 
		// Base Case 
		if (root == null) return; 
		// Create an empty deque for doing spiral level order traversal and enqueue root 
		Deque<Node> q = new LinkedList<Node>(); 
		q.addFirst(root); 
		// create a stack to store Binary Tree nodes to insert into DLL later 
		Stack<Node> stack = new Stack<Node>(); 
		int level = 0; 
		while (!q.isEmpty()) {                 
			// nodeCount indicates number of Nodes at current level. 
			int nodeCount = q.size(); 
			// Dequeue all Nodes of current level and Enqueue all Nodes of next level 
			if (level%2 != 0) { //odd level 

				while (nodeCount > 0) { 
					// dequeue node from front & push it to stack 
					Node node = q.peekFirst(); 
					q.pollFirst(); 
					stack.push(node); 
					// insert its left and right children in the back of the deque 
					if (node.left != null) 
						q.addLast(node.left); 
					if (node.right != null) 
						q.addLast(node.right); 
					nodeCount--; 
				} 
			} else { //even level 

				while (nodeCount > 0) { 
					// dequeue node from the back & push it to stack 
					Node node = q.peekLast(); 
					q.pollLast(); 
					stack.push(node); 
					// inserts its right and left children in the front of the deque 
					if (node.right != null) 
						q.addFirst(node.right); 
					if (node.left != null) 
						q.addFirst(node.left); 
					nodeCount--; 
				} 
			} 
			level++; 
		} 

		// pop all nodes from stack and push them in the beginning of the list 
		while (!stack.empty()) { 
			push_list(stack.peek()); 
			stack.pop(); 
		} 

	} 

	// Driver program to test above functions 
	public static void main(String[] args) 
	{ 
		// Let us create binary tree as shown in above diagram 
		BinaryTreeToDoublyListSpiralFashion tree = new BinaryTreeToDoublyListSpiralFashion(); 

		tree.root = new Node(1); 

		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 

		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 

		tree.root.right.left = new Node(6); 
		tree.root.right.right = new Node(7); 

		tree.root.left.left.left = new Node(8); 
		tree.root.left.left.right = new Node(9); 

		tree.root.left.right.left = new Node(10); 
		tree.root.left.right.right = new Node(11); 

		// tree.root.right.left.left = new Node(12); 
		tree.root.right.left.right = new Node(13); 

		tree.root.right.right.left = new Node(14); 
		// tree.root.right.right.right = new Node(15); 

/*		       1      level=0
            /     \
           2        3     level=1
          / \     /    \
         4   5    6     7   level=2
	    / \  /\    \   /
       8  9 10 11  13 14      level=3 */

		tree.spiralLevelOrder(tree.root); 

		System.out.println("Created DLL is : "); 
		tree.printList(tree.head); 
		System.out.println(); 
	} 
} 



/*

Convert a Binary Tree into Doubly Linked List in spiral fashion

		       1      level=0
            /     \
           2        3     level=1
          / \     /    \
         4   5    6     7   level=2
	    / \  /\    \   /
       8  9 10 11  13 14      level=3 

output spiral fashion list: 1 2 3 7 6 5 4 8 9 10 11 13 14 

For example, for the tree on left side, Doubly Linked List can be,s
1 2 3 7 6 5 4 8 9 10 11 13 14   or   1 3 2 4 5 6 7 14 13 11 10 9 8.
*/
