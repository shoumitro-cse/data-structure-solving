// Java implementation to count quadruples from four sorted arrays whose sum is equal to a given value x

//javac -d classes CountQuadruples.java  && cd classes && java CountQuadruples && cd ..

class CountQuadruples {

    // Time Complexity: O(n4) 
    // Auxiliary Space: O(1)
	static int countQuadruples(int arr1[], int arr2[], int arr3[], int arr4[], int n, int x) {
		int count = 0;
		
		// generate all possible quadruples from the four sorted arrays
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					for (int l = 0; l < n; l++) {
					// check whether elements of quadruple sum up to x or not
						if ((arr1[i] + arr2[j] + arr3[k] + arr4[l]) == x) {
							count++;
						}
					}
				}
			}
		}

		// required count of quadruples
		return count;
	}

	public static void main(String[] args) {

		// four sorted arrays each of size 'n'
		int arr1[] = {1, 4, 5, 6};
		int arr2[] = {2, 3, 7, 8};
		int arr3[] = {1, 4, 6, 10};
		int arr4[] = {2, 4, 7, 8};

		int n = arr1.length;
		int x = 30;
		System.out.println("Count = "+ countQuadruples(arr1, arr2, arr3, arr4, n, x));

	}
}


/*
Count quadruples from four sorted arrays whose sum is equal to a given value x


Given four sorted arrays each of size n of distinct elements. Given a value x. 
The problem is to count all quadruples(group of four numbers) from all the four arrays 
whose sum is equal to x.
Note: The quadruple has an element from each of the four arrays.
Examples: 

Input : arr1 = {1, 4, 5, 6},
        arr2 = {2, 3, 7, 8},
        arr3 = {1, 4, 6, 10},
        arr4 = {2, 4, 7, 8} 
        n = 4, x = 30

Output : 4
The quadruples are:
(4, 8, 10, 8), (5, 7, 10, 8),
(5, 8, 10, 7), (6, 7, 10, 7)

Input : For the same above given fours arrays
        x = 25
Output : 14

*/