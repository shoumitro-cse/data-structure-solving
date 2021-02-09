// Minimize the number of weakly connected nodes

// g++ weakly_connected_nodes.cpp && ./a.out

#include <bits/stdc++.h>
using namespace std;

// Set of nodes which are traversed
// in each launch of the DFS
set<int> node;
vector<int> Graph[10001];

// Function traversing the graph using DFS
// approach and updating the set of nodes
void dfs(bool visit[], int src) {

	visit[src] = true;
	node.insert(src);
	int len = Graph[src].size();
	
	for (int i = 0; i < len; i++) 
		if (!visit[Graph[src][i]])	 
			dfs(visit, Graph[src][i]);
}

// building a undirected graph
void buildGraph(int x[], int y[], int len){

	for (int i = 0; i < len; i++) {
		int p = x[i];
		int q = y[i];
		Graph[p].push_back(q);
		Graph[q].push_back(p);
	}
}

// computes the minimum number of disconnected
// components when a bi-directed graph is 
// converted to a undirected graph
int compute(int n) {

	// Declaring and initializing a visited array
	bool visit[n + 5];
	memset(visit, false, sizeof(visit));
	
	int number_of_nodes = 0;

	// We check if each node is visited once or not
	for (int i = 0; i < n; i++) {
		// We only launch DFS from a node iff it is unvisited.
		if (!visit[i]) {
			// Clearing the set of nodes on every relaunch of DFS
			node.clear();
			// relaunching DFS from an unvisited node.
			dfs(visit, i);
			
			int count = 0;		 
			for (auto it = node.begin(); it != node.end(); ++it) {
				count += Graph[(*it)].size();
			}
		
			count /= 2;	 
			if (count == node.size() - 1) {
			   number_of_nodes++;
			}

		}
	}

	return number_of_nodes;
}


int main() {

	int n = 6, m = 4;
	int x[m + 5] = {1, 1, 4, 4};
	int y[m + 5] = {2, 3, 5, 6};
	
    /*For given x and y above, graph is as below :
        1-----2         4------5
        |               |
        |               |
        |               |
        3               6
         
        // Note : This code will work for connected graph also as :
        1-----2
        |     | \
        |     |  \
        |     |   \
        3-----4----5
    */
	
	// Building graph in the form of a adjacency list
	buildGraph(x, y, n);
	cout << compute(n) << " weakly connected nodes"<<endl;
	
	return 0;
}

/*

Minimize the number of weakly connected nodes

Given an undirected graph, task is to find the minimum number of weakly connected nodes after converting this graph into directed one. 

Weakly Connected Nodes : Nodes which are having 0 indegree(number of incoming edges).

Prerequisite : BFS traversal

Examples :  

Input : 4 4 
        0 1
        1 2
        2 3
        3 0
Output : 0 disconnected components

Input : 6 5
       1 2
       2 3
       4 5
       4 6
       5 6
Output : 1 disconnected components


Explanation : (pic) 

*/