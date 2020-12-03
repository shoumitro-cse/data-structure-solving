//Java program to do level order traversal line by line 
//Level order traversal line by line | Set 2 (Using Two Queues)

//javac -d classes LevelOrderTraversal.java  && cd classes && java LevelOrderTraversal && cd ..

import java.util.LinkedList; 
import java.util.Queue; 

public class LevelOrderTraversal {

	static class Node { 
		int data; 
		Node left; 
		Node right; 
		Node(int data) { 
			this.data = data; 
			left = null; 
			right = null; 
		} 
	} 

	// Prints level order traversal line by line using two queues. 
	//Time Complexity : O(n)
	static void levelOrder(Node root) {
		Queue<Node> q1 = new LinkedList<Node>(); 
		Queue<Node> q2 = new LinkedList<Node>(); 
		if (root == null) 
			return; 
		// Pushing first level node into first queue 
		q1.add(root); 
		// Executing loop till both the queues become empty 
		while (!q1.isEmpty() || !q2.isEmpty()) { 

			while (!q1.isEmpty()) { 
				if (q1.peek().left != null) {
					q2.add(q1.peek().left); 
				}
				if (q1.peek().right != null) {
					q2.add(q1.peek().right); 
				}
				System.out.print(q1.poll().data + " "); 
			} 
			System.out.println(); 

			while (!q2.isEmpty()) { 
				if (q2.peek().left != null) {
					q1.add(q2.peek().left); 
				}
				if (q2.peek().right != null) {
					q1.add(q2.peek().right); 
				}
				System.out.print(q2.poll().data + " "); 
			} 
			System.out.println(); 
		} 
	} 

	public static void main(String[] args) { 

		Node root = new Node(1); 

		root.left = new Node(2); 
		root.right = new Node(3); 
		
		root.left.left = new Node(4); 
		root.left.right = new Node(5); 
		
		root.right.right = new Node(6); 

		levelOrder(root); 
	} 
} 
