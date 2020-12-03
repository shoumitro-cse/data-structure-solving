// Java Program for a Queue based approach to find first non-repeating character 

//javac -d classes FindFirstNonRepeatingCharacter.java  && cd classes && java FindFirstNonRepeatingCharacter && cd ..

import java.util.LinkedList; 
import java.util.Queue; 

public class FindFirstNonRepeatingCharacter { 

	final static int MAX_CHAR = 26; 

	// function to find first non repeating character of stream 
	static void firstNonRepeating(String str) { 
		// count array of size 26(assuming only lower case characters are present) 
		int[] charCount = new int[MAX_CHAR]; 
		// Queue to store Characters 
		Queue<Character> q = new LinkedList<Character>(); 
		// traverse whole stream 
		for (int i = 0; i < str.length(); i++) { 
			char ch = str.charAt(i); 
			// push each character in queue 
			q.add(ch); 
			// increment the frequency count 
			charCount[ch-'a']++; 
			
			// check for the non repeating character 
			while (!q.isEmpty()) { 
				if (charCount[q.peek()-'a'] > 1) { //charCount[4, 1, 1]
					// System.out.println("\nentry");
					q.remove(); 
				} else { 
					System.out.print(q.peek() + " "); 
					break; 
				} 
			} 

			if (q.isEmpty()) {
				System.out.print(-1 + " "); 
			}
		} 
		System.out.println(); 
	} 


	public static void main(String[] args) { 
		// String str = "aabbcdfg"; 
		String str = "aaaabc"; 
		firstNonRepeating(str); 
	} 
} 

/*

Queue based approach for first non-repeating character in a stream

Given a stream of characters and we have to find first non repeating character each 
time a character is inserted to the stream.

Examples:

Input  : a a b c
Output : a -1 b b

Input  : a a c
Output : a -1 c



Algorithm:

1. Create a count array of size 26(assuming only lower case characters are present) and 
   initialize it with zero.
2. Create a queue of char datatype.
3. Store each character in queue and increase its frequency in the hash array.
4. For every character of stream, we check front of the queue.
5. If the frequency of character at the front of queue is one, then that will be the 
   first non repeating character.
6. Else if frequency is more than 1, then we pop that element.
7. If queue became empty that means there are no non repeating character so we will print -1.



*/