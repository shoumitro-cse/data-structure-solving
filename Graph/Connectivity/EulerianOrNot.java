// check if a given directed graph is Eulerian or not 

// Find if an array of strings can be chained to form a circle | Set 1

 // javac -d classes  EulerianOrNot.java  && cd classes && java EulerianOrNot && cd ..

import java.util.ArrayList; 
import java.util.List; 

// A class that represents an undirected graph 
class EulerianOrNot{ 
	
	static final int CHARS = 26; 

	// No. of vertices 
	int V; 

	// A dynamic array of adjacency lists 
	List<List<Integer>> adj; 
	int[] in; 

	// Constructor 
	EulerianOrNot(int V) { 
		this.V = V; 
		in = new int[V]; 
		adj = new ArrayList<>(CHARS); 
		
		for(int i = 0; i < CHARS; i++) { 
	    	adj.add(i, new ArrayList<>()); 
		} 
	} 

	// Function to add an edge to graph 
	void addEdge(int v, int w) { 
		adj.get(v).add(w); 
		in[w]++; 
	} 
	// Method to check if this graph is Eulerian or not 
	boolean isEulerianCycle() { 
		// Check if all non-zero degree 
		// vertices are connected 
		if (!isSC()) 
			return false;
		// Check if in degree and out 
		// degree of every vertex is same 
		for(int i = 0; i < V; i++) 
		if (adj.get(i).size() != in[i]) 
			return false; 
		return true; 
	} 

	// This function returns true if all 
	// non-zero degree vertices of graph 
	// are strongly connected. Please refer 
	boolean isSC() { 
		// Mark all the vertices as not 
		// visited (For first DFS) 
		boolean[] visited = new boolean[V]; 
		for(int i = 0; i < V; i++) 
		   visited[i] = false; 
		// Find the first vertex with 
		// non-zero degree 
		int n; 
		for(n = 0; n < V; n++) 
		  if (adj.get(n).size() > 0) 
			break; 
		// Do DFS traversal starting from 
		// first non zero degree vertex. 
		DFSUtil(n, visited); 
		// If DFS traversal doesn't visit all 
		// vertices, then return false. 
		for(int i = 0; i < V; i++) 
		  if (adj.get(i).size() > 0 && !visited[i]) 
			return false; 
		// Create a reversed graph 
		EulerianOrNot gr = getTranspose(); 
		// Mark all the vertices as not 
		// visited (For second DFS) 
		for(int i = 0; i < V; i++) 
		  visited[i] = false; 
		// Do DFS for reversed graph starting from first vertex. Staring Vertex 
		// must be same starting point of first DFS 
		gr.DFSUtil(n, visited); 
		// If all vertices are not visited in second DFS, then return false 
		for(int i = 0; i < V; i++) 
		  if (adj.get(i).size() > 0 && !visited[i]) 
			return false; 

		return true; 
	} 


	void DFSUtil(int v, boolean[] visited) { 
		// Mark the current node as visited and print it 
		visited[v] = true; 
		// Recur for all the vertices adjacent to this vertex 
		for(Integer i : adj.get(v)) 
		if (!visited[i]) { 
			DFSUtil(i, visited); 
		} 
	} 

	// Function that returns reverse (or transpose) of this graph 
	// This function is needed in isSC() 
	EulerianOrNot getTranspose() { 
		EulerianOrNot g = new EulerianOrNot(V); 
		for(int v = 0; v < V; v++) { 
			// Recur for all the vertices adjacent to this vertex 
			for(Integer i : adj.get(v)) { 
				g.adj.get(i).add(v); 
				g.in[v]++; 
			} 
		} 
		return g; 
	} 

	// This function takes an of strings and returns true if the given array 
	// of strings can be chained to form cycle 
	static boolean canBeChained(String[] arr, int n) { 
		// Create a graph with 'aplha' edges 
		EulerianOrNot g = new EulerianOrNot(CHARS); 
		// Create an edge from first character to last character of every string 
		for(int i = 0; i < n; i++) { 
		  String s = arr[i]; 
		  g.addEdge(s.charAt(0) - 'a', s.charAt(s.length() - 1) - 'a'); 
		} 
		// The given array of strings can be chained if there is an eulerian 
		// cycle in the created graph 
		return g.isEulerianCycle(); 
	} 


	public static void main(String[] args) throws Exception {
		String[] arr1 = { "for", "geek", "rig", "kaf" }; 
		int n1 = arr1.length; 
		System.out.println((canBeChained(arr1, n1) ? "\nCan be chained " : "\nCan't be chained ")); 

/*		String[] arr2 = { "aab", "abb" }; 
		int n2 = arr2.length; 
		
		System.out.println((canBeChained(arr2, n2) ? "Can be chained " : "Can't be chained ")); */
	} 
} 


/*
Find if an array of strings can be chained to form a circle | Set 1


Given an array of strings, find if the given strings can be chained to form a circle. 
A string X can be put before another string Y in circle if the last character of X is 
same as first character of Y.

Examples:

Input: arr[] = {"geek", "king"}
Output: Yes, the given strings can be chained.
Note that the last character of first string is same
as first character of second string and vice versa is
also true.

Input: arr[] = {"for", "geek", "rig", "kaf"}
Output: Yes, the given strings can be chained.
The strings can be chained as "for", "rig", "geek" 
and "kaf"

Input: arr[] = {"aab", "bac", "aaa", "cda"}
Output: Yes, the given strings can be chained.
The strings can be chained as "aaa", "aab", "bac" 
and "cda"

Input: arr[] = {"aaa", "bbb", "baa", "aab"};
Output: Yes, the given strings can be chained.
The strings can be chained as "aaa", "aab", "bbb" 
and "baa"

Input: arr[] = {"aaa"};
Output: Yes

Input: arr[] = {"aaa", "bbb"};
Output: No

Input  : arr[] = ["abc", "efg", "cde", "ghi", "ija"]
Output : Yes
These strings can be reordered as, “abc”, “cde”, “efg”,
“ghi”, “ija”

Input : arr[] = [“ijk”, “kji”, “abc”, “cba”]
Output : No*/










/*

// C++ code to check if cyclic order is possible among strings
// under given constrainsts
#include <bits/stdc++.h>
using namespace std;
#define M 26

// Utility method for a depth first search among vertices
void dfs(vector<int> g[], int u, vector<bool> &visit)
{
	visit[u] = true;
	for (int i = 0; i < g[u].size(); ++i)
		if(!visit[g[u][i]])
			dfs(g, g[u][i], visit);
}

// Returns true if all vertices are strongly connected i.e. can be made as loop
bool isConnected(vector<int> g[], vector<bool> &mark, int s)
{
	// Initialize all vertices as not visited
	vector<bool> visit(M, false);

	// perform a dfs from s
	dfs(g, s, visit);

	// now loop through all characters
	for (int i = 0; i < M; i++)
	{

		if (mark[i] && !visit[i])
			return false;
	}

	// If we reach that means graph is connected
	return true;
}

// return true if an order among strings is possible
bool possibleOrderAmongString(string arr[], int N)
{
	// Create an empty graph
	vector<int> g[M];

	// Initialize all vertices as not marked
	vector<bool> mark(M, false);

	// Initialize indegree and outdegree of every
	// vertex as 0.
	vector<int> in(M, 0), out(M, 0);

	// Process all strings one by one
	for (int i = 0; i < N; i++)
	{
		// Find first and last characters
		int f = arr[i].front() - 'a';
		int l = arr[i].back() - 'a';

		// Mark the characters
		mark[f] = mark[l] = true;

		// increase indegree and outdegree count
		in[l]++;
		out[f]++;

		// Add an edge in graph
		g[f].push_back(l);
	}

	// If for any character indegree is not equal to
	// outdegree then ordering is not possible
	for (int i = 0; i < M; i++)
		if (in[i] != out[i])
			return false;

	return isConnected(g, mark, arr[0].front() - 'a');
}

// Driver code to test above methods
int main()
{
	// string arr[] = {"abc", "efg", "cde", "ghi", "ija"};
	string arr[] = {"ab", "bc", "cd", "de", "ed", "da"};
	int N = sizeof(arr) / sizeof(arr[0]);

	if (possibleOrderAmongString(arr, N) == false)
		cout << "Ordering not possible\n";
	else
		cout << "Ordering is possible\n";
	return 0;
}
*/