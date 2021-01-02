//print all conflicting appointments in a given set of appointments

class ConflictingAppointments {

	// Structure to represent an interval
	static class Interval {
		int low, high;
	}

	static class ITNode{
		// 'i' could also be a normal variable
		Interval i; 
		int max;
		ITNode left, right;
	}

	// A utility function to create a new node
	static Interval newInterval(int l, int h) {
		Interval temp = new Interval();
		temp.low = l;
		temp.high = h;
		return temp;
	}

	// A utility function to create a new node
	static ITNode newNode(Interval i) {
		ITNode temp = new ITNode();
		temp.i = i;
		temp.max = i.high;
		temp.left = temp.right = null;
		return temp;
	}

	static ITNode insert(ITNode root, Interval i) {
		// Base case: Tree is empty, new node becomes root
		if (root == null)
			return newNode(i);
		// Get low value of interval at root
		int l = root.i.low;
		// If root's low value is smaller, then new interval goes to left subtree
		if (i.low < l)
			root.left = insert(root.left, i);
		// Else, new node goes to right subtree.
		else
			root.right = insert(root.right, i);
		// Update the max value of this ancestor if needed
		if (root.max < i.high)
			root.max = i.high;

		return root;
	}

	// A utility function to check if given two intervals overlap
	static boolean doOVerlap(Interval i1, Interval i2){
		if (i1.low < i2.high && i2.low < i1.high)
			return true;
		return false;
	}

	// The main function that searches a given 
	// interval i in a given Interval Tree.
	static Interval overlapSearch(ITNode root, Interval i) {
		// Base Case, tree is empty
		if (root == null)
			return null;
		// If given interval overlaps with root
		if (doOVerlap(root.i, i))
			return root.i;

		if (root.left != null && root.left.max >= i.low)
			return overlapSearch(root.left, i);
		// Else interval can only overlap with right subtree
		return overlapSearch(root.right, i);
	}

	// This function prints all conflicting
	// appointments in a given array of apointments.
	static void printConflicting(Interval appt[], int n) {
		// Create an empty Interval Search Tree, add first appointment
		ITNode root = null;
		root = insert(root, appt[0]);
		// Process rest of the intervals
		for(int i = 1; i < n; i++){
			Interval res = overlapSearch(root, appt[i]);
			if (res != null)
				System.out.print("[" + appt[i].low + "," + appt[i].high + 
								"] Conflicts with [" + res.low + "," + res.high + "]\n");
			// Insert this appointment
			root = insert(root, appt[i]);
		}
	}

	// Driver code
	public static void main(String[] args)
	{
		Interval appt[] = new Interval[6];
		appt[0] = newInterval(1, 5);
		appt[1] = newInterval(3, 7);
		appt[2] = newInterval(2, 6);
		appt[3] = newInterval(10, 15);
		appt[4] = newInterval(5, 6);
		appt[5] = newInterval(4, 100);
		
		int n = appt.length;
		System.out.print("Following are conflicting intervals\n");
			
		printConflicting(appt, n);
	}
}


/*
Given n appointments, find all conflicting appointments


Given n appointments, find all conflicting appointments. 

Examples:

Input: appointments[] = { {1, 5} {3, 7}, {2, 6}, {10, 15}, {5, 6}, {4, 100}}
Output: Following are conflicting intervals
[3,7] Conflicts with [1,5]
[2,6] Conflicts with [1,5]
[5,6] Conflicts with [3,7]
[4,100] Conflicts with [1,5]

*/