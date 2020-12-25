// Given an ancestor matrix for binary tree, construct the tree. 

//javac -d classes ConstructTreeFromAncestorMatrix.java  && cd classes && java ConstructTreeFromAncestorMatrix && cd ..


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

 // A binary tree node 
class Node {
	int data;
	Node left, right;

	Node(int d)
	{
		data = d;
		left = right = null;
	}
}

public class ConstructTreeFromAncestorMatrix {

	static Node ancestorNode(int[][] mat){
		int n = mat.length;
		// Binary array to determine whether parent is set for node i or not
		int[] parent = new int[n];
		Node root = null;
		// Map to store row numbers as key and their sum as their values
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < n; j++){
				sum += mat[i][j];
			}
			map.put(i, sum);
		}
		//{0=0, 1=2, 2=1, 3=0, 4=0, 5=5}
		// System.out.println(map);

		// node[i] will store node for i in constructed tree
		// Sorting the map according to its values
		Map<Integer, Integer> sorted
			= map.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(e-> e.getKey(),
					e-> e.getValue(),(e1, e2) -> e2, LinkedHashMap::new));

       //{0=0, 3=0, 4=0, 2=1, 1=2, 5=5}
		// System.out.println(sorted);

		// System.out.println(n);

		Node node[] = new Node[n];

		for (Map.Entry<Integer, Integer> entry : sorted.entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();
			// create a new node for every value
			node[key] = new Node(key);
			// if its is an internal node
			if (value != 0) {
				// Traverse row corresponding to the node
				for (int i = 0; i < n; i++) {
					// if parent is not set and ancestor exits
					if (parent[i] == 0 && mat[key][i] != 0) {
						// check for unoccupied left/right node and set parent of node i
						if (node[key].left == null)
							node[key].left = node[i];
						else
							node[key].right = node[i];
						parent[i] = 1;
					}
					// To store last processed node. This node will be root after loop terminates
					root = node[key];
				}
			}
		}

		return root;
	}

	 // Given a binary tree, print its nodes in inorder 
	static void inOrder(Node root) {

		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}


	public static void main(String[] args) {

		int mat[][] = {
			{ 0, 0, 0, 0, 0, 0 }, 
			{ 1, 0, 0, 0, 1, 0 },
			{ 0, 0, 0, 1, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 }, 
			{ 1, 1, 1, 1, 1, 0 }
		};

		Node root = ancestorNode(mat);
		// Function call
		inOrder(root);
		System.out.println("");
	}
}



/*
Construct tree from ancestor matrix

Given an ancestor matrix mat[n][n] where Ancestor matrix is defined as below. 

mat[i][j] = 1 if i is ancestor of j
mat[i][j] = 0, otherwise 
Construct a Binary Tree from a given ancestor matrix where all its values of nodes are 
from 0 to n-1.

It may be assumed that the input provided the program is valid and tree can be constructed out of it.
Many Binary trees can be constructed from one input. The program will construct any one of them.

Examples: 

Input: 0 1 1
       0 0 0 
       0 0 0 
Output: Root of one of the below trees.
    0                0
  /   \     OR     /   \
 1     2          2     1

Input: 0 0 0 0 0 0 
       1 0 0 0 1 0 
       0 0 0 1 0 0 
       0 0 0 0 0 0 
       0 0 0 0 0 0 
       1 1 1 1 1 0

Output: Root of one of the below trees.
      5              5               5
   /    \           / \            /   \
  1      2   OR    2   1    OR    1     2  OR ....
 /  \   /        /    /  \       / \    /
0   4  3        3    0    4     4   0  3

There are different possible outputs because ancestor
matrix doesn't store that which child is left and which is right.*/