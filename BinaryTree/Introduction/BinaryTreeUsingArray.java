//Binary Tree (Array implementation)

// JAVA implementation of tree using array numbering starting from 0 to n-1.

// javac -d classes BinaryTreeUsingArray.java  && cd classes && java BinaryTreeUsingArray && cd ..

import java.util.*;
import java.lang.*;
import java.io.*;

class BinaryTreeUsingArray {

	public static void main(String[] args) {
	
		ArrayTree obj = new ArrayTree();

		obj.Root("A");//root
		
		obj.set_Left("B", 0);//root.left
		obj.set_Right("C", 0);//root.right

		obj.set_Left("D", 1);//root.left.left
		obj.set_Right("E", 1);//root.left.right
		
		obj.set_Left("F", 2);//root.right.left

		/*    A(0)    
		     /   \
		    B(1)  C(2)  
		  /   \      \
		 D(3)  E(4)   F(6) */


/*		System.out.println();
		obj.print_Tree();*/


		System.out.print("\nInorder: ");
		obj.inOrder(0);
		System.out.println();		

		System.out.print("pre order: ");
		obj.preOrder(0);
		System.out.println();		

		System.out.print("post order: ");
		obj.postOrder(0);
		System.out.println();

	}
}

class ArrayTree {

	// static int root = 0;
	static String[] str = new String[10];
	// create root
	public void Root(String key) {
		str[0] = key;
	}
	// create left son of root
	public void set_Left(String key, int root) {
		int t = (root * 2) + 1;
		if (str[root] == null) {
			System.out.printf("Can't set child at %d, no parent found\n", t);
		}
		else {
			str[t] = key;
		}
	}
	// create right son of root
	public void set_Right(String key, int root) {
		int t = (root * 2) + 2;
		if (str[root] == null) {
			System.out.printf("Can't set child at %d, no parent found\n", t);
		} else {
			str[t] = key;
		}
	}

/*    //print all data
	public void print_Tree() {
		for (int i = 0; i < 10; i++) {
			if (str[i] != null)
				System.out.print(str[i]+" ");
			else
				System.out.print("-");
		}
	}*/

	public void inOrder(int root) {
		int len = str.length;
		if(root >= len) 
			return;

       inOrder((root*2)+1);//left
       if (str[root] != null) { //root
	     System.out.print(str[root]+" ");
       }
       inOrder((root*2)+2);//right
	}

	public void preOrder(int root) {
		int len = str.length;
		if(root >= len) 
			return;

       if (str[root] != null) {//root
	     System.out.print(str[root]+" ");
       }
       preOrder((root*2)+1);//left
       preOrder((root*2)+2);//right
	}

	public void postOrder(int root) {
		int len = str.length;
		if(root >= len) 
			return;

       postOrder((root*2)+1);//left
       postOrder((root*2)+2);//right
       if (str[root] != null) {//root
	     System.out.print(str[root]+" ");
       }
	}


}



/*
Binary Tree (Array implementation)

Talking about representation, trees can be represented in two ways: 
1) Dynamic Node Representation (Linked Representation). 
2) Array Representation (Sequential Representation).
We are going to talk about the sequential representation of the trees. 
To represent tree using an array. 

       A(0)    
     /   \
    B(1)  C(2)  
  /   \      \
 D(3)  E(4)   F(6) 


OR,

      A(1)    
     /   \
    B(2)  C(3)  
  /   \      \
 D(4)  E(5)   F(7)  



parent=p; 
then left=(2*p)+1; 
and right=(2*p)+2;

where parent, left and right are the values of indices of the array.*/