// Delete every Kth node from circular linked list

// Java program to delete every kth Node from circular linked list. 
//javac -d classes DeleteEveryKthNode.java  && cd classes && java DeleteEveryKthNode && cd ..

class DeleteEveryKthNode { 
	
	/* structure for a Node */
	static class Node { 
		int data; 
		Node next; 
		Node(int x) { 
			data = x; 
			next = null; 
		} 
	}; 

	/*Utility function to print the circular linked list*/
	static void printList(Node head) { 
		if (head == null) return; 
		Node temp = head; 
		do { 
			System.out.print(temp.data + "->"); 
			temp = temp.next; 
		} while (temp != head); 
		System.out.println(head.data ); 
	} 

	/*Function to delete every kth Node*/
	static Node deleteK(Node head_ref, int k) {
		
		Node head = head_ref; 
		
		// If list is empty, simply return. 
		if (head == null) return null; 

		// take two pointers - current and previous 
		Node curr = head, prev=null; 

		while (true) { 
			// Check if Node is the only Node If yes, we reached the goal, therefore return. 
			if (curr.next == head && curr == head) break; 
			// Print intermediate list. 
			printList(head); 
			//If more than one Node present in the list,Make previous pointer point to current 
			//Iterate current pointer k times, i.e. current Node is to be deleted. 
			for (int i = 0; i < k; i++) { //k=4
				prev = curr; 
				curr = curr.next; 
			} 

			if (curr == head) { // delete first node
				prev = head; 
				while (prev.next != head) 
					prev = prev.next; 
				head = curr.next; 
				prev.next = head; 
				head_ref = head; 
			} else if (curr.next == head) { // delete last node
				prev.next = head; 
			} else { //delete middle
				prev.next = curr.next; 
			} 
		} 
		return head; 
	} 

	/* Function to insert a Node at the end of a Circular linked list */
	static Node insertNode(Node head_ref, int x) { 
		// Create a new Node 
		Node head = head_ref; 
		Node temp = new Node(x); 

		// if the list is empty, make the new Node head Also, it will point to itself. 
		if (head == null) { 
			temp.next = temp; 
			head_ref = temp; 
			return head_ref; 
		} else { // traverse the list to reach the last Node and insert the Node 
			Node ptr = head; 
			while (ptr.next != head) {
				ptr = ptr.next; 
			}
			ptr.next = temp; 
			temp.next = head; 
		} 
		return head; 
	} 

	/* Driver code */
	public static void main(String args[]) {

		// insert Nodes in the circular linked list 
		Node head = null; 
		head = insertNode(head, 1); 
		head = insertNode(head, 2); 
		head = insertNode(head, 3); 
		head = insertNode(head, 4); 
		head = insertNode(head, 5); 
		head = insertNode(head, 6); 
		head = insertNode(head, 7); 
		head = insertNode(head, 8); 
		head = insertNode(head, 9); 

		int k = 4; 

		// Delete every kth Node from the circular linked list. 
		head = deleteK(head, k); 
	} 
} 


/*
Delete every Kth node from circular linked list

Delete every kth Node from a circular linked list until only one node is left. 
Also print the intermediate lists.

Examples:

Input : n=4, k=2, list = 1->2->3->4
Output : 
1->2->3->4->1
1->2->4->1
2->4->2
2->2

Input : n=9, k=4, list = 1->2->3->4->5->6->7->8->9
Output :
1->2->3->4->5->6->7->8->9->1
1->2->3->4->6->7->8->9->1
1->2->3->4->6->7->8->1
1->2->3->6->7->8->1
2->3->6->7->8->2
2->3->6->8->2
2->3->8->2
2->3->2
2->2


Algorithm
Repeat the following steps until there is only one node left in the list.
Case 1: List is empty.
If the list is empty, simply return.

Case 2: List has only one node.
If the list has only one node left, we will print the list and 
return as our goal is reached.

Case 3: List has more than one nodes.
Define two pointers curr and prev and initialize the pointer curr with the head node.
Traverse the list using curr pointer by iterating it k times.

Node to be deleted is the first node of the list.
Condition to check this( curr == head && curr->next == head).
If yes, then move prev until it reaches the last node. After prev reaches the last node, 
set head = head -> next and prev -> next = head. Delete curr.
Node to be deleted is the last node in the list.
Condition to check this is (curr -> next == head).
If curr is the last node. Set prev -> next = head and delete the node curr by free(curr).
Node to be deleted is neither the first node nor the last node,
 then set prev -> next = temp -> next and delete curr.*/