// Construct a graph from given degrees of all vertices

// javac -d classes ConstructGraphFromGivenGegrees.java  && cd classes && java ConstructGraphFromGivenGegrees && cd ..

import java.util.*; 

class ConstructGraphFromGivenGegrees  
{ 

	// A function to print the adjacency matrix. 
	// Time Complexity: O(v*v).
	static void printMat(int degseq[], int n) 
	{ 
		// n is number of vertices 
		int [][] mat = new int[n][n]; 

		for (int i = 0; i < n; i++) { 
			for (int j = i + 1; j < n; j++) { 
				// For each pair of vertex decrement the degree of both vertex. 
				if (degseq[i] > 0 && degseq[j] > 0) { 
					degseq[i]--; 
					degseq[j]--; 
					mat[i][j] = 1; 
					mat[j][i] = 1; 
				} 
			} 
		} 

		// Print the result in specified format 
		System.out.print("\n" + setw(3) + "	 "); 
		
		for (int i = 0; i < n; i++) 
			System.out.print(setw(3) + "(" + i + ")"); 
		System.out.print("\n\n"); 

		for (int i = 0; i < n; i++) { 
			System.out.print(setw(4) + "(" + i + ")"); 
			
			for (int j = 0; j < n; j++) 
				System.out.print(setw(5) + mat[i][j]); 
			System.out.print("\n"); 
		} 
	} 

	static String setw(int n) 
	{ 
		String space = ""; 
		while(n-- > 0) 
			space += " "; 
		return space; 
	} 

	// Driver Code 
	public static void main(String[] args) 
	{ 
		int degseq[] = { 2, 2, 1, 1, 1 }; 
		int n = degseq.length; 
		printMat(degseq, n); 
	} 
} 


/*
Construct a graph from given degrees of all vertices


This is a C++ program to generate a graph for a given fixed degree sequence.This algorithm generates a undirected graph for the given degree sequence.It does not include self-edge and multiple edges.

Examples:

Input : degrees[] = {2, 2, 1, 1}
Output :  (0)  (1)  (2)  (3)
    (0)    0    1    1    0                              
    (1)    1    0    0    1                   
    (2)    1    0    0    0                       
    (3)    0    1    0    0     
Explanation : We are given that there
are four vertices with degree of vertex
0 as 2, degree of vertex 1 as 2, degree
of vertex 2 as 1 and degree of vertex 3
as 1. Following is graph that follows
given conditions.                   
    (0)----------(1)
     |            | 
     |            | 
     |            |
    (2)          (3) */