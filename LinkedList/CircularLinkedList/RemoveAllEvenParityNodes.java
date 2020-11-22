// Remove all even parity nodes from a Circular Singly Linked List

//javac -d classes RemoveAllEvenParityNodes.java  && cd classes && java RemoveAllEvenParityNodes && cd ..

class RemoveAllEvenParityNodes{

	// Structure for a node
	static class Node 
	{
		int data;
		Node next;
	};

	// Function to insert a node at
	// the beginning of a Circular
	// linked list
	static Node push(Node head_ref, int data)
	{
		
		// Create a new node
		// and make head as next
		// of it.
		Node ptr1 = new Node();

		Node temp = head_ref;
		ptr1.data = data;
		ptr1.next = head_ref;

		// If linked list is not null then
		// set the next of last node
		if (head_ref != null)
		{
			
			// Find the node before head
			// and update next of it.
			while (temp.next != head_ref)
				temp = temp.next;

			temp.next = ptr1;
		}
		else

			// Point for the first node
			ptr1.next = ptr1;

		head_ref = ptr1;
		return head_ref;
	}

	// Function to delete the node 
	// from a Circular Linked list
	static void deleteNode(Node head_ref,
						Node del)
	{
		
		// If node to be deleted is
		// head node
		if (head_ref == del)
			head_ref = del.next;

		Node temp = head_ref;

		// Traverse list till not found
		// delete node
		while (temp.next != del)
		{
			temp = temp.next;
		}

		// Copy the address of the node
		temp.next = del.next;

		// Finally, free the memory
		// occupied by del
		System.gc();

		return;
	}

	// Function that returns true if count of set bits in x is even
    static boolean isEvenParity(int x) {

        // Parity will store the count of set bits
        int parity = 0;
         
        while (x != 0) {
            if ((x & 1) != 0) {
                parity++;
            }
            x = x >> 1;
        }
     
        if (parity % 2 == 0)
            return true;
        else
            return false;
    }

	// Function to delete all the Even Parity Nodes from the singly circular linked list
	static void deleteEvenParityNodes(Node head) {

		if (head == null)
			return;
		if (head == head.next) {
			if (isEvenParity(head.data))
				head = null;
			return;
		}

		Node ptr = head;
		// Traverse the list till the end
		do {
			// If the node's data has even parity, delete node 'ptr'
			if (isEvenParity(ptr.data))
				deleteNode(head, ptr);
			// Point to the next node
			ptr = ptr.next;

		} while (ptr != head);

	}

	// Function to print nodes in a
	// given Circular linked list
	static void printList(Node head)
	{
		if (head == null)
		{
			System.out.print("Empty List\n");
			return;
		}

		Node temp = head;
		if (head != null)
		{
			do
			{
				System.out.printf("%d ", temp.data);
				temp = temp.next;
			} while (temp != head);
			System.out.printf("\n");
		}
	}

	// Driver code
	public static void main(String[] args)
	{
		
		// Initialize lists as empty
		Node head = null;

		// Created linked list will be
		// 11.9.34.6.13.21
		head = push(head, 21);
		head = push(head, 13);
		head = push(head, 6);
		head = push(head, 34);
		head = push(head, 9);
		head = push(head, 11);

		printList(head);

		deleteEvenParityNodes(head);

		printList(head);
	}
}


/*
Remove all even parity nodes from a Circular Singly Linked List
Given a Doubly linked list and Circular singly linked list containing N nodes, 
the task is to remove all the nodes from each list which contains elements whose parity is even.

Example: 

Input: CLL = 9 -> 11 -> 34 -> 6 -> 13 -> 21 
Output: 11 -> 13 -> 21 
Explanation: 
The circular singly linked list contains : 
11 -> 1011, parity = 3 
9 -> 1001, parity = 2 
34 -> 100010, parity = 2 
6 -> 110, parity = 2 
13 -> 1101, parity = 3 
21 -> 10101, parity = 3 
Here, parity for nodes containing 9, 34, and 6 are even. 
Hence, these nodes have been deleted.

Input: DLL = 18 <=> 15 <=> 8 <=> 9 <=> 14 
Output: 8 <=> 14 
Explanation: 
The linked list contains : 
18 -> 10010, parity = 2 
15 -> 1111, parity = 4 
8 -> 1000, parity = 1 
9 -> 1001, parity = 2 
14 -> 1110, parity = 3 
Here, parity for nodes containing 18, 15 and 9 are even. 
Hence, these nodes have been deleted. */