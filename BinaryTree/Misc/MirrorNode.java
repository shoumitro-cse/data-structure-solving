// Find mirror of a given node in Binary tree

//javac -d classes MirrorNode.java  && cd classes && java MirrorNode && cd ..

class MirrorNode { 

	/* A binary tree Node has data, pointer to left child 
	and a pointer to right child */
	static class Node 
	{ 
		int key; 
		Node left, right; 
	} 

	// create new Node and initialize it 
	static Node newNode(int key) 
	{ 
		Node n = new Node(); 
		
			n.key = key; 
			n.left = null; 
			n.right = null; 
			return n; 
	} 

	// recursive function to find mirror of Node 
	static int findMirrorRec(int target, Node left, Node right) 
	{ 
		if (left==null || right==null) 
			return 0; 

		if (left.key == target) 
			return right.key; 
		if (right.key == target) 
			return left.key; 
		// first recur external Nodes 
		int mirror_val = findMirrorRec(target, left.left, right.right); 
		if (mirror_val != 0) 
			return mirror_val; 
		// if no mirror found, recur internal Nodes 
		return findMirrorRec(target, left.right, right.left); 
	} 

	// interface for mirror search 
	static int findMirror(Node root, int target) 
	{ 
		if (root == null) 
			return 0; 
		if (root.key == target) 
			return target; 
		return findMirrorRec(target, root.left, root.right); 
	} 

	// Driver 
	public static void main(String[] args) 
	{ 
		Node root = newNode(1); 
		root.left = newNode(2); 
		root.left.left = newNode(4); 
		root.left.left.right = newNode(7); 
		root.right = newNode(3); 
		root.right.left = newNode(5); 
		root.right.right = newNode(6); 
		root.right.left.left = newNode(8); 
		root.right.left.right = newNode(9); 

		// target Node whose mirror have to be searched 
		int target = 4; 

		int mirror = findMirror(root, target); 

		if (mirror != 0) 
			System.out.println("Mirror of Node " + target + " is Node " + mirror); 
		else
			System.out.println("Mirror of Node " + target + " is null "); 
	} 
} 
