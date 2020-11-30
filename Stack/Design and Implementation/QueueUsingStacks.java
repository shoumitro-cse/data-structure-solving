// Queue using Stacks

// javac -d classes QueueUsingStacks.java  && cd classes && java QueueUsingStacks && cd ..

import java.util.*; 

class QueueUsingStacks 
{ 
	static class Queue { 

		static Stack<Integer> stack1 = new Stack<Integer>(); 
		static Stack<Integer> stack2 = new Stack<Integer>(); 

		static void enQueue(int x) { //insert
			// Move all elements from stack1 to stack2 
			while (!stack1.isEmpty()) { 
				stack2.push(stack1.pop()); 
				//stack1.pop(); 
			} 
			// Push item into stack1 
			stack1.push(x); 
			// Push everything back to stack1 
			while (!stack2.isEmpty()) { 
				stack1.push(stack2.pop()); 
				//stack2.pop(); 
			} 
		} 

		// Dequeue an item from the queue 
		static int deQueue() { // delete
			// if first stack is empty 
			if (stack1.isEmpty()) { 
				System.out.println("Q is Empty"); 
				System.exit(0); 
			} 
			// Return top of stack1 
			int x = stack1.peek(); 
			stack1.pop(); 
			return x; 
		} 
	}; 

	// Driver code 
	public static void main(String[] args) 
	{ 
		Queue q = new Queue(); 
		q.enQueue(1); 
		q.enQueue(2); 
		q.enQueue(3); 

		System.out.println(q.deQueue()); 
		System.out.println(q.deQueue()); 
		System.out.println(q.deQueue()); 
	} 
} 



/*Complexity Analysis:

Time Complexity:

Push operation: O(N).
In the worst case we have empty whole of stack 1 into stack 2.

Pop operation: O(1).
Same as pop operation in stack.

Auxiliary Space: O(N).
Use of stack for storing values.*/


/*// Java Program to implement a queue using one stack 

import java.util.Stack; 

public class QOneStack { 
	// class of queue having two stacks 
	static class Queue { 
		Stack<Integer> stack1; 
	} 

	 // Function to push an item to stack
	static void push(Stack<Integer> top_ref, int new_data) 
	{ 
		 // put in the data 
		top_ref.push(new_data); 
	} 

	 // Function to pop an item from stack
	static int pop(Stack<Integer> top_ref) 
	{ 
		// If stack is empty then error 
		if (top_ref == null) { 
			System.out.println("Stack Underflow"); 
			System.exit(0); 
		} 
		// return element from stack 
		return top_ref.pop(); 
	} 

	 // Function to enqueue an item to queue 
	static void enQueue(Queue q, int x) 
	{ 
		push(q.stack1, x); 
	} 

	 // Function to deQueue an item from queue 
	static int deQueue(Queue q) 
	{ 
		int x, res = 0; 
		 If the stacks is empty then error 
		if (q.stack1.isEmpty()) { 
			System.out.println("Q is Empty"); 
			System.exit(0); 
		} 
		// Check if it is a last element of stack 
		else if (q.stack1.size() == 1) { 
			return pop(q.stack1); 
		} 
		else { 

			 // pop an item from the stack1 
			x = pop(q.stack1); 

			 // store the last deQueued item 
			res = deQueue(q); 

			 // push everything back to stack1 
			push(q.stack1, x); 
			return res; 
		} 
		return 0; 
	} 

	 // Driver function to test above functions 
	public static void main(String[] args) 
	{ 
		 // Create a queue with items 1 2 3
		Queue q = new Queue(); 
		q.stack1 = new Stack<>(); 

		enQueue(q, 1); 
		enQueue(q, 2); 
		enQueue(q, 3); 

		 // Dequeue items 
		System.out.print(deQueue(q) + " "); 
		System.out.print(deQueue(q) + " "); 
		System.out.print(deQueue(q) + " "); 
	} 
} 
*/



/*Complexity Analysis:

Time Complexity:
Push operation : O(1).
Same as pop operation in stack.
Pop operation : O(N).
The difference from above method is that in this method element is returned and all elements are restored back in a single call.
Auxiliary Space: O(N).
Use of stack for storing values.*/





 // Java Program to implement a queue using two stacks 
// Note that Stack class is used for Stack implementation 

/*
import java.util.Stack; 

public class GFG { 
	 // class of queue having two stacks 
	static class Queue { 
		Stack<Integer> stack1; 
		Stack<Integer> stack2; 
	} 

	 // Function to push an item to stack
	static void push(Stack<Integer> top_ref, int new_data) 
	{ 
		// Push the data onto the stack 
		top_ref.push(new_data); 
	} 

	 // Function to pop an item from stack
	static int pop(Stack<Integer> top_ref) 
	{ 
		// If stack is empty then error 
		if (top_ref.isEmpty()) { 
			System.out.println("Stack Underflow"); 
			System.exit(0); 
		} 

		// pop the data from the stack 
		return top_ref.pop(); 
	} 

	// Function to enqueue an item to the queue 
	static void enQueue(Queue q, int x) 
	{ 
		push(q.stack1, x); 
	} 

	 // Function to deQueue an item from queue 
	static int deQueue(Queue q) 
	{ 
		int x; 

		 // If both stacks are empty then error 
		if (q.stack1.isEmpty() && q.stack2.isEmpty()) { 
			System.out.println("Q is empty"); 
			System.exit(0); 
		} 

		 // Move elements from stack1 to stack 2 only if stack2 is empty 
		if (q.stack2.isEmpty()) { 
			while (!q.stack1.isEmpty()) { 
				x = pop(q.stack1); 
				push(q.stack2, x); 
			} 
		} 
		x = pop(q.stack2); 
		return x; 
	} 

	 // Driver function to test above functions 
	public static void main(String args[]) 
	{ 
		 // Create a queue with items 1 2 3
		Queue q = new Queue(); 
		q.stack1 = new Stack<>(); 
		q.stack2 = new Stack<>(); 
		enQueue(q, 1); 
		enQueue(q, 2); 
		enQueue(q, 3); 

		 // Dequeue items 
		System.out.print(deQueue(q) + " "); 
		System.out.print(deQueue(q) + " "); 
		System.out.println(deQueue(q) + " "); 
	} 
} 
*/

/*Complexity Analysis:

Time Complexity:
Push operation: O(1).
Same as pop operation in stack.
Pop operation: O(N).
In the worst case we have empty whole of stack 1 into stack 2
Auxiliary Space: O(N).
Use of stack for storing values.*/