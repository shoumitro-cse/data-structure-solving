//All Topological Sorts of a Directed Acyclic Graph

// javac -d classes AllTopologicalSorts.java  && cd classes && java AllTopologicalSorts && cd ..

import java.util.*;

class Graph {

	int V; // No. of vertices

	List<Integer> adjListArray[];

	public Graph(int V) {
		
		this.V = V;

		@SuppressWarnings("unchecked")
		List<Integer> adjListArray[] = new LinkedList[V];
		
		this.adjListArray = adjListArray;
		
		for (int i = 0; i < V; i++) {
			adjListArray[i] = new LinkedList<>();
		}
	}

	// Utility function to add edge
	public void addEdge(int src, int dest) {
		this.adjListArray[src].add(dest);

	}
	
	// Main recursive function to print all possible topological sorts
	private void allTopologicalSortsUtil(boolean[] visited, 
						int[] indegree, ArrayList<Integer> stack) {

		// To indicate whether all topological are found or not
		boolean flag = false;
		for (int i = 0; i < this.V; i++) {

			// If indegree is 0 and not yet visited then only choose that vertex
			if (!visited[i] && indegree[i] == 0) {
				
				// including in result
				visited[i] = true;
				stack.add(i);

				for (int adjacent : this.adjListArray[i]) {
					indegree[adjacent]--;
				}

				allTopologicalSortsUtil(visited, indegree, stack);
				
				// resetting visited, res and indegree for backtracking
				visited[i] = false;
				stack.remove(stack.size() - 1);

				for (int adjacent : this.adjListArray[i]) {
					indegree[adjacent]++;
				}

				flag = true;
			}
		}

		// We reach here if all vertices are visited. So we print the solution here
		if (!flag) {
			stack.forEach(i -> System.out.print(i + " "));
			System.out.println();
		}

	}
	
	// The function does all Topological Sort.
	// It uses recursive alltopologicalSortUtil()
	public void allTopologicalSorts() {
		// Mark all the vertices as not visited
		boolean[] visited = new boolean[this.V];

		int[] indegree = new int[this.V];

		for (int i = 0; i < this.V; i++) {

			for (int var : this.adjListArray[i]) {
				indegree[var]++;
			}
		}

		ArrayList<Integer> stack = new ArrayList<>();

		allTopologicalSortsUtil(visited, indegree, stack);
	}
	
}


class AllTopologicalSorts {

	public static void main(String[] args) {

		// Create a graph given in the above diagram
		Graph graph = new Graph(6);
		graph.addEdge(5, 2);
		graph.addEdge(5, 0);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);

		System.out.println("All Topological sorts");
		graph.allTopologicalSorts();
	}

}

/*
All Topological Sorts of a Directed Acyclic Graph


Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.
Given a DAG, print all topological sorts of the graph.
 

For example, consider the below graph. (pic-> TopologicalSorting.png)

All topological sorts of the given graph are:
4 5 0 2 3 1 
4 5 2 0 3 1 
4 5 2 3 0 1 
4 5 2 3 1 0 
5 2 3 4 0 1 
5 2 3 4 1 0 
5 2 4 0 3 1 
5 2 4 3 0 1 
5 2 4 3 1 0 
5 4 0 2 3 1 
5 4 2 0 3 1 
5 4 2 3 0 1 
5 4 2 3 1 0 
 

In a Directed acyclic graph many a times we can have vertices which are unrelated to each other because of which we can order them in many ways. These various topological sorting is important in many cases, for example if some relative weight is also available between the vertices, which is to minimize then we need to take care of relative ordering as well as their relative weight, which creates the need of checking through all possible topological ordering. 
We can go through all possible ordering via backtracking , the algorithm step are as follows : 
 

Initialize all vertices as unvisited.
Now choose vertex which is unvisited and has zero indegree and decrease indegree of all those vertices by 1 (corresponding to removing edges) now add this vertex to result and call the recursive function again and backtrack.
After returning from function reset values of visited, result and indegree for enumeration of other possibilities.
*/