// Get Level of a node in a Binary Tree 
import java.io.*; 
import java.util.*; 
class Node 
{ 
	int data; 
	Node left, right; 

	public Node(int d) 
	{ 
		data = d; 
		left = right = null; 
	} 
} 

class GetLevel 
{ 

	Node root; 

/*    // utility function to return level of given node 
    static int getLevel(node root, int data) 
    { 
        Queue<node> q = new LinkedList<>(); 
        int level = 1; 
        q.add(root); 
  
        // extra NULL is pushed to keep track 
        // of all the nodes to be pushed before 
        // level is incremented by 1 
        q.add(null); 
        while (!q.isEmpty()) 
        { 
            node temp = q.poll(); 
            if (temp == null) 
            { 
                if (q.peek() != null)  
                { 
                    q.add(null); 
                } 
                level += 1; 
            }  
            else
            { 
                if (temp.data == data)  
                { 
                    return level; 
                } 
                if (temp.left != null)  
                { 
                    q.add(temp.left); 
                } 
                if (temp.right != null)  
                { 
                    q.add(temp.right); 
                } 
            } 
        } 
        return 0; 
    } */
  
  
	int getLevelUtil(Node node, int data, int level) 
	{ 
		if (node == null) 
			return 0; 

		if (node.data == data) 
			return level; 

		int downlevel = getLevelUtil(node.left, data, level + 1); 
		if (downlevel != 0) 
			return downlevel; 

		downlevel = getLevelUtil(node.right, data, level + 1); 
		return downlevel; 
	} 

	/* Returns level of given data value */
	int getLevel(Node node, int data) 
	{ 
		return getLevelUtil(node, data, 1); 
	} 

	/* Driver function to test above functions */
	public static void main(String[] args) 
	{ 
		GetLevel tree = new GetLevel(); 

		/* Constructing tree given in the above figure */
		tree.root = new Node(3); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(5); 
		tree.root.left.left = new Node(1); 
		tree.root.left.right = new Node(4); 
		for (int x = 1; x <= 5; x++) 
		{ 
			int level = tree.getLevel(tree.root, x); 
			if (level != 0) 
				System.out.println("Level of " + x + " is "+ tree.getLevel(tree.root, x)); 
			else
				System.out.println(x + " is not present in tree"); 
		} 
	} 
} 

