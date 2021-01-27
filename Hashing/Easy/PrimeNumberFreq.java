// Java code to find number occurring prime number of times with frequency >= k 

//javac -d classes PrimeNumberFreq.java  && cd classes && java PrimeNumberFreq && cd ..

import java.util.*; 

public class PrimeNumberFreq { 

	// Function to find number with prime occurrences 
	static void primeOccurences(int[] arr, int k) {

		Map<Integer, Integer> map = new HashMap<>(); 

		// Insert values and their frequencies 
		for (int i = 0; i < arr.length; i++) { 
			int val = arr[i]; 

			int freq; 
			if (map.containsKey(val)) { 
			  freq = map.get(val); 
			  freq++; 
			} else {
			  freq = 1; 
			}

			map.put(val, freq); 
		} 

		// Traverse map and find elements with prime frequencies and frequency at least k 
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) { 
			int value = entry.getValue(); 
			if (isPrime(value) && value >= k) {
				System.out.println(entry.getKey()); 
			}
		} 
	} 

	// Check if the number of occurrences are primes or not 
	private static boolean isPrime(int n) { 

		if ((n > 2 && n % 2 == 0) || n == 1) {
		  return false;		 
		}

		for (int i = 3; i <= (int)Math.sqrt(n); i += 2) { 
		  if (n % i == 0) {
			return false;			 
		  }
		} 

		return true; 
	} 

	public static void main(String[] args) {

		int[] arr = { 11, 11, 11, 23, 11, 37, 37, 51, 51, 51, 51, 51 }; 
		int k = 2; 

		primeOccurences(arr, k); 
	} 
} 



/*Numbers with prime frequencies greater than or equal to k

Given an array, find elements which appears prime number of times in the array with 
minimum k frequency (frequency >= k).

Examples :

Input : int[] arr = { 11, 11, 11, 23, 11, 37, 51, 
                      37, 37, 51, 51, 51, 51 };
        k = 2
Output : 37, 51
Explanation :
11's count is 4, 23 count 1, 37 count 3, 51 count 5. 
37 and 51 are two number that appear prime number of
time and frequencies greater than or equal to k.

Input : int[] arr = { 11, 22, 33 } min Occurrence = 1
Output : -1
None of the count is prime number of times
*/