// Ford-Fulkerson Algorithm for Maximum Flow Problem

// javac -d classes  FordFulkersonAlgo.java  && cd classes && java FordFulkersonAlgo && cd ..

import java.util.*; 
import java.lang.*; 
import java.io.*; 
import java.util.LinkedList; 

class FordFulkersonAlgo {

	static final int V = 6; //Number of vertices in graph 


	boolean bfs(int rGraph[][], int s, int t, int parent[]) {

		// Create a visited array and mark all vertices as not visited 
		boolean visited[] = new boolean[V]; 
		for(int i=0; i<V; ++i) {
			visited[i]=false; 
		}

		// Create a queue, enqueue source vertex and mark source vertex as visited 
		LinkedList<Integer> queue = new LinkedList<Integer>(); 
		queue.add(s); 

		visited[s] = true; 
		parent[s] = -1; 

		// Standard BFS Loop 
		while (queue.size()!=0) {

			int u = queue.poll(); 

			for (int v=0; v<V; v++) { 
				if (visited[v]==false && rGraph[u][v] > 0) { 
					queue.add(v); 
					parent[v] = u; 
					visited[v] = true; 
				} 
			} 
		} 

		// If we reached sink in BFS starting from source, then return true, else false 
		return (visited[t] == true); 
	} 

	// Returns tne maximum flow from s to t in the given graph 
	int fordFulkerson(int graph[][], int s, int t) { 

		int u, v; 

		int rGraph[][] = new int[V][V]; 

		for (u = 0; u < V; u++) {
			for (v = 0; v < V; v++) {
				rGraph[u][v] = graph[u][v]; 
			}
		}

		// This array is filled by BFS and to store path 
		int parent[] = new int[V]; 

		int max_flow = 0; // There is no flow initially 

		// Augment the flow while tere is path from source 
		// to sink 
		while (bfs(rGraph, s, t, parent)) { 

			int path_flow = Integer.MAX_VALUE; 
			for (v = t; v != s; v = parent[v]) { 
				u = parent[v]; 
				path_flow = Math.min(path_flow, rGraph[u][v]); 
			} 

			// update residual capacities of the edges and reverse edges along the path 
			for (v=t; v != s; v=parent[v]) { 
				u = parent[v]; 
				rGraph[u][v] -= path_flow; 
				rGraph[v][u] += path_flow; 
			} 

			// Add path flow to overall flow 
			max_flow += path_flow; 
		} 

		// Return the overall flow 
		return max_flow; 
	} 


	public static void main (String[] args) throws java.lang.Exception {

		// Let us create a graph shown in the above example 
		int graph[][] =new int[][] { 
			                         {0, 16, 13, 0, 0, 0}, 
									 {0, 0, 10, 12, 0, 0}, 
									 {0,  4, 0,  0, 14,0}, 
									 {0,  0, 9,  0,  0, 20}, 
									 {0,  0, 0,  7,  0, 4}, 
									 {0,  0, 0,  0,  0, 0} 
								  }; 

		FordFulkersonAlgo m = new FordFulkersonAlgo(); 

		System.out.println("The maximum possible flow is: " + m.fordFulkerson(graph, 0, 5)); 

	} 
} 



/*
Ford-Fulkerson Algorithm for Maximum Flow Problem


Given a graph which represents a flow network where every edge has a capacity. 
Also given two vertices source ‘s’ and sink ‘t’ in the graph, find the maximum possible 
flow from s to t with following constraints:
a) Flow on an edge doesn’t exceed the given capacity of the edge.

b) Incoming flow is equal to outgoing flow for every vertex except s and t.


For example, consider the following graph from CLRS book.
(pic-> FordFulkersonAlgo.png)

The maximum possible flow in the above graph is 23.
(pic-> FordFulkersonAlgo2.png)

*/