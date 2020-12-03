// ZigZag Tree Traversal

 //javac -d classes ZigzagOrderTraversal.java  && cd classes && java ZigzagOrderTraversal && cd ..

import java.util.*; 

// Binary Tree node 
class Node {

	int data; 
	Node left; 
	Node right;

	Node(int data) { 
		this.data = data; 
	} 
} 

class BinaryTree { 

	Node root; 

	// function to print the zigzag traversal 
	
	// Time Complexity: O(n)
    // Space Complexity: O(n)+(n)=O(n)
	void printZigZagTraversal() { 
		// if null then return 
		if (root == null) { 
		   return; 
		} 
		// declare two stacks 
		Stack<Node> currentLevel = new Stack<>(); 
		Stack<Node> nextLevel = new Stack<>(); 
		// push the root 
		currentLevel.push(root); 
		boolean leftToRight = true; 
		// check if stack is empty 
		while (!currentLevel.isEmpty()) { 
			// pop out of stack 
			Node node = currentLevel.pop(); 
			// print the data in it 
			System.out.print(node.data + " "); 
			// store data according to current order. 
			if (leftToRight) { 

				if (node.left != null) { 
				   nextLevel.push(node.left); 
				} 
				if (node.right != null) { 
				   nextLevel.push(node.right); 
				} 

			} else { 

				if (node.right != null) { 
				   nextLevel.push(node.right); 
				} 
				if (node.left != null) { 
				   nextLevel.push(node.left); 
				} 
			} 

			if (currentLevel.isEmpty()) { 
				leftToRight = !leftToRight; 
				//swap two stack
				Stack<Node> temp = currentLevel; 
				currentLevel = nextLevel; 
				nextLevel = temp; 
			} 
		} 
	} 


} 



public class ZigzagOrderTraversal { 

	// driver program to test the above function 
	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree(); 
	
		tree.root = new Node(1); 
	
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
	
		tree.root.left.left = new Node(7); 
		tree.root.left.right = new Node(6); 
		
		tree.root.right.left = new Node(5); 
		tree.root.right.right = new Node(4); 

		System.out.println("ZigZag Order traversal of binary tree is"); 
		tree.printZigZagTraversal(); 
		System.out.println(); 
	} 
} 

/*ZigZag Tree Traversal

Write a function to print ZigZag order traversal of a binary tree. 
For the below binary tree the zigzag order traversal will be 1 3 2 7 6 5 4


solution.

This problem can be solved using two stacks. Assume the two stacks are current: 
currentlevel and nextlevel. We would also need a variable to keep track of the current level 
order(whether it is left to right or right to left). We pop from the currentlevel stack and 
print the nodes value. Whenever the current level order is from left to right, push the nodes 
left child, then its right child to the stack nextlevel. Since a stack is a LIFO(Last-In-First_out) 
structure, next time when nodes are popped off nextlevel, it will be in the reverse order. 
On the other hand, when the current level order is from right to left, we would push the nodes 
right child first, then its left child. Finally, do-not forget to swap those two stacks at the end 
of each level(i.e., when current level is empty)

*/