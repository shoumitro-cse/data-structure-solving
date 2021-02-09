// Find the smallest binary digit multiple of given number

// javac -d classes SmallestBinaryDigit.java  && cd classes && java SmallestBinaryDigit && cd ..

import java.util.*;
import java.io.*;

class SmallestBinaryDigit {

	// Method return t % N, where t is stored as a string
	public static int mod(String t, int N) {
		
		int r = 0;
		
		for(int i = 0; i < t.length(); i++) {
			r = r * 10 + (t.charAt(i) - '0');
			r = r % N;
		}

		return r;
	}

	// method returns smallest multiple which has binary digits
	public static String getMinimumMultipleOfBinaryDigit(int N) {

		Queue<String> q = new LinkedList<String>();
		Set<Integer> visit = new HashSet<>();

		String t = "1";

		// In starting push 1 into our queue
		q.add(t);

		// loop untill queue is not empty
		while (!q.isEmpty()) {
			
			// Take the front number from queue.
			t = q.remove();

			// Find remainder of t with respect to N.
			int rem = mod(t, N);
			
			// If remainder is 0 then we have found our solution
			if (rem == 0){
				return t;
			} else if(!visit.contains(rem)) {
			    // If this remainder is not previously seen, 
			    //then push t0 and t1 in our queue
				visit.add(rem);
				q.add(t + "0");
				q.add(t + "1");
			}

		}

		return "";
	}

	public static void main (String[] args) {
		int N = 12;
		System.out.println(getMinimumMultipleOfBinaryDigit(N));
	}

}



/*
Find the smallest binary digit multiple of given number


A decimal number is called a binary digit number if its digits are binary. For example, 102 is not 
a binary digit number and 101 is.
We are given a decimal number N, we need to find the smallest multiple of N which is a binary digit 
number, 

Examples:  

Input : N = 2
Output: 10
Explanation: 10 is a multiple of 2. 
              Note that 5 * 2 = 10

Input  : N = 17
Output : 11101
Explanation: 11101 is a multiple of 17. 
              Note that 653 * 17 = 11101
*/