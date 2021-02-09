// Longest Path in a Directed Acyclic Graph

// g++ LongestPathGAG.cpp && ./a.out

#include <iostream>
#include <limits.h>
#include <list>
#include <stack>

#define NINF INT_MIN

using namespace std;

class AdjListNode { 
	int v; 
	int weight; 

public: 
	AdjListNode(int _v, int _w) { 
		v = _v; 
		weight = _w; 
	} 

	int getV() { return v; } 
	int getWeight() { return weight; } 
}; 

// Class to represent a graph using adjacency list 
// representation 
class Graph { 
	int V; // No. of vertices' 

	// Pointer to an array containing adjacency lists 
	list<AdjListNode>* adj; 

	// A function used by longestPath 
	void topologicalSortUtil(int v, bool visited[], stack<int>& Stack); 

public: 
	Graph(int V); // Constructor 
	~Graph(); // Destructor

	// function to add an edge to graph 
	void addEdge(int u, int v, int weight); 

	// Finds longest distances from given source vertex 
	void longestPath(int s); 
}; 

Graph::Graph(int V) // Constructor 
{ 
	this->V = V; 
	adj = new list<AdjListNode>[V]; 
} 

Graph::~Graph() // Destructor 
{ 
	delete [] adj; 
} 


void Graph::addEdge(int u, int v, int weight) { 
	AdjListNode node(v, weight); 
	adj[u].push_back(node); // Add v to u's list 
} 


void Graph::topologicalSortUtil(int v, bool visited[], stack<int>& Stack) {

	// Mark the current node as visited 
	visited[v] = true; 

	// Recur for all the vertices adjacent to this vertex 
	list<AdjListNode>::iterator i; 
	for (i = adj[v].begin(); i != adj[v].end(); ++i) { 

		AdjListNode node = *i; 
		
		if (!visited[node.getV()]) {
			topologicalSortUtil(node.getV(), visited, Stack); 
		}
	} 

	// Push current vertex to stack which stores topological sort 
	Stack.push(v); 
} 

// The function to find longest distances from a given vertex. 
// It uses recursive topologicalSortUtil() to get topological sorting. 
void Graph::longestPath(int s) {

	stack<int> Stack; 
	int dist[V]; 

	// Mark all the vertices as not visited 
	bool* visited = new bool[V]; 
	for (int i = 0; i < V; i++) 
		visited[i] = false; 

	// Call the recursive helper function to store Topological 
	// Sort starting from all vertices one by one 
	for (int i = 0; i < V; i++) 
		if (visited[i] == false) 
			topologicalSortUtil(i, visited, Stack); 

	// Initialize distances to all vertices as infinite and distance to source as 0 
	for (int i = 0; i < V; i++) 
		dist[i] = NINF; 
	dist[s] = 0; 

	// Process vertices in topological order 
	while (Stack.empty() == false) {

		// Get the next vertex from topological order 
		int u = Stack.top(); 
		Stack.pop(); 

		// Update distances of all adjacent vertices 
		list<AdjListNode>::iterator i; 
		if (dist[u] != NINF) { 

			for (i = adj[u].begin(); i != adj[u].end(); ++i) { 

				if (dist[i->getV()] < dist[u] + i->getWeight()) {
					dist[i->getV()] = dist[u] + i->getWeight(); // dist increase
				}
			}
		} 
	} 

	// Print the calculated longest distances 
	for (int i = 0; i < V; i++) {
		(dist[i] == NINF) ? cout << "INF " : cout << dist[i] << " ";
	}
	
	delete [] visited;
} 



int main() {

	// Create a graph given in the above diagram. Here vertex numbers are 0, 1, 2, 3, 4, 5 with 
	// following mappings: 0=r, 1=s, 2=t, 3=x, 4=y, 5=z 
	
	Graph g(6); 
	
	g.addEdge(0, 1, 5); 
	g.addEdge(0, 2, 3); 
	g.addEdge(1, 3, 6); 
	g.addEdge(1, 2, 2); 
	g.addEdge(2, 4, 4); 
	g.addEdge(2, 5, 2); 
	g.addEdge(2, 3, 7); 
	g.addEdge(3, 5, 1); 
	g.addEdge(3, 4, -1); 
	g.addEdge(4, 5, -2); 

	int s = 1; 
	cout << "\n\nFollowing are longest distances from source vertex "<< s << " \n"; 
	g.longestPath(s); 
    cout<<endl;

	return 0; 
}

/*
Time Complexity: Time complexity of topological sorting is O(V + E). After finding topological order, the algorithm process all vertices and for every vertex, it runs a loop for all adjacent vertices. As total adjacent vertices in a graph is O(E), the inner loop runs O(V + E) times. Therefore, overall time complexity of this algorithm is O(V + E).

*/



/*// A C++ program to find single source longest distances
// in a DAG
#include <bits/stdc++.h>
using namespace std;

// Graph is represented using adjacency list. Every node of
// adjacency list contains vertex number of the vertex to
// which edge connects. It also contains weight of the edge
class AdjListNode
{
	int v;
	int weight;
public:
	AdjListNode(int _v, int _w)
	{
		v = _v;
		weight = _w;
	}
	int getV() {
		return v;
	}
	int getWeight() {
		return weight;
	}
};

// Graph class represents a directed graph using adjacency
// list representation
class Graph
{
	int V; // No. of vertices

	// Pointer to an array containing adjacency lists
	list<AdjListNode>* adj;

	// This function uses DFS
	void longestPathUtil(int, vector<bool> &, stack<int> &);
public:
	Graph(int); // Constructor
	~Graph(); // Destructor

	// function to add an edge to graph
	void addEdge(int, int, int);

	void longestPath(int);
};

Graph::Graph(int V) // Constructor
{
	this->V = V;
	adj = new list<AdjListNode>[V];
}

Graph::~Graph() // Destructor
{
	delete[] adj;
}

void Graph::addEdge(int u, int v, int weight)
{
	AdjListNode node(v, weight);
	adj[u].push_back(node); // Add v to u's list
}

// A recursive function used by longestPath. See below
// link for details.
// https://www.geeksforgeeks.org/topological-sorting/
void Graph::longestPathUtil(int v, vector<bool> &visited, stack<int> &Stack)
{
	// Mark the current node as visited
	visited[v] = true;

	// Recur for all the vertices adjacent to this vertex
	for (AdjListNode node : adj[v])
	{
		if (!visited[node.getV()])
			longestPathUtil(node.getV(), visited, Stack);
	}

	// Push current vertex to stack which stores topological
	// sort
	Stack.push(v);
}

// The function do Topological Sort and finds longest distances from given source vertex
void Graph::longestPath(int s) {

	// Initialize distances to all vertices as infinite and distance to source as 0
	int dist[V];
	for (int i = 0; i < V; i++)
		dist[i] = INT_MAX;
	dist[s] = 0;

	stack<int> Stack;

	// Mark all the vertices as not visited
	vector<bool> visited(V, false);

	for (int i = 0; i < V; i++) {
		if (visited[i] == false) {
			longestPathUtil(i, visited, Stack);
		}
	}

	// Process vertices in topological order
	while (!Stack.empty()) {

		// Get the next vertex from topological order
		int u = Stack.top();
		Stack.pop();

		if (dist[u] != INT_MAX) {
			
			// Update distances of all adjacent vertices (edge from u -> v exists)
			for (AdjListNode v : adj[u]) {

				// consider negative weight of edges and find shortest path
				if (dist[v.getV()] > dist[u] + v.getWeight() * -1) {
					dist[v.getV()] = dist[u] + v.getWeight() * -1;
				}
			}
		}
	}

	// Print the calculated longest distances
	for (int i = 0; i < V; i++) {

		if (dist[i] == INT_MAX)
			cout << "INT_MIN ";
		else
			cout << (dist[i] * -1) << " ";
	}
}

// Driver code
int main()
{
	Graph g(6);

	g.addEdge(0, 1, 5);
	g.addEdge(0, 2, 3);
	g.addEdge(1, 3, 6);
	g.addEdge(1, 2, 2);
	g.addEdge(2, 4, 4);
	g.addEdge(2, 5, 2);
	g.addEdge(2, 3, 7);
	g.addEdge(3, 5, 1);
	g.addEdge(3, 4, -1);
	g.addEdge(4, 5, -2);

	int s = 1;

	cout << "Following are longest distances from "<< "source vertex " << s << " \n";
	g.longestPath(s);
    cout<<endl;

	return 0;
}

*/