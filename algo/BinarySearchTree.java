// javac BinarySearchTree.java && java BinarySearchTree


// Java program to demonstrate insert operation in binary search tree
class BinarySearchTree {

    /* Class containing left and right child of current node and key value*/
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    BinarySearchTree() { 
        root = null; 
    }

    // This method mainly calls insertRec()
    void insert(int key) {
        root = insertRec(root, key);
    }
    
    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int key) {

        /* If the tree is empty, return a new node */
        if (root == null) { // for base case
            // System.out.println("base case check");
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        // System.out.println(root.key); // root node data
        return root;
    }


    void insert2(int key) {
        root = insert2Rec(root, key);
    }

    /* A loop function to insert a new key in BST */
    public Node insert2Rec(Node root, int item) {
       Node parent_node, current_node;

       if (root == null) {
            root = new Node(item);
            return root;
        } 

        parent_node = null;
        current_node = root;

        while(current_node != null) {
            parent_node = current_node;
            if (item < current_node.key) {
                current_node = current_node.left;
            } else {
                current_node = current_node.right;
            }
        }

        if (item < parent_node.key) {
            parent_node.left = new Node(item);
        } else {
            parent_node.right = new Node(item);
        }

        return root;
    }

    // This method mainly calls deleteRec() 
    void deleteKey(int key) 
    { 
        root = deleteRec(root, key); 
        // System.out.println("\n\nroot : "+root.key+"\n\n");
    } 
  
    /* A recursive function to insert a new key in BST */
    Node deleteRec(Node root, int key) 
    { 
        /* Base Case: If the tree is empty */
        if (root == null)  return root; 
  
        /* Otherwise, recur down the tree */
        if (key < root.key) 
            root.left = deleteRec(root.left, key); 
        else if (key > root.key) 
            root.right = deleteRec(root.right, key); 
  
        // if key is same as root's key, then This is the node to be deleted 
        else
        { 
            // delete node with only one child or no child 
            // if (root.left == null) 
            //     return root.right; //null or right branch
            // else if (root.right == null) 
            //     return root.left; //null or left branch

            // delete node with only one child or no child 
            if (root.left == null) {
                // System.out.println("one child or no child  root data : "+root.key);
                // System.out.println("one child or no child  root left data : "+(root.left==null));
                // System.out.println("one child or no child  root right data : "+(root.right==null));
                return root.right; // null or right branch
            }    
            else if (root.right == null) {
                // System.out.println("one child or no child  root left data : "+(root.left==null));
                // System.out.println("one child or no child  root right data : "+(root.right==null));
                return root.left; // null or left branch
            }
  
            // node with two children: Get the inorder successor (smallest 
            // in the right subtree) 
            root.key = minValue(root.right); 
  
            // Delete the inorder successor 
            root.right = deleteRec(root.right, root.key); // delete root.key item

            // System.out.println("root data : "+root.key);
            // System.out.println("root left data : "+root.left.key);
            // System.out.println("root right data : "+root.right.key);
        } 
        return root; 
    } 
  
    int minValue(Node root) 
    { 
        // System.out.println("min calling....");
        int minv = root.key; 
        while (root.left != null) 
        { 
            minv = root.left.key; 
            root = root.left; 
        } 
        return minv; 
    } 

    // This method mainly calls InorderRec()
    void inorder() {
       inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key+" ");
            inorderRec(root.right);
        }
    }

    // Driver Program to test above functions
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create following BST
              50
             /  \
            30   70
            / \ / \
          20 40 60 80 */

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);

        tree.insert2(60);
        tree.insert2(80);

        System.out.println("Inorder traversal of the given tree"); 
        tree.inorder(); 
  
        // System.out.println("\nDelete 20"); 
        // tree.deleteKey(20); 
        // System.out.println("Inorder traversal of the modified tree"); 
        // tree.inorder(); 
  
        System.out.println("\nDelete 30"); 
        tree.deleteKey(30); 
        System.out.println("Inorder traversal of the modified tree"); 
        tree.inorder(); 
  
        System.out.println("\nDelete 50"); 
        tree.deleteKey(50); 
        System.out.println("Inorder traversal of the modified tree"); 
        tree.inorder(); 

        System.out.println();
    }
}
// This code is contributed by Ankur Narain Verma
