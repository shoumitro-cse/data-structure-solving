// Tracking current Maximum Element in a Stack

// javac -d classes TrackingCurrentMaxEleStack.java  && cd classes && java TrackingCurrentMaxEleStack && cd ..


import java.util.*; 

class TrackingCurrentMaxEleStack { 

	static class StackWithMax { 
		// main stack 
		static Stack<Integer> mainStack = new Stack<Integer> (); 

		// tack to keep track of max element 
		static Stack<Integer> trackStack = new Stack<Integer> (); 

	    static void push(int x) { 

			mainStack.push(x); 
			
			if (mainStack.size() == 1) { 
				trackStack.push(x); 
				return; 
			} 

			if (x > trackStack.peek()) 
				trackStack.push(x); 
			else
				trackStack.push(trackStack.peek()); 
		} 

		static int getMax() { 
			return trackStack.peek(); 
		} 

		static void pop() { 
			mainStack.pop(); 
			trackStack.pop(); 
		} 
	}; 

	// Driver program to test above functions 
	public static void main(String[] args) {

		StackWithMax s = new StackWithMax(); 

		s.push(20); 
		System.out.println(s.getMax()); 

		s.push(10); 
		System.out.println(s.getMax()); 

		s.push(50); 
		System.out.println(s.getMax()); 

		System.out.println("mainStack: "+s.mainStack);
		System.out.println("trackStack: "+s.trackStack);
	} 
} 


/*
Tracking current Maximum Element in a Stack

Time Complexity : O(1)
Auxiliary Complexity : O(n)

Given a Stack, keep track of the maximum value in it. The maximum value may be the top 
element of the stack, but once a new element is pushed or an element is popped from the stack, 
the maximum element will be now from the rest of the elements.

Examples:

Input : 4 19 7 14 20
Output : Max Values in stack are 
         4 19 19 19 20

Input : 40 19 7 14 20 5
Output :  Max Values in stack are 
         40 40 40 40 40 40*/