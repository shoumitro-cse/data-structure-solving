// Pairs of Amicable Numbers


//javac -d classes PairsOfAmicableNumbers.java  && cd classes && java PairsOfAmicableNumbers && cd ..

import java.io.*; 

class PairsOfAmicableNumbers {

	// Calculate the sum of proper divisors 
	static int sumOfDiv(int x) { 
		// 1 is a proper divisor 
		int sum = 1; 
		for (int i = 2; i <= Math.sqrt(x); i++) { 
			if (x % i == 0) { 
				sum += i; 
				// To handle perfect squares 
				if (x / i != i) {
					sum += x / i; 
				}
			} 
		} 
	  return sum; 
	} 

	// Check if pair is amicable 
	static boolean isAmicable(int a, int b) { 
		return (sumOfDiv(a) == b && sumOfDiv(b) == a); 
	} 

	// This function prints pair of amicable pairs present in the input array 
	static int countPairs(int arr[], int n) { 
		int count = 0; 
		// Iterate through each pair, and find if it an amicable pair 
		for (int i = 0; i < n; i++) 
			for (int j = i + 1; j < n; j++) 
				if (isAmicable(arr[i], arr[j])) 
					count++; 

		return count; 
	} 

	public static void main(String args[]) { 

		int arr1[] = { 220, 284, 1184, 1210, 2, 5 }; 
		int n1 = arr1.length; 

		System.out.println(countPairs(arr1, n1)); 

		int arr2[] = { 2620, 2924, 5020, 5564, 6232, 6368 }; 
		int n2 = arr2.length; 

		System.out.println(countPairs(arr2, n2)); 
		// System.out.println(Math.sqrt(16)); 
	} 
} 

/*
Pairs of Amicable Numbers

divisor of 220 = {1,2,4,5,10,11,20,22,44,55,110}
divisor of 284 = {1,2,4,71,142}

divisor of 220 sum	=	sum{1,2,4,5,10,11,20,22,44,55,110} = 284	
divisor of 284 sum  =	sum{1,2,4,71,142} =	220.

Given an array of integers, print the number of pairs in the array that form an amicable pair. Two numbers are amicable if the first is equal to the sum of divisors of the second, and if the second number is equal to the sum of divisors of the first.

Examples :

Input  : arr[] = {220, 284, 1184, 1210, 2, 5}
Output : 2
Explanation : (220, 284) and (1184, 1210) form amicable pair

Input  : arr[] = {2620, 2924, 5020, 5564, 6232, 6368}
Output : 3
Explanation : (2620, 2924), (5020, 5564) and (6232, 6368) forms amicable pair

*/

