// check if removing an edge disconnects a graph or not. 

// g++ CheckDisconnects.cpp && ./a.out

#include<bits/stdc++.h> 
using namespace std; 

// Graph class represents a directed graph 
// using adjacency list representation 
class Graph 
{ 
	int V; // No. of vertices 
	list<int> *adj; 
	void DFS(int v, bool visited[]); 
public: 
	Graph(int V); // Constructor 

	// function to add an edge to graph 
	void addEdge(int v, int w); 

	// Returns true if graph is connected 
	bool isConnected(); 

	bool isBridge(int u, int v); 
}; 

Graph::Graph(int V) 
{ 
	this->V = V; 
	adj = new list<int>[V]; 
} 

void Graph::addEdge(int u, int v) 
{ 
	adj[u].push_back(v); // Add w to v’s list. 
	adj[v].push_back(u); // Add w to v’s list. 
} 

void Graph::DFS(int v, bool visited[]) 
{ 
	// Mark the current node as visited and print it 
	visited[v] = true; 

	// Recur for all the vertices adjacent to 
	// this vertex 
	list<int>::iterator i; 
	for (i = adj[v].begin(); i != adj[v].end(); ++i) 
		if (!visited[*i]) 
			DFS(*i, visited); 
} 

// Returns true if given graph is connected, else false 
bool Graph::isConnected() {

	bool visited[V]; 
	memset(visited, false, sizeof(visited)); 

	// Find all reachable vertices from first vertex 
	DFS(0, visited); 

	// If set of reachable vertices includes all, return true. 
	for (int i=1; i<V; i++) 
	  if (visited[i] == false) 
		return false; 

	return true; 
} 

// This function assumes that edge (u, v) 
// exists in graph or not, 
bool Graph::isBridge(int u, int v) 
{ 
	// Remove edge from undirected graph 
	adj[u].remove(v); 
	adj[v].remove(u); 

	bool res = isConnected(); 

	// Adding the edge back 
	addEdge(u, v); 

	// Return true if graph becomes disconnected after removing the edge. 
	return (res == false); 
} 

// Driver code 
int main() {

	// Create a graph given in the above diagram 
	Graph g(4); 
	g.addEdge(0, 1); 
	g.addEdge(1, 2); 
	g.addEdge(2, 3); 

	g.isBridge(1, 2)? cout << "Yes"<<endl : cout << "No"<<endl; 

	return 0; 
} 

/*Check if removing a given edge disconnects a graph

Given an undirected graph and an edge, the task is to find if the given edge is a bridge in graph,
 i.e., removing the edge disconnects the graph.

Following are some example graphs with bridges highlighted with red color.

 show pic

// Time Complexity : O(V + E)
*/
