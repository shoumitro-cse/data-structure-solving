// Java code to delete middle of a stack without using additional data structure. 

//javac -d classes DeleteMiddleElementFromStack.java  && cd classes && java DeleteMiddleElementFromStack && cd ..


import java.io.*; 
import java.util.*; 

public class DeleteMiddleElementFromStack { 

	// Deletes middle of stack of size 
	// n. Curr is current item number 
	static void deleteMid(Stack<Character> st, int n, int curr) 
	{ 
		
		// If stack is empty or all items 
		// are traversed 
		if (st.empty() || curr == n) 
			return; 
		
		// Remove current item 
		char x = st.pop(); 
		
		// Remove other items 
		deleteMid(st, n, curr+1); 
		
		// Put all items back except middle 
		if (curr != n/2) 
			st.push(x); 
	} 
	
	// Driver function to test above functions 
	public static void main(String args[]) 
	{ 
		Stack<Character> st = new Stack<Character>(); 
	
		// push elements into the stack 
		st.push('1'); 
		st.push('2'); 
		st.push('3'); 
		st.push('4'); 
		st.push('5'); 
		st.push('6'); 
		// st.push('7'); 
	
		System.out.println("st.size(): "+st.size()); 
		System.out.println(st); 

		deleteMid(st, st.size(), 0); 

		System.out.println(); 
		System.out.println(st); 
		System.out.println(); 
	} 
} 

/*
Delete middle element of a stack


Given a stack with push(), pop(), empty() operations, delete middle of it without 
using any additional data structure.

Input  : Stack[] = [1, 2, 3, 4, 5]
Output : Stack[] = [1, 2, 4, 5]

Input  : Stack[] = [1, 2, 3, 4, 5, 6]
Output : Stack[] = [1, 2, 4, 5, 6]*/