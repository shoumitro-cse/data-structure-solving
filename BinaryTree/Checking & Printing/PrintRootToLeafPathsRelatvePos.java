// Print all root to leaf paths with there relative positions

//javac -d classes PrintRootToLeafPathsRelatvePos.java  && cd classes && java PrintRootToLeafPathsRelatvePos && cd ..  

import java.util.ArrayList;

class PrintRootToLeafPathsRelatvePos {
	
	static final int MAX_PATH_SIZE = 1000;

	// tree structure
	static class Node {
		char data;
		Node left, right;
	};

	// Function create new node
	static Node newNode(char data) {
		Node temp = new Node();
		temp.data = data;
		temp.left = temp.right = null;
		return temp;
	}

	// Store path information
	static class PATH {
		// Horigontal distance of node from root.
		int Hd; 
		// Store key
		char key;
		public PATH(int Hd, char key) {
			this.Hd = Hd;
			this.key = key;
		}
		public PATH() {}
	};

	// Prints given root to leaf path with underscores
	static void printPath(ArrayList<PATH> path, int size) {
		// Find the minimum horizontal distance value in current root to leaf path
		int minimum_Hd = Integer.MAX_VALUE;
		PATH p;
		// Find minimum horizontal distance
		for(int it = 0; it < size; it++) {
			p = path.get(it);
			minimum_Hd = Math.min(minimum_Hd, p.Hd);
		}
		// Print the root to leaf path with "_" that indicate the related position
		for(int it = 0; it < size; it++) {
			// Current tree node
			p = path.get(it);
			int noOfUnderScores = Math.abs(p.Hd - minimum_Hd);
			// Print underscore
			for(int i = 0; i < noOfUnderScores; i++)
				System.out.print("_");
			// Print current key
			System.out.println(p.key);
		}
		System.out.println("==============================");
	}


	static void printAllPathsUtil(Node root, ArrayList<PATH> allPath, int HD, int order) {
		// Base case
		if (root == null)
			return;
		// Leaf node
		if (root.left == null && root.right == null) {
			// Add leaf node and then print path
			allPath.set(order, new PATH(HD, root.data));
			// AllPath[order] = (PATH { HD, root.data });
			printPath(allPath, order+1);
			return;
		}
		// Store current path information
		allPath.set(order, new PATH(HD, root.data));
		// AllPath[order] = (PATH { HD, root.data }); //Call left sub_tree
		printAllPathsUtil(root.left, allPath, HD-1, order+1);
		// Call left sub_tree
		printAllPathsUtil(root.right, allPath, HD+1, order+1);
	}

	static void printAllPaths(Node root){
		// Base case
		if (root == null)
			return;
		ArrayList<PATH> allPaths = new ArrayList<>();
		for(int i = 0; i < MAX_PATH_SIZE; i++) {
			allPaths.add(new PATH());
		}
		printAllPathsUtil(root, allPaths, 0, 0);
	}

	public static void main(String[] args) {

		Node root = newNode('A');

		root.left = newNode('B');
		root.right = newNode('C');
		
		root.left.left = newNode('D');
		root.left.right = newNode('E');
		
		root.right.left = newNode('F');
		root.right.right = newNode('G');
		
		/*		 A 
		       /   \  
		      B      C 
		     / \    / \
		    D   E   F  G*/

		printAllPaths(root);
	}
}


/*
Asked In: Google Interview 

Print all root to leaf paths with there relative positions

Given a binary tree, print the root to the leaf path, but add “_” to indicate 
the relative position. 

Example: 

Input : Root of below tree
         A 
       /   \  
      B      C 
     / \    / \
    D   E   F  G

Output : All root to leaf paths
_ _ A
_ B
D

_ A
B
_ E

 A
 _ C
 F

A
_ C
_ _ G

*/



/*Print_Path_with_underscore function 

print_path

……a) First find the minimum Horizontal distance of the current path. 
……b) After that we traverse current path 
……….First Print number of underscore “_” : abs (current_node_HD – minimum-HD) 
……….Print current node value. */