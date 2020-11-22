//Convert a Binary Tree to a Circular Doubly Link List

//javac -d classes ConvertBinaryTreeToCircularDoublyList.java  && cd classes && java ConvertBinaryTreeToCircularDoublyList && cd ..

class Node {

	int val; 
	Node left,right; 

	public Node(int val) { 
		this.val = val; 
		left = right = null; 
	} 
} 

// A class to represent a tree 
class Tree {

	Node root; 
	public Tree() { 
		root = null; 
	} 

	// concatenate both the lists and returns the head of the List 
	public Node concatTwoList(Node leftList, Node rightList) {
		// System.out.println("calling...");

		// If either of the list is empty, then return the other list 
		if (leftList == null) 
			return rightList; 

		if (rightList == null) 
			return leftList; 

		// Store the last Node of left List 
		Node left_end_node = leftList.left; 

		// Store the last Node of right List 
		Node right_end_node = rightList.left; 
        
        // System.out.println("(leftList ,rightList): ("+leftList.val+", "+rightList.val+")\n");
		// System.out.println("(left_end_node ,right_end_node): ("+left_end_node.val+", "+right_end_node.val+")\n");

		// Connect the last node of Left List with the first Node of the right List 
		left_end_node.right = rightList; 
		rightList.left = left_end_node; 

		// left of first node refers to the last node in the list 
		leftList.left = right_end_node; 

		// Right of last node refers to the first node of the List 
		right_end_node.right = leftList; 

		// Return the Head of the List 
		return leftList; 
	} 

	// Method converts a tree to a circular Link List and then returns the head of the Link List 
	public Node binaryTreeToCircularList(Node root) {

		if (root == null) 
			return null; 

		// Recursively convert left and right subtrees 
		Node left = binaryTreeToCircularList(root.left); 
		Node right = binaryTreeToCircularList(root.right); 

		// Make a circular linked list of single node (or root). 
		//To do so, make the right and 
		// left pointers of this node point to itself 
		root.left = root.right = root; 
		// System.out.println("(root, left, right): ("+root.val+left.val+right.val+")");
		// System.out.println("root: "+root.val);

		// Step 1 (concatenate the left list with the list with single node, i.e., current node) 
		// Step 2 (concatenate the returned list with the right List) 

		return concatTwoList(concatTwoList(left, root), right); //in order
		// return concatTwoList(concatTwoList(root, left), right); // pre order
		// return concatTwoList(concatTwoList(left, right), root); // post order
	} 

	// Display Circular Link List 
	public void display(Node head) { 

		System.out.println("Circular Linked List is :"); 
		Node itr = head; 

		do { 
			System.out.print(itr.val+ " " ); 
			itr = itr.right; 
		} while (itr != head); 

		System.out.println(); 
	} 
} 

class ConvertBinaryTreeToCircularList {

	public static void main(String args[]) 
	{ 
		// Build the tree 
		Tree tree = new Tree(); 

		tree.root = new Node(10); 

		tree.root.left = new Node(12); 
		tree.root.right = new Node(15);

		tree.root.left.left = new Node(25); 
		tree.root.left.right = new Node(30); 

		tree.root.right.left = new Node(36); 
		/*     10
		       / \
		      12  15
		      /\   /\
		    25 30 36    */

		// head refers to the head of the Link List 
		Node head = tree.binaryTreeToCircularList(tree.root); 

		// Display the Circular LinkedList 
		tree.display(head); 

	} 
} 



/*Convert a Binary Tree to a Circular Doubly Link List
Given a Binary Tree, convert it to a Circular Doubly Linked List (In-Place).

	1. The left and right pointers in nodes are to be used as previous and next 
	pointers respectively in converted Circular Linked List.
	2. The order of nodes in List must be same as Inorder of the given Binary Tree.
	3. The first node of Inorder traversal must be head node of the Circular List.

The idea can be described using below steps.
1) Write a general purpose function that concatenates two given circular doubly lists
 (This function is explained below).
2) Now traverse the given tree
….a) Recursively convert left subtree to a circular DLL. Let the converted list be leftList.
….a) Recursively convert right subtree to a circular DLL. Let the converted list be rightList.
….c) Make a circular linked list of root of the tree, make left and right of root to point to itself.
….d) Concatenate leftList with list of single root node.
….e) Concatenate the list produced in step above (d) with rightList.

Note that the above code traverses tree in Postorder fashion. 
We can traverse in inorder fashion also. We can first concatenate left subtree and root,
 then recur for right subtree and concatenate the result with left-root concatenation.*/