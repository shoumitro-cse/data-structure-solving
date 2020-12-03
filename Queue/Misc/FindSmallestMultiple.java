// Java program to find smallest multiple of a given number made of digits 0 and 9 only 

//javac -d classes FindSmallestMultiple.java  && cd classes && java FindSmallestMultiple && cd ..

import java.util.*; 

class FindSmallestMultiple { 
	// Maximum number of numbers made of 0 and 9 
	static int MAX_COUNT = 10000; 
	static List<String> vec = new LinkedList<String>(); 

	static void generateNumbersUtil() { 
		Queue<String> q = new LinkedList<String>(); 
		q.add("9"); 
		for (int count = MAX_COUNT; count > 0; count--) { 
			String s1 = q.remove(); 
			vec.add(s1); 
			String s2 = s1; 
			q.add(s1 + "0"); 
			q.add(s2 + "9"); 
		} 
	} 
 
   // Time Complexity: O(n)
	static String findSmallestMultiple(int n) { 
		for (int i = 0; i < vec.size(); i++) { 
			if (Integer.parseInt(vec.get(i)) % n == 0) { 
				return vec.get(i); 
			} 
		} 
		return ""; 
	} 

	public static void main(String[] args) { 
		generateNumbersUtil(); 
		// System.out.println(vec); 
		int n = 7; 
		System.out.println(findSmallestMultiple(n)); 
	} 
} 


/*
Smallest multiple of a given number made of digits 0 and 9 only

We are given an integer N. We need to write a program to find the least positive integer X made 
up of only digits 9’s and 0’s, such that, X is a multiple of N.

Note: It is assumed that the value of X will not exceed 10^6.

Examples:

Input : N = 5
Output : X = 90
Exaplanation: 90 is the smallest number made up 
of 9's and 0's which is divisible by 5.

Input : N = 7
Output : X = 9009
Exaplanation: 9009 is smallest number made up 
of 9's and 0's which is divisible by 7.*/