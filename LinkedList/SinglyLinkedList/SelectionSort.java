// Recursive selection sort for singly linked list | Swapping node links

// javac -d classes SelectionSort.java  && cd classes && java SelectionSort  && cd ..

class SelectionSort { 
	// A Linked list node 
	static class Node { 
		int data; 
		Node next; 
	}; 

	// function to swap nodes 'currX' and 'currY' in a 
	// linked list without swapping data 
	static Node swapNodes( Node head_ref, Node curr_head, Node min, Node minBefore) { 
		// make 'currY' as new head 
		head_ref = min; 
		// adjust links 
		minBefore.next = curr_head; 
		// Swap next pointers 
		Node temp = min.next; 
		min.next = curr_head.next; 
		curr_head.next = temp; 
		return head_ref; 
	} 

	// function to sort the linked list using recursive selection sort technique 
	//Time Complexity: O(n2)
	static Node recurSelectionSort( Node head) { 
		// if there is only a single node 
		if (head.next == null) 
			return head; 
		// 'min' - pointer to store the node having minimum data value 
		Node min = head; 
		// 'beforeMin' - pointer to store node previous to 'min' node 
		Node beforeMin = null; 
		Node ptr = head;
		// traverse the list till the last node 
		while ( ptr.next != null) { 
			// if true, then update 'min' and 'beforeMin' 
			if (ptr.next.data < min.data) { 
				min = ptr.next; 
				beforeMin = ptr; 
			} 
			ptr = ptr.next;
		} 
		// if 'min' and 'head' are not same, swap the head node with the 'min' node 
		if (min != head) 
			head = swapNodes(head, head, min, beforeMin); 
		// recursively sort the remaining list 
		head.next = recurSelectionSort(head.next); 
		return head; 
	} 

	// function to sort the given linked list 
	static Node sort( Node head_ref) { 
		// if list is empty 
		if ((head_ref) == null) 
			return null; 
		// sort the list using recursive selection sort technique 
		head_ref = recurSelectionSort(head_ref); 
		return head_ref; 
	} 

	// function to insert a node at the 
	// beginning of the linked list 
	static Node push( Node head_ref, int new_data) { 
		// allocate node 
		Node new_node = new Node(); 
		// put in the data 
		new_node.data = new_data; 
		// link the old list to the new node 
		new_node.next = (head_ref); 
		// move the head to point to the new node 
		(head_ref) = new_node; 
		return head_ref; 
	} 

	// function to print the linked list 
	static void printList( Node head) { 
		while (head != null) { 
			System.out.print( head.data + " "); 
			head = head.next; 
		} 
	} 

	// Driver code 
	public static void main(String args[]) { 
		Node head = null; 
		// create linked list 10.12.8.4.6 
		head = push(head, 6); 
		head = push(head, 4); 
		head = push(head, 8); 
		head = push(head, 12); 
		head = push(head, 10); 

		System.out.println( "Linked list before sorting:"); 
		printList(head); 

		// sort the linked list 
		head = sort(head); 

		System.out.print( "\nLinked list after sorting:"); 
		printList(head); 
		System.out.print( "\n"); 
	} 
} 


/*In Selection Sort, we first find minimum element, swap it with the beginning node and recur
for remaining list. Below is recursive implementation of these steps for linked list.

Algorithm

recurSelectionSort(head)
     if head->next == NULL
         return head
     Initialize min = head
     Initialize beforeMin = NULL
     Initialize ptr = head
    
     while ptr->next != NULL 
         if min->data > ptr->next->data
         min = ptr->next
         beforeMin = ptr
     ptr = ptr->next    
    
     if min != head
         swapNodes(&head, head, min, beforeMin)
    
     head->next = recurSelectionSort(head->next)
     return head

swapNodes(head_ref, currX, currY, prevY)
     head_ref = currY
     prevY->next = currX

     Initialize temp = currY->next
     currY->next = currX->next
     currX->next  = temp   */