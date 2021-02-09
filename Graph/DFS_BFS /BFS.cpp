// BFS using STL for competitive coding

// A Quick implementation of BFS using vectors and queue

// g++ BFS.cpp && ./a.out

#include <bits/stdc++.h> 
#define pb push_back

using namespace std; 

vector<bool> v; 
vector<vector<int>> g; 


void edge(int a, int b) { 
	// for undirected graph add this line 
	g[a].pb(b); 
    // g[b].pb(a); 
} 


void bfs(int u) {

	queue<int> q; 
	q.push(u); 
	v[u] = true; 

	while (!q.empty()) { 
		int f = q.front(); q.pop(); 
		cout << f << " "; 
		// Enqueue all adjacent of f and mark them visited 
		for (auto i = g[f].begin(); i != g[f].end(); i++) { 
		   if (!v[*i]) { 
			 q.push(*i); 
			 v[*i] = true; 
		   } 
		} 
	} 

} 



int main() {

	int n, e; 
	cin >> n >> e; 

	v.assign(n, false); 
	g.assign(n, vector<int>()); 

	int a, b; 
	for (int i = 0; i < e; i++) { 
	   cin >> a >> b; 
	   edge(a, b); 
	} 

	for (int i = 0; i < n; i++) { 
	  if (!v[i]) {
		bfs(i); 
	  }
	} 

    cout<<endl;
	
	return 0; 
} 



/*

input:

5 2
0 1
0 2




input:

5 4
0 1
0 2
1 3
1 4
0 1 2 3 4 




BFS using STL for competitive coding


A STL based simple implementation of BFS using queue and vector in STL. The adjacency list is represented using vectors of vector.

In BFS, we start with a node.
1) Create a queue and enqueue source into it. 
   Mark source as visited.
2) While queue is not empty, do following
    a) Dequeue a vertex from queue. Let this 
       be f.
    b) Print f
    c) Enqueue all not yet visited adjacent
       of f and mark them visited.

*/

