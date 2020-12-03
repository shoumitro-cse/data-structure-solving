//An Interesting Method to Generate Binary Numbers from 1 to n

//Java program to generate binary numbers from 1 to n 

//javac -d classes GenerateBinaryNumbers.java  && cd classes && java GenerateBinaryNumbers && cd ..

import java.util.LinkedList; 
import java.util.Queue; 

public class GenerateBinaryNumbers { 

	// This function uses queue data structure to print binary numbers 
	//Time Complexity: O(n * logn)
	static void generatePrintBinary(int n) { 
		// Create an empty queue of strings 
		Queue<String> q = new LinkedList<String>(); 	
		// Enqueue the first binary number 
		q.add("1"); 
		// This loops is like BFS of a tree with 1 as root 
		// 0 as left child and 1 as right child and so on 
		while(n--> 0) { 
			// print the front of queue 
			String s1 = q.remove(); 
			System.out.println(s1); 
			// Store s1 before changing it 
			String s2 = s1; 
			// Append "0" to s1 and enqueue it 
			q.add(s1 + "0"); 
			// Append "1" to s2 and enqueue it. Note that s2 contains the previous front 
			q.add(s2 + "1"); 
		} 
	} 
	
	// Driver program to test above function 
	public static void main(String[] args) { 
		int n=10; 
		generatePrintBinary(n); 
	} 
} 


/*
An Interesting Method to Generate Binary Numbers from 1 to n

Given a number n, write a function that generates and prints all binary numbers with decimal values from 1 to n.
Examples:

Input: n = 2
Output: 1, 10

Input: n = 5
Output: 1, 10, 11, 100, 101


A simple method is to run a loop from 1 to n, call decimal to binary inside the loop.

Algorithm:
1) Create an empty queue of strings
2) Enqueue the first binary number “1” to queue.
3) Now run a loop for generating and printing n binary numbers.
……a) Dequeue and Print the front of queue.
……b) Append “0” at the end of front item and enqueue it.
……c) Append “1” at the end of front item and enqueue it.*/