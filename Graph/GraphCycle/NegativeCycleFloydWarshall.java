// Detecting negative cycle using Floyd Warshall

// javac -d classes NegativeCycleFloydWarshall.java  && cd classes && java NegativeCycleFloydWarshall && cd ..


class NegativeCycleFloydWarshall { 
	
	// Number of vertices in the graph 
	static final int V = 4; 
	static final int INF = 99999; 

	// Returns true if graph has negative weight cycle else false. 
	static boolean negCyclefloydWarshall(int graph[][]) { 

		int dist[][] = new int[V][V], i, j, k; 

		for (i = 0; i < V; i++) 
			for (j = 0; j < V; j++) 
				dist[i][j] = graph[i][j]; 
	
		for (k = 0; k < V; k++) { 
			// Pick all vertices as source one by one 
			for (i = 0; i < V; i++) { 
				// Pick all vertices as destination for the above picked source 
				for (j = 0; j < V; j++) { 
					// If vertex k is on the shortest path from 
					// i to j, then update the value of dist[i][j] 
					if (dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j]; 
					}
				} 
			} 
		} 
	
		// If distance of any verex from itself becomes negative, 
		// then there is a negative weight cycle. 
		for (i = 0; i < V; i++) {
			if (dist[i][i] < 0) {
				return true; 
			}
		}

		return false; 
	} 
		
	public static void main (String[] args) { 
	
    /* Let us create the following weighted graph 
                1 
        (0)----------->(1) 
        /|\               | 
         |               | 
      -1 |               | -1 
         |                \|/ 
        (3)<-----------(2) 
            -1     */
          
		int graph[][] = { 
			              {0, 1, INF, INF}, 
						  {INF, 0, -1, INF}, 
						  {INF, INF, 0, -1}, 
						  {-1, INF, INF, 0}
						}; 
		
		if (negCyclefloydWarshall(graph)) 
			System.out.println("Yes"); 
		else
			System.out.println("No"); 
	} 
} 

