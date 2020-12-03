//Level order traversal in spiral form

// javac -d classes SpiralLevelOrderTraversal.java  && cd classes && java SpiralLevelOrderTraversal && cd ..

class Node { 
	int data; 
	Node left, right; 
	public Node(int d) { 
		data = d; 
		left = right = null; 
	} 
} 

class SpiralLevelOrderTraversal { 
	Node root; 

	int height(Node node) { 
		if (node == null) { 
			return 0; 
		} else { 
			 // compute the height of each subtree 
			int lheight = height(node.left); 
			int rheight = height(node.right); 
			 // use the larger one 
			if (lheight > rheight) 
				return (lheight + 1); 
			else
				return (rheight + 1); 
		} 
	} 

	// Function to print the spiral traversal of tree 
	void printSpiral(Node node) { 
		int h = height(node); //3
		System.out.println("height: "+h);
		boolean spiral_leve_bool = false; 
		for (int i = 1; i <= h; i++) { 
			printGivenLevel(node, i, spiral_leve_bool); 
			// Revert spiral_leve_bool to traverse next level in opposite order
			spiral_leve_bool = !spiral_leve_bool; 
		} 
	} 

	 // Print nodes at a given level 
	void printGivenLevel(Node node, int level, boolean spiral_leve_bool) {

		if (node == null) { 
			return; 
		}

		if (level == 1) { 
			System.out.print(node.data + " "); 
		} else if (level > 1) { 
			if (spiral_leve_bool == true) { 
				printGivenLevel(node.left, level-1, spiral_leve_bool); 
				printGivenLevel(node.right, level-1, spiral_leve_bool); 
			} else { 
				printGivenLevel(node.right, level-1, spiral_leve_bool); 
				printGivenLevel(node.left, level-1, spiral_leve_bool); 
			} 
		} 
	} 


	public static void main(String[] args) {

		SpiralLevelOrderTraversal tree = new SpiralLevelOrderTraversal(); 
		
		tree.root = new Node(1); 
		
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		
		tree.root.left.left = new Node(7); 
		tree.root.left.right = new Node(6); 
		
		tree.root.right.left = new Node(5); 
		tree.root.right.right = new Node(4); 
		
		System.out.println("\n\nSpiral order traversal of Binary Tree is "); 
		tree.printSpiral(tree.root); 
		System.out.println(); 
	
	} 
} 


/*
Level order traversal in spiral form

Write a function to print spiral order traversal of a tree. For below tree, 
function should print 1, 2, 3, 4, 5, 6, 7.
spiral_order


Method 1 (Recursive)
This problem can be seen as an extension of the level order traversal post.
To print the nodes in spiral order, nodes at different levels should be printed in alternating order.
An additional Boolean variable ltr is used to change printing order of levels. If ltr is 1 
then printGivenLevel() prints nodes from left to right else from right to left. 
Value of ltr is flipped in each iteration to change the order.



Function to print level order traversal of tree

printSpiral(tree)
  bool ltr = 0;
  for d = 1 to height(tree)
     printGivenLevel(tree, d, ltr);
     ltr ~= ltr /*flip ltr



Function to print all nodes at a given level

printGivenLevel(tree, level, ltr)
if tree is NULL then return;
if level is 1, then
    print(tree->data);
else if level greater than 1, then
    if(ltr)
        printGivenLevel(tree->left, level-1, ltr);
        printGivenLevel(tree->right, level-1, ltr);
    else
        printGivenLevel(tree->right, level-1, ltr);
        printGivenLevel(tree->left, level-1, ltr);

        
*/