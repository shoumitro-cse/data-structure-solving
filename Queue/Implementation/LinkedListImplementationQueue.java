// Java program for linked-list implementation of queue 

// A linked list (LL) node to store a queue entry 
//javac -d classes LinkedListImplementationQueue.java  && cd classes && java LinkedListImplementationQueue && cd ..

class Node { 
	int key; 
	Node next; 

	// constructor to create a new linked list node 
	public Node(int key) 
	{ 
		this.key = key; 
		this.next = null; 
	} 
} 

// A class to represent a queue 
// The queue, front stores the front node of LL and rear stores the 
// last node of LL 
class Queue { 

	Node front, rear; 

	public Queue() { 
		this.front = this.rear = null; 
	} 

	// Method to add an key to the queue. 
	void enqueue(int key) { 
		// Create a new LL node 
		Node temp = new Node(key); 
		// If queue is empty, then new node is front and rear both 
		if (this.rear == null) { 
			this.front = this.rear = temp; 
			return; 
		} 
		// Add the new node at the end of queue and change rear 
		this.rear.next = temp; 
		this.rear = temp; 
	} 

	// Method to remove an key from queue. 
	void dequeue() {

		// If queue is empty, return NULL. 
		if (this.front == null) 
			return; 
		// Store previous front and move front one node ahead 
		Node temp = this.front; 
		this.front = this.front.next; 

		// If front becomes NULL, then change rear also as NULL 
		if (this.front == null) 
			this.rear = null; 
	} 
} 

// Driver class 
public class LinkedListImplementationQueue { 

	public static void main(String[] args) {

		Queue q = new Queue(); 
		q.enqueue(10); 
		q.enqueue(20); 

		q.dequeue(); 
		q.dequeue(); 

		q.enqueue(30); 
		q.enqueue(40); 
		q.enqueue(50); 

		q.dequeue(); 
		System.out.println("Queue Front : " + q.front.key); 
		System.out.println("Queue Rear : " + q.rear.key); 
	} 
} 


/*Time Complexity: Time complexity of both operations enqueue() and dequeue() is O(1) as 
we only change few pointers in both operations. There is no loop in any of the operations.



Queue – Linked List Implementation
Last Updated: 28-09-2020
In the previous post, we introduced Queue and discussed array implementation. In this post, linked list implementation is discussed. The following two main operations must be implemented efficiently.

In a Queue data structure, we maintain two pointers, front and rear. The front points the first item of queue and rear points to last item.

enQueue() This operation adds a new node after rear and moves rear to the next node.

deQueue() This operation removes the front node and moves front to the next node.

*/