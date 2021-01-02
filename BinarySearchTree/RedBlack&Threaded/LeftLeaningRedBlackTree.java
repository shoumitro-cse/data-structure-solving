// insert operation in Red Black Tree. 

//javac -d classes LeftLeaningRedBlackTree.java  && cd classes && java LeftLeaningRedBlackTree && cd ..

class Node {

	Node left, right; 
	int data; 
	// red ==> true, black ==> false 
	boolean color; 
	Node(int data) { 
		this.data = data; 
		left = null; 
		right = null; 
		// New Node which is created is always red in color. 
		color = true; 
	} 
} 

public class LeftLeaningRedBlackTree { 

	private static Node root = null; 
	
	// utility function to rotate Node anticlockwise. 
	Node rotateLeft(Node root_ref) { 
		System.out.printf("left rotation!!\n"); 
		Node child = root_ref.right; 
		Node childLeft = child.left; 

		child.left = root_ref; 
		root_ref.right = childLeft; 

		return child; 
	} 

	// utility function to rotate Node clockwise. 
	Node rotateRight(Node root_ref) { 
		System.out.printf("right rotation\n"); 
		Node child = root_ref.left; 
		Node childRight = child.right; 

		child.right = root_ref; 
		root_ref.left = childRight; 

		return child; 
	} 

	// utility function to check whether Node is red in color or not. 
	boolean isRed(Node root_ref) { 
		if (root_ref == null) 
			return false; 
		return (root_ref.color == true); 
	} 

	// utility function to swap color of two 
	// Nodes. 
	void swapColors(Node Node1, Node Node2) { 
		boolean temp = Node1.color; 
		Node1.color = Node2.color; 
		Node2.color = temp; 
	} 

	// insertion into Left Leaning Red Black Tree. 
	Node insert(Node root_ref, int data) 
	{ 
		// Normal insertion code for any Binary 
		// Search tree. 
		if (root_ref == null) 
			return new Node(data); 

		if (data < root_ref.data) 
			root_ref.left = insert(root_ref.left, data); 
		
		else if (data > root_ref.data) 
			root_ref.right = insert(root_ref.right, data); 
		
		else
			return root_ref; 
		
		// case 1. 
		// when right child is Red but left child is Black or doesn't exist. 
		if (isRed(root_ref.right) && !isRed(root_ref.left)) { 
			// left rotate the Node to make it into valid structure. 
			root_ref = rotateLeft(root_ref); 
			// swap the colors as the child Node should always be red 
			swapColors(root_ref, root_ref.left); 

		} 

		// case 2 
		// when left child as well as left grand child in Red 
		if (isRed(root_ref.left) && isRed(root_ref.left.left)) { 
			// right rotate the current Node to make it into a valid structure. 
			root_ref = rotateRight(root_ref); 
			swapColors(root_ref, root_ref.right); 
		} 

		// case 3 
		// when both left and right child are Red in color. 
		if (isRed(root_ref.left) && isRed(root_ref.right)) { 
			// invert the color of Node as well it's left and right child. 
			root_ref.color = !root_ref.color; 
			// change the color to black. 
			root_ref.left.color = false; 
			root_ref.right.color = false; 
		} 

		return root_ref; 
	} 


	// Inorder traversal 
	void inorder(Node Node) 
	{ 
		if (Node != null) 
		{ 
			inorder(Node.left); 
			System.out.print(Node.data + " "); 
			inorder(Node.right); 
		} 
	} 

	public static void main(String[] args) { 
		/* LLRB tree made after all insertions are made. 
				
		1. Nodes which have double INCOMING edge means 
			that they are RED in color. 
		2. Nodes which have single INCOMING edge means 
			that they are BLACK in color. 
		
	        root
	         |
	         40
	       //  \
	      20    50
	     /  \
	   10    30
	        //
	       25 */
		
		LeftLeaningRedBlackTree Node = new LeftLeaningRedBlackTree(); 
		
		root = Node.insert(root, 10); 
		// to make sure that root remains 
		// black is color 
		root.color = false; 
		
		root = Node.insert(root, 20); 
		root.color = false; 
		
		root = Node.insert(root, 30); 
		root.color = false; 
		
		root = Node.insert(root, 40); 
		root.color = false; 
		
		root = Node.insert(root, 50); 
		root.color = false; 
		
		root = Node.insert(root, 25); 
		root.color = false; 

		// display the tree through inorder traversal. 
		Node.inorder(root); 
		System.out.println();

	} 
	
} 



/*
Left Leaning Red Black Tree (Insertion)


A left leaning Red Black Tree or (LLRB), is a variant of red black tree, which is a 
lot easier to implement than Red black tree itself and guarantees all the search, 
delete and insert operations in O(logn) time.

Which nodes are RED and Which are Black ?
Nodes which have double incoming edge are RED in color.
Nodes which have single incoming edge are BLACK in color.

Characteristics of LLRB
1. Root node is Always BLACK in color.
2. Every new Node inserted is always RED in color.
3. Every NULL child of a node is considered as BLACK in color.
Eg : only 40 is present in tree.

 
     root
       |
       40 <-- as 40 is the root so it 
      /  \    is also Black in color. 
    NULL  NULL <-- Black in color.
4. There should not be a node which has RIGHT RED child and LEFT BLACK child(or NULL child as all NULLS are BLACK), if present Left rotate the node, and swap the colors of current node and its LEFT child so as to maintain consistency for rule 2 i.e., new node must be RED in color.




 CASE 1.
   root                        root     
     |                          ||      
     40      LeftRotate(40)     50     
    /  \\        --->          /  \    
  NULL  50                   40   NULL    

                               root              
                                |               
         ColorSwap(50, 40)      50 
           --->               //  \              
                             40  NULL                     
5. There should not be a node which has LEFT RED child and LEFT RED grandchild, if present Right Rotate the node and swap the colors between node and it’s RIGHT child to follow rule 2.

  CASE 2.
   root                         root      
    |                            ||        
    40        RightRotate(40)    20        
   //  \         --->          //   \      
  20    50                    10    40           
 //                                   \      
10                                     50

                          root
                           |
    ColorSwap(20, 40)      20
      --->                // \\
                         10   40
                               \
                               50
 
6. There should not be a node which has LEFT RED child and RIGHT RED child, if present Invert the colors of all nodes i. e., current_node, LEFT child, and RIGHT child.

   CASE 3.
   root                           root      
    |       !color(20, 10, 30)     ||       
    20            --->             20                
  //  \\                          /  \  
 10    30                        10  30 

                                     root
        As the root is always black    |                     
                --->                  20   
                                     /  \
                                   10   30   
Why are we following the above mentioned rules? Because by following above characteristics/rules we are able to simulate all the red-black tree’s properties without caring about the complex implementation of it.
Example:

Insert the following data into LEFT LEANING RED-BLACK
TREE and display the inorder traversal of tree.
Input : 10 20 30 40 50 25
Output : 10 20 30 40 50 25
        root
         |
         40
       //  \
      20    50
     /  \
   10    30
        //
       25 


*/