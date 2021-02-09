// Check if a given graph is tree or not

// javac -d classes  GraphIsTreeOrNot.java  && cd classes && java GraphIsTreeOrNot && cd ..

import java.io.*; 
import java.util.*; 

// This class represents a directed graph using adjacency list representation 
class Graph 
{ 
	private int V; // No. of vertices 
	private LinkedList<Integer> adj[]; //Adjacency List 

	// Constructor 
	@SuppressWarnings("unchecked") 
	Graph(int v) { 
		V = v; 
		adj = new LinkedList[V]; 
		for (int i = 0; i < v; ++i) {
			adj[i] = new LinkedList<Integer>(); 
		}
	} 

	// Function to add an edge into the graph 
	void addEdge(int v,int w) { 
		adj[v].add(w); 
		adj[w].add(v); 
	} 

	// A recursive function that uses visited[] and parent 
	// to detect cycle in subgraph reachable from vertex v. 
	boolean isCyclicDFSUtil(int v, boolean visited[], int parent) {
		// Mark the current node as visited 
		visited[v] = true; 
		Integer i; 
		// Recur for all the vertices adjacent to this vertex 
		Iterator<Integer> it = adj[v].iterator(); 
		while (it.hasNext()) { 
			i = it.next(); 
			// If an adjacent is not visited, then recur for that adjacent 
			if (!visited[i]) { 
				if (isCyclicDFSUtil(i, visited, v)) 
					return true; 
			} else if (i != parent) {
			// If an adjacent is visited and not parent of current vertex, then there is a cycle. 
			   return true; 
			}
		} 

		return false; 
	} 

	// Returns true if the graph is a tree, else false. 
	boolean isTree() { 

		// Mark all the vertices as not visited and not part of recursion stack 
		boolean visited[] = new boolean[V]; 
		for (int i = 0; i < V; i++) {
			visited[i] = false; 
		}
		
		// The call to isCyclicDFSUtil serves multiple purposes 
		// It returns true if graph reachable from vertex 0 
		// is cyclcic. It also marks all vertices reachable from 0. 
		if (isCyclicDFSUtil(0, visited, -1)) {
			return false; 
		}

		// If we find a vertex which is not reachable from 0 
		// (not marked by isCyclicDFSUtil(), then we return false 
		for (int u = 0; u < V; u++) {
			if (!visited[u]) {
				return false; 
			}
		}

		return true; 
	} 

} 

class GraphIsTreeOrNot {


	public static void main(String args[]) {

		// Create a graph given in the above diagram 
		Graph g1 = new Graph(5); 
		g1.addEdge(1, 0); 
		g1.addEdge(0, 2); 
		g1.addEdge(0, 3); 
		g1.addEdge(3, 4); 
		if (g1.isTree()) 
			System.out.println("Graph is Tree"); 
		else
			System.out.println("Graph is not Tree"); 

/*		Graph g2 = new Graph(5); 
		g2.addEdge(1, 0); 
		g2.addEdge(0, 2); 
		g2.addEdge(2, 1); 
		g2.addEdge(0, 3); 
		g2.addEdge(3, 4); 

		if (g2.isTree()) 
			System.out.println("Graph is Tree"); 
		else
			System.out.println("Graph is not Tree"); */

	} 

}

/*
Check if a given graph is tree or not


Write a function that returns true if a given undirected graph is tree and false otherwise. 
For example, the following graph is a tree.
(pic)*/