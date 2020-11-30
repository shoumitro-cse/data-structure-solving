// Java proram to evaluate value of a postfix expression 

//javac -d classes EvaluatePostfix.java  && cd classes && java EvaluatePostfix && cd ..

import java.util.Stack; 

public class EvaluatePostfix 
{ 
	// Method to evaluate value of a postfix expression 
	// Time complexity is O(n)
	static int evaluatePostfix(String exp) 
	{ 
		//create a stack 
		Stack<Integer> stack=new Stack<>(); 
		
		// Scan all characters one by one 
		for(int i=0; i<exp.length(); i++) 
		{ 
			char c = exp.charAt(i); 

			if(c == ' ') {
				continue;
			}
			
			// If the scanned character is an operand (number here), push it to the stack. 
			if(Character.isDigit(c)) {
			  // stack.push(c - '0'); 
			  stack.push(Integer.parseInt(c+"")); 
			} else { 
				// exp="231*+9-"; 

			    // If the scanned character is an operator, pop two 
			    // elements from stack apply the operator 
				int val1 = stack.pop(); 
				int val2 = stack.pop(); 
				
				switch(c) {

					case '+': 
						stack.push(val2+val1); 
						break; 
					
					case '-': 
						stack.push(val2- val1); 
						break; 
					
					case '/': 
						stack.push(val2/val1); 
						break; 
					
					case '*': 
						stack.push(val2*val1); 
						break; 
			    } 
			} 
		} 
		return stack.pop();	 
	} 
	
	// Driver program to test above functions 
	public static void main(String[] args) { 
		String exp="231*+9-"; 
		System.out.println("postfix evaluation.\n"+exp+" = "+evaluatePostfix(exp)); 
	} 
} 



/*Stack | Set 4 (Evaluation of Postfix Expression)

Time complexity of evaluation algorithm is O(n) where n is number of characters in input expression.


The Postfix notation is used to represent algebraic expressions. 
The expressions written in postfix form are evaluated faster compared to infix notation 
as parenthesis are not required in postfix. We have discussed infix to postfix conversion. 
In this post, evaluation of postfix expressions is discussed.

Following is algorithm for evaluation postfix expressions.
	1) Create a stack to store operands (or values).
	2) Scan the given expression and do following for every scanned element.
	…..a) If the element is a number, push it into the stack
	…..b) If the element is a operator, pop operands for the operator from stack. 
	      Evaluate the operator and push the result back to the stack
	3) When the expression is ended, the number in the stack is the final answer


Example:

Let the given expression be “2 3 1 * + 9 -“. We scan all elements one by one.

1) Scan ‘2’, it’s a number, so push it to stack. Stack contains ‘2’
2) Scan ‘3’, again a number, push it to stack, stack now contains ‘2 3’ (from bottom to top)
3) Scan ‘1’, again a number, push it to stack, stack now contains ‘2 3 1’
4) Scan ‘*’, it’s an operator, pop two operands from stack, apply the * operator on operands, 
   we get 3*1 which results in 3. We push the result ‘3’ to stack. Stack now becomes ‘2 3’.
5) Scan ‘+’, it’s an operator, pop two operands from stack, apply the + operator on operands, 
   we get 3 + 2 which results in 5. We push the result ‘5’ to stack. Stack now becomes ‘5’.
6) Scan ‘9’, it’s a number, we push it to the stack. Stack now becomes ‘5 9’.
7) Scan ‘-‘, it’s an operator, pop two operands from stack, apply the – operator on operands, 
   we get 5 – 9 which results in -4. We push the result ‘-4’ to stack. Stack now becomes ‘-4’.
8) There are no more elements to scan, we return the top element from stack (which is the only 
   element left in stack).*/