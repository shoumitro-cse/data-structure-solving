// Java program to find number 
// of pairs in an array such
// that their XOR is 0
import java.util.*;

class PairXORIs0 {
	// Function to calculate the count
	static int calculate(int a[], int n){
		// Sorting the list using built in function
		Arrays.sort(a);
		int count = 1;
		int answer = 0;
		// Traversing through the elements
		for (int i = 1; i < n; i++) {
			if (a[i] == a[i - 1]){
				// Counting frequency of each elements
				count += 1;
			} else{
				// Adding the contribution of the frequency to the answer
				answer = answer + (count * (count - 1)) / 2;
				count = 1;
			}
		}
		answer = answer + (count * (count - 1)) / 2;
	  return answer;
	}
	
	public static void main (String[] args) {
		int a[] = { 1, 2, 1, 2, 4 };
		int n = a.length;
		// Print the count
		System.out.println(calculate(a, n));
	}
}

/*
Find number of pairs in an array such that their XOR is 0


Given an array A[ ]  of size N. Find the number of pairs (i, j) such that A_i  XOR A_j  = 0, and 1 <= i < j <= N.
Examples : 
 

Input : A[] = {1, 3, 4, 1, 4}
Output : 2
Explanation : Index (0, 3) and (2, 4)

Input : A[] = {2, 2, 2}
Output : 3
*/