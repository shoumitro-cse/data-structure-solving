// Java program to find length of the
// longest increasing subsequence whose adjacent element differ by 1

//javac -d classes LastConsIncr.java  && cd classes && java LastConsIncr && cd ..
import java.util.*;

class LastConsIncr {

	static int LongIncrConseqSubseq(int arr[], int n) {
		// create hashmap to save latest consequent number as "key" and its length as "value"
		HashMap<Integer, Integer> map = new HashMap<>();
		// put first element as "key" and its length as "value"
		map.put(arr[0], 1);
		
		for (int i = 1; i < n; i++) {
			// check if last consequent of arr[i] exist or not
			if (map.containsKey(arr[i]-1)) {
				// put the updated consequent number and increment its value(length)
				map.put(arr[i], map.get(arr[i]-1) + 1);
				// remove the last consequent number
				map.remove(arr[i]-1);
			} else {
			   // if their is no last consequent of arr[i] then put arr[i]
				map.put(arr[i], 1);
			}
		}
		return Collections.max(map.values());
	}

	public static void main(String args[]) {
		// Take input from user
		int arr[] = new int[]{3, 10, 3, 11, 4, 5, 6, 7, 8, 12};
		
		System.out.println(LongIncrConseqSubseq(arr, arr.length));
	}


}



/*
Longest Increasing consecutive subsequence


Given N elements, write a program that prints the length of the longest increasing 
subsequence whose adjacent element difference is one. 
Examples: 

Input : a[] = {3, 10, 3, 11, 4, 5, 6, 7, 8, 12} 
Output : 6 
Explanation: 3, 4, 5, 6, 7, 8 is the longest increasing subsequence whose adjacent 
             element differs by one. 

Input : a[] = {6, 7, 8, 3, 4, 5, 9, 10} 
Output : 5 
Explanation: 6, 7, 8, 9, 10 is the longest increasing subsequence 
*/