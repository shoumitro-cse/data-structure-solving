// How to create mergable stack using doubly linked list

// The class Node contains the structure of our Node of the linked list 

// javac -d classes MergableStack.java  && cd classes && java MergableStack && cd ..

import java.io.*; 

class Node 
{ 
	Node next; 
	Node prev; 
	int data; 
	
	// Create a node with the 
	// given value 
	Node(int value) 
	{ 
		data = value; 
		next = null; 
		prev = null; 
	} 
} 

class Stack { 
	
	private Node head; 
	private Node tail; 

	// Initialize stack class 
	// with its head and tail as null 
	Stack() 
	{ 
		head = null; 
		tail = null; 
	} 

	public void push(int value) 
	{ 
		Node newNode = new Node(value); 
		if(head == null) 
		{ 
			head = newNode; 
			head.next=null; 
			head.prev = null; 
			tail = newNode; 
		} 
		else
		{ 
			newNode.prev = tail; 
			tail.next = newNode; 
			tail = newNode; 
		} 
	} 

	public void pop() 
	{ 
		if(head == null) 
			System.out.println("stack underflow"); 
		
		if(head == tail) 
		{ 
			head = null; 
			tail = null; 
		} 
		else
		{ 
			Node n = tail; 
			tail = tail.prev; 
			n.prev = null; 
			tail.next = null; 
		} 
	} 

	public void merge(Stack s) 
	{ 
		head.prev = s.tail; 
		s.tail.next = head; 
		head = s.head; 
		// s.tail = null; 
		// s.head = null; 
	} 

	public void display() 
	{ 
		if(tail != null) 
		{ 
			Node n = tail; 
			while(n != null) { 
				System.out.print(n.data + " "); 
				n = n.prev; 
			} 
			System.out.println(); 
		} else { 
			System.out.println("Stack Underflow"); 
		} 
	} 
} 

class MergableStack { 

	public static void main (String[] args) { 
		
		Stack ms1 = new Stack(); 
		ms1.push(6); 
		ms1.push(5); 
		ms1.push(4); 

		Stack ms2 = new Stack(); 
		ms2.push(9); 
		ms2.push(8); 
		ms2.push(7); 
		
		ms1.merge(ms2); 
		
		ms1.display(); 
	} 
} 

