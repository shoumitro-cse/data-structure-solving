// find if the given expression is satisfiable using the Kosaraju's Algorithm 

import java.io.*; 
import java.util.*; 

class SatisfiableKA { 

	static final int MAX = 100000; 


	@SuppressWarnings("unchecked") 
	static List<List<Integer>> adj = new ArrayList(); 

	@SuppressWarnings("unchecked") 
	static List<List<Integer> > adjInv = new ArrayList(); 
	
	static boolean[] visited = new boolean[MAX]; 
	static boolean[] visitedInv = new boolean[MAX]; 
	
	static Stack<Integer> s = new Stack<Integer>(); 

	// This array will store the SCC that the particular node belongs to 
	static int[] scc = new int[MAX]; 

	// counter maintains the number of the SCC 
	static int counter = 1; 

	// Adds edges to form the original graph void 
	static void addEdges(int a, int b) { 
		adj.get(a).add(b); 
	} 

	// Add edges to form the inverse graph 
	static void addEdgesInverse(int a, int b) { 
		adjInv.get(b).add(a); 
	} 

	// For STEP 1 of Kosaraju's Algorithm 
	static void dfsFirst(int u) 
	{ 
		if (visited[u]) 
			return; 

		visited[u] = true; 

		for(int i = 0; i < adj.get(u).size(); i++) 
			dfsFirst(adj.get(u).get(i)); 

		s.push(u); 
	} 

	// For STEP 2 of Kosaraju's Algorithm 
	static void dfsSecond(int u) 
	{ 
		if (visitedInv[u]) 
			return; 

		visitedInv[u] = true; 

		for(int i = 0; i < adjInv.get(u).size(); i++) 
			dfsSecond(adjInv.get(u).get(i)); 

		scc[u] = counter; 
	} 

	// Function to check 2-Satisfiability 
	static void is2Satisfiable(int n, int m, int a[], int b[]) { 
		// Adding edges to the graph 
		for(int i = 0; i < m; i++) { 
			if (a[i] > 0 && b[i] > 0) { 
				addEdges(a[i] + n, b[i]); 
				addEdgesInverse(a[i] + n, b[i]); 
				addEdges(b[i] + n, a[i]); 
				addEdgesInverse(b[i] + n, a[i]); 
			} else if (a[i] > 0 && b[i] < 0) { 
				addEdges(a[i] + n, n - b[i]); 
				addEdgesInverse(a[i] + n, n - b[i]); 
				addEdges(-b[i], a[i]); 
				addEdgesInverse(-b[i], a[i]); 
			} else if (a[i] < 0 && b[i] > 0) { 
				addEdges(-a[i], b[i]); 
				addEdgesInverse(-a[i], b[i]); 
				addEdges(b[i] + n, n - a[i]); 
				addEdgesInverse(b[i] + n, n - a[i]); 
			} else { 
				addEdges(-a[i], n - b[i]); 
				addEdgesInverse(-a[i], n - b[i]); 
				addEdges(-b[i], n - a[i]); 
				addEdgesInverse(-b[i], n - a[i]); 
			} 
		} 

		// STEP 1 of Kosaraju's Algorithm which traverses the original graph 
		for(int i = 1; i <= 2 * n; i++) 
			if (!visited[i]) 
				dfsFirst(i); 

		while (!s.isEmpty()) { 
			int top = s.peek(); 
			s.pop(); 

			if (!visitedInv[top]) { 
				dfsSecond(top); 
				counter++; 
			} 
		} 

		for(int i = 1; i <= n; i++) { 
			// For any 2 vairable x and -x lie in same SCC 
			if (scc[i] == scc[i + n]) { 
				System.out.println("The given expression is unsatisfiable."); 
				return; 
			} 
		} 
		// No such variables x and -x exist which lie in same SCC 
		System.out.println("The given expression is satisfiable."); 
	} 

	// Driver code 
	public static void main(String[] args) { 

		int n = 5, m = 7; 

		for(int i = 0; i < MAX; i++) { 
			adj.add(new ArrayList<Integer>()); 
			adjInv.add(new ArrayList<Integer>()); 
		} 

		int a[] = { 1, -2, -1, 3, -3, -4, -3 }; 
		int b[] = { 2, 3, -2, 4, 5, -5, 4 }; 
		// We have considered the same example for which Implication Graph was made 
		is2Satisfiable(n, m, a, b); 
	} 
} 

