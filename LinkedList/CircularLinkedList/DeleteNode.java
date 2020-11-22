// Java program to delete a given key from Circular linked list.
//javac -d classes DeleteNode.java  && cd classes && java DeleteNode && cd ..

class DeleteNode {

	/* ure for a node */
	static class Node {
		int data;
		Node next;
	};

	/* Function to insert a node at the beginning of a Circular linked list */
	static Node push(Node head_ref, int data) {

		// Create a new node and make head as next of it.
		Node ptr1 = new Node();
		ptr1.data = data;
		ptr1.next = head_ref;

		/* If linked list is not null then set the next of last node */
		if (head_ref != null) {
			// Find the node before head and update next of it.
			Node temp = head_ref;
			while (temp.next != head_ref) {
			   temp = temp.next;
			}
			temp.next = ptr1;
		} else {
			ptr1.next = ptr1; /*For the first node */
		}

		head_ref = ptr1;
		return head_ref;
	}

	/* Function to print nodes in a given circular linked list */
	static void printList(Node head) {

		Node temp = head;
		int count=0;
		if (head != null) {
			do {
				count++;
				System.out.printf("%d ", temp.data);
				temp = temp.next;
			} while (temp != head);
		}
		System.out.printf("\ncount : "+count+"\n");
	}

	/* Function to delete a given node from the list */
	static Node deleteNode(Node head, int key) {

		if (head == null) return null;

		// Find the required node
		Node curr = head, prev = null;

		while (curr.data != key) {
			if (curr.next == head) {
				System.out.printf("\nGiven node is not found" + " in the list!!!\n");
				return head;
			}
			prev = curr;
			curr = curr.next;
		}

		// delete only one node
		if (curr.data == key && curr == head && curr.next == head) {
			System.out.println("head delete...");
			head = null;
			return head;
		}

		// If more than one node, check if it is first node
		if (curr == head) { // delete first node
			prev = head;
			while (prev.next != head)
				prev = prev.next;
			head = curr.next;
			prev.next = head;
		} else if (curr.next == head) { // delete last node
			prev.next = head;
		} else { // delete middle node
			prev.next = curr.next; 
		}

		return head;
	}

	/* Driver code */
	public static void main(String args[]) {

		/* Initialize lists as empty */
		Node head = null;

		/* Created linked list will be 2.5.7.8.10 */
		head = push(head, 2);
		head = push(head, 5);
		head = push(head, 7);
		head = push(head, 8);
		head = push(head, 10);

		System.out.printf("List Before Deletion: ");
		printList(head);

		head = deleteNode(head, 8);

		System.out.printf("List After Deletion Item 8: ");
		printList(head);
	}
}

