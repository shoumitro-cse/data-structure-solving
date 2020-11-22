// Sorted insert for circular linked list
//javac -d classes SortedInsert.java  && cd classes && java SortedInsert && cd ..
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

class SortedInsert {

	Node head; 

	// Constructor 
	SortedInsert() { 
		head = null; 
	} 

	/* function to insert a new_node in a list in sorted way. 
	Note that this function expects a pointer to head node 
	as this can modify the head of the input linked list */
	// Time Complexity: O(n) where n is the number of nodes in the given linked list.
	void sortedInsert(Node new_node) { 

		Node current = head; 

		// Case 1 of the above algo 
		if (current == null) { 
			new_node.next = new_node; 
			head = new_node; 
		} else if (current.data >= new_node.data) { 
			// Case 2 of the above algo 
			/* If value is smaller than head's value then we need to change next of last node */
			while (current.next != head) {
				current = current.next; 
			}

			current.next = new_node; 
			new_node.next = head; 
			head = new_node; 
		} else { 
			 // Case 3 of the above algo 
			/* Locate the node before the point of insertion */
			while (current.next != head && current.next.data < new_node.data) {
				current = current.next; 
			}

			new_node.next = current.next; 
			current.next = new_node; 
		} 
	} 

	// Utility method to print a linked list 
	void printList() { 

		if (head != null) { 
			Node temp = head; 
			do { 
				System.out.print(temp.data + " "); 
				temp = temp.next; 
			} while (temp != head); 
		   System.out.println(); 
		} 
	} 

	// Driver code to test above 
	public static void main(String[] args) { 

		SortedInsert list = new SortedInsert(); 

		// Creating the linkedlist 
		int arr[] = new int[] {12, 56, 2, 11, 1, 90}; 

		/* start with empty linked list */
		Node temp = null; 

		/* Create linked list from the array arr[]. 
		Created linked list will be 1->2->11->12->56->90*/
		for (int i = 0; i < 6; i++) { 
			temp = new Node(arr[i]); 
			list.sortedInsert(temp); 
		} 

		list.printList(); 
	} 
} 


/*
Algorithm:

Allocate memory for the newly inserted node and put data in the newly allocated node.
Let the pointer to the new node be new_node.
 After memory allocation, following are the three cases that need to be handled.

1) Linked List is empty:  
    a)  since new_node is the only node in CLL, make a self loop.      
          new_node->next = new_node;  
    b) change the head pointer to point to new node.
          *head_ref = new_node;
2) New node is to be inserted just before the head node:    
  (a) Find out the last node using a loop.
         while(current->next != *head_ref)
            current = current->next;
  (b) Change the next of last node. 
         current->next = new_node;
  (c) Change next of new node to point to head.
         new_node->next = *head_ref;
  (d) change the head pointer to point to new node.
         *head_ref = new_node;
3) New node is to be  inserted somewhere after the head: 
   (a) Locate the node after which new node is to be inserted.
         while ( current->next!= *head_ref && 
             current->next->data data)
         {   current = current->next;   }
   (b) Make next of new_node as next of the located pointer
         new_node->next = current->next;
   (c) Change the next of the located pointer
         current->next = new_node; */