//	 CPP program for the above approach 

// g++ SortEleFreq.cpp && ./a.out

#include <bits/stdc++.h>
using namespace std;

// Used for sorting by frequency. And if frequency is same, then by appearance
bool sortByVal(const pair<int, int>& a, const pair<int, int>& b) {
	// If frequency is same then sort by index
	if (a.second == b.second) 
		return a.first < b.first;
  return a.second > b.second;
}

// function to sort elements by frequency
vector<int>sortByFreq(int a[], int n) {

	vector<int>res;
	unordered_map<int, int> m;
	vector<pair<int, int> > v;

	for (int i = 0; i < n; ++i) {
		// Map m is used to keep track of count of elements in array
		m[a[i]]++;	 
	}

	// Copy map to vector
	copy(m.begin(), m.end(), back_inserter(v));
	// Sort the element of array by frequency
	sort(v.begin(), v.end(), sortByVal);

	for (int i = 0; i < v.size(); ++i) {
	  while(v[i].second--) {
		res.push_back(v[i].first);
	  }
	}

	return res;
}

int main() {

	int a[] = { 2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8 };
	int n = sizeof(a) / sizeof(a[0]);

	vector<int>res;
	
	res = sortByFreq(a, n);

	for(int i = 0;i < res.size(); i++) {
		cout<<res[i]<<" ";
	}
    cout<<endl;
	return 0;

}


/*
Sort elements by frequency | Set 4 (Efficient approach using hash)

Print the elements of an array in the decreasing frequency if 2 numbers have the same 
frequency then print the one which came first.
Examples: 
 

Input : arr[] = {2, 5, 2, 8, 5, 6, 8, 8}
Output : arr[] = {8, 8, 8, 2, 2, 5, 5, 6}

Input : arr[] = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8}
Output : arr[] = {8, 8, 8, 2, 2, 5, 5, 6, -1, 9999999}
 */