//Print Nodes in Top View of Binary Tree

import java.util.*; 

class PrintTopView { 
	
	// Structure of binary tree 
	static class Node { 
		Node left; 
		Node right; 
		int data; 
	} 

	static Node newNode(int key) { 
		Node node = new Node(); 
		node.left = node.right = null; 
		node.data = key; 
		return node; 
	} 

    // function should print the topView of  the binary tree 
    static void TopView(Node root) { 

        class QueueObj { 
            Node node; 
            int hd; // horizontal distance
            QueueObj(Node node, int hd) { 
                this.node = node; 
                this.hd = hd; 
            } 
        }

        Queue<QueueObj> q = new LinkedList<QueueObj>(); 
        Map<Integer, Node> topViewMap = new TreeMap<Integer, Node>(); 
  
        if (root == null) { 
            return; 
        } else { 
            q.add(new QueueObj(root, 0)); 
        } 
  
        System.out.println("The top view of the tree is(Iterative) : "); 

        while (!q.isEmpty()) { 
            
            QueueObj tmpNode = q.poll(); 
            
            if (!topViewMap.containsKey(tmpNode.hd)) { 
                topViewMap.put(tmpNode.hd, tmpNode.node); 
            } 
  
            if (tmpNode.node.left != null) { 
                q.add(new QueueObj(tmpNode.node.left, tmpNode.hd-1)); 
            } 
            if (tmpNode.node.right != null) { 
                q.add(new QueueObj(tmpNode.node.right, tmpNode.hd+1)); 
            } 
  
        } 

        for (Map.Entry<Integer, Node> entry : topViewMap.entrySet()) { 
            System.out.print(entry.getValue().data+" "); 
        } 
    }



	static class pair { 
		int first, second; 
		pair(){} 
		pair(int i, int j) { 
			first = i; 
			second = j; 
		} 
	} 
	static TreeMap<Integer, pair> m = new TreeMap<>(); 
	// function to fill the map 
	static void fillMap(Node root, int distance, int level) { 

		if(root == null) 
			return; 

		if(m.get(distance) == null) { 
			m.put(distance, new pair(root.data, level)); 
		} else if(m.get(distance).second>level) { 
			m.put(distance, new pair(root.data, level)); 
		} 

		fillMap(root.left, distance-1, level+1); 
		fillMap(root.right, distance+1, level+1); 
	} 

	// function should print the topView of the binary tree 
	static void topView(Node root) { 
		fillMap(root, 0, 0); 
		for (Map.Entry<Integer, pair> entry : m.entrySet()) { 
			System.out.print(entry.getValue().first + " "); 
		} 
	} 

	// Driver Code 
	public static void main(String args[]) { 

		Node root = newNode(1); 
		root.left = newNode(2); 
		root.right = newNode(3); 
		root.left.right = newNode(4); 
		root.left.right.right = newNode(5); 
		root.left.right.right.right = newNode(6); 

		/*		1
		      /   \
		    2       3
		      \   
		        4  
		          \
		            5
		             \
		               6
		*/

		System.out.println("\n\nFollowing are nodes in top view of Binary Tree"); 
		topView(root); 
		
		System.out.println("\n\n"); 
		TopView(root); 
		System.out.println(); 
	} 
} 

/*Print Nodes in Top View of Binary Tree

Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. 
Given a binary tree, print the top view of it. The output nodes can be printed in any order.

A node x is there in output if x is the topmost node at its horizontal distance. 
Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1, 
and that of right child is horizontal distance of x plus 1.

       1
    /     \
   2       3
  /  \    / \
 4    5  6   7
Top view of the above binary tree is
4 2 1 3 7

        1
      /   \
    2       3
      \   
        4  
          \
            5
             \
               6
Top view of the above binary tree is
2 1 3 6*/