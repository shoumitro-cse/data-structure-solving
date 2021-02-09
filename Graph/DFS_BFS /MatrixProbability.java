// A matrix probability question

// javac -d classes MatrixProbability.java  && cd classes && java MatrixProbability && cd ..

import java.io.*; 

class MatrixProbability { 
	
	// check if (x, y) is valid matrix coordinate 
	static boolean isSafe(int x, int y, int m, int n) { 
		return (x >= 0 && x < m && y >= 0 && y < n); 
	} 

	// Function to calculate probability that after N moves from a given 
	// position (x, y) in m x n matrix, boundaries of the matrix will not be crossed. 
	static double findProbability(int m, int n, int x, int y, int N) { 
		
		// boundary crossed 
		if (!isSafe(x, y, m, n)) 
			return 0.0; 

		// N steps taken 
		if (N == 0) 
			return 1.0; 

		// Initialize result 
		double prob = 0.0; 

		// move up 
		prob += findProbability(m, n, x - 1, y, N - 1) * 0.25; 

		// move right 
		prob += findProbability(m, n, x, y + 1, N - 1) * 0.25; 

		// move down 
		prob += findProbability(m, n, x + 1, y, N - 1) * 0.25; 

		// move left 
		prob += findProbability(m, n, x, y - 1, N - 1) * 0.25; 

		return prob; 
	} 

	// Driver code 
	public static void main (String[] args) { 
		// matrix size 
		int m = 5, n = 5; 
		// coordinates of starting point 
		int i = 1, j = 1; 
		// Number of steps 
		int N = 2; 
		System.out.println("\nProbability is " + findProbability(m, n, i, j, N)); 

	} 

} 


/*
A matrix probability question


Given a rectangular matrix, we can move from current cell in 4 directions with equal probability. 
The 4 directions are right, left, top or bottom. Calculate the Probability that after N moves from 
a given position (i, j) in the matrix, we will not cross boundaries of the matrix at any point.
*/