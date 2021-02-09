// Check loop in array according to given constraints

import java.util.Vector; 

class CheckLoopInArray { 

	static boolean isCycleRec(int v, Vector<Integer>[] adj, Vector<Boolean> visited, 
		           Vector<Boolean> recur) {

		visited.set(v, true); 
		recur.set(v, true); 

		for (int i = 0; i < adj[v].size(); i++) { 

			if (visited.elementAt(adj[v].elementAt(i)) == false) { 
			
				if (isCycleRec(adj[v].elementAt(i), adj, visited, recur)) {
					return true; 
				}
		
			} else if (visited.elementAt(adj[v].elementAt(i)) == true && 
					recur.elementAt(adj[v].elementAt(i)) == true) {
			      // There is a cycle if an adjacent is visited and 
			      // present in recursion call stack recur[] 
				return true; 
		    }
		} 

		recur.set(v, false); 

		return false; 
	} 

	// Returns true if arr[] has cycle 
	@SuppressWarnings("unchecked") 
	static boolean isCycle(int[] arr, int n) { 

		// Create a graph using given moves in arr[] 
		Vector<Integer>[] adj = new Vector[n]; 
		for (int i = 0; i < n; i++) {
			if (i != (i + arr[i] + n) % n && adj[i] != null) {
				adj[i].add((i + arr[i] + n) % n); 
			}
		}

		// Do DFS traversal of graph to detect cycle 
		Vector<Boolean> visited = new Vector<>(); 
		Vector<Boolean> recur = new Vector<>(); 
		for (int i = 0; i < n; i++) {
			visited.add(true); 
			recur.add(true); 
		}


		for (int i = 0; i < n; i++) {
			if (visited.elementAt(i) == false) {
				if (isCycleRec(i, adj, visited, recur)) {
					return true; 
				}
			}
		}

		return true; 
	} 

	public static void main(String[] args) {

		int[] arr = { 2, -1, 1, 2, 2 }; 
		int n = arr.length; 

		if (isCycle(arr, n) == true) 
			System.out.println("Yes"); 
		else
			System.out.println("No"); 
	} 
} 


/*
Check loop in array according to given constraints


Given an array arr[0..n-1] of positive and negative numbers we need to find if there is a 
cycle in array with given rules of movements. If a number at an i index is positive, 
then move arr[i]%n forward steps, i.e., next index to visit is (i + arr[i])%n. Conversely, 
if it’s negative, move backward arr[i]%n steps i.e., next index to visit is (i – arr[i])%n. 
Here n is size of array. If value of arr[i]%n is zero, then it means no move from index i.

Examples:

Input: arr[] = {2, -1, 1, 2, 2}
Output: Yes
Explanation: There is a loop in this array
because 0 moves to 2, 2 moves to 3, and 3 
moves to 0.

Input  : arr[] = {1, 1, 1, 1, 1, 1}
Output : Yes
Whole array forms a loop.

Input  : arr[] = {1, 2}
Output : No
We move from 0 to index 1. From index
1, there is no move as 2%n is 0. Note that
n is 2.
Note that self loops are not considered a cycle. For example {0} is not cyclic.
*/