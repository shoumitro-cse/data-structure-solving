// JavaProgram to convert prefix to postfix

//javac -d classes PrefixToPostfix.java  && cd classes && java PrefixToPostfix && cd ..

import java.util.*;

class PrefixToPostfix {

	// funtion to check if character
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

	// Convert prefix to Postfix expression
	static String preToPost(String str)
	{
		Stack<String> stack = new Stack<String>();
		// length of expression
		int length = str.length();
		// reading from right to left
		for (int i = length - 1; i >= 0; i--) 
		{
			char ch = str.charAt(i);
			// check if symbol is operator
			if (isOperator(ch)) 
			{
				// pop two operands from stack
				String op1 = stack.pop();
				String op2 = stack.pop();
				// concat the operands and operator
				String temp = op1 + op2 + ch;
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
		String str = "*-A/BC-/AKL";
		System.out.println("original : "+ str);
		System.out.println("Postfix : "+ preToPost(str));
	}
}


/*Algorithm for Prefix to Postfix: 

Algorithm:
1. Read the Prefix expression in reverse order (from right to left)
2. If the symbol is an operand, then push it onto the Stack
3. If the symbol is an operator, then pop two operands from the Stack 
4. Create a string by concatenating the two operands and the operator after them. 
5. string = operand1 + operand2 + operator 
6. And push the resultant string back to Stack
7. Repeat the above steps until end of Prefix expression.


Examples: 

Input :  Prefix :  *+AB-CD
Output : Postfix : AB+CD-*
Explanation : Prefix to Infix :  (A+B) * (C-D)
              Infix to Postfix :  AB+CD-*

Input :  Prefix :  *-A/BC-/AKL
Output : Postfix : ABC/-AK/L-*
Explanation : Prefix to Infix :  (A-(B/C))*((A/K)-L)
              Infix to Postfix : ABC/-AK/L-* 


Prefix to Postfix Conversion
Last Updated: 30-10-2020
Prefix: An expression is called the prefix expression if the operator appears in the expression 
before the operands. Simply of the form (operator operand1 operand2). 
Example : *+AB-CD (Infix : (A+B) * (C-D) )

Postfix: An expression is called the postfix expression if the operator appears in the expression 
after the operands. Simply of the form (operand1 operand2 operator). 
Example : AB+CD-* (Infix : (A+B * (C-D) )
Given a Prefix expression, convert it into a Postfix expression. 
Conversion of Prefix expression directly to Postfix without going through the process of 
converting them first to Infix and then to Postfix is much better in terms of computation 
and better understanding the expression (Computers evaluate using Postfix expression). 


    */