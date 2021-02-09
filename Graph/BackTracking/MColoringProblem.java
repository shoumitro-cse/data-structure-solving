/* M Coloring problem using backtracking */

// javac -d classes  MColoringProblem.java  && cd classes && java MColoringProblem && cd ..

public class MColoringProblem {

	final int V = 4;
	int color[];

	 // A utility function to check if the current color assignment is safe for vertex v 
	boolean isSafe(int v, int graph[][], int color[], int c) {
		for (int i = 0; i < V; i++) {
			if (graph[v][i] == 1 && c == color[i]) {
				return false;
			}
		}
		return true;
	}

	 // A recursive utility function to solve m coloring problem 
	boolean graphColoringUtil(int graph[][], int m, int color[], int v) {
		 // base case: If all vertices are assigned a color then return true 
		if (v == V)
			return true;

		 // Consider this vertex v and try different colors 
		for (int c = 1; c <= m; c++) {// m = 3 number of color
			 // Check if assignment of color c to v is fine
			if (isSafe(v, graph, color, c)) {
				color[v] = c;
				 // recur to assign colors to rest of the vertices 
				if (graphColoringUtil(graph, m, color, v + 1))
					return true;
				 // If assigning color c doesn't lead to a solution then remove it 
				color[v] = 0;
			}
		}

		 // If no color can be assigned to this vertex then return false 
		return false;
	}


	boolean graphColoring(int graph[][], int m) {
		// Initialize all color values as 0. This
		// initialization is needed correct
		// functioning of isSafe()
		color = new int[V];
		for (int i = 0; i < V; i++) {
			color[i] = 0;
		}

		// Call graphColoringUtil() for vertex 0
		if (!graphColoringUtil(graph, m, color, 0)) {
			System.out.println("Solution does not exist");
			return false;
		}

		// Print the solution
		printSolution(color);
		return true;
	}

	 // A utility function to print solution 
	void printSolution(int color[]) {
		System.out.println("Solution Exists: Following are the assigned colors");
		for (int i = 0; i < V; i++) {
			System.out.print(" " + color[i] + " ");
		}

		System.out.println();
	}

	public static void main(String args[]) {

		MColoringProblem coloring = new MColoringProblem();
		
        /* 
          Create following graph and test whether it is
           3 colorable

          (3)---(2)
           |   / |
           |  /  |
           | /   |
          (0)---(1)
        */

		int graph[][] = {
							{ 0, 1, 1, 1 },
							{ 1, 0, 1, 0 },
							{ 1, 1, 0, 1 },
							{ 1, 0, 1, 0 },
						};

		int m = 3; // Number of colors

		coloring.graphColoring(graph, m);
	
	}
}

/*m Coloring Problem | Backtracking-5


Given an undirected graph and a number m, determine if the graph can be coloured with at most m colours such that no two adjacent vertices of the graph are colored with the same color. Here coloring of a graph means the assignment of colors to all vertices. 
Input-Output format: 
Input: 

A 2D array graph[V][V] where V is the number of vertices in graph and graph[V][V] is adjacency matrix representation of the graph. A value graph[i][j] is 1 if there is a direct edge from i to j, otherwise graph[i][j] is 0.
An integer m which is the maximum number of colors that can be used.
Output: 
An array color[V] that should have numbers from 1 to m. color[i] should represent the color assigned to the ith vertex. The code should also return false if the graph cannot be colored with m colors.

Example: 

Input:  
graph = {0, 1, 1, 1},
        {1, 0, 1, 0},
        {1, 1, 0, 1},
        {1, 0, 1, 0}
Output: 
Solution Exists: 
Following are the assigned colors
 1  2  3  2
Explanation: By coloring the vertices 
with following colors, adjacent 
vertices does not have same colors

Input: 
graph = {1, 1, 1, 1},
        {1, 1, 1, 1},
        {1, 1, 1, 1},
        {1, 1, 1, 1}
Output: Solution does not exist.
Explanation: No solution exits.


 Following is an example of a graph that can be coloured with 3 different colours. (pic)
*/