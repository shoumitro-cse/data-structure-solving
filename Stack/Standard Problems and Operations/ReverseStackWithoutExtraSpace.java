// Reverse a stack without using extra space in O(n)

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
	public void push(int data) 
	{ 
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

	// Reverses the stack using simple 
	// linked list reversal logic. 
	public void reverse() 
	{ 
		Node prev, cur, next_node; 
		cur = top; 
		prev = null; 
		while (cur != null) { 
			next_node = cur.next; 
			cur.next = prev; 
			prev = cur; 
			cur = next_node; 
		} 
		top = prev; 
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


/*Examples:

Input : 1->2->3->4
Output : 4->3->2->1

Input :  6->5->4
Output : 4->5->6*/