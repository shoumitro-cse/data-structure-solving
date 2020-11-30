// Implement a stack using single queue

//javac -d classes StackUsingSingleQueue.java  && cd classes && java StackUsingSingleQueue && cd ..

import java.util.LinkedList; 
import java.util.Queue; 

public class StackUsingSingleQueue {

	Queue<Integer> q = new LinkedList<Integer>(); 
	
	// Push operation 
	void push(int val) 
	{ 
		// get previous size of queue 
		int size = q.size(); 
		
		// Add current element 
		q.add(val); 
		
		// Pop (or Dequeue) all previous 
		// elements and put them after current 
		// element 
		for (int i = 0; i < size; i++) 
		{ 
			// this will add front element into 
			// rear of queue 
			int x = q.remove(); 
			q.add(x); 
		} 
	} 
	
	// Removes the top element 
	int pop() 
	{ 
		if (q.isEmpty()) 
		{ 
			System.out.println("No elements"); 
			return -1; 
		} 
		int x = q.remove(); 
		return x; 
	} 
	
	// Returns top of StackUsingSingleQueue 
	int top() 
	{ 
		if (q.isEmpty()) 
			return -1; 
		return q.peek(); 
	} 
	
	// Returns true if StackUsingSingleQueue is empty else false 
	boolean isEmpty() 
	{ 
		return q.isEmpty(); 
	} 

	// Driver program to test above methods 
	public static void main(String[] args) 
	{ 
		StackUsingSingleQueue s = new StackUsingSingleQueue(); 
		s.push(10); 
		s.push(20); 

		System.out.println("Top element :" + s.top()); 
		s.pop(); 

		s.push(30); 

		s.pop(); 
		System.out.println("Top element :" + s.top()); 
	} 
} 

