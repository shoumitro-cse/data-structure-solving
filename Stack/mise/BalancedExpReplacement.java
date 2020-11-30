// Java program to determine whether given expression is balanced/ parenthesis expression or not. 

//Balanced expression with replacement

//javac -d classes BalancedExpReplacement.java  && cd classes && java BalancedExpReplacement && cd ..

import java.util.Stack; 

class BalancedExpReplacement { 
	// Function to check if two 
	// brackets are matching or not. 

	static int isMatching(char a, char b) { 
		if ((a == '{' && b == '}') || (a == '[' && b == ']') || (a == '(' && b == ')') || a == 'X') { 
			return 1; 
		} 
		return 0; 
	} 

	// Recursive function to check if given expression is balanced or not. 
	// Time Complexity: O((2^n)*n)
    // Auxiliary Space: O(N)
	static int isBalanced(String s, Stack<Character> stack, int index) { 

		if (index == s.length()) { 
			if (stack.size() == 0) { 
				return 1; 
			} else { 
				return 0; 
			} 
		} 

		char top; 
		int res; 

		if (s.charAt(index) == '{'|| s.charAt(index) == '('|| s.charAt(index) == '[') { 
			
			 stack.push(s.charAt(index)); 
			return isBalanced(s, stack, index + 1); 

		} else if (s.charAt(index) == '}' || s.charAt(index) == ')'|| s.charAt(index) == ']') { 

			if (stack.size() == 0) { 
				return 0; 
			} 
			
			top = stack.pop(); 

			if (isMatching(top, s.charAt(index)) == 0) { 
				return 0; 
			} 
			return isBalanced(s, stack, index + 1); 

		} else if (s.charAt(index) == 'X') { 

			Stack<Character> tempStack = new Stack<>(); 
			//because in java, direct assignment copies only reference and not the whole object 
			tempStack.addAll(stack); 
			tempStack.push(s.charAt(index)); 
			
			res = isBalanced(s, tempStack, index + 1); //return 0
			
			if (res == 1) { 
				return 1; 
			} 

			if (stack.size() == 0) { 
				return 0; 
			}
			stack.pop(); 
			
			return isBalanced(s, stack, index + 1); 
		} 

		return 1; 
	} 

	// Driver Code 
	public static void main(String[] args) { 

		// String s = "[{X}(X)]"; //Not Balanced
		// String s = "{(X}[X";// here X is a replacement of ')' and ']', X=')' and X=']' //Balanced
		String s = "{(X}[]";// here X is a replacement of ')', X=')' //Balanced
		Stack<Character> stack = new Stack<Character>(); 

		if (isBalanced(s, stack, 0) != 0) { 
			System.out.println("Balanced"); 
		} else { 
			System.out.println("Not Balanced"); 
		} 
	} 
} 



/*Balanced expression with replacement

Given a string that contains only the following => ‘{‘, ‘}’, ‘(‘, ‘)’, ‘[’, ‘]’. 
At some places there is ‘X’ in place of any bracket. Determine whether by replacing 
all ‘X’s with appropriate bracket, is it possible to make a valid bracket sequence.

Prerequisite: Balanced Parenthesis Expression

Examples:

Input : S = "{(X[X])}"
Output : Balanced
The balanced expression after 
replacing X with suitable bracket is:
{([[]])}.

Input : [{X}(X)]
Output : Not balanced
No substitution of X with any bracket
results in a balanced expression.


Approach: We have discussed a solution on verifying whether given parenthesis expression is 
balanced or not.

Following the same approach described in the article, a stack data structure is used for 
verifying whether given expression is balanced or not. For each type of character in string, 
the operations to be performed on stack are:

1. ‘{‘ or ‘(‘ or ‘[‘ : When current element of string is an opening bracket, push the element 
	in stack.
2. ‘}’ or ‘]’ or ‘)’ : When current element of string is a closing bracket, pop the top element 
   of the stack and check if it is a matching opening bracket for the closing bracket or not. 
    If it is matching, then move to next element of string. If it is not, then current string 
    is not balanced. It is also possible that the element popped from stack is ‘X’. In that case 
    ‘X’ is a matching opening bracket because it is pushed in stack only when it is assumed to be
    an opening bracket as described in next step.
3. ‘X’ : When current element is X then it can either be a starting bracket or a closing bracket. 
   First assume that it is a starting bracket and recursively call for next element by pushing 
   X in stack. If the result of recursion is false then X is a closing bracket which matches the 
   bracket at top of the stack (If stack is non-empty). So pop the top element and recursively 
   call for next element. If the result of recursion is again false, then the expression is not 
   balanced.*/