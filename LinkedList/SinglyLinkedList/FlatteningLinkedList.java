//javac -d classes FlatteningLinkedList.java  && cd classes && java FlatteningLinkedList  && cd ..

// Java program for flattening a Linked List 
class FlatteningLinkedList {

	Node head; // head of list 
	/* Linked list Node*/
	class Node {
		int data; 
		Node right, down; 
		Node(int data) 
		{ 
			this.data = data; 
			right = null; 
			down = null; 
		} 
	} 

	// An utility function to merge two sorted linked lists 
	Node merge(Node a, Node b) {
		if (a == null)	 return b; // if first linked list is empty then second 
		if (b == null)	 return a; // if second linked list is empty then first 
		// compare the data members of the two linked lists and put the larger one in the result 
		Node result; 
		if (a.data < b.data) { 
			result = a; 
			result.down = merge(a.down, b); 
		} else { 
			result = b; 
			result.down = merge(a, b.down); 
		} 
		result.right = null; 
/*		head=result;
		printList();// for debug*/
		return result; 
	} 
        /* Let us create the following linked list 
            5 -> 10 -> 19 -> 28 
            |    |     |     | 
            V    V     V     V 
            7    20    22    35 
            |          |     | 
            V          V     V 
            8          50    40 
            |                | 
            V                V 
            30               45 
        */

	Node flatten(Node root) {
		// Base Cases 
		if (root == null || root.right == null) 
			return root; 
		root.right = flatten(root.right); // recur for list on right 
		root = merge(root, root.right); // now merge 
		return root; // return the root it will be in turn merged with its left 
	} 

	/* Utility function to insert a node at beginning of the 
	linked list */
	Node push(Node head_ref, int data) {
		Node new_node = new Node(data); 
		new_node.down = head_ref; 
		head_ref = new_node; 
		return head_ref; 
	} 

	void printList() {
		Node temp = head; 
		while (temp != null) { 
			System.out.print(temp.data + " "); 
			temp = temp.down; 
		} 
		System.out.println(); 
	} 

	/* Driver program to test above functions */
	public static void main(String args[]) {

		FlatteningLinkedList L = new FlatteningLinkedList(); 

        /* Let us create the following linked list 
            5 -> 10 -> 19 -> 28 
            |    |     |     | 
            V    V     V     V 
            7    20    22    35 
            |          |     | 
            V          V     V 
            8          50    40 
            |                | 
            V                V 
            30               45 
        */

		L.head = L.push(L.head, 30); //down
		L.head = L.push(L.head, 8); //down
		L.head = L.push(L.head, 7);//down 
		L.head = L.push(L.head, 5); //root
        
        //5 right node 10
 /*20*/ L.head.right = L.push(L.head.right, 20); //down
 /*10*/ L.head.right = L.push(L.head.right, 10); //right root

        // 10 right node 19
/*50*/  L.head.right.right = L.push(L.head.right.right, 50);//down 
/*22*/	L.head.right.right = L.push(L.head.right.right, 22); //down
/*19*/	L.head.right.right = L.push(L.head.right.right, 19); //right root

        // 29 right node 28
/*45*/	L.head.right.right.right = L.push(L.head.right.right.right, 45); //down
/*40*/	L.head.right.right.right = L.push(L.head.right.right.right, 40); //down
/*35*/	L.head.right.right.right = L.push(L.head.right.right.right, 35); //down
/*28*/	L.head.right.right.right = L.push(L.head.right.right.right, 28); //right root

		// flatten the list 
		L.head = L.flatten(L.head); 

		L.printList(); 
	} 
} 


/*
Flattening a Linked List
Last Updated: 04-07-2020
Given a linked list where every node represents a linked list and contains two pointers of its type:
(i) Pointer to next node in the main list (we call it ‘right’ pointer in below code)
(ii) Pointer to a linked list where this node is head (we call it ‘down’ pointer in below code).
All linked lists are sorted. See the following example

       5 -> 10 -> 19 -> 28
       |    |     |     |
       V    V     V     V
       7    20    22    35
       |          |     |
       V          V     V
       8          50    40
       |                |
       V                V
       30               45
Write a function flatten() to flatten the lists into a single linked list. 
The flattened linked list should also be sorted. For example, 
for the above input list, 
output list should be 5->7->8->10->19->20->22->28->30->35->40->45->50.
*/