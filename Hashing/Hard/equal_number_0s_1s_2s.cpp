//Count Substrings with equal number of 0s, 1s and 2s

// g++ equal_number_0s_1s_2s.cpp && ./a.out

#include <bits/stdc++.h> 
using namespace std; 

// Method to count number of substring which has equal 0, 1 and 2 
int getSubstringWithEqual012(string str) {

	int n = str.length(); 

	// map to store, how many times a difference pair has occurred previously 
	map< pair<int, int>, int > mp; 
	mp[make_pair(0, 0)] = 1; 

	// zc (Count of zeroes), oc(Count of 1s) and tc(count of twos) In starting all counts are zero 
	int zc = 0, oc = 0, tc = 0; 

	// looping into string 
	int res = 0; // Initialize result 
	for (int i = 0; i < n; ++i) { 
		// increasing the count of current character 
		if (str[i] == '0') zc++; 
		else if (str[i] == '1') oc++; 
		else tc++; // Assuming that string doesn't contain other characters 
		// making pair of differences (z[i] - o[i], z[i] - t[i]) 
		pair<int, int> tmp = make_pair(zc - oc, zc - tc); 

		res = res + mp[tmp]; 
		// increasing the count of current difference pair by 1 
		mp[tmp]++; 
	} 

	return res; 
} 

int main() { 
	string str = "0102010"; 
	cout << getSubstringWithEqual012(str) << endl; 
	return 0; 
} 



/*
Count Substrings with equal number of 0s, 1s and 2s


Given a string which consists of only 0s, 1s or 2s, count the number of substrings that 
have equal number of 0s, 1s and 2s.

Examples:

Input  :  str = “0102010”
Output :  2
Explanation : Substring str[2, 4] = “102” and 
              substring str[4, 6] = “201” has 
              equal number of 0, 1 and 2

Input : str = "102100211"
Output : 5
*/
