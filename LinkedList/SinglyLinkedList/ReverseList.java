// Java program to segregate even and odd nodes in a LinkedList
// javac -d classes ReverseList.java  && cd classes && java ReverseList  && cd ..

import java.util.*; 
class ReverseList 
{ 
	static Node head; // head of list 

	/* Linked list Node*/
	class Node 
	{ 
		int data; 
		Node next; 
		Node(int d) 
		{ 
			data = d; 
			next = null; 
		} 
	} 


	/* Given a reference (pointer to pointer) to the head 
		of a list and an int, push a new node on the front 
		of the list. */
	void push(int new_data) 
	{ 
		/* 1 & 2: Allocate the Node & 
				Put in the data*/
		Node new_node = new Node(new_data); 

		/* 3. Make next of new Node as head */
		new_node.next = head; 

		/* 4. Move the head to point to new Node */
		head = new_node; 
	} 

	// Utility function to print a linked list 
	// void printList(Node head) 
	// { 
	// 	Node temp = head; 
	// 	while(temp != null) 
	// 	{ 
	// 		System.out.print(temp.data+" "); 
	// 		temp = temp.next; 
	// 	} 
	// 	System.out.println(); 
	// } 	

	// Time Complexity: O(n)
	void printList(Node head) { 
		if(head == null) return;
		printList(head.next);
		System.out.print(head.data + " "); 
	} 


	// Node reverseGroup(Node head, int k) {
	//    // Create a stack of Node*  
	//     Stack<Node> mystack = new Stack<Node> ();  
	//     Node current = head;  
	//     Node prev = null;  
	  
	//     while (current != null) {  
	  
	//         // Terminate the loop whichever comes first  
	//         // either current == NULL or count >= k  
	//         int count = 0;  
	//         while (current != null && count < k) {  
	//             mystack.push(current);  
	//             current = current.next;  
	//             count++;  
	//         }  
	  
	//         // Now pop the elements of stack one by one  
	//         while (mystack.size() > 0) {  
	//   	        if (prev == null) {  
	//                 prev = mystack.peek();  
	//                 head = prev;  
	//                 mystack.pop();  
	//             }  
	//             else {  
	//                 prev.next = mystack.peek();  
	//                 prev = prev.next;  
	//                 mystack.pop();  
	//             }  
	//         } 

	//     }  
	  
	//     // Next of last element will point to NULL.  
	//     prev.next = null;  
	  
	//     return head; 
	// }


	/*Time Complexity: O(n).
	Traversal of list is done only once and it has ‘n’ elements.
	Auxiliary Space: O(n/k).
	For each Linked List of size n, n/k or (n/k)+1 calls will be made during the recursion.*/
	Node reverseGroup(Node head, int k) {
		Node current=head, prev=null, next_node=null;
		int c = 0;
        while(c < k && current != null) {
           next_node = current.next;
           current.next = prev;
           prev = current;
           current = next_node;
           c++;
        }

        if(next_node != null)
        	head.next = reverseGroup(next_node, k);
        // System.out.println();
        // printList(head);
        // System.out.println();
		return prev;
	}	

	Node kThAlternateReverse(Node head, int k) {

		Node current=head, prev=null, next_node=null;
		int c = 0;

        /*1) reverse first k nodes of the linked list */
        while(c<k && current != null) {
           next_node = current.next;
           current.next = prev;
           prev = current;
           current = next_node;
           c++;
        }

        /* 2) Now head points to the kth node. So change next of head to (k+1)th node*/
        if(head != null)
        	head.next = current;

/*        System.out.println();
        printList(head);
        System.out.println();*/

       /* 3) We do not want to reverse next k nodes. 
          So move the current pointer to skip next k nodes */
        c=0;
        while(c<k-1 && current != null) {
           current = current.next;
           c++;
        }

       /* 4) Recursively call for the list starting from current->next. 
         And make rest of the list as next of first node */
        if(current != null)
        	current.next = kThAlternateReverse(current.next, k);

       /* 5) prev is new head of the input list */
		return prev;
	}

/*// to reverse a linked list using two pointers. 
	Node reverseList(Node head) {
		Node curr = head;
		Node next_node = null;
		while (curr.next != null) {
          next_node = curr.next;
          curr.next = next_node.next;
          next_node.next = head;
          head = next_node; 
          // System.out.println();
          // System.out.println();
          // printList(head);
          // System.out.println();
          // System.out.println();
		}
		return head;
	}*/

/*	Node reverseList(Node head) {
		Node curr = head;
		Node prev = null;
		while (curr != null) {
          Node next = curr.next;
          curr.next = prev;
          prev = curr;

          curr = next; //increemrnt
		}

		head = prev;
		return head;
	}*/


/*   // Time Complexity: O(n) 
   // Space Complexity: O(1)
    Node reverseList(Node node) {
		if(node == null || node.next == null) return node;
		Node head = reverseList(node.next);
		node.next.next = node;
		node.next=null;

	    ReverseList llist = new ReverseList(); 
		// llist.printList(head); // for debug

		return head;
	}*/





	/* Driver program to test above functions */
	public static void main(String args[]) 
	{ 
		ReverseList llist = new ReverseList(); 
        llist.push(8); 
        llist.push(7); 
        llist.push(6); 
        llist.push(5); 
        llist.push(4); 
        llist.push(3); 
        llist.push(2); 
        llist.push(1); 

		System.out.println("Origional Linked List"); 
		llist.printList(llist.head); 

		// System.out.println("\Reverse Linked List"); 
		// llist.printList(llist.reverseList(llist.head)); 
		// System.out.println(); 

		// System.out.println("\nreverse Group Linked List"); 
		// llist.printList(llist.reverseGroup(llist.head, 2)); 
		// System.out.println(); 

		System.out.println("\nreverse Group Linked List"); 
		llist.printList(llist.kThAlternateReverse(llist.head, 2)); 
		System.out.println(); 
	} 
} 
