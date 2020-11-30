
//Postfix to Infix

//javac -d classes PostfixToInfix.java  && cd classes && java PostfixToInfix && cd ..

import java.util.*;

class PostfixToInfix {

	// function to check if character is operator or not
	static boolean isOperator(char x)
	{

		switch (x) {
		case '+':
		case '-':
		case '/':
		case '*':
			return true;
		}
		return false;
	}

	// Convert postfix to Prefix expression
	static String postToInfix(String str)
	{
		Stack<String> stack = new Stack<String>();
		// length of expression
		int length = str.length();
		// reading from right to left
		for (int i = 0; i<length; i++) 
		{
			char ch = str.charAt(i);
			// check if symbol is operator
			if (isOperator(ch)) 
			{
				// pop two operands from stack
				String op1 = stack.pop();
				String op2 = stack.pop();
				// concat the operands and operator
				String temp = "("+op2+ ch + op1+")" ;
				// Push String temp back to stack
				stack.push(temp);
			}
			// if symbol is an operand
			else {
				// push the operand to the stack
				stack.push(ch + "");
			}
		}

		// stack contains only the Postfix expression
		String result = stack.pop();
		return result;
	}

	// Driver Code
	public static void main(String args[])
	{
		String post_exp = "ABC/-AK/L-*";
	    // post_exp = "ab*c+"; 
		// Function call
		System.out.println("Original : " + post_exp);
		System.out.println("Infix : " + postToInfix(post_exp));
	}
}


/*

Algorithm:
1. Read the Postfix expression from left to right
2. If the symbol is an operand, then push it onto the Stack
3. If the symbol is an operator, then pop two operands from the Stack 
     Create a string by concatenating the two operands and the operator before them. 
     string =  "("+ operand2 +operator+ operand1+")" 
4. And push the resultant string back to Stack
5. Repeat the above steps until end of Prefix expression.


Algorithm2:
1.While there are input symbol left
…1.1 Read the next symbol from the input.
2.If the symbol is an operand
…2.1 Push it onto the stack.
3.Otherwise,
…3.1 the symbol is an operator.
…3.2 Pop the top 2 values from the stack.
…3.3 Put the operator, with the values as arguments and form a string.
…3.4 Push the resulted string back to stack.
4.If there is only one value in the stack
…4.1 That value in the stack is the desired infix string.
Below is the implementation of above approach:

Examples:

Input : abc++
Output : (a + (b + c))

Input  : ab*c+
Output : ((a*b)+c)

Infix expression: The expression of the form a op b. When an operator is 
in-between every pair of operands.

Postfix expression: The expression of the form a b op. When an operator is 
followed for every pair of operands.
*/