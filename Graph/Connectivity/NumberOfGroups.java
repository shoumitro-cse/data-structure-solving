// Number of groups formed in a graph of friends


import java.util.*;
import java.io.*;

class Graph {

	// No. of vertices
	private int V; 

	// Array of lists for Adjacency
	// List Representation
	private LinkedList<Integer> adj[];

	// Constructor
	@SuppressWarnings("unchecked") 
	Graph(int v) {
		V = v;
		adj = new LinkedList[V];
		for(int i = 0; i < V; i++) {
			adj[i] = new LinkedList();
		}
	}

	// Adds a relation as a two way edge of undirected graph.
	public void addRelation(int v, int w) {
		// Since indexing is 0 based, reducing edge numbers by 1.
		v--;
		w--;
		adj[v].add(w);
		adj[w].add(v);
	}

	// Returns count of not visited nodes reachable from v using DFS.
	int countUtil(int v, boolean visited[])
	{
		int count = 1;
		visited[v] = true;
		
		// Recur for all the vertices adjacent 
		// to this vertex
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext())
		{
			int n = i.next();
			if (!visited[n])
				count = count + countUtil(n, visited);
		}
		return count;
	}

	// A DFS based function to Count number of
	// existing groups and number of new groups
	// that can be formed using a member of
	// every group.
	void countGroups() {
		// Mark all the vertices as not visited(set as false by default in java)
		boolean visited[] = new boolean[V];
		int existing_groups = 0, new_groups = 1;
		
		for(int i = 0; i < V; i++) {
			// If not in any group.
			if (visited[i] == false) {
				existing_groups++;
				// Number of new groups that can be formed.
				new_groups = new_groups * countUtil(i, visited);
			}
		}

		if (existing_groups == 1) {
			new_groups = 0;
		}
			
		System.out.println("No. of existing groups are " + existing_groups);
		System.out.println("No. of new groups that can be formed are " + new_groups);
	}

}


class NumberOfGroups {
	// Driver code 
	public static void main(String[] args) {
		int n = 6;
		// Create a graph given in the above diagram
		Graph g = new Graph(n); // total 6 people
		g.addRelation(1, 2); // 1 and 2 are friends
		g.addRelation(3, 4); // 3 and 4 are friends
		g.addRelation(5, 6); // 5 and 6 are friends

		g.countGroups();
	}
}



/*
Number of groups formed in a graph of friends


Given n friends and their friendship relations, find the total number of groups that exist. And the number of ways of new groups that can be formed consisting of people from every existing group. 
If no relation is given for any person then that person has no group and singularly forms a group. If a is a friend of b and b is a friend of c, then a b and c form a group.

Examples:  

Input : Number of people = 6 
        Relations : 1 - 2, 3 - 4 
                    and 5 - 6 
Output: Number of existing Groups = 3
        Number of new groups that can
        be formed = 8
Explanation: The existing groups are 
(1, 2), (3, 4), (5, 6). The new 8 groups 
that can be formed by considering a 
member of every group are (1, 3, 5), 
(1, 3, 6), (1, 4, 5), (1, 4, 6), (2, 
3, 5), (2, 3, 6), (2, 4, 5) and (2, 4,
6). 

Input:  Number of people = 6 
        Relations : 1 - 2 and 2 - 3 
Output: Number of existing Groups = 2
        Number of new groups that can
        be formed = 3
Explanation: The existing groups are 
(1, 2, 3) and (4). The new groups that 
can be formed by considering a member
of every group are (1, 4), (2, 4), (3, 4).*/