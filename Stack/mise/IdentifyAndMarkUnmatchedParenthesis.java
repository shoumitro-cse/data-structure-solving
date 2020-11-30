// Identify and mark unmatched parenthesis in an expression

//javac -d classes IdentifyAndMarkUnmatchedParenthesis.java  && cd classes && java IdentifyAndMarkUnmatchedParenthesis && cd ..

import java.util.*;

class IdentifyAndMarkUnmatchedParenthesis {

	static void identifyParenthesis(StringBuffer a) {

/*		public StringBuilder replace(int start, int end, String str)
			Parameters
			start − This is the beginning index, inclusive.
			end − This is the ending index, exclusive.
			str − This is the String that will replace previous contents.*/

		Stack<Integer> st = new Stack<Integer>(); 
		// run the loop upto end of the string 
		for (int i = 0; i < a.length(); i++) { 
			// if a[i] is opening bracket then push into stack 
			if (a.charAt(i) == '(') {
				st.push(i); 
			} else if (a.charAt(i) == ')') { 
			// if a[i] is closing bracket ')'. If this closing bracket is unmatched 
				if (st.empty()) {
					a.replace(i, i+1, "-1"); 
				} else { 
					// replace all opening brackets with 0 and closing brackets with 1 
					a.replace(i, i+1, "1"); 
					a.replace(st.peek(), st.peek()+1, "0"); 
					st.pop(); 
				} 
			} 
		} 

		// if stack is not empty then pop out all 
		// elements from it and replace -1 at that 
		// index of the string 
		while (!st.empty()) { 
			a.replace(st.peek(), st.peek()+1, "-1"); 
			st.pop(); 
		} 

		// print final string 
		System.out.println(a);
	} 

	// Driver code 
	public static void main(String[] args) {
		// StringBuffer str = new StringBuffer("(((((a))"); 
		StringBuffer str = new StringBuffer("(a))"); 
		identifyParenthesis(str); 
	}
}



/*
Identify and mark unmatched parenthesis in an expression


Given an expression, find and mark matched and unmatched parenthesis in it. 
We need to replace all balanced opening parenthesis with 0, balanced closing parenthesis 
with 1, and all unbalanced with -1.
Examples:  

Input : ((a) 
Output : -10a1

Input : (a))
Output : 0a1-1

Input  : (((abc))((d)))))
Output : 000abc1100d111-1-1
*/

/*
StringBuilder Examples:

package com.tutorialspoint;

import java.lang.*;

public class StringBuilderDemo {

   public static void main(String[] args) {
  
      StringBuilder str = new StringBuilder("Java Util Package");
      System.out.println("string = " + str);
    
      // replace substring from index 5 to index 9
      str.replace(5, 9, "Lang");
   
      // prints the StringBuilder after replacing
      System.out.println("After replacing: " + str);
   }
}

Output:
string = Java Util Package
After replacing: Java Lang Package*/