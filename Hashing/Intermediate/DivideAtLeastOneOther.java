// Java program to find special numbers in an array 

//javac -d classes DivideAtLeastOneOther.java  && cd classes && java DivideAtLeastOneOther && cd ..

import java.io.*; 
import java.util.*; 

class DivideAtLeastOneOther { 
	
	// Function to find special numbers 
	static void divisibilityCheck(List<Integer> arr, int n) { 
		
		// Storing all array elements in a hash and finding maximum element in array 
		List<Integer> s = new ArrayList<Integer>(); 
		int max_ele = Integer.MIN_VALUE; 
		for (int i = 0; i < n; i++) { 
			s.add(arr.get(i)); 
			// finding maximum element of array 
			max_ele = Math.max(max_ele, arr.get(i)); 
		} 

		LinkedHashSet<Integer> res = new LinkedHashSet<Integer>(); 
		for (int i = 0; i < n; i++) { 
			// Check for non-zero values only 
			if (arr.get(i) != 0) {
				// checking the factor of current element 
				for (int j = arr.get(i) * 2; j <= max_ele; j += arr.get(i)) { 
					if (s.contains(j)) {
						res.add(j); 
					}
				} 
			}
		} 

		List<Integer> list = new ArrayList<Integer>(res); 
		Collections.reverse(list); 

		for (Integer temp : list) {
			System.out.print(temp + " "); 
		}

	} 

	public static void main(String args[]) { 
		List<Integer> arr = Arrays.asList(2, 3, 8, 6, 9, 10); 
		int n = arr.size(); 
		divisibilityCheck(arr, n); 
		System.out.println();
	} 
} 



/*
Print array elements that are divisible by at-least one other


Given an array of length N that contains only integers, the task is to print the special 
numbers of array. A number in this array is called Special number if it is divisible by 
at least one other number in the array.

Examples :

Input : 1 2 3
Output : 2 3
Explanation : both 2 and 3 are divisible by 1.

Input : 2 3 4 6 8 9
Output : 4 6 8 9
Explanation : 2 and 3 are not divisible by any other element. Rest of the element are divisible by at-least 1 element. 6 is divisible by both 2 and 3, 4 divisible by 2, 8 divisible by 2 and 4 both, 9 divisible by 3.

Input : 3 5 7 11
Output :
Explanation : all elements are relatively prime so no special number.
*/


