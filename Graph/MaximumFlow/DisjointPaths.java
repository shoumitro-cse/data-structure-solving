// Find maximum number of edge disjoint paths between two vertices

// javac -d classes  DisjointPaths.java  && cd classes && java DisjointPaths && cd ..

import java.util.*; 

class DisjointPaths { 

	// Number of vertices in given graph 
	static int V = 8; 

	/* Returns true if there is a path from 
	source 's' to sink 't' in residual graph. 
	Also fills parent[] to store the path */
	static boolean bfs(int rGraph[][], int s, int t, int parent[]) {

		// Create a visited array and 
		// mark all vertices as not visited 
		boolean []visited = new boolean[V]; 


		// Create a queue, enqueue source vertex and 
		// mark source vertex as visited 
		Queue <Integer> q = new LinkedList<>(); 
		q.add(s); 
		visited[s] = true; 
		parent[s] = -1; 

		// Standard BFS Loop 
		while (!q.isEmpty()) 
		{ 
			int u = q.peek(); 
			q.remove(); 

			for (int v = 0; v < V; v++) 
			{ 
				if (visited[v] == false && 
					rGraph[u][v] > 0) 
				{ 
					q.add(v); 
					parent[v] = u; 
					visited[v] = true; 
				} 
			} 
		} 

		// If we reached sink in BFS 
		// starting from source, then 
		// return true, else false 
		return (visited[t] == true); 
	} 

	// Returns tne maximum number of edge-disjoint 
	// paths from s to t. This function is copy of 
	// forFulkerson() discussed at http://goo.gl/wtQ4Ks 
	static int findDisjointPaths(int graph[][], int s, int t) { 

		int u, v; 

		int [][]rGraph = new int[V][V]; 
		for (u = 0; u < V; u++) 
			for (v = 0; v < V; v++) 
				rGraph[u][v] = graph[u][v]; 
		
		// This array is filled by BFS and to store path 
		int []parent = new int[V]; 

		int max_flow = 0; // There is no flow initially 

		// Augment the flow while there is path 
		// from source to sink 
		while (bfs(rGraph, s, t, parent)) 
		{ 

			int path_flow = Integer.MAX_VALUE; 

			for (v = t; v != s; v = parent[v]) 
			{ 
				u = parent[v]; 
				path_flow = Math.min(path_flow, rGraph[u][v]); 
			} 

			// update residual capacities of the edges and reverse edges along the path 
			for (v = t; v != s; v = parent[v]) { 
				u = parent[v]; 
				rGraph[u][v] -= path_flow; 
				rGraph[v][u] += path_flow; 
			} 

			// Add path flow to overall flow 
			max_flow += path_flow; 
		} 

		// Return the overall flow (max_flow is equal to 
		// maximum number of edge-disjoint paths) 
		return max_flow; 
	} 


	public static void main(String[] args) {

		// Let us create a graph shown in the above example 
		int graph[][] = {
			              {0, 1, 1, 1, 0, 0, 0, 0}, 
						  {0, 0, 1, 0, 0, 0, 0, 0}, 
						  {0, 0, 0, 1, 0, 0, 1, 0}, 
						  {0, 0, 0, 0, 0, 0, 1, 0}, 
						  {0, 0, 1, 0, 0, 0, 0, 1}, 
						  {0, 1, 0, 0, 0, 0, 0, 1}, 
						  {0, 0, 0, 0, 0, 1, 0, 1}, 
						  {0, 0, 0, 0, 0, 0, 0, 0}
						}; 

		int s = 0; 
		int t = 7; 
		System.out.println("There can be maximum " + findDisjointPaths(graph, s, t) + 
					" edge-disjoint paths from " + s + " to "+ t); 
	} 
} 


/*
Find maximum number of edge disjoint paths between two vertices

Given a directed graph and two vertices in it, source ‘s’ and destination ‘t’, find out the maximum number of edge disjoint paths from s to t. Two paths are said edge disjoint if they don’t share any edge.

pic

There can be maximum two edge disjoint paths from source 0 to destination 7 in the above graph. Two edge disjoint paths are highlighted below in red and blue colors are 0-2-6-7 and 0-3-6-5-7.

pic2

Note that the paths may be different, but the maximum number is same. For example, in the above diagram, another possible set of paths is 0-1-2-6-7 and 0-3-6-5-7 respectively.

*/