//print all nodes that don't have sibling 

// javac -d classes PrintdonotHaveSibling.java  && cd classes && java PrintdonotHaveSibling && cd .. 

class Node 
{ 
	int data; 
	Node left, right; 

	Node(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

class PrintdonotHaveSibling 
{ 
	Node root; 
	
	// Function to print all non-root nodes that don't have a sibling 
	void printSingles(Node node) { 
		// Base case 
		if (node == null) 
		  return; 
		// If this is an internal node, recur for left and right subtrees 
		if (node.left != null && node.right != null) { 
			printSingles(node.left); 
			printSingles(node.right); 
		} else if (node.right != null) { 
			System.out.print(node.right.data + " "); 
			printSingles(node.right); 
		} else if (node.left != null) { 
			System.out.print( node.left.data + " "); 
			printSingles(node.left); 
		} 
	} 
	// Driver program to test the above functions 
	public static void main(String args[]) {

		PrintdonotHaveSibling tree = new PrintdonotHaveSibling(); 
		 // Let us construct the tree shown in above diagram 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.right = new Node(4); 
		tree.root.right.left = new Node(5); 
		tree.root.right.left.right = new Node(6); 

/*		   1
		/    \
       2      3
        \    /
         4  5
           /
          6*/
		
		tree.printSingles(tree.root); 
		System.out.println(); 
	} 
} 


/*
Print all nodes that don’t have sibling

Given a Binary Tree, print all nodes that don’t have a sibling 
(a sibling is a node that has same parent. In a Binary Tree, 
	there can be at most one sibling). Root should not be printed as root cannot have a sibling.

For example, the output should be “4 5 6” for the following tree.

		   1
		/    \
       2      3
        \    /
         4  5
           /
          6       */