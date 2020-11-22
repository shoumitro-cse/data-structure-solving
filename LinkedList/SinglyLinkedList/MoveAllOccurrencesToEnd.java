// Move all occurrences of an element to end in a linked list

// javac -d classes MoveAllOccurrencesToEnd.java  && cd classes && java MoveAllOccurrencesToEnd && cd ..
class MoveAllOccurrencesToEnd { 

	// A Linked list Node 
	static class Node { 
		int data; 
		Node next; 
	} 

	// A urility function to create a new node. 
	static Node newNode(int x) { 
		Node temp = new Node(); 
		temp.data = x; 
		temp.next = null; 
		return temp; 
	} 

	// Utility function to print the elements in Linked list 
	static void printList(Node head) { 
		Node temp = head; 
		while (temp != null) { 
			System.out.printf("%d ", temp.data); 
			temp = temp.next; 
		} 
		System.out.printf("\n"); 
	} 

	// Moves all occurrences of given key to end of linked list. 
	// Time Complexity : O(n) requires only one traversal of list.
	static void moveToEnd(Node head, int key) { 

		Node ptr_key = head; 

		// Traverse list 
		Node curr = head; 
		
		while (curr != null) { 

			if (curr != ptr_key && curr.data != key) { 
				// System.out.println("data : "+curr.data+" "+ptr_key.data);
				ptr_key.data = curr.data; 
				curr.data = key; 
				ptr_key = ptr_key.next; 
			} 
			
		/*  20 10 10 30 40 10 60
			20 30 10 10 40 10 60
			20 30 40 60 10 10 10*/
			
			// 10 20 10 30 40 10 60  key=10. Find next position where key is present 
			if (ptr_key.data != key) {
				ptr_key = ptr_key.next; 
			}

			// Moving to next Node 
			curr = curr.next; 
		} 
	} 


	    // Function to remove key to end 
    public static Node keyToEnd(Node head, int key) { 
  
        // Node to keep pointing to tail 
        Node tail = head; 
  
        if (head == null) { 
            return null; 
        } 
  
        while (tail.next != null) { 
            tail = tail.next; 
        } 
  
        // Node to point to last of linked list 
        Node last = tail; 
  
        Node current = head; 
        Node prev = null; 
  
        // Node prev2 to point to previous when head.data!=key 
        Node prev2 = null; 
  
        // loop to perform operations to remove key to end 
        while (current != tail) { 

            if (current.data == key && prev2 == null) { 
                prev = current; 
                current = current.next; 
                head = current; 
                last.next = prev; 
                last = last.next; 
                last.next = null; 
                // prev = null; 
            } else { 

                if (current.data == key && prev2 != null) { 
                    prev = current; 
                    current = current.next; 
                    prev2.next = current; 
                    last.next = prev; 
                    last = last.next; 
                    last.next = null; 
                    // prev = null; 
                } else if (current != tail) { 
                    prev2 = current; 
                    current = current.next; 
                } 
            } 
        } 
        return head; 
    } 

	// Driver code 
	public static void main(String args[]) 
	{ 
		Node head = newNode(10); 
		head.next = newNode(20); 
		head.next.next = newNode(10); 
		head.next.next.next = newNode(30); 
		head.next.next.next.next = newNode(40); 
		head.next.next.next.next.next = newNode(10); 
		head.next.next.next.next.next.next = newNode(60); 

		System.out.printf("Before moveToEnd(), the Linked list is\n"); 
		printList(head); 

		int key = 10; 
		// moveToEnd(head, key); 
		head = keyToEnd(head, key); 

		System.out.printf("\nAfter moveToEnd(), the Linked list is\n"); 
		printList(head); 
	} 
} 



/*Move all occurrences of an element to end in a linked list
Given a linked list and a key in it, 
the task is to move all occurrences of given key to end of linked list, 
keeping order of all other elements same.

Examples:

Input  : 1 -> 2 -> 2 -> 4 -> 3
         key = 2 
Output : 1 -> 4 -> 3 -> 2 -> 2

Input  : 6 -> 6 -> 7 -> 6 -> 3 -> 10
         key = 6
Output : 7 -> 3 -> 10 -> 6 -> 6 -> 6*/