// Level Order Binary Tree Traversal

//javac -d classes LevelOrderBinaryTreeTraversal.java  && cd classes && java LevelOrderBinaryTreeTraversal && cd ..

 // Class containing left and right child of current node and key value

import java.util.*; 

class Node {
	int data;
	Node left, right;
	public Node(int item) {
		data = item;
		left = right = null;
	}
}

class BinaryTree {
	// Root of the Binary Tree
	Node root;
	public BinaryTree() {
		root = null;
	}


	/* Compute the "height" of a tree -- the number of
	nodes along the longest path from the root node
	down to the farthest leaf node.*/
	int height(Node root) {

		if (root == null) {
		    return 0;
		} else {
			 // compute height of each subtree 
			int left_height = height(root.left);
			int right_height = height(root.right);
			 // use the larger one 
			if (left_height > right_height) {
				return left_height+1;
			} else { 
				return right_height+1;
			} 
		}
	}

	/* Print nodes at the given level */
	void printGivenLevel (Node root ,int level) {

		if (root == null) {
			return;
		}

		if (level == 1) {
			System.out.print(root.data + " ");
		} else if (level > 1) {
			printGivenLevel(root.left, level-1);
			printGivenLevel(root.right, level-1);
		}
	}


/*	Time Complexity: O(n^2) in worst case. For a skewed tree, printGivenLevel() takes O(n) 
	time where n is the number of nodes in the skewed tree.
	So time complexity of printLevelOrder() is O(n) + O(n-1) + O(n-2) + .. + O(1) which is O(n^2). 
    Space Complexity: O(n) in worst case. For a skewed tree, 
    printGivenLevel() uses O(n) space for call  
   stack. For a Balanced tree, call stack uses O(log n) space, (i.e., height of the balanced tree). */
	

	
/*	 // function to print level order traversal of tree
	void printLevelOrder() {

		int h = height(root);
		System.out.println("height: "+h);// height=3
		int level;
		
		for (level=1; level<=h; level++) {
			printGivenLevel(root, level); // 1, 2, 3
		}

	}
*/


    // using queue
    // Time Complexity: O(n) where n is number of nodes in the binary tree 
// Space Complexity: O(n) where n is number of nodes in the binary tree 
	void printLevelOrder() {

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
 
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
 
            // Enqueue left child 
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
 
            // Enqueue right child 
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
 

}

class LevelOrderBinaryTreeTraversal {

	 // Driver program to test above functions 
	public static void main(String args[]) {

		BinaryTree tree = new BinaryTree();
		tree.root= new Node(1);

		tree.root.left= new Node(2);
		tree.root.right= new Node(3);
		
		tree.root.left.left= new Node(4);
		tree.root.left.right= new Node(5);
			
		System.out.println("\n\nLevel order traversal of binary tree is ");
		tree.printLevelOrder();
		System.out.println();
	}

}


/*
Method 2 (Using queue)

Algorithm: 
For each node, first the node is visited and then it’s child nodes are put in a FIFO queue. 

printLevelorder(tree)
1) Create an empty queue q
2) temp_node = root //start from root
3) Loop while temp_node is not NULL
    a) print temp_node->data.
    b) Enqueue temp_node’s children 
      (first left then right children) to q
    c) Dequeue a node from q.*/