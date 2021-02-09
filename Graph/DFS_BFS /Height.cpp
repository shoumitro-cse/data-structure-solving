// C++ program to find root which gives minimum height to tree

//  g++ Height.cpp && ./a.out

#include <bits/stdc++.h>
using namespace std;

// This class represents a undirected graph using adjacency list
// representation
class Graph {

  public:
	int V; // No. of vertices

	// Pointer to an array containing adjacency lists
	list<int> *adj;

	// Vector which stores degree of all vertices
	vector<int> degree;

	Graph(int V);		 // Constructor
	void addEdge(int v, int w); // To add an edge

	// function to get roots which give minimum height
	vector<int> rootForMinimumHeight();
};

// Constructor of graph, initializes adjacency list and degree vector
Graph::Graph(int V) {
	this->V = V;
	adj = new list<int>[V];
	for (int i = 0; i < V; i++) {
		degree.push_back(0);
	}
}

// addEdge method adds vertex to adjacency list and increases degree by 1
void Graph::addEdge(int v, int w) {
	adj[v].push_back(w); // Add w to v’s list
	adj[w].push_back(v); // Add v to w’s list

	degree[v]++;		 // increment degree of v by 1
	degree[w]++;		 // increment degree of w by 1
}

// Method to return roots which gives minimum height to tree
vector<int> Graph::rootForMinimumHeight() {

	queue<int> q;

	// first enqueue all leaf nodes in queue
	for (int i = 0; i < V; i++) {
		if (degree[i] == 1) {
			q.push(i);
			// cout<<i<<endl;
		}
	}

	// loop untill total vertex remains less than 2
	while (V > 2) {

		int popEle = q.size();
		V -= popEle;	 // popEle number of vertices will be popped
		
		for (int i = 0; i < popEle; i++) {
			int t = q.front(); q.pop();
			// for each neighbour, decrease its degree and if it become leaf, insert into queue
			for (auto j = adj[t].begin(); j != adj[t].end(); j++) {
			   degree[*j]--;
			   if (degree[*j] == 1) {
				 q.push(*j);
		         // cout<<*j<<endl;
			   }
			}
		}
	}

	// copying the result from queue to result vector
	vector<int> res;
	while (!q.empty()) {
		res.push_back(q.front());
		q.pop();
	}

	return res;
}


// Driver code
int main() {

	Graph g(6);
	
	g.addEdge(0, 3);
	g.addEdge(1, 3);
	g.addEdge(2, 3);
	g.addEdge(4, 3);
	g.addEdge(5, 4);

	// Function Call
	vector<int> res = g.rootForMinimumHeight();
	for (int i = 0; i < res.size(); i++) {
	  cout << res[i] << " ";
	}

	cout << endl;
}
