/* A Java program to answer queries to check whether 
the substrings are palindrome or not efficiently */

public class PalindromeSubstringQueries { 

	static int p = 101; 
	static int MOD = 1000000007; 

	// Structure to represent a query. A query consists 
	// of (L, R) and we have to answer whether the substring 
	// from index-L to R is a palindrome or not 
	static class Query { 
		int L, R; 
		public Query(int L, int R) { 
			this.L = L; 
			this.R = R; 
		} 
	}; 

	// A function to check if a string str is palindrome in the ranfe L to R 
	static boolean isPalindrome(String str, int L, int R) { 
		// Keep comparing characters while they are same 
		while (R > L) { 
			if (str.charAt(L++) != str.charAt(R--)) { 
				return (false); 
			} 
		} 
		return (true); 
	} 

	// A Function to find pow (base, exponent) % MOD in log (exponent) time 
	static int modPow(int base, int exponent) {

		if (exponent == 0) { 
			return 1; 
		} 

		if (exponent == 1) { 
			return base; 
		} 

		int temp = modPow(base, exponent / 2); 

		if (exponent % 2 == 0) { 
			return (temp % MOD * temp % MOD) % MOD; 
		} else { 
			return (((temp % MOD * temp % MOD) % MOD) * base % MOD) % MOD; 
		} 
	} 

	// A Function to calculate Modulo Multiplicative Inverse of 'n' 
	static int findMMI(int n) { 
		return modPow(n, MOD - 2); 
	} 

	// A Function to calculate the prefix hash 
	static void computePrefixHash(String str, int n, int prefix[], int power[]) { 
		prefix[0] = 0; 
		prefix[1] = str.charAt(0); 
		for (int i = 2; i <= n; i++) { 
			prefix[i] = (prefix[i - 1] % MOD 
						+ (str.charAt(i - 1) % MOD * power[i - 1] % MOD) % MOD) % MOD; 
		} 
		return; 
	} 

	// A Function to calculate the suffix hash 
	// Suffix hash is nothing but the prefix hash of 
	// the reversed string 
	static void computeSuffixHash(String str, int n, int suffix[], int power[]) { 
		suffix[0] = 0; 
		suffix[1] = str.charAt(n - 1); 

		for (int i = n - 2, j = 2; i >= 0 && j <= n; i--, j++) { 
			suffix[j] = (suffix[j - 1] % MOD 
						+ (str.charAt(i) % MOD * power[j - 1] % MOD) % MOD) % MOD; 
		} 
		return; 
	} 

	// A Function to answer the Queries 
	static void queryResults(String str, Query q[], int m, int n, 
		int prefix[], int suffix[], int power[])  { 
		for (int i = 0; i <= m - 1; i++) { 
			int L = q[i].L; 
			int R = q[i].R; 

			// Hash Value of Substring [L, R] 
			long hash_LR 
				= ((prefix[R + 1] - prefix[L] + MOD) % MOD * findMMI(power[L]) % MOD) % MOD; 

			// Reverse Hash Value of Substring [L, R] 
		  long reverse_hash_LR 
			= ((suffix[n - L] - suffix[n - R - 1] + MOD) % MOD * findMMI(power[n - R - 1]) % MOD) % MOD; 

			// If both are equal then the substring is a palindrome 
			if (hash_LR == reverse_hash_LR) { 
				if (isPalindrome(str, L, R) == true) { 
					System.out.printf("The Substring [%d %d] is a "+ "palindrome\n", L, R); 
				} else { 
					System.out.printf("The Substring [%d %d] is not a "+ "palindrome\n", L, R); 
				} 
			} else { 
				System.out.printf("The Substring [%d %d] is not a "+ "palindrome\n", L, R); 
			} 
		} 

		return; 
	} 

	// A Dynamic Programming Based Approach to compute the 
	// powers of 101 
	static void computePowers(int power[], int n) { 
		// 101^0 = 1 
		power[0] = 1; 
		for (int i = 1; i <= n; i++) { 
			power[i] = (power[i - 1] % MOD * p % MOD) % MOD; 
		} 
		return; 
	} 

	public static void main(String[] args) {
	 
		String str = "abaaabaaaba"; 
		int n = str.length(); 

		// A Table to store the powers of 101 
		int[] power = new int[n + 1]; 

		computePowers(power, n); 

		// Arrays to hold prefix and suffix hash values 
		int[] prefix = new int[n + 1]; 
		int[] suffix = new int[n + 1]; 

		// Compute Prefix Hash and Suffix Hash Arrays 
		computePrefixHash(str, n, prefix, power); 
		computeSuffixHash(str, n, suffix, power); 

		Query q[] = { new Query(0, 10), new Query(5, 8), 
					new Query(2, 5), new Query(5, 9) }; 
		int m = q.length; 

		queryResults(str, q, m, n, prefix, suffix, power); 
	} 
} 

/*
Palindrome Substring Queries

Given a string and several queries on the substrings of the given input string to check whether the substring is a palindrome or not.

Examples :

Suppose our input string is “abaaabaaaba” and the queries- [0, 10], [5, 8], [2, 5], [5, 9]

We have to tell that the substring having the starting and ending indices as above is a palindrome or not.

[0, 10] → Substring is “abaaabaaaba” which is a palindrome.
[5, 8] → Substring is “baaa” which is not a palindrome.
[2, 5] → Substring is “aaab” which is not a palindrome.
[5, 9] → Substring is “baaab” which is a palindrome.


Let us assume that there are Q such queries to be answered and N be the length of our input string. There are the following two ways to answer these queries

*/