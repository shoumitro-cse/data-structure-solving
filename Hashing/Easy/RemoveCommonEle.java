// Remove minimum number of elements such that no common element exist in both array

import java.util.*; 

class RemoveCommonEle { 
	
	// To find no elements to remove so no common element exist 
	public static int minRemove(int a[], int b[], int n, int m) { 

		// To store count of array element 
		HashMap<Integer, Integer> countA = new HashMap<Integer, Integer>(); 
		HashMap<Integer, Integer> countB = new HashMap<Integer, Integer>(); 
	
		// Count elements of a 
		for (int i = 0; i < n; i++) { 
			if (countA.containsKey(a[i])) {
				countA.put(a[i], countA.get(a[i]) + 1); 
			} else { 
			  countA.put(a[i], 1); 
			}		
		} 
		
		// Count elements of b 
		for (int i = 0; i < m; i++){ 
			if (countB.containsKey(b[i])) {
			  countB.put(b[i], countB.get(b[i]) + 1); 
			} else { 
			  countB.put(b[i], 1);
			} 
		} 
		
		// Traverse through all common element, and pick minimum occurrence from two arrays 
		int res = 0; 
		
		Set<Integer> s = countA.keySet(); 
		
		for (int x : s) {
			if(countB.containsKey(x)) {
				res += Math.min(countB.get(x), countA.get(x)); 
			}
		}
	
		// To return count of minimum elements 
		return res; 
	} 
	
	public static void main(String[] args) { 

		int a[] = { 1, 2, 3, 4 }; 
		int b[] = { 2, 3, 4, 5, 8 }; 
		int n = a.length; 
		int m = b.length; 
	
		System.out.println(minRemove(a, b, n, m)); 
			
	} 
} 


	
/*
Remove minimum number of elements such that no common element exist in both array

Given two arrays A[] and B[] consisting of n and m elements respectively. 
Find minimum number of elements to remove from each array such that no common 
element exist in both.

Examples:

Input : A[] = { 1, 2, 3, 4}
        B[] = { 2, 3, 4, 5, 8 }
Output : 3
We need to remove 2, 3 and 4 from any array.

Input : A[] = { 4, 2, 4, 4}
        B[] = { 4, 3 }
Output : 1
We need to remove 4 from B[]

Input : A[] = { 1, 2, 3, 4 }
        B[] = { 5, 6, 7 }
Output : 0
There is no common element in both.*/