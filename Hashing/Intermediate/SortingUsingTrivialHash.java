// Sorting using trivial hash function

//javac -d classes SortingUsingTrivialHash.java  && cd classes && java SortingUsingTrivialHash && cd ..

import java.util.*; 

class SortingUsingTrivialHash { 

	static void sortUsingHash(int a[], int n) { 
		// find the maximum element 
		int max = Arrays.stream(a).max().getAsInt(); 
		// create a hash function upto the max size 
		int hash[] = new int[max + 1]; 
		// traverse through all the elements and keep a count 
		for (int i = 0; i < n; i++) 
			hash[a[i]] += 1; 

		for (int i = 0; i <= max; i++) { 
			// if present 
			if (hash[i] != 0) { 
				// print the element that number of times it's present 
				for (int j = 0; j < hash[i]; j++) { 
					System.out.print(i+" "); 
				} 
			} 
		} 
	} 

	public static void main(String[] args) { 
		int a[] = { 9, 4, 3, 2, 5, 2, 1, 0, 4, 3, 5, 10, 15, 12, 18, 20, 19 }; 
		int n = a.length; 
		sortUsingHash(a, n); 
		System.out.println();
	} 
} 

/*
Sorting using trivial hash function


Examples:

Input :  9 4 3 5 8 
Output : 3 4 5 8 9
*/

