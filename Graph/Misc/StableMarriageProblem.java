// Stable Marriage Problem

import java.util.*; 

class StableMarriageProblem { 

	// Number of Men or Women 
	static int N = 4; 

	// This function returns true if woman 'w' prefers man 'm1' over man 'm' 
	static boolean wPrefersM1OverM(int prefer[][], int w, int m, int m1) { 

		for (int i = 0; i < N; i++) { 

			if (prefer[w][i] == m1) 
				return true; 
			if (prefer[w][i] == m) 
			  return false; 
		} 

		return false; 
	} 


	static void stableMarriage(int prefer[][]) { 

		int wPartner[] = new int[N]; 

		boolean mFree[] = new boolean[N]; 

		// Initialize all men and women as free 
		Arrays.fill(wPartner, -1); 
		int freeCount = N; 

		// While there are free men 
		while (freeCount > 0) { 

			int m; 
			for (m = 0; m < N; m++) 
				if (mFree[m] == false) 
					break; 

			for (int i = 0; i < N && mFree[m] == false; i++) { 
				int w = prefer[m][i]; 

				if (wPartner[w - N] == -1) { 
					wPartner[w - N] = m; 
					mFree[m] = true; 
					freeCount--; 
				} else { // If w is not free 
					// Find current engagement of w 
					int m1 = wPartner[w - N]; 
					if (wPrefersM1OverM(prefer, w, m, m1) == false) { 
						wPartner[w - N] = m; 
						mFree[m] = true; 
						mFree[m1] = false; 
					} 
				} // End of Else 
			} // End of the for loop that goes 
			// to all women in m's list 
		} // End of main while loop 


		// Print the solution 
		System.out.println("Woman Man"); 
		for (int i = 0; i < N; i++) { 
			System.out.print(" "); 
			System.out.println(i + N + "	 " + wPartner[i]); 
		} 
	} 

	// Driver Code 
	public static void main(String[] args) {

		int prefer[][] = new int[][]{
			                         {7, 5, 6, 4}, 
									 {5, 4, 6, 7}, 
									 {4, 5, 6, 7}, 
									 {4, 5, 6, 7}, 
									 {0, 1, 2, 3}, 
									 {0, 1, 2, 3}, 
									 {0, 1, 2, 3}, 
									 {0, 1, 2, 3}
									}; 
		stableMarriage(prefer); 
	} 
} 


/*
Stable Marriage Problem


The Stable Marriage Problem states that given N men and N women, where each person has ranked all members of the opposite sex in order of preference, marry the men and women together such that there are no two people of opposite sex who would both rather have each other than their current partners. If there are no such people, all the marriages are “stable” (Source Wiki).

Consider the following example.

Let there be two men m1 and m2 and two women w1 and w2.
Let m1‘s list of preferences be {w1, w2}
Let m2‘s list of preferences be {w1, w2}
Let w1‘s list of preferences be {m1, m2}
Let w2‘s list of preferences be {m1, m2}

The matching { {m1, w2}, {w1, m2} } is not stable because m1 and w1 would prefer each other over their assigned partners. The matching {m1, w1} and {m2, w2} is stable because there are no two people of opposite sex that would prefer each other over their assigned partners.

It is always possible to form stable marriages from lists of preferences (See references for proof). Following is Gale–Shapley algorithm to find a stable matching:
The idea is to iterate through all free men while there is any free man available. Every free man goes to all women in his preference list according to the order. For every woman he goes to, he checks if the woman is free, if yes, they both become engaged. If the woman is not free, then the woman chooses either says no to him or dumps her current engagement according to her preference list. So an engagement done once can be broken if a woman gets better option. Time Complexity of Gale-Shapley Algorithm is O(n2).
Following is complete algorithm from Wiki*/