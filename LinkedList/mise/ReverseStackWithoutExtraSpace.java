// Java program to implement Stack using linked list so that reverse can be done with O(1) extra space. 

//javac -d classes ReverseStackWithoutExtraSpace.java  && cd classes && java ReverseStackWithoutExtraSpace && cd ..

class Node { 
	int data; 
	Node next; 
	public Node(int data) { 
		this.data = data; 
		this.next = null; 
	} 
} 

class Stack {

	Node top; 

	// Push and pop operations 
	public void push(int data) {

		if (this.top == null) { 
			top = new Node(data); 
			return; 
		} 
		Node s = new Node(data); 
		s.next = this.top; 
		this.top = s; 
	} 
	public Node pop() 
	{ 
		Node s = this.top; 
		this.top = this.top.next; 
		return s; 
	} 

	// prints contents of stack 
	public void display() 
	{ 
		Node s = this.top; 
		while (s != null) { 
			System.out.print(s.data + " "); 
			s = s.next; 
		} 
		System.out.println(); 
	} 

	// Reverses the stack using simple linked list reversal logic. 
	public void reverse() 
	{ 
		Node prev, cur, next; 
		cur = prev = this.top; 
		cur = cur.next; 
		prev.next = null; 
		while (cur != null) { 
			next = cur.next; 
			cur.next = prev; 
			prev = cur; 
			
			cur = next; 
		} 
		this.top = prev; 
	} 
} 

public class ReverseStackWithoutExtraSpace { 

	public static void main(String[] args) 
	{ 
		Stack s = new Stack(); 
		s.push(1); 
		s.push(2); 
		s.push(3); 
		s.push(4); 
		System.out.println("Original Stack"); 
		s.display(); 

		// reverse 
		s.reverse(); 

		System.out.println("Reversed Stack"); 
		s.display(); 
	} 
} 
