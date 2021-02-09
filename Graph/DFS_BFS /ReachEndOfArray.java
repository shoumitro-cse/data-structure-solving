// Minimum steps to reach end of array under constraints

// javac -d classes ReachEndOfArray.java  && cd classes && java ReachEndOfArray && cd ..

import java.util.*; 

class ReachEndOfArray { 

	// Method returns minimum step to reach end of array 
	static int getMinStepToReachEnd(int arr[], int N) {

		// visit boolean array checks whether current index is previously visited 
		boolean [] visit = new boolean[N]; 

		// distance array stores distance of current index from starting index 
		int [] distance = new int[N]; 

		// digit vector stores indices where a particular number resides 
        @SuppressWarnings("unchecked")
		Vector<Integer> [] digit = new Vector[10]; 
		for(int i = 0; i < 10; i++) 
			digit[i] = new Vector<>(); 

		// In starting all index are unvisited 
		for(int i = 0; i < N; i++) 
			visit[i] = false; 

		// storing indices of each number 
		// in digit vector 
		for (int i = 1; i < N; i++) 
			digit[arr[i]].add(i); 

		// for starting index distance will be zero 
		distance[0] = 0; 
		visit[0] = true; 

		// Creating a queue and inserting index 0. 
		Queue<Integer> q = new LinkedList<>(); 
		q.add(0); 

		// loop untill queue in not empty 
		while(!q.isEmpty()) {

			// Get an item from queue, q. 
			int idx = q.remove(); 

			// If we reached to last index break from loop 
			if (idx == N - 1) 
				break; 

			// Find value of dequeued index 
			int d = arr[idx]; 

			// looping for all indices with value as d. 
			for (int i = 0; i < digit[d].size(); i++) { 
				int nextidx = digit[d].get(i); 
				if (!visit[nextidx]) { 
					visit[nextidx] = true; 
					q.add(nextidx); 

					// update the distance of this nextidx 
					distance[nextidx] = distance[idx] + 1; 
				} 
			} 

			// clear all indices for digit d, 
			// because all of them are processed 
			digit[d].clear(); 

			// checking condition for previous index 
			if (idx-1 >= 0 && !visit[idx-1]) { 
				visit[idx-1] = true; 
				q.add(idx-1); 
				distance[idx-1] = distance[idx] + 1; 
			} 

			// checking condition for next index 
			if (idx + 1 < N && !visit[idx + 1]) { 
				visit[idx + 1] = true; 
				q.add(idx + 1); 
				distance[idx + 1] = distance[idx] + 1; 
			} 

		} 

		// N-1 th position has the final result 
		return distance[N-1]; 
	} 

	public static void main(String []args) { 
		int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 5, 4, 3, 6, 0, 1, 2, 3, 4, 5, 7}; 
		int N = arr.length; 
		System.out.println(getMinStepToReachEnd(arr, N)); 
	} 

} 


/*
Minimum steps to reach end of array under constraints


Given an array containing one digit numbers only, assuming we are standing at first index, 
we need to reach to end of array using minimum number of steps where in one step, we can jump 
to neighbor indices or can jump to a position with same value.

In other words, if we are at index i, then in one step you can reach to, arr[i-1] or arr[i+1] or 
arr[K] such that arr[K] = arr[i] (value of arr[K] is same as arr[i])

Examples:

Input : arr[] = {5, 4, 2, 5, 0}
Output : 2
Explanation : Total 2 step required.
We start from 5(0), in first step jump to next 5 
and in second step we move to value 0 (End of arr[]).

Input  : arr[] = [0, 1, 2, 3, 4, 5, 6, 7, 5, 4,
                 3, 6, 0, 1, 2, 3, 4, 5, 7]
Output : 5
Explanation : Total 5 step required.
0(0) -> 0(12) -> 6(11) -> 6(6) -> 7(7) -> (18)                                                          
(inside parenthesis indices are shown)
*/