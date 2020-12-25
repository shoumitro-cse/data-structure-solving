// Sum of all nodes in a binary tree

//javac -d classes SumAllElements.java  && cd classes && java SumAllElements && cd ..

class SumAllElements {

	static class Node 
	{ 
		int key; 
		Node left, right; 
	} 

	/* utility that allocates a new 
	Node with the given key */
	static Node newNode(int key) 
	{ 
		Node node = new Node(); 
		node.key = key; 
		node.left = node.right = null; 
		return (node); 
	} 

	 // Function to find sum of all the elements
	static int addBT(Node root) { 
		if (root == null) 
			return 0; 
		return (root.key + addBT(root.left) + addBT(root.right)); 
	} 

	// Driver Code 
	public static void main(String args[]) 
	{ 
		Node root = newNode(1); 

		root.left = newNode(2); 
		root.right = newNode(3); 
		
		root.left.left = newNode(4); 
		root.left.right = newNode(5); 
		
		root.right.left = newNode(6); 
		root.right.right = newNode(7); 
		
		root.right.left.right = newNode(8);

/*		  1
		/   \
	   2     3
	  / \   / \
	 4   5 6   7	  
	        \
	         8

     output: 36
	         */

		int sum = addBT(root); 
		System.out.println("Sum of all the elements is: " + sum); 
	} 
} 


