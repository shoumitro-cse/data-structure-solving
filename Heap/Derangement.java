// generate smallest derangement using priority queue.

//javac -d classes Derangement.java  && cd classes && java Derangement && cd ..


class Derangement 
{ 
	
	static void generate_derangement(int N) 
	{ 
		// Generate Sequence S 
		int S[] = new int[N + 1]; 
		for (int i = 1; i <= N; i++) 
			S[i] = i; 

		// Generate Derangement 
		int D[] = new int[N + 1]; 
		for (int i = 1; i <= N; i += 2) { 
			if (i == N) { 
				// Only if i is odd Swap S[N-1] and S[N] 
				D[N] = S[N - 1]; 
				D[N - 1] = S[N]; 
			} else { 
				D[i] = i+1; 
				D[i+1] = i; 
			} 
		} 

		// Print Derangement 
		for (int i = 1; i <= N; i++) 
			System.out.print(D[i] + " "); 
		System.out.println(); 
	} 

	public static void main(String[] args) { 
		generate_derangement(10); 
	} 
} 


