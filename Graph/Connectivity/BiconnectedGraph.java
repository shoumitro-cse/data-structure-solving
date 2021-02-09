// find biconnected components in a given undirected graph 

// javac -d classes  BiconnectedGraph.java  && cd classes && java BiconnectedGraph && cd ..

import java.io.*; 
import java.util.*; 


class Graph { 

	private int V, E; // No. of vertices & Edges respectively 
	private LinkedList<Integer> adj[]; // Adjacency List 
	
	// Count is number of biconnected components. time is used to find discovery times 
	static int count = 0, time = 0; 

	class Edge { 
		int u; 
		int v; 
		Edge(int u, int v) { 
			this.u = u; 
			this.v = v; 
		} 
	}; 

	// Constructor 
	Graph(int v) { 
		
		V = v; 
		E = 0; 
		adj = new LinkedList[v]; 

		for (int i = 0; i < v; ++i) {
			adj[i] = new LinkedList(); 
		}
	} 

	// Function to add an edge into the graph 
	void addEdge(int v, int w) { 
		adj[v].add(w); 
		E++; 
	} 

	void BCCUtil(int u, int disc[], int low[], LinkedList<Edge> st, int parent[]) { 

		// Initialize discovery time and low value 
		disc[u] = low[u] = ++time; 
		int children = 0; 

		// Go through all vertices adjacent to this 
		Iterator<Integer> it = adj[u].iterator(); 
		while (it.hasNext()) { 
			
			int v = it.next(); // v is current adjacent of 'u' 

			// If v is not visited yet, then recur for it 
			if (disc[v] == -1) { 
				children++; 
				parent[v] = u; 

				// store the edge in stack 
				st.add(new Edge(u, v)); 
				BCCUtil(v, disc, low, st, parent); 

				// Check if the subtree rooted with 'v' has a 
				// connection to one of the ancestors of 'u' 
				// Case 1 -- per Strongly Connected Components Article 
				if (low[u] > low[v]) 
					low[u] = low[v]; 

				// If u is an articulation point, pop all edges from stack till u -- v 
				if ((disc[u] == 1 && children > 1) || (disc[u] > 1 && low[v] >= disc[u])) { 
					
					while (st.getLast().u != u || st.getLast().v != v) { 
						System.out.print(st.getLast().u + "--" + st.getLast().v + " "); 
						st.removeLast(); 
					} 

					System.out.println(st.getLast().u + "--" + st.getLast().v + " "); 
					st.removeLast(); 
					count++; 
				} 
			} else if (v != parent[u] && disc[v] < disc[u] ) { 
				if (low[u] > disc[v]) {
				   low[u] = disc[v]; 
				}
				st.add(new Edge(u, v)); 
			} 
		} 
	} 

	// The function to do DFS traversal. It uses BCCUtil() 
	void BCC() {

		int disc[] = new int[V]; 
		int low[] = new int[V]; 
		int parent[] = new int[V]; 

		LinkedList<Edge> st = new LinkedList<Edge>(); 

		// Initialize disc and low, and parent arrays 
		for (int i = 0; i < V; i++) { 
			disc[i] = -1; 
			low[i] = -1; 
			parent[i] = -1; 
		} 

		for (int i = 0; i < V; i++) { 

			if (disc[i] == -1) {
				BCCUtil(i, disc, low, st, parent); 
			}

			int j = 0; 
			// If stack is not empty, pop all edges from stack 
			while (st.size() > 0) { 
				j = 1; 
				System.out.print(st.getLast().u + "--" + st.getLast().v + " "); 
				st.removeLast(); 
			} 

			if (j == 1) { 
				System.out.println(); 
				count++; 
			} 
		} 
	} 

} 


class BiconnectedGraph {

	public static void main(String args[]) {

		Graph g = new Graph(12); 
		
		g.addEdge(0, 1); 
		g.addEdge(1, 0); 
		g.addEdge(1, 2); 
		g.addEdge(2, 1); 
		g.addEdge(1, 3); 
		g.addEdge(3, 1); 
		g.addEdge(2, 3); 
		g.addEdge(3, 2); 
		g.addEdge(2, 4); 
		g.addEdge(4, 2); 
		g.addEdge(3, 4); 
		g.addEdge(4, 3); 
		g.addEdge(1, 5); 
		g.addEdge(5, 1); 
		g.addEdge(0, 6); 
		g.addEdge(6, 0); 
		g.addEdge(5, 6); 
		g.addEdge(6, 5); 
		g.addEdge(5, 7); 
		g.addEdge(7, 5); 
		g.addEdge(5, 8); 
		g.addEdge(8, 5); 
		g.addEdge(7, 8); 
		g.addEdge(8, 7); 
		g.addEdge(8, 9); 
		g.addEdge(9, 8); 
		g.addEdge(10, 11); 
		g.addEdge(11, 10); 

		g.BCC(); 

		System.out.println("Above are " + g.count + " biconnected components in graph"); 
	} 

}

/*
Biconnected Components


A biconnected component is a maximal biconnected subgraph.
Biconnected Graph is already discussed here. In this article, we will see how to find biconnected 
component in a graph using algorithm by John Hopcroft and Robert Tarjan.

(pic)

In above graph, following are the biconnected components:

4–2 3–4 3–1 2–3 1–2
8–9
8–5 7–8 5–7
6–0 5–6 1–5 0–1
10–11

*/



/*
// A Java program to find if a given undirected graph is
// biconnected
import java.io.*;
import java.util.*;
import java.util.LinkedList;

// This class represents a directed graph using adjacency
// list representation
class Graph
{
	private int V; // No. of vertices

	// Array of lists for Adjacency List Representation
	private LinkedList<Integer> adj[];

	int time = 0;
	static final int NIL = -1;

	// Constructor
	Graph(int v)
	{
		V = v;
		adj = new LinkedList[v];
		for (int i=0; i<v; ++i)
			adj[i] = new LinkedList();
	}

	//Function to add an edge into the graph
	void addEdge(int v, int w)
	{
		adj[v].add(w); //Note that the graph is undirected.
		adj[w].add(v);
	}

	// A recursive function that returns true if there is an articulation
	// point in given graph, otherwise returns false.
	// This function is almost same as isAPUtil() @ http://goo.gl/Me9Fw
	// u --> The vertex to be visited next
	// visited[] --> keeps tract of visited vertices
	// disc[] --> Stores discovery times of visited vertices
	// parent[] --> Stores parent vertices in DFS tree
	boolean isBCUtil(int u, boolean visited[], int disc[],int low[],
					int parent[])
	{

		// Count of children in DFS Tree
		int children = 0;

		// Mark the current node as visited
		visited[u] = true;

		// Initialize discovery time and low value
		disc[u] = low[u] = ++time;

		// Go through all vertices aadjacent to this
		Iterator<Integer> i = adj[u].iterator();
		while (i.hasNext())
		{
			int v = i.next(); // v is current adjacent of u

			// If v is not visited yet, then make it a child of u
			// in DFS tree and recur for it
			if (!visited[v])
			{
				children++;
				parent[v] = u;

				// check if subgraph rooted with v has an articulation point
				if (isBCUtil(v, visited, disc, low, parent))
					return true;

				// Check if the subtree rooted with v has a connection to
				// one of the ancestors of u
				low[u] = Math.min(low[u], low[v]);

				// u is an articulation point in following cases

				// (1) u is root of DFS tree and has two or more chilren.
				if (parent[u] == NIL && children > 1)
					return true;

				// (2) If u is not root and low value of one of its
				// child is more than discovery value of u.
				if (parent[u] != NIL && low[v] >= disc[u])
					return true;
			}

			// Update low value of u for parent function calls.
			else if (v != parent[u])
				low[u] = Math.min(low[u], disc[v]);
		}
		return false;
	}

	// The main function that returns true if graph is Biconnected,
	// otherwise false. It uses recursive function isBCUtil()
	boolean isBC()
	{
		// Mark all the vertices as not visited
		boolean visited[] = new boolean[V];
		int disc[] = new int[V];
		int low[] = new int[V];
		int parent[] = new int[V];

		// Initialize parent and visited, and ap(articulation point)
		// arrays
		for (int i = 0; i < V; i++)
		{
			parent[i] = NIL;
			visited[i] = false;
		}

		// Call the recursive helper function to find if there is an
		// articulation/ point in given graph. We do DFS traversal
		// starring from vertex 0
		if (isBCUtil(0, visited, disc, low, parent) == true)
			return false;

		// Now check whether the given graph is connected or not.
		// An undirected graph is connected if all vertices are
		// reachable from any starting point (we have taken 0 as
		// starting point)
		for (int i = 0; i < V; i++)
			if (visited[i] == false)
				return false;

		return true;
	}

	// Driver method
	public static void main(String args[])
	{
		// Create graphs given in above diagrams
		Graph g1 =new Graph(2);
		g1.addEdge(0, 1);
		if (g1.isBC())
			System.out.println("Yes");
		else
			System.out.println("No");

		Graph g2 =new Graph(5);
		g2.addEdge(1, 0);
		g2.addEdge(0, 2);
		g2.addEdge(2, 1);
		g2.addEdge(0, 3);
		g2.addEdge(3, 4);
		g2.addEdge(2, 4);
		if (g2.isBC())
			System.out.println("Yes");
		else
			System.out.println("No");

		Graph g3 = new Graph(3);
		g3.addEdge(0, 1);
		g3.addEdge(1, 2);
		if (g3.isBC())
			System.out.println("Yes");
		else
			System.out.println("No");

		Graph g4 = new Graph(5);
		g4.addEdge(1, 0);
		g4.addEdge(0, 2);
		g4.addEdge(2, 1);
		g4.addEdge(0, 3);
		g4.addEdge(3, 4);
		if (g4.isBC())
			System.out.println("Yes");
		else
			System.out.println("No");

		Graph g5= new Graph(3);
		g5.addEdge(0, 1);
		g5.addEdge(1, 2);
		g5.addEdge(2, 0);
		if (g5.isBC())
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
*/