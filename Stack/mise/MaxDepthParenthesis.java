//Find maximum depth of nested parenthesis in a string

//javac -d classes MaxDepthParenthesis.java  && cd classes && java MaxDepthParenthesis && cd ..

class MaxDepthParenthesis { 

// function takes a string and returns the 
// maximum depth nested parenthesis 
	static int maxDepth(String S) { 

		int current_max = 0; // current count 
		int max = 0; // overall maximum count 
		int n = S.length(); 

		// Traverse the input string 
		for (int i = 0; i < n; i++) { 

			if (S.charAt(i) == '(') { 
				current_max++; 
				// update max if required 
				if (current_max > max) { 
					max = current_max; 
				} 

			} else if (S.charAt(i) == ')') { 
				if (current_max > 0) { 
					current_max--; 
				} else { 
					return -1; 
				} 
			} 
		} 

		// finally check for unbalanced string 
		if (current_max != 0) { 
			return -1; 
		} 

		return max; 
	} 

// Driver program 
	public static void main(String[] args) { 
		String s = "( ((X)) (((Y))) )"; 
		System.out.println(maxDepth(s)); 
	} 
} 



/*Time Complexity : O(n) 
Auxiliary Space : O(n)
Method 2 ( O(1) auxiliary space ) 
This can also be done without using stack. 
 

1) Take two variables max and current_max, initialize both of them as 0.
2) Traverse the string, do following for every character
    a) If current character is ‘(’, increment current_max and 
       update max value if required.
    b) If character is ‘)’. Check if current_max is positive or
       not (this condition ensure that parenthesis are balanced). 
       If positive that means we previously had a ‘(’ character 
       so decrement current_max without worry. 
       If not positive then the parenthesis are not balanced. 
       Thus return -1. 
3) If current_max is not 0, then return -1 to ensure that the parenthesis
   are balanced. Else return max


  Examples : 

	Input : S = "( a(b) (c) (d(e(f)g)h) I (j(k)l)m)";
	Output : 4

	Input : S = "( p((q)) ((s)t) )";
	Output : 3

	Input : S = "";
	Output : 0

	Input : S = "b) (c) ()";
	Output : -1 

	Input : S = "(b) ((c) ()"
	Output : -1 

*/