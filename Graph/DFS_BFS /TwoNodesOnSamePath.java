// Check if two nodes are on same path in a tree

// javac -d classes TwoNodesOnSamePath.java  && cd classes && java TwoNodesOnSamePath && cd ..

import java.util.*; 

class TwoNodesOnSamePath { 
	
	static int MAX = 100001; 

	// To keep track of visited vertices in DFS 
	static boolean [] visit = new boolean[MAX]; 

	// To store start and end time of all vertices during DFS. 
	static int [] intime = new int[MAX]; 
	static int [] outtime = new int[MAX]; 

	// Initially timer is zero 
	static int timer = 0; 

	// Does DFS of given graph and fills arrays intime[] and outtime[]. These arrays are used 
	// to answer given queries. 
	static void dfs(Vector<Integer> graph[], int v) {

		visit[v] = true; 
		
		// Increment the timer as you enter the recursion for v 
		++timer; 
		
		// Upgrade the in time for the vertex 
		intime[v] = timer; 

		for(int it : graph[v]) { 
			
			if (visit[it] == false) {
				dfs(graph, it); 
			}

			it++; 
		} 
		
		// Increment the timer as you exit the recursion for v 
		++timer; 
		
		// Upgrade the outtime for that node 
		outtime[v] = timer; 
	} 

	// Returns true if 'u' and 'v' lie on same root to leaf path else false. 
	static boolean query(int u, int v) { 
		return ((intime[u] < intime[v] && outtime[u] > outtime[v]) || 
				(intime[v] < intime[u] && outtime[v] > outtime[u])); 
	} 

	// Driver code 
	public static void main(String[] args) {

		// Let us create above shown tree 
		int n = 9; // total number of nodes 
		
		@SuppressWarnings("unchecked") 
		Vector<Integer> [] graph = new Vector[n + 1]; 
		for(int i = 0; i < graph.length; i++) {
			graph[i] = new Vector<Integer>(); 
		}
			
		graph[1].add(2); 
		graph[1].add(3); 
		graph[3].add(6); 
		graph[2].add(4); 
		graph[2].add(5); 
		graph[5].add(7); 
		graph[5].add(8); 
		graph[5].add(9); 

		// Start dfs (here root node is 1) 
		dfs(graph, 1); 

		// Below are calls for few pairs of nodes 
		if (query(1, 5)) 
			System.out.print("Yes\n" ); 
		else
			System.out.print("No\n"); 
			
		if (query(2, 9)) 
			System.out.print("Yes\n"); 
		else
			System.out.print("No\n"); 
		
		if (query(2, 6)) 
			System.out.print("Yes\n" ); 
		else
			System.out.print("No\n"); 
	} 
} 



/*
Check if two nodes are on same path in a tree


Given a tree (not necessarily a binary tree) and a number of queries such that every query 
takes two nodes of the tree as parameters. For every query pair, find if two nodes are on the 
same path from the root to the bottom.

For example, consider the below tree, if given queries are (1, 5), (1, 6), and (2, 6), then 
answers should be true, true, and false respectively. 

Note that 1 and 5 lie on the same root to leaf path, so do 1 and 6, but 2 and 6 are not on the same root to leaf path.

*/