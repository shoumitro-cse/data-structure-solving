// find the k-th missing element in a given sequence 

//javac -d classes FindKthMissingEle.java  && cd classes && java FindKthMissingEle && cd ..
import java.util.*; 

class FindKthMissingEle { 

	// Returns k-th missing element. It returns -1 if no k is more than number of missing elements. 
	static int find(int a[], int b[], int k, int n1, int n2) { 

		// Insert all elements of givens sequence b[]. 
		LinkedHashSet<Integer> s = new LinkedHashSet<>(); 
		for (int i = 0; i < n2; i++) { 
			s.add(b[i]); 
		}

		// Traverse through increasing sequence and keep track of count of missing numbers. 
		int missing = 0; 
		for (int i = 0; i < n1; i++) { 
			if(!s.contains(a[i]) ) 
				missing++; 
			if (missing == k) 
				return a[i]; 
		} 

		return -1; 
	} 

	public static void main(String[] args) { 

		int a[] = { 0, 2, 4, 6, 8, 10, 12, 14, 15 }; 
		int b[] = { 4, 10, 6, 8, 12 }; 
		int n1 = a.length; 
		int n2 = b.length; 

		int k = 3; 
		System.out.println(find(a, b, k, n1, n2)); 
	} 
} 



/*
k-th missing element in increasing sequence which is not present in a given sequence

Given two sequences, one is increasing sequence a[] and another a normal sequence b[], 
find the K-th missing element in the increasing sequence which is not present in the 
given sequence. If no k-th missing element is there output -1

Examples:

Input:  a[] = {0, 2, 4, 6, 8, 10, 12, 14, 15};
        b[] = {4, 10, 6, 8, 12};
          k = 3
Output: 14
Explanation : The numbers from increasing sequence that
are not present in the given sequence are 0, 2, 14, 15.
The 3rd missing number is 14.
*/
