//Create a Doubly Linked List from a Ternary Tree
// javac -d classes DoublyListFromTernaryTree.java  && cd classes && java DoublyListFromTernaryTree && cd ..

class Tree 
{ 
	int data; 
	Tree left, middle, right; 
	public Tree(int data) { 
		this.data = data; 
		left = middle = right = null; 
	} 
} 

class DoublyListFromTernaryTree { 
	
	//tail of the linked list. 
	static Tree tail; 

	//function to push the node to the tail. 
	public static void push(Tree node) { 
		//to put the node at the end of the already existing tail. 
		tail.right = node;				 
		//to point to the previous node. 
		node.left = tail;		 
		// middle pointer should point to nothing so null. initiate right pointer to null. 
		node.middle = node.right = null; 
		//update the tail position. 
		tail = node;			 
	} 
	
	/* Create a doubly linked list out of given a ternary tree. 
	by traversing the tree in preoder fashion. */
	public static void ternaryTree(Tree root) { 

		if(root == null) return;					 
		
		Tree left = root.left; 
		Tree middle = root.middle; 
		Tree right = root.right;
        
        if(tail != root)
		  push(root);		

		ternaryTree(left);		 
		ternaryTree(middle); 
		ternaryTree(right); 

	/*	already root is in the tail so dont push 
		the root when it was root.In the first 
		case both root and tail have root in them. */
		// if(tail != root) {
			// System.out.println(tail.data+" "+root.data);
			// push(root);			 
		// }		
		// First the left child is to be taken. Then middle and then right child. 
		// ternaryTree(left);		 
		// ternaryTree(middle); 
		// ternaryTree(right); 
	} 

	//function to initiate the list process. 
	public static Tree startTree(Tree root) { 
		//Initiate the tail with root. 
		tail = root; 
		ternaryTree(root); 
		return root;		 
	} 
	
	// Utility function for printing double linked list. 
	public static void printList(Tree head) 
	{ 
		System.out.print("Created Double Linked list is:\n"); 
		while(head != null) 
		{ 
			System.out.print(head.data + " "); 
			head = head.right; 
		} 
		System.out.print("\n"); 
	} 
	
	// Driver program to test above functions 
	public static void main(String args[]) 
	{ 
		
		// Construting ternary tree as shown in above figure 
		Tree root = new Tree(30); 

		root.left = new Tree(5); 
		root.middle = new Tree(11); 
		root.right = new Tree(63); 

		root.left.left = new Tree(1); 
		root.left.middle = new Tree(4); 
		root.left.right = new Tree(8); 

		root.middle.left = new Tree(6); 
		root.middle.middle = new Tree(7); 
		root.middle.right = new Tree(15); 

		root.right.left = new Tree(31); 
		root.right.middle = new Tree(55); 
		root.right.right = new Tree(65); 


		/*   
		        30
		     /   |   \
		   5    11     63
		 / | \  /| \  / | \   
        1  4 8 6 7 15 31 55 65 
		                       */

		
		// The function which initiates the list 
		// process returns the head. 
		Tree head = startTree(root);		 
		printList(head); 
	} 
} 



/*
Create a Doubly Linked List from a Ternary Tree
Given a ternary tree, create a doubly linked list out of it. A ternary tree is just like binary 
tree but instead of having two nodes, it has three nodes i.e. left, middle, right.

The doubly linked list should holds following properties –

Left pointer of ternary tree should act as prev pointer of doubly linked list.
Middle pointer of ternary tree should not point to anything.
Right pointer of ternary tree should act as next pointer of doubly linked list.
Each node of ternary tree is inserted into doubly linked list before its 
subtrees and for any node, its left child will be inserted first, followed 
by mid and right child (if any).
For the above example, the linked list formed for below tree should be 
NULL <- 30 <-> 5 <-> 1 <-> 4 <-> 8 <-> 11 <-> 6 <-> 7 <-> 15 <-> 63 <-> 31 <-> 55 <-> 65 -> NULL
*/