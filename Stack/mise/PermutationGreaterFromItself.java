// Count natural numbers whose all permutation are greater than that number

// javac -d classes PermutationGreaterFromItself.java  && cd classes && java PermutationGreaterFromItself && cd ..

import java.util.Stack; 

class PermutationGreaterFromItself { 

   //Time Complexity : O(x) where x is number of elements printed in output
   // Return the count of the number having all permutation greater than or equal to the number. 
	static int countNumber(int n) { 

		int result = 0; 
		// Pushing 1 to 9 because all number from 1 to 9 have this property. 
		for (int i = 1; i <= 9; i++) { 

			Stack<Integer> stack = new Stack<>(); 
			if (i <= n) { 
				stack.push(i); 
				result++; 
			} 
			System.out.println("stack: "+stack);
			// take a number from stack and add a digit smaller than last digit of it. 
			while (!stack.empty()) { 
				int top = stack.pop(); 
				for (int j = top % 10; j <= 9; j++) { 
					int x = top * 10 + j; 
					if (x <= n) { 
			            System.out.println("entry");
						stack.push(x); 
						result++; 
					} 
				} 
			} 

			System.out.println("result: "+result);
			System.out.println();
		} 

		return result; 
	} 

	public static void main(String[] args) { 
		int n = 22; 
		System.out.println("Output: "+countNumber(n)); 

	} 
} 

/*
Count natural numbers whose all permutation are greater than that number

There are some natural number whose all permutation is greater than or equal to that 
number eg. 123, whose all the permutation (123, 231, 321) are greater than or equal to 123.

Given a natural number n, the task is to count all such number from 1 to n.

Examples:

Input : n = 15.
Output : 14
1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 
13, 14, 15 are the numbers whose all 
permutation is greater than the number
itself. So, output 14.

Input : n = 100.
Output : 54
*/