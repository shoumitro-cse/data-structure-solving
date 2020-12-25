// Populate Inorder Successor for all nodes

//javac -d classes PopulateInorder.java  && cd classes && java PopulateInorder && cd ..

class Node { 
	int data; 
	Node left, right, next; 

	Node(int item) { 
		data = item; 
		left = right = next = null; 
	} 
} 

class PopulateInorder {

	Node root; 
	static Node next = null; 

   //Time Complexity: O(n)
	void populateNext(Node node) { 
		if (node != null) { 
			populateNext(node.right); 
			node.next = next; 
			next = node; 
			populateNext(node.left); 
		} 
	} 

	public static void main(String args[]) {

		PopulateInorder tree = new PopulateInorder(); 
		tree.root = new Node(10); 
		tree.root.left = new Node(8); 
		tree.root.right = new Node(12); 
		tree.root.left.left = new Node(3); 
         /*		   
	            10 
	           /   \ 
	          8     12 
	         / \
	        3   null */

		// Populates nextRight pointer in all nodes 
		tree.populateNext(tree.root); 

		// Let us see the populated values 
		Node ptr = tree.root.left.left; //3
		while (ptr != null) { 
			// -1 is printed if there is no successor 
			int print = ptr.next != null ? ptr.next.data : -1; 
			System.out.println("Next of " + ptr.data + " is: " + print); 
			ptr = ptr.next; 
		} 
	} 
} 

