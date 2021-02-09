// transitive closure using Floyd Warshall Algorithm
//Transitive closure of a graph

// javac -d classes  TransitiveClosure.java  && cd classes && java TransitiveClosure && cd ..

import java.util.*;
import java.lang.*;
import java.io.*;

class TransitiveClosure {

	final static int V = 4; //Number of vertices in a graph

	// Prints transitive closure of graph[][] using Floyd Warshall algorithm
	void printTransitiveClosure(int graph[][]) {

		int reach[][] = new int[V][V];
		int i, j, k;

		for (i = 0; i < V; i++)
			for (j = 0; j < V; j++)
				reach[i][j] = graph[i][j];

		for (k = 0; k < V; k++) {
			// Pick all vertices as source one by one
			for (i = 0; i < V; i++) {
				// Pick all vertices as destination for the above picked source
				for (j = 0; j < V; j++) {
					// If vertex k is on a path from i to j,
					// then make sure that the value of reach[i][j] is 1
					reach[i][j] = (reach[i][j]!=0) || ((reach[i][k]!=0) && (reach[k][j]!=0))?1:0;
				}
			}
		}

		// Print the shortest distance matrix
		printSolution(reach);
	}

	 // A utility function to print solution 
	void printSolution(int reach[][]) {
		
		System.out.println("Following matrix is transitive closure of the given graph");
		
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if ( i == j)
				  System.out.print("1 ");
				else
				  System.out.print(reach[i][j]+" ");
			}

			System.out.println();
		}
	}

	public static void main (String[] args) {
 
        /* Let us create the following weighted graph
              
         (0)------->(3)
          |         /|\
          |          |
          |          | 
         \|/         |
         (1)------->(2)
                          */

		int graph[][] = new int[][]{ 
			                         {1, 1, 0, 1},
									 {0, 1, 1, 0},
									 {0, 0, 1, 1},
									 {0, 0, 0, 1}
								  };

		// Print the solution
		TransitiveClosure g = new TransitiveClosure();
		g.printTransitiveClosure(graph);

		/*Output:
				1 1 1 1 
				0 1 1 1 
				0 0 1 1 
				0 0 0 1 */

	}
}

/*Time Complexity: O(V3) where V is number of vertices in the given graph.
See below post for a O(V2) solution. */


/*
Transitive closure of a graph


Given a directed graph, find out if a vertex j is reachable from another vertex i for all 
vertex pairs (i, j) in the given graph. Here reachable mean that there is a path from vertex 
i to j. The reach-ability matrix is called the transitive closure of a graph.

For example, consider below graph
(pic)

Transitive closure of above graphs is 
     1 1 1 1 
     1 1 1 1 
     1 1 1 1 
     0 0 0 1*/