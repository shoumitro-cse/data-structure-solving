// Traveling Salesman Problem (TSP) Implementation

// javac -d classes  TSP.java  && cd classes && java TSP && cd ..

import java.util.*;

class TSP {
	
	static int V = 4;

	// implementation of traveling Salesman Problem
	static int travllingSalesmanProblem(int graph[][], int s) {

		// store all vertex apart from source vertex
		ArrayList<Integer> vertex = new ArrayList<Integer>();

		for (int i = 0; i < V; i++) {
			if (i != s) {
			   vertex.add(i);
			}
		}

		// store minimum weight Hamiltonian Cycle.
		int min_path = Integer.MAX_VALUE;

		do {
			// store current Path weight(cost)
			int current_pathweight = 0;
			// compute current path weight
			int k = s;
			for (int i = 0; i < vertex.size(); i++) {
				current_pathweight += graph[k][vertex.get(i)];
				k = vertex.get(i);
			}

			current_pathweight += graph[k][s];
			// update minimum
			min_path = Math.min(min_path, current_pathweight);

		} while (findNextPermutation(vertex));

		return min_path;
	}

	// Function to swap the data present in the left and right indices 
	public static ArrayList<Integer> swap(ArrayList<Integer> data, int left, int right) { 
		// Swap the data 
		int temp = data.get(left); 
		data.set(left, data.get(right)); 
		data.set(right, temp); 

		// Return the updated array 
		return data; 
	} 

	// Function to reverse the sub-array starting from left to the right both inclusive 
	public static ArrayList<Integer> reverse(ArrayList<Integer> data, int left, int right) { 
		
		// Reverse the sub-array 
		while (left < right) { 
			int temp = data.get(left); 
			data.set(left++, data.get(right)); 
			data.set(right--, temp); 
		} 

		// Return the updated array 
		return data; 
	} 

	// Function to find the next permutation of the given integer array 
	public static boolean findNextPermutation(ArrayList<Integer> data) { 
		// If the given dataset is empty 
		// or contains only one element 
		// next_permutation is not possible 
		if (data.size() <= 1) 
			return false; 

		int last = data.size() - 2; 

		// find the longest non-increasing 
		// suffix and find the pivot 
		while (last >= 0) { 
			if (data.get(last) < data.get(last + 1)) { 
			  break; 
			} 
			last--; 
		} 

		// If there is no increasing pair 
		// there is no higher order permutation 
		if (last < 0) 
			return false; 

		int nextGreater = data.size() - 1; 

		// Find the rightmost successor to the pivot 
		for (int i = data.size() - 1; i > last; i--) { 
			if (data.get(i) > data.get(last)) { 
			  nextGreater = i; 
			  break; 
			} 
		} 

		// Swap the successor and the pivot 
		data = swap(data, nextGreater, last); 
		
		// Reverse the suffix 
		data = reverse(data, last + 1, data.size() - 1); 
		
		// Return true as the next_permutation is done 
		return true; 
	} 

	// Driver Code
	public static void main(String args[]) {

		// matrix representation of graph
		int graph[][] = {
			              {0, 10, 15, 20},
						  {10, 0, 35, 25},
						  {15, 35, 0, 30},
						  {20, 25, 30, 0}
						};
		int s = 0;
		System.out.println(
		travllingSalesmanProblem(graph, s));
	}
}


/*
Traveling Salesman Problem (TSP) Implementation



Travelling Salesman Problem (TSP) : Given a set of cities and distances between every pair of 
cities, the problem is to find the shortest possible route that visits every city exactly once 
and returns to the starting point. 

Note the difference between Hamiltonian Cycle and TSP. The Hamiltonian cycle problem is to find 
if there exists a tour that visits every city exactly once. Here we know that Hamiltonian Tour 
exists (because the graph is complete) and in fact, many such tours exist, the problem is to find 
a minimum weight Hamiltonian Cycle. 

For example, consider the graph shown in the figure on the right side. A TSP tour in the graph 
is 1-2-4-3-1. The cost of the tour is 10+25+30+15 which is 80.
The problem is a famous NP-hard problem. There is no polynomial-time known solution for this 
problem. 
 



Examples: (pic)

Output of Given Graph:
minimum weight Hamiltonian Cycle :
10 + 25 + 30 + 15 := 80*/