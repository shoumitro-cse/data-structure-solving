// Priority Queue using doubly linked list

//javac -d classes PriorityQueueDoublyList.java  && cd classes && java PriorityQueueDoublyList && cd ..


import java.util.* ; 

class PriorityQueueDoublyList { 
	
	static Node front , rear; 
		
	// Linked List Node 
	static class Node { 
		int data; 
		int priority; 
		Node prev, next; 
	} 
		
	// Function to insert a new Node 
	static void push(Node front_node, Node rear_node, int data, int p) {

		Node news = new Node(); 
		news.data = data; 
		news.priority = p; 
		
		// If linked list is empty 
		if (front_node == null) { 
			front_node = news; 
			rear_node = news; 
			news.next = null; 
		
		} else { // If p is less than or equal front node's priority, then insert at the front. 

			if (p <= front_node.priority) { //insert into first 
				news.next = front_node; 
				front_node.prev = news; //create own circle
				front_node = news; 
			
			} else if (p > rear_node.priority) { //insert into last
				news.next = null; 
				rear_node.next = news; 
				news.prev = rear_node; //create own circle
				rear_node = news; 
			
			} else { //insert into middle 

				Node start = front_node.next; 
				while (start.priority > p) {
					start = start.next;			 
				}
				news.next = start.next; 
				start.next.prev=news;

				start.next = news; 
				news.prev = start; 
		        // System.out.println("middle node insert"); 

			} 
		} 
		front =front_node; 
		rear=rear_node; 
	} 
		
	// Return the value at rear 
	static int peek(Node front_node) { 
		if(isEmpty(front_node)) return -1;
		return front_node.data; 
	} 
		
	static boolean isEmpty(Node front_node) { 
		return (front_node == null); 
	} 
		
	// Removes the element with the 
	// least priority value form the list 
	static int pop(Node front_node, Node rear_node) { 
        
        if(isEmpty(front_node)) return -1;

		Node temp = front_node; 
		int res = temp.data; 

		front_node = front_node.next; 

		if (front_node == null) {
		   rear_node = null; 
		}
		
		front =front_node; 
		rear=rear_node; 
		return res; 
		
	} 

	public static void display() {
		Node temp = front, p=new Node();
         
        System.out.print("\nForword: ");		
		while(temp != null) {
          System.out.print(temp.data+" ");
          p = temp;
          temp = temp.next;
		}
         System.out.print("\nReverse: ");		

        while(p != null) {
          System.out.print(p.data+" ");
          p = p.prev;
		}
         System.out.print("\n");
	}
		

	public static void main(String args[]) { 

		// front => 1->2->34->3->4->5->6 <= rear

		push(front, rear, 2, 3); //priority=3

		push(front, rear, 3, 4); //priority=4
		push(front, rear, 4, 5); //priority=5
		push(front, rear, 5, 6); //priority=6
		push(front, rear, 6, 7); //priority=7
		push(front, rear, 1, 2); //priority=2
		
		// middle node insert
		push(front, rear, 34, 3); //priority=3

		System.out.println("pop(): "+pop(front, rear)); 
/*		System.out.println("pop(): "+pop(front, rear)); 
		System.out.println("pop(): "+pop(front, rear)); 
		System.out.println("pop(): "+pop(front, rear)); 
		System.out.println("pop(): "+pop(front, rear)); 
		System.out.println("pop(): "+pop(front, rear)); 
		System.out.println("pop(): "+pop(front, rear)); */
		System.out.println("front: "+peek(front)); 
		System.out.println("rear: "+peek(rear)); 

		display();
		
	} 
} 



/*Priority Queue using doubly linked list
Given Nodes with their priority, implement a priority queue using doubly linked list.

Prerequisite : Priority Queue

Operations on Priority Queue :
1. push(): This function is used to insert a new data into the queue.
2. pop(): This function removes the element with the lowest priority value form the queue.
3. peek() / top(): This function is used to get the lowest priority 
                   element in the queue without removing it from the queue.


Approach :
1. Create a doubly linked list having fields info(hold the information of the Node), priority(hold the priority of the Node), prev(point to previous Node), next(point to next Node).
2. Insert the element and priority in the Node.
3. Arrange the Nodes in the increasing order of the priority.

 */