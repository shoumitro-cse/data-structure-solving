// Java program to Multiply two numbers represented as linked lists 
// /javac -d classes MultiplyTwoNumbers.java  && cd classes && java MultiplyTwoNumbers && cd ..

class MultiplyTwoNumbers { 

	// Linked list node 
	static class node 
	{ 
		int data; 
		node next; 
	}; 

	// Function to create a new node 
	// with given data 
	static node newNode(int data) 
	{ 
		node new_node = new node(); 
		new_node.data = data; 
		new_node.next = null; 
		return new_node; 
	} 

	// Function to insert a node at the 
	// beginning of the Linked List 
	static node push( node head_ref, int new_data) 
	{ 
		// allocate node 
		node new_node = newNode(new_data); 

		// link the old list off the new node 
		new_node.next = (head_ref); 

		// move the head to point to the new node 
		(head_ref) = new_node; 
		return head_ref; 
	} 

	// Multiply contents of two linked lists 
	static long multiplyTwoLists ( node first, node second) { 

		int num1 = 0, num2 = 0; 
		
		// Generate numbers from linked lists 
		while (first != null || second != null) { 
			if (first != null) { 
				num1 = num1*10 + first.data; 
				first = first.next; 
			} 
			if (second != null) { 
				num2 = num2*10 + second.data; 
				second = second.next; 
			} 
		} 

		// Return multiplication of 
		// two numbers 
		return num1*num2; 
	} 

	// A utility function to print a linked list 
	static void printList( node node) 
	{ 
		while(node != null) 
		{ 
			System.out.printf("%d", node.data); 
			if(node.next != null) 
				System.out.printf("->"); 
			node = node.next; 
		} 
		System.out.printf("\n"); 
	} 

	// Driver code 
	public static void main(String args[]) 
	{ 
		node first = null; 
		node second = null; 

		// create first list 9.4.6 
		first = push(first, 6); 
		first = push(first, 4); 
		first = push(first, 9); 
		System.out.printf("First List is: "); 
		printList(first); 

		// create second list 8.4 
		second = push(second, 4); 
		second = push(second, 8); 
		System.out.printf("Second List is: "); 
		printList(second); 

		// Multiply the two lists and see result 
		System.out.printf("Result is: "); 
		System.out.println(multiplyTwoLists(first, second)); 
	} 
} 

/*
Multiply two numbers represented by Linked Lists
Given two numbers represented by linked lists,
 write a function that returns the multiplication of these two linked lists.

Examples:

Input : 9->4->6
        8->4
Output : 79464

Input : 3->2->1
        1->2
Output : 3852



Algorithm to generate the number from linked list representation:

1) Initialize a variable to zero
2) Start traversing the linked list
3) Add the value of first node to this variable
4) From the second node, multiply the variable by 10
   first and then add the value of the node to this 
   variable.
5) Repeat step 4 until we reach the last node of the list. 



*/