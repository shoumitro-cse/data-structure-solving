// Java program to interleave the first half of the queue with the second half 

//javac -d classes InterleaveFirstHalfQueue.java  && cd classes && java InterleaveFirstHalfQueue && cd ..

import java.util.*; 

class InterleaveFirstHalfQueue { 

	// Function to interleave the queue 
	static void interLeaveQueue(Queue<Integer>q) {

		// System.out.println(q.size()); 
		// To check the odd number of elements 
		if (q.size() % 2 != 0) {
			System.out.println("Input odd number of integers." ); 
		}

		// Initialize an empty stack of int type 
		Stack<Integer> s = new Stack<>(); 
		int halfSize = q.size() / 2; 

		// Push first half elements into the stack 
		// queue:16 17 18 19 20, stack: 15(T) 14 13 12 11 
		for (int i = 0; i < halfSize; i++) { 
			s.push(q.poll()); 
		} 

		// enqueue back the stack elements 
		// queue: 16 17 18 19 20 15 14 13 12 11 
		while (!s.empty()) { 
			q.add(s.pop()); 
		} 

		// dequeue the first half elements of queue 
		// and enqueue them back 
		// queue: 15 14 13 12 11 16 17 18 19 20 
		for (int i = 0; i < halfSize; i++) { 
			q.add(q.poll()); 
		} 

		// Again push the first half elements into the stack 
		// queue: 16 17 18 19 20, 
		//stack: 11(T) 12 13 14 15 
		for (int i = 0; i < halfSize; i++) { 
			s.push(q.peek()); 
			q.poll(); 
		} 
		// interleave the elements of queue and stack 
		// queue: 11 16 12 17 13 18 14 19 15 20 
		while (!s.empty()) { 
			q.add(s.pop()); 
			q.add(q.poll()); 
		} 
	} 

	// Driver code 
	public static void main(String[] args) {

		Queue<Integer> q = new java.util.LinkedList<>(); 
		q.add(11); // front and delete
		q.add(12); 
		q.add(13); 
		q.add(14); 
		q.add(15); 
		
		q.add(16); 
		q.add(17); 
		q.add(18); 
		q.add(19); 
		q.add(20); //rear and insert

		// q.add(21); //rear and insert

		System.out.println("Before: "+q); 
		interLeaveQueue(q); 		
		System.out.println("After: "+q); 
	} 
} 

//Time complexity: O(n).
//Auxiliary Space: O(n).



/*
Interleave the first half of the queue with second half

Following are the steps to solve the problem:
1.Push the first half elements of queue to stack.
2.Enqueue back the stack elements.
3.Dequeue the first half elements of the queue and enqueue them back.
4.Again push the first half elements into the stack.
5.Interleave the elements of queue and stack.

Given a queue of integers of even length, rearrange the elements by interleaving 
the first half of the queue with the second half of the queue.

Only a stack can be used as an auxiliary space.

Examples:

Input :  1 2 3 4
Output : 1 3 2 4

Input : 11 12 13 14 15 16 17 18 19 20
Output : 11 16 12 17 13 18 14 19 15 20*/