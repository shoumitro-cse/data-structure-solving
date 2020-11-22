// Java program to convert a given Binary Tree to Doubly Linked List 

// javac -d classes BinaryTreeToDoublyLinkedList.java  && cd classes && java BinaryTreeToDoublyLinkedList && cd ..

class Node { 
	int data; 
	Node left, right; 

	public Node(int data) { 
		this.data = data; 
		left = right = null; 
	} 
} 

class BinaryTreeToDoublyLinkedList { 
	// root --> Root of Binary Tree 
	Node root=null; 
	// head --> Pointer to head Node of created doubly linked list 
	Node head=null; 

    //Convert a given Binary Tree to Doubly Linked List | Set 4
	// Time Complexity: O(n), as the solution does a single traversal of given Binary Tree.
	void binaryToDoublyList(Node root) { 
		// Base cases 
		if (root == null) return; 

		// Recursively convert right subtree 
		binaryToDoublyList(root.right); 

		// insert root into DLL 
	    root.right = head; 

		// Change left pointer of previous head 
		if (head != null) 
			head.left = root; 

		// Change head of Doubly linked list 
		head = root; 
		// System.out.println(root.data);

		// Recursively convert left subtree 
		binaryToDoublyList(root.left); 
	} 

/*   //Convert a given Binary Tree to Doubly Linked List | Set 3
   static Node prev = null; 
   void binaryToDoublyList(Node root) { 
        // Base case 
        if (root == null) return; 
   
        // Recursively convert left subtree 
        binaryToDoublyList(root.left); 
   
        // Now convert this Node 
        if (prev == null)  {
            head = root; 
        } else { 
            root.left = prev; 
            prev.right = root; 
        } 
        prev = root; 
   
        // Finally convert right subtree 
        binaryToDoublyList(root.right); 
    } */

/*   // Convert a given Binary Tree to Doubly Linked List | Set 2
    static Node prev; 
    static void fixPrevptr(Node root) { 

        if (root == null) return; 
  
        fixPrevptr(root.left); 
        root.left = prev; 
        prev = root; 
        fixPrevptr(root.right); 
  
    } 
 
    static Node fixNextptr(Node root)  {         
        // Find the right most Node in BT or last Node in DLL 
        while (root.right != null) { // root=5
            root = root.right; // increment
        }
        //here root=9

        // Start from the rightmost Node, traverse  
        // back using left pointers. While traversing, change right pointer of Nodes 
        while (root != null && root.left != null) { // root=9 and root.left=8
            Node left = root.left; 
            left.right = root; 
            root = root.left; 
        }
        // The leftmost Node is head of linked list, return it 
        return root; // root=0
    } 
   // Time Complexity: O(n) where n is the number of nodes in given Binary Tree. 
    void binaryToDoublyList(Node root) { 
        prev = null; 
        // Set the previous pointer 
        fixPrevptr(root); // root=5
        // Set the next pointer and return head of DLL 
        head = fixNextptr(root); // root=5
    } */



/*// Convert a given Binary Tree to Doubly Linked List | Set 1
    Node _binaryToDoublyList(Node root)  { 
        // Base case 
        if (root == null) return root; 

        // Convert the left subtree and link to root 
        if (root.left != null)  { 
            // Convert the left subtree 
            Node left = _binaryToDoublyList(root.left); 
            // Find inorder predecessor. After this loop, left 
            // will point to the inorder predecessor 
            for (; left.right != null; left = left.right); 
            // Make root as next of the predecessor 
            left.right = root; 
            // Make predecssor as previous of root 
            root.left = left; 
        } 
        // Convert the right subtree and link to root 
        if (root.right != null)  { 
            // Convert the right subtree 
            Node right = _binaryToDoublyList(root.right); 
            // Find inorder successor. After this loop, right 
            // will point to the inorder successor 
            for (; right.left != null; right = right.left); 
            // Make root as previous of successor 
            right.left = root; 
            // Make successor as next of root 
            root.right = right; 
        } 
        return root; // root=5
    } 

    void binaryToDoublyList(Node root) { 
        // Base case 
        if (root == null) return ; 

        // Convert to DLL using bintree2listUtil() 
        root = _binaryToDoublyList(root); 
        // System.out.println(root.data); //5

        while (root.left != null) {
            root = root.left; 
        }
        head = root;
    } */


	// Utility function for printing double linked list. 
	void printList(Node head) 
	{ 
		System.out.println("Extracted Double Linked List is : "); 
		while (head != null) { 
			System.out.print(head.data + " "); 
			head = head.right; 
		} 
		System.out.print("\n"); 
	} 

    static int findSize(Node Node) { 
        int res = 0; 
        while (Node != null) { 
            res++; 
            Node = Node.right; 
        } 
		System.out.printf("Size : %d\n", res); 
        return res; 
    } 

	// Driver program to test the above functions 
	public static void main(String[] args) { 


		BinaryTreeToDoublyLinkedList tree = new BinaryTreeToDoublyLinkedList(); 

		tree.root = new Node(5); 

		tree.root.left = new Node(3); 
		tree.root.right = new Node(6); 

		tree.root.left.left = new Node(1); 
		tree.root.left.right = new Node(4); 

		tree.root.right.right = new Node(8); 

		tree.root.left.left.left = new Node(0); 
		tree.root.left.left.right = new Node(2); 

		tree.root.right.right.left = new Node(7); 
		tree.root.right.right.right = new Node(9); 

        /* Constructing below tree 
               5 
             /   \ 
            3     6 
           / \     \ 
          1   4     8 
         / \       / \ 
        0   2     7   9  */

		tree.binaryToDoublyList(tree.root); 
		tree.printList(tree.head); 

        findSize(tree.head);
	} 
} 

