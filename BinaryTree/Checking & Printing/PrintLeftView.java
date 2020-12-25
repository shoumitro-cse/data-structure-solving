//print left view of binary tree

// javac -d classes PrintLeftView.java  && cd classes && java PrintLeftView && cd ..  
import java.util.*;

class Node {
	int data;
	Node left, right;

	public Node(int item)
	{
		data = item;
		left = right = null;
	}
}

 // Class to print the left view 
class PrintLeftView {

	Node root;
	static int max_level = 0;

	// recursive function to print left view
	void leftViewUtil(Node node, int level){
		// Base Case
		if (node == null)
			return;
		// If this is the first node of its level
		if (max_level < level) {
			System.out.print(node.data+" ");
			max_level = level;
		}
		// for left view
		leftViewUtil(node.left, level + 1);
		leftViewUtil(node.right, level + 1);		

		// for right view
/*		leftViewUtil(node.right, level + 1);
		leftViewUtil(node.left, level + 1);*/
	}

	// A wrapper over leftViewUtil()
	void leftView() {
		leftViewUtil(root, 1);
	}


   // Time Complexity: is O(n).
    private static void printLeftViewIterative(Node root) {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
 
        while (!queue.isEmpty()) {
            // number of nodes at current level
            int n = queue.size();
            // Traverse all nodes of current level
            for (int i = 0; i < n; i++) {
                Node temp = queue.poll();
                // Print the left most element at the level
                // if (i == n-1)// for right view
                if (i == 0)//for left view
                    System.out.print(temp.data + " ");
                // Add left node to queue
                if (temp.left != null)
                    queue.add(temp.left);
                // Add right node to queue
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
    }
 

	public static void main(String args[]) {

		 // creating a binary tree and entering the nodes 
		PrintLeftView tree = new PrintLeftView();
		tree.root = new Node(12);
		tree.root.left = new Node(10);
		tree.root.right = new Node(30);
		tree.root.right.left = new Node(25);
		tree.root.right.right = new Node(40);

		/*		 12
				/  \
		      10    30
		            / \
		           25  40  */
 
		System.out.println("\n\nRecursive: ");
		tree.leftView();

		System.out.println("\nIterative: ");
		tree.printLeftViewIterative(tree.root);
		System.out.println("");
	}
}

 // Time Complexity: O( n ), where n is the number of nodes in the binary tree.


/*
Print Left View of a Binary Tree

Given a Binary Tree, print left view of it. Left view of a Binary Tree 
is set of nodes visible when tree is visited from left side.
 

left-view Examples: 

input:
			     12
				/  \
			  10    30
			        / \
			       25  40 
output: 12 10 25         

Input : 
                 1
               /   \
              2     3
             / \     \
            4   5     6             
Output : 1 2 4

Input :
        1
      /   \
    2       3
      \   
        4  
          \
            5
             \
               6
Output :1 2 4 5 6
*/