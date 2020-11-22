// Java implementation to modify the contents of the linked list 
// javac -d classes ModifyContents.java  && cd classes && java ModifyContents && cd ..

import java.util.*; 

class ModifyContents { 
	
	 // Linked list node 
	static class Node { 
		int data; 
		Node next; 
	}; 

	/* Function to insert a node at the beginning of the linked list */
	static Node push(Node head_ref, int new_data) 
	{ 
		 // allocate node 
		Node new_node =new Node(); 
		 // put in the data 
		new_node.data = new_data; 
			
		 // link the old list at the end of the new node 
		new_node.next = head_ref; 
			
		/* move the head to point to the new node */
		head_ref = new_node; 
		
		return head_ref; 
	} 

	static Node front, back; 

	static void frontAndBackSplit( Node head) 
	{ 
		Node slow, fast; 
		
		slow = head; 
		fast = head.next; 
		
		/* Advance 'fast' two nodes, and 
		advance 'slow' one node */
		while (fast != null) 
		{ 
			fast = fast.next; 
			if (fast != null) 
			{ 
				slow = slow.next; 
				fast = fast.next; 
			} 
		} 
		
		/* 'slow' is before the midpoint in the list, so split it in two at that point. */
		front = head; 
		back = slow.next; 
		slow.next = null;

		System.out.println("\nfront list:"); 
		printList(front);	

		System.out.println("\nback list:"); 
		printList(back);
		System.out.println(); 
	} 

	/* Function to reverse the linked list */
	static Node reverseList( Node head_ref) 
	{ 
		Node current, prev, next; 
		current = head_ref; 
		prev = null; 
		while (current != null) 
		{ 
			next = current.next; 
			current.next = prev; 
			prev = current; 

			current = next; 
		} 
		head_ref = prev; 
		return head_ref; 
	} 

	// perfrom the required subtraction operation 
	// on the 1st half of the linked list 
	static void modifyTheContentsOf1stHalf() 
	{ 
		Node front1 = front, back1 = back; 
		// traversing both the lists simultaneously 
		while (back1 != null) { 
			// subtraction operation and node data modification 
			front1.data = front1.data - back1.data; 
			
			front1 = front1.next; 
			back1 = back1.next; 
		} 
	} 

	// function to concatenate the 2nd(back) list 
	// at the end of the 1st(front) list and 
	// returns the head of the new list 
	static Node concatFrontAndBackList(Node front, Node back) 
	{ 
		Node head = front; 
		
		if(front == null)return back; 
		
		while (front.next != null) 
			front = front.next; 
			
		front.next = back; 
		
		return head; 
	} 

	// function to modify the contents of the linked list 
    //Time Complexity: O(n), where n in the number of nodes.
	static Node modifyTheList( Node head) { 
		// if list is empty or contains only single node 
		if (head == null || head.next == null) {
			return head; 
		}
		front = null; back = null; 
		// split the list into two halves  front and back lists 
		frontAndBackSplit(head); 
		// reverse the 2nd(back) list 
		back = reverseList(back); 
		
		System.out.println("reverse back list:"); 
		printList(back);
		System.out.println(); 

		// modify the contents of 1st half 
		modifyTheContentsOf1stHalf(); 
		// agains reverse the 2nd(back) list 
		back = reverseList(back); 
		// concatenating the 2nd list back to the end of the 1st list 
		head = concatFrontAndBackList(front, back); 
		// pointer to the modified list 
		return head; 
	} 


/*	    // Function to middle node of list. 
    static Node find_mid(Node head)  { 

        Node temp = head, slow = head, fast = head; 
  
        while (fast != null && fast.next != null) { 
            // Advance 'fast' two nodes, and advance 'slow' one node 
            slow = slow.next; 
            fast = fast.next.next; 
        } 
        // If number of nodes are odd then update slow by slow.next; 
        if (fast != null) { 
            slow = slow.next; 
        } 
  
        return slow; 
    } 
  
    // function to modify the contents of the linked list. 
    // Time Complexity : O(n)
    // Space Complexity : O(n/2)
    static Node modifyTheList(Node head) { 
        // Create Stack.  
        Stack<Integer> stack = new Stack<Integer>(); 
        Node temp = head; 
        Node mid = find_mid(head);
  
        while (mid != null) { 
            stack.add(mid.data); 
            mid = mid.next; 
        } 
  
    // Traverse the list by using temp until stack is empty. 
        while (!stack.empty()) { 
            temp.data = temp.data - stack.peek(); 
            temp = temp.next; 
            stack.pop(); 
        } 
      return head;
    } 
*/


	// function to print the linked list 
	static void printList( Node head) { 
		if (head == null) 
			return; 
		
		while (head.next != null) { 
			System.out.print(head.data + "->"); 
			head = head.next; 
		} 
		System.out.println(head.data+"->null" ); 
	} 

	// Driver Code 
	public static void main(String args[]) 
	{ 
		Node head = null; 
		
		// creating the linked list 
		head = push(head, 10); 
		head = push(head, 7); 
		head = push(head, 12); 
		head = push(head, 8); 
		head = push(head, 9); 
		head = push(head, 2); 
		
		System.out.println( "Original List:" ); 
		printList(head); 

		// modify the linked list 
		head = modifyTheList(head); 
		
		// print the modified linked list 
		System.out.println( "Modified List:" ); 
		printList(head); 		

	} 
} 



/*

Modify contents of Linked List
Last Updated: 24-01-2020
Given a singly linked list containing n nodes. Modify the value of first half nodes
 such that 1st node’s new value is equal to the last node’s value minus first node’s 
 current value, 2nd node’s new value is equal to the second last node’s value minus 
 2nd node’s current value, likewise for first half nodes. If n is odd then the value 
 of the middle node remains unchanged.
(No extra memory to be used).

Input : 10 -> 4 -> 5 -> 3 -> 6
Output : 4 -> 1 -> 5 -> 3 -> 6

Input : 2 -> 9 -> 8 -> 12 -> 7 -> 10
Output : -8 -> 2 -> -4 -> 12 -> 7 -> 10*/