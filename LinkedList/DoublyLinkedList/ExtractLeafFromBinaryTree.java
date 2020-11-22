// Java program to extract leaf nodes from binary tree using double linked list 

// A binay tree node 
class Node 
{ 
	int data; 
	Node left, right; 

	Node(int item) 
	{ 
		data = item; 
		right = left = null; 
	} 
} 

class BinaryTree {

	Node root; 
	Node head; // will point to head of DLL 
	Node prev; // temporary pointer 

	// The main function that links the list list to be traversed 
	public Node extractLeafList(Node root) { 

		if (root == null) return null;

		if (root.left == null && root.right == null) { //insert only leaf node

			if (head == null) { 
				head = root; 
				prev = root; 
			} else { 
				prev.right = root; 
				root.left = prev; 
				prev = root; 
			} 
			return null; // look here. return null all leaf node
		} 
		root.left = extractLeafList(root.left); 
		root.right = extractLeafList(root.right); 
		return root; 
	} 

	//Prints the DLL in both forward and reverse directions. 
	public void display(Node head) { 
		Node last = null; 
		while (head != null) { 
			System.out.print(head.data + " "); 
			last = head; 
			head = head.right; 
		} 
	} 

	void inorder(Node node) { 
		if (node == null) return; 
		inorder(node.left); 
		System.out.print(node.data + " "); 
		inorder(node.right); 
	} 

} 

class ExtractLeafFromBinaryTree {
	// Driver program to test above functions 
	public static void main(String args[]) 
	{ 
		BinaryTree tree = new BinaryTree(); 

		tree.root = new Node(1); 

		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 

		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 

		tree.root.right.right = new Node(6); 

		tree.root.left.left.left = new Node(7); 
		tree.root.left.left.right = new Node(8);

		tree.root.right.right.left = new Node(9); 
		tree.root.right.right.right = new Node(10); 

  /*Let the following be input binary tree
		        1
		     /     \
		    2       3
		   / \       \
		  4   5       6
		 / \         / \
		7   8       9   10*/

		System.out.println("Inorder traversal of given tree is : "); 
		tree.inorder(tree.root); 

		tree.extractLeafList(tree.root); 
		System.out.println(""); 
		
		System.out.println("Extracted leaf Node from tree and create list : "); 
		tree.display(tree.head); 
		System.out.println("");

		System.out.println("Inorder traversal of modified tree is : "); 
		tree.inorder(tree.root); 
		System.out.println(); 
	} 

}

/*Extract Leaves of a Binary Tree in a Doubly Linked List

Given a Binary Tree, extract all leaves of it in a Doubly Linked List (DLL). 
Note that the DLL need to be created in-place. Assume that the node structure 
of DLL and Binary Tree is same, only the meaning of left and right pointers are different. 
In DLL, left means previous pointer and right means next pointer.

Let the following be input binary tree
        1
     /     \
    2       3
   / \       \
  4   5       6
 / \         / \
7   8       9   10


Output:
Doubly Linked List
head=> null<-7<->8<->5<->9<->10->null

Modified Tree:
        1
     /     \
    2       3
   /         \
  4           6
  
*/

