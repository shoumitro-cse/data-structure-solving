// Java program to find min sum of squares of characters after k removals 

//javac -d classes FindMinSumOfsquaresOfcharactersAfterKremovals.java  && cd classes && java FindMinSumOfsquaresOfcharactersAfterKremovals && cd ..

import java.util.Comparator; 
import java.util.PriorityQueue; 
import java.util.*; 

public class FindMinSumOfsquaresOfcharactersAfterKremovals { 

	static final int MAX_CHAR = 26; 

	// Main Function to calculate min sum of squares of characters after k removals 
	// Time Complexity: O(k*logn)
	static int minStringValue(String str, int k) { 
		
		int l = str.length(); // find length of string 
		
		// if K is greater than length of string so reduced string will become 0 
		if (k >= l) 
			return 0; 

		// Else find Frequency of each character and store in an array 
		int[] frequency = new int[MAX_CHAR]; 
		for (int i = 0; i < l; i++) {
			frequency[str.charAt(i)-'a']++; 
		}
		// System.out.println(Arrays.toString(frequency));

		// creating a priority queue with comparator 
		// such that elements in the queue are in descending order. 
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder()); 

		// Push each char frequency into a priority_queue 
		for (int i = 0; i < MAX_CHAR; i++) { 
			if (frequency[i] != 0) {
				q.add(frequency[i]); 
			}
		} 
		// System.out.println(q);

		// Remove K characters which have highest frequency from queue.
		while (k != 0) { //k=2
			// it is reverse order. so str="aaab" [3, 1] then [2, 1] then [1,1]
			q.add(q.poll()-1); 
			k--; 
		} 
		// System.out.println(q);
		// After removal of K characters find sum of squares of string Value 
		int result = 0; // Initialize result 
		while (!q.isEmpty()) { 
			result += q.peek() * q.poll(); 
		} 

		return result; 
	} 

	// Driver Code 
	public static void main(String args[]) 
	{ 
		String str = "abbccc"; // Input 1 
		int k = 2; 
		// System.out.println("Output: "+minStringValue(str, k)); 

		str = "aaab"; // Input 2 
		k = 2; 
		System.out.println("Output: "+minStringValue(str, k)); 
	} 
} 



/*
Algorithm:
1. Initialize empty priority queue.
2. Count frequency of each character and Store into temp array.
4. Remove K characters which have highest frequency from queue.
5. Finally Count Sum of square of each element and return it.

Minimum sum of squares of character counts in a given string after removing k characters

Given a string of lowercase alphabets and a number k, the task is to print the minimum 
value of the string after removal of ‘k’ characters. The value of a string is defined 
as the sum of squares of the count of each distinct character. For example consider 
the string “saideep”, here frequencies of characters are s-1, a-1, i-1, e-2, d-1, p-1 and 
value of the string is 1^2 + 1^2 + 1^2 + 1^2 + 1^2 + 2^2 = 9.

Expected Time Complexity: O(k*logn)

Examples:

Input :  str = abccc, K = 1
Output :  6
We remove c to get the value as 12 + 12 + 22

Input :  str = aaab, K = 2
Output :  2  */