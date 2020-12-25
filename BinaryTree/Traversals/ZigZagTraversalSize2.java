// Java program to print Zig-Zag traversal in groups of size 2. 
//Level order traversal with direction change after every two levels


//javac -d classes ZigZagTraversalSize2.java  && cd classes && java ZigZagTraversalSize2 && cd ..

import java.util.*; 

class ZigZagTraversalSize2 { 

	static class Node { 
		Node left; 
		int data; 
		Node right; 
	}; 

	// Utility function to create a new tree node 
	static Node newNode(int data) { 
		Node temp = new Node(); 
		temp.data = data; 
		temp.left = temp.right = null; 
		return temp; 
	} 

	static void modifiedLevelOrder(Node node) { 
		// For null root 
		if (node == null) 
			return; 
		if (node.left == null && node.right == null) { 
			System.out.print(node.data); 
			return; 
		} 

		Queue<Node> myQueue = new LinkedList<>(); 
		Stack<Node> myStack = new Stack<>(); 
		Node temp = null; 
		int sz; 
		int ct = 0; 

		boolean rightToLeft = false; 
		// Push root node to the queue 
		myQueue.add(node); 
		// Run this while loop till queue got empty 
		while (!myQueue.isEmpty()) { 
			ct++; 
			sz = myQueue.size(); 
			// Do a normal level order traversal 
			for (int i = 0; i < sz; i++) { 
				temp = myQueue.remove(); 

				if (rightToLeft == false) {
					System.out.print(temp.data + " ");		 
				} else{
					myStack.push(temp);		 
				}

				if (temp.left != null) 
					myQueue.add(temp.left); 

				if (temp.right != null) 
					myQueue.add(temp.right); 
			} 

			if (rightToLeft == true) { 

				while (!myStack.isEmpty()) { 
					temp = myStack.pop(); 
					System.out.print(temp.data + " "); 
				} 
			} 
			if (ct == 2) { 
				rightToLeft = !rightToLeft; 
				ct = 0; 
			} 

			System.out.print("\n"); 
		} 
	} 


	// Driver Code 
	public static void main(String[] args) {

		// Let us create binary tree 
		Node root = newNode(1); 
		root.left = newNode(2); 
		root.right = newNode(3); 
		root.left.left = newNode(4); 
		root.left.right = newNode(5); 
		root.right.left = newNode(6); 
		root.right.right = newNode(7); 
		root.left.left.left = newNode(8); 
		root.left.left.right = newNode(9); 
		root.left.right.left = newNode(3); 
		root.left.right.right = newNode(1); 
		root.right.left.left = newNode(4); 
		root.right.left.right = newNode(2); 
		root.right.right.left = newNode(7); 
		root.right.right.right = newNode(2); 
		root.left.right.left.left = newNode(16); 
		root.left.right.left.right = newNode(17); 
		root.right.left.right.left = newNode(18); 
		root.right.right.left.right = newNode(19); 

	/*		    1     
	          /   \
	        2       3
	      /  \     /  \
	     4    5    6    7
	    / \  / \  / \  / \ 
	   8  9 3   1 4  2 7  2
	     /     / \    \
	    16    17  18   19  */

		modifiedLevelOrder(root); 
	} 
} 




/*Level order traversal with direction change after every two levels


Given a binary tree, print the level order traversal in such a way that first two 
levels are printed from left to right, next two levels are printed from right to left, 
then next two from left to right and so on. So, the problem is to reverse the direction 
of level order traversal of binary tree after every two levels.
Examples: 

Input: 
            1     
          /   \
        2       3
      /  \     /  \
     4    5    6    7
    / \  / \  / \  / \ 
   8  9 3   1 4  2 7  2
     /     / \    \
    16    17  18   19
Output:
1
2 3
7 6 5 4
2 7 2 4 1 3 9 8
16 17 18 19
In the above example, first two levels
are printed from left to right, next two
levels are printed from right to left,
and then last level is printed from 
left to right.*/