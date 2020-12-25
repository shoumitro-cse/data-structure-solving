// Minimum swap required to convert binary tree to binary search tree 

// g++ SwapRequiredBTtoBST.cpp && ./a.out



#include<bits/stdc++.h> 
using namespace std; 

// Inorder Traversal of Binary Tree 
void inorder(int a[], std::vector<int> &v, int n, int index) { 
	// if index is greater or equal to vector size 
	if(index >= n) 
		return; 
	inorder(a, v, n, 2*index+1); 
	// push elements in vector 
	v.push_back(a[index]); 
	inorder(a, v, n, 2*index+2); 
} 

//Time Complexity: O(n log n).
// Function to find minimum swaps to sort an array 
int minSwaps(vector<int> &v) {

	vector<pair<int,int>> t(v.size()); 

	int ans = 0; 
	for(int i = 0; i < v.size(); i++) {
		t[i].first = v[i];
		t[i].second = i; 
	}
	
/*   for(int i = 0; i < v.size(); i++) {
	  cout<<"("<<t[i].first<<" "<<t[i].second<<") ";;
	}
    cout<<endl;*/
    
	sort(t.begin(), t.end()); 

/*   for(int i = 0; i < v.size(); i++) {
	  cout<<"("<<t[i].first<<" "<<t[i].second<<") ";;
	}
    cout<<endl;*/

	for(int i = 0; i < t.size(); i++) { 
		// second element is equal to i 
		if(i == t[i].second) {
			continue; 
		} else { 
			// swaping of elements 
			swap(t[i].first, t[t[i].second].first); 
			swap(t[i].second, t[t[i].second].second); 
		} 
		// Second is not equal to i 
		if(i != t[i].second) {
			--i; 
		}
		ans++; 
	} 
	return ans; 
} 


int main() 
{ 
	int a[] = { 1, 2, 3 };
	int n = sizeof(a)/sizeof(a[0]); 

	std::vector<int> v; 

	inorder(a, v, n, 0); 

	cout << minSwaps(v) << endl; 

	/*input: 1       output:  2
			/ \    =====>    / \
		   2   3            1   3
		After swapping node 1 with node 2.
		So, only 1 swap required.

	    output: 1                     */

} 




/*Minimum swap required to convert binary tree to binary search tree

Given the array representation of Complete Binary Tree i.e, if index i is the parent, 
index 2*i + 1 is the left child and index 2*i + 2 is the right child. The task is to 
find the minimum number of swap required to convert it into Binary Search Tree.

input: 1       output:  2
		/ \    =====>    / \
	   2   3            1   3

After swapping node 1 with node 2.
So, only 1 swap required.

output: 1                     */