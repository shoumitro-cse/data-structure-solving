//Iterative Depth First Traversal of Graph

//javac -d classes DepthFirstTraversalGraphIterative.java  && cd classes && java DepthFirstTraversalGraphIterative && cd ..

import java.util.*; 

public class DepthFirstTraversalGraphIterative 
{ 
	// This class represents a directed graph using adjacency 
	// list representation 
	static class Graph 
	{ 
		int V; //Number of Vertices 
		
		LinkedList<Integer>[] adj; // adjacency lists 
		
		//Constructor 
		Graph(int V) {

			this.V = V; 
			adj = new LinkedList[V]; // V=5
			
			for (int i = 0; i < adj.length; i++) {// adj.length=5
				adj[i] = new LinkedList<Integer>(); 
			}
			
		} 
		
		//To add an edge to graph 
		void addEdge(int v, int w) { 
			adj[v].add(w); // Add w to v’s list. 
		} 
		


/*		Complexity Analysis:
			1. Time complexity: O(V + E), where V is the number of vertices and E is 
			   the number of edges in the graph.
			2. Space Complexity: O(V). Since an extra visited array is needed of size V.*/
		void DFS(int s) { 
			// Initially mark all vertices as not visited 
			Vector<Boolean> visited = new Vector<Boolean>(V); 

			for (int i = 0; i < V; i++) {
				visited.add(false); 
			}
			// Create a stack for DFS 
			Stack<Integer> stack = new Stack<>(); 
			// Push the current source node 
			stack.push(s); 
			
			while(stack.empty() == false) 
			{ 
				// Pop a vertex from stack and print it 
				s = stack.pop(); 
				
				if(visited.get(s) == false) { 
					System.out.print(s + " "); 
					visited.set(s, true); 
				} 
				
				Iterator<Integer> itr = adj[s].iterator(); 
				
				while (itr.hasNext()) 
				{ 
					int v = itr.next(); 
					if(!visited.get(v)) {
						stack.push(v); 
					}
				} 
				
			} 
		} 
	} 
	
	// Driver program to test methods of graph class 
	public static void main(String[] args) 
	{ 
		// Total 5 vertices in graph 
		Graph g = new Graph(5); 
		
		g.addEdge(1, 0); 
		g.addEdge(0, 2); 
		g.addEdge(2, 1); 
		g.addEdge(0, 3); 
		g.addEdge(1, 4); 

/*		0<-----1------------>4
		|\    /^
		| \  /
		|  \/ 
		|  /\
		v /  v
		2    3       

		adj[0] = 2, 3
		adj[1] = 0, 4
		adj[2] = 1
		adj[3] = 
		adj[4] = */
			
		System.out.println("Following is the Depth First Traversal"); 
		g.DFS(0); 
		System.out.println(); 
	} 
} 



/*Algorithm:
1. Created a stack of nodes and visited array.
2. Insert the root in the stack.
3. Run a loop till the stack is not empty.
4. Pop the element from the stack and print the element.
5. For every adjacent and unvsisted node of current node, mark the node and insert it in the stack.*/