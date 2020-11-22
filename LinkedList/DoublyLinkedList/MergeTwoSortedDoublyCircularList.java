// Sorted merge of two sorted doubly circular linked lists

// Java implementation for Sorted merge of two sorted doubly circular linked list 
// javac -d classes MergeTwoSortedDoublyCircularList.java  && cd classes && java MergeTwoSortedDoublyCircularList && cd ..

class MergeTwoSortedDoublyCircularList { 
	
	static class Node { 
		int data; 
		Node next, prev; 
	}; 

	// A utility function to insert a new node at the beginning of doubly circular linked list 
	static Node insert(Node head_ref, int data) { 
		// allocate space 
		Node new_node = new Node(); 
		// put in the data 
		new_node.data = data; 
		// if list is empty 
		if (head_ref == null) { 
			new_node.next = new_node; 
			new_node.prev = new_node; //cteate circular linked list 
		} else{ 
			// pointer points to last Node 
			Node last = (head_ref).prev; 
			// setting up previous and next of new node 
			new_node.next = head_ref; 
			new_node.prev = last; 
			// update next and previous pointers of head_ref and last. 
			last.next = (head_ref).prev = new_node; 
		} 
		// update head_ref pointer 
		head_ref = new_node; 
		return head_ref; 
	} 

	// function for Sorted merge of two sorted doubly linked list 
	static Node merge(Node first, Node second) { 
		// If first list is empty 
		if (first == null) return second; 

		// If second list is empty 
		if (second == null) return first; 
		// Pick the smaller value and adjust the links 
		if (first.data < second.data) { 
			first.next = merge(first.next, second); 
			first.next.prev = first; 
			first.prev = null; 
			return first; 
		} else { 
			second.next = merge(first, second.next); 
			second.next.prev = second; 
			second.prev = null; 
			return second; 
		} 
	} 

	// function for Sorted merge of two sorted doubly circular linked list 
	//Time Complexity: O(n1 + n2).
	static Node mergeUtil(Node head1, Node head2) { 
		// if 1st list is empty 
		if (head1 == null) 
			return head2; 
		// if 2nd list is empty 
		if (head2 == null) 
			return head1; 
		// get pointer to the node which will be the last node of the final list 
		Node last_node; 
		//circular linked list
		//head1: 1 3 5 8 
        //head2: 2 7 9 11 
		// head1.prev = last node=>8
		// head2.prev = last node=>11
		if (head1.prev.data < head2.prev.data) 
			last_node = head2.prev; 
		else
			last_node = head1.prev; 
		// store null to the 'next' link of the last nodes of the two lists 
		head1.prev.next = head2.prev.next = null; // create list from circle list
		// sorted merge of head1 and head2 
		Node finalHead = merge(head1, head2); 
		// 'prev' of 1st node pointing the last node 
		// 'next' of last node pointing to 1st node 
		// create circle
		finalHead.prev = last_node; 
		last_node.next = finalHead; 
	  return finalHead; 
	} 

	// function to print the list 
	static void printList(Node head) { 
		Node temp = head; 

		while (temp.next != head) { 
			System.out.print ( temp.data+ " "); 
			temp = temp.next; 
		} 
		System.out.print ( temp.data + " "); 
	} 

	// Driver code 
	public static void main(String args[]) 
	{ 
		Node head1 = null, head2 = null; 

		// list 1: 
		head1 = insert(head1, 8); 
		head1 = insert(head1, 5); 
		head1 = insert(head1, 3); 
		head1 = insert(head1, 1); 

		// list 2: 
		head2 = insert(head2, 11); 
		head2 = insert(head2, 9); 
		head2 = insert(head2, 7); 
		head2 = insert(head2, 2); 

		System.out.print("head1: "); 
		printList(head1); 
		
		System.out.print( "\nhead2: ");
		printList(head2); 

		Node newHead = mergeUtil(head1, head2); 

		System.out.print( "\nFinal Sorted List: "); 
		printList(newHead); 
		System.out.print( "\n"); 
	} 
} 

/*Algorithm:
1. If head1 == NULL, return head2.
2. If head2 == NULL, return head1.
3. Let last1 and last2 be the last nodes of the two lists respectively. 
   They can be obtained with the help of the previous links of the first nodes.
4. Get pointer to the node which will be the last node of the final list. 
   If last1.data < last2.data, then last_node = last2, Else last_node = last1.
5. Update last1.next = last2.next = NULL.
6. Now merge the two lists as two sorted doubly linked list are being merged. 
   Refer merge procedure of this post. Let the first node of the final list be finalHead.
7. Update finalHead.prev = last_node and last_node.next = finalHead.
8. Return finalHead*/