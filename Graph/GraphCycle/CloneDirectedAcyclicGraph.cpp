// Clone a Directed Acyclic Graph

// g++ CloneDirectedAcyclicGraph.cpp && ./a.out

#include <bits/stdc++.h>
using namespace std;

// Class to create a new graph node
class Node {
	public:
		int key;
		vector<Node *> adj;
		// key is the value of the node adj will be holding a dynamic
		// list of all Node type neighboring nodes
		Node(int key) {
			this->key = key; 
		}
};

// Function to print a graph, depth-wise, recursively
void printGraph(Node *startNode, vector<bool> &visited) {
	
	// Visit only those nodes who have any neighboring nodes to be traversed
	if (!startNode->adj.empty()) {
		
		for(auto node : startNode->adj) {
		
			if (!visited[startNode->key]) {
				
				// cout<<"edge "<<startNode<<" - "<<node<< " : "<<startNode->key<< " - "<<node->key<< endl;
				cout<<"edge "<<" : "<<startNode->key<< " - "<<node->key<< endl;
				
				if (!visited[node->key]) {
					printGraph(node, visited);
					visited[node->key] = true;
				}
			}
		}
	}
}


Node *cloneGraph(Node *oldSource, Node *newSource, vector<bool> &visited) {
	
	Node *clone = NULL;
	
	if (!visited[oldSource->key] && !oldSource->adj.empty()) {
		
		for(auto old : oldSource->adj) {	
			// Below check is for backtracking, so new nodes don't get initialized everytime
			if (clone == NULL || (clone != NULL && clone->key != old->key)) {
				clone = new Node(old->key);
			}
				
			newSource->adj.push_back(clone);
			cloneGraph(old, clone, visited);

			visited[old->key] = true;
		}
	}

	return newSource;
}


int main() {

	Node *n0 = new Node(0);
	Node *n1 = new Node(1);
	Node *n2 = new Node(2);
	Node *n3 = new Node(3);
	Node *n4 = new Node(4);
	
	n0->adj.push_back(n1);
	n0->adj.push_back(n2);
	n1->adj.push_back(n2);
	n1->adj.push_back(n3);
	n1->adj.push_back(n4);
	n2->adj.push_back(n3);
	n3->adj.push_back(n4);
	

/*	Input :
 
	0 - - - > 1 - - - -> 4
	|        /  \        ^   
	|       /    \       |  
	|      /      \      |
	|     /        \     |  
	|    /          \    |
	|   /            \   |
	v  v              v  |
	2 - - - - - - - - -> 3*/


	// Flag to check if a node is already visited.
	// Stops indefinite looping during recursion
	vector<bool> visited(5, false);
	cout << "Graph Before Cloning:-\n";
	printGraph(n0, visited);
	
	visited = { false, false, false, false, false };
	
	cout << "\nGraph Before Starts:-\n";
	Node *clonedGraphHead = cloneGraph(n0, new Node(n0->key), visited);
	cout << "Cloning Process Completes.\n";
	
	visited = { false, false, false, false, false };
	cout << "\nGraph After Cloning:-\n";
	printGraph(clonedGraphHead, visited);
	
	return 0;
}




/*
Clone a Directed Acyclic Graph


A directed acyclic graph (DAG) is a graph which doesn’t contain a cycle and 
has directed edges. We are given a DAG, we need to clone it, i.e., create another 
graph that has copy of its vertices and edges connecting them.

Examples:  

Input :
 
0 - - - > 1 - - - -> 4
|        /  \        ^   
|       /    \       |  
|      /      \      |
|     /        \     |  
|    /          \    |
|   /            \   |
v  v              v  |
2 - - - - - - - - -> 3


Output : Printing the output of the cloned graph gives: 
0-1
1-2
2-3
3-4
1-3
1-4
0-2
*/