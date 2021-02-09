// Number of Triangles in Directed and Undirected Graphs

// javac -d classes NumberOfTriangles2.java  && cd classes && java NumberOfTriangles2 && cd ..


import java.io.*;

class NumberOfTriangles2 {

	// Number of vertices in the graph
	int V = 4;


	int countTriangle(int graph[][], boolean isDirected) {
		// Initialize result
		int count_Triangle = 0;
		// Consider every possible triplet of edges in graph
		for (int i = 0; i < V; i++)
		{
			for (int j = 0; j < V; j++)
			{
				for (int k=0; k<V; k++)
				{
					// Check the triplet if it
					// satisfies the condition
					if (graph[i][j] == 1 && graph[j][k] == 1 && graph[k][i] == 1)
						count_Triangle++;
				}
			}
		}

		// If graph is directed , division is done by 3 else division by 6 is done
		if(isDirected == true) {
			count_Triangle /= 3;
		} else {
			count_Triangle /= 6;
		}

		return count_Triangle;
	}


	public static void main(String args[]) {
			
		// Create adjacency matrix of an undirected graph
		int graph[][] = {   
			                {0, 1, 1, 0},
							{1, 0, 1, 1},
							{1, 1, 0, 1},
							{0, 1, 1, 0}
						};
		

		// Create adjacency matrix of a directed graph
		int digraph[][] = { 
			                {0, 0, 1, 0},
							{1, 0, 0, 1},
							{0, 1, 0, 0},
							{0, 0, 1, 0}
						  };
		
		NumberOfTriangles2 obj = new NumberOfTriangles2();

		System.out.println("The Number of triangles "+
				"in undirected graph : " +obj.countTriangle(graph, false));

		System.out.println("\n\nThe Number of triangles"+
						" in directed graph : "+ obj.countTriangle(digraph, true));

	}
}


/*
Number of Triangles in Directed and Undirected Graphs

Given a Graph, count number of triangles in it. The graph is can be directed or undirected.

Example: (pic)

Input: digraph[V][V] = { {0, 0, 1, 0},
                        {1, 0, 0, 1},
                        {0, 1, 0, 0},
                        {0, 0, 1, 0}
                      };
Output: 2
Give adjacency matrix represents following 
directed graph*/