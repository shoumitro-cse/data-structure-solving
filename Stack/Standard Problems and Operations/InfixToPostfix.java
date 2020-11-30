//Infix to Postfix

 // Java implementation to convert infix expression to postfix

// Note that here we use Stack class for Stack operations 
//javac -d classes InfixToPostfix.java  && cd classes && java InfixToPostfix && cd ..

import java.util.Stack; 

class InfixToPostfix { 
	
	// A utility function to return 
	// precedence of a given operator 
	// Higher returned value means higher precedence 
	static int precedence(char ch) 
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
	} 
	
	// The main method that converts 
	// given infix expression to postfix expression. 
	static String infixToPostfix(String exp) 
	{ 
		// initializing empty String for result 
		String result = new String(""); 
		
		// initializing empty stack 
		Stack<Character> stack = new Stack<>(); 
		
		for (int i = 0; i<exp.length(); ++i) {

			char c = exp.charAt(i); 
			
			// If the scanned character is an operand, add it to output. 
			if (Character.isLetterOrDigit(c)) {
				result += c; 
				// System.out.println(c);
			} else if (c == '(') {
			    // If the scanned character is an '(', push it to the stack. 
				stack.push(c); 
			} else if (c == ')') { 
				// If the scanned character is an ')', 
				// pop and output from the stack 
				// until an '(' is encountered. 
				while (!stack.isEmpty() && stack.peek() != '(') { 
					result += stack.pop(); 
				}
				stack.pop(); 
			} else { 
			    // an operator is encountered 
				while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) { 
					result += stack.pop(); 
			    } 
				stack.push(c); 
			} 
	
		} 
	
		// pop all the operators from the stack 
		while (!stack.isEmpty()) { 
			if(stack.peek() == '(') 
				return "Invalid Expression"; 
			result += stack.pop(); 
		} 
		return result; 
	} 
	
	// Driver method 
	public static void main(String[] args) { 
		String exp = "a+b*(c^d-e)^(f+g*h)-i"; 
		System.out.println(infixToPostfix(exp)); 
	} 
} 


/*(Infix to Postfix)

Algorithm 
1. Scan the infix expression from left to right. 
2. If the scanned character is an operand, output it. 
3. Else, 
      1 If the precedence of the scanned operator is greater than the precedence of 
        the operator in the stack(or the stack is empty or the stack contains a ‘(‘ ), push it. 
      2 Else, Pop all the operators from the stack which are greater than or equal to in 
        precedence than that of the scanned operator. After doing that Push the scanned operator 
        to the stack. (If you encounter parenthesis while popping then stop there and push the 
        scanned operator in the stack.) 
4. If the scanned character is an ‘(‘, push it to the stack. 
5. If the scanned character is an ‘)’, pop the stack and and output it until a ‘(‘ is encountered, 
   nd discard both the parenthesis. 
6. Repeat steps 2-6 until infix expression is scanned. 
7. Print the output 
8. Pop and output from the stack until it is not empty.



Infix expression:The expression of the form a op b. When an operator is in-between every pair
                  of operands.
Postfix expression:The expression of the form a b op. When an operator is followed for every 
                    pair of operands.

Why postfix representation of the expression? 

The compiler scans the expression either from left to right or from right to left. 
Consider the below expression: a op1 b op2 c op3 d 
If op1 = +, op2 = *, op3 = +
The compiler first scans the expression to evaluate the expression b * c, then 
again scan the expression to add a to it. The result is then added to d after another scan.
The repeated scanning makes it very in-efficient. It is better to convert the expression to 
postfix(or prefix) form before evaluation.
The corresponding expression in postfix form is: abc*+d+. The postfix expressions can be 
evaluated easily using a stack. We will cover postfix expression evaluation in a separate post.

*/



 // C++ implementation to convert infix expression to postfix
// Note that here we use std::stack 
// for Stack operations 
/*#include<bits/stdc++.h> 
using namespace std; 

//Function to return precedence of operators 
int prec(char c) 
{ 
	if(c == '^') 
	return 3; 
	else if(c == '*' || c == '/') 
	return 2; 
	else if(c == '+' || c == '-') 
	return 1; 
	else
	return -1; 
} 

// The main function to convert infix expression 
//to postfix expression 
void infixToPostfix(string s) 
{ 
	std::stack<char> st; 
	st.push('N'); 
	int l = s.length(); 
	string ns; 
	for(int i = 0; i < l; i++) 
	{ 
		
		// If the scanned character is 
		// an operand, add it to output string. 
		if((s[i] >= 'a' && s[i] <= 'z') || 
		(s[i] >= 'A' && s[i] <= 'Z')) 
		ns+=s[i]; 

		// If the scanned character is an 
		// ‘(‘, push it to the stack. 
		else if(s[i] == '(') 
		
		st.push('('); 
		
		// If the scanned character is an ‘)’, 
		// pop and to output string from the stack 
		// until an ‘(‘ is encountered. 
		else if(s[i] == ')') 
		{ 
			while(st.top() != 'N' && st.top() != '(') 
			{ 
				char c = st.top(); 
				st.pop(); 
			ns += c; 
			} 
			if(st.top() == '(') 
			{ 
				char c = st.top(); 
				st.pop(); 
			} 
		} 
		
		//If an operator is scanned 
		else{ 
			while(st.top() != 'N' && prec(s[i]) <= 
								prec(st.top())) 
			{ 
				char c = st.top(); 
				st.pop(); 
				ns += c; 
			} 
			st.push(s[i]); 
		} 

	} 
	
	// Pop all the remaining elements from the stack 
	while(st.top() != 'N') 
	{ 
		char c = st.top(); 
		st.pop(); 
		ns += c; 
	} 
	
	cout << ns << endl; 

} 

//Driver program to test above functions 
int main() 
{ 
	string exp = "a+b*(c^d-e)^(f+g*h)-i"; 
	infixToPostfix(exp); 
	return 0; 
} 
// This code is contributed by Gautam Singh 
*/