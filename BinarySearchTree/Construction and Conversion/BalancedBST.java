//Sorted Linked List to Balanced BST

//javac -d classes BalancedBST.java  && cd classes && java BalancedBST && cd ..

class BalancedBST { 

	/* head node of link list */
	static LNode head; 
	
	/* Link list Node */
	class LNode { 
		int data; 
		LNode next, prev; 
		LNode(int d) { 
			data = d; 
			next = prev = null; 
		} 
	} 
	
	/* A Binary Tree Node */
	class TNode { 
		int data; 
		TNode left, right; 
		TNode(int d) { 
			data = d; 
			left = right = null; 
		} 
	} 

	/* This function counts the number of nodes in Linked List 
	and then calls sortedListToBSTRecur() to construct BST */
	TNode sortedListToBST() 
	{ 
		/*Count the number of nodes in Linked List */
		int n = countNodes(head); 
		/* Construct BST */
		return sortedListToBSTRecur(n); 
	} 

	/* The main function that constructs balanced BST and 
	returns root of it. 
	n --> No. of nodes in the Doubly Linked List */
	TNode sortedListToBSTRecur(int n) 
	{ 
		/* Base Case */
		if (n <= 0) 
			return null; 
		TNode left = sortedListToBSTRecur(n/2); 
		TNode root = new TNode(head.data); 
		// Set pointer to left subtree 
		root.left = left; 
		head = head.next; 
		root.right = sortedListToBSTRecur(n-(n/2)-1); 

		return root; 
	} 

	int countNodes(LNode head) 
	{ 
		int count = 0; 
		LNode temp = head; 
		while (temp != null) { 
			temp = temp.next; 
			count++; 
		} 
		return count; 
	} 

	/* Function to insert a node at the beginging of 
	the Doubly Linked List */
	void push(int new_data) 
	{ 
		/* allocate node */
		LNode new_node = new LNode(new_data); 
		/* since we are adding at the beginning, 
		prev is always NULL */
		new_node.prev = null; 
		/* link the old list off the new node */
		new_node.next = head; 
		/* change prev of head node to new node */
		if (head != null) 
			head.prev = new_node; 
		/* move the head to point to the new node */
		head = new_node; 
	} 

	/* Function to print nodes in a given linked list */
	void printList(LNode node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
	} 

	/* A utility function to print preorder traversal of BST */
	void preOrder(TNode node) 
	{ 
		if (node == null) 
			return; 
		System.out.print(node.data + " "); 
		preOrder(node.left); 
		preOrder(node.right); 
	} 

	/* Driver program to test above functions */
	public static void main(String[] args) { 
		BalancedBST llist = new BalancedBST(); 

		/* Let us create a sorted linked list to test the functions 
		Created linked list will be 7->6->5->4->3->2->1 */
		llist.push(7); 
		llist.push(6); 
		llist.push(5); 
		llist.push(4); 
		llist.push(3); 
		llist.push(2); 
		llist.push(1); 

		System.out.println("Given Linked List "); 
		llist.printList(head); 

		/* Convert List to BST */
		TNode root = llist.sortedListToBST(); 
		System.out.println(""); 
		
		System.out.println("Pre-Order Traversal of constructed BST "); 
		llist.preOrder(root); 
		System.out.println(); 
	} 
} 


/*
Sorted Linked List to Balanced BST

Given a Singly Linked List which has data members sorted in ascending order. 
Construct a Balanced Binary Search Tree which has same data members as the given Linked List.

Examples:

Input:  Linked List 1->2->3
Output: A Balanced BST 
     2   
   /  \  
  1    3 


Input: Linked List 1->2->3->4->5->6->7
Output: A Balanced BST
        4
      /   \
     2     6
   /  \   / \
  1   3  5   7  

Input: Linked List 1->2->3->4
Output: A Balanced BST
      3   
    /  \  
   2    4 
 / 
1

Input:  Linked List 1->2->3->4->5->6
Output: A Balanced BST
      4   
    /   \  
   2     6 
 /  \   / 
1   3  5   */