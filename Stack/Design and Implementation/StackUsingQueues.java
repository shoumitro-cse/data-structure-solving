//Implement MyMyStack using Queues
 // Java Program to implement a MyMyStack using two queue 

// javac -d classes MyStackUsingQueues.java  && cd classes && java MyStackUsingQueues && cd ..

import java.util.*; 

class MyStackUsingQueues { 

	static class MyMyStack { 
		// Two inbuilt queues 
		static Queue<Integer> q1 = new LinkedList<Integer>(); 
		static Queue<Integer> q2 = new LinkedList<Integer>(); 
		// To maintain current number of elements 
		static int curr_size; 

		MyMyStack() { 
			curr_size = 0; 
		} 
		static void push(int x) { 
			curr_size++; 
			// Push x first in empty q2 
			q2.add(x); 
			// Push all the remaining elements in q1 to q2. 
			while (!q1.isEmpty()) { 
				q2.add(q1.peek()); 
				q1.remove(); 
			} 
			// swap the names of two queues 
			Queue<Integer> q = q1; 
			q1 = q2; 
			q2 = q; 
		} 

		static void pop() { 
			// if no elements are there in q1 
			if (q1.isEmpty()) 
				return; 
			q1.remove(); 
			curr_size--; 
		} 

		static int top() { 
			if (q1.isEmpty()) 
				return -1; 
			return q1.peek(); 
		} 

		static int size() { 
			return curr_size; 
		} 
	} 

	// driver code 
	public static void main(String[] args) 
	{ 
		MyMyStack s = new MyMyStack(); 
		s.push(1); 
		s.push(2); 
		s.push(3); 

		System.out.println("current size: " + s.size()); 

		System.out.println(s.top()); 
		s.pop(); 

		System.out.println(s.top()); 
		s.pop(); 

		System.out.println(s.top()); 

		System.out.println("current size: " + s.size()); 
	} 
} 



/* // Java Program to implement a MyStack using two queue 
import java.util.*; 

class MyStack { 

	Queue<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>(); 
	
	int curr_size; 

	public MyStack() { 
		curr_size = 0; 
	} 

	void removeElement() { 
		if (q1.isEmpty()) {
			return; 
		}
		// Leave one element in q1 and push others in q2. 
		while (q1.size() != 1) { 
			q2.add(q1.peek()); 
			q1.remove(); 
		} 
		// Pop the only left element from q1 
		q1.remove(); 
		curr_size--; 

		// swap the names of two queues 
		Queue<Integer> q = q1; 
		q1 = q2; 
		q2 = q; 
	} 

	void add(int x) { 
		q1.add(x); 
		curr_size++; 
	} 

	int top() {
		if (q1.isEmpty()) { 
			return -1; 
		}	
		while (q1.size() != 1) { 
			q2.add(q1.peek()); 
			q1.remove(); 
		} 
		// last pushed element 
		int temp = q1.peek(); 
		// to empty the auxiliary queue after last operation 
		q1.remove(); 
		// push last element to q2 
		q2.add(temp); 
		// swap the two queues names 
		Queue<Integer> q = q1; 
		q1 = q2; 
		q2 = q; 
		return temp; 
	} 

	int size() { 
		return curr_size; 
	} 
} 

class MyStackUsingQueues {
	// Driver code 
	public static void main(String[] args) 
	{ 
		MyStack s = new MyStack(); 
		s.add(1); 
		s.add(2); 
		s.add(3); 
		s.add(4); 

		System.out.println("current size: " + s.size()); 

		System.out.println(s.top()); 
		s.removeElement(); 
		
		System.out.println(s.top()); 
		s.removeElement(); 
		
		System.out.println(s.top()); 
		
		System.out.println("current size: " + s.size()); 
	} 

}
*/
