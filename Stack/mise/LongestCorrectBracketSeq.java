// Range Queries for Longest Correct Bracket Subsequence Set | 2

//javac -d classes LongestCorrectBracketSeq.java  && cd classes && java LongestCorrectBracketSeq && cd ..

import java.util.*;

class LongestCorrectBracketSeq {

	/*
	openBracket[] stands for "Balanced open parentheses" 
	closeBracket[] stands for "Balanced close parentheses"
	*/

/*	// Function for precomputation
	static void constructBlanceArray(int openBracket[], int closeBracket[], String str, int n) {
		// Create a stack and push -1 as initial index to it.
		Stack<Integer> stack = new Stack<>();;
		// Traverse all characters of given String
		for(int i = 0; i < n; i++) {
			// If opening bracket, push index of it
			if (str.charAt(i) == '(') {
				stack.add(i);
			} else {
			   // If closing bracket, i.e., str[i] = ')'
				if (!stack.isEmpty()) {
					closeBracket[i] = 1;
					openBracket[stack.peek()] = 1;
					stack.pop();
				} else {
				   // If stack is empty.
					closeBracket[i] = 0;
				}
			}
		}
		// System.out.println("openBracket: "+Arrays.toString(openBracket));
		// System.out.println("closeBracket: "+Arrays.toString(closeBracket));
		for(int i = 1; i < n; i++) {
			closeBracket[i] += closeBracket[i - 1];
			openBracket[i] += openBracket[i - 1];
		}
	}

	// Function return output of each query in O(1)
	static int query(int openBracket[], int closeBracket[], int start, int end) {

		if (openBracket[start-1] == openBracket[start]) {
			return (closeBracket[end]-openBracket[start]) * 2;
		} else {
			return (closeBracket[end]-openBracket[start] + 1) * 2;
		}
	}
*/

	// Function return output of each query in O(1)
	static int longestCorrectBracket(String str, int start, int end) {

		if (start>end || start>str.length()|| end>str.length()) {
		  return 0;
		}

		int result=0;
		Stack<Character> stack = new Stack<>();
		for (int i=start; i<=end ;i++ ) {
			char ch = str.charAt(i);
			if (ch == '(') {
				stack.push(ch);
			} else if(ch == ')') {
			  while(!stack.isEmpty() && stack.peek() != '(') {
			    result++;
			    stack.pop();
			  }
			  if (!stack.isEmpty()) {
			      stack.pop();
			      result++;
			  }
			}
		}
	  
	  return result*2;
	}



	// Driver code
	public static void main(String[] args)
	{

		String str = "())(())(())(";
		int n = str.length();

		int startIndex = 1, endIndex = 8;

		System.out.print("Maximum Length Correct " + 
						"Bracket Subsequence between " + 
						startIndex + " and " + endIndex +
						" = " + longestCorrectBracket(str, startIndex, endIndex) + "\n");

/*		int closeBracket[] = new int[n+1];
		int openBracket[] = new int[n+1];

		constructBlanceArray(openBracket, closeBracket, str, n);*/

/*		System.out.println("openBracket:  "+Arrays.toString(openBracket));
		System.out.println("closeBracket: "+Arrays.toString(closeBracket));*/

/*
		startIndex = 4;
		endIndex = 5;
		System.out.print("Maximum Length Correct " + 
						"Bracket Subsequence between " + 
						startIndex + " and " + endIndex +
						" = " + query(openBracket, closeBracket, startIndex,
									endIndex) + "\n");

		startIndex = 1;
		endIndex = 5;
		System.out.print("Maximum Length Correct " +
						"Bracket Subsequence between " +
						startIndex + " and " + endIndex +
						" = " + query(openBracket, closeBracket, startIndex,
									endIndex) + "\n");*/
	}
}



/*
Range Queries for Longest Correct Bracket Subsequence Set | 2

Given a bracket sequence or in other words a string S of length n, consisting of 
characters ‘(‘ and ‘)’. Find the length of the maximum correct bracket subsequence 
of sequence for a given query range. Note: A correct bracket sequence is the one 
that has matched bracket pairs or which contains another nested correct bracket 
sequence. For e.g (), (()), ()() are some correct bracket sequence. 

Examples:

Input : S = ())(())(())(
        Start Index of Range = 0, 
        End Index of Range = 11
Output : 10
Explanation:  Longest Correct Bracket Subsequence is ()(())(())

Input : S = ())(())(())(
        Start Index of Range = 1, 
        End Index of Range = 2
Output : 0*/