// Java program to reverse first k elements of a queue. 

// javac -d classes ReverseFirsKelementsofQueue.java  && cd classes && java ReverseFirsKelementsofQueue && cd ..

import java.util.LinkedList; 
import java.util.Queue; 
import java.util.Stack; 

public class ReverseFirsKelementsofQueue { 

	static Queue<Integer> queue; 

	// Function to reverse the first 
	// K elements of the Queue 
	static void reverseQueueFirstKElements(int k) {

		if (queue.isEmpty() == true || k > queue.size()) 
			return; 

		if (k <= 0) 
			return; 

		Stack<Integer> stack = new Stack<Integer>(); 

		// Push the first K elements into a Stack 
		for (int i = 0; i < k; i++) { 
			stack.push(queue.peek()); 
			queue.remove(); 
		} 

		// Enqueue the contents of stack at the back of the queue 
		while (!stack.empty()) { 
			queue.add(stack.peek()); 
			stack.pop();  
		} 

		// Remove the remaining elements and enqueue them at the end of the Queue 
		for (int i = 0; i < queue.size()-k; i++) { 
			queue.add(queue.peek()); 
			queue.remove(); 
		} 

	} 

	// Utility Function to print the Queue 
	static void Print() 
	{ 
		while (!queue.isEmpty()) { 
			System.out.print(queue.peek() + " "); 
			queue.remove(); 
		} 
	   System.out.println(" "); 
	} 

	// Driver code 
	public static void main(String args[]) 
	{ 
		// rear->100, 90, 80, 70, 60, 50, 40, 30, 20, 1<- front
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

		int k = 5; 
		reverseQueueFirstKElements(k); 
		Print(); 
	} 
} 



/*Reversing the first K elements of a Queue

Complexity Analysis:

Time Complexity: O(n+k).
Where ‘n’ is the total number of elements in the queue and ‘k’ is the number of elements 
to be reversed. This is because firstly the whole queue is emptied into the stack and after 
that first ‘k’ elements are emptied and enqueued in the same way.

Auxiliary Space :Use of stack to store values for the purpose of reversing-: O(n)


Given an integer k and a queue of integers, we need to reverse the order of the first k 
elements of the queue, leaving the other elements in the same relative order.

Only following standard operations are allowed on queue.

enqueue(x) : Add an item x to rear of queue
dequeue() : Remove an item from front of queue
size() : Returns number of elements in queue.
front() : Finds front item.
Examples:

Input : Q = [10, 20, 30, 40, 50, 60, 
            70, 80, 90, 100]
        k = 5

Output : Q = [50, 40, 30, 20, 10, 60, 
             70, 80, 90, 100]




Input : Q = [10, 20, 30, 40, 50, 60, 
            70, 80, 90, 100]
        k = 4
Output : Q = [40, 30, 20, 10, 50, 60, 
             70, 80, 90, 100]

The idea is to use an auxiliary stack.
1. Create an empty stack.
2. One by one dequeue items from given queue and push the dequeued items to stack.
3. Enqueue the contents of stack at the back of the queue
4. Dequeue (size-k) elements from the front and enque them one by one to the same queue.

             */