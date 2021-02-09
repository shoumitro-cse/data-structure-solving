// The Knight’s tour problem | Backtracking-1


// javac -d classes  KnightTour.java  && cd classes && java KnightTour && cd ..

class KnightTour {

	static int N = 8;

	 // A utility function to check if i,j are valid indexes for N*N chessboard 
	static boolean isSafe(int x, int y, int sol[][]) {
		return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
	}

	 // A utility function to print solution matrix sol[N][N] 
	static void printSolution(int sol[][]) {
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				System.out.print(sol[x][y] + " ");
			}
			System.out.println();
		}
	}

	static boolean solveKT() {

		int sol[][] = new int[8][8];

		 // Initialization of solution matrix 
		for (int x = 0; x < N; x++) {
		   for (int y = 0; y < N; y++) {
			  sol[x][y] = -1;
		   }
		}

		// xMove[] and yMove[] define next move of Knight.
		// xMove[] is for next value of x coordinate
		// yMove[] is for next value of y coordinate 
		int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

		// Since the Knight is initially at the first block
		sol[0][0] = 0;

		 // Start from 0,0 and explore all tours using solveKTUtil() 
		if (!solveKTUtil(0, 0, 1, sol, xMove, yMove)) {
			System.out.println("Solution does not exist");
			return false;
		} else {
			printSolution(sol);
		}

		return true;
	}

	 // A recursive utility function to solve Knight Tour problem 
	static boolean solveKTUtil(int x, int y, int movei, int sol[][], int xMove[], int yMove[]) {

		int k, next_x, next_y;
		
		if (movei == N * N)
			return true;

		 // Try all next moves from the current coordinate x, y 
		for (k = 0; k < 8; k++) {
			
			next_x = x + xMove[k];
			next_y = y + yMove[k];
			
			if (isSafe(next_x, next_y, sol)) {

				sol[next_x][next_y] = movei;
				if (solveKTUtil(next_x, next_y, movei + 1, sol, xMove, yMove))
					return true;
				else
					sol[next_x][next_y] = -1; // backtracking
			}
		}

		return false;
	}

	public static void main(String args[]) {
		// Function Call
		solveKT();
	}
}

/*
Time Complexity : 
There are N2 Cells and for each, we have a maximum of 8 possible moves to choose from, 
so the worst running time is O(8N^2).
*/


/*
The Knight’s tour problem | Backtracking-1

Backtracking is an algorithmic paradigm that tries different solutions until finds a solution that “works”. Problems which are typically solved using backtracking technique have the following property in common. These problems can only be solved by trying every possible configuration and each configuration is tried only once. A Naive solution for these problems is to try all configurations and output a configuration that follows given problem constraints. Backtracking works in an incremental way and is an optimization over the Naive solution where all possible configurations are generated and tried.
For example, consider the following Knight’s Tour problem. 

Problem Statement:
Given a N*N board with the Knight placed on the first block of an empty board. Moving according to the rules of chess knight must visit each square exactly once. Print the order of each the cell in which they are visited.

Example:

Input : 
N = 8
Output:
0  59  38  33  30  17   8  63
37  34  31  60   9  62  29  16
58   1  36  39  32  27  18   7
35  48  41  26  61  10  15  28
42  57   2  49  40  23   6  19
47  50  45  54  25  20  11  14
56  43  52   3  22  13  24   5
51  46  55  44  53   4  21  12
*/