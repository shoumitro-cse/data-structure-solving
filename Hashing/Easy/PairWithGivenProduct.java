// Java program to find if there is a pair with given product. 


//javac -d classes PairWithGivenProduct.java  && cd classes && java PairWithGivenProduct && cd ..

class PairWithGivenProduct {

	// Returns true if there is a pair in arr[0..n-1] with product equal to x. 
	boolean isProduct(int arr[], int n, int x) { 
		for (int i=0; i<n-1; i++) {
			for (int j=i+1; j<n; j++) { 
				if (arr[i]*arr[j] == x) { 
					return true; 
				}
			}
		}
		return false; 
	} 

	public static void main(String[] args) {

		PairWithGivenProduct g = new PairWithGivenProduct(); 

		int arr[] = {10, 20, 9, 40}; 
		int x = 400; 
		int n = arr.length; 
		
		if (g.isProduct(arr, n, x)) 
			System.out.println("Yes"); 
		else
			System.out.println("No"); 

		x = 190; 
		if (g.isProduct(arr, n, x)) 
			System.out.println("Yes"); 
		else
			System.out.println("No"); 

	} 
} 

/*
Pair with given product | Set 1 (Find if any pair exists)


Given an array of distinct elements and a number x, 
find if there is a pair with a product equal to x.

Examples :

Input : arr[] = {10, 20, 9, 40};
        int x = 400;
Output : Yes

Input : arr[] = {10, 20, 9, 40};
        int x = 190;
Output : No

Input : arr[] = {-10, 20, 9, -40};
        int x = 400;
Output : Yes

Input : arr[] = {-10, 20, 9, 40};
        int x = -400;
Output : Yes

Input : arr[] = {0, 20, 9, 40};
        int x = 0;
Output : Yes
*/