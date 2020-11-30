//Postfix to Prefix Conversion

// Java Program to convert postfix to prefix

//javac -d classes PostfixToPrefix.java  && cd classes && java PostfixToPrefix && cd ..

import java.util.*;

class PostfixToPrefix {

	// function to check if character
	// is operator or not
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
	static String postToPre(String str)
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
				String temp = ch + op2 + op1 ;
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
		// Function call
		System.out.println("Original : " + post_exp);
		System.out.println("Prefix : " + postToPre(post_exp));
	}
}



/*Algorithm for Postfix to Prefix: 
 

1. Read the Postfix expression from left to right
2. If the symbol is an operand, then push it onto the Stack
3. If the symbol is an operator, then pop two operands from the Stack 
     Create a string by concatenating the two operands and the operator before them. 
     string = operator + operand2 + operand1 
4. And push the resultant string back to Stack
5. Repeat the above steps until end of Prefix expression.


Examples: 

Input :  Postfix : AB+CD-*
Output : Prefix :  *+AB-CD
Explanation : Postfix to Infix : (A+B) * (C-D)
              Infix to Prefix :  *+AB-CD

Input :  Postfix : ABC/-AK/L-*
Output : Prefix :  *-A/BC-/AKL
Explanation : Postfix to Infix : ((A-(B/C))*((A/K)-L))
              Infix to Prefix :  *-A/BC-/AKL 



 Postfix to Prefix Conversion

Postfix: An expression is called the postfix expression if the operator appears in the expression 
after the operands. Simply of the form (operand1 operand2 operator). 
Example : AB+CD-* (Infix : (A+B) * (C-D) )

Prefix : An expression is called the prefix expression if the operator appears in the expression 
before the operands. Simply of the form (operator operand1 operand2). 
Example : *+AB-CD (Infix : (A+B) * (C-D) )

Given a Postfix expression, convert it into a Prefix expression. 
Conversion of Postfix expression directly to Prefix without going through the process of 
converting them first to Infix and then to Prefix is much better in terms of computation 
and better understanding the expression (Computers evaluate using Postfix expression). 

*/