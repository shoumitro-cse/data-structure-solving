// Number of siblings of a given Node in n-ary Tree

//javac -d classes FindNumberOfSiblings.java  && cd classes && java FindNumberOfSiblings && cd ..

import java.util.*; 

class FindNumberOfSiblings { 
	// Represents a node of an n-ary tree 
	static class Node { 
		int key; 
		Vector<Node> child; 
		Node(int data) { 
			key = data; 
			child = new Vector<Node>(); 
		} 
	}; 
	// Function to calculate number of siblings of a given node 
	
	// Time Complexity : O(N), where N is the number of nodes in tree.
    // Auxiliary Space : O(N), where N is the number of nodes in tree.
	static int numberOfSiblings(Node root, int x) { 
		if (root == null) {
			return 0; 
		}
		// Creating a queue and pushing the root 
		Queue<Node> queue = new LinkedList<>(); 
		queue.add(root); 
		while (queue.size() > 0) { 
			// Dequeue an item from queue and 
			// check if it is equal to x If YES, then return number of children 
			Node node = queue.remove(); 
			// Enqueue all children of the dequeued item 
			for (int i = 0; i < node.child.size(); i++) { 
				// If the value of children 
				// is equal to x, then return the number of siblings 
				if (node.child.get(i).key == x) { 
					return node.child.size() - 1;
				} 
				queue.add(node.child.get(i)); 
			} 
		} 
		return -1; 
	} 

	// Driver code 
	public static void main(String args[]) 
	{ 
		// Creating a generic tree as shown in above figure 
		Node root = new Node(50); 
		
		(root.child).add(new Node(2)); 
		(root.child).add(new Node(30)); 
		(root.child).add(new Node(14)); 
		(root.child).add(new Node(60)); 
		// (root.child).add(new Node(70)); 

		(root.child.get(0).child).add(new Node(15)); 
		(root.child.get(0).child).add(new Node(25)); 
		
		(root.child.get(0).child.get(1).child).add(new Node(70)); 
		(root.child.get(0).child.get(1).child).add(new Node(100)); 
		
		(root.child.get(1).child).add(new Node(6)); 
		(root.child.get(1).child).add(new Node(1)); 
		
		(root.child.get(2).child).add(new Node(7)); 

		(root.child.get(2).child.get(0).child).add(new Node(17)); 
		(root.child.get(2).child.get(0).child).add(new Node(99)); 
		(root.child.get(2).child.get(0).child).add(new Node(27)); 
		
		(root.child.get(3).child).add(new Node(16)); 

		// Node whose number of siblings is to be calculated 
		// int x = 100; 
		int x = 30; 

		// Function calling 
		System.out.println( numberOfSiblings(root, x) ); 
	} 
} 


/*
Example :
	Input : 30
	Output : 3


Approach : For every node in the given n-ary tree, push the children of the current node
in the queue. While adding the children of current node in queue, check if any children is 
equal to the given value x or not. If yes, then return the number of siblings of x.
*/