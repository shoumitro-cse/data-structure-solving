//find duplicate parenthesis in a balanced expression 

//javac -d classes DuplicateParenthesis.java  && cd classes && java DuplicateParenthesis && cd ..

import java.util.Stack; 

public class DuplicateParenthesis { 

	/*Time complexity of above solution is O(n).
	  Auxiliary space used by the program is O(n).*/
   
   // Function to find duplicate parenthesis in a balanced expression 
	static boolean findDuplicateparenthesis(String s) { 
		// create a stack of characters 
		Stack<Character> stack = new Stack<>(); 
		// Iterate through the given expression 
		char[] str = s.toCharArray(); 
		for (char ch : str) { 
			// if current character is close parenthesis ')' 
			if (ch == ')') { 
				// pop character from the stack 
				char top = stack.pop(); 
				int elementsInside = 0; 

				while (top != '(') { 
					elementsInside++; 
					top = stack.pop(); 
				} 
				
				if (elementsInside < 1) { 
					return true; 
				}

			} else { 
			 // push open parenthesis '(', operators and operands to stack 
				stack.push(ch); 
			} 
		} 

		// No duplicates found 
		return false; 
	} 

// Driver code 
public static void main(String[] args) { 

		// input balanced expression 
		String str = "(((a+(b))+(c+d)))"; 

		if (findDuplicateparenthesis(str)) { 
			System.out.println("Duplicate Found "); 
		} else { 
			System.out.println("No Duplicates Found "); 
		} 

	} 
} 


/*Find if an expression has duplicate parenthesis or not

Given a balanced expression, find if it contains duplicate parenthesis or not. 
A set of parenthesis are duplicate if the same subexpression is 
surrounded by multiple parenthesis.

Examples:

Below expressions have duplicate parenthesis - 
((a+b)+((c+d)))
The subexpression "c+d" is surrounded by two
pairs of brackets.

(((a+(b)))+(c+d))
The subexpression "a+(b)" is surrounded by two 
pairs of brackets.

(((a+(b))+c+d))
The whole expression is surrounded by two 
pairs of brackets.

Below expressions don't have any duplicate parenthesis -
((a+b)+(c+d)) 
No subsexpression is surrounded by duplicate
brackets.

((a+(b))+(c+d))
No subsexpression is surrounded by duplicate
brackets.*/