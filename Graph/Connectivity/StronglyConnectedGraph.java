// Check if a StronglyConnectedGraph is strongly connected | Set 1 (Kosaraju using DFS)

// javac -d classes  StronglyConnectedGraph.java  && cd classes && java StronglyConnectedGraph && cd ..


import java.io.*; 
import java.util.*; 
import java.util.LinkedList; 

// This class represents a directed Graph using adjacency list representation 
class StronglyConnectedGraph {

	private int V; // No. of vertices 
	private LinkedList<Integer> adj[]; //Adjacency List 

	//Constructor 
	StronglyConnectedGraph(int v) { 
		V = v; 
		adj = new LinkedList[v]; 
		for (int i=0; i<v; ++i) {
			adj[i] = new LinkedList(); 
		}
	} 

	//Function to add an edge into the Graph 
	void addEdge(int v,int w) { 
		adj[v].add(w); 
	} 

	// A recursive function to print DFS starting from v 
	void DFSUtil(int v, Boolean visited[]) { 
		// Mark the current node as visited and print it 
		visited[v] = true; 
		int n; 
		// Recur for all the vertices adjacent to this vertex 
		Iterator<Integer> i = adj[v].iterator(); 
		while (i.hasNext()) { 
			n = i.next(); 
			if (!visited[n]) {
				DFSUtil(n, visited); 
			}
		} 
	} 

	// Function that returns transpose of this Graph 
	StronglyConnectedGraph getTranspose() {
		StronglyConnectedGraph g = new StronglyConnectedGraph(V); 
		// Recur for all the vertices adjacent to this vertex 
		for (int v = 0; v < V; v++) { 
		   Iterator<Integer> i = adj[v].listIterator(); 
		   while (i.hasNext()) {
			 g.adj[i.next()].add(v); 
		   }
		} 

		return g; 
	} 

	// The main function that returns true if Graph is strongly connected 
	Boolean isSC() { 

		// Step 1: Mark all the vertices as not visited (For first DFS) 
		Boolean visited [] = new Boolean[V]; 
		for (int i = 0; i < V; i++) {
		   visited[i] = false; 
		}

		// Step 2: Do DFS traversal starting from first vertex. 
		DFSUtil(0, visited); 
		
		// If DFS traversal doesn't visit all vertices, then return false. 
		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {
				return false; 
			}
		}
		// Step 3: Create a reversed Graph 
		StronglyConnectedGraph gr = getTranspose(); 
		// Step 4: Mark all the vertices as not visited (For second DFS) 
		for (int i = 0; i < V; i++) {
			visited[i] = false; 
		}
		// Step 5: Do DFS for reversed Graph starting from 
		// first vertex. Staring Vertex must be same starting point of first DFS 
		gr.DFSUtil(0, visited); 
		// If all vertices are not visited in second DFS, then return false 
		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {
				return false; 
			}
		}

		return true; 
	} 

	public static void main(String args[]) {

		// Create Graph given in the above diagrams 
		StronglyConnectedGraph g1 = new StronglyConnectedGraph(5); 
		
		g1.addEdge(0, 1); 
		g1.addEdge(1, 2); 
		g1.addEdge(2, 3); 
		g1.addEdge(3, 0); 
		g1.addEdge(2, 4); 
		g1.addEdge(4, 2); 

		if (g1.isSC()) 
			System.out.println("Yes"); 
		else
			System.out.println("No"); 

		StronglyConnectedGraph g2 = new StronglyConnectedGraph(4); 
		
		g2.addEdge(0, 1); 
		g2.addEdge(1, 2); 
		g2.addEdge(2, 3); 
		
		if (g2.isSC()) 
			System.out.println("Yes"); 
		else
			System.out.println("No"); 

	} 
} 


/*
Check if a graph is strongly connected | Set 1 (Kosaraju using DFS)


Given a directed graph, find out whether the graph is strongly connected or not. A directed graph 
is strongly connected if there is a path between any two pair of vertices. For example, 
following is a strongly connected graph.


It is easy for undirected graph, we can just do a BFS and DFS starting from any vertex. 
If BFS or DFS visits all vertices, then the given undirected graph is connected. This approach 
won’t work for a directed graph. For example, consider the following graph which is not strongly 
connected. If we start DFS (or BFS) from vertex 0, we can reach all vertices, but if we start from 
any other vertex, we cannot reach all vertices.
*/


// Time Complexity: Time complexity of above implementation is sane as Depth First Search which 
// is O(V+E) if the graph is represented using adjacency list representation.
