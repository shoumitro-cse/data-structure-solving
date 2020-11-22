// Java program to implement merge sort in singly linked list 
//Merge Sort for Doubly Linked List

// javac -d classes MergeSortDoublyLinkedList.java  && cd classes && java MergeSortDoublyLinkedList && cd ..

class MergeSortDoublyLinkedList { 

	static Node head; // head of list 

	/* Node Class */
	static class Node { 

		int data; 
		Node next, prev; 

		// Constructor to create a new node 
		Node(int d) { 
			data = d; 
			next = prev = null; 
		} 
	} 

	void print(Node node) { 
		Node temp = node; 

		System.out.println("Forward Traversal using next pointer"); 
		while (node != null) { 
			System.out.print(node.data + " "); 
			temp = node; 
			node = node.next; 
		}

		System.out.println("\nBackward Traversal using prev pointer"); 
		while (temp != null) { 
			System.out.print(temp.data + " "); 
			temp = temp.prev; 
		} 
	} 

	// Split a doubly linked list (DLL) into 2 DLLs of 
	// half sizes 
	Node split(Node head) { 
		Node fast = head, slow = head; 
		while (fast.next != null && fast.next.next != null) { 
			fast = fast.next.next; 
			slow = slow.next; 
		} 
		Node temp = slow.next; 
		slow.next = null; 
		return temp; 
	} 

   // Time Complexity:  Θ(nLogn) .
	Node mergeSort(Node start) { 
		if (start == null || start.next == null) { 
			return start; 
		} 

		Node second = split(start); 

		// Recur for left and right halves 
		start = mergeSort(start); 
		second = mergeSort(second); 

		// Merge the two sorted halves 
		return merge(start, second); 
	} 

	// Function to merge two linked lists 
	 // Time Complexity:  Θ(Log n) .
	Node merge(Node first, Node second) { 
		// If first linked list is empty 
		if (first == null) { 
			return second; 
		} 

		// If second linked list is empty 
		if (second == null) { 
			return first; 
		} 

		// Pick the smaller value 
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

	// Driver program to test above functions 
	public static void main(String[] args) { 

		MergeSortDoublyLinkedList list = new MergeSortDoublyLinkedList(); 

		list.head = new Node(10); 
		list.head.next = new Node(30); 
		list.head.next.next = new Node(3); 
		list.head.next.next.next = new Node(4); 
		list.head.next.next.next.next = new Node(20); 
		list.head.next.next.next.next.next = new Node(5); 
		
/*		System.out.println("Linked list before sorting :"); 
		list.print(list.head); 
		System.out.println(); */
		
		Node node = list.mergeSort(head); 

		System.out.println("Linked list after sorting :"); 
		list.print(node); 
		System.out.println(); 		

	} 
} 

