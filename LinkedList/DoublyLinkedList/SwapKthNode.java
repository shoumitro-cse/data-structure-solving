// Swap Kth node from beginning with Kth node from end in a Linked List

// javac -d classes SwapKthNode.java  && cd classes && java SwapKthNode && cd .. 

class Node { 
	int data; 
	Node next; 
	Node(int d) 
	{ 
		data = d; 
		next = null; 
	} 
} 

class SwapKthNode { 

	Node head; 

	/* Utility function to insert 
	a node at the beginning */
	void push(int new_data) 
	{ 
		Node new_node = new Node(new_data); 
		new_node.next = head; 
		head = new_node; 
	} 

	/* Utility function for displaying linked list */
	void printList() 
	{ 
		Node node = head; 
		while (node != null) { 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(""); 
	} 

	/* Utility function for calculating 
	length of linked list */
	int countNodes() 
	{ 
		int count = 0; 
		Node s = head; 
		while (s != null) { 
			count++; 
			s = s.next; 
		} 
		return count; 
	} 

	/*Complexity Analysis:

	Time Complexity: O(n), where n is the length of the list.
	One traversal of the list is needed.
	Auxiliary Space: O(1).
	No extra space is required.*/
	void swapKth(int k) { 
		// Count nodes in linked list 
		int n = countNodes(); 

		// Check if k is valid 
		if (n < k) 
			return; 

		// If x (kth node from start) and y(kth node from end) are same 
		if (2 * k - 1 == n) 
			return; 

		// Find the kth node from beginning of linked list. 
		// We also find previous of kth node because we need 
		// to update next pointer of the previous. 
		Node x = head; 
		Node x_prev = null; 
		for (int i = 1; i < k; i++) { 
			x_prev = x; 
			x = x.next; 
		} 

		// Similarly, find the kth node from end and its 
		// previous. kth node from end is (n-k+1)th node from beginning 
		Node y = head; 
		Node y_prev = null; 
		for (int i = 1; i < n - k + 1; i++) { 
			y_prev = y; 
			y = y.next; 
		} 

		if (x_prev != null) 
			x_prev.next = y; 

		// Same thing applies to y_prev 
		if (y_prev != null) 
			y_prev.next = x; 

		// Swap next pointers of x and y. T
		Node temp = x.next; 
		x.next = y.next; 
		y.next = temp; 

		// Change head pointers when k is 1 or n 
		if (k == 1) 
			head = y; 

		if (k == n) 
			head = x; 
	} 

	// Driver code to test above 
	public static void main(String[] args) {

		SwapKthNode llist = new SwapKthNode(); 

		for (int i = 8; i >= 1; i--) 
			llist.push(i); 

		System.out.print("Original linked list: "); 
		llist.printList(); 
		System.out.println(""); 

		for (int i = 1; i < 9; i++) { 
			llist.swapKth(i); 
			System.out.println("Modified List for k = " + i); 
			llist.printList(); 
			System.out.println(""); 
		} 

	} 
} 



/*Swap Kth node from beginning with Kth node from end in a Linked List
Given a singly linked list, swap kth node from beginning with kth node from end. 
Swapping of data is not allowed, only pointers should be changed. 
This requirement may be logical in many situations where the linked list data part 
is huge (For example student details line Name, RollNo, Address, ..etc). 
The pointers are always fixed (4 bytes for most of the compilers).

Example:

Input: 1 -> 2 -> 3 -> 4 -> 5, K = 2
Output: 1 -> 4 -> 3 -> 2 -> 5 
Explanation: The 2nd node from 1st is 2 and 
2nd node from last is 4, so swap them.


Input: 1 -> 2 -> 3 -> 4 -> 5, K = 5
Output: 5 -> 2 -> 3 -> 4 -> 1 
Explanation: The 5th node from 1st is 5 and 
5th node from last is 1, so swap them.*/