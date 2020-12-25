// Find root of the tree where children id sum for every node is given

// javac -d classes FindRootChildrenIdSum.java  && cd classes && java FindRootChildrenIdSum && cd ..

class FindRootChildrenIdSum 
{ 

	static class Pair { 
		int first, second; 
		public Pair(int first, int second) { 
			this.first = first; 
			this.second = second; 
		} 

	} 

	static int findRoot(Pair arr[], int n) { 
		int root = 0; 
		for (int i = 0; i < n; i++) { 
			root += (arr[i].first - arr[i].second); 
		} 
		return root; 
	} 

	// Driver code 
	public static void main(String[] args) {

		Pair arr[] = {
			        new Pair(1, 5), 
			        new Pair(2, 0), 
					new Pair(3, 0), 
					new Pair(4, 0), 
					new Pair(5, 5), 
					new Pair(6, 5)
				  }; 
		int n = arr.length; 
		System.out.printf("%d\n", findRoot(arr, n)); 
	} 

} 

/*Find root of the tree where children id sum for every node is given

Consider a binary tree whose nodes have ids from 1 to n where n is number of nodes in the tree. 
The tree is given as a collection of n Pairs, where every Pair represents node id and sum of 
children ids.

Examples:

Input : 1 5
        2 0
        3 0
        4 0
        5 5
        6 5
Output: 6
Explanation: In this case, two trees can 
be made as follows and 6 is the root node.
   6          6
   \         / \
    5       1   4
   / \       \
  1   4       5
 / \         / \
2   3       2   3

Input : 4 0
Output: 4
Explanation: Clearly 4 does 
not have any children and is the
only node i.e., the root node.


*/