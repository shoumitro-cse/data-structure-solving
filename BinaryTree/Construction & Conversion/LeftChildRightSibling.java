// Creating a tree with Left-Child Right-Sibling Representation

// javac -d classes LeftChildRightSibling.java  && cd classes && java LeftChildRightSibling && cd ..

class LeftChildRightSibling { 
	
	static class Node 
	{ 
		int data; 
		Node next, child; 
		public Node(int data) 
		{ 
			this.data = data; 
			next = child = null; 
		} 
	} 
	
	// Adds a sibling to a list with starting with n 
	static public Node addSibling(Node node, int data) 
	{ 
		if(node == null) 
			return null; 
		while(node.next != null) 
			node = node.next; 
		return node.next = new Node(data); 
	} 
		
	// Add child Node to a Node 
	static public Node addChild(Node node, int data) 
	{ 
		if(node == null) 
			return null; 
	
		// Check if child is not empty. 
		if(node.child != null) 
			return (addSibling(node.child, data)); 
		else
			return node.child = new Node(data); 
	} 

	// Traverses tree in depth first order 
	static public void traverseTree(Node root) 
	{ 
		if(root == null) 
			return; 

		while(root != null) { 

			System.out.print(root.data + " "); 

			if(root.child != null) 
				traverseTree(root.child); 

			root = root.next; 
		} 

	} 

	// Driver code 
	public static void main(String args[]) 
	{ 
		

		Node root = new Node(10); 

		Node n1 = addChild(root, 2); 
		Node n2 = addChild(root, 3);
		Node n3 = addChild(root, 4); 

		Node n4 = addChild(n3, 6); 

		Node n5 = addChild(root, 5); 

		Node n6 = addChild(n5, 7); 
		Node n7 = addChild(n5, 8); 
		Node n8 = addChild(n5, 9); 
		
		/* Let us create below tree 
		 	   10 
		 	 / / \ \ 
		    2 3	 4  5 
	     		 | / | \ 
	     		 6 7 8 9 */
	
	// Left child right sibling 
	/*   10 
		  | 
		  2 -> 3 -> 4 -> 5 
					 |    | 
					 6    7 -> 8 -> 9 */

		System.out.println("\n"); 
		traverseTree(root); 
		System.out.println(" "); 
	} 
} 


/*
Creating a tree with Left-Child Right-Sibling Representation

Left-Child Right-Sibling Representation is a different representation of an n-ary tree 
where instead of holding a reference to each and every child node, a node holds just two 
references, first a reference to it’s first child, and the other to it’s immediate next sibling. 
This new transformation not only removes the need of advance knowledge of the number of children 
a node has, but also limits the number of references to a maximum of two, thereby making it so 
much easier to code.

At each node, link children of same parent from left to right.
Parent should be linked with only first child.
Examples:

Left Child Right Sibling tree representation

      10->null <--- next
      |<---child  
      2 -> 3 -> 4 -> 5
			    |    |  
			    6    7 -> 8 -> 9*/