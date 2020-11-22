// javac BinaryTree.java && java BinaryTree
public class BinaryTree {

	Node root; // head of list 

	/* Linked list Node*/
	class Node { 
		int data; 
		Node left, right; 
		Node(int d) { 
			data = d; 
			left = null; 
			right = null;
		} 
	}

	public Node addLeftTreeNode(Node node ,int new_data) {
        Node new_node = new Node(new_data);
        node.left = new_node;
        return new_node;
	} 

	public Node addRightTreeNode(Node node, int new_data) {
        Node new_node = new Node(new_data);
        node.right = new_node;
        return new_node;
	}

	public  Node addRootTreeNode(int new_data) {
        root = new Node(new_data);
        return root;
	} 

	public static void preOrder(Node node) {
       
       System.out.print(node.data+" ");

       if(node.left != null)
       	 preOrder(node.left);

       if(node.right != null)
       	 preOrder(node.right);
	}

	public static void postOrder(Node node) {
       
       if(node.left != null)
       	 postOrder(node.left);

       if(node.right != null)
       	 postOrder(node.right);

       System.out.print(node.data+" ");
	}

	public static void inOrder(Node node) {
       
       if(node.left != null)
       	 inOrder(node.left);

       System.out.print(node.data+" ");

       if(node.right != null)
       	 inOrder(node.right);
	}


	public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

		    Node root_node = tree.addRootTreeNode(2);

        Node seven = tree.addLeftTreeNode(root_node, 7);
        Node nine = tree.addRightTreeNode(root_node, 9);   

        Node one = tree.addLeftTreeNode(seven, 1);
        Node six = tree.addRightTreeNode(seven, 6);

        Node eight = tree.addRightTreeNode(nine, 8);

        Node five = tree.addLeftTreeNode(six, 5);
        Node ten = tree.addRightTreeNode(six, 10);

        Node three = tree.addLeftTreeNode(eight, 3);
        Node four = tree.addRightTreeNode(eight, 4);


        System.out.print("Pre Order : ");
        preOrder(root_node);
        System.out.println();

        System.out.print("IN Order : ");
        inOrder(root_node);
        System.out.println();

        System.out.print("Post Order : ");
        postOrder(root_node);
        System.out.println();


        // System.out.println(root_node.data);	

        // System.out.print(root_node.left.data+" ");		
        // System.out.print(root_node.right.data);

        // System.out.println();	

        // System.out.print(seven.left.data+" ");		
        // System.out.print(seven.right.data);	

        // System.out.println();	

        // System.out.print(nine.right.data+" ");		
        // System.out.println();	 

        // System.out.print(six.left.data+" ");		
        // System.out.print(six.right.data);	

        // System.out.println();	 

        // System.out.print(eight.left.data+" ");		
        // System.out.print(eight.right.data);	

        // System.out.println();		
		
	}
}