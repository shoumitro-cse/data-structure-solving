// Binary Indexed Tree : Range Updates and Point Queries

//javac -d classes PointQueries.java  && cd classes && java PointQueries && cd ..

class PointQueries { 

	// Updates such that getElement() gets an increased 
	// value when queried from l to r. 
	static void update(int arr[], int l, int r, int val) 
	{ 
		arr[l] += val; 
		if(r + 1 < arr.length) 
		arr[r+1] -= val; 
	} 

	// Get the element indexed at i 
	static int getElement(int arr[], int i) 
	{ 
		// To get ith element sum of all the elements 
		// from 0 to i need to be computed 
		int res = 0; 
		for (int j = 0 ; j <= i; j++) 
			res += arr[j]; 

		return res; 
	} 

	// Driver program to test above function 
	public static void main(String[] args) 
	{ 
		int arr[] = {0, 0, 0, 0, 0}; 
		int n = arr.length; 

		int l = 2, r = 4, val = 2; 
		update(arr, l, r, val); 

		//Find the element at Index 4 
		int index = 4; 
		System.out.println("Element at index " + index + " is " +getElement(arr, index)); 

		l = 0; 
		r = 3; 
		val = 4; 
		update(arr,l,r,val); 

		//Find the element at Index 3 
		index = 3; 
		System.out.println("Element at index " + index + " is " +getElement(arr, index)); 

	} 
} 
