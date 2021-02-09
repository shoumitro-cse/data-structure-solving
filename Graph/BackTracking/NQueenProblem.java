// N Queen Problem | Backtracking-3

//javac -d classes  NQueenProblem.java  && cd classes && java NQueenProblem && cd ..

import java.util.*; 

class NQueenProblem {

	static int N = 4; 

	/* ld is an array where its indices indicate row-col+N-1 
	(N-1) is for shifting the difference to store negative indices */
	static int []ld = new int[30]; 

	/* rd is an array where its indices indicate row+col 
	and used to check whether a queen can be placed on right diagonal or not*/
	static int []rd = new int[30]; 

	/*column array where its indices indicates column and 
	used to check whether a queen can be placed in that row or not*/
	static int []cl = new int[30]; 

	 // A utility function to print solution 
	static void printSolution(int board[][]) { 
		for (int i = 0; i < N; i++) { 
			for (int j = 0; j < N; j++) 
				System.out.printf(" %d ", board[i][j]); 
			System.out.printf("\n"); 
		} 
	} 

	 // A recursive utility function to solve N Queen problem 
	static boolean solveNQUtil(int board[][], int col) { 

		 // base case: If all queens are placed then return true 
		if (col >= N) 
			return true; 

		 // Consider this column and try placing this queen in all rows one by one 
		for (int i = 0; i < N; i++) { 			
			/*Check if the queen can be placed on board[i][col] 

			 A check if a queen can be placed on board[row][col].We just need to check 
			ld[row-col+n-1] and rd[row+coln] where ld and rd are for left and right 
			diagonal respectively*/
			if ((ld[i - col + N - 1] != 1 && rd[i + col] != 1) && cl[i] != 1) { 
				 // Place this queen in board[i][col] 
				board[i][col] = ld[i - col + N - 1] = rd[i + col] = cl[i] = 1; 
				 // recur to place rest of the queens 
				if (solveNQUtil(board, col + 1)) {
					return true; 
				}
				 // If placing queen in board[i][col] doesn't lead to a solution, then 
				// remove queen from board[i][col] 
				board[i][col] = ld[i - col + N - 1] = rd[i + col] = cl[i] = 0; // BACKTRACK
			} 
		} 

		 // If the queen cannot be placed in any row in this colum col then return false 
		return false; 
	} 

	static boolean solveNQ() {

		int board[][] = {
			              { 0, 0, 0, 0 }, 
						  { 0, 0, 0, 0 }, 
						  { 0, 0, 0, 0 }, 
						  { 0, 0, 0, 0 }
						}; 

		if (solveNQUtil(board, 0) == false) { 
			System.out.printf("Solution does not exist"); 
			return false; 
		} 

		printSolution(board); 
		return true; 
	} 

	public static void main(String[] args) { 
	  solveNQ(); 
	} 
} 

/*N Queen Problem | Backtracking-3


We have discussed Knight’s tour and Rat in a Maze problems in Set 1 and Set 2 respectively. 
Let us discuss N Queen as another example problem that can be solved using Backtracking.
The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens 
attack each other. For example, following is a solution for 4 Queen problem.



The expected output is a binary matrix which has 1s for the blocks where queens are placed. 
For example, following is the output matrix for above 4 queen solution.

              { 0,  1,  0,  0}
              { 0,  0,  0,  1}
              { 1,  0,  0,  0}
              { 0,  0,  1,  0}
*/