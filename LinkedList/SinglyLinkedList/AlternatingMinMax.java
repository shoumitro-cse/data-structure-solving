// Rearrange a given list such that it consists of alternating minimum maximum elements

//javac -d classes AlternatingMinMax.java  && cd classes && java AlternatingMinMax && cd ..

import java.util.*; 

class AlternatingMinMax { 
	
	// Function to rearrange a given list such that it 
	// consists of alternating minimum maximum elements 
	// using LinkedList 
	public static void alternateSort(LinkedList<Integer> ll) { 

        System.out.println(ll); 
		Collections.sort(ll); 
	    System.out.println(ll); 

		for (int i = 1; i < (ll.size() + 1)/2; i++) { 
			Integer x = ll.getLast(); 
			ll.removeLast(); 
			ll.add(2*i - 1, x); 
		} 
		
		System.out.println(ll); 
	} 
	
	public static void main (String[] args) throws java.lang.Exception {

		// input list 
		Integer arr[] = {1, 3, 8, 2, 7, 5, 6, 4}; 
		
		// convert array to LinkedList 
		LinkedList<Integer> ll = new LinkedList<Integer>(Arrays.asList(arr)); 
		
		// rearrange the given list 
		alternateSort(ll); 
	} 
} 
