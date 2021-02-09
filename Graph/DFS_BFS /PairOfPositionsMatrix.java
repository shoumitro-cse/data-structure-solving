// Number of pair of positions in matrix which are not accessible

//javac -d classes PairOfPositionsMatrix.java  && cd classes && java PairOfPositionsMatrix && cd ..

import java.util.*; 

class PairOfPositionsMatrix { 

	static int k; 

	// Counts number of vertices connected in a component containing x. Stores the count in k. 
	static void dfs(Vector<Integer> graph[], boolean visited[], int x) {

		for (int i = 0; i < graph[x].size(); i++) {
			if (!visited[graph[x].get(i)]) { 
				// Incrementing the number of node in a connected component. 
				(k)++; 
				visited[graph[x].get(i)] = true; 
				dfs(graph, visited, graph[x].get(i)); 
			} 
		} 
	} 

	// Return the number of count of non-accessible cells. 
	static int countNonAccessible(Vector<Integer> graph[], int N) { 
		boolean []visited = new boolean[N * N + N]; 
		int ans = 0; 
		for (int i = 1; i <= N * N; i++) { 
			if (!visited[i]) { 
				visited[i] = true; 
				// Initialize count of connected vertices found by DFS starting from i. 
				k = 1; 
				dfs(graph, visited, i); 

				// Update result 
				ans += k * (N * N - k); 
			} 
		} 
		return ans; 
	} 

	// Inserting the edge between edge. 
	static void insertpath(Vector<Integer> graph[], int N, int x1, int y1, int x2, int y2) { 
		
		// Mapping the cell coordinate into node number. 
		int a = (x1 - 1) * N + y1; // 1
		int b = (x2 - 1) * N + y2; // 2

		// Inserting the edge. 
		graph[a].add(b); 
		graph[b].add(a); 
	} 

    @SuppressWarnings("unchecked")
	public static void main(String args[]) {

		int N = 2; 

		Vector[] graph = new Vector[N * N + 1]; 
	
		for (int i = 1; i <= N * N; i++) 
			graph[i] = new Vector<Integer>(); 
	
		insertpath(graph, N, 1, 1, 1, 2); 
		insertpath(graph, N, 1, 2, 2, 2); 

		System.out.println(); 
		System.out.println(countNonAccessible(graph, N)); 

	} 
} 


/*
Number of pair of positions in matrix which are not accessible

Time Complexity : O(N * N).


Given a positive integer N. Consider a matrix of N X N. No cell can be accessible from any other cell, 
except the given pair cell in the form of (x1, y1), (x2, y2) i.e there is a path (accessible) 
between (x2, y2) to (x1, y1). The task is to find the count of pairs (a1, b1), (a2, b2) 
such that cell (a2, b2) is not accessible from (a1, b1).

Examples:

Input : N = 2
Allowed path 1: (1, 1) (1, 2)
Allowed path 2: (1, 2) (2, 2)
Output : 6

Cell (2, 1) is not accessible from any cell
and no cell is accessible from it. (pic)

(1, 1) - (2, 1)
(1, 2) - (2, 1)
(2, 2) - (2, 1)
(2, 1) - (1, 1)
(2, 1) - (1, 2)
(2, 1) - (2, 2)
*/