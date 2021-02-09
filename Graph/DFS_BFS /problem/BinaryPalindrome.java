// JAVA code to form binary palindrome 

//javac -d classes BinaryPalindrome.java  && cd classes && java BinaryPalindrome && cd ..

import java.util.*; 

class BinaryPalindrome { 

	
	// function to apply DFS 
	static void dfs(int parent, int ans[], Vector<Integer> connectchars[]) { 

		// set the parent marked 
		ans[parent] = 1; 

		// if the node has not been visited set it and its children marked 
		for (int i = 0; i < connectchars[parent].size(); i++) { 
			if (ans[connectchars[parent].get(i)] != 1) {
				dfs(connectchars[parent].get(i), ans, connectchars); 
			}
		} 

	} 

    
    // Time Complexity : O(n)
    @SuppressWarnings("unchecked") 
	static void printBinaryPalindrome(int n, int k) { 

		int []arr = new int[n]; 
		int []ans = new int[n]; 

		// link which digits must be equal 
		Vector<Integer> []connectchars = new Vector[k]; 
		
		for (int i = 0; i < k; i++) {
			connectchars[i] = new Vector<Integer>(); 
		}

		for (int i = 0; i < n; i++) {
			arr[i] = i % k; 
		}

		// connect the two indices 
		for (int i = 0; i < n / 2; i++) { 
			connectchars[arr[i]].add(arr[n-i-1]); 
			connectchars[arr[n-i-1]].add(arr[i]); 
		} 
        
        // [0, 1, 2, 3, 0, 1, 2, 3, 0, 1]
        // System.out.println(Arrays.toString(arr));
        
        // [[1, 1, 1], [0, 0, 0], [3, 3], [2, 2]]
        // System.out.println(Arrays.toString(connectchars));

		// set everything connected to first character as 1 
		dfs(0, ans, connectchars); 

		for (int i = 0; i < n; i++) {
			System.out.print(ans[arr[i]]); 
		}

	} 


	public static void main(String[] args) { 
		int n = 10, k = 4; 
		printBinaryPalindrome(n, k); 
		System.out.println();
	} 


} 


/*
Construct binary palindrome by repeated appending and trimming


Given n and k, Construct a palindrome of size n using a binary number of size k repeating 
itself to wrap into the palindrome. The palindrome must always begin with 1 and contains 
maximum number of zeros.

Examples :

Input : n = 5,  k = 3
Output : 11011 
Explanation : the 3 sized substring is
110 combined twice and trimming the extra 
0 in the end to give 11011.

Input : n = 2,  k = 8
Output : 11 
Explanation : the 8 sized substring is 11...... 
wrapped to two places to give 11.

*/