//How to check if two given sets are disjoint?

//javac -d classes CheckDisjoint.java  && cd classes && java CheckDisjoint && cd ..

import java.util.*; 

class CheckDisjoint {


	// This function prints all distinct elements 
	static boolean areDisjoint(int set1[], int set2[]) { 

		// Creates an empty hashset 
		HashSet<Integer> set = new HashSet<>(); 

		// Traverse the first set and store its elements in hash 
		for (int i=0; i<set1.length; i++) 
			set.add(set1[i]); 

		// Traverse the second set and check if any element of it is already in hash or not. 
		for (int i=0; i<set2.length; i++) 
			if (set.contains(set2[i])) 
				return false; 

		return true; 
	} 

	public static void main (String[] args) {

		int set1[] = {10, 5, 3, 4, 6}; 
		int set2[] = {8, 7, 9, 3}; 
		
		if (areDisjoint(set1, set2)) 
			System.out.println("Yes"); 
		else
			System.out.println("No"); 
	} 
} 


/*How to check if two given sets are disjoint?


Given two sets represented by two arrays, how to check if the given two sets are disjoint or not? It may be assumed that the given arrays have no duplicates.
 

Input: set1[] = {12, 34, 11, 9, 3}
       set2[] = {2, 1, 3, 5}
Output: Not Disjoint
3 is common in two sets.

Input: set1[] = {12, 34, 11, 9, 3}
       set2[] = {7, 2, 1, 5}
Output: Yes, Disjoint
There is no common element in two sets.
*/


