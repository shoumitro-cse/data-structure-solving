// Java program for special level order traversal 

//javac -d classes SpecialLevelOrderTraversal.java  && cd classes && java SpecialLevelOrderTraversal && cd ..

import java.util.*; 

 // Class containing left and right child of current node and key value
class Node 
{ 
	int data; 
	Node left, right; 

	public Node(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

class SpecialLevelOrderTraversal { 
	Node root; 



/*   // Perfect Binary Tree Specific Level Order Traversal | Set 2
    void printSpecificLevelOrderUtil(Node root, Stack<Node> s) { 
        if (root == null) 
            return; 
        Queue<Node> q = new LinkedList<Node>(); 
        q.add(root.left); 
        q.add(root.right); 
        Node first = null, second = null; 
        // traversal loop 
        while (!q.isEmpty())  { 
            // Pop two items from queue 
            first = q.poll(); 
            second =  q.poll(); 
            // Push first and second node's chilren in reverse order 
            s.push(second.left); 
            s.push(first.right); 
            s.push(second.right); 
            s.push(first.left); 
            // If first and second have grandchildren, enqueue them in specific order 
            if (first.left.left != null) { 
                q.add(first.right); 
                q.add(second.left); 
                q.add(first.left); 
                q.add(second.right); 
            } 
        } 
    } 
  
     // Given a perfect binary tree, print its nodes in specific level order 
    // Reverse level traversal
    void printSpecificLevelOrder(Node root) { 
        //create a stack and push root 
        Stack<Node> s = new Stack<Node>(); 
        //Push level 1 and level 2 nodes in stack 
        s.push(root); 
        // Since it is perfect Binary Tree, right is not checked 
        if (root.left != null)  { 
            s.push(root.right); 
            s.push(root.left); 
        } 
        // Do anything more if there are nodes at next level in given perfect Binary Tree 
        if (root.left.left != null) 
            printSpecificLevelOrderUtil(root, s); 
        // Finally pop all Nodes from stack and prints them. 
        while (!s.empty()) { 
            System.out.print(s.peek().data + " "); 
            s.pop(); 
        } 
    } 
*/



	 // Given a perfect binary tree, print its nodes in specific level order 
	void printSpecificLevelOrder(Node node) { 
		if (node == null) 
			return; 
		// Let us print root and next level first 
		System.out.print(node.data); 
		// Since it is perfect Binary Tree, right is not checked 
		if (node.left != null) 
			System.out.print(" " + node.left.data + " " + node.right.data); 
		// Do anything more if there are nodes at next level in 
		// given perfect Binary Tree 
		if (node.left.left == null) 
			return; 
		// Create a queue and enqueue left and right children of root 
		Queue<Node> q = new LinkedList<Node>(); 
		q.add(node.left); 
		q.add(node.right); 
		// We process two nodes at a time, so we need two variables 
		// to store two front items of queue 
		Node first = null, second = null; 
		// traversal loop 
		while (!q.isEmpty()) { 
			// Pop two items from queue 
			first = q.remove(); 
			second = q.remove(); 
			// Print children of first and second in reverse order 
			System.out.print(" " + first.left.data + " " +second.right.data); 
			System.out.print(" " + first.right.data + " " +second.left.data); 
			// If first and second have grandchildren, enqueue them in reverse order 
			if (first.left.left != null) { 
				q.add(first.left); 
				q.add(second.right); 
				q.add(first.right); 
				q.add(second.left); 
			} 
		} 
	} 




	public static void main(String args[]) { 
		SpecialLevelOrderTraversal tree = new SpecialLevelOrderTraversal(); 
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
		tree.root.right.left.left = new Node(12); 
		tree.root.right.left.right = new Node(13); 
		tree.root.right.right.left = new Node(14); 
		tree.root.right.right.right = new Node(15); 

		tree.root.left.left.left.left = new Node(16); 
		tree.root.left.left.left.right = new Node(17); 
		tree.root.left.left.right.left = new Node(18); 
		tree.root.left.left.right.right = new Node(19); 
		tree.root.left.right.left.left = new Node(20); 
		tree.root.left.right.left.right = new Node(21); 
		tree.root.left.right.right.left = new Node(22); 
		tree.root.left.right.right.right = new Node(23); 
		tree.root.right.left.left.left = new Node(24); 
		tree.root.right.left.left.right = new Node(25); 
		tree.root.right.left.right.left = new Node(26); 
		tree.root.right.left.right.right = new Node(27); 
		tree.root.right.right.left.left = new Node(28); 
		tree.root.right.right.left.right = new Node(29); 
		tree.root.right.right.right.left = new Node(30); 
		tree.root.right.right.right.right = new Node(31); 

		System.out.println("Specific Level Order traversal of binary tree is "); 
		tree.printSpecificLevelOrder(tree.root); 
		System.out.println(""); 
	} 
} 



/*
output1
1 2 3 4 7 5 6 8 15 9 14 10 13 11 12 16 31 17 30 18 29 19 28 20 27 21 26 22 25 23 24

output2:
16 31 17 30 18 29 19 28 20 27 21 26 22 25 23 24 8 15 9 14 10 13 11 12 4 7 5 6 2 3 1
*/
