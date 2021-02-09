// Floyd Warshall Algorithm | DP-16

// javac -d classes  FloydWarshallAlgo.java  && cd classes && java FloydWarshallAlgo && cd ..

import java.util.*;
import java.lang.*;
import java.io.*;


class FloydWarshallAlgo {

	final static int INF = 99999, V = 4;

// f Floyd Warshall Algorithm is Θ(V3)
	void floydWarshall(int graph[][]) {

		int dist[][] = new int[V][V];
		int i, j, k;

		for (i = 0; i < V; i++) {
			for (j = 0; j < V; j++) {
				dist[i][j] = graph[i][j];
			}
		}


		for (k = 0; k < V; k++) {
			// Pick all vertices as source one by one
			for (i = 0; i < V; i++) {
				// Pick all vertices as destination for the above picked source
				for (j = 0; j < V; j++) {
					// If vertex k is on the shortest path from
					// i to j, then update the value of dist[i][j]
					if (dist[i][k] + dist[k][j] < dist[i][j])
						dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}

		// Print the shortest distance matrix
		printSolution(dist);
	}

	void printSolution(int dist[][]) {
		
		System.out.println("The following matrix shows the shortest "+
						"distances between every pair of vertices");

		for (int i=0; i<V; ++i) {
			for (int j=0; j<V; ++j) {
				if (dist[i][j]==INF)
					System.out.print("INF ");
				else
					System.out.print(dist[i][j]+" ");
			}
			System.out.println();
		}
	}


	public static void main (String[] args) {

		/* Let us create the following weighted graph

		             10
		       (0)------->(3)
		        |         /|\
		      5 |          |
		        |          | 1
		       \|/         |
		       (1)------->(2)
		            3  
                               */
		int graph[][] = { 
				            {0, 5, INF, 10},
							{INF, 0, 3, INF},
							{INF, INF, 0, 1},
							{INF, INF, INF, 0}
						};

		FloydWarshallAlgo a = new FloydWarshallAlgo();

		// Print the solution
		a.floydWarshall(graph);
	}
}


/*
Floyd Warshall Algorithm | DP-16

 
The Floyd Warshall Algorithm is for solving the All Pairs Shortest Path problem. 
The problem is to find shortest distances between every pair of vertices in a given edge 
weighted directed Graph. 

Example: 

Input:
       graph[][] = { {0,   5,  INF, 10},
                    {INF,  0,  3,  INF},
                    {INF, INF, 0,   1},
                    {INF, INF, INF, 0} }
which represents the following graph
             10
       (0)------->(3)
        |         /|\
      5 |          |
        |          | 1
       \|/         |
       (1)------->(2)
            3       
Note that the value of graph[i][j] is 0 if i is equal to j 
And graph[i][j] is INF (infinite) if there is no edge from vertex i to j.

Output:
Shortest distance matrix
      0      5      8      9
    INF      0      3      4
    INF    INF      0      1
    INF    INF    INF      0


    */