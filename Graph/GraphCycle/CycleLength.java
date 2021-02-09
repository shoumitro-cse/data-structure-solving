// Cycles of length n in an undirected and connected graph

// javac -d classes CycleLength.java  && cd classes && java CycleLength && cd ..

public class CycleLength { 
	
	// Number of vertices 
	public static final int V = 5; 
	static int count = 0; 
	
	static void DFS(int graph[][], boolean marked[], int n, int vert, int start) { 
	   
	   // mark the vertex vert as visited 
		marked[vert] = true; 
		
		// if the path of length (n-1) is found 
		if (n == 0) { 
			// mark vert as un-visited to make it usable again 
			marked[vert] = false; 
			// Check if vertex vert end with vertex start 
			if (graph[vert][start] == 1) { 
				count++; 
				return; 
			} else {
				return; 
			}
		} 
		
		// For searching every possible path of length (n-1) 
		for (int i = 0; i < V; i++) {
			if (!marked[i] && graph[vert][i] == 1) { 
				// DFS for searching path by decreasing length by 1 
				DFS(graph, marked, n-1, i, start); 
			}
		}

		// marking vert as unvisited to make it usable again 
		marked[vert] = false; 
	} 
	
	// Count cycles of length N in an undirected and connected graph. 
	static int countCycles(int graph[][], int n) { 
		// all vertex are marked un-visited initially. 
		boolean marked [] = new boolean[V];
		// Searching for cycle by using v-n+1 vertices 
		for (int i = 0; i < V-(n-1); i++) { 
			DFS(graph, marked, n-1, i, i); 
			// ith vertex is marked as visited and will not be visited again 
			marked[i] = true; 
		} 
		
		return count / 2; 
	} 
	

	public static void main(String[] args) { 
		
		int graph[][] = {
				            {0, 1, 0, 1, 0}, 
							{1, 0, 1, 0, 1}, 
							{0, 1, 0, 1, 0}, 
							{1, 0, 1, 0, 1}, 
							{0, 1, 0, 1, 0}
					   }; 
		int n = 4; 
		System.out.println("Total cycles of length "+ n + " are "+ countCycles(graph, n)); 
	} 
} 


/*
Cycles of length n in an undirected and connected graph


Given an undirected and connected graph and a number n, count total number of cycles of 
length n in the graph. A cycle of length n simply means that the cycle contains n vertices 
and n edges. And we have to count all such cycles that exist.

Example : (pic)

Input :  n = 4

Output : Total cycles = 3
Explanation : Following 3 unique cycles 
   0 -> 1 -> 2 -> 3 -> 0
   0 -> 1 -> 4 -> 3 -> 0
   1 -> 2 -> 3 -> 4 -> 1

Note* : There are more cycles but
these 3 are unique as 0 -> 3 -> 2 -> 1-> 0 and 0 -> 1 -> 2 -> 3 -> 0 are 
same cycles and hence will be counted as 1.

*/