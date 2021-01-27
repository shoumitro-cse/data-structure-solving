// Java implementation to find such pairs 

//javac -d classes ModPairs.java  && cd classes && java ModPairs && cd ..

class ModPairs { 
	// method to find pair such that (a % b = k) 
	static boolean printPairs(int arr[], int n, int k) {

		boolean isPairFound = true; 
		// Consider each and every pair 
		for (int i = 0; i < n; i++) { 
			for (int j = 0; j < n; j++) { 
				// Print if their modulo equals to k 
				if (i != j && arr[i] % arr[j] == k) { 
					System.out.print("(" + arr[i] + ", " + arr[j] + ")"+ " "); 
					isPairFound = true; 
				} 
			} 
		} 

		return isPairFound; 
	} 

	public static void main(String args[]) {
	 
		int arr[] = { 2, 3, 5, 4, 7 }; 
		int k = 3; 

		if (printPairs(arr, arr.length, k) == false) {
			System.out.println("No such pair exists"); 
		}
		System.out.println(); 
	} 
} 

/*
Find all pairs (a, b) in an array such that a % b = k

Given an array with distinct elements, the task is to find the pairs in the array such that a % b = k, where k is a given integer.

Examples :

Input  :  arr[] = {2, 3, 5, 4, 7}   
              k = 3
Output :  (7, 4), (3, 4), (3, 5), (3, 7)
7 % 4 = 3
3 % 4 = 3
3 % 5 = 3
3 % 7 = 3
*/
