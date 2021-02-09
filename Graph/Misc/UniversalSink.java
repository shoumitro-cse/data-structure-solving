// Determine whether a universal sink exists in a directed Graph

 // javac -d classes UniversalSink.java  && cd classes && java UniversalSink && cd ..

import java.io.*; 
import java.util.*; 

class Graph 
{ 
	int vertices; 
	int[][] adjacency_matrix; 

	// constructor to initialize number of vertices and 
	// size of adjacency matrix 
	public Graph(int vertices) { 
		this.vertices = vertices; 
		adjacency_matrix = new int[vertices][vertices]; 
	} 

	public void insert(int source, int destination) { 
		// make adjacency_matrix[i][j] = 1 if there is an edge from i to j 
		adjacency_matrix[source-1][destination-1] = 1; 
	} 

	public boolean issink(int i) { 

		for (int j = 0 ; j < vertices ; j++) { 
			if (adjacency_matrix[i][j] == 1) 
				return false; 
			if (adjacency_matrix[j][i] == 0 && j != i) 
				return false; 
		} 
		//if none of the checks fails, return true 
		return true; 
	} 


	public int eliminate() { 

		int i = 0, j = 0; 
		while (i < vertices && j < vertices) { 

			if (adjacency_matrix[i][j] == 1) 
				i++; 
			else
				j++; 
		} 

		if (i > vertices) 
			return -1; 
		else if (!issink(i)) 
			return -1; 
		else 
			return i; 
	} 
} 

public class UniversalSink { 

	public static void main(String[] args)throws IOException { 

		int number_of_vertices = 6; 
		int number_of_edges = 5; 

		Graph g = new Graph(number_of_vertices); 
		

		//input set 1 
		g.insert(1, 6); 
		g.insert(2, 6); 
		g.insert(3, 6); 
		g.insert(4, 6); 
		g.insert(5, 6); 
		


/*		//input set 2 
		g.insert(1, 6); 
		g.insert(2, 3); 
		g.insert(2, 4); 
		g.insert(4, 3); 
		g.insert(5, 3); */

		int vertex = g.eliminate(); 

		// returns 0 based indexing of vertex. returns -1 if no sink exits. 
		// returns the vertex number-1 if sink is found 
		if (vertex >= 0) 
			System.out.println("Sink found at vertex "+ (vertex + 1)); 
		else
			System.out.println("No Sink"); 
	} 
} 


/*
Determine whether a universal sink exists in a directed graph


Determine whether a universal sink exists in a directed graph. A universal sink is a vertex which has no edge emanating from it, and all other vertices have an edge towards the sink.

Input : 
v1 -> v2 (implies vertex 1 is connected to vertex 2)
v3 -> v2
v4 -> v2
v5 -> v2
v6 -> v2                        
Output :
Sink found at vertex 2

Input : 
v1 -> v6
v2 -> v3
v2 -> v4
v4 -> v3
v5 -> v3
Output :
No Sink
*/