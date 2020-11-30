// Expression Evaluation

//javac -d classes ExpressionEvaluation.java  && cd classes && java ExpressionEvaluation && cd ..

import java.util.Stack;

public class ExpressionEvaluation {


	// Time Complexity: O(n) 
	// Space Complexity: O(n)
	public static int evaluate(String expression) {

		char[] tokens = expression.toCharArray();
		// Stack for numbers: 'values'
		Stack<Integer> values = new Stack<Integer>();
		// Stack for Operators: 'operators'
		Stack<Character> operators = new Stack<Character>();

		for (int i = 0; i < tokens.length; i++) {
			// Current token is a whitespace, skip it
			if (tokens[i] == ' ')
				continue;
			// Current token is a number, push it to stack for numbers
			if (tokens[i] >= '0' && tokens[i] <= '9') {
				StringBuffer stringBuffer = new StringBuffer();
				// There may be more than one digits in number
				while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
					stringBuffer.append(tokens[i++]);
				}
				values.push(Integer.parseInt(stringBuffer.toString()));
			    i--;
			} else if (tokens[i] == '(') {
			    // Current token is an opening brace, push it to 'operators'
				operators.push(tokens[i]);
			} else if (tokens[i] == ')') {
			   // Closing brace encountered, solve entire brace
				while (operators.peek() != '(') {
				  values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
			    }
				operators.pop();
			} else if (tokens[i] == '+' || tokens[i] == '-' ||tokens[i] == '*' || tokens[i] == '/') {
			   // Current token is an operator.
				while (!operators.empty() && hasPrecedence(tokens[i], operators.peek())) {
				  values.push(applyOperation(operators.pop(), values.pop(),values.pop()));
			      // System.out.println(values.peek());
			    }
				// Push current token to 'operators'.
				operators.push(tokens[i]);
			}
		}
		// Entire expression has been parsed at this point, apply remaining operators to remaining values
		while (!operators.empty()) {
			values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
		}
		// Top of 'values' contains result, return it
		return values.pop();
	}

	// Returns true if 'op2' has higher or same precedence as 'op1', otherwise returns false.
	public static boolean hasPrecedence(char op1, char op2) {

		if (op2 == '(' || op2 == ')') {
			return false;
		}

		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')){
			return false;
		} else {
			return true;
		}
	}
/*   static int precedence(char ch) 
	{ 
		switch (ch) 
		{ 
			case '+': 
			case '-': 
				return 1; 
		
			case '*': 
			case '/': 
				return 2; 
		
			case '^': 
				return 3; 
		} 
		return -1; 
	} */

	// A utility method to apply an operator 'op' on operands 'a'  and 'b'. Return the result.
	public static int applyOperation(char op, int b, int a) {

		switch (op) {

			case '+':
				return a + b;
			case '-':
				return a - b;
			case '*':
				return a * b;
			case '/':
				if (b == 0)throw new UnsupportedOperationException("Cannot divide by zero");
				return a / b;
		}
		return 0;
	}

	// Driver method to test above methods
	public static void main(String[] args) {
		// System.out.println(ExpressionEvaluation.evaluate("10 + 2 * 6"));
		// System.out.println(ExpressionEvaluation.evaluate("100 * 2 + 12"));
		// System.out.println(ExpressionEvaluation.evaluate("100 * ( 2 + 12 )"));
		System.out.println("(100 * ( 2 + 12 ) / 14) = "+ExpressionEvaluation.evaluate("(100 * ( 2 + 12 ) / 14)"));

		// System.out.println(ExpressionEvaluation.evaluate("100*(2+12)/14"));
	}
}

/*Expression Evaluation

Time Complexity: O(n) 
Space Complexity: O(n)

Algorithm:

1. While there are still tokens to be read in,
   1.1 Get the next token.
   1.2 If the token is:
       1.2.1 A number: push it onto the value stack.
       1.2.2 A variable: get its value, and push onto the value stack.
       1.2.3 A left parenthesis: push it onto the operator stack.
       1.2.4 A right parenthesis:
         1 While the thing on top of the operator stack is not a 
           left parenthesis,
             1 Pop the operator from the operator stack.
             2 Pop the value stack twice, getting two operands.
             3 Apply the operator to the operands, in the correct order.
             4 Push the result onto the value stack.
         2 Pop the left parenthesis from the operator stack, and discard it.
       1.2.5 An operator (call it thisOp):
         1 While the operator stack is not empty, and the top thing on the
           operator stack has the same or greater precedence as thisOp,
           1 Pop the operator from the operator stack.
           2 Pop the value stack twice, getting two operands.
           3 Apply the operator to the operands, in the correct order.
           4 Push the result onto the value stack.
         2 Push thisOp onto the operator stack.
2. While the operator stack is not empty,
    1 Pop the operator from the operator stack.
    2 Pop the value stack twice, getting two operands.
    3 Apply the operator to the operands, in the correct order.
    4 Push the result onto the value stack.
3. At this point the operator stack should be empty, and the value
   stack should have only one value in it, which is the final result.



Evaluate an expression represented by a String. The expression can contain parentheses, 
you can assume parentheses are well-matched. For simplicity, you can assume only binary 
operations allowed are +, -, *, and /. Arithmetic Expressions can be written in one of 
three forms:

Infix Notation: Operators are written between the operands they operate on, e.g. 3 + 4.

Prefix Notation: Operators are written before the operands, e.g + 3 4

Postfix Notation: Operators are written after operands.*/