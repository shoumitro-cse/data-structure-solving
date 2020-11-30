//Convert Infix To Prefix Notation

//javac -d classes InfixToPrefix.java  && cd classes && java InfixToPrefix && cd ..

import java.util.Stack; 

class InfixToPrefix { 
	
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
	static String infixToPostFix(String exp) 
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

	static String infixToPreFix(String str) {

         int len = str.length();
         String reverse="";

		for (int i=len-1; i>=0; i--) {
			if(str.charAt(i)=='(') {
              reverse +=")";
			} else if(str.charAt(i)==')') {
				reverse +="(";
			} else {
				reverse += str.charAt(i)+"";
			}
		}

		String prefix= infixToPostFix(reverse);

		reverse = ""; 
		len = prefix.length();         
		for (int i=len-1; i>=0; i--) {
		  reverse += prefix.charAt(i)+"";
		}

      return reverse;
	}
	
	// Driver method 
	public static void main(String[] args) { 

		// String exp = "a+b*(c^d-e)^(f+g*h)-i"; 
		String exp = "((a+b)*(c+d))"; 

		System.out.println("orginal infix: "+exp); 
		// System.out.println("convert postfix: "+infixToPostFix(exp)); 

		System.out.println("convert prefix: "+infixToPreFix(exp)); 
	} 
} 



/*
Convert Infix To Prefix Notation

Algorithm:
Step 1: Reverse the infix expression i.e A+B*C will become C*B+A. Note 
       while reversing each ‘(‘ will become ‘)’ and each ‘)’ becomes ‘(‘.
Step 2: Obtain the postfix expression of the modified expression i.e CB*A+.
Step 3: Reverse the postfix expression. Hence in our example prefix is +A*BC.

Input : A * B + C / D
Output : + * A B/ C D 

Input : (A - B/C) * (A/K-L)
Output : *-A/BC-/AKL*/