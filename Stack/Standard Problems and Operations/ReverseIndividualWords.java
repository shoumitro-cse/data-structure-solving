// Reverse individual words

// javac -d classes ReverseIndividualWords.java  && cd classes && java ReverseIndividualWords && cd ..


import java.io.*; 
import java.util.*; 

class ReverseIndividualWords { 

	// reverses individual words of a string 
	static void reverseWords(String str) { 

		Stack<Character> st = new Stack<Character>(); 
		// Traverse given string and push all characters to stack until we see a space. 
		for (int i = 0; i < str.length(); ++i) { 

			if (str.charAt(i) != ' ') { 
				st.push(str.charAt(i));
			} else { 
			    // When we see a space, we print contents of stack. 
				while (st.empty() == false) { 
					System.out.print(st.pop()); 
				} 
				System.out.print(" "); 
			} 
		} 
		// Since there may not be space after last word. 
		while (st.empty() == false) { 
			System.out.print(st.pop()); 
			
		} 
		System.out.println(" "); 
	} 

	// Driver program to test above function 
	public static void main(String[] args) 
	{ 
	    String str = "Hello World"; 
		System.out.println(); 
		System.out.println(str); 
		reverseWords(str); 
	} 
} 


/*
Reverse individual words


Given a string str, we need to print reverse of individual words.

Examples:

Input : Hello World
Output : olleH dlroW
 
*/