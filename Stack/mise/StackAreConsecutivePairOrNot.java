// Java program to check if successive pair of numbers in the stack are consecutive or not 

//javac -d classes StackAreConsecutivePairOrNot.java  && cd classes && java StackAreConsecutivePairOrNot && cd ..

import java.util.*; 

class StackAreConsecutivePairOrNot { 

	/*Time complexity: O(n).
	Auxiliary Space: O(n).*/
	// Function to check if elements are 
	// pairwise consecutive in stack 
	static boolean pairWiseConsecutive(Stack<Integer> s) {

		// Transfer elements of s to aux. 
		Stack<Integer> aux = new Stack<Integer> (); 
	
		while (!s.isEmpty()) { 
			aux.push(s.peek()); 
			s.pop(); 
		}
		 
		boolean result = true; 

		while (aux.size() > 1) { 
			int x = aux.pop(); 
			int y = aux.pop(); 

			if (Math.abs(x - y) != 1) { 
			  result = false; 
			}
			// Push the elements to original stack. 
			s.push(x); 
			s.push(y); 
		} 

		if (aux.size() == 1) {
			s.push(aux.peek()); 
		}

		return result; 
	} 

	// Driver program 
	public static void main(String[] args) {

		Stack<Integer> s = new Stack<Integer> (); 
		s.push(4); 
		s.push(5); 
		s.push(-2); 
		s.push(-3); 
		s.push(11); 
		s.push(10); 
		s.push(5); 
		s.push(6); 
		s.push(20); 

		if (pairWiseConsecutive(s)) 
			System.out.println("Yes"); 
		else
			System.out.println("No"); 

		System.out.println("Stack content (from top) after function call");  
	    System.out.println(s); 

	} 
} 



/*Check if stack elements are pairwise consecutive

Given a stack of integers, write a function pairWiseConsecutive() that 
checks whether numbers in the stack are pairwise consecutive or not. 
The pairs can be increasing or decreasing, and if the stack has an odd number
 of elements, the element at the top is left out of a pair. The function should retain
  the original stack content.

Only following standard operations are allowed on stack.

push(X): Enter a element X on top of stack.
pop(): Removes top element of the stack.
empty(): To check if stack is empty.
Examples:

Input : stack = [4, 5, -2, -3, 11, 10, 5, 6, 20]
Output : Yes
Each of the pairs (4, 5), (-2, -3), (11, 10) and
(5, 6) consists of consecutive numbers.

Input : stack = [4, 6, 6, 7, 4, 3]
Output : No
(4, 6) are not consecutive.*/