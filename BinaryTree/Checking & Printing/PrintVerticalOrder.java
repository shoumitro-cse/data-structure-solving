// Java program for printing vertical order of a given binary tree

//javac -d classes PrintVerticalOrder.java  && cd classes && java PrintVerticalOrder && cd ..  

import java.util.TreeMap;
import java.util.Vector;
import java.util.Map.Entry;

public class PrintVerticalOrder {
	// Tree node
	static class Node {
		int key;
		Node left;
		Node right;
		// Constructor
		Node(int data) {
			key = data;
			left = null;
			right = null;
		}
	}
	// Utility function to store vertical order in map 'm'
	// 'hd' is horizontal distance of current node from root. 'hd' is initially passed as 0
	static void getVerticalOrder(Node root, int hd, TreeMap<Integer,Vector<Integer>> m) {
		// Base case
		if(root == null)
			return;
		//get the vector list at 'hd'
		Vector<Integer> get = m.get(hd);
		// Store current node in map 'm'
		if(get == null) {
			get = new Vector<>();
			get.add(root.key);
		} else
			get.add(root.key);
		
		m.put(hd, get);
		// Store nodes in left subtree
		getVerticalOrder(root.left, hd-1, m);
		// Store nodes in right subtree
		getVerticalOrder(root.right, hd+1, m);
	}
	
	// The main function to print vertical order of a binary tree with the given root
	static void printVerticalOrder(Node root) {
		// Create a map and store vertical order in map using function getVerticalOrder()
		TreeMap<Integer,Vector<Integer>> m = new TreeMap<>();
		int hd =0;
		getVerticalOrder(root, hd, m);
		// Traverse the map and print nodes at every horigontal distance (hd)
		for (Entry<Integer, Vector<Integer>> entry : m.entrySet()) {
			System.out.println(entry.getValue());
			// System.out.println(entry);
		}
	}
	
	// Driver program to test above functions
	public static void main(String[] args) {

		// TO DO Auto-generated method stub
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);
		root.right.right.right = new Node(9);

		System.out.println("Vertical Order traversal is");
		printVerticalOrder(root);
	}
}



/*Time Complexity of hashing based solution can be considered as O(n) under the assumption 
that we have good hashing function that allows insertion and retrieval operations in O(1) time.
 In the above C++ implementation, map of STL is used. map in STL is typically implemented 
 using a Self-Balancing Binary Search Tree where all operations take O(Logn) time. 
 Therefore time complexity of the above implementation is O(nLogn).*/



/*
Print a Binary Tree in Vertical Order | Set 2 (Map based Method)

Given a binary tree, print it vertically. The following example illustrates the 
vertical order traversal.

           1
        /    \ 
       2      3
      / \   /   \
     4   5  6   7
               /  \ 
              8   9 
               
              
The output of print this tree vertically will be:
4
2
1 5 6
3 8
7
9*/



// Print a Binary Tree in Vertical Order | Set 3 (Using Level Order Traversal)

/*import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Node {
	int key;
	Node left, right;
	// A utility function to create a new node
	Node newNode(int key){
		Node node = new Node();
		node.key = key;
		node.left = node.right = null;
		return node;
	}
}

class Qobj {
	int hd;
	Node node;
	Qobj(int hd, Node node) {
		this.hd = hd;
		this.node = node;
	}
}

public class PrintVerticalOrder {

	// The main function to print vertical oder of a
	// binary tree with given root
	static void printVerticalOrder(Node root) {
		// Base case
		if (root == null)
			return;
		// Create a map and store vertical oder in
		// map using function getVerticalOrder()
		TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<>();
		int hd = 0;

		// Create queue to do level order traversal.
		// Every item of queue contains node and
		// horizontal distance.
		Queue<Qobj> que = new LinkedList<Qobj>();
		que.add(new Qobj(0, root));

		while (!que.isEmpty()) {
			// pop from queue front
			Qobj temp = que.poll();
			hd = temp.hd;
			Node node = temp.node;

			// insert this node's data in array of hash
			if (m.containsKey(hd)) {
				m.get(hd).add(node.key);
			} else {
				ArrayList<Integer> al = new ArrayList<>();
				al.add(node.key);
				m.put(hd, al);
			}
			if (node.left != null)
				que.add(new Qobj(hd-1, node.left));
			if (node.right != null)
				que.add(new Qobj(hd + 1, node.right));
		}

		// Traverse the map and print nodes at
		// every horizontal distance (hd)
		for (Map.Entry<Integer, ArrayList<Integer> > entry : m.entrySet()) {
			ArrayList<Integer> al = entry.getValue();
			for (Integer i : al)
				System.out.print(i + " ");
			System.out.println();
		}
	}

	// Driver program to test above functions
	public static void main(String ar[])
	{
		Node n = new Node();
		Node root;

		root = n.newNode(1);
		root.left = n.newNode(2);
		root.right = n.newNode(3);
		root.left.left = n.newNode(4);
		root.left.right = n.newNode(5);
		root.right.left = n.newNode(6);
		root.right.right = n.newNode(7);
		root.right.left.right = n.newNode(8);
		root.right.right.right = n.newNode(9);
		root.right.right.left = n.newNode(10);
		root.right.right.left.right = n.newNode(11);
		root.right.right.left.right.right = n.newNode(12);

		System.out.println("Vertical order traversal is ");
		printVerticalOrder(root);
	}
}*/

/*
Print a Binary Tree in Vertical Order | Set 3 (Using Level Order Traversal)

Given a binary tree, print it vertically. The following example illustrates vertical order traversal. 

       
           1
         /   \
       2       3
     /  \     /  \
   4     5   6    7
              \    \
               8    9            
              
The output of print this tree vertically will be:
4
2
1 5 6
3 8
7
9

Algorithm:
1. To maintain a hash for the branch of each node.
2. Traverse the tree in level order fashion.
3. In level order traversal, maintain a queue
   which holds, node and its vertical branch.
    * pop from queue.
    * add this node's data in vector corresponding
      to its branch in the hash.
    * if this node hash left child, insert in the 
      queue, left with branch - 1.
    * if this node hash right child, insert in the 
      queue, right with branch + 1.



*/


/* Time Complexity of the above implementation is O(n Log n). Note that the above implementation uses
  a map which is implemented using self-balancing BST.
We can reduce the time complexity to O(n) using unordered_map. To print nodes in the desired 
order, we can have 2 variables denoting min and max horizontal distance. We can simply iterate
 from min to max horizontal distance and get corresponding values from Map. So it is O(n)
Auxiliary Space: O(n) */