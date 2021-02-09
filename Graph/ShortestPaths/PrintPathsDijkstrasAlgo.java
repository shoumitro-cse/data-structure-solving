// Printing Paths in Dijkstra’s Shortest Path Algorithm

// javac -d classes  PrintPathsDijkstrasAlgo.java  && cd classes && java PrintPathsDijkstrasAlgo && cd ..


class PrintPathsDijkstrasAlgo { 

	private static final int NO_PARENT = -1; 


	private static void dijkstra(int[][] adj_matrix, int startVertex) {

		int nVertices = adj_matrix[0].length; 

		int[] shortDist = new int[nVertices]; 

		boolean[] added = new boolean[nVertices]; 

		for (int v = 0; v < nVertices; v++) { 
			shortDist[v] = Integer.MAX_VALUE; 
			added[v] = false; 
		} 
		
		// Distance of source vertex from itself is always 0 
		shortDist[startVertex] = 0; 
		// Parent array to store shortest path tree 
		int[] parents = new int[nVertices]; 
		// The starting vertex does not have a parent 
		parents[startVertex] = NO_PARENT; 

		// Find shortest path for all  vertices 
		for (int i = 1; i < nVertices; i++) { //number of edge

			int nv = -1; 
			int sd = Integer.MAX_VALUE; 
			
			for (int v = 0; v < nVertices; v++) { 

				if (!added[v] && shortDist[v] < sd) { 
					nv = v; 
					sd = shortDist[v]; 
				} 
			} 
			// Mark the picked vertex as processed 
			added[nv] = true; 
			// Update dist value of the adjacent vertices of the picked vertex. 
			for (int v = 0; v < nVertices; v++) { 
				int edgeDist = adj_matrix[nv][v]; 
			   if (edgeDist > 0 && ((sd + edgeDist) < shortDist[v])) { 
					parents[v] = nv; 
					shortDist[v] = sd + edgeDist; 
				} 
			} 
		} 

		printSolution(startVertex, shortDist, parents); 
	} 

	// A utility function to print the constructed dist array and shortest paths 
	private static void printSolution(int startVertex, int[] dist, int[] parents) { 
		int nVertices = dist.length; 
		System.out.print("Vertex\t\tDistance\tPath"); 
		
		for (int v = 0; v < nVertices; v++) { 
			if (v != startVertex) { 
				System.out.print("\n" + startVertex + " -> "); 
				System.out.print(v + " \t\t "); 
				System.out.print(dist[v] + "\t\t"); 
				printPath(v, parents); 
			} 
		} 
	} 

	// Function to print shortest path from source to currentVertex using parents array 
	private static void printPath(int currentVertex, int[] parents) {
		// Base case : Source node has been processed 
		if (currentVertex == NO_PARENT) { 
			return; 
		} 

		printPath(parents[currentVertex], parents); 
		System.out.print(currentVertex + " "); 
	} 

	public static void main(String[] args) { 

		System.out.println("\n\n");

		int[][] adj_matrix = { 
			                        { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
									{ 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
									{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
									{ 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
									{ 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
									{ 0, 0, 4, 0, 10, 0, 2, 0, 0 }, 
									{ 0, 0, 0, 14, 0, 2, 0, 1, 6 }, 
									{ 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
									{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } 
								  }; 

		dijkstra(adj_matrix, 0); 
		System.out.println();

	} 
} 

/*

Printing Paths in Dijkstra’s Shortest Path Algorithm


Given a graph and a source vertex in graph, find shortest paths from source to all vertices in the given graph.

We have discussed Dijkstra’s Shortest Path algorithm in below posts.

Dijkstra’s shortest path for adjacency matrix representation
Dijkstra’s shortest path for adjacency list representation
The implementations discussed above only find shortest distances, but do not print paths. In this post printing of paths is discussed.

For example, consider below graph and source as 0,



Output should be
Vertex           Distance         Path
0 -> 1          4        0 1 
0 -> 2          12        0 1 2 
0 -> 3          19        0 1 2 3 
0 -> 4          21        0 7 6 5 4 
0 -> 5          11        0 7 6 5 
0 -> 6          9        0 7 6 
0 -> 7          8        0 7 
0 -> 8          14        0 1 2 8*/