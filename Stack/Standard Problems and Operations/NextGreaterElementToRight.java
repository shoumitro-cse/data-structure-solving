// Java program to print number of NGEs to the right

//javac -d classes NextGreaterElementToRight.java  && cd classes && java NextGreaterElementToRight && cd ..


import java.util.*;

class NextGreaterElementToRight
{

	// array to store the next greater element index
	static void fillNext(int next[], int a[], int n) {
		// Use stack
		Stack<Integer> s = new Stack<Integer>();
		// push the 0th index to the stack
		s.push(0);
		// traverse in the loop from 1-nth index
		for (int i = 1; i < n; i++) {
			// iterate till loop is empty
			while (s.size() > 0) {
				// get the topmost index in the stack
				int cur = s.peek();

				if (a[cur] < a[i]) {
					// initialize the cur index position's next greatest as index
					next[cur] = i;
					// pop the cur index as its greater element has been found
					s.pop();
				} else {
				// if not greater then break
					break;
				}
			}
			// push the i index so that its next greatest can be found
			s.push(i);
		}
		// iterate for all other index left inside stack
		while (s.size() > 0) {
			int cur = s.peek();
			// mark it as -1 as no element in greater then it in right
			next[cur] = -1;
			s.pop();
		}
		// System.out.println("next array: "+Arrays.toString(next));
	}

	// function to count the number of 
	// next greater numbers to the right
	static void count(int a[], int dp[], int n)
	{
		// initializes the next array as 0
		int next[] = new int[n];

		for(int i = 0; i < n; i++) {
		   next[i] = 0;
		}
		
		// calls the function to pre-calculate
		// the next greatest element indexes
		fillNext(next, a, n);
		System.out.println("next greater index array: "+Arrays.toString(next));

		for (int i = n - 1; i >= 0; i--) {
			// if the i-th element has no next greater element to right
			if (next[i] == -1) {
				dp[i] = 0;
			} else {
			    // Count of next greater numbers to right.
				dp[i] = 1 + dp[next[i]];
			}
		}
	}

	// answers all queries in O(1)
	static int answerQuery(int dp[], int index)
	{
		// returns the number of next greater
		// elements to the right.
		return dp[index];
	}

	// driver code
	public static void main(String args[]) {
		
		int arr[] = { 3, 4, 2, 7, 5, 8, 10, 6 };
		System.out.println("\noriginal array: "+Arrays.toString(arr));
		int n = arr.length;

		int dp[] = new int[n];

		// calls the function to count the number
		// of greater elements to the right for every element.
		count(arr, dp, n);


		System.out.println("dp: "+Arrays.toString(dp));

		// query 1 answered
		System.out.println(answerQuery(dp, 0));

		// query 2 answered
		System.out.println( answerQuery(dp, 5));
		

	}
}


/*
Number of NGEs to the right


Given an array of n integers and q queries, print the number of 
next greater elements to the right of the given index element. 
Examples: 

Input: a[] = {3, 4, 2, 7, 5, 8, 10, 6}  
              q = 2 
              index = 0, 
              index = 5
Output: 6
        1 

Explanation:

1. The next greater elements
to the right of 3(index 0) are 4,7,5,8,10,6. so output=6

2. The next greater elements to the right
of 8(index 5) are 10. so output=1*/