// Transpose graph

//javac -d classes TransposeGraph.java  && cd classes && java TransposeGraph && cd ..

import java.util.*; 
import java.lang.*; 
import java.io.*; 

class Graph { 
	// Total number of vertices 
	private static int vertices = 5; 
	// Find transpose of graph represented by adj 
	private static ArrayList<Integer>[] adj = new ArrayList[vertices]; 
	// Store the transpose of graph represented by tr 
	private static ArrayList<Integer>[] tr = new ArrayList[vertices]; 
	// Function to add an edge from source vertex u to 
	// destination vertex v, if choice is false the edge is added 
	// to adj otherwise the edge is added to tr 
    @SuppressWarnings("unchecked") 
    Graph(int v) {
    	this.vertices=v;
		for(int i = 0; i < vertices; i++) { 
			this.adj[i] = new ArrayList<Integer>(); 
			this.tr[i] = new ArrayList<Integer>(); 
		} 
    }

	public static void addedge(int u, int v, boolean choice) { 
		if(!choice) 
			adj[u].add(v); 
		else
			tr[u].add(v); 
	} 

	// Function to print the graph representation 
	public static void printGraph() { 
		for(int i = 0; i < vertices; i++) { 
			System.out.print(i + "--> "); 
			for(int j = 0; j < tr[i].size(); j++) {
				System.out.print(tr[i].get(j) + " "); 
			}
			System.out.println(); 
		} 
	} 

	// Function to print the transpose of 
	// the graph represented as adj and store it in tr 
	public static void makeTranspose() { 
		// Traverse the graph and for each edge u, v in graph add the edge v, u in transpose 
		for(int i = 0; i < vertices; i++) {
			for(int j = 0; j < adj[i].size(); j++) {
				addedge(adj[i].get(j), i, true); 
			}
		}
	} 

} 

class TransposeGraph {

	public static void main (String[] args) throws java.lang.Exception {

        Graph graph = new Graph(5); 

		graph.addedge(0, 1, false); 
		graph.addedge(0, 4, false); 
		graph.addedge(0, 3, false); 
		graph.addedge(2, 0, false); 
		graph.addedge(3, 2, false); 
		graph.addedge(4, 1, false); 
		graph.addedge(4, 3, false); 
		
		// Finding transpose of the graph 
		graph.makeTranspose(); 
		
		// Printing the graph representation 
		graph.printGraph(); 
	} 
}
