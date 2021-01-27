// Maximum array from two given arrays keeping order same

// Make a set of maximum elements from two arrays A[] and B[]

// g++ max_two_arrays.cpp && ./a.out

#include <bits/stdc++.h>
using namespace std;

void maximizeTheFirstArray(int A[], int B[], int n) {

	// Create copies of A[] and B[] and sort the copies in descending order.

	vector<int> temp1(A, A+n);
	vector<int> temp2(B, B+n);

	sort(temp1.begin(), temp1.end(), greater<int>());
	sort(temp2.begin(), temp2.end(), greater<int>());

	// Put maximum n distinct elements of both sorted arrays in a map.
	unordered_map<int, int> m;
	int i = 0, j = 0;

	while (m.size() < n) {
		
		if (temp1[i] >= temp2[j]) {
			m[temp1[i]]++;
			i++;
		} else {
			m[temp2[j]]++;
			j++;
		}
	}

	// Copy elements of A[] to that are present in hash m.
	vector<int> res;
	for (int i = 0; i < n; i++) {
		if (m.find(A[i]) != m.end()) {
		  res.push_back(A[i]);
		}
	}

	for (int i = 0; i < n; i++) {
		if (m.find(B[i]) != m.end() && m[B[i]] == 1) {
		   res.push_back(B[i]);
		}
	}

	// print result
	for (int i = 0; i < n; i++) {
		cout << res[i] << " ";
	}
}

int main() {
	int A[] = { 9, 7, 2, 3, 6 };
	int B[] = { 7, 4, 8, 0, 1 };
	int n = sizeof(A) / sizeof(A[0]);
	maximizeTheFirstArray(A, B, n);
	cout<<endl;
	return 0;
}



/*Maximum array from two given arrays keeping order same


Given two same-sized arrays A[] and B[] (both arrays contain distinct elements individually but may have some common elements), the task is to form a third (or result) array of the same size. The resulting array should have maximum n elements from both arrays. It should have chosen elements of A[] first, then chosen elements of B[] in the same order as they appear in original arrays. If there are common elements, then only one element should be present in res[] and priority should be given to A[].
Examples:  

Input :  A[] =  [ 9 7 2 3 6 ]
         B[] =  [ 7 4 8 0 1 ]
Output : res[] = [9 7 6 4 8]
res[] has maximum n elements of both A[] 
and B[] such that elements of A[] appear
first (in same order), then elements of B[].
Also 7 is common and priority is given to
A's 7.

Input :  A[] = [ 6 7 5 3 ]
         B[] = [ 5 6 2 9 ] 
Output : res[] = [ 6 7 5 9 ]
*/
