// reverse the number using a stack 

//javac -d classes ReverseNumberUsingStack.java  && cd classes && java ReverseNumberUsingStack && cd ..


import java.util.Stack; 

public class ReverseNumberUsingStack {

	// Stack to maintain order of digits 
	static Stack<Integer> st= new Stack<>(); 

	// Function to push digits into stack 
	static void push_digits(int number) { 
		while(number != 0) { 
			st.push(number % 10); 
			number = number / 10; 
		} 
	} 

	// Function to reverse the number 
	static int reverse_number(int number) { 
		// Function call to push number's digits to stack 
		push_digits(number); 
		int reverse = 0; 
		int i = 1; 
		// Popping the digits and forming the reversed number 
		while (!st.isEmpty()) { 
			reverse = reverse + (st.peek() * i); 
			st.pop(); 
			i = i * 10; 
		} 
		// Return the reversed number formed 
		return reverse; 
	} 

	// Driver program to test above function 
	public static void main(String[] args) { 
		int number = 123; 
		System.out.println(number+" to: "+reverse_number(number)); 
	} 
} 


/*
Reverse a number using stack

Given a number , write a program to reverse this number using stack.

Examples:

Input : 365
Output : 563

Input : 6899
Output : 9986*/