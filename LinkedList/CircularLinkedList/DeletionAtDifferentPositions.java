//Deletion at different positions in a Circular Linked List
// javac -d classes DeletionAtDifferentPositions.java  && cd classes && java DeletionAtDifferentPositions && cd ..
import java.util.*; 
import java.lang.*; 
import java.io.*; 

class DeletionAtDifferentPositions 
{ 

	// structure for a node 
	static class Node 
	{ 
		int data; 
		Node next; 
	}; 

	// Function to insert a node at the end of 
	// a Circular linked list 
	static Node Insert(Node head, int data) 
	{ 
		Node current = head; 
		
		// Create a new node 
		Node newNode = new Node(); 

		// check node is created or not 
		if (newNode == null) 
		{ 
			System.out.printf("\nMemory Error\n"); 
			return null; 
		} 

		// insert data into newly created node 
		newNode.data = data; 

		// check list is empty 
		// if not have any node then 
		// make first node it 
		if (head == null) 
		{ 
			newNode.next = newNode; 
			head = newNode; 
			return head; 
		} 

		// if list have already some node 
		else
		{ 

			// move first node to last node 
			while (current.next != head) 
			{ 
				current = current.next; 
			} 

			// put first or head node address 
			// in new node link 
			newNode.next = head; 

			// put new node address into last 
			// node link(next) 
			current.next = newNode; 
		} 
		return head; 
	} 

	// Function print data of list 
	static void Display( Node head) 
	{ 
		Node current = head; 

		// if list is empty, simply show message 
		if (head == null) 
		{ 
			System.out.printf("\nDisplay List is empty\n"); 
			return; 
		} 

		// traverse first to last node 
		else
		{ 
			do
			{ 
				System.out.printf("%d ", current.data); 
				current = current.next; 
			} while (current != head); 
		} 
	} 

	// Function return number of nodes present in list 
	static int Length(Node head) 
	{ 
		Node current = head; 
		int count = 0; 

		// if list is empty 
		// simply return length zero 
		if (head == null) 
		{ 
			return 0; 
		} 

		// traverse forst to last node 
		else
		{ 
			do
			{ 
				current = current.next; 
				count++; 
			} while (current != head); 
		} 
		return count; 
	} 

	// Function delete First node of 
	// Circular Linked List 
	static Node DeleteFirst(Node head) 
	{ 
		Node previous = head, next = head; 

		// check list have any node 
		// if not then return 
		if (head == null) 
		{ 
			System.out.printf("\nList is empty\n"); 
			return null; 
		} 

		// check list have single node 
		// if yes then delete it and return 
		if (previous.next == previous) 
		{ 
			head = null; 
			return null; 
		} 

		// traverse second to first 
		while (previous.next != head) 
		{ 
			previous = previous.next; 
			next = previous.next; 
		} 

		// now previous is last node and 
		// next is first node of list 
		// first node(next) link address 
		// put in last node(previous) link 
		previous.next = next.next; 

		// make second node as head node 
		head = previous.next; 

		return head; 
	} 

	// Function to delete last node of 
	// Circular Linked List 
	static Node DeleteLast(Node head) 
	{ 
		Node current = head, temp = head, previous=null; 

		// check if list doesn't have any node 
		// if not then return 
		if (head == null) 
		{ 
			System.out.printf("\nList is empty\n"); 
			return null; 
		} 

		// check if list have single node 
		// if yes then delete it and return 
		if (current.next == current) 
		{ 
			head = null; 
			return null; 
		} 

		// move first node to last 
		// previous 
		while (current.next != head) 
		{ 
			previous = current; 
			current = current.next; 
		} 

		previous.next = current.next; 
		head = previous.next; 
		
		return head; 
	} 

	// Function delete node at a given poisition 
	// of Circular Linked List 
	static Node DeleteAtPosition( Node head, int index) 
	{ 
		// Find length of list 
		int len = Length(head); 
		int count = 1; 
		Node previous = head, next = head; 

		// check list have any node 
		// if not then return 
		if (head == null) 
		{ 
			System.out.printf("\nDelete Last List is empty\n"); 
			return null; 
		} 

		// given index is in list or not 
		if (index >= len || index < 0) 
		{ 
			System.out.printf("\nIndex is not Found\n"); 
			return null; 
		} 

		// delete first node 
		if (index == 0) 
		{ 
			head = DeleteFirst(head); 
			return head; 
		} 

		// traverse first to last node 
		while (len > 0) 
		{ 

			// if index found delete that node 
			if (index == count) 
			{ 
				previous.next = next.next; 
				
				return head; 
			} 
			previous = previous.next; 
			next = previous.next; 
			len--; 
			count++; 
		} 
		return head; 
	} 

	// Driver Code 
	public static void main(String args[]) 
	{ 
		Node head = null; 
		head = Insert(head, 99); 
		head = Insert(head, 11); 
		head = Insert(head, 22); 
		head = Insert(head, 33); 
		head = Insert(head, 44); 
		head = Insert(head, 55); 
		head = Insert(head, 66); 

		// Deleting Node at position 
		System.out.printf("Initial List: "); 
		Display(head); 
		System.out.printf("\nAfter Deleting node at index 4: "); 
		head = DeleteAtPosition(head, 4); 
		Display(head); 

		// Deleting first Node 
		System.out.printf("\n\nInitial List: "); 
		Display(head); 
		System.out.printf("\nAfter Deleting first node: "); 
		head = DeleteFirst(head); 
		Display(head); 

		// Deleting last Node 
		System.out.printf("\n\nInitial List: "); 
		Display(head); 
		
		System.out.printf("\nAfter Deleting last node: "); 
		head = DeleteLast(head); 
		Display(head); 
		System.out.printf("\n"); 
	} 
} 

