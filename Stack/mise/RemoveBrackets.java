// Remove brackets from an algebraic string containing + and – operators

//javac -d classes RemoveBrackets.java  && cd classes && java RemoveBrackets && cd ..

import java.util.*; 

class RemoveBrackets { 

	// Function to simplify the string 
	static String simplify(String str) {

		int len = str.length(); 
		// resultant string of max length equal to length of input string 
		char res[] = new char[len]; 
		int index = 0, i = 0; 

		// create empty stack 
		Stack<Integer> s = new Stack<Integer> (); 
		s.push(0); 

		while (i < len) { 
			
			if (str.charAt(i) == '+') { 
				// If top is 1, flip the operator 
				if (s.peek() == 1) 
					res[index++] = '-'; 
				// If top is 0, append the same operator 
				if (s.peek() == 0) 
					res[index++] = '+'; 
			} else if (str.charAt(i) == '-') { 
				if (s.peek() == 1) 
					res[index++] = '+'; 
				else if (s.peek() == 0) 
					res[index++] = '-'; 
			} else if (str.charAt(i) == '(' && i > 0) {

				if (str.charAt(i-1) == '-') { 
					// x is opposite to the top of stack 
					int x = (s.peek() == 1) ? 0 : 1; 
					s.push(x); 
				} else if (str.charAt(i-1) == '+') {
				   // push value equal to top of the stack 
					s.push(s.peek()); 
				}
			} else if (str.charAt(i) == ')') {
			// If closing parentheses pop the stack once 
				s.pop(); 
			} else {
			   // copy the character to the result 
				res[index++] = str.charAt(i); 
			}

			i++; 
		} 
		return new String(res); 
	} 

	// Driver program 
	public static void main(String[] args) 
	{ 
		String s1 = "a-(b+c)"; 
		String s2 = "a-(b-c-(d+e))-f"; 
		System.out.println(simplify(s1)); 
		System.out.println(simplify(s2)); 
	} 
} 


/*
Remove brackets from an algebraic string containing + and – operators

Simplify a given algebraic string of characters, ‘+’, ‘-‘ operators and parentheses. 
Output the simplified string without parentheses.

Examples:

Input : "a-(b+c)"
Output : "a-b-c"

Input : "a-(b-c-(d+e))-f"
Output : "a-b+c+d+e-f" 


The idea is to check operators just before starting of bracket, i.e., before character ‘(‘. 
If operator is -, we need to toggle all operators inside the bracket. A stack is used which 
stores only two integers 0 and 1 to indicate whether to toggle or not.
We iterate for every character of input string. Initially push 0 to stack. Whenever the character 
is an operator (‘+’ or ‘-‘), check top of stack. If top of stack is 0, append the same operator in
the resultant string. If top of stack is 1, append the other operator (if ‘+’ append ‘-‘) in the 
resultant string.
*/