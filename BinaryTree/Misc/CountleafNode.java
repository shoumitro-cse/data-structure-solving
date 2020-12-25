// Java implementation to find leaf count of a given Binary tree 

/* Class containing left and right child of current 
node and key value*/
class Node 
{ 
	int data; 
	Node left, right; 

	public Node(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

public class BinaryTree 
{ 
	//Root of the Binary Tree 
	Node root; 

	/* Computes the number of non-leaf nodes in a t
	ree. */
	int countNonleaf(struct Node* root) 
	{ 
	    // Base cases. 
	    if (root == null || (root.left == null &&  root.right == null)) 
	        return 0; 
	    // If root is Not NULL and its one of its child is also not NULL 
	    return 1 + countNonleaf(root.left) +  countNonleaf(root.right); 
	} 


/*    static int getLeafCount(Node node)
    {
        // If tree is empty
        if (node == null)
        {
            return 0;
        }
 
        // Initialize empty queue.
        Queue<Node> q = new LinkedList<>();
 
        // Do level order traversal starting from root
        int count = 0; // Initialize count of leaves
        q.add(node);
        while (!q.isEmpty()) 
        {
            Node temp = q.peek();
            q.poll();
 
            if (temp.left != null) 
            {
                q.add(temp.left);
            }
            if (temp.right != null)
            {
                q.add(temp.right);
            }
            if (temp.left == null && 
                temp.right == null) 
            {
                count++;
            }
        }
        return count;
    }
*/
	
	/* Function to get the count of leaf nodes in a binary tree*/
	int getLeafCount() 
	{ 
		return getLeafCount(root); 
	} 

	int getLeafCount(Node node) 
	{ 
		if (node == null) 
			return 0; 
		if (node.left == null && node.right == null) 
			return 1; 
		else
			return getLeafCount(node.left) + getLeafCount(node.right); 
	} 

	/* Driver program to test above functions */
	public static void main(String args[]) 
	{ 
		/* create a tree */
		BinaryTree tree = new BinaryTree(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		
		/* get leaf count of the abve tree */
		System.out.println("The leaf count of binary tree is : "+ tree.getLeafCount()); 
		System.out.println("The Non-leaf count of binary tree is : "+ tree.countNonleaf()); 
	} 
} 

