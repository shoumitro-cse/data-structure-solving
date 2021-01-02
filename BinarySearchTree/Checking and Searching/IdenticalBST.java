// A Java program to check for Identical BSTs without building the trees 

//javac -d classes IdenticalBST.java  && cd classes && java IdenticalBST && cd ..

class IdenticalBST 
{ 

	static boolean isSameBSTUtil(int a[], int b[], int n, int i1, int i2, int min, int max) 
	{ 
		int j, k; 

		for (j = i1; j < n; j++) 
		  if (a[j] > min && a[j] < max) 
			break; 

		for (k = i2; k < n; k++) 
			if (b[k] > min && b[k] < max) 
				break; 

		if (j == n && k == n) 
			return true; 

		if (((j==n)^(k==n)) || a[j]!=b[k]) 
			return false; 

		return isSameBSTUtil(a, b, n, j+1, k+1, a[j], max) && // Right Subtree 
				isSameBSTUtil(a, b, n, j+1, k+1, min, a[j]); // Left Subtree 
	} 

	// A wrapper over isSameBSTUtil() 
	static boolean isSameBST(int a[], int b[], int n) 
	{ 
		return isSameBSTUtil(a, b, n, 0, 0, Integer.MIN_VALUE,Integer.MAX_VALUE); 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		int a[] = {8, 3, 6, 1, 4, 7, 10, 14, 13}; 
		int b[] = {8, 10, 14, 3, 6, 4, 1, 7, 13}; 
		int n=a.length; 

		System.out.printf("%s\n", isSameBST(a, b, n)? "BSTs are same":"BSTs not same"); 
	} 
} 


/*
Check for Identical BSTs without building the trees

Given two arrays which represent a sequence of keys. Imagine we make a Binary Search Tree (BST) from each array. We need to tell whether two BSTs will be identical or not without actually constructing the tree.
Examples
For example, the input arrays are {2, 4, 3, 1} and {2, 1, 4, 3} will construct the same tree

 Let the input arrays be a[] and b[]

Example 1:
a[] = {2, 4, 1, 3} will construct following tree.
   2
 /  \
1    4
    /
   3
b[] = {2, 4, 3, 1} will also also construct the same tree.
   2
 /  \
1    4
    /
   3 
So the output is "True"

Example 2:
a[] = {8, 3, 6, 1, 4, 7, 10, 14, 13}
b[] = {8, 10, 14, 3, 6, 4, 1, 7, 13}

They both construct the same following BST, so output is "True"
            8
         /    \
       3       10
     /  \        \
    1     6       14
        /   \     /
       4     7   13  
       */