// Java program to find length of the longest valid substring 

//javac -d classes LongestValidSubstringParenthesis.java  && cd classes && java LongestValidSubstringParenthesis && cd ..

import java.util.Stack; 

class LongestValidSubstringParenthesis 
{ 

 /* 
    //Another approach in O(1) auxiliary space and O(N) Time complexity  
    public static int findMaxLen(String s) {

    	int n = s.length();
  
        // Variables for left and right 
        // counter maxlength to store 
        // the maximum length found so far 
        int left = 0, right = 0; 
        int maxlength = 0; 
  
        // Iterating the string from left to right 
        for (int i = 0; i < n; i++) { 
           // String str = "((()()"; 
            if (s.charAt(i) == '(') 
                left++; 
            else
                right++; 

            if (left == right) 
                maxlength = Math.max(maxlength, 2 * right); 
  
            else if (right > left) 
                left = right = 0; 
        } 
  
        left = right = 0; 
  
        // Iterating the string from right to left 
        for (int i = n - 1; i >= 0; i--) { 
           // String str = "((()()"; 
            if (s.charAt(i) == '(') 
                left++; 
            else
                right++; 
  
            if (left == right) 
                maxlength = Math.max(maxlength, 2 * left); 
  
            else if (left > right) 
                left = right = 0; 
        } 
        return maxlength; 
    } */

	// method to get length of the longest valid 
	static int findMaxLen(String str) 
	{ 
		int n = str.length(); 
		// Create a stack and push -1 as initial index to it. 
		Stack<Integer> stack = new Stack<>(); 
		stack.push(-1); 
		// Initialize result 
		int result = 0; 
		// Traverse all characters of given string 
		for (int i = 0; i < n; i++) 
		{ 
			// If opening bracket, push index of it 
			if (str.charAt(i) == '(') {
				stack.push(i); 
			} else { 
			   // If closing bracket, i.e.,str[i] = ')' 
				if(!stack.empty()) {
					stack.pop(); 
				}

				if (!stack.empty()) {
					result = Math.max(result, i - stack.peek()); 
				} else {
					stack.push(i); 
				}
			} 
		} 

		return result; 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		String str = "((()()"; 
		// Function call 
		System.out.println(findMaxLen(str)); 

/*		str = "()(()))))"; 
		// Function call 
		System.out.println(findMaxLen(str)); */
	} 
}

/*
Length of the longest valid substring

Given a string consisting of opening and closing parenthesis, find the length of the 
longest valid parenthesis substring.

Examples: 

Input : ((()
Output : 2
Explanation : ()

Input: )()())
Output : 4
Explanation: ()() 

Input:  ()(()))))
Output: 6
Explanation:  ()(())


Algorithm:
1) Create an empty stack and push -1 to it. 
   The first element of the stack is used 
   to provide a base for the next valid string. 

2) Initialize result as 0.

3) If the character is '(' i.e. str[i] == '('), 
   push index'i' to the stack. 
   
2) Else (if the character is ')')
   a) Pop an item from the stack (Most of the 
      time an opening bracket)
   b) If the stack is not empty, then find the
      length of current valid substring by taking 
      the difference between the current index and
      top of the stack. If current length is more 
      than the result, then update the result.
   c) If the stack is empty, push the current index
      as a base for the next valid substring.

3) Return result.
*/