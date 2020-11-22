// Circular Queue | Set 2 (Circular Linked List Implementation)

//javac -d classes CircularQueueList.java  && cd classes && java CircularQueueList && cd .. 

import java.util.*; 

class CircularQueueList { 

	// Structure of a Node 
	static class Node { 
		int data; 
		Node link; 
	} 

	static class Queue { 
		Node front, rear; 
		Queue() {
			front=rear=null;
		}
	} 

	// Function to create Circular queue 
	// Time complexity O(1)
	static void enQueue(Queue q, int value) { // enter

		Node temp = new Node(); 
		temp.data = value; 

		if (q.front == null) 
			q.front = temp; 
		else
			q.rear.link = temp; 

		q.rear = temp; 
		q.rear.link = q.front; 
	} 

	// Function to delete element from Circular Queue 
	// Time complexity O(1)
	static int deQueue(Queue q) { // delete

		if (q.front == null) { //for empty
			System.out.printf("Queue is empty"); 
			return Integer.MIN_VALUE; 
		} 

		// If this is the last node to be deleted 
		int value; // Value to be dequeued 
		if (q.front == q.rear) { //for only one node
			value = q.front.data; 
			q.front = null; 
			q.rear = null; 
		} else {// There are more than one nodes 
			Node temp = q.front; 
			value = temp.data; 
			q.front = q.front.link; 
			q.rear.link = q.front; 
		} 

		return value; 
	} 

	// Function displaying the elements of Circular Queue 
	static void displayQueue(Queue q) {
		Node temp = q.front; 
		System.out.printf("\nElements in Circular Queue are: "); 
		do {
			System.out.printf("%d ", temp.data); 
            temp = temp.link;
		} while(temp != q.front);
		System.out.printf("\n"); 
	} 

	/* Driver of the program */
	public static void main(String args[]) {
	 
		// Create a queue and initialize front and rear 
		Queue q = new Queue(); 

		// Inserting elements in Circular Queue 
		enQueue(q, 14); 
		enQueue(q, 22); 
		enQueue(q, 6); 

		// Display elements present in Circular Queue 
		displayQueue(q); 

		// Deleting elements from Circular Queue 
		System.out.printf("\nDeleted value = %d", deQueue(q)); 
		System.out.printf("\nDeleted value = %d", deQueue(q)); 

		// Remaining elements in Circular Queue 
		displayQueue(q); 

		enQueue(q, 9); 
		enQueue(q, 20); 
		displayQueue(q); 

		System.out.println();
	} 
} 


/*
Time Complexity: Time complexity of 
enQueue(), deQueue() operation is O(1) as 
there is no loop in any of the operation.

Operations on Circular Queue:

1. Front:Get the front item from queue.
2. Rear: Get the last item from queue.

3. enQueue(value) This function is used to insert an element into the circular queue. 
In a circular queue, the new element is always inserted at Rear position.
Steps:
	1. Create a new node dynamically and insert value into it.
	2. Check if front==NULL, if it is true then front = rear = (newly created node)
	3. If it is false then rear=(newly created node) and rear node always contains 
	  the address of the front node.

4. deQueue() This function is used to delete an element from the circular queue. In a queue, the element is always deleted from front position.
Steps:
	1. Check whether queue is empty or not means front == NULL.
	2. If it is empty then display Queue is empty. If queue is not empty then step 3
	3. Check if (front==rear) if it is true then set front = rear = NULL else move the 
	  front forward in queue, update address of front in rear node and return the element.*/