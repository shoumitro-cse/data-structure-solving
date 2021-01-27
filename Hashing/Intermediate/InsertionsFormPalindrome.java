// Minimum insertions to form a palindrome with permutations allowed

//javac -d classes InsertionsFormPalindrome.java  && cd classes && java InsertionsFormPalindrome && cd ..

public class InsertionsFormPalindrome { 

	// Function will return number of characters to be added 
	static int minInsertion(String str) { 
		// To store string length 
		int n = str.length(); 
		// To store number of characters occurring odd number of times 
		int res = 0; 
		// To store count of each character 
		int[] count = new int[26]; 
		// To store occurrence of each character 
		for (int i = 0; i < n; i++) {
			count[str.charAt(i) - 'a']++; 
		}
		// To count characters with odd occurrence 
		for (int i = 0; i < 26; i++) { 
			if (count[i] % 2 == 1) 
				res++; 
		} 
		// As one character can be odd return res - 1 but if string is already palindrome return 0 
		return (res == 0) ? 0 : res-1; 
	} 

	public static void main(String[] args) { 
		String str = "geeksforgeeks"; 
		System.out.println(minInsertion(str)); 
	} 
} 

/*
Minimum insertions to form a palindrome with permutations allowed


Given a string of lowercase letters. Find minimum characters to be inserted in string so 
that it can become palindrome. We can change positions of characters in string.

Examples:

Input : geeksforgeeks
Output : 2
geeksforgeeks can be changed as:
geeksroforskeeg
geeksorfroskeeg
and many more

Input : aabbc
Output : 0
aabbc can be changed as:
abcba
bacab
*/
