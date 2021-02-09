// count cyclic points in an array using Kosaraju's Algorithm

// g++ CyclicPoint.cpp && ./a.out

#include <bits/stdc++.h>
using namespace std;

// Most of the code is taken from below link
// https://www.geeksforgeeks.org/strongly-connected-components/
class Graph {
	int V;
	list<int>* adj;
	void fillOrder(int v, bool visited[],
					stack<int>& Stack);
	int DFSUtil(int v, bool visited[]);

public:
	Graph(int V);
	void addEdge(int v, int w);
	int countSCCNodes();
	Graph getTranspose();
};

Graph::Graph(int V)
{
	this->V = V;
	adj = new list<int>[V];
}

// Counts number of nodes reachable
// from v
int Graph::DFSUtil(int v, bool visited[])
{
	visited[v] = true;
	int ans = 1;
	list<int>::iterator i;
	for (i = adj[v].begin(); i != adj[v].end(); ++i)
		if (!visited[*i])
		ans += DFSUtil(*i, visited);
	return ans;
}

Graph Graph::getTranspose()
{
	Graph g(V);
	for (int v = 0; v < V; v++) {
		list<int>::iterator i;
		for (i = adj[v].begin(); i != adj[v].end(); ++i)
			g.adj[*i].push_back(v);
	}
	return g;
}

void Graph::addEdge(int v, int w) {
	adj[v].push_back(w);
}

void Graph::fillOrder(int v, bool visited[], stack<int>& Stack) {
	visited[v] = true;
	list<int>::iterator i;
	for (i = adj[v].begin(); i != adj[v].end(); ++i) {
		if (!visited[*i]) {
			fillOrder(*i, visited, Stack);
		}
	}

	Stack.push(v);
}

// This function mainly returns total count of 
// nodes in individual SCCs using Kosaraju's
// algorithm.
int Graph::countSCCNodes() {

	int res = 0;
	stack<int> Stack;
	bool* visited = new bool[V];

	for (int i = 0; i < V; i++)
		visited[i] = false;
	
	for (int i = 0; i < V; i++)
		if (visited[i] == false)
			fillOrder(i, visited, Stack);
	
	Graph gr = getTranspose();
	for (int i = 0; i < V; i++)
		visited[i] = false;
	
	while (Stack.empty() == false) {
		int v = Stack.top();
		Stack.pop();
		
		if (visited[v] == false) {
			int ans = gr.DFSUtil(v, visited);
			if (ans > 1)
				res += ans;
		}
	}

	return res;
}

// Returns count of cyclic elements in arr[]
int countCyclic(int arr[], int n) {
	int res = 0;
	// Create a graph of array elements
	Graph g(n + 1);
	for (int i = 1; i <= n; i++) {
		int x = arr[i-1];
		// If i + arr[i-1] jumps beyond last element, we take mod considering cyclic array
		int v = (x + i) % n + 1;
		// If there is a self loop, we increment count of cyclic points.
		if (i == v) {
			res++;
		}
		g.addEdge(i, v);
	}
	// Add nodes of strongly connected components of size more than 1.
	res += g.countSCCNodes();
	return res;
}

int main() {
	int arr[] = {1, 1, 1, 1};
	int n = sizeof(arr)/sizeof(arr[0]);
	cout << countCyclic(arr, n)<<endl;
	return 0;
}


/*
Number of cyclic elements in an array where we can jump according to value


Given a array arr[] of n integers. For every value arr[i], we can move to arr[i] + 1 clockwise 
considering array elements in cycle. We need to count cyclic elements in the array. An element 
is cyclic if starting from it and moving to arr[i] + 1 leads to same element.

Examples:  

Input : arr[] = {1, 1, 1, 1}
Output : 4
All 4 elements are cyclic elements.
1 -> 3 -> 1
2 -> 4 -> 2
3 -> 1 -> 3
4 -> 2 -> 4

Input : arr[] = {3, 0, 0, 0}
Output : 1
There is one cyclic point 1,
1 -> 1
The path covered starting from 2 is
2 -> 3 -> 4 -> 1 -> 1.

The path covered starting from 3 is
2 -> 3 -> 4 -> 1 -> 1.

The path covered starting from 4 is
4 -> 1 -> 1*/