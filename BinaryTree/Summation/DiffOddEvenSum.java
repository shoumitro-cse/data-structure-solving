// difference between  sums of odd level and even level nodes of binary tree 

//javac -d classes DiffOddEvenSum.java  && cd classes && java DiffOddEvenSum && cd ..

import java.io.*; 
import java.util.*; 
// User defined node class 
class Node { 
	int data; 
	Node left, right; 
		
	// Constructor to create a new tree node 
	Node(int key) { 
		data = key; 
		left = right = null; 
	} 
} 
class DiffOddEvenSum { 
	// return difference of 
	// sums of odd level and even level 
	static int evenOddLevelDifference(Node root) { 

			if (root == null) 
				return 0; 
			// create a queue for level order traversal 
			Queue<Node> q = new LinkedList<>(); 
			q.add(root); 
			int level = 0; 
			int evenSum = 0, oddSum = 0; 
			// traverse until the queue is empty 
			while (q.size() != 0) { 
				int size = q.size(); 
				level++; 
					
				// traverse for complete level 
				while (size > 0) { 
						Node temp = q.remove(); 
						// check if level no.is even or odd and 
						// accordingly update the evenSum or oddSum 
						if (level % 2 == 0) 
							evenSum += temp.data; 
						else
							oddSum += temp.data; 
						// check for left child 
						if (temp.left != null) 
							q.add(temp.left); 
						// check for right child 
						if (temp.right != null) 
							q.add(temp.right); 
						size--; 
				} 
			} 
			return (oddSum - evenSum); 
	} 

	static int getLevelDiff(Node node)  { 
        // Base case 
        if (node == null) 
            return 0; 
        // Difference for root is root's data - difference for  
        // left subtree - difference for right subtree 
        return node.data - getLevelDiff(node.left) - getLevelDiff(node.right); 
    } 

	// Driver code 
	public static void main(String args[]) { 
			// construct a tree 
			Node root = new Node(5); 
			root.left = new Node(2); 
			root.right = new Node(6); 
			root.left.left = new Node(1); 
			root.left.right = new Node(4); 
			root.left.right.left = new Node(3); 
			root.right.right = new Node(8); 
			root.right.right.right = new Node(9); 
			root.right.right.left = new Node(7); 

			System.out.println("diffence between sums is " + getLevelDiff(root)); 
	} 
} 

/*
Difference between sums of odd level and even level nodes of a Binary Tree


Given a a Binary Tree, find the difference between the sum of nodes at odd level and 
the sum of nodes at even level. Consider root as level 1, left and right children of root 
as level 2 and so on.
For example, in the following tree, sum of nodes at odd level is (5 + 1 + 4 + 8) which is 18. 
And sum of nodes at even level is (2 + 6 + 3 + 7 + 9) which is 27. The output for following tree 
should be 18 – 27 which is -9.

      5
    /   \
   2     6
 /  \     \  
1    4     8
    /     / \ 
   3     7   9  */