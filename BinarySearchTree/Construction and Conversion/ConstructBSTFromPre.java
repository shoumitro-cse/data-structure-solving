//construct BST from given preorder traversal

//javac -d classes ConstructBSTFromPre.java  && cd classes && java ConstructBSTFromPre && cd ..
import java.util.*; 

class Node {
	int data;
	Node left, right;
	Node(int d) {
		data = d;
		left = right = null;
	}
}

class Index {
	int index = 0;
}

class ConstructBSTFromPre {

	// The main function that constructs BST from pre[] 
    Node constructTree(int pre[], int size) { 
        // The first element of pre[] is always root 
        Node root = new Node(pre[0]); 
        Stack<Node> s = new Stack<Node>(); 
        // Push root 
        s.push(root); 
        // Iterate through rest of the size-1 items of given preorder array 
        for (int i = 1; i < size; ++i) { 
            Node temp = null; 
            /* Keep on popping while the next value is greater than stack's top value. */
            while (!s.isEmpty() && pre[i] > s.peek().data) { 
                temp = s.pop(); 
            } 
            // Make this greater value as the right child and push it to the stack 
            if (temp != null) { 
                temp.right = new Node(pre[i]); 
                s.push(temp.right); 
            } else { 
                temp = s.peek(); 
                temp.left = new Node(pre[i]); 
                s.push(temp.left); 
            } 
        } 
  
        return root; 
    } 



	Index index = new Index();

	// A recursive function to construct BST from pre[].
	// preIndex is used to keep track of index in pre[].
	Node constructTreeUtil(int pre[], Index preIndex, int key, int min, int max, int size) {
		// Base case
		if (preIndex.index >= size) {
			return null;
		}
		Node root = null;
		// If current element of pre[] is in range, then only it is part of current subtree
		if (key > min && key < max) {
			// Allocate memory for root of this subtree and increment *preIndex
			root = new Node(key);
			preIndex.index = preIndex.index + 1;

			if (preIndex.index < size) {
				root.left = constructTreeUtil(pre, preIndex, pre[preIndex.index], min, key, size);
			}
			if (preIndex.index < size) {
				root.right = constructTreeUtil(pre, preIndex, pre[preIndex.index], key, max, size);
			}
		}

		return root;
	}

/*	// The main function to construct BST from given
	// preorder traversal. This function mainly uses
	// constructTreeUtil()
	Node constructTree(int pre[], int size) {
		int preIndex = 0;
		return constructTreeUtil(pre, index, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE, size);
	}*/

	// A utility function to print inorder traversal of a
	// Binary Tree
	void printInorder(Node node)
	{
		if (node == null) {
			return;
		}
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	public static void main(String[] args) {

		ConstructBSTFromPre tree = new ConstructBSTFromPre();
		int pre[] = new int[] { 10, 5, 1, 7, 40, 50 };
		int size = pre.length;
	
		// Function call
		Node root = tree.constructTree(pre, size);
		System.out.println("Inorder traversal of the constructed tree is ");
		tree.printInorder(root);
		System.out.println();
	}
}


/*
Construct BST from given preorder traversal | Set 1

Given preorder traversal of a binary search tree, construct the BST.

For example, if the given traversal is {10, 5, 1, 7, 40, 50}, then the output 
should be the root of the following tree.

     10
   /   \
  5     40
 /  \      \
1    7      50
*/