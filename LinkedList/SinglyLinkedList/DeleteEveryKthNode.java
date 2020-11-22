// Java program to delete every k-th Node of a singly linked list. 
// /javac -d classes DeleteEveryKthNode.java  && cd classes && java DeleteEveryKthNode && cd ..

class DeleteEveryKthNode { 

	/* Linked list Node */
	static class Node { 
		int data; 
		Node next; 
	} 

	// To remove complete list (Needed for 
	// case when k is 1) 
	static Node freeList(Node node) 
	{ 
		while (node != null) 
		{ 
			Node next = node.next; 
			node = next; 
		} 
		return node; 
	} 

	// Deletes every k-th node and returns head of modified list. 
	// Time Complexity : O(n)
	static Node deleteKthNode(Node head, int k) { 
		
		// If linked list is empty 
		if (head == null) {
			return null; 
		}

		if (k == 1) { 
			head = freeList(head); 
			return null; 
		} 
		// Initialize ptr and prev before starting traversal. 
		Node ptr = head, prev = null; 

		// Traverse list and delete every k-th node 
		int count = 0; 
		while (ptr != null) { 
			// increment Node count 
			count++; 
			// check if count is equal to k if yes, then delete current Node 
			if (k == count) { 
				// put the next of current Node in the next of previous Node 
				prev.next = ptr.next; 
				// set count = 0 to reach further k-th Node 
				count = 0; 
			} 
			// update prev if count is not 0 
			if (count != 0) {
				prev = ptr; 
			}
			ptr = prev.next; 
		} 
		return head; 
	} 

	/* Function to print linked list */
	static void displayList(Node head) 
	{ 
		Node temp = head; 
		if (head == null) {
			System.out.println("Empty list"); 
		}
		while (temp != null) 
		{ 
			System.out.print(temp.data + " "); 
			temp = temp.next; 
		} 
	} 

	// Utility function to create a new node. 
	static Node newNode(int x) 
	{ 
		Node temp = new Node(); 
		temp.data = x; 
		temp.next = null; 
		return temp; 
	} 

	// Driver Code 
	public static void main(String args[]) { 
		/* Start with the empty list */
		Node head = newNode(1); 
		head.next = newNode(2); 
		head.next.next = newNode(3); 
		head.next.next.next = newNode(4); 
		head.next.next.next.next = newNode(5); 
		head.next.next.next.next.next = newNode(6); 
		head.next.next.next.next.next.next = newNode(7); 
		head.next.next.next.next.next.next.next = newNode(8); 

		displayList(head); 
		System.out.println();

		int k = 3; 
		head = deleteKthNode(head, k); 

		displayList(head); 
		System.out.println();
	} 
} 

/*Remove every k-th node of the linked list
Given a singly linked list, Your task is to remove every K-th node of the linked list.
 Assume that K is always less than or equal to length of Linked List.

Examples :

Input : 1->2->3->4->5->6->7->8  
        k = 3
Output : 1->2->4->5->7->8
As 3 is the k-th node after its deletion list 
would be 1->2->4->5->6->7->8
And now 4 is the starting node then from it, 6 
would be the k-th node. So no other kth node 
could be there.So, final list is:
1->2->4->5->7->8.

Input: 1->2->3->4->5->6  
       k = 1
Output: Empty list 
All nodes need to be deleted



Algorithm:

(1) Traverse list and do following
   (a) Count node before deletion.
   (b) If (count == k) that means current 
        node is to be deleted.
      (i)  Delete current node i.e. do

          //  assign address of next node of 
          // current node to the previous node
          // of the current node.
          prev->next = ptr->next i.e.

       (ii) Reset count as 0, i.e., do count = 0.
   (c) Update prev node if count != 0 and if
       count is 0 that means that node is a
       starting point.
   (d) Update ptr and continue until all 
       k-th node gets deleted.

*/