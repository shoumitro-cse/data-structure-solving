// Construct Full Binary Tree from given preorder and postorder traversals

//javac -d classes BinaryTreeFromPrePost.java  && cd classes && java BinaryTreeFromPrePost && cd ..

public class BinaryTreeFromPrePost {
	// variable to hold index in pre[] array

	static class Node {
		int data;
		Node left, right;
		public Node(int data) {
			this.data = data;
		}
	}

	static int preindex;

        // A recursive function to construct Full 
    // from pre[] and post[]. preIndex is used 
    // to keep track of index in pre[]. l is 
    // low index and h is high index for the 
    // current subarray in post[]
	static Node constructTreeUtil(int pre[], int post[], int low, int high, int len) {
		// Base case
		if (preindex >= len || low > high){
			return null;
		}

		Node root = new Node(pre[preindex]);
		preindex++;
		
		if (low == high || preindex >= len){
			return root;
		}
		int i;
		// Search the next element of pre[] in post[]
		for (i = low; i <= high; i++) {
			
			if (post[i] == pre[preindex]) {
				break;
			}
		}

		if (i <= high) {
			root.left = constructTreeUtil(pre, post, low, i, len);
			root.right = constructTreeUtil(pre, post, i+1, high, len);
		}

		return root;
	}


	static Node constructTree(int pre[], int post[], int len) {
		preindex = 0;
		return constructTreeUtil(pre, post, 0, len-1, len);
	}

	static void printInorder(Node root) {
		if (root == null)
			return;
		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}

	public static void main(String[] args) {

		// int pre[] = { 1, 2, 4, 8, 9, 5, 3, 6, 7 };
		// int post[] = { 8, 9, 4, 5, 2, 6, 7, 3, 1 };		

		int pre[] = {1, 2, 4, 5, 3, 6, 7};
		int post[] = {4, 5, 2, 6, 7, 3, 1};

		int len = pre.length;
		Node root = constructTree(pre, post, len);

		System.out.println("\n\nInorder traversal of the constructed tree:");
		printInorder(root);
		System.out.println();

/*		        1
		      /   \
		    2       3
		  /  \     /  \
		 4    5   6    7*/
	}
}


/*
Construct Full Binary Tree from given preorder and postorder traversals

Given two arrays that represent preorder and postorder traversals of a full binary tree, 
construct the binary tree.
A Full Binary Tree is a binary tree where every Node has either 0 or 2 children
Following are examples of Full Trees. 

        1
      /   \
    2       3
  /  \     /  \
 4    5   6    7


       1
     /   \
   2      3
        /   \  
       4     5
           /   \  
          6    7
                  

          1
        /   \
      2       3
    /  \     /  \
   4    5   6    7
 /  \  
8    9 
*/