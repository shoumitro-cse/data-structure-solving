// Find all triplets with zero sum

//javac -d classes TripletsWithZeroSum.java  && cd classes && java TripletsWithZeroSum && cd ..

import java.util.*;

class TripletsWithZeroSum {


/*Complexity Analysis: 

Time Complexity: O(n2). 
Since two nested loops is required, so the time complexity is O(n2).
Auxiliary Space: O(n). 
Since a hashmap is required, so the time complexity is linear.*/

    // function to print triplets with 0 sum
    static void findTriplets(int arr[], int n) {
        boolean found = false;
        for (int i = 0; i < n - 1; i++) {
            // Find all pairs with sum equals to "-arr[i]"
            HashSet<Integer> s = new HashSet<Integer>();
            for (int j = i + 1; j < n; j++) {
                int x = -(arr[i] + arr[j]);
                if (s.contains(x)) {
                    System.out.printf("%d %d %d\n", x, arr[i], arr[j]);
                    found = true;
                } else {
                    s.add(arr[j]);
                }
            }
        }
        if (found == false) {
            System.out.printf(" No Triplet Found\n");
        }
    }



/*Complexity Analysis: 

Time Complexity : O(n3). 
As three nested loops are required, so the time complexity is O(n3).
Auxiliary Space : O(1). 
Since no extra space is required, so the time complexity is constant.
*/

/*	// Prints all triplets in arr[] with 0 sum
	static void findTriplets(int[] arr, int n) {

		boolean found = false;
		for (int i=0; i<n-2; i++) {
			for (int j=i+1; j<n-1; j++) {
				for (int k=j+1; k<n; k++) {
					if (arr[i]+arr[j]+arr[k] == 0) {
						System.out.print(arr[i]);
						System.out.print(" ");
						System.out.print(arr[j]);
						System.out.print(" ");
						System.out.print(arr[k]);
						System.out.print("\n");
						found = true;
					}
				}
			}
		}

		// If no triplet with 0 sum found in array
		if (found == false) {
			System.out.println(" not exist ");
		}

	}*/


/*	    // Method to count such triplets
    static int countTriplets(int arr[], int n, int m)
    {
        // Store all the elements in a set
        HashMap<Integer, Integer> occ = new HashMap<Integer, Integer>(n);
        for (int i = 0; i < n; i++)
            occ.put(arr[i], i);
 
        int count = 0;
 
        // Consider all pairs and check for a
        // third number so their product is equal to m
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // Check if current pair divides m or not
                // If yes, then search for (m / arr[i]*arr[j])
                if ((arr[i] * arr[j] <= m) && (arr[i] * arr[j] != 0) && (m % (arr[i] * arr[j]) == 0)) {
                    int check = m / (arr[i] * arr[j]);
 
                    occ.containsKey(check);
 
                    if (check != arr[i] && check != arr[j]
                        && occ.containsKey(check) && occ.get(check) > i && occ.get(check) > j)
                        count++;
                }
            }
        }
 
        // Return number of triplets
        return count;
    }
*/ 


	public static void main(String[] args) {
		int arr[] = {0, -1, 2, -3, 1};
		int n =arr.length;
		findTriplets(arr, n);

	}
}


/*
Find all triplets with zero sum

Given an array of distinct elements. The task is to find triplets in the array whose sum is zero.

Examples : 

Input : arr[] = {0, -1, 2, -3, 1}
Output : (0 -1 1), (2 -3 1)

Explanation : The triplets with zero sum are
0 + -1 + 1 = 0 and 2 + -3 + 1 = 0  

Input : arr[] = {1, -2, 1, 0, 5}
Output : 1 -2  1
Explanation : The triplets with zero sum is
1 + -2 + 1 = 0   

*/