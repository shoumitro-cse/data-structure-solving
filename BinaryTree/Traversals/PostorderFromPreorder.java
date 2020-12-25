// Find postorder traversal of BST from preorder traversal

//javac -d classes PostorderFromPreorder.java  && cd classes && java PostorderFromPreorder && cd ..

import java.util.*;

class PostorderFromPreorder {

/*	static class INT {
		int data;
		INT(int d) { 
			data = d; 
		}
	}

	// Function to find postorder traversal from preorder traversal.
	static void findPostOrderUtil(int pre[], int n, int minval, int maxval, INT preIndex) {

		if (preIndex.data == n)
			return;

		if (pre[preIndex.data] < minval || pre[preIndex.data] > maxval) {
			return;
		}

		int val = pre[preIndex.data];
		preIndex.data++; 
		// System.out.print("\npreindex: "+preIndex.data);


		findPostOrderUtil(pre, n, minval, val, preIndex); 

		findPostOrderUtil(pre, n, val, maxval, preIndex);

		System.out.print(val + " ");
	}

	// Function to find postorder traversal.
	static void findPostOrder(int pre[], int n){
		INT preIndex = new INT(0);
		findPostOrderUtil(pre, n, Integer.MIN_VALUE, Integer.MAX_VALUE, preIndex);
	}*/

	static int preIndex=0;
	// Function to find postorder traversal from preorder traversal.
	static void findPostOrderUtil(int pre[], int n, int minval, int maxval) {

		if (preIndex == n)
			return;

		if (pre[preIndex] < minval || pre[preIndex] > maxval) {
			return;
		}
		
		int val = pre[preIndex];
		preIndex++; 
		// System.out.println("\npreindex: "+preIndex);

		findPostOrderUtil(pre, n, minval, val); 

		findPostOrderUtil(pre, n, val, maxval);

		System.out.print(val + " ");
	}

	// Function to find postorder traversal.
	static void findPostOrder(int pre[], int n){
		findPostOrderUtil(pre, n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	// Driver code
	public static void main(String args[]){
		int pre[] = { 40, 30, 35, 80, 100 };
		int n = pre.length;
		
		// Calling function
		System.out.println();
		findPostOrder(pre, n);
		System.out.println();

	/*		40
			/\
		  30  80
		   \    \
		    35  100*/
	}
}


