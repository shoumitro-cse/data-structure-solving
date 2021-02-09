// Shortest path with exactly k edges in a directed and weighted graph

// javac -d classes  ShortestPathKEdge.java  && cd classes && java ShortestPathKEdge && cd ..

import java.util.*; 
import java.lang.*; 
import java.io.*; 

class ShortestPathKEdge {

	// Define number of vertices in the graph and inifinite value 
	static final int V = 4; 
	static final int INF = Integer.MAX_VALUE; 

	// A naive recursive function to count walks from u to v with k edges 
	int shortestPath(int graph[][], int u, int v, int k) {

		// Base cases 
		if (k == 0 && u == v) return 0; 
		if (k == 1 && graph[u][v] != INF) return graph[u][v]; 
		if (k <= 0) return INF; 

		// Initialize result 
		int res = INF; 

		// Go to all adjacents of u and recur 
		for (int i = 0; i < V; i++) { 
			if (graph[u][i] != INF && u != i && v != i) { 
				int rec_res = shortestPath(graph, i, v, k-1); 
				if (rec_res != INF) {
					res = Math.min(res, graph[u][i] + rec_res); 
				}
			} 
		} 
		
		return res; 
	} 

	public static void main (String[] args) {

		 // Let us create the graph shown in above diagram
		int graph[][] = new int[][] { 
			                          {0, 10, 3, 2}, 
									  {INF, 0, INF, 7}, 
									  {INF, INF, 0, 6}, 
									  {INF, INF, INF, 0} 
								   }; 
		ShortestPathKEdge t = new ShortestPathKEdge(); 
		int u = 0, v = 3, k = 2; 
	
		System.out.println("Weight of the shortest path is "+ t.shortestPath(graph, u, v, k)); 
	
	} 
} 


/*
Shortest path with exactly k edges in a directed and weighted graph


Given a directed and two vertices ‘u’ and ‘v’ in it, find shortest path from ‘u’ to ‘v’ with exactly k edges on the path.
The graph is given as adjacency matrix representation where value of graph[i][j] 
indicates the weight of an edge from vertex i to vertex j and a value INF(infinite)
 indicates no edge from i to j.

For example consider the following graph. Let source ‘u’ be vertex 0, destination ‘v’ be
 3 and k be 2. There are two walks of length 2, the walks are {0, 2, 3} and {0, 1, 3}. 
 The shortest among the two is {0, 2, 3} and weight of path is 3+6 = 9.

(show picture)*/