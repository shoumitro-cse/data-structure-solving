// Prefix to Infix Conversion

//javac -d classes PrefixToInfix.java  && cd classes && java PrefixToInfix && cd ..

import java.util.Stack;

class PrefixToInfix  {

	// Function to check if character
	// is operator or not	 
	static boolean isOperator(char x) 
	{
		switch(x)
		{
			case '+':
			case '-':
			case '*':
			case '/':
				return true;
		}
		return false;
	}

	// Convert prefix to Infix expression 
	public static String convert(String str)
	{
		Stack<String> stack = new Stack<>();
		
		// Length of expression 
		int len = str.length();
		
		// Reading from right to left 
		for(int i = len - 1; i >= 0; i--)
		{
			char c = str.charAt(i);
			if (isOperator(c))
			{
				String op1 = stack.pop();
				String op2 = stack.pop();
				
				// Concat the operands and operator 
				String temp = "(" + op1 + c + op2 + ")";
				stack.push(temp);
			} else {
				// To make character to string
				stack.push(c + ""); 
			}
		}
		String result = stack.pop();
		return result;
	}

	// Driver code
	public static void main(String[] args)
	{
		String exp = "*-A/BC-/AKL";
		System.out.println("\noriginal prefix : " + exp);
		System.out.println("convert Infix text : " + convert(exp));
	}
}



/*Algorithm for Prefix to Infix: 

Read the Prefix expression in reverse order (from right to left)
If the symbol is an operand, then push it onto the Stack
If the symbol is an operator, then pop two operands from the Stack 
Create a string by concatenating the two operands and the operator between them. 
string = (operand1 + operator + operand2) 
And push the resultant string back to Stack
Repeat the above steps until end of Prefix expression.


Input :  Prefix :  *+AB-CD
Output : Infix : ((A+B)*(C-D))

Input :  Prefix :  *-A/BC-/AKL
Output : Infix : ((A-(B/C))*((A/K)-L)) 



Prefix to Infix Conversion

Infix : An expression is called the Infix expression if the operator appears in between 
the operands in the expression. Simply of the form (operand1 operator operand2). 
Example : (A+B) * (C-D)

Prefix : An expression is called the prefix expression if the operator appears in the 
expression before the operands. Simply of the form (operator operand1 operand2). 
Example : *+AB-CD (Infix : (A+B) * (C-D) )

Given a Prefix expression, convert it into a Infix expression. 
Computers usually does the computation in either prefix or postfix (usually postfix). 
But for humans, its easier to understand an Infix expression rather than a prefix. 
Hence conversion is need for human understanding.
*/
