// Check for star graph


import java.io.*; 

class CheckStarGraph {

	// define the size of incidence matrix 
	static int size = 4; 

	// function to find star graph 
	static boolean checkStar(int mat[][]) { 

		// initialize number of vertex with deg 1 and n-1 
		int vertexD1 = 0, vertexDn_1 = 0; 
		
		// check for S1 
		if (size == 1) 
			return (mat[0][0] == 0); 
		
		// check for S2 
		if (size == 2) 
		return (mat[0][0] == 0 && mat[0][1] == 1 && 
				mat[1][0] == 1 && mat[1][1] == 0); 
	
		// check for Sn (n>2) 
		for (int i = 0; i < size; i++) { 

			int degreeI = 0; 
			for (int j = 0; j < size; j++) 
				if (mat[i][j] == 1) 
					degreeI++; 
	
			if (degreeI == 1) 
				vertexD1++; 
			else if (degreeI == size - 1) 
				vertexDn_1++; 
		} 
		
		return (vertexD1 == (size - 1) && vertexDn_1 == 1); 
	} 
	

	public static void main(String args[]) {

		int mat[][] = {
					        {0, 1, 1, 1}, 
							{1, 0, 0, 0}, 
							{1, 0, 0, 0}, 
							{1, 0, 0, 0}
					  }; 
	
		if (checkStar(mat)) 
			System.out.print("Star Graph"); 
		else
			System.out.print("Not a Star Graph"); 
	} 
} 


/*
Check for star graph


You are given an n * n matrix which represent a graph with n-vertices, check whether 
the input matrix represent a star graph or not.

Example:

Input : Mat[][] = {{0, 1, 0},
                   {1, 0, 1},
                   {0, 1, 0}}
Output : Star graph

Input : Mat[][] = {{0, 1, 0},
                   {1, 1, 1},
                   {0, 1, 0}}
Output : Not a Star graph*/