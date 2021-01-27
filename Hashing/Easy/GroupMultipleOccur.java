// A simple Java program to group multiple occurrences of individual array elements 

//javac -d classes GroupMultipleOccur.java  && cd classes && java GroupMultipleOccur && cd ..


/* Java program to group multiple occurrences of individual array elements */
import java.util.HashMap; 

class GroupMultipleOccur {

	// A hashing based method to group all occurrences of individual elements 
	static void orderedGroup(int arr[]) { 
		
		// Creates an empty hashmap 
		HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>(); 

		// Traverse the array elements, and store count for every element in HashMap 
		for (int i=0; i<arr.length; i++) { 
			// Check if element is already in HashMap 
			Integer prevCount = hM.get(arr[i]); 
			if (prevCount == null) {
			   prevCount = 0; 
			}	
			// Increment count of element element in HashMap 
			hM.put(arr[i], prevCount + 1); 
		} 

		// Traverse array again 
		for (int i=0; i<arr.length; i++) { 
			// Check if this is first occurrence 
			Integer count = hM.get(arr[i]);	 
			if (count != null) { 
				// If yes, then print the element 'count' times 
				for (int j=0; j<count; j++) {// print count time a spacific element
				   System.out.print(arr[i] + " "); 
				}
				// And remove the element from HashMap. 
				hM.remove(arr[i]); 
			} 
		} 
	} 

	public static void main (String[] args) { 
		int arr[] = {10, 5, 3, 10, 10, 4, 1, 3}; 
		orderedGroup(arr); 
		System.out.println();
	} 
} 

/*
Group multiple occurrence of array elements ordered by first occurrence

Given an unsorted array with repetitions, the task is to group multiple occurrence of individual elements. The grouping should happen in a way that the order of first occurrences of all elements is maintained.
Examples:

Input: arr[] = {5, 3, 5, 1, 3, 3}
Output:        {5, 5, 3, 3, 3, 1}

Input: arr[] = {4, 6, 9, 2, 3, 4, 9, 6, 10, 4}
Output:        {4, 4, 4, 6, 6, 9, 9, 2, 3, 10}
*/



/*class GroupMultipleOccur { 
	
	// A simple method to group all occurrences of individual elements 
	static void groupElements(int arr[], int n) { 
		
		// Initialize all elements as not visited 
		boolean visited[] = new boolean[n]; 
		for (int i = 0; i < n; i++) { 
			visited[i] = false; 
		} 

        // Time complexity of the above method is O(n2).
		// Traverse all elements 
		for (int i = 0; i < n; i++) { 
			// Check if this is first occurrence 
			if (!visited[i]) { 
				// If yes, print it and all subsequent occurrences 
				System.out.print(arr[i] + " "); 
				for (int j = i + 1; j < n; j++) { 
					if (arr[i] == arr[j]) { 
						System.out.print(arr[i] + " "); // print subsequence
						visited[j] = true; 
					} 
				} 
			} 
		} 

	} 

	public static void main(String[] args) { 
		
		int arr[] = {4, 6, 9, 2, 3, 4, 9, 6, 10, 4}; 
		int n = arr.length; 

		groupElements(arr, n); 
		System.out.println();

	} 
} 

*/