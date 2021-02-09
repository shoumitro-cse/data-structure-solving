// A Peterson Graph Problem

// javac -d classes PetersonGraphProblem.java  && cd classes && java PetersonGraphProblem && cd ..

class PetersonGraphProblem {

	// path to be checked 
	static char [] S = new char[100005];
	
	// adjacency matrix. 
	static boolean [][] adj = new boolean[10][10]; 
	
	// resulted path - way 
	// static char[] result = new char[100005]; 
	static String result = "";
	
	// we are applying breadth first search here 
	static boolean findthepath(char[] S, int v) { 

		// result[0] = (char) (v + '0'); 
		result += "start-->"+v+"-->";

		for (int i = 1; i<(int)S.length; i++) { 
			
			// first traverse the outer graph 
			if (adj[v][S[i]-'A'] || adj[S[i]-'A'][v]) { 
			   v = S[i]-'A'; 
			} else if (adj[v][S[i] - 'A' + 5] || adj[S[i] - 'A' + 5][v]) { 
			   // then traverse the inner graph 
			   v = S[i]-'A' + 5; 
			} else {
			    // if the condition failed to satisfy return false 
			   return false;
			}
	
			// result[i] = (char) (v + '0'); 
		    result += v+"-->";
		} 
		
		result +="end";

		return true; 
	} 
	
	public static void main(String[] args) { 

		// here we have used adjacency matrix to make connections between the connected nodes 
		adj[0][1] = adj[1][2] = adj[2][3] = adj[3][4] = 
		adj[4][0] = adj[0][5] = adj[1][6] = adj[2][7] = 
		adj[3][8] = adj[4][9] = adj[5][7] = adj[7][9] = 
		adj[9][6] = adj[6][8] = adj[8][5] = true; 
		
		// path to be checked 
		// char S[] = "ABB".toCharArray(); 
		char S[] = "ABBECCD".toCharArray(); 
		
		if (findthepath(S, S[0]-'A') || findthepath(S, S[0]-'A' + 5)) { 
		   System.out.println(); 
		   System.out.println(result); 
		} else { 
		   System.out.println("-1"); 
		} 

	} 
} 


/*
A Peterson Graph Problem


The following graph G is called a Petersen graph and its vertices have been numbered 
from 0 to 9. Some letters have also been assigned to vertices of G, as can be seen from the 
following picture:(pic)

Let’s consider a walk W in graph G, which consists of L vertices W1, W2, …, WL. A string S of L 
letters 'A' – 'E' is realized by walk W if the sequence of letters written along W is equal to S. 
Vertices can be visited multiple times while walking along W.

For example, S = 'ABBECCD' is realized by W = (0, 1, 6, 9, 7, 2, 3). Determine whether there is a 
walk W which realizes a given string S in graph G, and if so then find the lexicographically least 
such walk. The only line of input contains one string S. If there is no walk W which realizes S, 
then output -1 otherwise, you should output the least lexicographical walk W which realizes S.


Examples:(pic)

Input : s = 'ABB'
Output: 016
Explanation: As we can see in the graph the path from ABB is 016.

Input : s = 'AABE'
Output :-1
Explanation: As there is no path that exists, hence output is -1.

*/