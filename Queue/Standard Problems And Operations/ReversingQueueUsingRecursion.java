// Java program to reverse a Queue by recursion 

//javac -d classes ReversingQueueUsingRecursion.java  && cd classes && java ReversingQueueUsingRecursion && cd ..

import java.util.LinkedList; 
import java.util.Queue; 
import java.util.Stack; 

// Java program to reverse a queue recursively 
public class ReversingQueueUsingRecursion { 
	

	// Recurrsive function to reverse the queue 
	//Time Complexity : O(n).
	static Queue<Integer> reverseQueue(Queue<Integer> q) 
	{ 
		// Base case 
		if (q.isEmpty()) 
			return q; 
		// Dequeue current item (from front) 
		int data = q.remove(); 
		// Reverse remaining queue 
		q = reverseQueue(q); 
		// Enqueue current item (to rear) 
		q.add(data); 
		return q; 
	} 

	// Driver code 
	public static void main(String args[]) { 

	    Queue<Integer> queue = new LinkedList<Integer>(); 
		queue.add(56); // first
		queue.add(27); 
		queue.add(30); 
		queue.add(45); 
		queue.add(85); 
		queue.add(92); 
		queue.add(58); 
		queue.add(80); 
		queue.add(90); 
		queue.add(100); //last

        System.out.println("original: "+queue);
		queue = reverseQueue(queue); 
        System.out.println("reverse:  "+queue);
	} 
} 


/*

Reversing a queue using recursion

Given a queue, write a recursive function to reverse it.
Standard operations allowed :
enqueue(x) : Add an item x to rear of queue.
dequeue() : Remove an item from front of queue.
empty() : Checks if a queue is empty or not.

Examples :

Input : Q = [5, 24, 9, 6, 8, 4, 1, 8, 3, 6]
Output : Q = [6, 3, 8, 1, 4, 8, 6, 9, 24, 5]

Explanation : Output queue is the reverse of the input queue.

Input : Q = [8, 7, 2, 5, 1]
Output : Q = [1, 5, 2, 7, 8]




Recursive Algorithm :

1. The pop element from the queue if the queue has elements otherwise return empty queue.
2. Call reverseQueue function for the remaining queue.
3. Push the popped element in the resultant reversed queue.

Pseudo Code :

queue reverseFunction(queue)
{
    if (queue is empty)
       return queue;
    else {
       data = queue.front()
       queue.pop()
       queue = reverseFunction(queue);
       q.push(data);
       return queue;
    }
}*/