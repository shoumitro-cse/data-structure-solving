// Find largest d in array such that a + b + c = d


import java.util.HashMap; 
import java.lang.Math; 

// To store and retrieve indices pair i & j 
class Indexes {

	int i, j; 

	Indexes(int i, int j) { 
		this.i = i; 
		this.j = j; 
	} 

	int getI() { 
		return i; 
	} 

	int getJ() { 
		return j; 
	} 
} 

class LargestdInArray { 

	// The function finds four elements with given sum X 
	static int findFourElements(int[] arr, int n) {

		HashMap<Integer, Indexes> map = new HashMap<>(); 
		// Store sums (a+b) of all pairs (a,b) in a hash table 
		for (int i = 0; i < n - 1; i++) { 
			for (int j = i + 1; j < n; j++) { 
				map.put(arr[i] + arr[j], new Indexes(i, j)); 
			} 
		} 

		int d = Integer.MIN_VALUE; 
		
		// Traverse through all pairs and find (d -c) is present in hash table 
		for (int i = 0; i < n - 1; i++) { 
			for (int j = i + 1; j < n; j++) { 
				int abs_diff = Math.abs(arr[i] - arr[j]); 
				// If d - c is present in hash table, 
				if (map.containsKey(abs_diff)) { 
					Indexes indexes = map.get(abs_diff); 
					// Making sure that all elements are distinct array elements and an element 
					// is not considered more than once. 
					if (indexes.getI() != i && indexes.getI() != j && 
					        indexes.getJ() != i && indexes.getJ() != j) { 
						d = Math.max(d, Math.max(arr[i], arr[j])); 
					} 
				} 
			} 
		} 
		return d; 
	} 

	public static void main(String[] args) {

		int arr[] = { 2, 3, 5, 7, 12 }; 
		int n = arr.length; 
		
		int res = findFourElements(arr, n); 
	
		if (res == Integer.MIN_VALUE) 
			System.out.println("No Solution"); 
		else
			System.out.println(res); 
	} 
} 




/*
Find largest d in array such that a + b + c = d


Given a set S (all distinct elements) of integers, find the largest d such that a + b + c = d
where a, b, c, and d are distinct elements of S.

Constraints:
1 ≤ number of elements in the set ≤ 1000
INT_MIN ≤ each element in the set ≤ INT_MAX
Examples :

Input : S[] = {2, 3, 5, 7, 12}
Output : 12
Explanation: 12 is the largest d which can be represented as 12 = 2 + 3 + 7

Input : S[] = {2, 16, 64, 256, 1024}
Output : No solution
*/