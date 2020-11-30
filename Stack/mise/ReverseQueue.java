// Java program to reverse a Queue 

//javac -d classes ReverseQueue.java  && cd classes && java ReverseQueue && cd ..

import java.util.LinkedList; 
import java.util.Queue; 
import java.util.Stack; 

// Java program to reverse a queue 
public class ReverseQueue { 
	
	static Queue<Integer> queue; 

	// Utility function to print the queue 
	static void Print() 
	{ 
		while (!queue.isEmpty()) { 
			System.out.print( queue.peek() + ", "); 
			queue.remove(); 
		} 
		System.out.println(""); 
	} 

	// Function to reverse the queue 
	static void reversequeue() 
	{ 
		Stack<Integer> stack = new Stack<>(); 
		while (!queue.isEmpty()) { 
			stack.add(queue.peek()); 
			queue.remove(); 
		} 
		while (!stack.isEmpty()) { 
			queue.add(stack.peek()); 
			stack.pop(); 
		} 
	} 

	// Driver code 
	public static void main(String args[]) 
	{ 
		queue = new LinkedList<Integer>(); 
		queue.add(10); 
		queue.add(20); 
		queue.add(30); 
		queue.add(40); 
		queue.add(50); 
		queue.add(60); 
		queue.add(70); 
		queue.add(80); 
		queue.add(90); 
		queue.add(100); 
		// rear-->10,.........100<--front

		reversequeue(); 
		Print(); 
	} 
} 


/*Reversing a Queue

Give an algorithm for reversing a queue Q. 
Only following standard operations are allowed on queue.

enqueue(x) : Add an item x to rear of queue.
dequeue() : Remove an item from front of queue.
empty() : Checks if a queue is empty or not.
Examples:

Input :  Q = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
Output : Q = [100, 90, 80, 70, 60, 50, 40, 30, 20, 10]

Input : [1, 2, 3, 4, 5]
Output : [5, 4, 3, 2, 1]*/