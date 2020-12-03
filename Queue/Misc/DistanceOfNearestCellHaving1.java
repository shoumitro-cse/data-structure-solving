// Java program to find distance of nearest cell having 1 in a binary matrix. 

//javac -d classes DistanceOfNearestCellHaving1.java  && cd classes && java DistanceOfNearestCellHaving1 && cd ..

import java.io.*; 
import java.util.*; 

class DistanceOfNearestCellHaving1 { 
	
	static int N = 3; //row
	static int M = 4; //column
	

/*	Complexity Analysis:
		1. Time Complexity: O(N^2*M^2).
		   For every element in the matrix, the matrix is traversed and there are N*M elements
		   So the time complexity is O(N^2*M^2).
		2. Space Complexity: O(1).
		   No extra space is required.*/
	// Print the distance of nearest cell having 1 for each cell. 
	static void printDistance(int mat[][]) { 

		int ans[][] = new int[N][M]; 
		
		// Initialize the answer matrix with INT_MAX. 
		for (int i = 0; i < N; i++) { //row
			for (int j = 0; j < M; j++) { //column 
				ans[i][j] = Integer.MAX_VALUE;
			} 
		}
	
		// For each cell 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) { 
				// Traversing the whole matrix to find the minimum distance. 
				for (int k = 0; k < N; k++) {
					for (int l = 0; l < M; l++) { 
						// If cell contain 1, check for minimum distance. 
						if (mat[k][l] == 1) {
							ans[i][j] = Math.min(ans[i][j], Math.abs(i-k) + Math.abs(j-l)); 
						}
					} 
				}
			} 
		}
	
		// Printing the answer. 
		for (int i = 0; i < N; i++) { 
			for (int j = 0; j < M; j++) {
				System.out.print( ans[i][j] + " "); 
			}
		   System.out.println(); 
		} 
		// System.out.println(Arrays.toString(ans)); 
	} 
	

	public static void main (String[] args) {

		int mat[][] = { 
		                {0, 0, 0, 1}, 
						{0, 0, 1, 1}, 
						{0, 1, 1, 0} 
					  }; 
	
		printDistance(mat); 
	} 
} 



/*
Distance of nearest cell having 1 in a binary matrix

Complexity Analysis:
Time Complexity: O(N2*M2).
For every element in the matrix, the matrix is traversed and there are N*M elements So the time complexity is O(N2*M2).
Space Complexity: O(1).
No extra space is required.

Given a binary matrix of N x M, containing at least a value 1. 
The task is to find the distance of nearest 1 in the matrix for each cell. 
The distance is calculated as |i1 – i2| + |j1 – j2|, where i1, j1 are the row number and 
column number of the current cell and i2, j2 are the row number and column number of 
the nearest cell having value 1.

Examples:

Input : N = 3, M = 4
        mat[][] = { 0, 0, 0, 1,
                    0, 0, 1, 1,
                    0, 1, 1, 0 }
Output : 3 2 1 0
         2 1 0 0
         1 0 0 1
Explanation:
For cell at (0, 0), nearest 1 is at (0, 3),
so distance = (0 - 0) + (3 - 0) = 3.
Similarly, all the distance can be calculated.

Input : N = 3, M = 3
        mat[][] = { 1, 0, 0, 
		            0, 0, 1, 
		            0, 1, 1 }
Output :
       0 1 1 
       1 1 0 
       1 0 0 

Explanation:
For cell at (0, 1), nearest 1 is at (0, 0), so distance
is 1. Similarly, all the distance can be calculated.


Method 1: This method uses a simple brute force approach to arrive at the solution.

Approach: The idea is to traverse the matrix for each cell and find the minimum distance, 
To find the minimum distance traverse the matrix and find the cell which contains 1 and 
calculates the distance between two cells and store the minimum distance.

Algorithm :
1. Traverse the matrix from start to end (using two nested loops)
2. For every element find the closest element which contains 1. 
   To find the closest element traverse the matrix and find the minimum distance.
3. Fill the minimum distance in the matrix.

*/