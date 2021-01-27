// C++ program to find if string becomes palindrome after every query. 

// g++ PalindromeAfterEveryQuery.cpp && ./a.out

#include<bits/stdc++.h> 
using namespace std; 

// Function to check if string is Palindrome or Not 
bool IsPalindrome(string &str) 
{ 
	int n = strlen(str); 
	for (int i = 0; i < n/2 ; i++) 
		if (str[i] != str[n-1-i]) 
			return false; 
	return true; 
} 

// Takes two inputs for Q queries. For every query, it 
// prints Yes if string becomes palindrome and No if not. 
void Query(string &str, int Q) 
{ 
	int i1, i2; 
	char ch; 

	// Process all queries one by one 
	for (int q = 1 ; q <= Q ; q++ ) { 
		cin >> i1 >> i2 >> ch; 
		// query 1: i1 = 3 ,i2 = 0, ch = 'e' 
		// query 2: i1 = 0 ,i2 = 2 , ch = 's' 
		// replace character at index i1 & i2 with new 'ch' 
		str[i1] = str[i2] = ch; 

		// check string is palindrome or not 
		(isPalindrome(str)== true) ? cout << "YES" << endl : cout << "NO" << endl; 
	} 
} 

// Driver program 
int main() 
{ 
	char str[] = "geeks"; 
	int Q = 2; 
	Query(str, Q); 
	return 0; 
} 
