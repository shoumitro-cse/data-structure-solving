// Maximum Bipartite Matching

// javac -d classes  BipartiteMatching.java  && cd classes && java BipartiteMatching && cd ..

import java.util.*; 
import java.lang.*; 
import java.io.*; 

class BipartiteMatching 
{ 
	// M is number of applicants 
	// and N is number of jobs 
	static final int M = 6; 
	static final int N = 6; 

	// A DFS based recursive function that 
	// returns true if a matching for 
	// vertex u is possible 
	boolean bpm(boolean bpGraph[][], int u, boolean seen[], int matchR[]) {

		// Try every job one by one 
		for (int v = 0; v < N; v++) { 
			// If applicant u is interested in job v and v is not visited 
			if (bpGraph[u][v] && !seen[v]) { 
				// Mark v as visited 
				seen[v] = true; 

				if (matchR[v] < 0 || bpm(bpGraph, matchR[v], seen, matchR)) { 
					matchR[v] = u; 
					return true; 
				} 
			} 
		} 

		return false; 
	} 


	// Returns maximum number of matching from M to N 
	int maxBPM(boolean bpGraph[][]) { 

		int matchR[] = new int[N]; 
		// Initially all jobs are available 
		for(int i = 0; i < N; ++i) {
			matchR[i] = -1; 
		}

		// Count of jobs assigned to applicants 
		int result = 0; 
		for (int u = 0; u < M; u++) { 
			// Mark all jobs as not seen for next applicant. 
			boolean seen[] =new boolean[N] ; 
			for(int i = 0; i < N; ++i) {
				seen[i] = false; 
			}

			// Find if the applicant 'u' can get a job 
			if (bpm(bpGraph, u, seen, matchR)) {
				result++; 
			}
		} 

		return result; 
	} 

	// Driver Code 
	public static void main (String[] args) throws java.lang.Exception {

		// Let us create a bpGraph shown in the above example 
		boolean bpGraph[][] = new boolean[][]
		                  { 
							{false, true, true, 
							false, false, false}, 
							{true, false, false, 
							true, false, false}, 
							{false, false, true, 
							false, false, false}, 
							{false, false, true, 
							true, false, false}, 
							{false, false, false, 
							false, false, false}, 
							{false, false, false, 
							false, false, true}
						 };

		BipartiteMatching m = new BipartiteMatching(); 
		System.out.println( "Maximum number of applicants that can"+ 
							" get job is "+m.maxBPM(bpGraph)); 
	} 
} 

/*
Maximum Bipartite Matching


A matching in a Bipartite Graph is a set of the edges chosen in such a way that no two edges 
share an endpoint. A maximum matching is a matching of maximum size (maximum number of edges). 
In a maximum matching, if any edge is added to it, it is no longer a matching. There can be more 
than one maximum matchings for a given Bipartite Graph.

Why do we care?
There are many real world problems that can be formed as Bipartite Matching. For example, 
consider the following problem:
There are M job applicants and N jobs. Each applicant has a subset of jobs that he/she is 
interested in. Each job opening can only accept one applicant and a job applicant can be 
appointed for only one job. Find an assignment of jobs to applicants in such that as many 
applicants as possible get jobs.

(pic)

*/