// find index of closing bracket for given opening bracket. 

//javac -d classes FindIndexOfClosingBracket.java  && cd classes && java FindIndexOfClosingBracket && cd ..

import java.util.Stack; 

class FindIndexOfClosingBracket { 

// Function to find index of closing 
// bracket for given opening bracket. 
	static void test(String expr, int index) {
	// [ABC[23]][89] here index=0 
		int i; 
		// If index given is invalid and is not an opening bracket. 
		if (expr.charAt(index) != '[') { 
			System.out.print(expr + ", "+ index + ": -1\n"); 
			return; 
		} 
		// Stack to store opening brackets. 
		Stack<Integer> st = new Stack<>(); 
		// Traverse through string starting from given index. 
		for (i = index; i < expr.length(); i++) { 
			// If current character is an opening bracket push it in stack. 
			if (expr.charAt(i) == '[') { 
				st.push((int) expr.charAt(i)); 
		       // System.out.println(st); 
			} else if (expr.charAt(i) == ']') { 
				st.pop(); 
				if (st.empty()) { 
					System.out.print(expr + ", "+ index + ": " + i + "\n"); 
					return; 
				} 
			} 
		} 
		// If no matching closing bracket is found. 
		System.out.print(expr + ", "+ index + ": -1\n"); 
	} 

	public static void main(String[] args) { 
		test("[ABC[23]][89]", 0); // should be 8 
		// test("[ABC[23]][89]", 4); // should be 7 
		// test("[ABC[23]][89]", 9); // should be 12 
		// test("[ABC[23]][89]", 1); // No matching bracket 
	} 
} 

/*
Find index of closing bracket for a given opening bracket in an expression

Given a string with brackets. If the start index of the open bracket is given, 
find the index of the closing bracket.

Examples:

Input : string = [ABC[23]][89]
        index = 0
Output : 8
The opening bracket at index 0 corresponds
to closing bracket at index 8.*/