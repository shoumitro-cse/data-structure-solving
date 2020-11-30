// Check if a queue can be sorted into another queue using a stack

//javac -d classes CheckQueueSortUsingstack.java  && cd classes && java CheckQueueSortUsingstack && cd ..

import java.io.*; 
import java.util.*; 

class CheckQueueSortUsingstack 
{ 
	static Queue<Integer> q = new LinkedList<Integer>(); 
	
	// Function to check if given 
	// queue element can be sorted 
	// into another queue using a stack. 
	static boolean checkSorted(int n) 
	{ 
		Stack<Integer> stack = new Stack<Integer>(); 
		int expected_value = 1; 
		int front; 
	
		// while given Queue is not empty. 
		while (q.size() != 0) 
		{ 
			front = q.poll(); // delete front from queue
	
			// if front element is the expected_value element 
			if (front == expected_value) {
				expected_value++; 
			} else { 
				// if stack is empty, push the element 
				if (stack.size() == 0) { 
					stack.push(front); 
				} else if (stack.size() != 0 && stack.peek() < front) { 
				    // if top element is less than  element which need to be pushed, 
					//then return fasle. 
					return false; 
				} else {
				   // else push into the stack. 
				   stack.push(front);
				} 
			} 
	
			// while expected_value element are coming from stack, pop them out. 
			while (stack.size() != 0 && stack.peek() == expected_value) { 
				stack.pop(); 
				expected_value++; 
			} 
		} 
		
		// if the final expected_value element 
		// value is equal to initial Queue 
		// size and the stack is empty. 
		if (expected_value - 1 == n && stack.size() == 0) 
			return true; 
	
		return false; 
	} 
	
	// Driver Code 
	public static void main(String args[]) 
	{ 
		q.add(7); 
		q.add(1); 
		q.add(2); 
		q.add(3); 
		q.add(4); 
		q.add(5); 
		q.add(6); 
	
		int n = q.size(); 

		if (checkSorted(n)) 
			System.out.println("Yes"); 
		else
			System.out.println("No"); 
	} 
} 


/*Check if a queue can be sorted into another queue using a stack


Given a Queue consisting of first n natural numbers (in random order). 
The task is to check whether the given Queue elements can be arranged in increasing order 
in another Queue using a stack. The operation allowed are:

1. Push and pop elements from the stack
2. Pop (Or enqueue) from the given Queue.
3. Push (Or Dequeue) in the another Queue.

Examples :

Input : Queue[] = { 5, 1, 2, 3, 4 }
Output : Yes
Pop the first element of the given Queue i.e 5.
Push 5 into the stack.
Now, pop all the elements of the given Queue and push them to
second Queue.
Now, pop element 5 in the stack and push it to the second Queue.
 
Input : Queue[] = { 5, 1, 2, 6, 3, 4 }
Output : No
Push 5 to stack.
Pop 1, 2 from given Queue and push it to another Queue.
Pop 6 from given Queue and push to stack.
Pop 3, 4 from given Queue and push to second Queue.
Now, from using any of above operation, we cannot push 5
into the second Queue because it is below the 6 in the stack.
*/
