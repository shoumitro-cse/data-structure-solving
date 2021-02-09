// Find k-cores of an undirected graph

//javac -d classes FindkCoresUndirectedGraph.java  && cd classes && java FindkCoresUndirectedGraph && cd ..


import java.util.*; 

class FindkCoresUndirectedGraph { 

	// This class represents a undirected graph using adjacency list representation 
	static class Graph { 
		int V; // No. of vertices 
		// Pointer to an array containing adjacency lists 
		Vector<Integer>[] adj; 

		@SuppressWarnings("unchecked") 
		Graph(int V) { 
			this.V = V; 
			this.adj = new Vector[V]; 

			for (int i = 0; i < V; i++) {
				adj[i] = new Vector<>(); 
			}
		} 

		// function to add an edge to graph 
		void addEdge(int u, int v) { 
			this.adj[u].add(v); 
			this.adj[v].add(u); 
		} 


		boolean DFSUtil(int v, boolean[] visited, int[] vDegree, int k) { 
			
			// Mark the current node as visited and print it 
			visited[v] = true; 
			
			// Recur for all the vertices adjacent to this vertex 
			for (int i : adj[v]) { 
				
				// degree of v is less than k, then degree of adjacent must be reduced 
				if (vDegree[v] < k) {
					vDegree[i]--; 
				}

				// If adjacent is not processed, process it 
				if (!visited[i]) { 
					// If degree of adjacent after processing becomes 
					// less than k, then reduce degree of v also. 
					if (DFSUtil(i, visited, vDegree, k)) {
						vDegree[v]--; 
					}
				} 
			} 

			// Return true if degree of v is less than k 
			return (vDegree[v] < k); 
		} 

		// Prints k cores of an undirected graph 
		void printKCores(int k) {

			// INITIALIZATION Mark all the vertices as not visited and not processed. 
			boolean[] visited = new boolean[V]; 
			// boolean[] processed = new boolean[V]; 

			Arrays.fill(visited, false); 
			// Arrays.fill(processed, false); 

			int mindeg = Integer.MAX_VALUE; 
			int startvertex = 0; 

			// Store degrees of all vertices 
			int[] vDegree = new int[V]; 

			// System.out.println(Arrays.toString(vDegree));
			for (int i = 0; i < V; i++) { 
				vDegree[i] = adj[i].size(); 
				if (vDegree[i] < mindeg) { 
					mindeg = vDegree[i]; //4
					startvertex = i; //2
				} 
			} 

			System.out.println(Arrays.toString(vDegree));
			DFSUtil(startvertex, visited, vDegree, k); 
			System.out.println(Arrays.toString(vDegree));

			// DFS traversal to update degrees of all vertices. 
			for (int i = 0; i < V; i++) {
				if (!visited[i]) {
					DFSUtil(i, visited, vDegree, k); 
				}
			}
			System.out.println(Arrays.toString(vDegree));

			// PRINTING K CORES 
			System.out.println("K-Cores : "); 
			for (int v = 0; v < V; v++) { 
				// Only considering those vertices which have degree >= K after BFS 
				if (vDegree[v] >= k) { 
					System.out.printf("\n[%d]", v); 
					// Traverse adjacency list of v and print only 
					// those adjacent which have vDegree >= k after BFS. 
					for (int i : adj[v]) {
						if (vDegree[i] >= k) {
							System.out.printf(" -> %d", i); 
						}
					}
				} 
			} 
		} 
	} 


	public static void main(String[] args) { 

		// Create a graph given in the above diagram 
		int k = 3; 
		Graph g1 = new Graph(9); 
		g1.addEdge(0, 1); 
		g1.addEdge(0, 2); 
		g1.addEdge(1, 2); 
		g1.addEdge(1, 5); 
		g1.addEdge(2, 3); 
		g1.addEdge(2, 4); 
		g1.addEdge(2, 5); 
		g1.addEdge(2, 6); 
		g1.addEdge(3, 4); 
		g1.addEdge(3, 6); 
		g1.addEdge(3, 7); 
		g1.addEdge(4, 6); 
		g1.addEdge(4, 7); 
		g1.addEdge(5, 6); 
		g1.addEdge(5, 8); 
		g1.addEdge(6, 7); 
		g1.addEdge(6, 8); 
		g1.printKCores(k); 

		System.out.println(); 

/*		Graph g2 = new Graph(13); 
		g2.addEdge(0, 1); 
		g2.addEdge(0, 2); 
		g2.addEdge(0, 3); 
		g2.addEdge(1, 4); 
		g2.addEdge(1, 5); 
		g2.addEdge(1, 6); 
		g2.addEdge(2, 7); 
		g2.addEdge(2, 8); 
		g2.addEdge(2, 9); 
		g2.addEdge(3, 10); 
		g2.addEdge(3, 11); 
		g2.addEdge(3, 12); 
		g2.printKCores(k); */
	} 
} 

// Time complexity of the above solution is O(V + E) where V is number of vertices 
// and E is number of edges.



/*
Find k-cores of an undirected graph


Given a graph G and an integer K, K-cores of the graph are connected components that are left after all vertices of degree less than k have been removed (Source wiki)

Example: (pic is store inside computer)

Input : Adjacency list representation of graph shown
        on left side of below diagram
Output: K-Cores : 
[2] -> 3 -> 4 -> 6
[3] -> 2 -> 4 -> 6 -> 7
[4] -> 2 -> 3 -> 6 -> 7
[6] -> 2 -> 3 -> 4 -> 7
[7] -> 3 -> 4 -> 6
*/