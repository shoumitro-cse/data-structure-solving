// Move weighting scale alternate under given constraints

// javac -d classes MoveWeightingScale.java  && cd classes && java MoveWeightingScale && cd ..

class MoveWeightingScale {

	// DFS method to traverse among states of weighting scales 
	static boolean dfs(int residue, int curStep, int[] wt, int[] arr, int N, int steps) { 
		
		// If we reach to more than required steps, return true 
		if (curStep >= steps) 
			return true; 

		// Try all possible weights and choose one which returns 1 after wards 
		for (int i = 0; i < N; i++) { 
			if (curStep - 1 < 0 || (arr[i] > residue && arr[i] != wt[curStep - 1])) { 
				// assign this weight to array and recur for next state 
				wt[curStep] = arr[i]; 
				if (dfs(arr[i] - residue, curStep + 1, wt, arr, N, steps)) {
					return true; 
				}
			} 
		} 

		// if any weight is not possible, return false 
		return false; 
	} 

	// method prints weights for alternating scale and if not possible prints 'not possible' 
	static void printWeightOnScale(int[] arr, int N, int steps) {

		int[] wt = new int[steps]; 
		// call dfs with current residue as 0 and current steps as 0 
		if (dfs(0, 0, wt, arr, N, steps)) { 
			for (int i = 0; i < steps; i++) 
				System.out.print(wt[i] + " "); 
			System.out.println(); 
		} else {
			System.out.println("Not Possible"); 
		}
	} 
 
	public static void main(String[] args) { 
		
		int[] arr = { 2, 3, 5, 6 }; 
		int N = arr.length; 
		int steps = 10; 

		printWeightOnScale(arr, N, steps); 

	} 

} 


