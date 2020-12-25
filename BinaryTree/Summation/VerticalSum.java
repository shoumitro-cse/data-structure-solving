import java.util.TreeMap; 

// javac -d classes VerticalSum.java  && cd classes && java VerticalSum && cd ..

class TreeNode { 

	// data members 
	private int key; 
	private TreeNode left; 
	private TreeNode right; 

	// Accessor methods 
	public int key()	 { return key; } 
	public TreeNode left() { return left; } 
	public TreeNode right() { return right; } 

	// Constructor 
	public TreeNode(int key) 
{ this.key = key; left = null; right = null; } 

	// Methods to set left and right subtrees 
	public void setLeft(TreeNode left) { this.left = left; } 
	public void setRight(TreeNode right) { this.right = right; } 
} 

// Class for a Binary Tree 
class Tree { 

	private TreeNode root; 

	// Constructors 
	public Tree() { root = null; } 
	public Tree(TreeNode n) { root = n; } 

	// Method to be called by the consumer classes 
	// like Main class 
	public void VerticalSumMain() { 
		VerticalSum(root); 
	} 

	// A wrapper over VerticalSumUtil() 
	private void VerticalSum(TreeNode root) { 
		// base case 
		if (root == null) { return; } 
		// Creates an empty TreeMap hM 
		TreeMap<Integer, Integer> hM = new TreeMap<Integer, Integer>(); 
		// Calls the VerticalSumUtil() to store the 
		// vertical sum values in hM 
		VerticalSumUtil(root, 0, hM); 
		// Prints the values stored by VerticalSumUtil() 
		if (hM != null) { 
			System.out.println(hM.entrySet()); 
		} 
	} 

	// Traverses the tree in in-order form and builds 
	// a hashMap hM that contains the vertical sum 
	private void VerticalSumUtil(TreeNode root, int hD, TreeMap<Integer, Integer> hM) { 
		// base case 
		if (root == null) { 
			return; 
		} 
		// Store the values in hM for left subtree 
		VerticalSumUtil(root.left(), hD-1, hM); 
		// Update vertical sum for hD of this node 
		int prevSum = (hM.get(hD) == null) ? 0 : hM.get(hD); 
		hM.put(hD, prevSum + root.key()); 
		// Store the values in hM for right subtree 
		VerticalSumUtil(root.right(), hD + 1, hM); 
	} 
} 

// Driver class to test the verticalSum methods 
public class VerticalSum { 

	public static void main(String[] args) { 

		TreeNode root = new TreeNode(1); 
		root.setLeft(new TreeNode(2)); 
		root.setRight(new TreeNode(3)); 
		root.left().setLeft(new TreeNode(4)); 
		root.left().setRight(new TreeNode(5)); 
		root.right().setLeft(new TreeNode(6)); 
		root.right().setRight(new TreeNode(7)); 

		/*	  1
		    /   \
		  2      3
		 / \    / \
		4   5  6   7*/


		Tree t = new Tree(root); 

		System.out.println("Following are the values of\n" + 
						" vertical sums with the positions\n" + 
						" of the columns with respect to root "); 
		t.VerticalSumMain(); 
	} 
} 


/*Vertical Sum in a given Binary Tree | Set 1

Given a Binary Tree, find the vertical sum of the nodes that are in the same vertical line. 
Print all sums through different vertical lines.
Examples:

      1
    /   \
  2      3
 / \    / \
4   5  6   7
The tree has 5 vertical lines

Vertical-Line-1 has only one node 4 => vertical sum is 4
Vertical-Line-2: has only one node 2=> vertical sum is 2
Vertical-Line-3: has three nodes: 1,5,6 => vertical sum is 1+5+6 = 12
Vertical-Line-4: has only one node 3 => vertical sum is 3
Vertical-Line-5: has only one node 7 => vertical sum is 7

So expected output is 4, 2, 12, 3 and 7*/
