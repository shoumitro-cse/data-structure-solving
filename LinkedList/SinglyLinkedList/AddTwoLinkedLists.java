// Java program to add two numbers 
// represented by linked list 

//javac -d classes AddTwoLinkedLists.java  && cd classes && java AddTwoLinkedLists  && cd ..
class AddTwoLinkedLists { 

	static Node head1, head2; 

	static class Node { 

		int data; 
		Node next; 

		Node(int d) 
		{ 
			data = d; 
			next = null; 
		} 
	} 


	/*1. Time Complexity: O(m + n), 
	  where m and n are number of nodes in first and second lists respectively.

	2. Space Complexity: O(m + n).
	   A temporary linked list is needed to store the output number*/
	Node addTwoLists(Node first, Node second) {

		Node res = null; 
		Node prev = null; 
		Node temp = null; 
		int carry = 0, sum; 

		// while both lists exist 
		while (first != null || second != null) { 
            // addition of two number and sum greater then 10 then carry update
			sum = carry + (first != null ? first.data : 0) + (second != null ? second.data : 0); 

			// update carry for next calulation 
			carry = (sum >= 10) ? 1 : 0; 

			// update sum if it is greater than 10 
			// System.out.println(sum);
			sum = sum % 10; 
			// System.out.println(sum);

			// Create a new node with sum as data 
			temp = new Node(sum); 

			// if this is the first node then set 
			// it as head of the resultant list 
			if (res == null) { 
				res = temp; 
			} else { 
				prev.next = temp; 
			} 

			// Set prev for next insertion 
			prev = temp; 

			// Move first and second pointers 
			// to next nodes 
			if (first != null) { 
				first = first.next; 
			} 
			if (second != null) { 
				second = second.next; 
			} 
		} 

		if (carry > 0) { 
			temp.next = new Node(carry); 
		} 

		// return head of the resultant list 
		return res; 
	} 
	/* Utility function to print a linked list */

	void printList(Node head) 
	{ 
		while (head != null) { 
			System.out.print(head.data + " "); 
			head = head.next; 
		} 
		System.out.println(""); 
	} 

	public static void main(String[] args) 
	{ 
		AddTwoLinkedLists list = new AddTwoLinkedLists(); 

		// creating first list 
		list.head1 = new Node(7); 
		list.head1.next = new Node(5); 
		list.head1.next.next = new Node(9); 
		list.head1.next.next.next = new Node(4); 
		list.head1.next.next.next.next = new Node(6); 
		System.out.print("First List is "); 
		list.printList(head1); 

		// creating seconnd list 
		list.head2 = new Node(8); 
		list.head2.next = new Node(4); 
		System.out.print("Second List is "); 
		list.printList(head2); 

		// add the two lists and see the result 
		Node rs = list.addTwoLists(head1, head2); 
		System.out.print("Resultant List is "); 
		list.printList(rs); 
	} 
} 

/*
1. Problem:

Add two numbers represented by linked lists | Set 1
Last Updated: 08-06-2020
Given two numbers represented by two lists, write a function that returns the sum list. The sum list is list representation of the addition of two input numbers.
Example:

Input:
List1: 5->6->3 // represents number 365
List2: 8->4->2 // represents number 248
Output:
Resultant list: 3->1->6 // represents number 613
Explanation: 365 + 248 = 613

Input:
List1: 7->5->9->4->6 // represents number 64957
List2: 8->4 // represents number 48
Output:
Resultant list: 5->0->0->5->6 // represents number 65005
Explanation: 64957 + 48 = 65005*/