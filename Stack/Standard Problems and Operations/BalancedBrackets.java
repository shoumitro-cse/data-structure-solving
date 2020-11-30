// Check for Balanced Brackets in an expression (well-formedness) using Stack

//javac -d classes BalancedBrackets.java  && cd classes && java BalancedBrackets && cd ..

import java.util.*; 

public class BalancedBrackets { 

	// function to check if brackets are balanced 
	static boolean areBracketsBalanced(String expr) {

		// Using ArrayDeque is faster than using Stack class 
		// Deque<Character> stack = new ArrayDeque<Character>(); 
		Stack<Character> stack = new Stack<Character>();

		// Traversing the Expression 
		for (int i = 0; i < expr.length(); i++) {

			char x = expr.charAt(i); 

			if (x == '(' || x == '[' || x == '{') { 
				// Push the element in the stack 
				stack.push(x); 
				continue; 
			} 

			// IF current current character is not opening 
			// bracket, then it must be closing. So stack 
			// cannot be empty at this point. 
			if (stack.isEmpty()) 
				return false; 
			
			char check; 
			
			switch (x) { 

				case ')': 
					check = stack.pop(); 
					if (check == '{' || check == '[') 
						return false; 
					break; 

				case '}': 
					check = stack.pop(); 
					if (check == '(' || check == '[') 
						return false; 
					break; 

				case ']': 
					check = stack.pop(); 
					if (check == '(' || check == '{') 
						return false; 
					break; 
			} 
		} 

		while(!stack.isEmpty()) {
		   char	check = stack.pop();
		   if (check == '(' || check == '[' || check == '{' || check== ')'
		   	    || check== '}' || check == ']') {
		   	 return false;
		   }
		}
		// Check Empty Stack 
		return (stack.isEmpty()); 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		// String expr = "([{}])"; 
		String expr = "([{(g+h)+(k+h)}]+[d{(a+b)+(b+c)}])"; 

		// Function call 
		if (areBracketsBalanced(expr)) 
			System.out.println("\nBalanced "); 
		else
			System.out.println("\nNot Balanced "); 
	} 
} 



/*Check for Balanced Brackets in an expression (well-formedness) using Stack

 
Given an expression string exp, write a program to examine whether the pairs and
 the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in exp.

Example: 

Input: exp = “[()]{}{[()()]()}” 
Output: Balanced

Input: exp = “[(])” 
Output: Not Balanced */