// Magical Indices in an array

// javac -d classes MagicalIndiceArray.java  && cd classes && java MagicalIndiceArray && cd ..

import java.io.*; 
import java.util.*; 

public class MagicalIndiceArray { 

	// Function to count number of magical indices. 
	static int solve(int [] A, int n) {
		int i, cnt = 0, j; 	
		// Array to store parent node of traversal. 
		int [] parent = new int[n + 1]; 
		// Array to determine whether current node is already counted in the cycle. 
		int [] vis = new int[n + 1]; 
		// Initialize the arrays. 
		for (i = 0; i < n+1; i++) { 
		  parent[i] = -1; 
		  vis[i] = 0; 
		} 
			
		
		for (i = 0; i < n; i++) { 

			j = i; 
			
			if (parent[j] == -1) { 
				
				while (parent[j] == -1) { 
					parent[j] = i; 
					j = (j + A[j] + 1) % n; 
				} 

				// Check parent value to ensure a cycle is present. 
				if (parent[j] == i) { 
					
					// Count number of nodes in the cycle. 
					while (vis[j] == 0) { 
					  vis[j] = 1; 
					  cnt++; 
					  j = (j + A[j] + 1) % n; 
					} 

				}

			} 
		} 
		
		return cnt; 
	} 
	
	public static void main(String args[]) { 
		int [] A = { 0, 0, 0, 2 }; 
		int n = A.length; 
		System.out.println(solve(A, n)); 
	} 
} 


/*
Magical Indices in an array


Given an array A of integers. Index i of A is said to be connected to index j 
if j = (i + A[i]) % n + 1 (Assume 1-based indexing). Start traversing array from index i and 
jump to its next connected index. If on traversing array in the described order, index i is 
again visited then index i is a magical index. Count the number of magical indexes in the array. 
Assume that array A consists of non-negative integers.

Examples :

Input : A = {1, 1, 1, 1}
Output : 4
Possible traversals:
1 -> 3 -> 1
2 -> 4 -> 2
3 -> 1 -> 3
4 -> 2 -> 4
Clearly all the indices are magical

Input : A = {0, 0, 0, 2}
Output : 2
Possible traversals:
1 -> 2 -> 3 -> 4 -> 3...
2 -> 3 -> 4 -> 3...
3 -> 4 -> 3
4 -> 3 ->4
Magical indices = 3, 4

*/